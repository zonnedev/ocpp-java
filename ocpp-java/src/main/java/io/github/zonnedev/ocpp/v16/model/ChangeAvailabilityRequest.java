package io.github.zonnedev.ocpp.v16.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.zonnedev.ocpp.api.OcppVersion;
import io.github.zonnedev.ocpp.v16.Ocpp16Action;
import io.github.zonnedev.ocpp.v16.Ocpp16Request;
import java.util.Objects;

/** Immutable schema type generated from schemas/v16/ChangeAvailability.json. */
public record ChangeAvailabilityRequest(
  int connectorId,
  Type type
) implements Ocpp16Request {
  public ChangeAvailabilityRequest {
    Objects.requireNonNull(
      type,
      "type"
    );
  }

  public static ChangeAvailabilityRequest of(
    int connectorId,
    Type type
  ) {
    return new ChangeAvailabilityRequest(
      connectorId,
      type
    );
  }

  @JsonIgnore
  @Override
  public OcppVersion version() {
    return OcppVersion.OCPP_1_6_JSON;
  }

  @JsonIgnore
  @Override
  public Ocpp16Action action() {
    return Ocpp16Action.CHANGE_AVAILABILITY;
  }

  /** Closed wire enumeration generated from v16 inline enumeration. */
  public enum Type {
    INOPERATIVE("Inoperative"), OPERATIVE("Operative");

    private final String wireValue;

    Type(String wireValue) {
      this.wireValue = wireValue;
    }

    @JsonValue
    public String wireValue() {
      return wireValue;
    }

    @JsonCreator
    public static Type fromWireValue(String wireValue) {
      Objects.requireNonNull(
        wireValue,
        "wireValue"
      );
      return switch (wireValue) {
        case "Inoperative" -> INOPERATIVE;
        case "Operative" -> OPERATIVE;
        default ->
          throw new IllegalArgumentException("Unknown Type: " + wireValue);
      };
    }
  }
}
