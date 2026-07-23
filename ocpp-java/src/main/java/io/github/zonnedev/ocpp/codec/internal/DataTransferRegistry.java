package io.github.zonnedev.ocpp.codec.internal;

import io.github.zonnedev.ocpp.api.OcppVersion;
import io.github.zonnedev.ocpp.api.datatransfer.DataTransferModule;
import io.github.zonnedev.ocpp.api.datatransfer.DataTransferModuleRegistrar;
import io.github.zonnedev.ocpp.api.datatransfer.DataTransferOperationDefinition;
import io.github.zonnedev.ocpp.api.datatransfer.DataTransferResponsePayload;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

/**
 * Internal lookup assembled exclusively from explicitly registered DataTransfer
 * modules.
 */
public final class DataTransferRegistry implements DataTransferModuleRegistrar {
  private final Map<Key, DataTransferOperationDefinition<?, ?>> operations = new LinkedHashMap<>();
  private final Map<String, DataTransferModule> modules = new LinkedHashMap<>();
  private boolean frozen;

  @Override
  public DataTransferModuleRegistrar register(DataTransferModule module) {
    requireMutable();
    Objects.requireNonNull(
      module,
      "module"
    );
    String name = Objects.requireNonNull(
      module.name(),
      "module.name()"
    );
    if (name.isBlank()) {
      throw new IllegalArgumentException("DataTransfer module name must not be blank");
    }
    if (modules.putIfAbsent(
      name,
      module
    ) != null) {
      throw new IllegalArgumentException("Duplicate DataTransfer module name: " + name);
    }
    List<DataTransferOperationDefinition<?, ?>> definitions = List.copyOf(
      Objects.requireNonNull(
        module.operations(),
        "module.operations()"
      )
    );
    if (definitions.isEmpty()) {
      throw new IllegalArgumentException(
        "DataTransfer module must contain at least one operation: " + name
      );
    }
    for (DataTransferOperationDefinition<?, ?> definition : definitions) {
      registerDefinition(
        name,
        definition
      );
    }
    return this;
  }

  public DataTransferRegistry freeze() {
    frozen = true;
    return this;
  }

  public Optional<DataTransferOperationDefinition<?, ?>> find(
    OcppVersion version,
    String vendorId,
    String messageId
  ) {
    return Optional.ofNullable(
      operations.get(
        new Key(
          version,
          vendorId,
          messageId
        )
      )
    );
  }

  public boolean containsVendor(
    OcppVersion version,
    String vendorId
  ) {
    return operations.keySet()
      .stream()
      .anyMatch(
        key -> key.version() == version && key.vendorId()
          .equals(vendorId)
      );
  }

  public DataTransferOperationDefinition<?, ?> findByResponse(
    OcppVersion version,
    DataTransferResponsePayload response
  ) {
    return operations.values()
      .stream()
      .filter(operation -> operation.version() == version)
      .filter(
        operation -> operation.responseType()
          .equals(response.getClass())
      )
      .findFirst()
      .orElseThrow(
        () -> new IllegalArgumentException(
          "No registered DataTransfer operation uses response type " + response.getClass()
            .getName() + " for " + version
        )
      );
  }

  private void registerDefinition(
    String moduleName,
    DataTransferOperationDefinition<?, ?> definition
  ) {
    Objects.requireNonNull(
      definition,
      "operation"
    );
    Key key = new Key(
      definition.version(),
      definition.vendorId(),
      definition.messageId()
    );
    boolean duplicateResponseType = operations.values()
      .stream()
      .anyMatch(
        registered -> registered.version() == definition.version() && registered.responseType()
          .equals(definition.responseType())
      );
    if (duplicateResponseType) {
      throw new IllegalArgumentException(
        "DataTransfer response type is already registered for " + definition.version() + ": "
          + definition.responseType()
            .getName()
      );
    }
    if (operations.putIfAbsent(
      key,
      definition
    ) != null) {
      throw new IllegalArgumentException(
        "Duplicate DataTransfer operation " + key + " while registering module " + moduleName
      );
    }
  }

  private void requireMutable() {
    if (frozen) {
      throw new IllegalStateException("DataTransfer registrations are already frozen");
    }
  }

  private record Key(
    OcppVersion version,
    String vendorId,
    String messageId
  ) {
    private Key {
      Objects.requireNonNull(
        version,
        "version"
      );
      Objects.requireNonNull(
        vendorId,
        "vendorId"
      );
      Objects.requireNonNull(
        messageId,
        "messageId"
      );
    }
  }
}
