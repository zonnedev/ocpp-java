package io.github.zonnedev.ocpp.v16.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.zonnedev.ocpp.api.OcppVersion;
import io.github.zonnedev.ocpp.v16.Ocpp16Action;
import io.github.zonnedev.ocpp.v16.Ocpp16Response;
import java.util.Objects;

/**
 * Immutable schema type generated from
 * schemas/v16/SignedUpdateFirmwareResponse.json.
 */
public record SignedUpdateFirmwareResponse(
  UpdateFirmwareStatusEnum status
) implements Ocpp16Response {
  public SignedUpdateFirmwareResponse {
    Objects.requireNonNull(
      status,
      "status"
    );
  }

  public static SignedUpdateFirmwareResponse of(UpdateFirmwareStatusEnum status) {
    return new SignedUpdateFirmwareResponse(status);
  }

  @JsonIgnore
  @Override
  public OcppVersion version() {
    return OcppVersion.OCPP_1_6_JSON;
  }

  @JsonIgnore
  @Override
  public Ocpp16Action action() {
    return Ocpp16Action.SIGNED_UPDATE_FIRMWARE;
  }

  /**
   * Closed wire enumeration generated from v16 reusable definition
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
