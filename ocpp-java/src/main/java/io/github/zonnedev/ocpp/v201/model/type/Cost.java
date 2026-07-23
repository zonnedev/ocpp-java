package io.github.zonnedev.ocpp.v201.model.type;

import java.util.Objects;
import org.jspecify.annotations.Nullable;

/** Immutable schema type generated from v201 reusable definition CostType. */
public record Cost(
  int amount,
  @Nullable Integer amountMultiplier,
  CostKindEnum costKind,
  @Nullable CustomData customData
) {
  public Cost {
    Objects.requireNonNull(
      costKind,
      "costKind"
    );
  }

  public static Cost of(
    int amount,
    CostKindEnum costKind
  ) {
    return new Cost(
      amount,
      null,
      costKind,
      null
    );
  }
  public static Cost of(
    int amount,
    @Nullable Integer amountMultiplier,
    CostKindEnum costKind,
    @Nullable CustomData customData
  ) {
    return new Cost(
      amount,
      amountMultiplier,
      costKind,
      customData
    );
  }
}
