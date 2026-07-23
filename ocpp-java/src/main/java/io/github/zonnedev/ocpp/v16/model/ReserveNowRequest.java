package io.github.zonnedev.ocpp.v16.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.time.Instant;
import java.util.Objects;
import org.jspecify.annotations.Nullable;
import io.github.zonnedev.ocpp.api.OcppVersion;
import io.github.zonnedev.ocpp.v16.Ocpp16Action;
import io.github.zonnedev.ocpp.v16.Ocpp16Request;

/** Immutable schema type generated from schemas/v16/ReserveNow.json. */
public record ReserveNowRequest(
  int connectorId,
  Instant expiryDate,
  String idTag,
  @Nullable String parentIdTag,
  int reservationId
) implements Ocpp16Request {
  public ReserveNowRequest {
    Objects.requireNonNull(
      expiryDate,
      "expiryDate"
    );
    Objects.requireNonNull(
      idTag,
      "idTag"
    );
    if (idTag.length() > 20) {
      throw new IllegalArgumentException("idTag length violates schema constraints");
    }
    if (parentIdTag != null && (parentIdTag.length() > 20)) {
      throw new IllegalArgumentException("parentIdTag length violates schema constraints");
    }
  }

  public static ReserveNowRequest of(
    int connectorId,
    Instant expiryDate,
    String idTag,
    int reservationId
  ) {
    return new ReserveNowRequest(
      connectorId,
      expiryDate,
      idTag,
      null,
      reservationId
    );
  }
  public static ReserveNowRequest of(
    int connectorId,
    Instant expiryDate,
    String idTag,
    @Nullable String parentIdTag,
    int reservationId
  ) {
    return new ReserveNowRequest(
      connectorId,
      expiryDate,
      idTag,
      parentIdTag,
      reservationId
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
    return Ocpp16Action.RESERVE_NOW;
  }
}
