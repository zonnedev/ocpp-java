package io.github.zonnedev.ocpp.v201.model.type;

import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * Immutable schema type generated from v201 reusable definition
 * AdditionalInfoType.
 */
public record AdditionalInfo(
  String additionalIdToken,
  @Nullable CustomData customData,
  String type
) {
  public AdditionalInfo {
    Objects.requireNonNull(
      additionalIdToken,
      "additionalIdToken"
    );
    if (additionalIdToken.length() > 36) {
      throw new IllegalArgumentException("additionalIdToken length violates schema constraints");
    }
    Objects.requireNonNull(
      type,
      "type"
    );
    if (type.length() > 50) {
      throw new IllegalArgumentException("type length violates schema constraints");
    }
  }

  public static AdditionalInfo of(
    String additionalIdToken,
    String type
  ) {
    return new AdditionalInfo(
      additionalIdToken,
      null,
      type
    );
  }
  public static AdditionalInfo of(
    String additionalIdToken,
    @Nullable CustomData customData,
    String type
  ) {
    return new AdditionalInfo(
      additionalIdToken,
      customData,
      type
    );
  }
}
