package io.github.zonnedev.ocpp.v201.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.github.zonnedev.ocpp.api.OcppVersion;
import io.github.zonnedev.ocpp.v201.Ocpp201Action;
import io.github.zonnedev.ocpp.v201.Ocpp201Request;
import io.github.zonnedev.ocpp.v201.model.type.Component;
import io.github.zonnedev.ocpp.v201.model.type.CustomData;
import io.github.zonnedev.ocpp.v201.model.type.MonitorEnum;
import io.github.zonnedev.ocpp.v201.model.type.Variable;
import java.util.List;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * Immutable schema type generated from
 * schemas/v201/SetVariableMonitoringRequest.json.
 */
public record SetVariableMonitoringRequest(
  @Nullable CustomData customData,
  List<SetMonitoringData> setMonitoringData
) implements Ocpp201Request {
  public SetVariableMonitoringRequest {
    Objects.requireNonNull(
      setMonitoringData,
      "setMonitoringData"
    );
    setMonitoringData = List.copyOf(setMonitoringData);
    if (setMonitoringData.size() < 1) {
      throw new IllegalArgumentException("setMonitoringData size violates schema constraints");
    }
  }

  public static SetVariableMonitoringRequest of(List<SetMonitoringData> setMonitoringData) {
    return new SetVariableMonitoringRequest(
      null,
      setMonitoringData
    );
  }
  public static SetVariableMonitoringRequest of(
    @Nullable CustomData customData,
    List<SetMonitoringData> setMonitoringData
  ) {
    return new SetVariableMonitoringRequest(
      customData,
      setMonitoringData
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
    return Ocpp201Action.SET_VARIABLE_MONITORING;
  }

  /**
   * Immutable schema type generated from v201 reusable definition
   * SetMonitoringDataType.
   */
  public record SetMonitoringData(
    Component component,
    @Nullable CustomData customData,
    @Nullable Integer id,
    int severity,
    @Nullable Boolean transaction,
    MonitorEnum type,
    double value,
    Variable variable
  ) {
    public SetMonitoringData {
      Objects.requireNonNull(
        component,
        "component"
      );
      Objects.requireNonNull(
        type,
        "type"
      );
      Objects.requireNonNull(
        variable,
        "variable"
      );
    }

    public static SetMonitoringData of(
      Component component,
      int severity,
      MonitorEnum type,
      double value,
      Variable variable
    ) {
      return new SetMonitoringData(
        component,
        null,
        null,
        severity,
        null,
        type,
        value,
        variable
      );
    }
    public static SetMonitoringData of(
      Component component,
      @Nullable CustomData customData,
      @Nullable Integer id,
      int severity,
      @Nullable Boolean transaction,
      MonitorEnum type,
      double value,
      Variable variable
    ) {
      return new SetMonitoringData(
        component,
        customData,
        id,
        severity,
        transaction,
        type,
        value,
        variable
      );
    }
  }
}
