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
 * schemas/v16/InstallCertificateResponse.json.
 */
public record InstallCertificateResponse(
  InstallCertificateStatusEnum status
) implements Ocpp16Response {
  public InstallCertificateResponse {
    Objects.requireNonNull(
      status,
      "status"
    );
  }

  public static InstallCertificateResponse of(InstallCertificateStatusEnum status) {
    return new InstallCertificateResponse(status);
  }

  @JsonIgnore
  @Override
  public OcppVersion version() {
    return OcppVersion.OCPP_1_6_JSON;
  }

  @JsonIgnore
  @Override
  public Ocpp16Action action() {
    return Ocpp16Action.INSTALL_CERTIFICATE;
  }

  /**
   * Closed wire enumeration generated from v16 reusable definition
   * InstallCertificateStatusEnumType.
   */
  public enum InstallCertificateStatusEnum {
    ACCEPTED("Accepted"), FAILED("Failed"), REJECTED("Rejected");

    private final String wireValue;

    InstallCertificateStatusEnum(String wireValue) {
      this.wireValue = wireValue;
    }

    @JsonValue
    public String wireValue() {
      return wireValue;
    }

    @JsonCreator
    public static InstallCertificateStatusEnum fromWireValue(String wireValue) {
      Objects.requireNonNull(
        wireValue,
        "wireValue"
      );
      return switch (wireValue) {
        case "Accepted" -> ACCEPTED;
        case "Failed" -> FAILED;
        case "Rejected" -> REJECTED;
        default ->
          throw new IllegalArgumentException("Unknown InstallCertificateStatusEnum: " + wireValue);
      };
    }
  }
}
