package io.github.zonnedev.ocpp.v201.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.github.zonnedev.ocpp.api.OcppVersion;
import io.github.zonnedev.ocpp.v201.Ocpp201Action;
import io.github.zonnedev.ocpp.v201.Ocpp201Request;
import io.github.zonnedev.ocpp.v201.model.type.ChargingLimitSourceEnum;
import io.github.zonnedev.ocpp.v201.model.type.ChargingProfilePurposeEnum;
import io.github.zonnedev.ocpp.v201.model.type.CustomData;
import java.util.List;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * Immutable schema type generated from
 * schemas/v201/GetChargingProfilesRequest.json.
 */
public record GetChargingProfilesRequest(
  ChargingProfileCriterion chargingProfile,
  @Nullable CustomData customData,
  @Nullable Integer evseId,
  int requestId
) implements Ocpp201Request {
  public GetChargingProfilesRequest {
    Objects.requireNonNull(
      chargingProfile,
      "chargingProfile"
    );
  }

  public static GetChargingProfilesRequest of(
    ChargingProfileCriterion chargingProfile,
    int requestId
  ) {
    return new GetChargingProfilesRequest(
      chargingProfile,
      null,
      null,
      requestId
    );
  }
  public static GetChargingProfilesRequest of(
    ChargingProfileCriterion chargingProfile,
    @Nullable CustomData customData,
    @Nullable Integer evseId,
    int requestId
  ) {
    return new GetChargingProfilesRequest(
      chargingProfile,
      customData,
      evseId,
      requestId
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
    return Ocpp201Action.GET_CHARGING_PROFILES;
  }

  /**
   * Immutable schema type generated from v201 reusable definition
   * ChargingProfileCriterionType.
   */
  public record ChargingProfileCriterion(
    @Nullable List<ChargingLimitSourceEnum> chargingLimitSource,
    @Nullable List<Integer> chargingProfileId,
    @Nullable ChargingProfilePurposeEnum chargingProfilePurpose,
    @Nullable CustomData customData,
    @Nullable Integer stackLevel
  ) {
    public ChargingProfileCriterion {
      chargingLimitSource = chargingLimitSource == null ? null : List.copyOf(chargingLimitSource);
      if (chargingLimitSource != null
        && (chargingLimitSource.size() < 1 || chargingLimitSource.size() > 4)) {
        throw new IllegalArgumentException("chargingLimitSource size violates schema constraints");
      }
      chargingProfileId = chargingProfileId == null ? null : List.copyOf(chargingProfileId);
      if (chargingProfileId != null && (chargingProfileId.size() < 1)) {
        throw new IllegalArgumentException("chargingProfileId size violates schema constraints");
      }
    }

    public static ChargingProfileCriterion of() {
      return new ChargingProfileCriterion(
        null,
        null,
        null,
        null,
        null
      );
    }
    public static ChargingProfileCriterion of(
      @Nullable List<ChargingLimitSourceEnum> chargingLimitSource,
      @Nullable List<Integer> chargingProfileId,
      @Nullable ChargingProfilePurposeEnum chargingProfilePurpose,
      @Nullable CustomData customData,
      @Nullable Integer stackLevel
    ) {
      return new ChargingProfileCriterion(
        chargingLimitSource,
        chargingProfileId,
        chargingProfilePurpose,
        customData,
        stackLevel
      );
    }
  }
}
