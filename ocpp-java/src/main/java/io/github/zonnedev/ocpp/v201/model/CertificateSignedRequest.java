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
 * schemas/v201/CertificateSignedRequest.json.
 */
public record CertificateSignedRequest(
  String certificateChain,
  @Nullable CertificateSigningUseEnum certificateType,
  @Nullable CustomData customData
) implements Ocpp201Request {
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
    return new CertificateSignedRequest(
      certificateChain,
      null,
      null
    );
  }
  public static CertificateSignedRequest of(
    String certificateChain,
    @Nullable CertificateSigningUseEnum certificateType,
    @Nullable CustomData customData
  ) {
    return new CertificateSignedRequest(
      certificateChain,
      certificateType,
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
    return Ocpp201Action.CERTIFICATE_SIGNED;
  }
}
