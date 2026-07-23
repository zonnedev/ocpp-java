package io.github.zonnedev.ocpp.v201.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.github.zonnedev.ocpp.api.OcppVersion;
import io.github.zonnedev.ocpp.v201.Ocpp201Action;
import io.github.zonnedev.ocpp.v201.Ocpp201Request;
import io.github.zonnedev.ocpp.v201.model.type.CustomData;
import io.github.zonnedev.ocpp.v201.model.type.OCSPRequestData;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * Immutable schema type generated from
 * schemas/v201/GetCertificateStatusRequest.json.
 */
public record GetCertificateStatusRequest(
  @Nullable CustomData customData,
  OCSPRequestData ocspRequestData
) implements Ocpp201Request {
  public GetCertificateStatusRequest {
    Objects.requireNonNull(
      ocspRequestData,
      "ocspRequestData"
    );
  }

  public static GetCertificateStatusRequest of(OCSPRequestData ocspRequestData) {
    return new GetCertificateStatusRequest(
      null,
      ocspRequestData
    );
  }
  public static GetCertificateStatusRequest of(
    @Nullable CustomData customData,
    OCSPRequestData ocspRequestData
  ) {
    return new GetCertificateStatusRequest(
      customData,
      ocspRequestData
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
    return Ocpp201Action.GET_CERTIFICATE_STATUS;
  }
}
