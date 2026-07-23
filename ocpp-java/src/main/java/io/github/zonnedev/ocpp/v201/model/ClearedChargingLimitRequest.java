package io.github.zonnedev.ocpp.v201.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.github.zonnedev.ocpp.api.OcppVersion;
import io.github.zonnedev.ocpp.v201.Ocpp201Action;
import io.github.zonnedev.ocpp.v201.Ocpp201Request;
import io.github.zonnedev.ocpp.v201.model.type.ChargingLimitSourceEnum;
import io.github.zonnedev.ocpp.v201.model.type.CustomData;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * Immutable schema type generated from
 * schemas/v201/ClearedChargingLimitRequest.json.
 */
public record ClearedChargingLimitRequest(
  ChargingLimitSourceEnum chargingLimitSource,
  @Nullable CustomData customData,
  @Nullable Integer evseId
) implements Ocpp201Request {
  public ClearedChargingLimitRequest {
    Objects.requireNonNull(
      chargingLimitSource,
      "chargingLimitSource"
    );
  }

  public static ClearedChargingLimitRequest of(ChargingLimitSourceEnum chargingLimitSource) {
    return new ClearedChargingLimitRequest(
      chargingLimitSource,
      null,
      null
    );
  }
  public static ClearedChargingLimitRequest of(
    ChargingLimitSourceEnum chargingLimitSource,
    @Nullable CustomData customData,
    @Nullable Integer evseId
  ) {
    return new ClearedChargingLimitRequest(
      chargingLimitSource,
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
    return Ocpp201Action.CLEARED_CHARGING_LIMIT;
  }
}
