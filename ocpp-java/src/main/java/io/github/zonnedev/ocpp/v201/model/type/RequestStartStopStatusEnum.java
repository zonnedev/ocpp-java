package io.github.zonnedev.ocpp.v201.model.type;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.Objects;

/**
 * Closed wire enumeration generated from v201 reusable definition
 * RequestStartStopStatusEnumType.
 */
public enum RequestStartStopStatusEnum {
  ACCEPTED("Accepted"), REJECTED("Rejected");

  private final String wireValue;

  RequestStartStopStatusEnum(String wireValue) {
    this.wireValue = wireValue;
  }

  @JsonValue
  public String wireValue() {
    return wireValue;
  }

  @JsonCreator
  public static RequestStartStopStatusEnum fromWireValue(String wireValue) {
    Objects.requireNonNull(
      wireValue,
      "wireValue"
    );
    return switch (wireValue) {
      case "Accepted" -> ACCEPTED;
      case "Rejected" -> REJECTED;
      default ->
        throw new IllegalArgumentException("Unknown RequestStartStopStatusEnum: " + wireValue);
    };
  }
}
