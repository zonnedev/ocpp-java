package io.github.zonnedev.ocpp.v201.model.type;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.Objects;

/**
 * Closed wire enumeration generated from v201 reusable definition
 * GetCertificateIdUseEnumType.
 */
public enum GetCertificateIdUseEnum {
  V2_GROOT_CERTIFICATE("V2GRootCertificate"), MOROOT_CERTIFICATE(
    "MORootCertificate"
  ), CSMSROOT_CERTIFICATE("CSMSRootCertificate"), V2_GCERTIFICATE_CHAIN(
    "V2GCertificateChain"
  ), MANUFACTURER_ROOT_CERTIFICATE("ManufacturerRootCertificate");

  private final String wireValue;

  GetCertificateIdUseEnum(String wireValue) {
    this.wireValue = wireValue;
  }

  @JsonValue
  public String wireValue() {
    return wireValue;
  }

  @JsonCreator
  public static GetCertificateIdUseEnum fromWireValue(String wireValue) {
    Objects.requireNonNull(
      wireValue,
      "wireValue"
    );
    return switch (wireValue) {
      case "V2GRootCertificate" -> V2_GROOT_CERTIFICATE;
      case "MORootCertificate" -> MOROOT_CERTIFICATE;
      case "CSMSRootCertificate" -> CSMSROOT_CERTIFICATE;
      case "V2GCertificateChain" -> V2_GCERTIFICATE_CHAIN;
      case "ManufacturerRootCertificate" -> MANUFACTURER_ROOT_CERTIFICATE;
      default ->
        throw new IllegalArgumentException("Unknown GetCertificateIdUseEnum: " + wireValue);
    };
  }
}
