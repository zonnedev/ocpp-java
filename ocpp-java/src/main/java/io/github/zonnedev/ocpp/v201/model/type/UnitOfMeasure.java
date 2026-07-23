package io.github.zonnedev.ocpp.v201.model.type;

import org.jspecify.annotations.Nullable;

/**
 * Immutable schema type generated from v201 reusable definition
 * UnitOfMeasureType.
 */
public record UnitOfMeasure(
  @Nullable CustomData customData,
  @Nullable Integer multiplier,
  @Nullable String unit
) {
  public UnitOfMeasure {
    if (unit != null && (unit.length() > 20)) {
      throw new IllegalArgumentException("unit length violates schema constraints");
    }
  }

  public static UnitOfMeasure of() {
    return new UnitOfMeasure(
      null,
      null,
      null
    );
  }
  public static UnitOfMeasure of(
    @Nullable CustomData customData,
    @Nullable Integer multiplier,
    @Nullable String unit
  ) {
    return new UnitOfMeasure(
      customData,
      multiplier,
      unit
    );
  }
}
