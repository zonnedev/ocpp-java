package io.github.zonnedev.ocpp.v16.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.zonnedev.ocpp.api.OcppVersion;
import io.github.zonnedev.ocpp.v16.Ocpp16Action;
import io.github.zonnedev.ocpp.v16.Ocpp16Response;
import java.util.Objects;

/**
 * Immutable schema type generated from
 * schemas/v16/RemoteStartTransactionResponse.json.
 */
public record RemoteStartTransactionResponse(
  Status status
) implements Ocpp16Response {
  public RemoteStartTransactionResponse {
    Objects.requireNonNull(
      status,
      "status"
    );
  }

  public static RemoteStartTransactionResponse of(Status status) {
    return new RemoteStartTransactionResponse(status);
  }

  @JsonIgnore
  @Override
  public OcppVersion version() {
    return OcppVersion.OCPP_1_6_JSON;
  }

  @JsonIgnore
  @Override
  public Ocpp16Action action() {
    return Ocpp16Action.REMOTE_START_TRANSACTION;
  }

  /** Closed wire enumeration generated from v16 inline enumeration. */
  public enum Status {
    ACCEPTED("Accepted"), REJECTED("Rejected");

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
        case "Rejected" -> REJECTED;
        default -> throw new IllegalArgumentException(
          "Unknown Status: " + wireValue
        );
      };
    }
  }
}
