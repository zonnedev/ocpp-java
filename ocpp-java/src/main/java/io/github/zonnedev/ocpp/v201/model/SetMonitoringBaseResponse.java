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
 * schemas/v201/SetMonitoringBaseResponse.json.
 */
public record SetMonitoringBaseResponse(
  @Nullable CustomData customData,
  GenericDeviceModelStatusEnum status,
  @Nullable StatusInfo statusInfo
) implements Ocpp201Response {
  public SetMonitoringBaseResponse {
    Objects.requireNonNull(
      status,
      "status"
    );
  }

  public static SetMonitoringBaseResponse of(GenericDeviceModelStatusEnum status) {
    return new SetMonitoringBaseResponse(
      null,
      status,
      null
    );
  }
  public static SetMonitoringBaseResponse of(
    @Nullable CustomData customData,
    GenericDeviceModelStatusEnum status,
    @Nullable StatusInfo statusInfo
  ) {
    return new SetMonitoringBaseResponse(
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
    return Ocpp201Action.SET_MONITORING_BASE;
  }
}
