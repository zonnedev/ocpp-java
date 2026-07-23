package io.github.zonnedev.ocpp.v201.model.type;

import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * Immutable schema type generated from v201 reusable definition StatusInfoType.
 */
public record StatusInfo(
  @Nullable String additionalInfo,
  @Nullable CustomData customData,
  String reasonCode
) {
  public StatusInfo {
    if (additionalInfo != null && (additionalInfo.length() > 512)) {
      throw new IllegalArgumentException("additionalInfo length violates schema constraints");
    }
    Objects.requireNonNull(
      reasonCode,
      "reasonCode"
    );
    if (reasonCode.length() > 20) {
      throw new IllegalArgumentException("reasonCode length violates schema constraints");
    }
  }

  public static StatusInfo of(String reasonCode) {
    return new StatusInfo(
      null,
      null,
      reasonCode
    );
  }
  public static StatusInfo of(
    @Nullable String additionalInfo,
    @Nullable CustomData customData,
    String reasonCode
  ) {
    return new StatusInfo(
      additionalInfo,
      customData,
      reasonCode
    );
  }
}
