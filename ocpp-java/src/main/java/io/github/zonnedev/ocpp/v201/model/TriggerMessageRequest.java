package io.github.zonnedev.ocpp.v201.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.zonnedev.ocpp.api.OcppVersion;
import io.github.zonnedev.ocpp.v201.Ocpp201Action;
import io.github.zonnedev.ocpp.v201.Ocpp201Request;
import io.github.zonnedev.ocpp.v201.model.type.CustomData;
import io.github.zonnedev.ocpp.v201.model.type.EVSE;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * Immutable schema type generated from schemas/v201/TriggerMessageRequest.json.
 */
public record TriggerMessageRequest(
  @Nullable CustomData customData,
  @Nullable EVSE evse,
  MessageTriggerEnum requestedMessage
) implements Ocpp201Request {
  public TriggerMessageRequest {
    Objects.requireNonNull(
      requestedMessage,
      "requestedMessage"
    );
  }

  public static TriggerMessageRequest of(MessageTriggerEnum requestedMessage) {
    return new TriggerMessageRequest(
      null,
      null,
      requestedMessage
    );
  }
  public static TriggerMessageRequest of(
    @Nullable CustomData customData,
    @Nullable EVSE evse,
    MessageTriggerEnum requestedMessage
  ) {
    return new TriggerMessageRequest(
      customData,
      evse,
      requestedMessage
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
   * MessageTriggerEnumType.
   */
  public enum MessageTriggerEnum {
    BOOT_NOTIFICATION("BootNotification"), LOG_STATUS_NOTIFICATION(
      "LogStatusNotification"
    ), FIRMWARE_STATUS_NOTIFICATION("FirmwareStatusNotification"), HEARTBEAT(
      "Heartbeat"
    ), METER_VALUES("MeterValues"), SIGN_CHARGING_STATION_CERTIFICATE(
      "SignChargingStationCertificate"
    ), SIGN_V2_GCERTIFICATE("SignV2GCertificate"), STATUS_NOTIFICATION(
      "StatusNotification"
    ), TRANSACTION_EVENT("TransactionEvent"), SIGN_COMBINED_CERTIFICATE(
      "SignCombinedCertificate"
    ), PUBLISH_FIRMWARE_STATUS_NOTIFICATION("PublishFirmwareStatusNotification");

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
        case "SignChargingStationCertificate" -> SIGN_CHARGING_STATION_CERTIFICATE;
        case "SignV2GCertificate" -> SIGN_V2_GCERTIFICATE;
        case "StatusNotification" -> STATUS_NOTIFICATION;
        case "TransactionEvent" -> TRANSACTION_EVENT;
        case "SignCombinedCertificate" -> SIGN_COMBINED_CERTIFICATE;
        case "PublishFirmwareStatusNotification" -> PUBLISH_FIRMWARE_STATUS_NOTIFICATION;
        default -> throw new IllegalArgumentException("Unknown MessageTriggerEnum: " + wireValue);
      };
    }
  }
}
