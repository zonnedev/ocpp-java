package io.github.zonnedev.ocpp.v16.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.time.Instant;
import java.util.Objects;
import org.jspecify.annotations.Nullable;
import io.github.zonnedev.ocpp.api.OcppVersion;
import io.github.zonnedev.ocpp.v16.Ocpp16Action;
import io.github.zonnedev.ocpp.v16.Ocpp16Request;

/** Immutable schema type generated from schemas/v16/StartTransaction.json. */
public record StartTransactionRequest(
  int connectorId,
  String idTag,
  int meterStart,
  @Nullable Integer reservationId,
  Instant timestamp
) implements Ocpp16Request {
  public StartTransactionRequest {
    Objects.requireNonNull(
      idTag,
      "idTag"
    );
    if (idTag.length() > 20) {
      throw new IllegalArgumentException("idTag length violates schema constraints");
    }
    Objects.requireNonNull(
      timestamp,
      "timestamp"
    );
  }

  public static StartTransactionRequest of(
    int connectorId,
    String idTag,
    int meterStart,
    Instant timestamp
  ) {
    return new StartTransactionRequest(
      connectorId,
      idTag,
      meterStart,
      null,
      timestamp
    );
  }
  public static StartTransactionRequest of(
    int connectorId,
    String idTag,
    int meterStart,
    @Nullable Integer reservationId,
    Instant timestamp
  ) {
    return new StartTransactionRequest(
      connectorId,
      idTag,
      meterStart,
      reservationId,
      timestamp
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
    return Ocpp16Action.START_TRANSACTION;
  }
}
