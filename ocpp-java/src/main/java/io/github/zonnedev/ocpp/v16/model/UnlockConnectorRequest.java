package io.github.zonnedev.ocpp.v16.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.github.zonnedev.ocpp.api.OcppVersion;
import io.github.zonnedev.ocpp.v16.Ocpp16Action;
import io.github.zonnedev.ocpp.v16.Ocpp16Request;

/** Immutable schema type generated from schemas/v16/UnlockConnector.json. */
public record UnlockConnectorRequest(
  int connectorId
) implements Ocpp16Request {
  public UnlockConnectorRequest {

  }

  public static UnlockConnectorRequest of(int connectorId) {
    return new UnlockConnectorRequest(connectorId);
  }

  @JsonIgnore
  @Override
  public OcppVersion version() {
    return OcppVersion.OCPP_1_6_JSON;
  }

  @JsonIgnore
  @Override
  public Ocpp16Action action() {
    return Ocpp16Action.UNLOCK_CONNECTOR;
  }
}
