package io.github.zonnedev.ocpp.v201.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.zonnedev.ocpp.api.OcppVersion;
import io.github.zonnedev.ocpp.v201.Ocpp201Action;
import io.github.zonnedev.ocpp.v201.Ocpp201Response;
import io.github.zonnedev.ocpp.v201.model.type.CustomData;
import io.github.zonnedev.ocpp.v201.model.type.StatusInfo;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * Immutable schema type generated from
 * schemas/v201/SetDisplayMessageResponse.json.
 */
public record SetDisplayMessageResponse(
  @Nullable CustomData customData,
  DisplayMessageStatusEnum status,
  @Nullable StatusInfo statusInfo
) implements Ocpp201Response {
  public SetDisplayMessageResponse {
    Objects.requireNonNull(
      status,
      "status"
    );
  }

  public static SetDisplayMessageResponse of(DisplayMessageStatusEnum status) {
    return new SetDisplayMessageResponse(
      null,
      status,
      null
    );
  }
  public static SetDisplayMessageResponse of(
    @Nullable CustomData customData,
    DisplayMessageStatusEnum status,
    @Nullable StatusInfo statusInfo
  ) {
    return new SetDisplayMessageResponse(
      customData,
      status,
      statusInfo
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
    return Ocpp201Action.SET_DISPLAY_MESSAGE;
  }

  /**
   * Closed wire enumeration generated from v201 reusable definition
   * DisplayMessageStatusEnumType.
   */
  public enum DisplayMessageStatusEnum {
    ACCEPTED("Accepted"), NOT_SUPPORTED_MESSAGE_FORMAT("NotSupportedMessageFormat"), REJECTED(
      "Rejected"
    ), NOT_SUPPORTED_PRIORITY(
      "NotSupportedPriority"
    ), NOT_SUPPORTED_STATE("NotSupportedState"), UNKNOWN_TRANSACTION("UnknownTransaction");

    private final String wireValue;

    DisplayMessageStatusEnum(String wireValue) {
      this.wireValue = wireValue;
    }

    @JsonValue
    public String wireValue() {
      return wireValue;
    }

    @JsonCreator
    public static DisplayMessageStatusEnum fromWireValue(String wireValue) {
      Objects.requireNonNull(
        wireValue,
        "wireValue"
      );
      return switch (wireValue) {
        case "Accepted" -> ACCEPTED;
        case "NotSupportedMessageFormat" -> NOT_SUPPORTED_MESSAGE_FORMAT;
        case "Rejected" -> REJECTED;
        case "NotSupportedPriority" -> NOT_SUPPORTED_PRIORITY;
        case "NotSupportedState" -> NOT_SUPPORTED_STATE;
        case "UnknownTransaction" -> UNKNOWN_TRANSACTION;
        default ->
          throw new IllegalArgumentException("Unknown DisplayMessageStatusEnum: " + wireValue);
      };
    }
  }
}
