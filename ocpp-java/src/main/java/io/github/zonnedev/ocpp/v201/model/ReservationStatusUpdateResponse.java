package io.github.zonnedev.ocpp.v201.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.github.zonnedev.ocpp.api.OcppVersion;
import io.github.zonnedev.ocpp.v201.Ocpp201Action;
import io.github.zonnedev.ocpp.v201.Ocpp201Response;
import io.github.zonnedev.ocpp.v201.model.type.CustomData;
import org.jspecify.annotations.Nullable;

/**
 * Immutable schema type generated from
 * schemas/v201/ReservationStatusUpdateResponse.json.
 */
public record ReservationStatusUpdateResponse(
  @Nullable CustomData customData
) implements Ocpp201Response {
  public ReservationStatusUpdateResponse {

  }

  public static ReservationStatusUpdateResponse of() {
    return new ReservationStatusUpdateResponse(null);
  }
  public static ReservationStatusUpdateResponse of(@Nullable CustomData customData) {
    return new ReservationStatusUpdateResponse(customData);
  }

  @JsonIgnore
  @Override
  public OcppVersion version() {
    return OcppVersion.OCPP_2_0_1;
  }

  @JsonIgnore
  @Override
  public Ocpp201Action action() {
    return Ocpp201Action.RESERVATION_STATUS_UPDATE;
  }
}
