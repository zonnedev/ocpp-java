package io.github.zonnedev.ocpp.v201.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.zonnedev.ocpp.api.OcppVersion;
import io.github.zonnedev.ocpp.v201.Ocpp201Action;
import io.github.zonnedev.ocpp.v201.Ocpp201Response;
import io.github.zonnedev.ocpp.v201.model.type.CertificateHashData;
import io.github.zonnedev.ocpp.v201.model.type.CustomData;
import io.github.zonnedev.ocpp.v201.model.type.GetCertificateIdUseEnum;
import io.github.zonnedev.ocpp.v201.model.type.StatusInfo;
import java.util.List;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * Immutable schema type generated from
 * schemas/v201/GetInstalledCertificateIdsResponse.json.
 */
public record GetInstalledCertificateIdsResponse(
  @Nullable List<CertificateHashDataChain> certificateHashDataChain,
  @Nullable CustomData customData,
  GetInstalledCertificateStatusEnum status,
  @Nullable StatusInfo statusInfo
) implements Ocpp201Response {
  public GetInstalledCertificateIdsResponse {
    certificateHashDataChain = certificateHashDataChain == null
      ? null
      : List.copyOf(certificateHashDataChain);
    if (certificateHashDataChain != null && (certificateHashDataChain.size() < 1)) {
      throw new IllegalArgumentException(
        "certificateHashDataChain size violates schema constraints"
      );
    }
    Objects.requireNonNull(
      status,
      "status"
    );
  }

  public static GetInstalledCertificateIdsResponse of(GetInstalledCertificateStatusEnum status) {
    return new GetInstalledCertificateIdsResponse(
      null,
      null,
      status,
      null
    );
  }
  public static GetInstalledCertificateIdsResponse of(
    @Nullable List<CertificateHashDataChain> certificateHashDataChain,
    @Nullable CustomData customData,
    GetInstalledCertificateStatusEnum status,
    @Nullable StatusInfo statusInfo
  ) {
    return new GetInstalledCertificateIdsResponse(
      certificateHashDataChain,
      customData,
      status,
      statusInfo
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

  /**
   * Immutable schema type generated from v201 reusable definition
   * CertificateHashDataChainType.
   */
  public record CertificateHashDataChain(
    CertificateHashData certificateHashData,
    GetCertificateIdUseEnum certificateType,
    @Nullable List<CertificateHashData> childCertificateHashData,
    @Nullable CustomData customData
  ) {
    public CertificateHashDataChain {
      Objects.requireNonNull(
        certificateHashData,
        "certificateHashData"
      );
      Objects.requireNonNull(
        certificateType,
        "certificateType"
      );
      childCertificateHashData = childCertificateHashData == null
        ? null
        : List.copyOf(childCertificateHashData);
      if (childCertificateHashData != null
        && (childCertificateHashData.size() < 1 || childCertificateHashData.size() > 4)) {
        throw new IllegalArgumentException(
          "childCertificateHashData size violates schema constraints"
        );
      }
    }

    public static CertificateHashDataChain of(
      CertificateHashData certificateHashData,
      GetCertificateIdUseEnum certificateType
    ) {
      return new CertificateHashDataChain(
        certificateHashData,
        certificateType,
        null,
        null
      );
    }
    public static CertificateHashDataChain of(
      CertificateHashData certificateHashData,
      GetCertificateIdUseEnum certificateType,
      @Nullable List<CertificateHashData> childCertificateHashData,
      @Nullable CustomData customData
    ) {
      return new CertificateHashDataChain(
        certificateHashData,
        certificateType,
        childCertificateHashData,
        customData
      );
    }
  }

  /**
   * Closed wire enumeration generated from v201 reusable definition
   * GetInstalledCertificateStatusEnumType.
   */
  public enum GetInstalledCertificateStatusEnum {
    ACCEPTED("Accepted"), NOT_FOUND("NotFound");

    private final String wireValue;

    GetInstalledCertificateStatusEnum(String wireValue) {
      this.wireValue = wireValue;
    }

    @JsonValue
    public String wireValue() {
      return wireValue;
    }

    @JsonCreator
    public static GetInstalledCertificateStatusEnum fromWireValue(String wireValue) {
      Objects.requireNonNull(
        wireValue,
        "wireValue"
      );
      return switch (wireValue) {
        case "Accepted" -> ACCEPTED;
        case "NotFound" -> NOT_FOUND;
        default -> throw new IllegalArgumentException(
          "Unknown GetInstalledCertificateStatusEnum: " + wireValue
        );
      };
    }
  }
}
