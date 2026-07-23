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
 * schemas/v16/UnlockConnectorResponse.json.
 */
public record UnlockConnectorResponse(
  Status status
) implements Ocpp16Response {
  public UnlockConnectorResponse {
    Objects.requireNonNull(
      status,
      "status"
    );
  }

  public static UnlockConnectorResponse of(Status status) {
    return new UnlockConnectorResponse(status);
  }

  @JsonIgnore
  @Override
  public OcppVersion version() {
    return OcppVersion.OCPP_1_6_JSON;
  }

  @JsonIgnore
  @Override
  public Ocpp16Action action() {
    return Ocpp16Action.UNLOCK_CONNECTOR;
  }

  /** Closed wire enumeration generated from v16 inline enumeration. */
  public enum Status {
    UNLOCKED("Unlocked"), UNLOCK_FAILED("UnlockFailed"), NOT_SUPPORTED("NotSupported");

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
        case "Unlocked" -> UNLOCKED;
        case "UnlockFailed" -> UNLOCK_FAILED;
        case "NotSupported" -> NOT_SUPPORTED;
        default ->
          throw new IllegalArgumentException("Unknown Status: " + wireValue);
      };
    }
  }
}
