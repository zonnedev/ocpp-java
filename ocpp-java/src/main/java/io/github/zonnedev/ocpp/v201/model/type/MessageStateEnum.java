package io.github.zonnedev.ocpp.v201.model.type;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.Objects;

/**
 * Closed wire enumeration generated from v201 reusable definition
 * MessageStateEnumType.
 */
public enum MessageStateEnum {
  CHARGING("Charging"), FAULTED("Faulted"), IDLE("Idle"), UNAVAILABLE("Unavailable");

  private final String wireValue;

  MessageStateEnum(String wireValue) {
    this.wireValue = wireValue;
  }

  @JsonValue
  public String wireValue() {
    return wireValue;
  }

  @JsonCreator
  public static MessageStateEnum fromWireValue(String wireValue) {
    Objects.requireNonNull(
      wireValue,
      "wireValue"
    );
    return switch (wireValue) {
      case "Charging" -> CHARGING;
      case "Faulted" -> FAULTED;
      case "Idle" -> IDLE;
      case "Unavailable" -> UNAVAILABLE;
      default -> throw new IllegalArgumentException("Unknown MessageStateEnum: " + wireValue);
    };
  }
}
