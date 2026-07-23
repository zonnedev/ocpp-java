package io.github.zonnedev.ocpp.v201.model.type;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.Objects;

/**
 * Closed wire enumeration generated from v201 reusable definition
 * MessageFormatEnumType.
 */
public enum MessageFormatEnum {
  ASCII("ASCII"), HTML("HTML"), URI("URI"), UTF8("UTF8");

  private final String wireValue;

  MessageFormatEnum(String wireValue) {
    this.wireValue = wireValue;
  }

  @JsonValue
  public String wireValue() {
    return wireValue;
  }

  @JsonCreator
  public static MessageFormatEnum fromWireValue(String wireValue) {
    Objects.requireNonNull(
      wireValue,
      "wireValue"
    );
    return switch (wireValue) {
      case "ASCII" -> ASCII;
      case "HTML" -> HTML;
      case "URI" -> URI;
      case "UTF8" -> UTF8;
      default -> throw new IllegalArgumentException("Unknown MessageFormatEnum: " + wireValue);
    };
  }
}
