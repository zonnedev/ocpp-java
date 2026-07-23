package io.github.zonnedev.ocpp.v16.model.type;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.Objects;

/**
 * Closed wire enumeration generated from v16 reusable definition
 * CertificateUseEnumType.
 */
public enum CertificateUseEnum {
  CENTRAL_SYSTEM_ROOT_CERTIFICATE("CentralSystemRootCertificate"), MANUFACTURER_ROOT_CERTIFICATE(
    "ManufacturerRootCertificate"
  );

  private final String wireValue;

  CertificateUseEnum(String wireValue) {
    this.wireValue = wireValue;
  }

  @JsonValue
  public String wireValue() {
    return wireValue;
  }

  @JsonCreator
  public static CertificateUseEnum fromWireValue(String wireValue) {
    Objects.requireNonNull(
      wireValue,
      "wireValue"
    );
    return switch (wireValue) {
      case "CentralSystemRootCertificate" -> CENTRAL_SYSTEM_ROOT_CERTIFICATE;
      case "ManufacturerRootCertificate" -> MANUFACTURER_ROOT_CERTIFICATE;
      default -> throw new IllegalArgumentException("Unknown CertificateUseEnum: " + wireValue);
    };
  }
}
