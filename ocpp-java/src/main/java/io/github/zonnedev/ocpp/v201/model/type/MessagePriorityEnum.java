package io.github.zonnedev.ocpp.v201.model.type;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.Objects;

/**
 * Closed wire enumeration generated from v201 reusable definition
 * MessagePriorityEnumType.
 */
public enum MessagePriorityEnum {
  ALWAYS_FRONT("AlwaysFront"), IN_FRONT("InFront"), NORMAL_CYCLE("NormalCycle");

  private final String wireValue;

  MessagePriorityEnum(String wireValue) {
    this.wireValue = wireValue;
  }

  @JsonValue
  public String wireValue() {
    return wireValue;
  }

  @JsonCreator
  public static MessagePriorityEnum fromWireValue(String wireValue) {
    Objects.requireNonNull(
      wireValue,
      "wireValue"
    );
    return switch (wireValue) {
      case "AlwaysFront" -> ALWAYS_FRONT;
      case "InFront" -> IN_FRONT;
      case "NormalCycle" -> NORMAL_CYCLE;
      default -> throw new IllegalArgumentException("Unknown MessagePriorityEnum: " + wireValue);
    };
  }
}
