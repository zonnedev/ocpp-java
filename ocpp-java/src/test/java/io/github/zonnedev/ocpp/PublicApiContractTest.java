package io.github.zonnedev.ocpp;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.zonnedev.ocpp.api.OcppActionDefinition;
import io.github.zonnedev.ocpp.api.datatransfer.Ocpp16DataTransferOperation;
import io.github.zonnedev.ocpp.api.datatransfer.Ocpp201DataTransferOperation;
import io.github.zonnedev.ocpp.codec.OcppError;
import io.github.zonnedev.ocpp.codec.OcppErrorMessage;
import io.github.zonnedev.ocpp.codec.OcppRequestContext;
import io.github.zonnedev.ocpp.codec.OcppRequestMessage;
import io.github.zonnedev.ocpp.codec.OcppResponseMessage;
import io.github.zonnedev.ocpp.extension.v16.iso15118.Ocpp16Iso15118DataTransferModule;
import io.github.zonnedev.ocpp.v16.Ocpp16Action;
import io.github.zonnedev.ocpp.v201.Ocpp201Action;
import java.io.InputStream;
import java.lang.module.ModuleDescriptor;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.RecordComponent;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PublicApiContractTest {
  private static final Set<String> EXPORTED_PACKAGES = Set.of(
    "io.github.zonnedev.ocpp.api",
    "io.github.zonnedev.ocpp.api.datatransfer",
    "io.github.zonnedev.ocpp.codec",
    "io.github.zonnedev.ocpp.extension.v16.iso15118",
    "io.github.zonnedev.ocpp.jackson",
    "io.github.zonnedev.ocpp.v16",
    "io.github.zonnedev.ocpp.v16.model",
    "io.github.zonnedev.ocpp.v16.model.type",
    "io.github.zonnedev.ocpp.v201",
    "io.github.zonnedev.ocpp.v201.model",
    "io.github.zonnedev.ocpp.v201.model.type"
  );

  @Test
  @DisplayName("The Java module exports only the intended public API packages")
  void it_exports_only_the_intended_public_api_packages() throws Exception {
    ModuleDescriptor descriptor;
    Path classes = Path.of(
      OcppActionDefinition.class.getProtectionDomain()
        .getCodeSource()
        .getLocation()
        .toURI()
    );
    try (InputStream moduleInfo = Files.newInputStream(classes.resolve("module-info.class"))) {
      descriptor = ModuleDescriptor.read(moduleInfo);
    }

    assertThat(descriptor.name()).isEqualTo("io.github.zonnedev.ocpp");
    assertThat(
      descriptor.exports()
        .stream()
        .map(export -> export.source())
    ).containsExactlyInAnyOrderElementsOf(EXPORTED_PACKAGES);
    assertThat(EXPORTED_PACKAGES).doesNotContain("io.github.zonnedev.ocpp.codec.internal");
  }

  @Test
  @DisplayName("Every reachable public record follows the stable model construction contract")
  void it_enforces_the_public_record_construction_contract() {
    Set<Class<?>> records = reachablePublicRecords();

    assertThat(records).isNotEmpty();
    for (Class<?> record : records) {
      assertThat(
        Arrays.stream(record.getMethods())
          .anyMatch(
            method -> method.getName()
              .equals("of")
              && Modifier.isPublic(method.getModifiers())
              && Modifier.isStatic(method.getModifiers())
              && method.getReturnType()
                .equals(record)
          )
      )
        .as("%s exposes a public static of(...) factory", record.getName())
        .isTrue();
      assertThat(
        Arrays.stream(record.getRecordComponents())
          .map(RecordComponent::getType)
      )
        .as("%s has no Optional or Object record components", record.getName())
        .noneMatch(type -> type == Optional.class || type == Object.class);
    }
  }

  private static Set<Class<?>> reachablePublicRecords() {
    ArrayDeque<Class<?>> pending = new ArrayDeque<>();
    Set<Class<?>> visited = new HashSet<>();
    Set<Class<?>> records = new HashSet<>();

    pending.addAll(
      Set.of(
        OcppActionDefinition.class,
        Ocpp16DataTransferOperation.class,
        Ocpp201DataTransferOperation.class,
        OcppError.class,
        OcppErrorMessage.class,
        OcppRequestContext.class,
        OcppRequestMessage.class,
        OcppResponseMessage.class,
        Ocpp16Iso15118DataTransferModule.class
      )
    );
    Arrays.stream(Ocpp16Action.values())
      .forEach(action -> {
        pending.add(action.requestType());
        pending.add(action.responseType());
      });
    Arrays.stream(Ocpp201Action.values())
      .forEach(action -> {
        pending.add(action.requestType());
        pending.add(action.responseType());
      });

    while (!pending.isEmpty()) {
      Class<?> type = pending.removeFirst();
      if (!visited.add(type) || !isProjectType(type)) {
        continue;
      }
      if (type.isRecord() && Modifier.isPublic(type.getModifiers())) {
        records.add(type);
        Arrays.stream(type.getRecordComponents())
          .map(RecordComponent::getGenericType)
          .forEach(
            component -> enqueueTypes(
              component,
              pending
            )
          );
      }
      Arrays.stream(type.getDeclaredClasses())
        .filter(nested -> Modifier.isPublic(nested.getModifiers()))
        .forEach(pending::add);
    }
    return Set.copyOf(records);
  }

  private static boolean isProjectType(Class<?> type) {
    return type.getPackageName()
      .startsWith("io.github.zonnedev.ocpp");
  }

  private static void enqueueTypes(
    Type type,
    ArrayDeque<Class<?>> pending
  ) {
    switch (type) {
      case Class<?> concrete -> pending.add(concrete);
      case ParameterizedType parameterized -> {
        enqueueTypes(
          parameterized.getRawType(),
          pending
        );
        Arrays.stream(parameterized.getActualTypeArguments())
          .forEach(
            argument -> enqueueTypes(
              argument,
              pending
            )
          );
      }
      case GenericArrayType array -> enqueueTypes(
        array.getGenericComponentType(),
        pending
      );
      case WildcardType wildcard -> {
        Arrays.stream(wildcard.getUpperBounds())
          .forEach(
            bound -> enqueueTypes(
              bound,
              pending
            )
          );
        Arrays.stream(wildcard.getLowerBounds())
          .forEach(
            bound -> enqueueTypes(
              bound,
              pending
            )
          );
      }
      default -> {
      }
    }
  }
}
