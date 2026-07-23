package io.github.zonnedev.ocpp.v201.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.github.zonnedev.ocpp.api.OcppVersion;
import io.github.zonnedev.ocpp.v201.Ocpp201Action;
import io.github.zonnedev.ocpp.v201.Ocpp201Response;
import io.github.zonnedev.ocpp.v201.model.type.ChargingRateUnitEnum;
import io.github.zonnedev.ocpp.v201.model.type.ChargingSchedulePeriod;
import io.github.zonnedev.ocpp.v201.model.type.CustomData;
import io.github.zonnedev.ocpp.v201.model.type.GenericStatusEnum;
import io.github.zonnedev.ocpp.v201.model.type.StatusInfo;
import java.time.Instant;
import java.util.List;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * Immutable schema type generated from
 * schemas/v201/GetCompositeScheduleResponse.json.
 */
public record GetCompositeScheduleResponse(
  @Nullable CustomData customData,
  @Nullable CompositeSchedule schedule,
  GenericStatusEnum status,
  @Nullable StatusInfo statusInfo
) implements Ocpp201Response {
  public GetCompositeScheduleResponse {
    Objects.requireNonNull(
      status,
      "status"
    );
  }

  public static GetCompositeScheduleResponse of(GenericStatusEnum status) {
    return new GetCompositeScheduleResponse(
      null,
      null,
      status,
      null
    );
  }
  public static GetCompositeScheduleResponse of(
    @Nullable CustomData customData,
    @Nullable CompositeSchedule schedule,
    GenericStatusEnum status,
    @Nullable StatusInfo statusInfo
  ) {
    return new GetCompositeScheduleResponse(
      customData,
      schedule,
      status,
      statusInfo
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

  /**
   * Immutable schema type generated from v201 reusable definition
   * CompositeScheduleType.
   */
  public record CompositeSchedule(
    ChargingRateUnitEnum chargingRateUnit,
    List<ChargingSchedulePeriod> chargingSchedulePeriod,
    @Nullable CustomData customData,
    int duration,
    int evseId,
    Instant scheduleStart
  ) {
    public CompositeSchedule {
      Objects.requireNonNull(
        chargingRateUnit,
        "chargingRateUnit"
      );
      Objects.requireNonNull(
        chargingSchedulePeriod,
        "chargingSchedulePeriod"
      );
      chargingSchedulePeriod = List.copyOf(chargingSchedulePeriod);
      if (chargingSchedulePeriod.size() < 1) {
        throw new IllegalArgumentException(
          "chargingSchedulePeriod size violates schema constraints"
        );
      }
      Objects.requireNonNull(
        scheduleStart,
        "scheduleStart"
      );
    }

    public static CompositeSchedule of(
      ChargingRateUnitEnum chargingRateUnit,
      List<ChargingSchedulePeriod> chargingSchedulePeriod,
      int duration,
      int evseId,
      Instant scheduleStart
    ) {
      return new CompositeSchedule(
        chargingRateUnit,
        chargingSchedulePeriod,
        null,
        duration,
        evseId,
        scheduleStart
      );
    }
    public static CompositeSchedule of(
      ChargingRateUnitEnum chargingRateUnit,
      List<ChargingSchedulePeriod> chargingSchedulePeriod,
      @Nullable CustomData customData,
      int duration,
      int evseId,
      Instant scheduleStart
    ) {
      return new CompositeSchedule(
        chargingRateUnit,
        chargingSchedulePeriod,
        customData,
        duration,
        evseId,
        scheduleStart
      );
    }
  }
}
