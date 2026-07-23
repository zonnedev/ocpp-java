package io.github.zonnedev.ocpp.codec;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import io.github.zonnedev.ocpp.api.OcppActionDefinition;
import io.github.zonnedev.ocpp.v16.Ocpp16Action;
import io.github.zonnedev.ocpp.v16.Ocpp16Actions;
import io.github.zonnedev.ocpp.v201.Ocpp201Action;
import io.github.zonnedev.ocpp.v201.Ocpp201Actions;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class OfficialSchemaConformanceTest {
  private static final ObjectMapper MAPPER = new ObjectMapper();

  private final OcppMessageCodec codec = JacksonOcppMessageCodec.createDefault();

  @ParameterizedTest(name = "{0}")
  @MethodSource("invalidPayloads")
  @DisplayName("Every schema-invalid official payload is rejected")
  void it_rejects_every_schema_constraint_violation(
    String description,
    OcppActionDefinition<?, ?> definition,
    boolean request,
    JsonNode payload
  ) {
    assertThatThrownBy(
      () -> decode(
        definition,
        request,
        payload
      )
    )
      .as(description)
      .isInstanceOf(OcppDecodingException.class);
    assertThatThrownBy(
      () -> decode(
        definition,
        request,
        payload.toString()
      )
    )
      .as(description + " through the String entry point")
      .isInstanceOf(OcppDecodingException.class);
  }

  private static Stream<Arguments> invalidPayloads() {
    return ordinaryActions().flatMap(
      action -> Stream.concat(
        invalidPayloads(
          action,
          true
        ),
        invalidPayloads(
          action,
          false
        )
      )
    );
  }

  private static Stream<Arguments> invalidPayloads(
    ActionCase action,
    boolean request
  ) {
    try {
      Class<?> payloadType = request
        ? action.definition()
          .requestType()
        : action.definition()
          .responseType();
      Path schemaPath = OfficialProtocolFixtureTest.SCHEMA_DIRECTORY.resolve(
        action.schemaDirectory()
      )
        .resolve(
          OfficialProtocolFixtureTest.schemaFileName(
            action.version(),
            payloadType
          )
        );
      JsonNode schema = MAPPER.readTree(schemaPath.toFile());
      JsonNode valid = OfficialProtocolFixtureTest.minimalValue(
        schema,
        schema
      );
      List<InvalidPayload> invalid = new ArrayList<>();
      collectViolations(
        schema,
        schema,
        valid,
        "",
        invalid
      );
      String direction = request ? "request" : "response";
      return invalid.stream()
        .map(
          violation -> Arguments.of(
            action.version() + " " + action.definition()
              .action()
              .wireName()
              + " "
              + direction
              + " "
              + violation.description(),
            action.definition(),
            request,
            violation.payload()
          )
        );
    } catch (IOException exception) {
      throw new IllegalStateException("Could not load official schema", exception);
    }
  }

  private static Stream<ActionCase> ordinaryActions() {
    return Stream.concat(
      Arrays.stream(Ocpp16Action.values())
        .filter(action -> action != Ocpp16Action.DATA_TRANSFER)
        .map(
          action -> new ActionCase(
            "OCPP 1.6",
            "v16",
            Ocpp16Actions.definitionFor(action)
          )
        ),
      Arrays.stream(Ocpp201Action.values())
        .filter(action -> action != Ocpp201Action.DATA_TRANSFER)
        .map(
          action -> new ActionCase(
            "OCPP 2.0.1",
            "v201",
            Ocpp201Actions.definitionFor(action)
          )
        )
    );
  }

  private static void collectViolations(
    JsonNode schema,
    JsonNode root,
    JsonNode valid,
    String path,
    List<InvalidPayload> invalid
  ) {
    JsonNode resolved = schema.has("$ref")
      ? OfficialProtocolFixtureTest.resolveReference(
        schema.get("$ref")
          .textValue(),
        root
      )
      : schema;
    String type = resolved.path("type")
      .asText();

    if (resolved.has("enum")) {
      addReplacement(
        valid,
        path,
        "rejects an unknown enum",
        MAPPER.getNodeFactory()
          .textNode("__unknown_enum__"),
        invalid
      );
    } else {
      addWrongScalarType(
        valid,
        path,
        type,
        invalid
      );
    }

    switch (type) {
      case "object" -> collectObjectViolations(
        resolved,
        root,
        valid,
        path,
        invalid
      );
      case "array" -> collectArrayViolations(
        resolved,
        root,
        valid,
        path,
        invalid
      );
      case "string" -> collectStringViolations(
        resolved,
        valid,
        path,
        invalid
      );
      case "integer", "number" -> collectNumberViolations(
        resolved,
        valid,
        path,
        invalid
      );
      default -> {
      }
    }
  }

  private static void collectObjectViolations(
    JsonNode schema,
    JsonNode root,
    JsonNode valid,
    String path,
    List<InvalidPayload> invalid
  ) {
    if (schema.path("additionalProperties")
      .isBoolean()
      && !schema.path("additionalProperties")
        .booleanValue()) {
      JsonNode mutated = valid.deepCopy();
      ((ObjectNode) mutated.at(path)).put(
        "__unknown_property__",
        true
      );
      invalid.add(
        new InvalidPayload(
          location(path) + "rejects an unknown property",
          mutated
        )
      );
    }

    for (JsonNode required : schema.path("required")) {
      String property = required.textValue();
      String propertyPath = append(
        path,
        property
      );
      JsonNode missing = valid.deepCopy();
      ((ObjectNode) missing.at(path)).remove(property);
      invalid.add(
        new InvalidPayload(
          location(propertyPath) + "rejects a missing required property",
          missing
        )
      );

      addReplacement(
        valid,
        propertyPath,
        location(propertyPath) + "rejects null for a required property",
        MAPPER.getNodeFactory()
          .nullNode(),
        invalid
      );

      collectViolations(
        schema.path("properties")
          .path(property),
        root,
        valid,
        propertyPath,
        invalid
      );
    }
  }

  private static void collectArrayViolations(
    JsonNode schema,
    JsonNode root,
    JsonNode valid,
    String path,
    List<InvalidPayload> invalid
  ) {
    int minimum = schema.path("minItems")
      .asInt(0);
    if (minimum > 0) {
      JsonNode mutated = valid.deepCopy();
      ArrayNode array = (ArrayNode) mutated.at(path);
      while (array.size() >= minimum) {
        array.remove(array.size() - 1);
      }
      invalid.add(
        new InvalidPayload(
          location(path) + "rejects fewer than " + minimum + " items",
          mutated
        )
      );
    }

    if (schema.has("maxItems")) {
      int maximum = schema.get("maxItems")
        .intValue();
      JsonNode mutated = valid.deepCopy();
      ArrayNode array = (ArrayNode) mutated.at(path);
      JsonNode item = OfficialProtocolFixtureTest.minimalValue(
        schema.path("items"),
        root
      );
      while (array.size() <= maximum) {
        array.add(item.deepCopy());
      }
      invalid.add(
        new InvalidPayload(
          location(path) + "rejects more than " + maximum + " items",
          mutated
        )
      );
    }

    JsonNode array = valid.at(path);
    for (int index = 0; index < array.size(); index++) {
      collectViolations(
        schema.path("items"),
        root,
        valid,
        append(
          path,
          Integer.toString(index)
        ),
        invalid
      );
    }
  }

  private static void collectStringViolations(
    JsonNode schema,
    JsonNode valid,
    String path,
    List<InvalidPayload> invalid
  ) {
    if (schema.has("minLength") && schema.get("minLength")
      .intValue() > 0) {
      int minimum = schema.get("minLength")
        .intValue();
      addReplacement(
        valid,
        path,
        location(path) + "rejects strings shorter than " + minimum,
        MAPPER.getNodeFactory()
          .textNode("x".repeat(minimum - 1)),
        invalid
      );
    }
    if (schema.has("maxLength")) {
      int maximum = schema.get("maxLength")
        .intValue();
      addReplacement(
        valid,
        path,
        location(path) + "rejects strings longer than " + maximum,
        MAPPER.getNodeFactory()
          .textNode("x".repeat(maximum + 1)),
        invalid
      );
    }
  }

  private static void collectNumberViolations(
    JsonNode schema,
    JsonNode valid,
    String path,
    List<InvalidPayload> invalid
  ) {
    if (schema.has("minimum")) {
      double minimum = schema.get("minimum")
        .doubleValue();
      addReplacement(
        valid,
        path,
        location(path) + "rejects values below " + minimum,
        MAPPER.getNodeFactory()
          .numberNode(minimum - 1),
        invalid
      );
    }
    if (schema.has("maximum")) {
      double maximum = schema.get("maximum")
        .doubleValue();
      addReplacement(
        valid,
        path,
        location(path) + "rejects values above " + maximum,
        MAPPER.getNodeFactory()
          .numberNode(maximum + 1),
        invalid
      );
    }
  }

  private static void addWrongScalarType(
    JsonNode valid,
    String path,
    String type,
    List<InvalidPayload> invalid
  ) {
    JsonNode wrong = switch (type) {
      case "string" -> MAPPER.getNodeFactory()
        .numberNode(1);
      case "integer", "number", "boolean" -> MAPPER.getNodeFactory()
        .textNode("1");
      case "array", "object" -> MAPPER.getNodeFactory()
        .textNode("not-" + type);
      default -> null;
    };
    if (wrong != null) {
      addReplacement(
        valid,
        path,
        location(path) + "rejects scalar coercion for " + type,
        wrong,
        invalid
      );
    }
  }

  private static void addReplacement(
    JsonNode valid,
    String path,
    String description,
    JsonNode replacement,
    List<InvalidPayload> invalid
  ) {
    if (path.isEmpty()) {
      invalid.add(
        new InvalidPayload(
          description,
          replacement
        )
      );
      return;
    }
    JsonNode mutated = valid.deepCopy();
    int separator = path.lastIndexOf('/');
    JsonNode parent = mutated.at(
      separator == 0
        ? ""
        : path.substring(
          0,
          separator
        )
    );
    String segment = path.substring(separator + 1)
      .replace("~1", "/")
      .replace("~0", "~");
    if (parent.isArray()) {
      ((ArrayNode) parent).set(
        Integer.parseInt(segment),
        replacement
      );
    } else {
      ((ObjectNode) parent).set(
        segment,
        replacement
      );
    }
    invalid.add(
      new InvalidPayload(
        description,
        mutated
      )
    );
  }

  private static String append(
    String path,
    String segment
  ) {
    return path + "/" + segment.replace(
      "~",
      "~0"
    )
      .replace(
        "/",
        "~1"
      );
  }

  private static String location(String path) {
    return path.isEmpty() ? "payload " : path + " ";
  }

  @SuppressWarnings(
    {
      "rawtypes", "unchecked"
    }
  )
  private void decode(
    OcppActionDefinition<?, ?> definition,
    boolean request,
    JsonNode payload
  ) {
    if (request) {
      codec.decodeRequestPayload(
        (OcppActionDefinition) definition,
        payload
      );
    } else {
      codec.decodeResponsePayload(
        (OcppActionDefinition) definition,
        payload
      );
    }
  }

  @SuppressWarnings(
    {
      "rawtypes", "unchecked"
    }
  )
  private void decode(
    OcppActionDefinition<?, ?> definition,
    boolean request,
    String payload
  ) {
    if (request) {
      codec.decodeRequestPayload(
        (OcppActionDefinition) definition,
        payload
      );
    } else {
      codec.decodeResponsePayload(
        (OcppActionDefinition) definition,
        payload
      );
    }
  }

  private record ActionCase(
    String version, String schemaDirectory, OcppActionDefinition<?, ?> definition
  ) {
  }

  private record InvalidPayload(
    String description, JsonNode payload
  ) {
  }
}
