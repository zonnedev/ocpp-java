package io.github.zonnedev.ocpp.v16.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.zonnedev.ocpp.api.OcppVersion;
import io.github.zonnedev.ocpp.v16.Ocpp16Action;
import io.github.zonnedev.ocpp.v16.Ocpp16Request;
import java.util.Objects;

/**
 * Immutable schema type generated from
 * schemas/v16/DiagnosticsStatusNotification.json.
 */
public record DiagnosticsStatusNotificationRequest(
  Status status
) implements Ocpp16Request {
  public DiagnosticsStatusNotificationRequest {
    Objects.requireNonNull(
      status,
      "status"
    );
  }

  public static DiagnosticsStatusNotificationRequest of(
    Status status
  ) {
    return new DiagnosticsStatusNotificationRequest(status);
  }

  @JsonIgnore
  @Override
  public OcppVersion version() {
    return OcppVersion.OCPP_1_6_JSON;
  }

  @JsonIgnore
  @Override
  public Ocpp16Action action() {
    return Ocpp16Action.DIAGNOSTICS_STATUS_NOTIFICATION;
  }

  /** Closed wire enumeration generated from v16 inline enumeration. */
  public enum Status {
    IDLE("Idle"), UPLOADED("Uploaded"), UPLOAD_FAILED("UploadFailed"), UPLOADING("Uploading");

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
        case "Idle" -> IDLE;
        case "Uploaded" -> UPLOADED;
        case "UploadFailed" -> UPLOAD_FAILED;
        case "Uploading" -> UPLOADING;
        default -> throw new IllegalArgumentException(
          "Unknown Status: " + wireValue
        );
      };
    }
  }
}
