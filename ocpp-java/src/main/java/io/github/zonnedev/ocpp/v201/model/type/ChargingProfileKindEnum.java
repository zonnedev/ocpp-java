package io.github.zonnedev.ocpp.v201.model.type;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.Objects;

/**
 * Closed wire enumeration generated from v201 reusable definition
 * ChargingProfileKindEnumType.
 */
public enum ChargingProfileKindEnum {
  ABSOLUTE("Absolute"), RECURRING("Recurring"), RELATIVE("Relative");

  private final String wireValue;

  ChargingProfileKindEnum(String wireValue) {
    this.wireValue = wireValue;
  }

  @JsonValue
  public String wireValue() {
    return wireValue;
  }

  @JsonCreator
  public static ChargingProfileKindEnum fromWireValue(String wireValue) {
    Objects.requireNonNull(
      wireValue,
      "wireValue"
    );
    return switch (wireValue) {
      case "Absolute" -> ABSOLUTE;
      case "Recurring" -> RECURRING;
      case "Relative" -> RELATIVE;
      default ->
        throw new IllegalArgumentException("Unknown ChargingProfileKindEnum: " + wireValue);
    };
  }
}
