package io.github.zonnedev.ocpp.v201.model.type;

import org.jspecify.annotations.Nullable;

/** Immutable schema type generated from v201 reusable definition EVSEType. */
public record EVSE(
  @Nullable Integer connectorId,
  @Nullable CustomData customData,
  int id
) {
  public EVSE {

  }

  public static EVSE of(int id) {
    return new EVSE(
      null,
      null,
      id
    );
  }
  public static EVSE of(
    @Nullable Integer connectorId,
    @Nullable CustomData customData,
    int id
  ) {
    return new EVSE(
      connectorId,
      customData,
      id
    );
  }
}
