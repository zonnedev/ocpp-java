package io.github.zonnedev.ocpp.v201.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.zonnedev.ocpp.api.OcppVersion;
import io.github.zonnedev.ocpp.v201.Ocpp201Action;
import io.github.zonnedev.ocpp.v201.Ocpp201Request;
import io.github.zonnedev.ocpp.v201.model.type.CustomData;
import io.github.zonnedev.ocpp.v201.model.type.EVSE;
import io.github.zonnedev.ocpp.v201.model.type.IdToken;
import io.github.zonnedev.ocpp.v201.model.type.MeterValue;
import io.github.zonnedev.ocpp.v201.model.type.Transaction;
import java.time.Instant;
import java.util.List;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * Immutable schema type generated from
 * schemas/v201/TransactionEventRequest.json.
 */
public record TransactionEventRequest(
  @Nullable Integer cableMaxCurrent,
  @Nullable CustomData customData,
  TransactionEventEnum eventType,
  @Nullable EVSE evse,
  @Nullable IdToken idToken,
  @Nullable List<MeterValue> meterValue,
  @Nullable Integer numberOfPhasesUsed,
  @Nullable Boolean offline,
  @Nullable Integer reservationId,
  int seqNo,
  Instant timestamp,
  Transaction transactionInfo,
  TriggerReasonEnum triggerReason
) implements Ocpp201Request {
  public TransactionEventRequest {
    Objects.requireNonNull(
      eventType,
      "eventType"
    );
    meterValue = meterValue == null ? null : List.copyOf(meterValue);
    if (meterValue != null && (meterValue.size() < 1)) {
      throw new IllegalArgumentException("meterValue size violates schema constraints");
    }
    Objects.requireNonNull(
      timestamp,
      "timestamp"
    );
    Objects.requireNonNull(
      transactionInfo,
      "transactionInfo"
    );
    Objects.requireNonNull(
      triggerReason,
      "triggerReason"
    );
  }

  public static TransactionEventRequest of(
    TransactionEventEnum eventType,
    int seqNo,
    Instant timestamp,
    Transaction transactionInfo,
    TriggerReasonEnum triggerReason
  ) {
    return new TransactionEventRequest(
      null,
      null,
      eventType,
      null,
      null,
      null,
      null,
      null,
      null,
      seqNo,
      timestamp,
      transactionInfo,
      triggerReason
    );
  }
  public static TransactionEventRequest of(
    @Nullable Integer cableMaxCurrent,
    @Nullable CustomData customData,
    TransactionEventEnum eventType,
    @Nullable EVSE evse,
    @Nullable IdToken idToken,
    @Nullable List<MeterValue> meterValue,
    @Nullable Integer numberOfPhasesUsed,
    @Nullable Boolean offline,
    @Nullable Integer reservationId,
    int seqNo,
    Instant timestamp,
    Transaction transactionInfo,
    TriggerReasonEnum triggerReason
  ) {
    return new TransactionEventRequest(
      cableMaxCurrent,
      customData,
      eventType,
      evse,
      idToken,
      meterValue,
      numberOfPhasesUsed,
      offline,
      reservationId,
      seqNo,
      timestamp,
      transactionInfo,
      triggerReason
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
    return Ocpp201Action.TRANSACTION_EVENT;
  }

  /**
   * Closed wire enumeration generated from v201 reusable definition
   * TransactionEventEnumType.
   */
  public enum TransactionEventEnum {
    ENDED("Ended"), STARTED("Started"), UPDATED("Updated");

    private final String wireValue;

    TransactionEventEnum(String wireValue) {
      this.wireValue = wireValue;
    }

    @JsonValue
    public String wireValue() {
      return wireValue;
    }

    @JsonCreator
    public static TransactionEventEnum fromWireValue(String wireValue) {
      Objects.requireNonNull(
        wireValue,
        "wireValue"
      );
      return switch (wireValue) {
        case "Ended" -> ENDED;
        case "Started" -> STARTED;
        case "Updated" -> UPDATED;
        default -> throw new IllegalArgumentException("Unknown TransactionEventEnum: " + wireValue);
      };
    }
  }

  /**
   * Closed wire enumeration generated from v201 reusable definition
   * TriggerReasonEnumType.
   */
  public enum TriggerReasonEnum {
    AUTHORIZED("Authorized"), CABLE_PLUGGED_IN("CablePluggedIn"), CHARGING_RATE_CHANGED(
      "ChargingRateChanged"
    ), CHARGING_STATE_CHANGED("ChargingStateChanged"), DEAUTHORIZED(
      "Deauthorized"
    ), ENERGY_LIMIT_REACHED("EnergyLimitReached"), EVCOMMUNICATION_LOST(
      "EVCommunicationLost"
    ), EVCONNECT_TIMEOUT(
      "EVConnectTimeout"
    ), METER_VALUE_CLOCK("MeterValueClock"), METER_VALUE_PERIODIC(
      "MeterValuePeriodic"
    ), TIME_LIMIT_REACHED("TimeLimitReached"), TRIGGER("Trigger"), UNLOCK_COMMAND(
      "UnlockCommand"
    ), STOP_AUTHORIZED("StopAuthorized"), EVDEPARTED("EVDeparted"), EVDETECTED(
      "EVDetected"
    ), REMOTE_STOP("RemoteStop"), REMOTE_START("RemoteStart"), ABNORMAL_CONDITION(
      "AbnormalCondition"
    ), SIGNED_DATA_RECEIVED("SignedDataReceived"), RESET_COMMAND("ResetCommand");

    private final String wireValue;

    TriggerReasonEnum(String wireValue) {
      this.wireValue = wireValue;
    }

    @JsonValue
    public String wireValue() {
      return wireValue;
    }

    @JsonCreator
    public static TriggerReasonEnum fromWireValue(String wireValue) {
      Objects.requireNonNull(
        wireValue,
        "wireValue"
      );
      return switch (wireValue) {
        case "Authorized" -> AUTHORIZED;
        case "CablePluggedIn" -> CABLE_PLUGGED_IN;
        case "ChargingRateChanged" -> CHARGING_RATE_CHANGED;
        case "ChargingStateChanged" -> CHARGING_STATE_CHANGED;
        case "Deauthorized" -> DEAUTHORIZED;
        case "EnergyLimitReached" -> ENERGY_LIMIT_REACHED;
        case "EVCommunicationLost" -> EVCOMMUNICATION_LOST;
        case "EVConnectTimeout" -> EVCONNECT_TIMEOUT;
        case "MeterValueClock" -> METER_VALUE_CLOCK;
        case "MeterValuePeriodic" -> METER_VALUE_PERIODIC;
        case "TimeLimitReached" -> TIME_LIMIT_REACHED;
        case "Trigger" -> TRIGGER;
        case "UnlockCommand" -> UNLOCK_COMMAND;
        case "StopAuthorized" -> STOP_AUTHORIZED;
        case "EVDeparted" -> EVDEPARTED;
        case "EVDetected" -> EVDETECTED;
        case "RemoteStop" -> REMOTE_STOP;
        case "RemoteStart" -> REMOTE_START;
        case "AbnormalCondition" -> ABNORMAL_CONDITION;
        case "SignedDataReceived" -> SIGNED_DATA_RECEIVED;
        case "ResetCommand" -> RESET_COMMAND;
        default -> throw new IllegalArgumentException("Unknown TriggerReasonEnum: " + wireValue);
      };
    }
  }
}
