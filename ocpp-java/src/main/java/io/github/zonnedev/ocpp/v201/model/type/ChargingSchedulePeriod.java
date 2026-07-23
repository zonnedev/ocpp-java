package io.github.zonnedev.ocpp.v201.model.type;

import org.jspecify.annotations.Nullable;

/**
 * Immutable schema type generated from v201 reusable definition
 * ChargingSchedulePeriodType.
 */
public record ChargingSchedulePeriod(
  @Nullable CustomData customData,
  double limit,
  @Nullable Integer numberPhases,
  @Nullable Integer phaseToUse,
  int startPeriod
) {
  public ChargingSchedulePeriod {

  }

  public static ChargingSchedulePeriod of(
    double limit,
    int startPeriod
  ) {
    return new ChargingSchedulePeriod(
      null,
      limit,
      null,
      null,
      startPeriod
    );
  }
  public static ChargingSchedulePeriod of(
    @Nullable CustomData customData,
    double limit,
    @Nullable Integer numberPhases,
    @Nullable Integer phaseToUse,
    int startPeriod
  ) {
    return new ChargingSchedulePeriod(
      customData,
      limit,
      numberPhases,
      phaseToUse,
      startPeriod
    );
  }
}
