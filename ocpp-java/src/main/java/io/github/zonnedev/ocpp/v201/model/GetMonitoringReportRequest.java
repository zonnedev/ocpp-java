package io.github.zonnedev.ocpp.v201.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.zonnedev.ocpp.api.OcppVersion;
import io.github.zonnedev.ocpp.v201.Ocpp201Action;
import io.github.zonnedev.ocpp.v201.Ocpp201Request;
import io.github.zonnedev.ocpp.v201.model.type.ComponentVariable;
import io.github.zonnedev.ocpp.v201.model.type.CustomData;
import java.util.List;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * Immutable schema type generated from
 * schemas/v201/GetMonitoringReportRequest.json.
 */
public record GetMonitoringReportRequest(
  @Nullable List<ComponentVariable> componentVariable,
  @Nullable CustomData customData,
  @Nullable List<MonitoringCriterionEnum> monitoringCriteria,
  int requestId
) implements Ocpp201Request {
  public GetMonitoringReportRequest {
    componentVariable = componentVariable == null ? null : List.copyOf(componentVariable);
    if (componentVariable != null && (componentVariable.size() < 1)) {
      throw new IllegalArgumentException("componentVariable size violates schema constraints");
    }
    monitoringCriteria = monitoringCriteria == null ? null : List.copyOf(monitoringCriteria);
    if (monitoringCriteria != null
      && (monitoringCriteria.size() < 1 || monitoringCriteria.size() > 3)) {
      throw new IllegalArgumentException("monitoringCriteria size violates schema constraints");
    }
  }

  public static GetMonitoringReportRequest of(int requestId) {
    return new GetMonitoringReportRequest(
      null,
      null,
      null,
      requestId
    );
  }
  public static GetMonitoringReportRequest of(
    @Nullable List<ComponentVariable> componentVariable,
    @Nullable CustomData customData,
    @Nullable List<MonitoringCriterionEnum> monitoringCriteria,
    int requestId
  ) {
    return new GetMonitoringReportRequest(
      componentVariable,
      customData,
      monitoringCriteria,
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
    return Ocpp201Action.GET_MONITORING_REPORT;
  }

  /**
   * Closed wire enumeration generated from v201 reusable definition
   * MonitoringCriterionEnumType.
   */
  public enum MonitoringCriterionEnum {
    THRESHOLD_MONITORING("ThresholdMonitoring"), DELTA_MONITORING(
      "DeltaMonitoring"
    ), PERIODIC_MONITORING("PeriodicMonitoring");

    private final String wireValue;

    MonitoringCriterionEnum(String wireValue) {
      this.wireValue = wireValue;
    }

    @JsonValue
    public String wireValue() {
      return wireValue;
    }

    @JsonCreator
    public static MonitoringCriterionEnum fromWireValue(String wireValue) {
      Objects.requireNonNull(
        wireValue,
        "wireValue"
      );
      return switch (wireValue) {
        case "ThresholdMonitoring" -> THRESHOLD_MONITORING;
        case "DeltaMonitoring" -> DELTA_MONITORING;
        case "PeriodicMonitoring" -> PERIODIC_MONITORING;
        default ->
          throw new IllegalArgumentException("Unknown MonitoringCriterionEnum: " + wireValue);
      };
    }
  }
}
