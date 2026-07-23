package io.github.zonnedev.ocpp.v16.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.zonnedev.ocpp.api.datatransfer.DataTransferResponsePayload;
import io.github.zonnedev.ocpp.api.OcppVersion;
import io.github.zonnedev.ocpp.v16.Ocpp16Action;
import io.github.zonnedev.ocpp.v16.Ocpp16Response;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * Immutable schema type generated from schemas/v16/DataTransferResponse.json.
 */
public record DataTransferResponse<S extends DataTransferResponsePayload>(
  @Nullable S data,
  Status status
) implements Ocpp16Response {
  public DataTransferResponse {
    Objects.requireNonNull(
      status,
      "status"
    );
  }

  public static <S extends DataTransferResponsePayload> DataTransferResponse<S> of(Status status) {
    return new DataTransferResponse<>(
      null,
      status
    );
  }
  public static <S extends DataTransferResponsePayload> DataTransferResponse<S> of(
    @Nullable S data,
    Status status
  ) {
    return new DataTransferResponse<>(
      data,
      status
    );
  }

  public static <S extends DataTransferResponsePayload> DataTransferResponse<S> accepted(S data) {
    return of(
      data,
      Status.ACCEPTED
    );
  }

  public static <S extends DataTransferResponsePayload> DataTransferResponse<S> rejected() {
    return of(Status.REJECTED);
  }

  public static <S extends DataTransferResponsePayload> DataTransferResponse<S> unknownMessageId() {
    return of(Status.UNKNOWN_MESSAGE_ID);
  }

  public static <S extends DataTransferResponsePayload> DataTransferResponse<S> unknownVendorId() {
    return of(Status.UNKNOWN_VENDOR_ID);
  }

  @JsonIgnore
  @Override
  public OcppVersion version() {
    return OcppVersion.OCPP_1_6_JSON;
  }

  @JsonIgnore
  @Override
  public Ocpp16Action action() {
    return Ocpp16Action.DATA_TRANSFER;
  }

  /** Closed wire enumeration generated from v16 inline enumeration. */
  public enum Status {
    ACCEPTED("Accepted"), REJECTED("Rejected"), UNKNOWN_MESSAGE_ID(
      "UnknownMessageId"
    ), UNKNOWN_VENDOR_ID("UnknownVendorId");

    private final String wireValue;

    Status(String wireValue) {
      this.wireValue = wireValue;
    }

    @JsonValue
    public String wireValue() {
      return wireValue;
    }

    @JsonCreator
    public static Status fromWireValue(String wireValue) {
      Objects.requireNonNull(
        wireValue,
        "wireValue"
      );
      return switch (wireValue) {
        case "Accepted" -> ACCEPTED;
        case "Rejected" -> REJECTED;
        case "UnknownMessageId" -> UNKNOWN_MESSAGE_ID;
        case "UnknownVendorId" -> UNKNOWN_VENDOR_ID;
        default ->
          throw new IllegalArgumentException("Unknown Status: " + wireValue);
      };
    }
  }
}
