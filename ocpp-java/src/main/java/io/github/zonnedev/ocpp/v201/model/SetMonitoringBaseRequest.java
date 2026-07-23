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
 * Immutable schema type generated from
 * schemas/v201/SetMonitoringBaseRequest.json.
 */
public record SetMonitoringBaseRequest(
  @Nullable CustomData customData,
  MonitoringBaseEnum monitoringBase
) implements Ocpp201Request {
  public SetMonitoringBaseRequest {
    Objects.requireNonNull(
      monitoringBase,
      "monitoringBase"
    );
  }

  public static SetMonitoringBaseRequest of(MonitoringBaseEnum monitoringBase) {
    return new SetMonitoringBaseRequest(
      null,
      monitoringBase
    );
  }
  public static SetMonitoringBaseRequest of(
    @Nullable CustomData customData,
    MonitoringBaseEnum monitoringBase
  ) {
    return new SetMonitoringBaseRequest(
      customData,
      monitoringBase
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
    return Ocpp201Action.SET_MONITORING_BASE;
  }

  /**
   * Closed wire enumeration generated from v201 reusable definition
   * MonitoringBaseEnumType.
   */
  public enum MonitoringBaseEnum {
    ALL("All"), FACTORY_DEFAULT("FactoryDefault"), HARD_WIRED_ONLY("HardWiredOnly");

    private final String wireValue;

    MonitoringBaseEnum(String wireValue) {
      this.wireValue = wireValue;
    }

    @JsonValue
    public String wireValue() {
      return wireValue;
    }

    @JsonCreator
    public static MonitoringBaseEnum fromWireValue(String wireValue) {
      Objects.requireNonNull(
        wireValue,
        "wireValue"
      );
      return switch (wireValue) {
        case "All" -> ALL;
        case "FactoryDefault" -> FACTORY_DEFAULT;
        case "HardWiredOnly" -> HARD_WIRED_ONLY;
        default -> throw new IllegalArgumentException("Unknown MonitoringBaseEnum: " + wireValue);
      };
    }
  }
}
