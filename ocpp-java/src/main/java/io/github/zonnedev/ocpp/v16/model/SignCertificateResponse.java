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
 * schemas/v16/SignCertificateResponse.json.
 */
public record SignCertificateResponse(
  GenericStatusEnum status
) implements Ocpp16Response {
  public SignCertificateResponse {
    Objects.requireNonNull(
      status,
      "status"
    );
  }

  public static SignCertificateResponse of(GenericStatusEnum status) {
    return new SignCertificateResponse(status);
  }

  @JsonIgnore
  @Override
  public OcppVersion version() {
    return OcppVersion.OCPP_1_6_JSON;
  }

  @JsonIgnore
  @Override
  public Ocpp16Action action() {
    return Ocpp16Action.SIGN_CERTIFICATE;
  }

  /**
   * Closed wire enumeration generated from v16 reusable definition
   * GenericStatusEnumType.
   */
  public enum GenericStatusEnum {
    ACCEPTED("Accepted"), REJECTED("Rejected");

    private final String wireValue;

    GenericStatusEnum(String wireValue) {
      this.wireValue = wireValue;
    }

    @JsonValue
    public String wireValue() {
      return wireValue;
    }

    @JsonCreator
    public static GenericStatusEnum fromWireValue(String wireValue) {
      Objects.requireNonNull(
        wireValue,
        "wireValue"
      );
      return switch (wireValue) {
        case "Accepted" -> ACCEPTED;
        case "Rejected" -> REJECTED;
        default -> throw new IllegalArgumentException("Unknown GenericStatusEnum: " + wireValue);
      };
    }
  }
}
