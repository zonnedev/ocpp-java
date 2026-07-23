package io.github.zonnedev.ocpp.v16.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.zonnedev.ocpp.api.OcppVersion;
import io.github.zonnedev.ocpp.v16.Ocpp16Action;
import io.github.zonnedev.ocpp.v16.Ocpp16Response;
import java.util.Objects;

/**
 * Immutable schema type generated from schemas/v16/SendLocalListResponse.json.
 */
public record SendLocalListResponse(
  Status status
) implements Ocpp16Response {
  public SendLocalListResponse {
    Objects.requireNonNull(
      status,
      "status"
    );
  }

  public static SendLocalListResponse of(Status status) {
    return new SendLocalListResponse(status);
  }

  @JsonIgnore
  @Override
  public OcppVersion version() {
    return OcppVersion.OCPP_1_6_JSON;
  }

  @JsonIgnore
  @Override
  public Ocpp16Action action() {
    return Ocpp16Action.SEND_LOCAL_LIST;
  }

  /** Closed wire enumeration generated from v16 inline enumeration. */
  public enum Status {
    ACCEPTED("Accepted"), FAILED("Failed"), NOT_SUPPORTED("NotSupported"), VERSION_MISMATCH(
      "VersionMismatch"
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
        case "Failed" -> FAILED;
        case "NotSupported" -> NOT_SUPPORTED;
        case "VersionMismatch" -> VERSION_MISMATCH;
        default ->
          throw new IllegalArgumentException("Unknown Status: " + wireValue);
      };
    }
  }
}
