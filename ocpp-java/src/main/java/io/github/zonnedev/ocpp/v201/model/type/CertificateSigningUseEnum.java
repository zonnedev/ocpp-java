package io.github.zonnedev.ocpp.v201.model.type;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.Objects;

/**
 * Closed wire enumeration generated from v201 reusable definition
 * CertificateSigningUseEnumType.
 */
public enum CertificateSigningUseEnum {
  CHARGING_STATION_CERTIFICATE("ChargingStationCertificate"), V2_GCERTIFICATE("V2GCertificate");

  private final String wireValue;

  CertificateSigningUseEnum(String wireValue) {
    this.wireValue = wireValue;
  }

  @JsonValue
  public String wireValue() {
    return wireValue;
  }

  @JsonCreator
  public static CertificateSigningUseEnum fromWireValue(String wireValue) {
    Objects.requireNonNull(
      wireValue,
      "wireValue"
    );
    return switch (wireValue) {
      case "ChargingStationCertificate" -> CHARGING_STATION_CERTIFICATE;
      case "V2GCertificate" -> V2_GCERTIFICATE;
      default ->
        throw new IllegalArgumentException("Unknown CertificateSigningUseEnum: " + wireValue);
    };
  }
}
