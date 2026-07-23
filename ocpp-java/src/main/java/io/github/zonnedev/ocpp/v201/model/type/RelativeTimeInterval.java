package io.github.zonnedev.ocpp.v201.model.type;

import org.jspecify.annotations.Nullable;

/**
 * Immutable schema type generated from v201 reusable definition
 * RelativeTimeIntervalType.
 */
public record RelativeTimeInterval(
  @Nullable CustomData customData,
  @Nullable Integer duration,
  int start
) {
  public RelativeTimeInterval {

  }

  public static RelativeTimeInterval of(int start) {
    return new RelativeTimeInterval(
      null,
      null,
      start
    );
  }
  public static RelativeTimeInterval of(
    @Nullable CustomData customData,
    @Nullable Integer duration,
    int start
  ) {
    return new RelativeTimeInterval(
      customData,
      duration,
      start
    );
  }
}
