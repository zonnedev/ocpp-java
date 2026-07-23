package io.github.zonnedev.ocpp.v201.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.zonnedev.ocpp.api.OcppVersion;
import io.github.zonnedev.ocpp.v201.Ocpp201Action;
import io.github.zonnedev.ocpp.v201.Ocpp201Request;
import io.github.zonnedev.ocpp.v201.model.type.CustomData;
import java.time.Instant;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * Immutable schema type generated from
 * schemas/v201/NotifyEVChargingNeedsRequest.json.
 */
public record NotifyEVChargingNeedsRequest(
  ChargingNeeds chargingNeeds,
  @Nullable CustomData customData,
  int evseId,
  @Nullable Integer maxScheduleTuples
) implements Ocpp201Request {
  public NotifyEVChargingNeedsRequest {
    Objects.requireNonNull(
      chargingNeeds,
      "chargingNeeds"
    );
  }

  public static NotifyEVChargingNeedsRequest of(
    ChargingNeeds chargingNeeds,
    int evseId
  ) {
    return new NotifyEVChargingNeedsRequest(
      chargingNeeds,
      null,
      evseId,
      null
    );
  }
  public static NotifyEVChargingNeedsRequest of(
    ChargingNeeds chargingNeeds,
    @Nullable CustomData customData,
    int evseId,
    @Nullable Integer maxScheduleTuples
  ) {
    return new NotifyEVChargingNeedsRequest(
      chargingNeeds,
      customData,
      evseId,
      maxScheduleTuples
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
    return Ocpp201Action.NOTIFY_EVCHARGING_NEEDS;
  }

  /**
   * Immutable schema type generated from v201 reusable definition
   * ChargingNeedsType.
   */
  public record ChargingNeeds(
    @Nullable ACChargingParameters acChargingParameters,
    @Nullable CustomData customData,
    @Nullable DCChargingParameters dcChargingParameters,
    @Nullable Instant departureTime,
    EnergyTransferModeEnum requestedEnergyTransfer
  ) {
    public ChargingNeeds {
      Objects.requireNonNull(
        requestedEnergyTransfer,
        "requestedEnergyTransfer"
      );
    }

    public static ChargingNeeds of(EnergyTransferModeEnum requestedEnergyTransfer) {
      return new ChargingNeeds(
        null,
        null,
        null,
        null,
        requestedEnergyTransfer
      );
    }
    public static ChargingNeeds of(
      @Nullable ACChargingParameters acChargingParameters,
      @Nullable CustomData customData,
      @Nullable DCChargingParameters dcChargingParameters,
      @Nullable Instant departureTime,
      EnergyTransferModeEnum requestedEnergyTransfer
    ) {
      return new ChargingNeeds(
        acChargingParameters,
        customData,
        dcChargingParameters,
        departureTime,
        requestedEnergyTransfer
      );
    }

    /**
     * Immutable schema type generated from v201 reusable definition
     * ACChargingParametersType.
     */
    public record ACChargingParameters(
      @Nullable CustomData customData,
      int energyAmount,
      int evMaxCurrent,
      int evMaxVoltage,
      int evMinCurrent
    ) {
      public ACChargingParameters {

      }

      public static ACChargingParameters of(
        int energyAmount,
        int evMaxCurrent,
        int evMaxVoltage,
        int evMinCurrent
      ) {
        return new ACChargingParameters(
          null,
          energyAmount,
          evMaxCurrent,
          evMaxVoltage,
          evMinCurrent
        );
      }
      public static ACChargingParameters of(
        @Nullable CustomData customData,
        int energyAmount,
        int evMaxCurrent,
        int evMaxVoltage,
        int evMinCurrent
      ) {
        return new ACChargingParameters(
          customData,
          energyAmount,
          evMaxCurrent,
          evMaxVoltage,
          evMinCurrent
        );
      }
    }

    /**
     * Immutable schema type generated from v201 reusable definition
     * DCChargingParametersType.
     */
    public record DCChargingParameters(
      @Nullable Integer bulkSoC,
      @Nullable CustomData customData,
      @Nullable Integer energyAmount,
      @Nullable Integer evEnergyCapacity,
      int evMaxCurrent,
      @Nullable Integer evMaxPower,
      int evMaxVoltage,
      @Nullable Integer fullSoC,
      @Nullable Integer stateOfCharge
    ) {
      public DCChargingParameters {

      }

      public static DCChargingParameters of(
        int evMaxCurrent,
        int evMaxVoltage
      ) {
        return new DCChargingParameters(
          null,
          null,
          null,
          null,
          evMaxCurrent,
          null,
          evMaxVoltage,
          null,
          null
        );
      }
      public static DCChargingParameters of(
        @Nullable Integer bulkSoC,
        @Nullable CustomData customData,
        @Nullable Integer energyAmount,
        @Nullable Integer evEnergyCapacity,
        int evMaxCurrent,
        @Nullable Integer evMaxPower,
        int evMaxVoltage,
        @Nullable Integer fullSoC,
        @Nullable Integer stateOfCharge
      ) {
        return new DCChargingParameters(
          bulkSoC,
          customData,
          energyAmount,
          evEnergyCapacity,
          evMaxCurrent,
          evMaxPower,
          evMaxVoltage,
          fullSoC,
          stateOfCharge
        );
      }
    }

    /**
     * Closed wire enumeration generated from v201 reusable definition
     * EnergyTransferModeEnumType.
     */
    public enum EnergyTransferModeEnum {
      DC("DC"), AC_SINGLE_PHASE("AC_single_phase"), AC_TWO_PHASE("AC_two_phase"), AC_THREE_PHASE(
        "AC_three_phase"
      );

      private final String wireValue;

      EnergyTransferModeEnum(String wireValue) {
        this.wireValue = wireValue;
      }

      @JsonValue
      public String wireValue() {
        return wireValue;
      }

      @JsonCreator
      public static EnergyTransferModeEnum fromWireValue(String wireValue) {
        Objects.requireNonNull(
          wireValue,
          "wireValue"
        );
        return switch (wireValue) {
          case "DC" -> DC;
          case "AC_single_phase" -> AC_SINGLE_PHASE;
          case "AC_two_phase" -> AC_TWO_PHASE;
          case "AC_three_phase" -> AC_THREE_PHASE;
          default ->
            throw new IllegalArgumentException("Unknown EnergyTransferModeEnum: " + wireValue);
        };
      }
    }
  }
}
