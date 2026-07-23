package io.github.zonnedev.ocpp.v201.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.github.zonnedev.ocpp.api.OcppVersion;
import io.github.zonnedev.ocpp.v201.Ocpp201Action;
import io.github.zonnedev.ocpp.v201.Ocpp201Response;
import io.github.zonnedev.ocpp.v201.model.type.CustomData;
import io.github.zonnedev.ocpp.v201.model.type.GenericDeviceModelStatusEnum;
import io.github.zonnedev.ocpp.v201.model.type.StatusInfo;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * Immutable schema type generated from
 * schemas/v201/GetMonitoringReportResponse.json.
 */
public record GetMonitoringReportResponse(
  @Nullable CustomData customData,
  GenericDeviceModelStatusEnum status,
  @Nullable StatusInfo statusInfo
) implements Ocpp201Response {
  public GetMonitoringReportResponse {
    Objects.requireNonNull(
      status,
      "status"
    );
  }

  public static GetMonitoringReportResponse of(GenericDeviceModelStatusEnum status) {
    return new GetMonitoringReportResponse(
      null,
      status,
      null
    );
  }
  public static GetMonitoringReportResponse of(
    @Nullable CustomData customData,
    GenericDeviceModelStatusEnum status,
    @Nullable StatusInfo statusInfo
  ) {
    return new GetMonitoringReportResponse(
      customData,
      status,
      statusInfo
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
    return Ocpp201Action.GET_MONITORING_REPORT;
  }
}
