package io.github.zonnedev.ocpp.v201.model.type;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.Objects;

/**
 * Closed wire enumeration generated from v201 reusable definition
 * RecurrencyKindEnumType.
 */
public enum RecurrencyKindEnum {
  DAILY("Daily"), WEEKLY("Weekly");

  private final String wireValue;

  RecurrencyKindEnum(String wireValue) {
    this.wireValue = wireValue;
  }

  @JsonValue
  public String wireValue() {
    return wireValue;
  }

  @JsonCreator
  public static RecurrencyKindEnum fromWireValue(String wireValue) {
    Objects.requireNonNull(
      wireValue,
      "wireValue"
    );
    return switch (wireValue) {
      case "Daily" -> DAILY;
      case "Weekly" -> WEEKLY;
      default -> throw new IllegalArgumentException("Unknown RecurrencyKindEnum: " + wireValue);
    };
  }
}
