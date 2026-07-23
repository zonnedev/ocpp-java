package io.github.zonnedev.ocpp.v201.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.github.zonnedev.ocpp.api.OcppVersion;
import io.github.zonnedev.ocpp.v201.Ocpp201Action;
import io.github.zonnedev.ocpp.v201.Ocpp201Request;
import io.github.zonnedev.ocpp.v201.model.type.AttributeEnum;
import io.github.zonnedev.ocpp.v201.model.type.Component;
import io.github.zonnedev.ocpp.v201.model.type.CustomData;
import io.github.zonnedev.ocpp.v201.model.type.Variable;
import java.util.List;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * Immutable schema type generated from schemas/v201/GetVariablesRequest.json.
 */
public record GetVariablesRequest(
  @Nullable CustomData customData,
  List<GetVariableData> getVariableData
) implements Ocpp201Request {
  public GetVariablesRequest {
    Objects.requireNonNull(
      getVariableData,
      "getVariableData"
    );
    getVariableData = List.copyOf(getVariableData);
    if (getVariableData.size() < 1) {
      throw new IllegalArgumentException("getVariableData size violates schema constraints");
    }
  }

  public static GetVariablesRequest of(List<GetVariableData> getVariableData) {
    return new GetVariablesRequest(
      null,
      getVariableData
    );
  }
  public static GetVariablesRequest of(
    @Nullable CustomData customData,
    List<GetVariableData> getVariableData
  ) {
    return new GetVariablesRequest(
      customData,
      getVariableData
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
    return Ocpp201Action.GET_VARIABLES;
  }

  /**
   * Immutable schema type generated from v201 reusable definition
   * GetVariableDataType.
   */
  public record GetVariableData(
    @Nullable AttributeEnum attributeType,
    Component component,
    @Nullable CustomData customData,
    Variable variable
  ) {
    public GetVariableData {
      Objects.requireNonNull(
        component,
        "component"
      );
      Objects.requireNonNull(
        variable,
        "variable"
      );
    }

    public static GetVariableData of(
      Component component,
      Variable variable
    ) {
      return new GetVariableData(
        null,
        component,
        null,
        variable
      );
    }
    public static GetVariableData of(
      @Nullable AttributeEnum attributeType,
      Component component,
      @Nullable CustomData customData,
      Variable variable
    ) {
      return new GetVariableData(
        attributeType,
        component,
        customData,
        variable
      );
    }
  }
}
