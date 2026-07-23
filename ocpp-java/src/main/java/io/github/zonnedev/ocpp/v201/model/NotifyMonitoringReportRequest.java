package io.github.zonnedev.ocpp.v201.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.github.zonnedev.ocpp.api.OcppVersion;
import io.github.zonnedev.ocpp.v201.Ocpp201Action;
import io.github.zonnedev.ocpp.v201.Ocpp201Request;
import io.github.zonnedev.ocpp.v201.model.type.Component;
import io.github.zonnedev.ocpp.v201.model.type.CustomData;
import io.github.zonnedev.ocpp.v201.model.type.MonitorEnum;
import io.github.zonnedev.ocpp.v201.model.type.Variable;
import java.time.Instant;
import java.util.List;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * Immutable schema type generated from
 * schemas/v201/NotifyMonitoringReportRequest.json.
 */
public record NotifyMonitoringReportRequest(
  @Nullable CustomData customData,
  Instant generatedAt,
  @Nullable List<MonitoringData> monitor,
  int requestId,
  int seqNo,
  @Nullable Boolean tbc
) implements Ocpp201Request {
  public NotifyMonitoringReportRequest {
    Objects.requireNonNull(
      generatedAt,
      "generatedAt"
    );
    monitor = monitor == null ? null : List.copyOf(monitor);
    if (monitor != null && (monitor.size() < 1)) {
      throw new IllegalArgumentException("monitor size violates schema constraints");
    }
  }

  public static NotifyMonitoringReportRequest of(
    Instant generatedAt,
    int requestId,
    int seqNo
  ) {
    return new NotifyMonitoringReportRequest(
      null,
      generatedAt,
      null,
      requestId,
      seqNo,
      null
    );
  }
  public static NotifyMonitoringReportRequest of(
    @Nullable CustomData customData,
    Instant generatedAt,
    @Nullable List<MonitoringData> monitor,
    int requestId,
    int seqNo,
    @Nullable Boolean tbc
  ) {
    return new NotifyMonitoringReportRequest(
      customData,
      generatedAt,
      monitor,
      requestId,
      seqNo,
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
    return Ocpp201Action.NOTIFY_MONITORING_REPORT;
  }

  /**
   * Immutable schema type generated from v201 reusable definition
   * MonitoringDataType.
   */
  public record MonitoringData(
    Component component,
    @Nullable CustomData customData,
    Variable variable,
    List<VariableMonitoring> variableMonitoring
  ) {
    public MonitoringData {
      Objects.requireNonNull(
        component,
        "component"
      );
      Objects.requireNonNull(
        variable,
        "variable"
      );
      Objects.requireNonNull(
        variableMonitoring,
        "variableMonitoring"
      );
      variableMonitoring = List.copyOf(variableMonitoring);
      if (variableMonitoring.size() < 1) {
        throw new IllegalArgumentException("variableMonitoring size violates schema constraints");
      }
    }

    public static MonitoringData of(
      Component component,
      Variable variable,
      List<VariableMonitoring> variableMonitoring
    ) {
      return new MonitoringData(
        component,
        null,
        variable,
        variableMonitoring
      );
    }
    public static MonitoringData of(
      Component component,
      @Nullable CustomData customData,
      Variable variable,
      List<VariableMonitoring> variableMonitoring
    ) {
      return new MonitoringData(
        component,
        customData,
        variable,
        variableMonitoring
      );
    }

    /**
     * Immutable schema type generated from v201 reusable definition
     * VariableMonitoringType.
     */
    public record VariableMonitoring(
      @Nullable CustomData customData,
      int id,
      int severity,
      boolean transaction,
      MonitorEnum type,
      double value
    ) {
      public VariableMonitoring {
        Objects.requireNonNull(
          type,
          "type"
        );
      }

      public static VariableMonitoring of(
        int id,
        int severity,
        boolean transaction,
        MonitorEnum type,
        double value
      ) {
        return new VariableMonitoring(
          null,
          id,
          severity,
          transaction,
          type,
          value
        );
      }
      public static VariableMonitoring of(
        @Nullable CustomData customData,
        int id,
        int severity,
        boolean transaction,
        MonitorEnum type,
        double value
      ) {
        return new VariableMonitoring(
          customData,
          id,
          severity,
          transaction,
          type,
          value
        );
      }
    }
  }
}
