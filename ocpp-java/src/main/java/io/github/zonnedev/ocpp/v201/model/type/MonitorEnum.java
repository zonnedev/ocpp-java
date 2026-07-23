package io.github.zonnedev.ocpp.v201.model.type;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.Objects;

/**
 * Closed wire enumeration generated from v201 reusable definition
 * MonitorEnumType.
 */
public enum MonitorEnum {
  UPPER_THRESHOLD("UpperThreshold"), LOWER_THRESHOLD("LowerThreshold"), DELTA("Delta"), PERIODIC(
    "Periodic"
  ), PERIODIC_CLOCK_ALIGNED("PeriodicClockAligned");

  private final String wireValue;

  MonitorEnum(String wireValue) {
    this.wireValue = wireValue;
  }

  @JsonValue
  public String wireValue() {
    return wireValue;
  }

  @JsonCreator
  public static MonitorEnum fromWireValue(String wireValue) {
    Objects.requireNonNull(
      wireValue,
      "wireValue"
    );
    return switch (wireValue) {
      case "UpperThreshold" -> UPPER_THRESHOLD;
      case "LowerThreshold" -> LOWER_THRESHOLD;
      case "Delta" -> DELTA;
      case "Periodic" -> PERIODIC;
      case "PeriodicClockAligned" -> PERIODIC_CLOCK_ALIGNED;
      default -> throw new IllegalArgumentException("Unknown MonitorEnum: " + wireValue);
    };
  }
}
