package io.github.zonnedev.ocpp.v201.model.type;

import java.time.Instant;
import java.util.List;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * Immutable schema type generated from v201 reusable definition
 * ChargingScheduleType.
 */
public record ChargingSchedule(
  ChargingRateUnitEnum chargingRateUnit,
  List<ChargingSchedulePeriod> chargingSchedulePeriod,
  @Nullable CustomData customData,
  @Nullable Integer duration,
  int id,
  @Nullable Double minChargingRate,
  @Nullable SalesTariff salesTariff,
  @Nullable Instant startSchedule
) {
  public ChargingSchedule {
    Objects.requireNonNull(
      chargingRateUnit,
      "chargingRateUnit"
    );
    Objects.requireNonNull(
      chargingSchedulePeriod,
      "chargingSchedulePeriod"
    );
    chargingSchedulePeriod = List.copyOf(chargingSchedulePeriod);
    if (chargingSchedulePeriod.size() < 1 || chargingSchedulePeriod.size() > 1024) {
      throw new IllegalArgumentException("chargingSchedulePeriod size violates schema constraints");
    }
  }

  public static ChargingSchedule of(
    ChargingRateUnitEnum chargingRateUnit,
    List<ChargingSchedulePeriod> chargingSchedulePeriod,
    int id
  ) {
    return new ChargingSchedule(
      chargingRateUnit,
      chargingSchedulePeriod,
      null,
      null,
      id,
      null,
      null,
      null
    );
  }
  public static ChargingSchedule of(
    ChargingRateUnitEnum chargingRateUnit,
    List<ChargingSchedulePeriod> chargingSchedulePeriod,
    @Nullable CustomData customData,
    @Nullable Integer duration,
    int id,
    @Nullable Double minChargingRate,
    @Nullable SalesTariff salesTariff,
    @Nullable Instant startSchedule
  ) {
    return new ChargingSchedule(
      chargingRateUnit,
      chargingSchedulePeriod,
      customData,
      duration,
      id,
      minChargingRate,
      salesTariff,
      startSchedule
    );
  }
}
