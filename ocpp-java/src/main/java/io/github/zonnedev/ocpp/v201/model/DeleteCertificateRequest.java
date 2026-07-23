package io.github.zonnedev.ocpp.v201.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.github.zonnedev.ocpp.api.OcppVersion;
import io.github.zonnedev.ocpp.v201.Ocpp201Action;
import io.github.zonnedev.ocpp.v201.Ocpp201Request;
import io.github.zonnedev.ocpp.v201.model.type.CertificateHashData;
import io.github.zonnedev.ocpp.v201.model.type.CustomData;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * Immutable schema type generated from
 * schemas/v201/DeleteCertificateRequest.json.
 */
public record DeleteCertificateRequest(
  CertificateHashData certificateHashData,
  @Nullable CustomData customData
) implements Ocpp201Request {
  public DeleteCertificateRequest {
    Objects.requireNonNull(
      certificateHashData,
      "certificateHashData"
    );
  }

  public static DeleteCertificateRequest of(CertificateHashData certificateHashData) {
    return new DeleteCertificateRequest(
      certificateHashData,
      null
    );
  }
  public static DeleteCertificateRequest of(
    CertificateHashData certificateHashData,
    @Nullable CustomData customData
  ) {
    return new DeleteCertificateRequest(
      certificateHashData,
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
    return Ocpp201Action.DELETE_CERTIFICATE;
  }
}
