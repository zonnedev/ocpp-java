package io.github.zonnedev.ocpp.v16.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.zonnedev.ocpp.api.OcppVersion;
import io.github.zonnedev.ocpp.v16.Ocpp16Action;
import io.github.zonnedev.ocpp.v16.Ocpp16Response;
import java.time.Instant;
import java.util.List;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * Immutable schema type generated from
 * schemas/v16/GetCompositeScheduleResponse.json.
 */
public record GetCompositeScheduleResponse(
  @Nullable ChargingSchedule chargingSchedule,
  @Nullable Integer connectorId,
  @Nullable Instant scheduleStart,
  Status status
) implements Ocpp16Response {
  public GetCompositeScheduleResponse {
    Objects.requireNonNull(
      status,
      "status"
    );
  }

  public static GetCompositeScheduleResponse of(Status status) {
    return new GetCompositeScheduleResponse(
      null,
      null,
      null,
      status
    );
  }
  public static GetCompositeScheduleResponse of(
    @Nullable ChargingSchedule chargingSchedule,
    @Nullable Integer connectorId,
    @Nullable Instant scheduleStart,
    Status status
  ) {
    return new GetCompositeScheduleResponse(
      chargingSchedule,
      connectorId,
      scheduleStart,
      status
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
    return Ocpp16Action.GET_COMPOSITE_SCHEDULE;
  }

  /**
   * Immutable schema type generated from
   * schemas/v16/GetCompositeScheduleResponse.json inline object.
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
            "Unknown ChargingRateUnit: " + wireValue
          );
        };
      }
    }

    /**
     * Immutable schema type generated from
     * schemas/v16/GetCompositeScheduleResponse.json inline object.
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
  public enum Status {
    ACCEPTED("Accepted"), REJECTED("Rejected");

    private final String wireValue;

    Status(String wireValue) {
      this.wireValue = wireValue;
    }

    @JsonValue
    public String wireValue() {
      return wireValue;
    }

    @JsonCreator
    public static Status fromWireValue(String wireValue) {
      Objects.requireNonNull(
        wireValue,
        "wireValue"
      );
      return switch (wireValue) {
        case "Accepted" -> ACCEPTED;
        case "Rejected" -> REJECTED;
        default -> throw new IllegalArgumentException(
          "Unknown Status: " + wireValue
        );
      };
    }
  }
}
