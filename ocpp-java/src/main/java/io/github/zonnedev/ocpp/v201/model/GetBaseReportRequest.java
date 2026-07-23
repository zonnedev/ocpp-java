package io.github.zonnedev.ocpp.v201.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.zonnedev.ocpp.api.OcppVersion;
import io.github.zonnedev.ocpp.v201.Ocpp201Action;
import io.github.zonnedev.ocpp.v201.Ocpp201Request;
import io.github.zonnedev.ocpp.v201.model.type.CustomData;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * Immutable schema type generated from schemas/v201/GetBaseReportRequest.json.
 */
public record GetBaseReportRequest(
  @Nullable CustomData customData,
  ReportBaseEnum reportBase,
  int requestId
) implements Ocpp201Request {
  public GetBaseReportRequest {
    Objects.requireNonNull(
      reportBase,
      "reportBase"
    );
  }

  public static GetBaseReportRequest of(
    ReportBaseEnum reportBase,
    int requestId
  ) {
    return new GetBaseReportRequest(
      null,
      reportBase,
      requestId
    );
  }
  public static GetBaseReportRequest of(
    @Nullable CustomData customData,
    ReportBaseEnum reportBase,
    int requestId
  ) {
    return new GetBaseReportRequest(
      customData,
      reportBase,
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
    return Ocpp201Action.GET_BASE_REPORT;
  }

  /**
   * Closed wire enumeration generated from v201 reusable definition
   * ReportBaseEnumType.
   */
  public enum ReportBaseEnum {
    CONFIGURATION_INVENTORY("ConfigurationInventory"), FULL_INVENTORY(
      "FullInventory"
    ), SUMMARY_INVENTORY("SummaryInventory");

    private final String wireValue;

    ReportBaseEnum(String wireValue) {
      this.wireValue = wireValue;
    }

    @JsonValue
    public String wireValue() {
      return wireValue;
    }

    @JsonCreator
    public static ReportBaseEnum fromWireValue(String wireValue) {
      Objects.requireNonNull(
        wireValue,
        "wireValue"
      );
      return switch (wireValue) {
        case "ConfigurationInventory" -> CONFIGURATION_INVENTORY;
        case "FullInventory" -> FULL_INVENTORY;
        case "SummaryInventory" -> SUMMARY_INVENTORY;
        default -> throw new IllegalArgumentException("Unknown ReportBaseEnum: " + wireValue);
      };
    }
  }
}
