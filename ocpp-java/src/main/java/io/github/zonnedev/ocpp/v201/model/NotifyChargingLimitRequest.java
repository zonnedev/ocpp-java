package io.github.zonnedev.ocpp.v201.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.github.zonnedev.ocpp.api.OcppVersion;
import io.github.zonnedev.ocpp.v201.Ocpp201Action;
import io.github.zonnedev.ocpp.v201.Ocpp201Request;
import io.github.zonnedev.ocpp.v201.model.type.ChargingLimitSourceEnum;
import io.github.zonnedev.ocpp.v201.model.type.ChargingSchedule;
import io.github.zonnedev.ocpp.v201.model.type.CustomData;
import java.util.List;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * Immutable schema type generated from
 * schemas/v201/NotifyChargingLimitRequest.json.
 */
public record NotifyChargingLimitRequest(
  ChargingLimit chargingLimit,
  @Nullable List<ChargingSchedule> chargingSchedule,
  @Nullable CustomData customData,
  @Nullable Integer evseId
) implements Ocpp201Request {
  public NotifyChargingLimitRequest {
    Objects.requireNonNull(
      chargingLimit,
      "chargingLimit"
    );
    chargingSchedule = chargingSchedule == null ? null : List.copyOf(chargingSchedule);
    if (chargingSchedule != null && (chargingSchedule.size() < 1)) {
      throw new IllegalArgumentException("chargingSchedule size violates schema constraints");
    }
  }

  public static NotifyChargingLimitRequest of(ChargingLimit chargingLimit) {
    return new NotifyChargingLimitRequest(
      chargingLimit,
      null,
      null,
      null
    );
  }
  public static NotifyChargingLimitRequest of(
    ChargingLimit chargingLimit,
    @Nullable List<ChargingSchedule> chargingSchedule,
    @Nullable CustomData customData,
    @Nullable Integer evseId
  ) {
    return new NotifyChargingLimitRequest(
      chargingLimit,
      chargingSchedule,
      customData,
      evseId
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
    return Ocpp201Action.NOTIFY_CHARGING_LIMIT;
  }

  /**
   * Immutable schema type generated from v201 reusable definition
   * ChargingLimitType.
   */
  public record ChargingLimit(
    ChargingLimitSourceEnum chargingLimitSource,
    @Nullable CustomData customData,
    @Nullable Boolean isGridCritical
  ) {
    public ChargingLimit {
      Objects.requireNonNull(
        chargingLimitSource,
        "chargingLimitSource"
      );
    }

    public static ChargingLimit of(ChargingLimitSourceEnum chargingLimitSource) {
      return new ChargingLimit(
        chargingLimitSource,
        null,
        null
      );
    }
    public static ChargingLimit of(
      ChargingLimitSourceEnum chargingLimitSource,
      @Nullable CustomData customData,
      @Nullable Boolean isGridCritical
    ) {
      return new ChargingLimit(
        chargingLimitSource,
        customData,
        isGridCritical
      );
    }
  }
}
