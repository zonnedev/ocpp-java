package io.github.zonnedev.ocpp.v201.model.type;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.Objects;

/**
 * Closed wire enumeration generated from v201 reusable definition
 * AttributeEnumType.
 */
public enum AttributeEnum {
  ACTUAL("Actual"), TARGET("Target"), MIN_SET("MinSet"), MAX_SET("MaxSet");

  private final String wireValue;

  AttributeEnum(String wireValue) {
    this.wireValue = wireValue;
  }

  @JsonValue
  public String wireValue() {
    return wireValue;
  }

  @JsonCreator
  public static AttributeEnum fromWireValue(String wireValue) {
    Objects.requireNonNull(
      wireValue,
      "wireValue"
    );
    return switch (wireValue) {
      case "Actual" -> ACTUAL;
      case "Target" -> TARGET;
      case "MinSet" -> MIN_SET;
      case "MaxSet" -> MAX_SET;
      default -> throw new IllegalArgumentException("Unknown AttributeEnum: " + wireValue);
    };
  }
}
