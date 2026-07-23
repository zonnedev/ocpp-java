package io.github.zonnedev.ocpp.v201.model.type;

import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * Immutable schema type generated from v201 reusable definition ComponentType.
 */
public record Component(
  @Nullable CustomData customData,
  @Nullable EVSE evse,
  @Nullable String instance,
  String name
) {
  public Component {
    if (instance != null && (instance.length() > 50)) {
      throw new IllegalArgumentException("instance length violates schema constraints");
    }
    Objects.requireNonNull(
      name,
      "name"
    );
    if (name.length() > 50) {
      throw new IllegalArgumentException("name length violates schema constraints");
    }
  }

  public static Component of(String name) {
    return new Component(
      null,
      null,
      null,
      name
    );
  }
  public static Component of(
    @Nullable CustomData customData,
    @Nullable EVSE evse,
    @Nullable String instance,
    String name
  ) {
    return new Component(
      customData,
      evse,
      instance,
      name
    );
  }
}
