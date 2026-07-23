package io.github.zonnedev.ocpp.v201.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.zonnedev.ocpp.api.OcppVersion;
import io.github.zonnedev.ocpp.v201.Ocpp201Action;
import io.github.zonnedev.ocpp.v201.Ocpp201Request;
import io.github.zonnedev.ocpp.v201.model.type.CustomData;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * Immutable schema type generated from
 * schemas/v201/InstallCertificateRequest.json.
 */
public record InstallCertificateRequest(
  String certificate,
  InstallCertificateUseEnum certificateType,
  @Nullable CustomData customData
) implements Ocpp201Request {
  public InstallCertificateRequest {
    Objects.requireNonNull(
      certificate,
      "certificate"
    );
    if (certificate.length() > 5500) {
      throw new IllegalArgumentException("certificate length violates schema constraints");
    }
    Objects.requireNonNull(
      certificateType,
      "certificateType"
    );
  }

  public static InstallCertificateRequest of(
    String certificate,
    InstallCertificateUseEnum certificateType
  ) {
    return new InstallCertificateRequest(
      certificate,
      certificateType,
      null
    );
  }
  public static InstallCertificateRequest of(
    String certificate,
    InstallCertificateUseEnum certificateType,
    @Nullable CustomData customData
  ) {
    return new InstallCertificateRequest(
      certificate,
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
    return Ocpp201Action.INSTALL_CERTIFICATE;
  }

  /**
   * Closed wire enumeration generated from v201 reusable definition
   * InstallCertificateUseEnumType.
   */
  public enum InstallCertificateUseEnum {
    V2_GROOT_CERTIFICATE("V2GRootCertificate"), MOROOT_CERTIFICATE(
      "MORootCertificate"
    ), CSMSROOT_CERTIFICATE(
      "CSMSRootCertificate"
    ), MANUFACTURER_ROOT_CERTIFICATE("ManufacturerRootCertificate");

    private final String wireValue;

    InstallCertificateUseEnum(String wireValue) {
      this.wireValue = wireValue;
    }

    @JsonValue
    public String wireValue() {
      return wireValue;
    }

    @JsonCreator
    public static InstallCertificateUseEnum fromWireValue(String wireValue) {
      Objects.requireNonNull(
        wireValue,
        "wireValue"
      );
      return switch (wireValue) {
        case "V2GRootCertificate" -> V2_GROOT_CERTIFICATE;
        case "MORootCertificate" -> MOROOT_CERTIFICATE;
        case "CSMSRootCertificate" -> CSMSROOT_CERTIFICATE;
        case "ManufacturerRootCertificate" -> MANUFACTURER_ROOT_CERTIFICATE;
        default ->
          throw new IllegalArgumentException("Unknown InstallCertificateUseEnum: " + wireValue);
      };
    }
  }
}
