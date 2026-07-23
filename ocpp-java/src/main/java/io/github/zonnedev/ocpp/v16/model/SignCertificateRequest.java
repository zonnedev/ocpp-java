package io.github.zonnedev.ocpp.v16.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Objects;
import io.github.zonnedev.ocpp.api.OcppVersion;
import io.github.zonnedev.ocpp.v16.Ocpp16Action;
import io.github.zonnedev.ocpp.v16.Ocpp16Request;

/** Immutable schema type generated from schemas/v16/SignCertificate.json. */
public record SignCertificateRequest(
  String csr
) implements Ocpp16Request {
  public SignCertificateRequest {
    Objects.requireNonNull(
      csr,
      "csr"
    );
    if (csr.length() > 5500) {
      throw new IllegalArgumentException("csr length violates schema constraints");
    }
  }

  public static SignCertificateRequest of(String csr) {
    return new SignCertificateRequest(csr);
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
}
