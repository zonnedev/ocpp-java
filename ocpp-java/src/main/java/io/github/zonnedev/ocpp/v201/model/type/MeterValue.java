package io.github.zonnedev.ocpp.v201.model.type;

import java.time.Instant;
import java.util.List;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * Immutable schema type generated from v201 reusable definition MeterValueType.
 */
public record MeterValue(
  @Nullable CustomData customData,
  List<SampledValue> sampledValue,
  Instant timestamp
) {
  public MeterValue {
    Objects.requireNonNull(
      sampledValue,
      "sampledValue"
    );
    sampledValue = List.copyOf(sampledValue);
    if (sampledValue.size() < 1) {
      throw new IllegalArgumentException("sampledValue size violates schema constraints");
    }
    Objects.requireNonNull(
      timestamp,
      "timestamp"
    );
  }

  public static MeterValue of(
    List<SampledValue> sampledValue,
    Instant timestamp
  ) {
    return new MeterValue(
      null,
      sampledValue,
      timestamp
    );
  }
  public static MeterValue of(
    @Nullable CustomData customData,
    List<SampledValue> sampledValue,
    Instant timestamp
  ) {
    return new MeterValue(
      customData,
      sampledValue,
      timestamp
    );
  }
}
