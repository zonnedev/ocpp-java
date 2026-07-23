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
 * Immutable schema type generated from schemas/v16/GetCompositeSchedule.json.
 */
public record GetCompositeScheduleRequest(
  @Nullable ChargingRateUnit chargingRateUnit,
  int connectorId,
  int duration
) implements Ocpp16Request {
  public GetCompositeScheduleRequest {

  }

  public static GetCompositeScheduleRequest of(
    int connectorId,
    int duration
  ) {
    return new GetCompositeScheduleRequest(
      null,
      connectorId,
      duration
    );
  }
  public static GetCompositeScheduleRequest of(
    @Nullable ChargingRateUnit chargingRateUnit,
    int connectorId,
    int duration
  ) {
    return new GetCompositeScheduleRequest(
      chargingRateUnit,
      connectorId,
      duration
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
    return Ocpp16Action.GET_COMPOSITE_SCHEDULE;
  }

  /** Closed wire enumeration generated from v16 inline enumeration. */
  public enum ChargingRateUnit {
    A("A"), W("W");

    private final String wireValue;

    ChargingRateUnit(String wireValue) {
      this.wireValue = wireValue;
    }

    @JsonValue
    public String wireValue() {
      return wireValue;
    }

    @JsonCreator
    public static ChargingRateUnit fromWireValue(String wireValue) {
      Objects.requireNonNull(
        wireValue,
        "wireValue"
      );
      return switch (wireValue) {
        case "A" -> A;
        case "W" -> W;
        default -> throw new IllegalArgumentException(
          "Unknown ChargingRateUnit: " + wireValue
        );
      };
    }
  }
}
