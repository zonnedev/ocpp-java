package io.github.zonnedev.ocpp.v201.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.github.zonnedev.ocpp.api.OcppVersion;
import io.github.zonnedev.ocpp.v201.Ocpp201Action;
import io.github.zonnedev.ocpp.v201.Ocpp201Request;
import io.github.zonnedev.ocpp.v201.model.type.CustomData;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * Immutable schema type generated from
 * schemas/v201/RequestStopTransactionRequest.json.
 */
public record RequestStopTransactionRequest(
  @Nullable CustomData customData,
  String transactionId
) implements Ocpp201Request {
  public RequestStopTransactionRequest {
    Objects.requireNonNull(
      transactionId,
      "transactionId"
    );
    if (transactionId.length() > 36) {
      throw new IllegalArgumentException("transactionId length violates schema constraints");
    }
  }

  public static RequestStopTransactionRequest of(String transactionId) {
    return new RequestStopTransactionRequest(
      null,
      transactionId
    );
  }
  public static RequestStopTransactionRequest of(
    @Nullable CustomData customData,
    String transactionId
  ) {
    return new RequestStopTransactionRequest(
      customData,
      transactionId
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
    return Ocpp201Action.REQUEST_STOP_TRANSACTION;
  }
}
