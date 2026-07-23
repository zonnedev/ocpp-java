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
 * schemas/v201/GetDisplayMessagesResponse.json.
 */
public record GetDisplayMessagesResponse(
  @Nullable CustomData customData,
  GetDisplayMessagesStatusEnum status,
  @Nullable StatusInfo statusInfo
) implements Ocpp201Response {
  public GetDisplayMessagesResponse {
    Objects.requireNonNull(
      status,
      "status"
    );
  }

  public static GetDisplayMessagesResponse of(GetDisplayMessagesStatusEnum status) {
    return new GetDisplayMessagesResponse(
      null,
      status,
      null
    );
  }
  public static GetDisplayMessagesResponse of(
    @Nullable CustomData customData,
    GetDisplayMessagesStatusEnum status,
    @Nullable StatusInfo statusInfo
  ) {
    return new GetDisplayMessagesResponse(
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
    return Ocpp201Action.GET_DISPLAY_MESSAGES;
  }

  /**
   * Closed wire enumeration generated from v201 reusable definition
   * GetDisplayMessagesStatusEnumType.
   */
  public enum GetDisplayMessagesStatusEnum {
    ACCEPTED("Accepted"), UNKNOWN("Unknown");

    private final String wireValue;

    GetDisplayMessagesStatusEnum(String wireValue) {
      this.wireValue = wireValue;
    }

    @JsonValue
    public String wireValue() {
      return wireValue;
    }

    @JsonCreator
    public static GetDisplayMessagesStatusEnum fromWireValue(String wireValue) {
      Objects.requireNonNull(
        wireValue,
        "wireValue"
      );
      return switch (wireValue) {
        case "Accepted" -> ACCEPTED;
        case "Unknown" -> UNKNOWN;
        default ->
          throw new IllegalArgumentException("Unknown GetDisplayMessagesStatusEnum: " + wireValue);
      };
    }
  }
}
