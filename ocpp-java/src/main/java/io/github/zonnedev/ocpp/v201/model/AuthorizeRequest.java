package io.github.zonnedev.ocpp.v201.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.github.zonnedev.ocpp.api.OcppVersion;
import io.github.zonnedev.ocpp.v201.Ocpp201Action;
import io.github.zonnedev.ocpp.v201.Ocpp201Request;
import io.github.zonnedev.ocpp.v201.model.type.CustomData;
import io.github.zonnedev.ocpp.v201.model.type.IdToken;
import io.github.zonnedev.ocpp.v201.model.type.OCSPRequestData;
import java.util.List;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/** Immutable schema type generated from schemas/v201/AuthorizeRequest.json. */
public record AuthorizeRequest(
  @Nullable String certificate,
  @Nullable CustomData customData,
  IdToken idToken,
  @Nullable List<OCSPRequestData> iso15118CertificateHashData
) implements Ocpp201Request {
  public AuthorizeRequest {
    if (certificate != null && (certificate.length() > 5500)) {
      throw new IllegalArgumentException("certificate length violates schema constraints");
    }
    Objects.requireNonNull(
      idToken,
      "idToken"
    );
    iso15118CertificateHashData = iso15118CertificateHashData == null
      ? null
      : List.copyOf(iso15118CertificateHashData);
    if (iso15118CertificateHashData != null
      && (iso15118CertificateHashData.size() < 1 || iso15118CertificateHashData.size() > 4)) {
      throw new IllegalArgumentException(
        "iso15118CertificateHashData size violates schema constraints"
      );
    }
  }

  public static AuthorizeRequest of(IdToken idToken) {
    return new AuthorizeRequest(
      null,
      null,
      idToken,
      null
    );
  }
  public static AuthorizeRequest of(
    @Nullable String certificate,
    @Nullable CustomData customData,
    IdToken idToken,
    @Nullable List<OCSPRequestData> iso15118CertificateHashData
  ) {
    return new AuthorizeRequest(
      certificate,
      customData,
      idToken,
      iso15118CertificateHashData
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
    return Ocpp201Action.AUTHORIZE;
  }
}
