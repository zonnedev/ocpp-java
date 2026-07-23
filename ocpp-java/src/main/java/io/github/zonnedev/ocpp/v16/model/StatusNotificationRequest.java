package io.github.zonnedev.ocpp.v16.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.zonnedev.ocpp.api.OcppVersion;
import io.github.zonnedev.ocpp.v16.Ocpp16Action;
import io.github.zonnedev.ocpp.v16.Ocpp16Request;
import java.time.Instant;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/** Immutable schema type generated from schemas/v16/StatusNotification.json. */
public record StatusNotificationRequest(
  int connectorId,
  ErrorCode errorCode,
  @Nullable String info,
  Status status,
  @Nullable Instant timestamp,
  @Nullable String vendorErrorCode,
  @Nullable String vendorId
) implements Ocpp16Request {
  public StatusNotificationRequest {
    Objects.requireNonNull(
      errorCode,
      "errorCode"
    );
    if (info != null && (info.length() > 50)) {
      throw new IllegalArgumentException("info length violates schema constraints");
    }
    Objects.requireNonNull(
      status,
      "status"
    );
    if (vendorErrorCode != null && (vendorErrorCode.length() > 50)) {
      throw new IllegalArgumentException("vendorErrorCode length violates schema constraints");
    }
    if (vendorId != null && (vendorId.length() > 255)) {
      throw new IllegalArgumentException("vendorId length violates schema constraints");
    }
  }

  public static StatusNotificationRequest of(
    int connectorId,
    ErrorCode errorCode,
    Status status
  ) {
    return new StatusNotificationRequest(
      connectorId,
      errorCode,
      null,
      status,
      null,
      null,
      null
    );
  }
  public static StatusNotificationRequest of(
    int connectorId,
    ErrorCode errorCode,
    @Nullable String info,
    Status status,
    @Nullable Instant timestamp,
    @Nullable String vendorErrorCode,
    @Nullable String vendorId
  ) {
    return new StatusNotificationRequest(
      connectorId,
      errorCode,
      info,
      status,
      timestamp,
      vendorErrorCode,
      vendorId
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
    return Ocpp16Action.STATUS_NOTIFICATION;
  }

  /** Closed wire enumeration generated from v16 inline enumeration. */
  public enum ErrorCode {
    CONNECTOR_LOCK_FAILURE("ConnectorLockFailure"), EVCOMMUNICATION_ERROR(
      "EVCommunicationError"
    ), GROUND_FAILURE("GroundFailure"), HIGH_TEMPERATURE("HighTemperature"), INTERNAL_ERROR(
      "InternalError"
    ), LOCAL_LIST_CONFLICT("LocalListConflict"), NO_ERROR(
      "NoError"
    ), OTHER_ERROR("OtherError"), OVER_CURRENT_FAILURE("OverCurrentFailure"), POWER_METER_FAILURE(
      "PowerMeterFailure"
    ), POWER_SWITCH_FAILURE("PowerSwitchFailure"), READER_FAILURE("ReaderFailure"), RESET_FAILURE(
      "ResetFailure"
    ), UNDER_VOLTAGE("UnderVoltage"), OVER_VOLTAGE("OverVoltage"), WEAK_SIGNAL("WeakSignal");

    private final String wireValue;

    ErrorCode(String wireValue) {
      this.wireValue = wireValue;
    }

    @JsonValue
    public String wireValue() {
      return wireValue;
    }

    @JsonCreator
    public static ErrorCode fromWireValue(String wireValue) {
      Objects.requireNonNull(
        wireValue,
        "wireValue"
      );
      return switch (wireValue) {
        case "ConnectorLockFailure" -> CONNECTOR_LOCK_FAILURE;
        case "EVCommunicationError" -> EVCOMMUNICATION_ERROR;
        case "GroundFailure" -> GROUND_FAILURE;
        case "HighTemperature" -> HIGH_TEMPERATURE;
        case "InternalError" -> INTERNAL_ERROR;
        case "LocalListConflict" -> LOCAL_LIST_CONFLICT;
        case "NoError" -> NO_ERROR;
        case "OtherError" -> OTHER_ERROR;
        case "OverCurrentFailure" -> OVER_CURRENT_FAILURE;
        case "PowerMeterFailure" -> POWER_METER_FAILURE;
        case "PowerSwitchFailure" -> POWER_SWITCH_FAILURE;
        case "ReaderFailure" -> READER_FAILURE;
        case "ResetFailure" -> RESET_FAILURE;
        case "UnderVoltage" -> UNDER_VOLTAGE;
        case "OverVoltage" -> OVER_VOLTAGE;
        case "WeakSignal" -> WEAK_SIGNAL;
        default -> throw new IllegalArgumentException(
          "Unknown ErrorCode: " + wireValue
        );
      };
    }
  }

  /** Closed wire enumeration generated from v16 inline enumeration. */
  public enum Status {
    AVAILABLE("Available"), PREPARING("Preparing"), CHARGING("Charging"), SUSPENDED_EVSE(
      "SuspendedEVSE"
    ), SUSPENDED_EV(
      "SuspendedEV"
    ), FINISHING("Finishing"), RESERVED("Reserved"), UNAVAILABLE("Unavailable"), FAULTED("Faulted");

    private final String wireValue;

    Status(String wireValue) {
      this.wireValue = wireValue;
    }

    @JsonValue
    public String wireValue() {
      return wireValue;
    }

    @JsonCreator
    public static Status fromWireValue(String wireValue) {
      Objects.requireNonNull(
        wireValue,
        "wireValue"
      );
      return switch (wireValue) {
        case "Available" -> AVAILABLE;
        case "Preparing" -> PREPARING;
        case "Charging" -> CHARGING;
        case "SuspendedEVSE" -> SUSPENDED_EVSE;
        case "SuspendedEV" -> SUSPENDED_EV;
        case "Finishing" -> FINISHING;
        case "Reserved" -> RESERVED;
        case "Unavailable" -> UNAVAILABLE;
        case "Faulted" -> FAULTED;
        default ->
          throw new IllegalArgumentException("Unknown Status: " + wireValue);
      };
    }
  }
}
