package io.github.zonnedev.ocpp.v201.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.github.zonnedev.ocpp.api.OcppVersion;
import io.github.zonnedev.ocpp.v201.Ocpp201Action;
import io.github.zonnedev.ocpp.v201.Ocpp201Request;
import io.github.zonnedev.ocpp.v201.model.type.CustomData;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * Immutable schema type generated from schemas/v201/CostUpdatedRequest.json.
 */
public record CostUpdatedRequest(
  @Nullable CustomData customData,
  double totalCost,
  String transactionId
) implements Ocpp201Request {
  public CostUpdatedRequest {
    Objects.requireNonNull(
      transactionId,
      "transactionId"
    );
    if (transactionId.length() > 36) {
      throw new IllegalArgumentException("transactionId length violates schema constraints");
    }
  }

  public static CostUpdatedRequest of(
    double totalCost,
    String transactionId
  ) {
    return new CostUpdatedRequest(
      null,
      totalCost,
      transactionId
    );
  }
  public static CostUpdatedRequest of(
    @Nullable CustomData customData,
    double totalCost,
    String transactionId
  ) {
    return new CostUpdatedRequest(
      customData,
      totalCost,
      transactionId
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
    return Ocpp201Action.COST_UPDATED;
  }
}
