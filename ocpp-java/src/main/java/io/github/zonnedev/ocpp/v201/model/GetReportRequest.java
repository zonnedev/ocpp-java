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

/** Immutable schema type generated from schemas/v201/GetReportRequest.json. */
public record GetReportRequest(
  @Nullable List<ComponentCriterionEnum> componentCriteria,
  @Nullable List<ComponentVariable> componentVariable,
  @Nullable CustomData customData,
  int requestId
) implements Ocpp201Request {
  public GetReportRequest {
    componentCriteria = componentCriteria == null ? null : List.copyOf(componentCriteria);
    if (componentCriteria != null
      && (componentCriteria.size() < 1 || componentCriteria.size() > 4)) {
      throw new IllegalArgumentException("componentCriteria size violates schema constraints");
    }
    componentVariable = componentVariable == null ? null : List.copyOf(componentVariable);
    if (componentVariable != null && (componentVariable.size() < 1)) {
      throw new IllegalArgumentException("componentVariable size violates schema constraints");
    }
  }

  public static GetReportRequest of(int requestId) {
    return new GetReportRequest(
      null,
      null,
      null,
      requestId
    );
  }
  public static GetReportRequest of(
    @Nullable List<ComponentCriterionEnum> componentCriteria,
    @Nullable List<ComponentVariable> componentVariable,
    @Nullable CustomData customData,
    int requestId
  ) {
    return new GetReportRequest(
      componentCriteria,
      componentVariable,
      customData,
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
    return Ocpp201Action.GET_REPORT;
  }

  /**
   * Closed wire enumeration generated from v201 reusable definition
   * ComponentCriterionEnumType.
   */
  public enum ComponentCriterionEnum {
    ACTIVE("Active"), AVAILABLE("Available"), ENABLED("Enabled"), PROBLEM("Problem");

    private final String wireValue;

    ComponentCriterionEnum(String wireValue) {
      this.wireValue = wireValue;
    }

    @JsonValue
    public String wireValue() {
      return wireValue;
    }

    @JsonCreator
    public static ComponentCriterionEnum fromWireValue(String wireValue) {
      Objects.requireNonNull(
        wireValue,
        "wireValue"
      );
      return switch (wireValue) {
        case "Active" -> ACTIVE;
        case "Available" -> AVAILABLE;
        case "Enabled" -> ENABLED;
        case "Problem" -> PROBLEM;
        default ->
          throw new IllegalArgumentException("Unknown ComponentCriterionEnum: " + wireValue);
      };
    }
  }
}
