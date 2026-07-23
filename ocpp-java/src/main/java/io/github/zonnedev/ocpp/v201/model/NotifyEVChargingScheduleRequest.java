package io.github.zonnedev.ocpp.v201.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.github.zonnedev.ocpp.api.OcppVersion;
import io.github.zonnedev.ocpp.v201.Ocpp201Action;
import io.github.zonnedev.ocpp.v201.Ocpp201Request;
import io.github.zonnedev.ocpp.v201.model.type.ChargingSchedule;
import io.github.zonnedev.ocpp.v201.model.type.CustomData;
import java.time.Instant;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * Immutable schema type generated from
 * schemas/v201/NotifyEVChargingScheduleRequest.json.
 */
public record NotifyEVChargingScheduleRequest(
  ChargingSchedule chargingSchedule,
  @Nullable CustomData customData,
  int evseId,
  Instant timeBase
) implements Ocpp201Request {
  public NotifyEVChargingScheduleRequest {
    Objects.requireNonNull(
      chargingSchedule,
      "chargingSchedule"
    );
    Objects.requireNonNull(
      timeBase,
      "timeBase"
    );
  }

  public static NotifyEVChargingScheduleRequest of(
    ChargingSchedule chargingSchedule,
    int evseId,
    Instant timeBase
  ) {
    return new NotifyEVChargingScheduleRequest(
      chargingSchedule,
      null,
      evseId,
      timeBase
    );
  }
  public static NotifyEVChargingScheduleRequest of(
    ChargingSchedule chargingSchedule,
    @Nullable CustomData customData,
    int evseId,
    Instant timeBase
  ) {
    return new NotifyEVChargingScheduleRequest(
      chargingSchedule,
      customData,
      evseId,
      timeBase
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
    return Ocpp201Action.NOTIFY_EVCHARGING_SCHEDULE;
  }
}
