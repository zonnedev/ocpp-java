package io.github.zonnedev.ocpp.v201.model.type;

import java.util.List;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * Immutable schema type generated from v201 reusable definition
 * ConsumptionCostType.
 */
public record ConsumptionCost(
  List<Cost> cost,
  @Nullable CustomData customData,
  double startValue
) {
  public ConsumptionCost {
    Objects.requireNonNull(
      cost,
      "cost"
    );
    cost = List.copyOf(cost);
    if (cost.size() < 1 || cost.size() > 3) {
      throw new IllegalArgumentException("cost size violates schema constraints");
    }
  }

  public static ConsumptionCost of(
    List<Cost> cost,
    double startValue
  ) {
    return new ConsumptionCost(
      cost,
      null,
      startValue
    );
  }
  public static ConsumptionCost of(
    List<Cost> cost,
    @Nullable CustomData customData,
    double startValue
  ) {
    return new ConsumptionCost(
      cost,
      customData,
      startValue
    );
  }
}
