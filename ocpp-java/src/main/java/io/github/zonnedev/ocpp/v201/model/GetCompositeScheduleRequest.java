package io.github.zonnedev.ocpp.v201.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.github.zonnedev.ocpp.api.OcppVersion;
import io.github.zonnedev.ocpp.v201.Ocpp201Action;
import io.github.zonnedev.ocpp.v201.Ocpp201Request;
import io.github.zonnedev.ocpp.v201.model.type.ChargingRateUnitEnum;
import io.github.zonnedev.ocpp.v201.model.type.CustomData;
import org.jspecify.annotations.Nullable;

/**
 * Immutable schema type generated from
 * schemas/v201/GetCompositeScheduleRequest.json.
 */
public record GetCompositeScheduleRequest(
  @Nullable ChargingRateUnitEnum chargingRateUnit,
  @Nullable CustomData customData,
  int duration,
  int evseId
) implements Ocpp201Request {
  public GetCompositeScheduleRequest {

  }

  public static GetCompositeScheduleRequest of(
    int duration,
    int evseId
  ) {
    return new GetCompositeScheduleRequest(
      null,
      null,
      duration,
      evseId
    );
  }
  public static GetCompositeScheduleRequest of(
    @Nullable ChargingRateUnitEnum chargingRateUnit,
    @Nullable CustomData customData,
    int duration,
    int evseId
  ) {
    return new GetCompositeScheduleRequest(
      chargingRateUnit,
      customData,
      duration,
      evseId
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
    return Ocpp201Action.GET_COMPOSITE_SCHEDULE;
  }
}
