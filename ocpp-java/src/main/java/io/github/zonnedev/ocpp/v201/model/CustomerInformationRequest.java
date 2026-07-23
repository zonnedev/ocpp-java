package io.github.zonnedev.ocpp.v201.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.github.zonnedev.ocpp.api.OcppVersion;
import io.github.zonnedev.ocpp.v201.Ocpp201Action;
import io.github.zonnedev.ocpp.v201.Ocpp201Request;
import io.github.zonnedev.ocpp.v201.model.type.CertificateHashData;
import io.github.zonnedev.ocpp.v201.model.type.CustomData;
import io.github.zonnedev.ocpp.v201.model.type.IdToken;
import org.jspecify.annotations.Nullable;

/**
 * Immutable schema type generated from
 * schemas/v201/CustomerInformationRequest.json.
 */
public record CustomerInformationRequest(
  boolean clear,
  @Nullable CustomData customData,
  @Nullable CertificateHashData customerCertificate,
  @Nullable String customerIdentifier,
  @Nullable IdToken idToken,
  boolean report,
  int requestId
) implements Ocpp201Request {
  public CustomerInformationRequest {
    if (customerIdentifier != null && (customerIdentifier.length() > 64)) {
      throw new IllegalArgumentException("customerIdentifier length violates schema constraints");
    }
  }

  public static CustomerInformationRequest of(
    boolean clear,
    boolean report,
    int requestId
  ) {
    return new CustomerInformationRequest(
      clear,
      null,
      null,
      null,
      null,
      report,
      requestId
    );
  }
  public static CustomerInformationRequest of(
    boolean clear,
    @Nullable CustomData customData,
    @Nullable CertificateHashData customerCertificate,
    @Nullable String customerIdentifier,
    @Nullable IdToken idToken,
    boolean report,
    int requestId
  ) {
    return new CustomerInformationRequest(
      clear,
      customData,
      customerCertificate,
      customerIdentifier,
      idToken,
      report,
      requestId
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
    return Ocpp201Action.CUSTOMER_INFORMATION;
  }
}
