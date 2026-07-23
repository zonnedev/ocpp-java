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
 * schemas/v16/ExtendedTriggerMessageResponse.json.
 */
public record ExtendedTriggerMessageResponse(
  TriggerMessageStatusEnum status
) implements Ocpp16Response {
  public ExtendedTriggerMessageResponse {
    Objects.requireNonNull(
      status,
      "status"
    );
  }

  public static ExtendedTriggerMessageResponse of(TriggerMessageStatusEnum status) {
    return new ExtendedTriggerMessageResponse(status);
  }

  @JsonIgnore
  @Override
  public OcppVersion version() {
    return OcppVersion.OCPP_1_6_JSON;
  }

  @JsonIgnore
  @Override
  public Ocpp16Action action() {
    return Ocpp16Action.EXTENDED_TRIGGER_MESSAGE;
  }

  /**
   * Closed wire enumeration generated from v16 reusable definition
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
