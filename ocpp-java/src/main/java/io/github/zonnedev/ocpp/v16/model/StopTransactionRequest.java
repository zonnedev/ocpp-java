package io.github.zonnedev.ocpp.v16.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.zonnedev.ocpp.api.OcppVersion;
import io.github.zonnedev.ocpp.v16.Ocpp16Action;
import io.github.zonnedev.ocpp.v16.Ocpp16Request;
import java.time.Instant;
import java.util.List;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/** Immutable schema type generated from schemas/v16/StopTransaction.json. */
public record StopTransactionRequest(
  @Nullable String idTag,
  int meterStop,
  @Nullable Reason reason,
  Instant timestamp,
  @Nullable List<TransactionDataItem> transactionData,
  int transactionId
) implements Ocpp16Request {
  public StopTransactionRequest {
    if (idTag != null && (idTag.length() > 20)) {
      throw new IllegalArgumentException("idTag length violates schema constraints");
    }
    Objects.requireNonNull(
      timestamp,
      "timestamp"
    );
    transactionData = transactionData == null ? null : List.copyOf(transactionData);
  }

  public static StopTransactionRequest of(
    int meterStop,
    Instant timestamp,
    int transactionId
  ) {
    return new StopTransactionRequest(
      null,
      meterStop,
      null,
      timestamp,
      null,
      transactionId
    );
  }
  public static StopTransactionRequest of(
    @Nullable String idTag,
    int meterStop,
    @Nullable Reason reason,
    Instant timestamp,
    @Nullable List<TransactionDataItem> transactionData,
    int transactionId
  ) {
    return new StopTransactionRequest(
      idTag,
      meterStop,
      reason,
      timestamp,
      transactionData,
      transactionId
    );
  }

  @JsonIgnore
  @Override
  public OcppVersion version() {
    return OcppVersion.OCPP_1_6_JSON;
  }

  @JsonIgnore
  @Override
  public Ocpp16Action action() {
    return Ocpp16Action.STOP_TRANSACTION;
  }

  /** Closed wire enumeration generated from v16 inline enumeration. */
  public enum Reason {
    EMERGENCY_STOP("EmergencyStop"), EVDISCONNECTED("EVDisconnected"), HARD_RESET(
      "HardReset"
    ), LOCAL(
      "Local"
    ), OTHER("Other"), POWER_LOSS("PowerLoss"), REBOOT("Reboot"), REMOTE(
      "Remote"
    ), SOFT_RESET("SoftReset"), UNLOCK_COMMAND("UnlockCommand"), DE_AUTHORIZED("DeAuthorized");

    private final String wireValue;

    Reason(String wireValue) {
      this.wireValue = wireValue;
    }

    @JsonValue
    public String wireValue() {
      return wireValue;
    }

    @JsonCreator
    public static Reason fromWireValue(String wireValue) {
      Objects.requireNonNull(
        wireValue,
        "wireValue"
      );
      return switch (wireValue) {
        case "EmergencyStop" -> EMERGENCY_STOP;
        case "EVDisconnected" -> EVDISCONNECTED;
        case "HardReset" -> HARD_RESET;
        case "Local" -> LOCAL;
        case "Other" -> OTHER;
        case "PowerLoss" -> POWER_LOSS;
        case "Reboot" -> REBOOT;
        case "Remote" -> REMOTE;
        case "SoftReset" -> SOFT_RESET;
        case "UnlockCommand" -> UNLOCK_COMMAND;
        case "DeAuthorized" -> DE_AUTHORIZED;
        default ->
          throw new IllegalArgumentException("Unknown Reason: " + wireValue);
      };
    }
  }

  /**
   * Immutable schema type generated from schemas/v16/StopTransaction.json inline
   * object.
   */
  public record TransactionDataItem(
    List<SampledValueItem> sampledValue,
    Instant timestamp
  ) {
    public TransactionDataItem {
      Objects.requireNonNull(
        sampledValue,
        "sampledValue"
      );
      sampledValue = List.copyOf(sampledValue);
      Objects.requireNonNull(
        timestamp,
        "timestamp"
      );
    }

    public static TransactionDataItem of(
      List<SampledValueItem> sampledValue,
      Instant timestamp
    ) {
      return new TransactionDataItem(
        sampledValue,
        timestamp
      );
    }

    /**
     * Immutable schema type generated from schemas/v16/StopTransaction.json inline
     * object.
     */
    public record SampledValueItem(
      @Nullable Context context,
      @Nullable Format format,
      @Nullable Location location,
      @Nullable Measurand measurand,
      @Nullable Phase phase,
      @Nullable Unit unit,
      String value
    ) {
      public SampledValueItem {
        Objects.requireNonNull(
          value,
          "value"
        );
      }

      public static SampledValueItem of(String value) {
        return new SampledValueItem(
          null,
          null,
          null,
          null,
          null,
          null,
          value
        );
      }
      public static SampledValueItem of(
        @Nullable Context context,
        @Nullable Format format,
        @Nullable Location location,
        @Nullable Measurand measurand,
        @Nullable Phase phase,
        @Nullable Unit unit,
        String value
      ) {
        return new SampledValueItem(
          context,
          format,
          location,
          measurand,
          phase,
          unit,
          value
        );
      }

      /** Closed wire enumeration generated from v16 inline enumeration. */
      public enum Context {
        INTERRUPTION_BEGIN("Interruption.Begin"), INTERRUPTION_END(
          "Interruption.End"
        ), SAMPLE_CLOCK(
          "Sample.Clock"
        ), SAMPLE_PERIODIC("Sample.Periodic"), TRANSACTION_BEGIN(
          "Transaction.Begin"
        ), TRANSACTION_END("Transaction.End"), TRIGGER("Trigger"), OTHER("Other");

        private final String wireValue;

        Context(String wireValue) {
          this.wireValue = wireValue;
        }

        @JsonValue
        public String wireValue() {
          return wireValue;
        }

        @JsonCreator
        public static Context fromWireValue(
          String wireValue
        ) {
          Objects.requireNonNull(
            wireValue,
            "wireValue"
          );
          return switch (wireValue) {
            case "Interruption.Begin" -> INTERRUPTION_BEGIN;
            case "Interruption.End" -> INTERRUPTION_END;
            case "Sample.Clock" -> SAMPLE_CLOCK;
            case "Sample.Periodic" -> SAMPLE_PERIODIC;
            case "Transaction.Begin" -> TRANSACTION_BEGIN;
            case "Transaction.End" -> TRANSACTION_END;
            case "Trigger" -> TRIGGER;
            case "Other" -> OTHER;
            default -> throw new IllegalArgumentException(
              "Unknown Context: " + wireValue
            );
          };
        }
      }

      /** Closed wire enumeration generated from v16 inline enumeration. */
      public enum Format {
        RAW("Raw"), SIGNED_DATA("SignedData");

        private final String wireValue;

        Format(String wireValue) {
          this.wireValue = wireValue;
        }

        @JsonValue
        public String wireValue() {
          return wireValue;
        }

        @JsonCreator
        public static Format fromWireValue(
          String wireValue
        ) {
          Objects.requireNonNull(
            wireValue,
            "wireValue"
          );
          return switch (wireValue) {
            case "Raw" -> RAW;
            case "SignedData" -> SIGNED_DATA;
            default -> throw new IllegalArgumentException(
              "Unknown Format: " + wireValue
            );
          };
        }
      }

      /** Closed wire enumeration generated from v16 inline enumeration. */
      public enum Location {
        CABLE("Cable"), EV("EV"), INLET("Inlet"), OUTLET("Outlet"), BODY("Body");

        private final String wireValue;

        Location(String wireValue) {
          this.wireValue = wireValue;
        }

        @JsonValue
        public String wireValue() {
          return wireValue;
        }

        @JsonCreator
        public static Location fromWireValue(
          String wireValue
        ) {
          Objects.requireNonNull(
            wireValue,
            "wireValue"
          );
          return switch (wireValue) {
            case "Cable" -> CABLE;
            case "EV" -> EV;
            case "Inlet" -> INLET;
            case "Outlet" -> OUTLET;
            case "Body" -> BODY;
            default -> throw new IllegalArgumentException(
              "Unknown Location: " + wireValue
            );
          };
        }
      }

      /** Closed wire enumeration generated from v16 inline enumeration. */
      public enum Measurand {
        ENERGY_ACTIVE_EXPORT_REGISTER(
          "Energy.Active.Export.Register"
        ), ENERGY_ACTIVE_IMPORT_REGISTER(
          "Energy.Active.Import.Register"
        ), ENERGY_REACTIVE_EXPORT_REGISTER(
          "Energy.Reactive.Export.Register"
        ), ENERGY_REACTIVE_IMPORT_REGISTER(
          "Energy.Reactive.Import.Register"
        ), ENERGY_ACTIVE_EXPORT_INTERVAL(
          "Energy.Active.Export.Interval"
        ), ENERGY_ACTIVE_IMPORT_INTERVAL(
          "Energy.Active.Import.Interval"
        ), ENERGY_REACTIVE_EXPORT_INTERVAL(
          "Energy.Reactive.Export.Interval"
        ), ENERGY_REACTIVE_IMPORT_INTERVAL("Energy.Reactive.Import.Interval"), POWER_ACTIVE_EXPORT(
          "Power.Active.Export"
        ), POWER_ACTIVE_IMPORT("Power.Active.Import"), POWER_OFFERED(
          "Power.Offered"
        ), POWER_REACTIVE_EXPORT(
          "Power.Reactive.Export"
        ), POWER_REACTIVE_IMPORT(
          "Power.Reactive.Import"
        ), POWER_FACTOR("Power.Factor"), CURRENT_IMPORT(
          "Current.Import"
        ), CURRENT_EXPORT("Current.Export"), CURRENT_OFFERED("Current.Offered"), VOLTAGE(
          "Voltage"
        ), FREQUENCY("Frequency"), TEMPERATURE("Temperature"), SO_C("SoC"), RPM("RPM");

        private final String wireValue;

        Measurand(String wireValue) {
          this.wireValue = wireValue;
        }

        @JsonValue
        public String wireValue() {
          return wireValue;
        }

        @JsonCreator
        public static Measurand fromWireValue(
          String wireValue
        ) {
          Objects.requireNonNull(
            wireValue,
            "wireValue"
          );
          return switch (wireValue) {
            case "Energy.Active.Export.Register" -> ENERGY_ACTIVE_EXPORT_REGISTER;
            case "Energy.Active.Import.Register" -> ENERGY_ACTIVE_IMPORT_REGISTER;
            case "Energy.Reactive.Export.Register" -> ENERGY_REACTIVE_EXPORT_REGISTER;
            case "Energy.Reactive.Import.Register" -> ENERGY_REACTIVE_IMPORT_REGISTER;
            case "Energy.Active.Export.Interval" -> ENERGY_ACTIVE_EXPORT_INTERVAL;
            case "Energy.Active.Import.Interval" -> ENERGY_ACTIVE_IMPORT_INTERVAL;
            case "Energy.Reactive.Export.Interval" -> ENERGY_REACTIVE_EXPORT_INTERVAL;
            case "Energy.Reactive.Import.Interval" -> ENERGY_REACTIVE_IMPORT_INTERVAL;
            case "Power.Active.Export" -> POWER_ACTIVE_EXPORT;
            case "Power.Active.Import" -> POWER_ACTIVE_IMPORT;
            case "Power.Offered" -> POWER_OFFERED;
            case "Power.Reactive.Export" -> POWER_REACTIVE_EXPORT;
            case "Power.Reactive.Import" -> POWER_REACTIVE_IMPORT;
            case "Power.Factor" -> POWER_FACTOR;
            case "Current.Import" -> CURRENT_IMPORT;
            case "Current.Export" -> CURRENT_EXPORT;
            case "Current.Offered" -> CURRENT_OFFERED;
            case "Voltage" -> VOLTAGE;
            case "Frequency" -> FREQUENCY;
            case "Temperature" -> TEMPERATURE;
            case "SoC" -> SO_C;
            case "RPM" -> RPM;
            default -> throw new IllegalArgumentException(
              "Unknown Measurand: " + wireValue
            );
          };
        }
      }

      /** Closed wire enumeration generated from v16 inline enumeration. */
      public enum Phase {
        L1("L1"), L2("L2"), L3("L3"), N("N"), L1_N("L1-N"), L2_N("L2-N"), L3_N("L3-N"), L1_L2(
          "L1-L2"
        ), L2_L3("L2-L3"), L3_L1("L3-L1");

        private final String wireValue;

        Phase(String wireValue) {
          this.wireValue = wireValue;
        }

        @JsonValue
        public String wireValue() {
          return wireValue;
        }

        @JsonCreator
        public static Phase fromWireValue(
          String wireValue
        ) {
          Objects.requireNonNull(
            wireValue,
            "wireValue"
          );
          return switch (wireValue) {
            case "L1" -> L1;
            case "L2" -> L2;
            case "L3" -> L3;
            case "N" -> N;
            case "L1-N" -> L1_N;
            case "L2-N" -> L2_N;
            case "L3-N" -> L3_N;
            case "L1-L2" -> L1_L2;
            case "L2-L3" -> L2_L3;
            case "L3-L1" -> L3_L1;
            default -> throw new IllegalArgumentException(
              "Unknown Phase: " + wireValue
            );
          };
        }
      }

      /** Closed wire enumeration generated from v16 inline enumeration. */
      public enum Unit {
        WH("Wh"), K_WH("kWh"), VARH("varh"), KVARH("kvarh"), W("W"), K_W("kW"), VA("VA"), K_VA(
          "kVA"
        ), VAR("var"), KVAR("kvar"), A("A"), V(
          "V"
        ), K(
          "K"
        ), CELCIUS("Celcius"), CELSIUS("Celsius"), FAHRENHEIT("Fahrenheit"), PERCENT("Percent");

        private final String wireValue;

        Unit(String wireValue) {
          this.wireValue = wireValue;
        }

        @JsonValue
        public String wireValue() {
          return wireValue;
        }

        @JsonCreator
        public static Unit fromWireValue(
          String wireValue
        ) {
          Objects.requireNonNull(
            wireValue,
            "wireValue"
          );
          return switch (wireValue) {
            case "Wh" -> WH;
            case "kWh" -> K_WH;
            case "varh" -> VARH;
            case "kvarh" -> KVARH;
            case "W" -> W;
            case "kW" -> K_W;
            case "VA" -> VA;
            case "kVA" -> K_VA;
            case "var" -> VAR;
            case "kvar" -> KVAR;
            case "A" -> A;
            case "V" -> V;
            case "K" -> K;
            case "Celcius" -> CELCIUS;
            case "Celsius" -> CELSIUS;
            case "Fahrenheit" -> FAHRENHEIT;
            case "Percent" -> PERCENT;
            default -> throw new IllegalArgumentException(
              "Unknown Unit: " + wireValue
            );
          };
        }
      }
    }
  }
}
