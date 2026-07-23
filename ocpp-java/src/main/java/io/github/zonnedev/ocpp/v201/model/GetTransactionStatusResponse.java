package io.github.zonnedev.ocpp.v201.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.github.zonnedev.ocpp.api.OcppVersion;
import io.github.zonnedev.ocpp.v201.Ocpp201Action;
import io.github.zonnedev.ocpp.v201.Ocpp201Response;
import io.github.zonnedev.ocpp.v201.model.type.CustomData;
import org.jspecify.annotations.Nullable;

/**
 * Immutable schema type generated from
 * schemas/v201/GetTransactionStatusResponse.json.
 */
public record GetTransactionStatusResponse(
  @Nullable CustomData customData,
  boolean messagesInQueue,
  @Nullable Boolean ongoingIndicator
) implements Ocpp201Response {
  public GetTransactionStatusResponse {

  }

  public static GetTransactionStatusResponse of(boolean messagesInQueue) {
    return new GetTransactionStatusResponse(
      null,
      messagesInQueue,
      null
    );
  }
  public static GetTransactionStatusResponse of(
    @Nullable CustomData customData,
    boolean messagesInQueue,
    @Nullable Boolean ongoingIndicator
  ) {
    return new GetTransactionStatusResponse(
      customData,
      messagesInQueue,
      ongoingIndicator
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
