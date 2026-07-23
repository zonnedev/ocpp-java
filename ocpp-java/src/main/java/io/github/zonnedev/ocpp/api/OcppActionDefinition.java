package io.github.zonnedev.ocpp.api;

import java.util.Objects;

public record OcppActionDefinition<Q extends OcppRequest, S extends OcppResponse>(
  OcppAction action, Class<Q> requestType, Class<S> responseType
) {
  public OcppActionDefinition {
    Objects.requireNonNull(
      action,
      "action"
    );
    Objects.requireNonNull(
      requestType,
      "requestType"
    );
    Objects.requireNonNull(
      responseType,
      "responseType"
    );
    if (!action.requestType()
      .equals(requestType)
      || !action.responseType()
        .equals(responseType)) {
      throw new IllegalArgumentException("Types do not match action metadata");
    }
  }

  public static <Q extends OcppRequest, S extends OcppResponse> OcppActionDefinition<Q, S> of(
    OcppAction action,
    Class<Q> requestType,
    Class<S> responseType
  ) {
    return new OcppActionDefinition<>(
      action,
      requestType,
      responseType
    );
  }
}
