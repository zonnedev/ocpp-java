package io.github.zonnedev.ocpp.v201.model.type;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.Objects;

/**
 * Closed wire enumeration generated from v201 reusable definition
 * ReasonEnumType.
 */
public enum ReasonEnum {
  DE_AUTHORIZED("DeAuthorized"), EMERGENCY_STOP("EmergencyStop"), ENERGY_LIMIT_REACHED(
    "EnergyLimitReached"
  ), EVDISCONNECTED("EVDisconnected"), GROUND_FAULT("GroundFault"), IMMEDIATE_RESET(
    "ImmediateReset"
  ), LOCAL("Local"), LOCAL_OUT_OF_CREDIT("LocalOutOfCredit"), MASTER_PASS("MasterPass"), OTHER(
    "Other"
  ), OVERCURRENT_FAULT("OvercurrentFault"), POWER_LOSS("PowerLoss"), POWER_QUALITY(
    "PowerQuality"
  ), REBOOT("Reboot"), REMOTE("Remote"), SOCLIMIT_REACHED(
    "SOCLimitReached"
  ), STOPPED_BY_EV("StoppedByEV"), TIME_LIMIT_REACHED("TimeLimitReached"), TIMEOUT("Timeout");

  private final String wireValue;

  ReasonEnum(String wireValue) {
    this.wireValue = wireValue;
  }

  @JsonValue
  public String wireValue() {
    return wireValue;
  }

  @JsonCreator
  public static ReasonEnum fromWireValue(String wireValue) {
    Objects.requireNonNull(
      wireValue,
      "wireValue"
    );
    return switch (wireValue) {
      case "DeAuthorized" -> DE_AUTHORIZED;
      case "EmergencyStop" -> EMERGENCY_STOP;
      case "EnergyLimitReached" -> ENERGY_LIMIT_REACHED;
      case "EVDisconnected" -> EVDISCONNECTED;
      case "GroundFault" -> GROUND_FAULT;
      case "ImmediateReset" -> IMMEDIATE_RESET;
      case "Local" -> LOCAL;
      case "LocalOutOfCredit" -> LOCAL_OUT_OF_CREDIT;
      case "MasterPass" -> MASTER_PASS;
      case "Other" -> OTHER;
      case "OvercurrentFault" -> OVERCURRENT_FAULT;
      case "PowerLoss" -> POWER_LOSS;
      case "PowerQuality" -> POWER_QUALITY;
      case "Reboot" -> REBOOT;
      case "Remote" -> REMOTE;
      case "SOCLimitReached" -> SOCLIMIT_REACHED;
      case "StoppedByEV" -> STOPPED_BY_EV;
      case "TimeLimitReached" -> TIME_LIMIT_REACHED;
      case "Timeout" -> TIMEOUT;
      default -> throw new IllegalArgumentException("Unknown ReasonEnum: " + wireValue);
    };
  }
}
