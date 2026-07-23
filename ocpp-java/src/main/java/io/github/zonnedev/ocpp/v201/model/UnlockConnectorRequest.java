package io.github.zonnedev.ocpp.v201.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.github.zonnedev.ocpp.api.OcppVersion;
import io.github.zonnedev.ocpp.v201.Ocpp201Action;
import io.github.zonnedev.ocpp.v201.Ocpp201Request;
import io.github.zonnedev.ocpp.v201.model.type.CustomData;
import org.jspecify.annotations.Nullable;

/**
 * Immutable schema type generated from
 * schemas/v201/UnlockConnectorRequest.json.
 */
public record UnlockConnectorRequest(
  int connectorId,
  @Nullable CustomData customData,
  int evseId
) implements Ocpp201Request {
  public UnlockConnectorRequest {

  }

  public static UnlockConnectorRequest of(
    int connectorId,
    int evseId
  ) {
    return new UnlockConnectorRequest(
      connectorId,
      null,
      evseId
    );
  }
  public static UnlockConnectorRequest of(
    int connectorId,
    @Nullable CustomData customData,
    int evseId
  ) {
    return new UnlockConnectorRequest(
      connectorId,
      customData,
      evseId
    );
  }

  @JsonIgnore
  @Override
  public OcppVersion version() {
    return OcppVersion.OCPP_2_0_1;
  }

  @JsonIgnore
  @Override
  public Ocpp201Action action() {
    return Ocpp201Action.UNLOCK_CONNECTOR;
  }
}
