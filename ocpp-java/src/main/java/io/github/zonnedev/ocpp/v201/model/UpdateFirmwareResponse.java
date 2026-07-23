package io.github.zonnedev.ocpp.v201.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.zonnedev.ocpp.api.OcppVersion;
import io.github.zonnedev.ocpp.v201.Ocpp201Action;
import io.github.zonnedev.ocpp.v201.Ocpp201Response;
import io.github.zonnedev.ocpp.v201.model.type.CustomData;
import io.github.zonnedev.ocpp.v201.model.type.StatusInfo;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * Immutable schema type generated from
 * schemas/v201/UpdateFirmwareResponse.json.
 */
public record UpdateFirmwareResponse(
  @Nullable CustomData customData,
  UpdateFirmwareStatusEnum status,
  @Nullable StatusInfo statusInfo
) implements Ocpp201Response {
  public UpdateFirmwareResponse {
    Objects.requireNonNull(
      status,
      "status"
    );
  }

  public static UpdateFirmwareResponse of(UpdateFirmwareStatusEnum status) {
    return new UpdateFirmwareResponse(
      null,
      status,
      null
    );
  }
  public static UpdateFirmwareResponse of(
    @Nullable CustomData customData,
    UpdateFirmwareStatusEnum status,
    @Nullable StatusInfo statusInfo
  ) {
    return new UpdateFirmwareResponse(
      customData,
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
    return Ocpp201Action.UPDATE_FIRMWARE;
  }

  /**
   * Closed wire enumeration generated from v201 reusable definition
   * UpdateFirmwareStatusEnumType.
   */
  public enum UpdateFirmwareStatusEnum {
    ACCEPTED("Accepted"), REJECTED("Rejected"), ACCEPTED_CANCELED(
      "AcceptedCanceled"
    ), INVALID_CERTIFICATE("InvalidCertificate"), REVOKED_CERTIFICATE("RevokedCertificate");

    private final String wireValue;

    UpdateFirmwareStatusEnum(String wireValue) {
      this.wireValue = wireValue;
    }

    @JsonValue
    public String wireValue() {
      return wireValue;
    }

    @JsonCreator
    public static UpdateFirmwareStatusEnum fromWireValue(String wireValue) {
      Objects.requireNonNull(
        wireValue,
        "wireValue"
      );
      return switch (wireValue) {
        case "Accepted" -> ACCEPTED;
        case "Rejected" -> REJECTED;
        case "AcceptedCanceled" -> ACCEPTED_CANCELED;
        case "InvalidCertificate" -> INVALID_CERTIFICATE;
        case "RevokedCertificate" -> REVOKED_CERTIFICATE;
        default ->
          throw new IllegalArgumentException("Unknown UpdateFirmwareStatusEnum: " + wireValue);
      };
    }
  }
}
