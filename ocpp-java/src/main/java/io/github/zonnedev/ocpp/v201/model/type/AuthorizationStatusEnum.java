package io.github.zonnedev.ocpp.v201.model.type;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.Objects;

/**
 * Closed wire enumeration generated from v201 reusable definition
 * AuthorizationStatusEnumType.
 */
public enum AuthorizationStatusEnum {
  ACCEPTED("Accepted"), BLOCKED("Blocked"), CONCURRENT_TX("ConcurrentTx"), EXPIRED(
    "Expired"
  ), INVALID("Invalid"), NO_CREDIT("NoCredit"), NOT_ALLOWED_TYPE_EVSE(
    "NotAllowedTypeEVSE"
  ), NOT_AT_THIS_LOCATION(
    "NotAtThisLocation"
  ), NOT_AT_THIS_TIME("NotAtThisTime"), UNKNOWN("Unknown");

  private final String wireValue;

  AuthorizationStatusEnum(String wireValue) {
    this.wireValue = wireValue;
  }

  @JsonValue
  public String wireValue() {
    return wireValue;
  }

  @JsonCreator
  public static AuthorizationStatusEnum fromWireValue(String wireValue) {
    Objects.requireNonNull(
      wireValue,
      "wireValue"
    );
    return switch (wireValue) {
      case "Accepted" -> ACCEPTED;
      case "Blocked" -> BLOCKED;
      case "ConcurrentTx" -> CONCURRENT_TX;
      case "Expired" -> EXPIRED;
      case "Invalid" -> INVALID;
      case "NoCredit" -> NO_CREDIT;
      case "NotAllowedTypeEVSE" -> NOT_ALLOWED_TYPE_EVSE;
      case "NotAtThisLocation" -> NOT_AT_THIS_LOCATION;
      case "NotAtThisTime" -> NOT_AT_THIS_TIME;
      case "Unknown" -> UNKNOWN;
      default ->
        throw new IllegalArgumentException("Unknown AuthorizationStatusEnum: " + wireValue);
    };
  }
}
