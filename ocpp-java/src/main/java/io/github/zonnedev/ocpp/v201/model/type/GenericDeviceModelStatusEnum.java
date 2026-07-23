package io.github.zonnedev.ocpp.v201.model.type;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.Objects;

/**
 * Closed wire enumeration generated from v201 reusable definition
 * GenericDeviceModelStatusEnumType.
 */
public enum GenericDeviceModelStatusEnum {
  ACCEPTED("Accepted"), REJECTED("Rejected"), NOT_SUPPORTED("NotSupported"), EMPTY_RESULT_SET(
    "EmptyResultSet"
  );

  private final String wireValue;

  GenericDeviceModelStatusEnum(String wireValue) {
    this.wireValue = wireValue;
  }

  @JsonValue
  public String wireValue() {
    return wireValue;
  }

  @JsonCreator
  public static GenericDeviceModelStatusEnum fromWireValue(String wireValue) {
    Objects.requireNonNull(
      wireValue,
      "wireValue"
    );
    return switch (wireValue) {
      case "Accepted" -> ACCEPTED;
      case "Rejected" -> REJECTED;
      case "NotSupported" -> NOT_SUPPORTED;
      case "EmptyResultSet" -> EMPTY_RESULT_SET;
      default ->
        throw new IllegalArgumentException("Unknown GenericDeviceModelStatusEnum: " + wireValue);
    };
  }
}
