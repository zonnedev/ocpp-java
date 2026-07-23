package io.github.zonnedev.ocpp.v201.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.github.zonnedev.ocpp.api.OcppVersion;
import io.github.zonnedev.ocpp.v201.Ocpp201Action;
import io.github.zonnedev.ocpp.v201.Ocpp201Request;
import io.github.zonnedev.ocpp.v201.model.type.CustomData;
import org.jspecify.annotations.Nullable;

/**
 * Immutable schema type generated from
 * schemas/v201/CancelReservationRequest.json.
 */
public record CancelReservationRequest(
  @Nullable CustomData customData,
  int reservationId
) implements Ocpp201Request {
  public CancelReservationRequest {

  }

  public static CancelReservationRequest of(int reservationId) {
    return new CancelReservationRequest(
      null,
      reservationId
    );
  }
  public static CancelReservationRequest of(
    @Nullable CustomData customData,
    int reservationId
  ) {
    return new CancelReservationRequest(
      customData,
      reservationId
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
    return Ocpp201Action.CANCEL_RESERVATION;
  }
}
