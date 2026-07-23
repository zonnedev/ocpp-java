package io.github.zonnedev.ocpp.v201.model.type;

import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * Immutable schema type generated from v201 reusable definition
 * ComponentVariableType.
 */
public record ComponentVariable(
  Component component,
  @Nullable CustomData customData,
  @Nullable Variable variable
) {
  public ComponentVariable {
    Objects.requireNonNull(
      component,
      "component"
    );
  }

  public static ComponentVariable of(Component component) {
    return new ComponentVariable(
      component,
      null,
      null
    );
  }
  public static ComponentVariable of(
    Component component,
    @Nullable CustomData customData,
    @Nullable Variable variable
  ) {
    return new ComponentVariable(
      component,
      customData,
      variable
    );
  }
}
