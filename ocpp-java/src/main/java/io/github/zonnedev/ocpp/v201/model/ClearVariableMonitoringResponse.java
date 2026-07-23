package io.github.zonnedev.ocpp.v201.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.zonnedev.ocpp.api.OcppVersion;
import io.github.zonnedev.ocpp.v201.Ocpp201Action;
import io.github.zonnedev.ocpp.v201.Ocpp201Response;
import io.github.zonnedev.ocpp.v201.model.type.CustomData;
import io.github.zonnedev.ocpp.v201.model.type.StatusInfo;
import java.util.List;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * Immutable schema type generated from
 * schemas/v201/ClearVariableMonitoringResponse.json.
 */
public record ClearVariableMonitoringResponse(
  List<ClearMonitoringResult> clearMonitoringResult,
  @Nullable CustomData customData
) implements Ocpp201Response {
  public ClearVariableMonitoringResponse {
    Objects.requireNonNull(
      clearMonitoringResult,
      "clearMonitoringResult"
    );
    clearMonitoringResult = List.copyOf(clearMonitoringResult);
    if (clearMonitoringResult.size() < 1) {
      throw new IllegalArgumentException("clearMonitoringResult size violates schema constraints");
    }
  }

  public static ClearVariableMonitoringResponse of(
    List<ClearMonitoringResult> clearMonitoringResult
  ) {
    return new ClearVariableMonitoringResponse(
      clearMonitoringResult,
      null
    );
  }
  public static ClearVariableMonitoringResponse of(
    List<ClearMonitoringResult> clearMonitoringResult,
    @Nullable CustomData customData
  ) {
    return new ClearVariableMonitoringResponse(
      clearMonitoringResult,
      customData
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
    return Ocpp201Action.CLEAR_VARIABLE_MONITORING;
  }

  /**
   * Immutable schema type generated from v201 reusable definition
   * ClearMonitoringResultType.
   */
  public record ClearMonitoringResult(
    @Nullable CustomData customData,
    int id,
    ClearMonitoringStatusEnum status,
    @Nullable StatusInfo statusInfo
  ) {
    public ClearMonitoringResult {
      Objects.requireNonNull(
        status,
        "status"
      );
    }

    public static ClearMonitoringResult of(
      int id,
      ClearMonitoringStatusEnum status
    ) {
      return new ClearMonitoringResult(
        null,
        id,
        status,
        null
      );
    }
    public static ClearMonitoringResult of(
      @Nullable CustomData customData,
      int id,
      ClearMonitoringStatusEnum status,
      @Nullable StatusInfo statusInfo
    ) {
      return new ClearMonitoringResult(
        customData,
        id,
        status,
        statusInfo
      );
    }

    /**
     * Closed wire enumeration generated from v201 reusable definition
     * ClearMonitoringStatusEnumType.
     */
    public enum ClearMonitoringStatusEnum {
      ACCEPTED("Accepted"), REJECTED("Rejected"), NOT_FOUND("NotFound");

      private final String wireValue;

      ClearMonitoringStatusEnum(String wireValue) {
        this.wireValue = wireValue;
      }

      @JsonValue
      public String wireValue() {
        return wireValue;
      }

      @JsonCreator
      public static ClearMonitoringStatusEnum fromWireValue(String wireValue) {
        Objects.requireNonNull(
          wireValue,
          "wireValue"
        );
        return switch (wireValue) {
          case "Accepted" -> ACCEPTED;
          case "Rejected" -> REJECTED;
          case "NotFound" -> NOT_FOUND;
          default ->
            throw new IllegalArgumentException("Unknown ClearMonitoringStatusEnum: " + wireValue);
        };
      }
    }
  }
}
