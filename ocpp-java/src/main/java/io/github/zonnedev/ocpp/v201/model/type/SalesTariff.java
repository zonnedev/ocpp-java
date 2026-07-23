package io.github.zonnedev.ocpp.v201.model.type;

import java.util.List;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * Immutable schema type generated from v201 reusable definition
 * SalesTariffType.
 */
public record SalesTariff(
  @Nullable CustomData customData,
  int id,
  @Nullable Integer numEPriceLevels,
  @Nullable String salesTariffDescription,
  List<SalesTariffEntry> salesTariffEntry
) {
  public SalesTariff {
    if (salesTariffDescription != null && (salesTariffDescription.length() > 32)) {
      throw new IllegalArgumentException(
        "salesTariffDescription length violates schema constraints"
      );
    }
    Objects.requireNonNull(
      salesTariffEntry,
      "salesTariffEntry"
    );
    salesTariffEntry = List.copyOf(salesTariffEntry);
    if (salesTariffEntry.size() < 1 || salesTariffEntry.size() > 1024) {
      throw new IllegalArgumentException("salesTariffEntry size violates schema constraints");
    }
  }

  public static SalesTariff of(
    int id,
    List<SalesTariffEntry> salesTariffEntry
  ) {
    return new SalesTariff(
      null,
      id,
      null,
      null,
      salesTariffEntry
    );
  }
  public static SalesTariff of(
    @Nullable CustomData customData,
    int id,
    @Nullable Integer numEPriceLevels,
    @Nullable String salesTariffDescription,
    List<SalesTariffEntry> salesTariffEntry
  ) {
    return new SalesTariff(
      customData,
      id,
      numEPriceLevels,
      salesTariffDescription,
      salesTariffEntry
    );
  }
}
