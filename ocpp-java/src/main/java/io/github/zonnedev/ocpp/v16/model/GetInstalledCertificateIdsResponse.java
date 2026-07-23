package io.github.zonnedev.ocpp.v16.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.zonnedev.ocpp.api.OcppVersion;
import io.github.zonnedev.ocpp.v16.Ocpp16Action;
import io.github.zonnedev.ocpp.v16.Ocpp16Response;
import io.github.zonnedev.ocpp.v16.model.type.CertificateHashData;
import java.util.List;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * Immutable schema type generated from
 * schemas/v16/GetInstalledCertificateIdsResponse.json.
 */
public record GetInstalledCertificateIdsResponse(
  @Nullable List<CertificateHashData> certificateHashData,
  GetInstalledCertificateStatusEnum status
) implements Ocpp16Response {
  public GetInstalledCertificateIdsResponse {
    certificateHashData = certificateHashData == null ? null : List.copyOf(certificateHashData);
    if (certificateHashData != null && (certificateHashData.size() < 1)) {
      throw new IllegalArgumentException("certificateHashData size violates schema constraints");
    }
    Objects.requireNonNull(
      status,
      "status"
    );
  }

  public static GetInstalledCertificateIdsResponse of(GetInstalledCertificateStatusEnum status) {
    return new GetInstalledCertificateIdsResponse(
      null,
      status
    );
  }
  public static GetInstalledCertificateIdsResponse of(
    @Nullable List<CertificateHashData> certificateHashData,
    GetInstalledCertificateStatusEnum status
  ) {
    return new GetInstalledCertificateIdsResponse(
      certificateHashData,
      status
    );
  }

  @JsonIgnore
  @Override
  public OcppVersion version() {
    return OcppVersion.OCPP_1_6_JSON;
  }

  @JsonIgnore
  @Override
  public Ocpp16Action action() {
    return Ocpp16Action.GET_INSTALLED_CERTIFICATE_IDS;
  }

  /**
   * Closed wire enumeration generated from v16 reusable definition
   * GetInstalledCertificateStatusEnumType.
   */
  public enum GetInstalledCertificateStatusEnum {
    ACCEPTED("Accepted"), NOT_FOUND("NotFound");

    private final String wireValue;

    GetInstalledCertificateStatusEnum(String wireValue) {
      this.wireValue = wireValue;
    }

    @JsonValue
    public String wireValue() {
      return wireValue;
    }

    @JsonCreator
    public static GetInstalledCertificateStatusEnum fromWireValue(String wireValue) {
      Objects.requireNonNull(
        wireValue,
        "wireValue"
      );
      return switch (wireValue) {
        case "Accepted" -> ACCEPTED;
        case "NotFound" -> NOT_FOUND;
        default -> throw new IllegalArgumentException(
          "Unknown GetInstalledCertificateStatusEnum: " + wireValue
        );
      };
    }
  }
}
