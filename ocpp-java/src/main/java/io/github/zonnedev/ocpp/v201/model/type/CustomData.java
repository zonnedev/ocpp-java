package io.github.zonnedev.ocpp.v201.model.type;

import java.util.Objects;

/**
 * Immutable schema type generated from v201 reusable definition CustomDataType.
 */
public record CustomData(
  String vendorId
) {
  public CustomData {
    Objects.requireNonNull(
      vendorId,
      "vendorId"
    );
    if (vendorId.length() > 255) {
      throw new IllegalArgumentException("vendorId length violates schema constraints");
    }
  }

  public static CustomData of(String vendorId) {
    return new CustomData(vendorId);
  }
}
