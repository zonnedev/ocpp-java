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
 * schemas/v201/BootNotificationRequest.json.
 */
public record BootNotificationRequest(
  ChargingStation chargingStation,
  @Nullable CustomData customData,
  BootReasonEnum reason
) implements Ocpp201Request {
  public BootNotificationRequest {
    Objects.requireNonNull(
      chargingStation,
      "chargingStation"
    );
    Objects.requireNonNull(
      reason,
      "reason"
    );
  }

  public static BootNotificationRequest of(
    ChargingStation chargingStation,
    BootReasonEnum reason
  ) {
    return new BootNotificationRequest(
      chargingStation,
      null,
      reason
    );
  }
  public static BootNotificationRequest of(
    ChargingStation chargingStation,
    @Nullable CustomData customData,
    BootReasonEnum reason
  ) {
    return new BootNotificationRequest(
      chargingStation,
      customData,
      reason
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
    return Ocpp201Action.BOOT_NOTIFICATION;
  }

  /**
   * Closed wire enumeration generated from v201 reusable definition
   * BootReasonEnumType.
   */
  public enum BootReasonEnum {
    APPLICATION_RESET("ApplicationReset"), FIRMWARE_UPDATE("FirmwareUpdate"), LOCAL_RESET(
      "LocalReset"
    ), POWER_UP("PowerUp"), REMOTE_RESET("RemoteReset"), SCHEDULED_RESET(
      "ScheduledReset"
    ), TRIGGERED("Triggered"), UNKNOWN("Unknown"), WATCHDOG("Watchdog");

    private final String wireValue;

    BootReasonEnum(String wireValue) {
      this.wireValue = wireValue;
    }

    @JsonValue
    public String wireValue() {
      return wireValue;
    }

    @JsonCreator
    public static BootReasonEnum fromWireValue(String wireValue) {
      Objects.requireNonNull(
        wireValue,
        "wireValue"
      );
      return switch (wireValue) {
        case "ApplicationReset" -> APPLICATION_RESET;
        case "FirmwareUpdate" -> FIRMWARE_UPDATE;
        case "LocalReset" -> LOCAL_RESET;
        case "PowerUp" -> POWER_UP;
        case "RemoteReset" -> REMOTE_RESET;
        case "ScheduledReset" -> SCHEDULED_RESET;
        case "Triggered" -> TRIGGERED;
        case "Unknown" -> UNKNOWN;
        case "Watchdog" -> WATCHDOG;
        default -> throw new IllegalArgumentException("Unknown BootReasonEnum: " + wireValue);
      };
    }
  }

  /**
   * Immutable schema type generated from v201 reusable definition
   * ChargingStationType.
   */
  public record ChargingStation(
    @Nullable CustomData customData,
    @Nullable String firmwareVersion,
    String model,
    @Nullable Modem modem,
    @Nullable String serialNumber,
    String vendorName
  ) {
    public ChargingStation {
      if (firmwareVersion != null && (firmwareVersion.length() > 50)) {
        throw new IllegalArgumentException("firmwareVersion length violates schema constraints");
      }
      Objects.requireNonNull(
        model,
        "model"
      );
      if (model.length() > 20) {
        throw new IllegalArgumentException("model length violates schema constraints");
      }
      if (serialNumber != null && (serialNumber.length() > 25)) {
        throw new IllegalArgumentException("serialNumber length violates schema constraints");
      }
      Objects.requireNonNull(
        vendorName,
        "vendorName"
      );
      if (vendorName.length() > 50) {
        throw new IllegalArgumentException("vendorName length violates schema constraints");
      }
    }

    public static ChargingStation of(
      String model,
      String vendorName
    ) {
      return new ChargingStation(
        null,
        null,
        model,
        null,
        null,
        vendorName
      );
    }
    public static ChargingStation of(
      @Nullable CustomData customData,
      @Nullable String firmwareVersion,
      String model,
      @Nullable Modem modem,
      @Nullable String serialNumber,
      String vendorName
    ) {
      return new ChargingStation(
        customData,
        firmwareVersion,
        model,
        modem,
        serialNumber,
        vendorName
      );
    }

    /** Immutable schema type generated from v201 reusable definition ModemType. */
    public record Modem(
      @Nullable CustomData customData,
      @Nullable String iccid,
      @Nullable String imsi
    ) {
      public Modem {
        if (iccid != null && (iccid.length() > 20)) {
          throw new IllegalArgumentException("iccid length violates schema constraints");
        }
        if (imsi != null && (imsi.length() > 20)) {
          throw new IllegalArgumentException("imsi length violates schema constraints");
        }
      }

      public static Modem of() {
        return new Modem(
          null,
          null,
          null
        );
      }
      public static Modem of(
        @Nullable CustomData customData,
        @Nullable String iccid,
        @Nullable String imsi
      ) {
        return new Modem(
          customData,
          iccid,
          imsi
        );
      }
    }
  }
}
