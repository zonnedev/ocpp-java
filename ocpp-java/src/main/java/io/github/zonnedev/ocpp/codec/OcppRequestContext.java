package io.github.zonnedev.ocpp.codec;

import io.github.zonnedev.ocpp.api.OcppActionDefinition;
import io.github.zonnedev.ocpp.api.datatransfer.DataTransferOperationDefinition;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/** Correlation metadata required to decode a CALLRESULT for its source CALL. */
public record OcppRequestContext(
  OcppActionDefinition<?, ?> action,
  @Nullable DataTransferOperationDefinition<?, ?> dataTransferOperation
) {
  public OcppRequestContext {
    Objects.requireNonNull(
      action,
      "action"
    );
  }

  public static OcppRequestContext of(OcppActionDefinition<?, ?> action) {
    return new OcppRequestContext(
      action,
      null
    );
  }

  public static OcppRequestContext of(
    OcppActionDefinition<?, ?> action,
    DataTransferOperationDefinition<?, ?> dataTransferOperation
  ) {
    return new OcppRequestContext(
      action,
      dataTransferOperation
    );
  }
}
