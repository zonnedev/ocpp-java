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
 * schemas/v16/CertificateSignedResponse.json.
 */
public record CertificateSignedResponse(
  CertificateSignedStatusEnum status
) implements Ocpp16Response {
  public CertificateSignedResponse {
    Objects.requireNonNull(
      status,
      "status"
    );
  }

  public static CertificateSignedResponse of(CertificateSignedStatusEnum status) {
    return new CertificateSignedResponse(status);
  }

  @JsonIgnore
  @Override
  public OcppVersion version() {
    return OcppVersion.OCPP_1_6_JSON;
  }

  @JsonIgnore
  @Override
  public Ocpp16Action action() {
    return Ocpp16Action.CERTIFICATE_SIGNED;
  }

  /**
   * Closed wire enumeration generated from v16 reusable definition
   * CertificateSignedStatusEnumType.
   */
  public enum CertificateSignedStatusEnum {
    ACCEPTED("Accepted"), REJECTED("Rejected");

    private final String wireValue;

    CertificateSignedStatusEnum(String wireValue) {
      this.wireValue = wireValue;
    }

    @JsonValue
    public String wireValue() {
      return wireValue;
    }

    @JsonCreator
    public static CertificateSignedStatusEnum fromWireValue(String wireValue) {
      Objects.requireNonNull(
        wireValue,
        "wireValue"
      );
      return switch (wireValue) {
        case "Accepted" -> ACCEPTED;
        case "Rejected" -> REJECTED;
        default ->
          throw new IllegalArgumentException("Unknown CertificateSignedStatusEnum: " + wireValue);
      };
    }
  }
}
