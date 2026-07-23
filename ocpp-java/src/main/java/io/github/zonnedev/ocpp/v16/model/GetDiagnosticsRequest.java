package io.github.zonnedev.ocpp.v16.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.time.Instant;
import java.util.Objects;
import org.jspecify.annotations.Nullable;
import io.github.zonnedev.ocpp.api.OcppVersion;
import io.github.zonnedev.ocpp.v16.Ocpp16Action;
import io.github.zonnedev.ocpp.v16.Ocpp16Request;

/** Immutable schema type generated from schemas/v16/GetDiagnostics.json. */
public record GetDiagnosticsRequest(
  String location,
  @Nullable Integer retries,
  @Nullable Integer retryInterval,
  @Nullable Instant startTime,
  @Nullable Instant stopTime
) implements Ocpp16Request {
  public GetDiagnosticsRequest {
    Objects.requireNonNull(
      location,
      "location"
    );
  }

  public static GetDiagnosticsRequest of(String location) {
    return new GetDiagnosticsRequest(
      location,
      null,
      null,
      null,
      null
    );
  }
  public static GetDiagnosticsRequest of(
    String location,
    @Nullable Integer retries,
    @Nullable Integer retryInterval,
    @Nullable Instant startTime,
    @Nullable Instant stopTime
  ) {
    return new GetDiagnosticsRequest(
      location,
      retries,
      retryInterval,
      startTime,
      stopTime
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
    return Ocpp16Action.GET_DIAGNOSTICS;
  }
}
