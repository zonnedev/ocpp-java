package io.github.zonnedev.ocpp.api.datatransfer;

import io.github.zonnedev.ocpp.api.OcppVersion;
import java.util.Objects;

/**
 * Definition of an OCPP 2.0.1 vendor operation whose data property contains
 * native JSON.
 */
public record Ocpp201DataTransferOperation<Q extends DataTransferRequestPayload, S extends DataTransferResponsePayload>(
  String vendorId,
  String messageId,
  Class<Q> requestType,
  Class<S> responseType
) implements DataTransferOperationDefinition<Q, S> {
  public Ocpp201DataTransferOperation {
    requireIdentifier(
      vendorId,
      255,
      "vendorId"
    );
    requireIdentifier(
      messageId,
      50,
      "messageId"
    );
    Objects.requireNonNull(
      requestType,
      "requestType"
    );
    Objects.requireNonNull(
      responseType,
      "responseType"
    );
  }

  public static <Q extends DataTransferRequestPayload, S extends DataTransferResponsePayload> Ocpp201DataTransferOperation<Q, S> of(
    String vendorId,
    String messageId,
    Class<Q> requestType,
    Class<S> responseType
  ) {
    return new Ocpp201DataTransferOperation<>(
      vendorId,
      messageId,
      requestType,
      responseType
    );
  }

  @Override
  public OcppVersion version() {
    return OcppVersion.OCPP_2_0_1;
  }

  private static void requireIdentifier(
    String value,
    int maximumLength,
    String name
  ) {
    Objects.requireNonNull(
      value,
      name
    );
    if (value.isEmpty() || value.length() > maximumLength) {
      throw new IllegalArgumentException(
        name + " length must be between 1 and " + maximumLength
      );
    }
  }
}
