package io.github.zonnedev.ocpp.v201.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.github.zonnedev.ocpp.api.OcppVersion;
import io.github.zonnedev.ocpp.v201.Ocpp201Action;
import io.github.zonnedev.ocpp.v201.Ocpp201Response;
import io.github.zonnedev.ocpp.v201.model.type.CustomData;
import org.jspecify.annotations.Nullable;

/**
 * Immutable schema type generated from
 * schemas/v201/NotifyChargingLimitResponse.json.
 */
public record NotifyChargingLimitResponse(
  @Nullable CustomData customData
) implements Ocpp201Response {
  public NotifyChargingLimitResponse {

  }

  public static NotifyChargingLimitResponse of() {
    return new NotifyChargingLimitResponse(null);
  }
  public static NotifyChargingLimitResponse of(@Nullable CustomData customData) {
    return new NotifyChargingLimitResponse(customData);
  }

  @JsonIgnore
  @Override
  public OcppVersion version() {
    return OcppVersion.OCPP_2_0_1;
  }

  @JsonIgnore
  @Override
  public Ocpp201Action action() {
    return Ocpp201Action.NOTIFY_CHARGING_LIMIT;
  }
}
