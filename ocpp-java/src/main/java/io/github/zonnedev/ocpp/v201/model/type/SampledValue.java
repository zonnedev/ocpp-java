package io.github.zonnedev.ocpp.v201.model.type;

import org.jspecify.annotations.Nullable;

/**
 * Immutable schema type generated from v201 reusable definition
 * SampledValueType.
 */
public record SampledValue(
  @Nullable ReadingContextEnum context,
  @Nullable CustomData customData,
  @Nullable LocationEnum location,
  @Nullable MeasurandEnum measurand,
  @Nullable PhaseEnum phase,
  @Nullable SignedMeterValue signedMeterValue,
  @Nullable UnitOfMeasure unitOfMeasure,
  double value
) {
  public SampledValue {

  }

  public static SampledValue of(double value) {
    return new SampledValue(
      null,
      null,
      null,
      null,
      null,
      null,
      null,
      value
    );
  }
  public static SampledValue of(
    @Nullable ReadingContextEnum context,
    @Nullable CustomData customData,
    @Nullable LocationEnum location,
    @Nullable MeasurandEnum measurand,
    @Nullable PhaseEnum phase,
    @Nullable SignedMeterValue signedMeterValue,
    @Nullable UnitOfMeasure unitOfMeasure,
    double value
  ) {
    return new SampledValue(
      context,
      customData,
      location,
      measurand,
      phase,
      signedMeterValue,
      unitOfMeasure,
      value
    );
  }
}
