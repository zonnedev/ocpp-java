package io.github.zonnedev.ocpp.v201.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.github.zonnedev.ocpp.api.OcppVersion;
import io.github.zonnedev.ocpp.v201.Ocpp201Action;
import io.github.zonnedev.ocpp.v201.Ocpp201Request;
import io.github.zonnedev.ocpp.v201.model.type.ChargingProfile;
import io.github.zonnedev.ocpp.v201.model.type.CustomData;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * Immutable schema type generated from
 * schemas/v201/SetChargingProfileRequest.json.
 */
public record SetChargingProfileRequest(
  ChargingProfile chargingProfile,
  @Nullable CustomData customData,
  int evseId
) implements Ocpp201Request {
  public SetChargingProfileRequest {
    Objects.requireNonNull(
      chargingProfile,
      "chargingProfile"
    );
  }

  public static SetChargingProfileRequest of(
    ChargingProfile chargingProfile,
    int evseId
  ) {
    return new SetChargingProfileRequest(
      chargingProfile,
      null,
      evseId
    );
  }
  public static SetChargingProfileRequest of(
    ChargingProfile chargingProfile,
    @Nullable CustomData customData,
    int evseId
  ) {
    return new SetChargingProfileRequest(
      chargingProfile,
      customData,
      evseId
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
    return Ocpp201Action.SET_CHARGING_PROFILE;
  }
}
