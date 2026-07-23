package io.github.zonnedev.ocpp.v16.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.zonnedev.ocpp.api.OcppVersion;
import io.github.zonnedev.ocpp.v16.Ocpp16Action;
import io.github.zonnedev.ocpp.v16.Ocpp16Request;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * Immutable schema type generated from schemas/v16/LogStatusNotification.json.
 */
public record LogStatusNotificationRequest(
  @Nullable Integer requestId,
  UploadLogStatusEnum status
) implements Ocpp16Request {
  public LogStatusNotificationRequest {
    Objects.requireNonNull(
      status,
      "status"
    );
  }

  public static LogStatusNotificationRequest of(UploadLogStatusEnum status) {
    return new LogStatusNotificationRequest(
      null,
      status
    );
  }
  public static LogStatusNotificationRequest of(
    @Nullable Integer requestId,
    UploadLogStatusEnum status
  ) {
    return new LogStatusNotificationRequest(
      requestId,
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
    return Ocpp16Action.LOG_STATUS_NOTIFICATION;
  }

  /**
   * Closed wire enumeration generated from v16 reusable definition
   * UploadLogStatusEnumType.
   */
  public enum UploadLogStatusEnum {
    BAD_MESSAGE("BadMessage"), IDLE("Idle"), NOT_SUPPORTED_OPERATION(
      "NotSupportedOperation"
    ), PERMISSION_DENIED(
      "PermissionDenied"
    ), UPLOADED("Uploaded"), UPLOAD_FAILURE("UploadFailure"), UPLOADING("Uploading");

    private final String wireValue;

    UploadLogStatusEnum(String wireValue) {
      this.wireValue = wireValue;
    }

    @JsonValue
    public String wireValue() {
      return wireValue;
    }

    @JsonCreator
    public static UploadLogStatusEnum fromWireValue(String wireValue) {
      Objects.requireNonNull(
        wireValue,
        "wireValue"
      );
      return switch (wireValue) {
        case "BadMessage" -> BAD_MESSAGE;
        case "Idle" -> IDLE;
        case "NotSupportedOperation" -> NOT_SUPPORTED_OPERATION;
        case "PermissionDenied" -> PERMISSION_DENIED;
        case "Uploaded" -> UPLOADED;
        case "UploadFailure" -> UPLOAD_FAILURE;
        case "Uploading" -> UPLOADING;
        default -> throw new IllegalArgumentException("Unknown UploadLogStatusEnum: " + wireValue);
      };
    }
  }
}
