package io.github.zonnedev.ocpp.v201.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.github.zonnedev.ocpp.api.OcppVersion;
import io.github.zonnedev.ocpp.v201.Ocpp201Action;
import io.github.zonnedev.ocpp.v201.Ocpp201Response;
import io.github.zonnedev.ocpp.v201.model.type.CustomData;
import io.github.zonnedev.ocpp.v201.model.type.RequestStartStopStatusEnum;
import io.github.zonnedev.ocpp.v201.model.type.StatusInfo;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * Immutable schema type generated from
 * schemas/v201/RequestStartTransactionResponse.json.
 */
public record RequestStartTransactionResponse(
  @Nullable CustomData customData,
  RequestStartStopStatusEnum status,
  @Nullable StatusInfo statusInfo,
  @Nullable String transactionId
) implements Ocpp201Response {
  public RequestStartTransactionResponse {
    Objects.requireNonNull(
      status,
      "status"
    );
    if (transactionId != null && (transactionId.length() > 36)) {
      throw new IllegalArgumentException("transactionId length violates schema constraints");
    }
  }

  public static RequestStartTransactionResponse of(RequestStartStopStatusEnum status) {
    return new RequestStartTransactionResponse(
      null,
      status,
      null,
      null
    );
  }
  public static RequestStartTransactionResponse of(
    @Nullable CustomData customData,
    RequestStartStopStatusEnum status,
    @Nullable StatusInfo statusInfo,
    @Nullable String transactionId
  ) {
    return new RequestStartTransactionResponse(
      customData,
      status,
      statusInfo,
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
    return Ocpp201Action.REQUEST_START_TRANSACTION;
  }
}
