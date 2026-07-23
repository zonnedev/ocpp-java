package io.github.zonnedev.ocpp.v201.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.github.zonnedev.ocpp.api.OcppVersion;
import io.github.zonnedev.ocpp.v201.Ocpp201Action;
import io.github.zonnedev.ocpp.v201.Ocpp201Request;
import io.github.zonnedev.ocpp.v201.model.type.CertificateSigningUseEnum;
import io.github.zonnedev.ocpp.v201.model.type.CustomData;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * Immutable schema type generated from
 * schemas/v201/SignCertificateRequest.json.
 */
public record SignCertificateRequest(
  @Nullable CertificateSigningUseEnum certificateType,
  String csr,
  @Nullable CustomData customData
) implements Ocpp201Request {
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
    return new SignCertificateRequest(
      null,
      csr,
      null
    );
  }
  public static SignCertificateRequest of(
    @Nullable CertificateSigningUseEnum certificateType,
    String csr,
    @Nullable CustomData customData
  ) {
    return new SignCertificateRequest(
      certificateType,
      csr,
      customData
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
    return Ocpp201Action.SIGN_CERTIFICATE;
  }
}
