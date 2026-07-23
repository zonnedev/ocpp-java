package io.github.zonnedev.ocpp.v201.model.type;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.Objects;

/**
 * Closed wire enumeration generated from v201 reusable definition
 * CostKindEnumType.
 */
public enum CostKindEnum {
  CARBON_DIOXIDE_EMISSION("CarbonDioxideEmission"), RELATIVE_PRICE_PERCENTAGE(
    "RelativePricePercentage"
  ), RENEWABLE_GENERATION_PERCENTAGE("RenewableGenerationPercentage");

  private final String wireValue;

  CostKindEnum(String wireValue) {
    this.wireValue = wireValue;
  }

  @JsonValue
  public String wireValue() {
    return wireValue;
  }

  @JsonCreator
  public static CostKindEnum fromWireValue(String wireValue) {
    Objects.requireNonNull(
      wireValue,
      "wireValue"
    );
    return switch (wireValue) {
      case "CarbonDioxideEmission" -> CARBON_DIOXIDE_EMISSION;
      case "RelativePricePercentage" -> RELATIVE_PRICE_PERCENTAGE;
      case "RenewableGenerationPercentage" -> RENEWABLE_GENERATION_PERCENTAGE;
      default -> throw new IllegalArgumentException("Unknown CostKindEnum: " + wireValue);
    };
  }
}
