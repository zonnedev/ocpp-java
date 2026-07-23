package io.github.zonnedev.ocpp.v16.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.zonnedev.ocpp.api.OcppVersion;
import io.github.zonnedev.ocpp.v16.Ocpp16Action;
import io.github.zonnedev.ocpp.v16.Ocpp16Request;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/** Immutable schema type generated from schemas/v16/TriggerMessage.json. */
public record TriggerMessageRequest(
  @Nullable Integer connectorId,
  RequestedMessage requestedMessage
) implements Ocpp16Request {
  public TriggerMessageRequest {
    Objects.requireNonNull(
      requestedMessage,
      "requestedMessage"
    );
  }

  public static TriggerMessageRequest of(RequestedMessage requestedMessage) {
    return new TriggerMessageRequest(
      null,
      requestedMessage
    );
  }
  public static TriggerMessageRequest of(
    @Nullable Integer connectorId,
    RequestedMessage requestedMessage
  ) {
    return new TriggerMessageRequest(
      connectorId,
      requestedMessage
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
    return Ocpp16Action.TRIGGER_MESSAGE;
  }

  /** Closed wire enumeration generated from v16 inline enumeration. */
  public enum RequestedMessage {
    BOOT_NOTIFICATION("BootNotification"), DIAGNOSTICS_STATUS_NOTIFICATION(
      "DiagnosticsStatusNotification"
    ), FIRMWARE_STATUS_NOTIFICATION(
      "FirmwareStatusNotification"
    ), HEARTBEAT(
      "Heartbeat"
    ), METER_VALUES("MeterValues"), STATUS_NOTIFICATION("StatusNotification");

    private final String wireValue;

    RequestedMessage(String wireValue) {
      this.wireValue = wireValue;
    }

    @JsonValue
    public String wireValue() {
      return wireValue;
    }

    @JsonCreator
    public static RequestedMessage fromWireValue(String wireValue) {
      Objects.requireNonNull(
        wireValue,
        "wireValue"
      );
      return switch (wireValue) {
        case "BootNotification" -> BOOT_NOTIFICATION;
        case "DiagnosticsStatusNotification" -> DIAGNOSTICS_STATUS_NOTIFICATION;
        case "FirmwareStatusNotification" -> FIRMWARE_STATUS_NOTIFICATION;
        case "Heartbeat" -> HEARTBEAT;
        case "MeterValues" -> METER_VALUES;
        case "StatusNotification" -> STATUS_NOTIFICATION;
        default -> throw new IllegalArgumentException(
          "Unknown RequestedMessage: " + wireValue
        );
      };
    }
  }
}
