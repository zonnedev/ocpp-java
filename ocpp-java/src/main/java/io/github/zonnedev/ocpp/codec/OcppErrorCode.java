package io.github.zonnedev.ocpp.codec;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.Arrays;
import java.util.Objects;

public enum OcppErrorCode {
  NOT_IMPLEMENTED("NotImplemented"), NOT_SUPPORTED("NotSupported"), INTERNAL_ERROR(
    "InternalError"
  ), PROTOCOL_ERROR("ProtocolError"), SECURITY_ERROR("SecurityError"), FORMATION_VIOLATION(
    "FormationViolation"
  ), PROPERTY_CONSTRAINT_VIOLATION("PropertyConstraintViolation"), OCCURRENCE_CONSTRAINT_VIOLATION(
    "OccurrenceConstraintViolation"
  ), TYPE_CONSTRAINT_VIOLATION("TypeConstraintViolation"), GENERIC_ERROR("GenericError");
  private final String wireValue;
  OcppErrorCode(String wireValue) {
    this.wireValue = wireValue;
  }
  @JsonValue
  public String wireValue() {
    return wireValue;
  }
  @JsonCreator
  public static OcppErrorCode fromWireValue(String value) {
    Objects.requireNonNull(
      value,
      "value"
    );
    return Arrays.stream(values())
      .filter(v -> v.wireValue.equals(value))
      .findFirst()
      .orElseThrow(
        () -> new IllegalArgumentException("Unknown OCPP error code: " + value)
      );
  }
}
