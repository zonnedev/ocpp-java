package io.github.zonnedev.ocpp.v16.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.github.zonnedev.ocpp.api.OcppVersion;
import io.github.zonnedev.ocpp.v16.Ocpp16Action;
import io.github.zonnedev.ocpp.v16.Ocpp16Request;
import io.github.zonnedev.ocpp.v16.model.type.CertificateHashData;
import java.util.Objects;

/** Immutable schema type generated from schemas/v16/DeleteCertificate.json. */
public record DeleteCertificateRequest(
  CertificateHashData certificateHashData
) implements Ocpp16Request {
  public DeleteCertificateRequest {
    Objects.requireNonNull(
      certificateHashData,
      "certificateHashData"
    );
  }

  public static DeleteCertificateRequest of(CertificateHashData certificateHashData) {
    return new DeleteCertificateRequest(certificateHashData);
  }

  @JsonIgnore
  @Override
  public OcppVersion version() {
    return OcppVersion.OCPP_1_6_JSON;
  }

  @JsonIgnore
  @Override
  public Ocpp16Action action() {
    return Ocpp16Action.DELETE_CERTIFICATE;
  }
}
