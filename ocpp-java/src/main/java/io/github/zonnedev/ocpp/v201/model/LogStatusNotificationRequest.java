package io.github.zonnedev.ocpp.v201.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.zonnedev.ocpp.api.OcppVersion;
import io.github.zonnedev.ocpp.v201.Ocpp201Action;
import io.github.zonnedev.ocpp.v201.Ocpp201Request;
import io.github.zonnedev.ocpp.v201.model.type.CustomData;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * Immutable schema type generated from
 * schemas/v201/LogStatusNotificationRequest.json.
 */
public record LogStatusNotificationRequest(
  @Nullable CustomData customData,
  @Nullable Integer requestId,
  UploadLogStatusEnum status
) implements Ocpp201Request {
  public LogStatusNotificationRequest {
    Objects.requireNonNull(
      status,
      "status"
    );
  }

  public static LogStatusNotificationRequest of(UploadLogStatusEnum status) {
    return new LogStatusNotificationRequest(
      null,
      null,
      status
    );
  }
  public static LogStatusNotificationRequest of(
    @Nullable CustomData customData,
    @Nullable Integer requestId,
    UploadLogStatusEnum status
  ) {
    return new LogStatusNotificationRequest(
      customData,
      requestId,
      status
    );
  }

  @JsonIgnore
  @Override
  public OcppVersion version() {
    return OcppVersion.OCPP_2_0_1;
  }

  @JsonIgnore
  @Override
  public Ocpp201Action action() {
    return Ocpp201Action.LOG_STATUS_NOTIFICATION;
  }

  /**
   * Closed wire enumeration generated from v201 reusable definition
   * UploadLogStatusEnumType.
   */
  public enum UploadLogStatusEnum {
    BAD_MESSAGE("BadMessage"), IDLE("Idle"), NOT_SUPPORTED_OPERATION(
      "NotSupportedOperation"
    ), PERMISSION_DENIED("PermissionDenied"), UPLOADED(
      "Uploaded"
    ), UPLOAD_FAILURE(
      "UploadFailure"
    ), UPLOADING("Uploading"), ACCEPTED_CANCELED("AcceptedCanceled");

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
        case "AcceptedCanceled" -> ACCEPTED_CANCELED;
        default -> throw new IllegalArgumentException("Unknown UploadLogStatusEnum: " + wireValue);
      };
    }
  }
}
