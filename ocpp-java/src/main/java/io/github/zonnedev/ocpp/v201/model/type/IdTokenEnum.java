package io.github.zonnedev.ocpp.v201.model.type;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.Objects;

/**
 * Closed wire enumeration generated from v201 reusable definition
 * IdTokenEnumType.
 */
public enum IdTokenEnum {
  CENTRAL("Central"), E_MAID("eMAID"), ISO14443("ISO14443"), ISO15693("ISO15693"), KEY_CODE(
    "KeyCode"
  ), LOCAL("Local"), MAC_ADDRESS("MacAddress"), NO_AUTHORIZATION("NoAuthorization");

  private final String wireValue;

  IdTokenEnum(String wireValue) {
    this.wireValue = wireValue;
  }

  @JsonValue
  public String wireValue() {
    return wireValue;
  }

  @JsonCreator
  public static IdTokenEnum fromWireValue(String wireValue) {
    Objects.requireNonNull(
      wireValue,
      "wireValue"
    );
    return switch (wireValue) {
      case "Central" -> CENTRAL;
      case "eMAID" -> E_MAID;
      case "ISO14443" -> ISO14443;
      case "ISO15693" -> ISO15693;
      case "KeyCode" -> KEY_CODE;
      case "Local" -> LOCAL;
      case "MacAddress" -> MAC_ADDRESS;
      case "NoAuthorization" -> NO_AUTHORIZATION;
      default -> throw new IllegalArgumentException("Unknown IdTokenEnum: " + wireValue);
    };
  }
}
