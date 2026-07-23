package io.github.zonnedev.ocpp.v16.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.zonnedev.ocpp.api.OcppVersion;
import io.github.zonnedev.ocpp.v16.Ocpp16Action;
import io.github.zonnedev.ocpp.v16.Ocpp16Response;
import java.util.Objects;

/** Immutable schema type generated from schemas/v16/ReserveNowResponse.json. */
public record ReserveNowResponse(
  Status status
) implements Ocpp16Response {
  public ReserveNowResponse {
    Objects.requireNonNull(
      status,
      "status"
    );
  }

  public static ReserveNowResponse of(Status status) {
    return new ReserveNowResponse(status);
  }

  @JsonIgnore
  @Override
  public OcppVersion version() {
    return OcppVersion.OCPP_1_6_JSON;
  }

  @JsonIgnore
  @Override
  public Ocpp16Action action() {
    return Ocpp16Action.RESERVE_NOW;
  }

  /** Closed wire enumeration generated from v16 inline enumeration. */
  public enum Status {
    ACCEPTED("Accepted"), FAULTED("Faulted"), OCCUPIED("Occupied"), REJECTED(
      "Rejected"
    ), UNAVAILABLE(
      "Unavailable"
    );

    private final String wireValue;

    Status(String wireValue) {
      this.wireValue = wireValue;
    }

    @JsonValue
    public String wireValue() {
      return wireValue;
    }

    @JsonCreator
    public static Status fromWireValue(String wireValue) {
      Objects.requireNonNull(
        wireValue,
        "wireValue"
      );
      return switch (wireValue) {
        case "Accepted" -> ACCEPTED;
        case "Faulted" -> FAULTED;
        case "Occupied" -> OCCUPIED;
        case "Rejected" -> REJECTED;
        case "Unavailable" -> UNAVAILABLE;
        default ->
          throw new IllegalArgumentException("Unknown Status: " + wireValue);
      };
    }
  }
}
