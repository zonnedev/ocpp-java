package io.github.zonnedev.ocpp.v201.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.github.zonnedev.ocpp.api.OcppVersion;
import io.github.zonnedev.ocpp.v201.Ocpp201Action;
import io.github.zonnedev.ocpp.v201.Ocpp201Response;
import io.github.zonnedev.ocpp.v201.model.type.CustomData;
import org.jspecify.annotations.Nullable;

/**
 * Immutable schema type generated from schemas/v201/CostUpdatedResponse.json.
 */
public record CostUpdatedResponse(
  @Nullable CustomData customData
) implements Ocpp201Response {
  public CostUpdatedResponse {

  }

  public static CostUpdatedResponse of() {
    return new CostUpdatedResponse(null);
  }
  public static CostUpdatedResponse of(@Nullable CustomData customData) {
    return new CostUpdatedResponse(customData);
  }

  @JsonIgnore
  @Override
  public OcppVersion version() {
    return OcppVersion.OCPP_2_0_1;
  }

  @JsonIgnore
  @Override
  public Ocpp201Action action() {
    return Ocpp201Action.COST_UPDATED;
  }
}
