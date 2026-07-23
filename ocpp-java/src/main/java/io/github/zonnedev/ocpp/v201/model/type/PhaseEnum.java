package io.github.zonnedev.ocpp.v201.model.type;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.Objects;

/**
 * Closed wire enumeration generated from v201 reusable definition
 * PhaseEnumType.
 */
public enum PhaseEnum {
  L1("L1"), L2("L2"), L3("L3"), N("N"), L1_N("L1-N"), L2_N("L2-N"), L3_N("L3-N"), L1_L2(
    "L1-L2"
  ), L2_L3("L2-L3"), L3_L1("L3-L1");

  private final String wireValue;

  PhaseEnum(String wireValue) {
    this.wireValue = wireValue;
  }

  @JsonValue
  public String wireValue() {
    return wireValue;
  }

  @JsonCreator
  public static PhaseEnum fromWireValue(String wireValue) {
    Objects.requireNonNull(
      wireValue,
      "wireValue"
    );
    return switch (wireValue) {
      case "L1" -> L1;
      case "L2" -> L2;
      case "L3" -> L3;
      case "N" -> N;
      case "L1-N" -> L1_N;
      case "L2-N" -> L2_N;
      case "L3-N" -> L3_N;
      case "L1-L2" -> L1_L2;
      case "L2-L3" -> L2_L3;
      case "L3-L1" -> L3_L1;
      default -> throw new IllegalArgumentException("Unknown PhaseEnum: " + wireValue);
    };
  }
}
