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
 * Immutable schema type generated from schemas/v16/ExtendedTriggerMessage.json.
 */
public record ExtendedTriggerMessageRequest(
  @Nullable Integer connectorId,
  MessageTriggerEnum requestedMessage
) implements Ocpp16Request {
  public ExtendedTriggerMessageRequest {
    Objects.requireNonNull(
      requestedMessage,
      "requestedMessage"
    );
  }

  public static ExtendedTriggerMessageRequest of(MessageTriggerEnum requestedMessage) {
    return new ExtendedTriggerMessageRequest(
      null,
      requestedMessage
    );
  }
  public static ExtendedTriggerMessageRequest of(
    @Nullable Integer connectorId,
    MessageTriggerEnum requestedMessage
  ) {
    return new ExtendedTriggerMessageRequest(
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
    return Ocpp16Action.EXTENDED_TRIGGER_MESSAGE;
  }

  /**
   * Closed wire enumeration generated from v16 reusable definition
   * MessageTriggerEnumType.
   */
  public enum MessageTriggerEnum {
    BOOT_NOTIFICATION("BootNotification"), LOG_STATUS_NOTIFICATION(
      "LogStatusNotification"
    ), FIRMWARE_STATUS_NOTIFICATION("FirmwareStatusNotification"), HEARTBEAT(
      "Heartbeat"
    ), METER_VALUES("MeterValues"), SIGN_CHARGE_POINT_CERTIFICATE(
      "SignChargePointCertificate"
    ), STATUS_NOTIFICATION("StatusNotification");

    private final String wireValue;

    MessageTriggerEnum(String wireValue) {
      this.wireValue = wireValue;
    }

    @JsonValue
    public String wireValue() {
      return wireValue;
    }

    @JsonCreator
    public static MessageTriggerEnum fromWireValue(String wireValue) {
      Objects.requireNonNull(
        wireValue,
        "wireValue"
      );
      return switch (wireValue) {
        case "BootNotification" -> BOOT_NOTIFICATION;
        case "LogStatusNotification" -> LOG_STATUS_NOTIFICATION;
        case "FirmwareStatusNotification" -> FIRMWARE_STATUS_NOTIFICATION;
        case "Heartbeat" -> HEARTBEAT;
        case "MeterValues" -> METER_VALUES;
        case "SignChargePointCertificate" -> SIGN_CHARGE_POINT_CERTIFICATE;
        case "StatusNotification" -> STATUS_NOTIFICATION;
        default -> throw new IllegalArgumentException("Unknown MessageTriggerEnum: " + wireValue);
      };
    }
  }
}
