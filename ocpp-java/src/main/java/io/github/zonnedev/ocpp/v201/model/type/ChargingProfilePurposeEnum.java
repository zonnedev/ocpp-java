package io.github.zonnedev.ocpp.v201.model.type;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.Objects;

/**
 * Closed wire enumeration generated from v201 reusable definition
 * ChargingProfilePurposeEnumType.
 */
public enum ChargingProfilePurposeEnum {
  CHARGING_STATION_EXTERNAL_CONSTRAINTS(
    "ChargingStationExternalConstraints"
  ), CHARGING_STATION_MAX_PROFILE(
    "ChargingStationMaxProfile"
  ), TX_DEFAULT_PROFILE("TxDefaultProfile"), TX_PROFILE("TxProfile");

  private final String wireValue;

  ChargingProfilePurposeEnum(String wireValue) {
    this.wireValue = wireValue;
  }

  @JsonValue
  public String wireValue() {
    return wireValue;
  }

  @JsonCreator
  public static ChargingProfilePurposeEnum fromWireValue(String wireValue) {
    Objects.requireNonNull(
      wireValue,
      "wireValue"
    );
    return switch (wireValue) {
      case "ChargingStationExternalConstraints" -> CHARGING_STATION_EXTERNAL_CONSTRAINTS;
      case "ChargingStationMaxProfile" -> CHARGING_STATION_MAX_PROFILE;
      case "TxDefaultProfile" -> TX_DEFAULT_PROFILE;
      case "TxProfile" -> TX_PROFILE;
      default ->
        throw new IllegalArgumentException("Unknown ChargingProfilePurposeEnum: " + wireValue);
    };
  }
}
