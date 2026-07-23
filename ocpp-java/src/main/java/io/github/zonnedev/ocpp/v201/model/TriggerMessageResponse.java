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
 * schemas/v201/TriggerMessageResponse.json.
 */
public record TriggerMessageResponse(
  @Nullable CustomData customData,
  TriggerMessageStatusEnum status,
  @Nullable StatusInfo statusInfo
) implements Ocpp201Response {
  public TriggerMessageResponse {
    Objects.requireNonNull(
      status,
      "status"
    );
  }

  public static TriggerMessageResponse of(TriggerMessageStatusEnum status) {
    return new TriggerMessageResponse(
      null,
      status,
      null
    );
  }
  public static TriggerMessageResponse of(
    @Nullable CustomData customData,
    TriggerMessageStatusEnum status,
    @Nullable StatusInfo statusInfo
  ) {
    return new TriggerMessageResponse(
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
    return Ocpp201Action.TRIGGER_MESSAGE;
  }

  /**
   * Closed wire enumeration generated from v201 reusable definition
   * TriggerMessageStatusEnumType.
   */
  public enum TriggerMessageStatusEnum {
    ACCEPTED("Accepted"), REJECTED("Rejected"), NOT_IMPLEMENTED("NotImplemented");

    private final String wireValue;

    TriggerMessageStatusEnum(String wireValue) {
      this.wireValue = wireValue;
    }

    @JsonValue
    public String wireValue() {
      return wireValue;
    }

    @JsonCreator
    public static TriggerMessageStatusEnum fromWireValue(String wireValue) {
      Objects.requireNonNull(
        wireValue,
        "wireValue"
      );
      return switch (wireValue) {
        case "Accepted" -> ACCEPTED;
        case "Rejected" -> REJECTED;
        case "NotImplemented" -> NOT_IMPLEMENTED;
        default ->
          throw new IllegalArgumentException("Unknown TriggerMessageStatusEnum: " + wireValue);
      };
    }
  }
}
