package io.github.zonnedev.ocpp.v201.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.github.zonnedev.ocpp.api.OcppVersion;
import io.github.zonnedev.ocpp.v201.Ocpp201Action;
import io.github.zonnedev.ocpp.v201.Ocpp201Request;
import io.github.zonnedev.ocpp.v201.model.type.CustomData;
import org.jspecify.annotations.Nullable;

/**
 * Immutable schema type generated from
 * schemas/v201/GetTransactionStatusRequest.json.
 */
public record GetTransactionStatusRequest(
  @Nullable CustomData customData,
  @Nullable String transactionId
) implements Ocpp201Request {
  public GetTransactionStatusRequest {
    if (transactionId != null && (transactionId.length() > 36)) {
      throw new IllegalArgumentException("transactionId length violates schema constraints");
    }
  }

  public static GetTransactionStatusRequest of() {
    return new GetTransactionStatusRequest(
      null,
      null
    );
  }
  public static GetTransactionStatusRequest of(
    @Nullable CustomData customData,
    @Nullable String transactionId
  ) {
    return new GetTransactionStatusRequest(
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
    return Ocpp201Action.GET_TRANSACTION_STATUS;
  }
}
