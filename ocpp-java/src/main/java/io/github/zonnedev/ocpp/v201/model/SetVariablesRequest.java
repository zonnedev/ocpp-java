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
 * Immutable schema type generated from schemas/v201/SetVariablesRequest.json.
 */
public record SetVariablesRequest(
  @Nullable CustomData customData,
  List<SetVariableData> setVariableData
) implements Ocpp201Request {
  public SetVariablesRequest {
    Objects.requireNonNull(
      setVariableData,
      "setVariableData"
    );
    setVariableData = List.copyOf(setVariableData);
    if (setVariableData.size() < 1) {
      throw new IllegalArgumentException("setVariableData size violates schema constraints");
    }
  }

  public static SetVariablesRequest of(List<SetVariableData> setVariableData) {
    return new SetVariablesRequest(
      null,
      setVariableData
    );
  }
  public static SetVariablesRequest of(
    @Nullable CustomData customData,
    List<SetVariableData> setVariableData
  ) {
    return new SetVariablesRequest(
      customData,
      setVariableData
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
    return Ocpp201Action.SET_VARIABLES;
  }

  /**
   * Immutable schema type generated from v201 reusable definition
   * SetVariableDataType.
   */
  public record SetVariableData(
    @Nullable AttributeEnum attributeType,
    String attributeValue,
    Component component,
    @Nullable CustomData customData,
    Variable variable
  ) {
    public SetVariableData {
      Objects.requireNonNull(
        attributeValue,
        "attributeValue"
      );
      if (attributeValue.length() > 1000) {
        throw new IllegalArgumentException("attributeValue length violates schema constraints");
      }
      Objects.requireNonNull(
        component,
        "component"
      );
      Objects.requireNonNull(
        variable,
        "variable"
      );
    }

    public static SetVariableData of(
      String attributeValue,
      Component component,
      Variable variable
    ) {
      return new SetVariableData(
        null,
        attributeValue,
        component,
        null,
        variable
      );
    }
    public static SetVariableData of(
      @Nullable AttributeEnum attributeType,
      String attributeValue,
      Component component,
      @Nullable CustomData customData,
      Variable variable
    ) {
      return new SetVariableData(
        attributeType,
        attributeValue,
        component,
        customData,
        variable
      );
    }
  }
}
