package io.github.zonnedev.ocpp.v201.model.type;

import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * Immutable schema type generated from v201 reusable definition
 * TransactionType.
 */
public record Transaction(
  @Nullable ChargingStateEnum chargingState,
  @Nullable CustomData customData,
  @Nullable Integer remoteStartId,
  @Nullable ReasonEnum stoppedReason,
  @Nullable Integer timeSpentCharging,
  String transactionId
) {
  public Transaction {
    Objects.requireNonNull(
      transactionId,
      "transactionId"
    );
    if (transactionId.length() > 36) {
      throw new IllegalArgumentException("transactionId length violates schema constraints");
    }
  }

  public static Transaction of(String transactionId) {
    return new Transaction(
      null,
      null,
      null,
      null,
      null,
      transactionId
    );
  }
  public static Transaction of(
    @Nullable ChargingStateEnum chargingState,
    @Nullable CustomData customData,
    @Nullable Integer remoteStartId,
    @Nullable ReasonEnum stoppedReason,
    @Nullable Integer timeSpentCharging,
    String transactionId
  ) {
    return new Transaction(
      chargingState,
      customData,
      remoteStartId,
      stoppedReason,
      timeSpentCharging,
      transactionId
    );
  }
}
