package io.github.zonnedev.ocpp.v16.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.github.zonnedev.ocpp.api.OcppVersion;
import io.github.zonnedev.ocpp.v16.Ocpp16Action;
import io.github.zonnedev.ocpp.v16.Ocpp16Request;
import io.github.zonnedev.ocpp.v16.model.type.CertificateUseEnum;
import java.util.Objects;

/**
 * Immutable schema type generated from
 * schemas/v16/GetInstalledCertificateIds.json.
 */
public record GetInstalledCertificateIdsRequest(
  CertificateUseEnum certificateType
) implements Ocpp16Request {
  public GetInstalledCertificateIdsRequest {
    Objects.requireNonNull(
      certificateType,
      "certificateType"
    );
  }

  public static GetInstalledCertificateIdsRequest of(CertificateUseEnum certificateType) {
    return new GetInstalledCertificateIdsRequest(certificateType);
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
}
