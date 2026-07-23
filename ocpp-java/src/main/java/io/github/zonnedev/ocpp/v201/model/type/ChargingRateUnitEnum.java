package io.github.zonnedev.ocpp.v201.model.type;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.Objects;

/**
 * Closed wire enumeration generated from v201 reusable definition
 * ChargingRateUnitEnumType.
 */
public enum ChargingRateUnitEnum {
  W("W"), A("A");

  private final String wireValue;

  ChargingRateUnitEnum(String wireValue) {
    this.wireValue = wireValue;
  }

  @JsonValue
  public String wireValue() {
    return wireValue;
  }

  @JsonCreator
  public static ChargingRateUnitEnum fromWireValue(String wireValue) {
    Objects.requireNonNull(
      wireValue,
      "wireValue"
    );
    return switch (wireValue) {
      case "W" -> W;
      case "A" -> A;
      default -> throw new IllegalArgumentException("Unknown ChargingRateUnitEnum: " + wireValue);
    };
  }
}
