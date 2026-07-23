package io.github.zonnedev.ocpp.v201.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.github.zonnedev.ocpp.api.OcppVersion;
import io.github.zonnedev.ocpp.v201.Ocpp201Action;
import io.github.zonnedev.ocpp.v201.Ocpp201Request;
import io.github.zonnedev.ocpp.v201.model.type.ChargingLimitSourceEnum;
import io.github.zonnedev.ocpp.v201.model.type.ChargingProfile;
import io.github.zonnedev.ocpp.v201.model.type.CustomData;
import java.util.List;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * Immutable schema type generated from
 * schemas/v201/ReportChargingProfilesRequest.json.
 */
public record ReportChargingProfilesRequest(
  ChargingLimitSourceEnum chargingLimitSource,
  List<ChargingProfile> chargingProfile,
  @Nullable CustomData customData,
  int evseId,
  int requestId,
  @Nullable Boolean tbc
) implements Ocpp201Request {
  public ReportChargingProfilesRequest {
    Objects.requireNonNull(
      chargingLimitSource,
      "chargingLimitSource"
    );
    Objects.requireNonNull(
      chargingProfile,
      "chargingProfile"
    );
    chargingProfile = List.copyOf(chargingProfile);
    if (chargingProfile.size() < 1) {
      throw new IllegalArgumentException("chargingProfile size violates schema constraints");
    }
  }

  public static ReportChargingProfilesRequest of(
    ChargingLimitSourceEnum chargingLimitSource,
    List<ChargingProfile> chargingProfile,
    int evseId,
    int requestId
  ) {
    return new ReportChargingProfilesRequest(
      chargingLimitSource,
      chargingProfile,
      null,
      evseId,
      requestId,
      null
    );
  }
  public static ReportChargingProfilesRequest of(
    ChargingLimitSourceEnum chargingLimitSource,
    List<ChargingProfile> chargingProfile,
    @Nullable CustomData customData,
    int evseId,
    int requestId,
    @Nullable Boolean tbc
  ) {
    return new ReportChargingProfilesRequest(
      chargingLimitSource,
      chargingProfile,
      customData,
      evseId,
      requestId,
      tbc
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
    return Ocpp201Action.REPORT_CHARGING_PROFILES;
  }
}
