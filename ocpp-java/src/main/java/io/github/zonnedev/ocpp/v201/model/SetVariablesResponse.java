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
 * Immutable schema type generated from schemas/v201/SetVariablesResponse.json.
 */
public record SetVariablesResponse(
  @Nullable CustomData customData,
  List<SetVariableResult> setVariableResult
) implements Ocpp201Response {
  public SetVariablesResponse {
    Objects.requireNonNull(
      setVariableResult,
      "setVariableResult"
    );
    setVariableResult = List.copyOf(setVariableResult);
    if (setVariableResult.size() < 1) {
      throw new IllegalArgumentException("setVariableResult size violates schema constraints");
    }
  }

  public static SetVariablesResponse of(List<SetVariableResult> setVariableResult) {
    return new SetVariablesResponse(
      null,
      setVariableResult
    );
  }
  public static SetVariablesResponse of(
    @Nullable CustomData customData,
    List<SetVariableResult> setVariableResult
  ) {
    return new SetVariablesResponse(
      customData,
      setVariableResult
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
   * SetVariableResultType.
   */
  public record SetVariableResult(
    SetVariableStatusEnum attributeStatus,
    @Nullable StatusInfo attributeStatusInfo,
    @Nullable AttributeEnum attributeType,
    Component component,
    @Nullable CustomData customData,
    Variable variable
  ) {
    public SetVariableResult {
      Objects.requireNonNull(
        attributeStatus,
        "attributeStatus"
      );
      Objects.requireNonNull(
        component,
        "component"
      );
      Objects.requireNonNull(
        variable,
        "variable"
      );
    }

    public static SetVariableResult of(
      SetVariableStatusEnum attributeStatus,
      Component component,
      Variable variable
    ) {
      return new SetVariableResult(
        attributeStatus,
        null,
        null,
        component,
        null,
        variable
      );
    }
    public static SetVariableResult of(
      SetVariableStatusEnum attributeStatus,
      @Nullable StatusInfo attributeStatusInfo,
      @Nullable AttributeEnum attributeType,
      Component component,
      @Nullable CustomData customData,
      Variable variable
    ) {
      return new SetVariableResult(
        attributeStatus,
        attributeStatusInfo,
        attributeType,
        component,
        customData,
        variable
      );
    }

    /**
     * Closed wire enumeration generated from v201 reusable definition
     * SetVariableStatusEnumType.
     */
    public enum SetVariableStatusEnum {
      ACCEPTED("Accepted"), REJECTED("Rejected"), UNKNOWN_COMPONENT(
        "UnknownComponent"
      ), UNKNOWN_VARIABLE(
        "UnknownVariable"
      ), NOT_SUPPORTED_ATTRIBUTE_TYPE(
        "NotSupportedAttributeType"
      ), REBOOT_REQUIRED("RebootRequired");

      private final String wireValue;

      SetVariableStatusEnum(String wireValue) {
        this.wireValue = wireValue;
      }

      @JsonValue
      public String wireValue() {
        return wireValue;
      }

      @JsonCreator
      public static SetVariableStatusEnum fromWireValue(String wireValue) {
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
          case "RebootRequired" -> REBOOT_REQUIRED;
          default ->
            throw new IllegalArgumentException("Unknown SetVariableStatusEnum: " + wireValue);
        };
      }
    }
  }
}
