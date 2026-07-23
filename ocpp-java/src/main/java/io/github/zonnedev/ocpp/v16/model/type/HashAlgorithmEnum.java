package io.github.zonnedev.ocpp.v16.model.type;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.Objects;

/**
 * Closed wire enumeration generated from v16 reusable definition
 * HashAlgorithmEnumType.
 */
public enum HashAlgorithmEnum {
  SHA256("SHA256"), SHA384("SHA384"), SHA512("SHA512");

  private final String wireValue;

  HashAlgorithmEnum(String wireValue) {
    this.wireValue = wireValue;
  }

  @JsonValue
  public String wireValue() {
    return wireValue;
  }

  @JsonCreator
  public static HashAlgorithmEnum fromWireValue(String wireValue) {
    Objects.requireNonNull(
      wireValue,
      "wireValue"
    );
    return switch (wireValue) {
      case "SHA256" -> SHA256;
      case "SHA384" -> SHA384;
      case "SHA512" -> SHA512;
      default -> throw new IllegalArgumentException("Unknown HashAlgorithmEnum: " + wireValue);
    };
  }
}
