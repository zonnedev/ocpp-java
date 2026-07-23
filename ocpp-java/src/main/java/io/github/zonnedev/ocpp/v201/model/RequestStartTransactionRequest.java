package io.github.zonnedev.ocpp.v201.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.github.zonnedev.ocpp.api.OcppVersion;
import io.github.zonnedev.ocpp.v201.Ocpp201Action;
import io.github.zonnedev.ocpp.v201.Ocpp201Request;
import io.github.zonnedev.ocpp.v201.model.type.ChargingProfile;
import io.github.zonnedev.ocpp.v201.model.type.CustomData;
import io.github.zonnedev.ocpp.v201.model.type.IdToken;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * Immutable schema type generated from
 * schemas/v201/RequestStartTransactionRequest.json.
 */
public record RequestStartTransactionRequest(
  @Nullable ChargingProfile chargingProfile,
  @Nullable CustomData customData,
  @Nullable Integer evseId,
  @Nullable IdToken groupIdToken,
  IdToken idToken,
  int remoteStartId
) implements Ocpp201Request {
  public RequestStartTransactionRequest {
    Objects.requireNonNull(
      idToken,
      "idToken"
    );
  }

  public static RequestStartTransactionRequest of(
    IdToken idToken,
    int remoteStartId
  ) {
    return new RequestStartTransactionRequest(
      null,
      null,
      null,
      null,
      idToken,
      remoteStartId
    );
  }
  public static RequestStartTransactionRequest of(
    @Nullable ChargingProfile chargingProfile,
    @Nullable CustomData customData,
    @Nullable Integer evseId,
    @Nullable IdToken groupIdToken,
    IdToken idToken,
    int remoteStartId
  ) {
    return new RequestStartTransactionRequest(
      chargingProfile,
      customData,
      evseId,
      groupIdToken,
      idToken,
      remoteStartId
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
