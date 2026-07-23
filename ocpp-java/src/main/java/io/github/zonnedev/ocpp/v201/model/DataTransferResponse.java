package io.github.zonnedev.ocpp.v201.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.zonnedev.ocpp.api.OcppVersion;
import io.github.zonnedev.ocpp.api.datatransfer.DataTransferResponsePayload;
import io.github.zonnedev.ocpp.v201.Ocpp201Action;
import io.github.zonnedev.ocpp.v201.Ocpp201Response;
import io.github.zonnedev.ocpp.v201.model.type.CustomData;
import io.github.zonnedev.ocpp.v201.model.type.StatusInfo;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * Immutable schema type generated from schemas/v201/DataTransferResponse.json.
 */
public record DataTransferResponse<S extends DataTransferResponsePayload>(
  @Nullable CustomData customData,
  @Nullable S data,
  DataTransferStatusEnum status,
  @Nullable StatusInfo statusInfo
) implements Ocpp201Response {
  public DataTransferResponse {
    Objects.requireNonNull(
      status,
      "status"
    );
  }

  public static <S extends DataTransferResponsePayload> DataTransferResponse<S> of(
    DataTransferStatusEnum status
  ) {
    return new DataTransferResponse<>(
      null,
      null,
      status,
      null
    );
  }

  public static <S extends DataTransferResponsePayload> DataTransferResponse<S> accepted(S data) {
    return new DataTransferResponse<>(
      null,
      data,
      DataTransferStatusEnum.ACCEPTED,
      null
    );
  }

  public static <S extends DataTransferResponsePayload> DataTransferResponse<S> rejected() {
    return of(DataTransferStatusEnum.REJECTED);
  }

  public static <S extends DataTransferResponsePayload> DataTransferResponse<S> unknownMessageId() {
    return of(DataTransferStatusEnum.UNKNOWN_MESSAGE_ID);
  }

  public static <S extends DataTransferResponsePayload> DataTransferResponse<S> unknownVendorId() {
    return of(DataTransferStatusEnum.UNKNOWN_VENDOR_ID);
  }
  public static <S extends DataTransferResponsePayload> DataTransferResponse<S> of(
    @Nullable CustomData customData,
    @Nullable S data,
    DataTransferStatusEnum status,
    @Nullable StatusInfo statusInfo
  ) {
    return new DataTransferResponse<>(
      customData,
      data,
      status,
      statusInfo
    );
  }

  @JsonIgnore
  @Override
  public OcppVersion version() {
    return OcppVersion.OCPP_2_0_1;
  }

  @JsonIgnore
  @Override
  public Ocpp201Action action() {
    return Ocpp201Action.DATA_TRANSFER;
  }

  /**
   * Closed wire enumeration generated from v201 reusable definition
   * DataTransferStatusEnumType.
   */
  public enum DataTransferStatusEnum {
    ACCEPTED("Accepted"), REJECTED("Rejected"), UNKNOWN_MESSAGE_ID(
      "UnknownMessageId"
    ), UNKNOWN_VENDOR_ID("UnknownVendorId");

    private final String wireValue;

    DataTransferStatusEnum(String wireValue) {
      this.wireValue = wireValue;
    }

    @JsonValue
    public String wireValue() {
      return wireValue;
    }

    @JsonCreator
    public static DataTransferStatusEnum fromWireValue(String wireValue) {
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
          throw new IllegalArgumentException("Unknown DataTransferStatusEnum: " + wireValue);
      };
    }
  }
}
