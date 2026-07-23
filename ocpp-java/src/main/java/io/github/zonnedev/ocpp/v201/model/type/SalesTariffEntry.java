package io.github.zonnedev.ocpp.v201.model.type;

import java.util.List;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * Immutable schema type generated from v201 reusable definition
 * SalesTariffEntryType.
 */
public record SalesTariffEntry(
  @Nullable List<ConsumptionCost> consumptionCost,
  @Nullable CustomData customData,
  @Nullable Integer ePriceLevel,
  RelativeTimeInterval relativeTimeInterval
) {
  public SalesTariffEntry {
    consumptionCost = consumptionCost == null ? null : List.copyOf(consumptionCost);
    if (consumptionCost != null && (consumptionCost.size() < 1 || consumptionCost.size() > 3)) {
      throw new IllegalArgumentException("consumptionCost size violates schema constraints");
    }
    Objects.requireNonNull(
      relativeTimeInterval,
      "relativeTimeInterval"
    );
  }

  public static SalesTariffEntry of(RelativeTimeInterval relativeTimeInterval) {
    return new SalesTariffEntry(
      null,
      null,
      null,
      relativeTimeInterval
    );
  }
  public static SalesTariffEntry of(
    @Nullable List<ConsumptionCost> consumptionCost,
    @Nullable CustomData customData,
    @Nullable Integer ePriceLevel,
    RelativeTimeInterval relativeTimeInterval
  ) {
    return new SalesTariffEntry(
      consumptionCost,
      customData,
      ePriceLevel,
      relativeTimeInterval
    );
  }
}
