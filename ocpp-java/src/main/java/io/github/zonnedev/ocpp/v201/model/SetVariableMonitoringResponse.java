package io.github.zonnedev.ocpp.v201.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.zonnedev.ocpp.api.OcppVersion;
import io.github.zonnedev.ocpp.v201.Ocpp201Action;
import io.github.zonnedev.ocpp.v201.Ocpp201Response;
import io.github.zonnedev.ocpp.v201.model.type.Component;
import io.github.zonnedev.ocpp.v201.model.type.CustomData;
import io.github.zonnedev.ocpp.v201.model.type.MonitorEnum;
import io.github.zonnedev.ocpp.v201.model.type.StatusInfo;
import io.github.zonnedev.ocpp.v201.model.type.Variable;
import java.util.List;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * Immutable schema type generated from
 * schemas/v201/SetVariableMonitoringResponse.json.
 */
public record SetVariableMonitoringResponse(
  @Nullable CustomData customData,
  List<SetMonitoringResult> setMonitoringResult
) implements Ocpp201Response {
  public SetVariableMonitoringResponse {
    Objects.requireNonNull(
      setMonitoringResult,
      "setMonitoringResult"
    );
    setMonitoringResult = List.copyOf(setMonitoringResult);
    if (setMonitoringResult.size() < 1) {
      throw new IllegalArgumentException("setMonitoringResult size violates schema constraints");
    }
  }

  public static SetVariableMonitoringResponse of(List<SetMonitoringResult> setMonitoringResult) {
    return new SetVariableMonitoringResponse(
      null,
      setMonitoringResult
    );
  }
  public static SetVariableMonitoringResponse of(
    @Nullable CustomData customData,
    List<SetMonitoringResult> setMonitoringResult
  ) {
    return new SetVariableMonitoringResponse(
      customData,
      setMonitoringResult
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
   * SetMonitoringResultType.
   */
  public record SetMonitoringResult(
    Component component,
    @Nullable CustomData customData,
    @Nullable Integer id,
    int severity,
    SetMonitoringStatusEnum status,
    @Nullable StatusInfo statusInfo,
    MonitorEnum type,
    Variable variable
  ) {
    public SetMonitoringResult {
      Objects.requireNonNull(
        component,
        "component"
      );
      Objects.requireNonNull(
        status,
        "status"
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

    public static SetMonitoringResult of(
      Component component,
      int severity,
      SetMonitoringStatusEnum status,
      MonitorEnum type,
      Variable variable
    ) {
      return new SetMonitoringResult(
        component,
        null,
        null,
        severity,
        status,
        null,
        type,
        variable
      );
    }
    public static SetMonitoringResult of(
      Component component,
      @Nullable CustomData customData,
      @Nullable Integer id,
      int severity,
      SetMonitoringStatusEnum status,
      @Nullable StatusInfo statusInfo,
      MonitorEnum type,
      Variable variable
    ) {
      return new SetMonitoringResult(
        component,
        customData,
        id,
        severity,
        status,
        statusInfo,
        type,
        variable
      );
    }

    /**
     * Closed wire enumeration generated from v201 reusable definition
     * SetMonitoringStatusEnumType.
     */
    public enum SetMonitoringStatusEnum {
      ACCEPTED("Accepted"), UNKNOWN_COMPONENT("UnknownComponent"), UNKNOWN_VARIABLE(
        "UnknownVariable"
      ), UNSUPPORTED_MONITOR_TYPE(
        "UnsupportedMonitorType"
      ), REJECTED("Rejected"), DUPLICATE("Duplicate");

      private final String wireValue;

      SetMonitoringStatusEnum(String wireValue) {
        this.wireValue = wireValue;
      }

      @JsonValue
      public String wireValue() {
        return wireValue;
      }

      @JsonCreator
      public static SetMonitoringStatusEnum fromWireValue(String wireValue) {
        Objects.requireNonNull(
          wireValue,
          "wireValue"
        );
        return switch (wireValue) {
          case "Accepted" -> ACCEPTED;
          case "UnknownComponent" -> UNKNOWN_COMPONENT;
          case "UnknownVariable" -> UNKNOWN_VARIABLE;
          case "UnsupportedMonitorType" -> UNSUPPORTED_MONITOR_TYPE;
          case "Rejected" -> REJECTED;
          case "Duplicate" -> DUPLICATE;
          default ->
            throw new IllegalArgumentException("Unknown SetMonitoringStatusEnum: " + wireValue);
        };
      }
    }
  }
}
