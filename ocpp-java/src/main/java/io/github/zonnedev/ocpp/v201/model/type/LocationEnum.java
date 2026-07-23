package io.github.zonnedev.ocpp.v201.model.type;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.Objects;

/**
 * Closed wire enumeration generated from v201 reusable definition
 * LocationEnumType.
 */
public enum LocationEnum {
  BODY("Body"), CABLE("Cable"), EV("EV"), INLET("Inlet"), OUTLET("Outlet");

  private final String wireValue;

  LocationEnum(String wireValue) {
    this.wireValue = wireValue;
  }

  @JsonValue
  public String wireValue() {
    return wireValue;
  }

  @JsonCreator
  public static LocationEnum fromWireValue(String wireValue) {
    Objects.requireNonNull(
      wireValue,
      "wireValue"
    );
    return switch (wireValue) {
      case "Body" -> BODY;
      case "Cable" -> CABLE;
      case "EV" -> EV;
      case "Inlet" -> INLET;
      case "Outlet" -> OUTLET;
      default -> throw new IllegalArgumentException("Unknown LocationEnum: " + wireValue);
    };
  }
}
