package io.github.zonnedev.ocpp.v201.model.type;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.Objects;

/**
 * Closed wire enumeration generated from v201 reusable definition
 * ChargingStateEnumType.
 */
public enum ChargingStateEnum {
  CHARGING("Charging"), EVCONNECTED("EVConnected"), SUSPENDED_EV("SuspendedEV"), SUSPENDED_EVSE(
    "SuspendedEVSE"
  ), IDLE("Idle");

  private final String wireValue;

  ChargingStateEnum(String wireValue) {
    this.wireValue = wireValue;
  }

  @JsonValue
  public String wireValue() {
    return wireValue;
  }

  @JsonCreator
  public static ChargingStateEnum fromWireValue(String wireValue) {
    Objects.requireNonNull(
      wireValue,
      "wireValue"
    );
    return switch (wireValue) {
      case "Charging" -> CHARGING;
      case "EVConnected" -> EVCONNECTED;
      case "SuspendedEV" -> SUSPENDED_EV;
      case "SuspendedEVSE" -> SUSPENDED_EVSE;
      case "Idle" -> IDLE;
      default -> throw new IllegalArgumentException("Unknown ChargingStateEnum: " + wireValue);
    };
  }
}
