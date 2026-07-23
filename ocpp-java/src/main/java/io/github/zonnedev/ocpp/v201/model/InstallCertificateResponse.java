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
 * schemas/v201/InstallCertificateResponse.json.
 */
public record InstallCertificateResponse(
  @Nullable CustomData customData,
  InstallCertificateStatusEnum status,
  @Nullable StatusInfo statusInfo
) implements Ocpp201Response {
  public InstallCertificateResponse {
    Objects.requireNonNull(
      status,
      "status"
    );
  }

  public static InstallCertificateResponse of(InstallCertificateStatusEnum status) {
    return new InstallCertificateResponse(
      null,
      status,
      null
    );
  }
  public static InstallCertificateResponse of(
    @Nullable CustomData customData,
    InstallCertificateStatusEnum status,
    @Nullable StatusInfo statusInfo
  ) {
    return new InstallCertificateResponse(
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
    return Ocpp201Action.INSTALL_CERTIFICATE;
  }

  /**
   * Closed wire enumeration generated from v201 reusable definition
   * InstallCertificateStatusEnumType.
   */
  public enum InstallCertificateStatusEnum {
    ACCEPTED("Accepted"), REJECTED("Rejected"), FAILED("Failed");

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
        case "Rejected" -> REJECTED;
        case "Failed" -> FAILED;
        default ->
          throw new IllegalArgumentException("Unknown InstallCertificateStatusEnum: " + wireValue);
      };
    }
  }
}
