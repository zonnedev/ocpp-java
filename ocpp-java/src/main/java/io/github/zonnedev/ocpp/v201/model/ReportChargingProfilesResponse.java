package io.github.zonnedev.ocpp.v201.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.github.zonnedev.ocpp.api.OcppVersion;
import io.github.zonnedev.ocpp.v201.Ocpp201Action;
import io.github.zonnedev.ocpp.v201.Ocpp201Response;
import io.github.zonnedev.ocpp.v201.model.type.CustomData;
import org.jspecify.annotations.Nullable;

/**
 * Immutable schema type generated from
 * schemas/v201/ReportChargingProfilesResponse.json.
 */
public record ReportChargingProfilesResponse(
  @Nullable CustomData customData
) implements Ocpp201Response {
  public ReportChargingProfilesResponse {

  }

  public static ReportChargingProfilesResponse of() {
    return new ReportChargingProfilesResponse(null);
  }
  public static ReportChargingProfilesResponse of(@Nullable CustomData customData) {
    return new ReportChargingProfilesResponse(customData);
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
