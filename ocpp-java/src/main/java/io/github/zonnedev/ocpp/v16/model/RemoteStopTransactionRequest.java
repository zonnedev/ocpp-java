package io.github.zonnedev.ocpp.v16.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.github.zonnedev.ocpp.api.OcppVersion;
import io.github.zonnedev.ocpp.v16.Ocpp16Action;
import io.github.zonnedev.ocpp.v16.Ocpp16Request;

/**
 * Immutable schema type generated from schemas/v16/RemoteStopTransaction.json.
 */
public record RemoteStopTransactionRequest(
  int transactionId
) implements Ocpp16Request {
  public RemoteStopTransactionRequest {

  }

  public static RemoteStopTransactionRequest of(int transactionId) {
    return new RemoteStopTransactionRequest(transactionId);
  }

  @JsonIgnore
  @Override
  public OcppVersion version() {
    return OcppVersion.OCPP_1_6_JSON;
  }

  @JsonIgnore
  @Override
  public Ocpp16Action action() {
    return Ocpp16Action.REMOTE_STOP_TRANSACTION;
  }
}
