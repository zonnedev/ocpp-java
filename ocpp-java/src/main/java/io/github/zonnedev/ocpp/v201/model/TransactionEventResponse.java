package io.github.zonnedev.ocpp.v201.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.github.zonnedev.ocpp.api.OcppVersion;
import io.github.zonnedev.ocpp.v201.Ocpp201Action;
import io.github.zonnedev.ocpp.v201.Ocpp201Response;
import io.github.zonnedev.ocpp.v201.model.type.CustomData;
import io.github.zonnedev.ocpp.v201.model.type.IdTokenInfo;
import io.github.zonnedev.ocpp.v201.model.type.MessageContent;
import org.jspecify.annotations.Nullable;

/**
 * Immutable schema type generated from
 * schemas/v201/TransactionEventResponse.json.
 */
public record TransactionEventResponse(
  @Nullable Integer chargingPriority,
  @Nullable CustomData customData,
  @Nullable IdTokenInfo idTokenInfo,
  @Nullable Double totalCost,
  @Nullable MessageContent updatedPersonalMessage
) implements Ocpp201Response {
  public TransactionEventResponse {

  }

  public static TransactionEventResponse of() {
    return new TransactionEventResponse(
      null,
      null,
      null,
      null,
      null
    );
  }
  public static TransactionEventResponse of(
    @Nullable Integer chargingPriority,
    @Nullable CustomData customData,
    @Nullable IdTokenInfo idTokenInfo,
    @Nullable Double totalCost,
    @Nullable MessageContent updatedPersonalMessage
  ) {
    return new TransactionEventResponse(
      chargingPriority,
      customData,
      idTokenInfo,
      totalCost,
      updatedPersonalMessage
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
    return Ocpp201Action.TRANSACTION_EVENT;
  }
}
