package io.github.zonnedev.ocpp.v201.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.github.zonnedev.ocpp.api.OcppVersion;
import io.github.zonnedev.ocpp.v201.Ocpp201Action;
import io.github.zonnedev.ocpp.v201.Ocpp201Response;
import io.github.zonnedev.ocpp.v201.model.type.CustomData;
import org.jspecify.annotations.Nullable;

/**
 * Immutable schema type generated from schemas/v201/NotifyReportResponse.json.
 */
public record NotifyReportResponse(
  @Nullable CustomData customData
) implements Ocpp201Response {
  public NotifyReportResponse {

  }

  public static NotifyReportResponse of() {
    return new NotifyReportResponse(null);
  }
  public static NotifyReportResponse of(@Nullable CustomData customData) {
    return new NotifyReportResponse(customData);
  }

  @JsonIgnore
  @Override
  public OcppVersion version() {
    return OcppVersion.OCPP_2_0_1;
  }

  @JsonIgnore
  @Override
  public Ocpp201Action action() {
    return Ocpp201Action.NOTIFY_REPORT;
  }
}
