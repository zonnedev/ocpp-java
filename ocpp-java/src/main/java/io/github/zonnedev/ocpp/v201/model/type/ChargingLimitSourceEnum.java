package io.github.zonnedev.ocpp.v201.model.type;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.Objects;

/**
 * Closed wire enumeration generated from v201 reusable definition
 * ChargingLimitSourceEnumType.
 */
public enum ChargingLimitSourceEnum {
  EMS("EMS"), OTHER("Other"), SO("SO"), CSO("CSO");

  private final String wireValue;

  ChargingLimitSourceEnum(String wireValue) {
    this.wireValue = wireValue;
  }

  @JsonValue
  public String wireValue() {
    return wireValue;
  }

  @JsonCreator
  public static ChargingLimitSourceEnum fromWireValue(String wireValue) {
    Objects.requireNonNull(
      wireValue,
      "wireValue"
    );
    return switch (wireValue) {
      case "EMS" -> EMS;
      case "Other" -> OTHER;
      case "SO" -> SO;
      case "CSO" -> CSO;
      default ->
        throw new IllegalArgumentException("Unknown ChargingLimitSourceEnum: " + wireValue);
    };
  }
}
