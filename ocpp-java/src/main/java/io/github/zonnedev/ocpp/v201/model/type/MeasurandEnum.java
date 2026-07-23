package io.github.zonnedev.ocpp.v201.model.type;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.Objects;

/**
 * Closed wire enumeration generated from v201 reusable definition
 * MeasurandEnumType.
 */
public enum MeasurandEnum {
  CURRENT_EXPORT("Current.Export"), CURRENT_IMPORT("Current.Import"), CURRENT_OFFERED(
    "Current.Offered"
  ), ENERGY_ACTIVE_EXPORT_REGISTER("Energy.Active.Export.Register"), ENERGY_ACTIVE_IMPORT_REGISTER(
    "Energy.Active.Import.Register"
  ), ENERGY_REACTIVE_EXPORT_REGISTER(
    "Energy.Reactive.Export.Register"
  ), ENERGY_REACTIVE_IMPORT_REGISTER(
    "Energy.Reactive.Import.Register"
  ), ENERGY_ACTIVE_EXPORT_INTERVAL("Energy.Active.Export.Interval"), ENERGY_ACTIVE_IMPORT_INTERVAL(
    "Energy.Active.Import.Interval"
  ), ENERGY_ACTIVE_NET("Energy.Active.Net"), ENERGY_REACTIVE_EXPORT_INTERVAL(
    "Energy.Reactive.Export.Interval"
  ), ENERGY_REACTIVE_IMPORT_INTERVAL("Energy.Reactive.Import.Interval"), ENERGY_REACTIVE_NET(
    "Energy.Reactive.Net"
  ), ENERGY_APPARENT_NET("Energy.Apparent.Net"), ENERGY_APPARENT_IMPORT(
    "Energy.Apparent.Import"
  ), ENERGY_APPARENT_EXPORT("Energy.Apparent.Export"), FREQUENCY("Frequency"), POWER_ACTIVE_EXPORT(
    "Power.Active.Export"
  ), POWER_ACTIVE_IMPORT("Power.Active.Import"), POWER_FACTOR("Power.Factor"), POWER_OFFERED(
    "Power.Offered"
  ), POWER_REACTIVE_EXPORT(
    "Power.Reactive.Export"
  ), POWER_REACTIVE_IMPORT("Power.Reactive.Import"), SO_C("SoC"), VOLTAGE("Voltage");

  private final String wireValue;

  MeasurandEnum(String wireValue) {
    this.wireValue = wireValue;
  }

  @JsonValue
  public String wireValue() {
    return wireValue;
  }

  @JsonCreator
  public static MeasurandEnum fromWireValue(String wireValue) {
    Objects.requireNonNull(
      wireValue,
      "wireValue"
    );
    return switch (wireValue) {
      case "Current.Export" -> CURRENT_EXPORT;
      case "Current.Import" -> CURRENT_IMPORT;
      case "Current.Offered" -> CURRENT_OFFERED;
      case "Energy.Active.Export.Register" -> ENERGY_ACTIVE_EXPORT_REGISTER;
      case "Energy.Active.Import.Register" -> ENERGY_ACTIVE_IMPORT_REGISTER;
      case "Energy.Reactive.Export.Register" -> ENERGY_REACTIVE_EXPORT_REGISTER;
      case "Energy.Reactive.Import.Register" -> ENERGY_REACTIVE_IMPORT_REGISTER;
      case "Energy.Active.Export.Interval" -> ENERGY_ACTIVE_EXPORT_INTERVAL;
      case "Energy.Active.Import.Interval" -> ENERGY_ACTIVE_IMPORT_INTERVAL;
      case "Energy.Active.Net" -> ENERGY_ACTIVE_NET;
      case "Energy.Reactive.Export.Interval" -> ENERGY_REACTIVE_EXPORT_INTERVAL;
      case "Energy.Reactive.Import.Interval" -> ENERGY_REACTIVE_IMPORT_INTERVAL;
      case "Energy.Reactive.Net" -> ENERGY_REACTIVE_NET;
      case "Energy.Apparent.Net" -> ENERGY_APPARENT_NET;
      case "Energy.Apparent.Import" -> ENERGY_APPARENT_IMPORT;
      case "Energy.Apparent.Export" -> ENERGY_APPARENT_EXPORT;
      case "Frequency" -> FREQUENCY;
      case "Power.Active.Export" -> POWER_ACTIVE_EXPORT;
      case "Power.Active.Import" -> POWER_ACTIVE_IMPORT;
      case "Power.Factor" -> POWER_FACTOR;
      case "Power.Offered" -> POWER_OFFERED;
      case "Power.Reactive.Export" -> POWER_REACTIVE_EXPORT;
      case "Power.Reactive.Import" -> POWER_REACTIVE_IMPORT;
      case "SoC" -> SO_C;
      case "Voltage" -> VOLTAGE;
      default -> throw new IllegalArgumentException("Unknown MeasurandEnum: " + wireValue);
    };
  }
}
