package io.github.zonnedev.ocpp.v201.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.github.zonnedev.ocpp.api.OcppVersion;
import io.github.zonnedev.ocpp.v201.Ocpp201Action;
import io.github.zonnedev.ocpp.v201.Ocpp201Request;
import io.github.zonnedev.ocpp.v201.model.type.CustomData;
import org.jspecify.annotations.Nullable;

/**
 * Immutable schema type generated from
 * schemas/v201/SetMonitoringLevelRequest.json.
 */
public record SetMonitoringLevelRequest(
  @Nullable CustomData customData,
  int severity
) implements Ocpp201Request {
  public SetMonitoringLevelRequest {

  }

  public static SetMonitoringLevelRequest of(int severity) {
    return new SetMonitoringLevelRequest(
      null,
      severity
    );
  }
  public static SetMonitoringLevelRequest of(
    @Nullable CustomData customData,
    int severity
  ) {
    return new SetMonitoringLevelRequest(
      customData,
      severity
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
    return Ocpp201Action.SET_MONITORING_LEVEL;
  }
}
