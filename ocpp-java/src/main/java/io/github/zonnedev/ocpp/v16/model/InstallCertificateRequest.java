package io.github.zonnedev.ocpp.v16.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.github.zonnedev.ocpp.api.OcppVersion;
import io.github.zonnedev.ocpp.v16.Ocpp16Action;
import io.github.zonnedev.ocpp.v16.Ocpp16Request;
import io.github.zonnedev.ocpp.v16.model.type.CertificateUseEnum;
import java.util.Objects;

/** Immutable schema type generated from schemas/v16/InstallCertificate.json. */
public record InstallCertificateRequest(
  String certificate,
  CertificateUseEnum certificateType
) implements Ocpp16Request {
  public InstallCertificateRequest {
    Objects.requireNonNull(
      certificate,
      "certificate"
    );
    if (certificate.length() > 5500) {
      throw new IllegalArgumentException("certificate length violates schema constraints");
    }
    Objects.requireNonNull(
      certificateType,
      "certificateType"
    );
  }

  public static InstallCertificateRequest of(
    String certificate,
    CertificateUseEnum certificateType
  ) {
    return new InstallCertificateRequest(
      certificate,
      certificateType
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
    return Ocpp16Action.INSTALL_CERTIFICATE;
  }
}
