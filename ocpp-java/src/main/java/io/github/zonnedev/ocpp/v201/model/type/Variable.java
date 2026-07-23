package io.github.zonnedev.ocpp.v201.model.type;

import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * Immutable schema type generated from v201 reusable definition VariableType.
 */
public record Variable(
  @Nullable CustomData customData,
  @Nullable String instance,
  String name
) {
  public Variable {
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

  public static Variable of(String name) {
    return new Variable(
      null,
      null,
      name
    );
  }
  public static Variable of(
    @Nullable CustomData customData,
    @Nullable String instance,
    String name
  ) {
    return new Variable(
      customData,
      instance,
      name
    );
  }
}
