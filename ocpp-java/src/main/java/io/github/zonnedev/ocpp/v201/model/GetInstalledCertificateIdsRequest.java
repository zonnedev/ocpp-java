package io.github.zonnedev.ocpp.v201.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.github.zonnedev.ocpp.api.OcppVersion;
import io.github.zonnedev.ocpp.v201.Ocpp201Action;
import io.github.zonnedev.ocpp.v201.Ocpp201Request;
import io.github.zonnedev.ocpp.v201.model.type.CustomData;
import io.github.zonnedev.ocpp.v201.model.type.GetCertificateIdUseEnum;
import java.util.List;
import org.jspecify.annotations.Nullable;

/**
 * Immutable schema type generated from
 * schemas/v201/GetInstalledCertificateIdsRequest.json.
 */
public record GetInstalledCertificateIdsRequest(
  @Nullable List<GetCertificateIdUseEnum> certificateType,
  @Nullable CustomData customData
) implements Ocpp201Request {
  public GetInstalledCertificateIdsRequest {
    certificateType = certificateType == null ? null : List.copyOf(certificateType);
    if (certificateType != null && (certificateType.size() < 1)) {
      throw new IllegalArgumentException("certificateType size violates schema constraints");
    }
  }

  public static GetInstalledCertificateIdsRequest of() {
    return new GetInstalledCertificateIdsRequest(
      null,
      null
    );
  }
  public static GetInstalledCertificateIdsRequest of(
    @Nullable List<GetCertificateIdUseEnum> certificateType,
    @Nullable CustomData customData
  ) {
    return new GetInstalledCertificateIdsRequest(
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
    return Ocpp201Action.GET_INSTALLED_CERTIFICATE_IDS;
  }
}
