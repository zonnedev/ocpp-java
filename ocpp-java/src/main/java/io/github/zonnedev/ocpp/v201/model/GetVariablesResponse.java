package io.github.zonnedev.ocpp.v201.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.zonnedev.ocpp.api.OcppVersion;
import io.github.zonnedev.ocpp.v201.Ocpp201Action;
import io.github.zonnedev.ocpp.v201.Ocpp201Response;
import io.github.zonnedev.ocpp.v201.model.type.AttributeEnum;
import io.github.zonnedev.ocpp.v201.model.type.Component;
import io.github.zonnedev.ocpp.v201.model.type.CustomData;
import io.github.zonnedev.ocpp.v201.model.type.StatusInfo;
import io.github.zonnedev.ocpp.v201.model.type.Variable;
import java.util.List;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * Immutable schema type generated from schemas/v201/GetVariablesResponse.json.
 */
public record GetVariablesResponse(
  @Nullable CustomData customData,
  List<GetVariableResult> getVariableResult
) implements Ocpp201Response {
  public GetVariablesResponse {
    Objects.requireNonNull(
      getVariableResult,
      "getVariableResult"
    );
    getVariableResult = List.copyOf(getVariableResult);
    if (getVariableResult.size() < 1) {
      throw new IllegalArgumentException("getVariableResult size violates schema constraints");
    }
  }

  public static GetVariablesResponse of(List<GetVariableResult> getVariableResult) {
    return new GetVariablesResponse(
      null,
      getVariableResult
    );
  }
  public static GetVariablesResponse of(
    @Nullable CustomData customData,
    List<GetVariableResult> getVariableResult
  ) {
    return new GetVariablesResponse(
      customData,
      getVariableResult
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
   * GetVariableResultType.
   */
  public record GetVariableResult(
    GetVariableStatusEnum attributeStatus,
    @Nullable StatusInfo attributeStatusInfo,
    @Nullable AttributeEnum attributeType,
    @Nullable String attributeValue,
    Component component,
    @Nullable CustomData customData,
    Variable variable
  ) {
    public GetVariableResult {
      Objects.requireNonNull(
        attributeStatus,
        "attributeStatus"
      );
      if (attributeValue != null && (attributeValue.length() > 2500)) {
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

    public static GetVariableResult of(
      GetVariableStatusEnum attributeStatus,
      Component component,
      Variable variable
    ) {
      return new GetVariableResult(
        attributeStatus,
        null,
        null,
        null,
        component,
        null,
        variable
      );
    }
    public static GetVariableResult of(
      GetVariableStatusEnum attributeStatus,
      @Nullable StatusInfo attributeStatusInfo,
      @Nullable AttributeEnum attributeType,
      @Nullable String attributeValue,
      Component component,
      @Nullable CustomData customData,
      Variable variable
    ) {
      return new GetVariableResult(
        attributeStatus,
        attributeStatusInfo,
        attributeType,
        attributeValue,
        component,
        customData,
        variable
      );
    }

    /**
     * Closed wire enumeration generated from v201 reusable definition
     * GetVariableStatusEnumType.
     */
    public enum GetVariableStatusEnum {
      ACCEPTED("Accepted"), REJECTED("Rejected"), UNKNOWN_COMPONENT(
        "UnknownComponent"
      ), UNKNOWN_VARIABLE(
        "UnknownVariable"
      ), NOT_SUPPORTED_ATTRIBUTE_TYPE("NotSupportedAttributeType");

      private final String wireValue;

      GetVariableStatusEnum(String wireValue) {
        this.wireValue = wireValue;
      }

      @JsonValue
      public String wireValue() {
        return wireValue;
      }

      @JsonCreator
      public static GetVariableStatusEnum fromWireValue(String wireValue) {
        Objects.requireNonNull(
          wireValue,
          "wireValue"
        );
        return switch (wireValue) {
          case "Accepted" -> ACCEPTED;
          case "Rejected" -> REJECTED;
          case "UnknownComponent" -> UNKNOWN_COMPONENT;
          case "UnknownVariable" -> UNKNOWN_VARIABLE;
          case "NotSupportedAttributeType" -> NOT_SUPPORTED_ATTRIBUTE_TYPE;
          default ->
            throw new IllegalArgumentException("Unknown GetVariableStatusEnum: " + wireValue);
        };
      }
    }
  }
}
