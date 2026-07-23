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

/**
 * Immutable schema type generated from schemas/v16/RemoteStartTransaction.json.
 */
public record RemoteStartTransactionRequest(
  @Nullable ChargingProfile chargingProfile,
  @Nullable Integer connectorId,
  String idTag
) implements Ocpp16Request {
  public RemoteStartTransactionRequest {
    Objects.requireNonNull(
      idTag,
      "idTag"
    );
    if (idTag.length() > 20) {
      throw new IllegalArgumentException("idTag length violates schema constraints");
    }
  }

  public static RemoteStartTransactionRequest of(String idTag) {
    return new RemoteStartTransactionRequest(
      null,
      null,
      idTag
    );
  }
  public static RemoteStartTransactionRequest of(
    @Nullable ChargingProfile chargingProfile,
    @Nullable Integer connectorId,
    String idTag
  ) {
    return new RemoteStartTransactionRequest(
      chargingProfile,
      connectorId,
      idTag
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
    return Ocpp16Action.REMOTE_START_TRANSACTION;
  }

  /**
   * Immutable schema type generated from schemas/v16/RemoteStartTransaction.json
   * inline object.
   */
  public record ChargingProfile(
    int chargingProfileId,
    ChargingProfileKind chargingProfileKind,
    ChargingProfilePurpose chargingProfilePurpose,
    ChargingSchedule chargingSchedule,
    @Nullable RecurrencyKind recurrencyKind,
    int stackLevel,
    @Nullable Integer transactionId,
    @Nullable Instant validFrom,
    @Nullable Instant validTo
  ) {
    public ChargingProfile {
      Objects.requireNonNull(
        chargingProfileKind,
        "chargingProfileKind"
      );
      Objects.requireNonNull(
        chargingProfilePurpose,
        "chargingProfilePurpose"
      );
      Objects.requireNonNull(
        chargingSchedule,
        "chargingSchedule"
      );
    }

    public static ChargingProfile of(
      int chargingProfileId,
      ChargingProfileKind chargingProfileKind,
      ChargingProfilePurpose chargingProfilePurpose,
      ChargingSchedule chargingSchedule,
      int stackLevel
    ) {
      return new ChargingProfile(
        chargingProfileId,
        chargingProfileKind,
        chargingProfilePurpose,
        chargingSchedule,
        null,
        stackLevel,
        null,
        null,
        null
      );
    }
    public static ChargingProfile of(
      int chargingProfileId,
      ChargingProfileKind chargingProfileKind,
      ChargingProfilePurpose chargingProfilePurpose,
      ChargingSchedule chargingSchedule,
      @Nullable RecurrencyKind recurrencyKind,
      int stackLevel,
      @Nullable Integer transactionId,
      @Nullable Instant validFrom,
      @Nullable Instant validTo
    ) {
      return new ChargingProfile(
        chargingProfileId,
        chargingProfileKind,
        chargingProfilePurpose,
        chargingSchedule,
        recurrencyKind,
        stackLevel,
        transactionId,
        validFrom,
        validTo
      );
    }

    /** Closed wire enumeration generated from v16 inline enumeration. */
    public enum ChargingProfileKind {
      ABSOLUTE("Absolute"), RECURRING("Recurring"), RELATIVE("Relative");

      private final String wireValue;

      ChargingProfileKind(String wireValue) {
        this.wireValue = wireValue;
      }

      @JsonValue
      public String wireValue() {
        return wireValue;
      }

      @JsonCreator
      public static ChargingProfileKind fromWireValue(
        String wireValue
      ) {
        Objects.requireNonNull(
          wireValue,
          "wireValue"
        );
        return switch (wireValue) {
          case "Absolute" -> ABSOLUTE;
          case "Recurring" -> RECURRING;
          case "Relative" -> RELATIVE;
          default -> throw new IllegalArgumentException(
            "Unknown ChargingProfileKind: " + wireValue
          );
        };
      }
    }

    /** Closed wire enumeration generated from v16 inline enumeration. */
    public enum ChargingProfilePurpose {
      CHARGE_POINT_MAX_PROFILE("ChargePointMaxProfile"), TX_DEFAULT_PROFILE(
        "TxDefaultProfile"
      ), TX_PROFILE("TxProfile");

      private final String wireValue;

      ChargingProfilePurpose(String wireValue) {
        this.wireValue = wireValue;
      }

      @JsonValue
      public String wireValue() {
        return wireValue;
      }

      @JsonCreator
      public static ChargingProfilePurpose fromWireValue(
        String wireValue
      ) {
        Objects.requireNonNull(
          wireValue,
          "wireValue"
        );
        return switch (wireValue) {
          case "ChargePointMaxProfile" -> CHARGE_POINT_MAX_PROFILE;
          case "TxDefaultProfile" -> TX_DEFAULT_PROFILE;
          case "TxProfile" -> TX_PROFILE;
          default -> throw new IllegalArgumentException(
            "Unknown ChargingProfilePurpose: " + wireValue
          );
        };
      }
    }

    /**
     * Immutable schema type generated from schemas/v16/RemoteStartTransaction.json
     * inline object.
     */
    public record ChargingSchedule(
      ChargingRateUnit chargingRateUnit,
      List<ChargingSchedulePeriodItem> chargingSchedulePeriod,
      @Nullable Integer duration,
      @Nullable Double minChargingRate,
      @Nullable Instant startSchedule
    ) {
      public ChargingSchedule {
        Objects.requireNonNull(
          chargingRateUnit,
          "chargingRateUnit"
        );
        Objects.requireNonNull(
          chargingSchedulePeriod,
          "chargingSchedulePeriod"
        );
        chargingSchedulePeriod = List.copyOf(chargingSchedulePeriod);
      }

      public static ChargingSchedule of(
        ChargingRateUnit chargingRateUnit,
        List<ChargingSchedulePeriodItem> chargingSchedulePeriod
      ) {
        return new ChargingSchedule(
          chargingRateUnit,
          chargingSchedulePeriod,
          null,
          null,
          null
        );
      }
      public static ChargingSchedule of(
        ChargingRateUnit chargingRateUnit,
        List<ChargingSchedulePeriodItem> chargingSchedulePeriod,
        @Nullable Integer duration,
        @Nullable Double minChargingRate,
        @Nullable Instant startSchedule
      ) {
        return new ChargingSchedule(
          chargingRateUnit,
          chargingSchedulePeriod,
          duration,
          minChargingRate,
          startSchedule
        );
      }

      /** Closed wire enumeration generated from v16 inline enumeration. */
      public enum ChargingRateUnit {
        A("A"), W("W");

        private final String wireValue;

        ChargingRateUnit(String wireValue) {
          this.wireValue = wireValue;
        }

        @JsonValue
        public String wireValue() {
          return wireValue;
        }

        @JsonCreator
        public static ChargingRateUnit fromWireValue(
          String wireValue
        ) {
          Objects.requireNonNull(
            wireValue,
            "wireValue"
          );
          return switch (wireValue) {
            case "A" -> A;
            case "W" -> W;
            default -> throw new IllegalArgumentException(
              "Unknown ChargingRateUnit: "
                + wireValue
            );
          };
        }
      }

      /**
       * Immutable schema type generated from schemas/v16/RemoteStartTransaction.json
       * inline object.
       */
      public record ChargingSchedulePeriodItem(
        double limit,
        @Nullable Integer numberPhases,
        int startPeriod
      ) {
        public ChargingSchedulePeriodItem {

        }

        public static ChargingSchedulePeriodItem of(
          double limit,
          int startPeriod
        ) {
          return new ChargingSchedulePeriodItem(
            limit,
            null,
            startPeriod
          );
        }
        public static ChargingSchedulePeriodItem of(
          double limit,
          @Nullable Integer numberPhases,
          int startPeriod
        ) {
          return new ChargingSchedulePeriodItem(
            limit,
            numberPhases,
            startPeriod
          );
        }
      }
    }

    /** Closed wire enumeration generated from v16 inline enumeration. */
    public enum RecurrencyKind {
      DAILY("Daily"), WEEKLY("Weekly");

      private final String wireValue;

      RecurrencyKind(String wireValue) {
        this.wireValue = wireValue;
      }

      @JsonValue
      public String wireValue() {
        return wireValue;
      }

      @JsonCreator
      public static RecurrencyKind fromWireValue(
        String wireValue
      ) {
        Objects.requireNonNull(
          wireValue,
          "wireValue"
        );
        return switch (wireValue) {
          case "Daily" -> DAILY;
          case "Weekly" -> WEEKLY;
          default -> throw new IllegalArgumentException(
            "Unknown RecurrencyKind: " + wireValue
          );
        };
      }
    }
  }
}
