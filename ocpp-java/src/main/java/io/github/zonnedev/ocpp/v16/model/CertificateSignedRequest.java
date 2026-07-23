package io.github.zonnedev.ocpp.v16.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Objects;
import io.github.zonnedev.ocpp.api.OcppVersion;
import io.github.zonnedev.ocpp.v16.Ocpp16Action;
import io.github.zonnedev.ocpp.v16.Ocpp16Request;

/** Immutable schema type generated from schemas/v16/CertificateSigned.json. */
public record CertificateSignedRequest(
  String certificateChain
) implements Ocpp16Request {
  public CertificateSignedRequest {
    Objects.requireNonNull(
      certificateChain,
      "certificateChain"
    );
    if (certificateChain.length() > 10000) {
      throw new IllegalArgumentException("certificateChain length violates schema constraints");
    }
  }

  public static CertificateSignedRequest of(String certificateChain) {
    return new CertificateSignedRequest(certificateChain);
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
}
