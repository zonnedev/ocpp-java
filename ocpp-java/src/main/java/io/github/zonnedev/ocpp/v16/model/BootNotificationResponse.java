package io.github.zonnedev.ocpp.v16.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.zonnedev.ocpp.api.OcppVersion;
import io.github.zonnedev.ocpp.v16.Ocpp16Action;
import io.github.zonnedev.ocpp.v16.Ocpp16Response;
import java.time.Instant;
import java.util.Objects;

/**
 * Immutable schema type generated from
 * schemas/v16/BootNotificationResponse.json.
 */
public record BootNotificationResponse(
  Instant currentTime,
  int interval,
  Status status
) implements Ocpp16Response {
  public BootNotificationResponse {
    Objects.requireNonNull(
      currentTime,
      "currentTime"
    );
    Objects.requireNonNull(
      status,
      "status"
    );
  }

  public static BootNotificationResponse of(
    Instant currentTime,
    int interval,
    Status status
  ) {
    return new BootNotificationResponse(
      currentTime,
      interval,
      status
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
    return Ocpp16Action.BOOT_NOTIFICATION;
  }

  /** Closed wire enumeration generated from v16 inline enumeration. */
  public enum Status {
    ACCEPTED("Accepted"), PENDING("Pending"), REJECTED("Rejected");

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
        case "Pending" -> PENDING;
        case "Rejected" -> REJECTED;
        default ->
          throw new IllegalArgumentException("Unknown Status: " + wireValue);
      };
    }
  }
}
