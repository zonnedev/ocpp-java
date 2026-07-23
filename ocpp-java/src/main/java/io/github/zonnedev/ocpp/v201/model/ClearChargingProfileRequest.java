package io.github.zonnedev.ocpp.v201.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.github.zonnedev.ocpp.api.OcppVersion;
import io.github.zonnedev.ocpp.v201.Ocpp201Action;
import io.github.zonnedev.ocpp.v201.Ocpp201Request;
import io.github.zonnedev.ocpp.v201.model.type.ChargingProfilePurposeEnum;
import io.github.zonnedev.ocpp.v201.model.type.CustomData;
import org.jspecify.annotations.Nullable;

/**
 * Immutable schema type generated from
 * schemas/v201/ClearChargingProfileRequest.json.
 */
public record ClearChargingProfileRequest(
  @Nullable ClearChargingProfile chargingProfileCriteria,
  @Nullable Integer chargingProfileId,
  @Nullable CustomData customData
) implements Ocpp201Request {
  public ClearChargingProfileRequest {

  }

  public static ClearChargingProfileRequest of() {
    return new ClearChargingProfileRequest(
      null,
      null,
      null
    );
  }
  public static ClearChargingProfileRequest of(
    @Nullable ClearChargingProfile chargingProfileCriteria,
    @Nullable Integer chargingProfileId,
    @Nullable CustomData customData
  ) {
    return new ClearChargingProfileRequest(
      chargingProfileCriteria,
      chargingProfileId,
      customData
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
    return Ocpp201Action.CLEAR_CHARGING_PROFILE;
  }

  /**
   * Immutable schema type generated from v201 reusable definition
   * ClearChargingProfileType.
   */
  public record ClearChargingProfile(
    @Nullable ChargingProfilePurposeEnum chargingProfilePurpose,
    @Nullable CustomData customData,
    @Nullable Integer evseId,
    @Nullable Integer stackLevel
  ) {
    public ClearChargingProfile {

    }

    public static ClearChargingProfile of() {
      return new ClearChargingProfile(
        null,
        null,
        null,
        null
      );
    }
    public static ClearChargingProfile of(
      @Nullable ChargingProfilePurposeEnum chargingProfilePurpose,
      @Nullable CustomData customData,
      @Nullable Integer evseId,
      @Nullable Integer stackLevel
    ) {
      return new ClearChargingProfile(
        chargingProfilePurpose,
        customData,
        evseId,
        stackLevel
      );
    }
  }
}
