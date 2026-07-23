package io.github.zonnedev.ocpp.v16.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.time.Instant;
import java.util.Objects;
import io.github.zonnedev.ocpp.api.OcppVersion;
import io.github.zonnedev.ocpp.v16.Ocpp16Action;
import io.github.zonnedev.ocpp.v16.Ocpp16Response;

/** Immutable schema type generated from schemas/v16/HeartbeatResponse.json. */
public record HeartbeatResponse(
  Instant currentTime
) implements Ocpp16Response {
  public HeartbeatResponse {
    Objects.requireNonNull(
      currentTime,
      "currentTime"
    );
  }

  public static HeartbeatResponse of(Instant currentTime) {
    return new HeartbeatResponse(currentTime);
  }

  @JsonIgnore
  @Override
  public OcppVersion version() {
    return OcppVersion.OCPP_1_6_JSON;
  }

  @JsonIgnore
  @Override
  public Ocpp16Action action() {
    return Ocpp16Action.HEARTBEAT;
  }
}
