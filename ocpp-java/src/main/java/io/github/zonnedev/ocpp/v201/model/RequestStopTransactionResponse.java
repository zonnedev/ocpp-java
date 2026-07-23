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
 * schemas/v201/RequestStopTransactionResponse.json.
 */
public record RequestStopTransactionResponse(
  @Nullable CustomData customData,
  RequestStartStopStatusEnum status,
  @Nullable StatusInfo statusInfo
) implements Ocpp201Response {
  public RequestStopTransactionResponse {
    Objects.requireNonNull(
      status,
      "status"
    );
  }

  public static RequestStopTransactionResponse of(RequestStartStopStatusEnum status) {
    return new RequestStopTransactionResponse(
      null,
      status,
      null
    );
  }
  public static RequestStopTransactionResponse of(
    @Nullable CustomData customData,
    RequestStartStopStatusEnum status,
    @Nullable StatusInfo statusInfo
  ) {
    return new RequestStopTransactionResponse(
      customData,
      status,
      statusInfo
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
