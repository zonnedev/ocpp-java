package io.github.zonnedev.ocpp.v201.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.github.zonnedev.ocpp.api.OcppVersion;
import io.github.zonnedev.ocpp.v201.Ocpp201Action;
import io.github.zonnedev.ocpp.v201.Ocpp201Response;
import io.github.zonnedev.ocpp.v201.model.type.CustomData;
import java.time.Instant;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/** Immutable schema type generated from schemas/v201/HeartbeatResponse.json. */
public record HeartbeatResponse(
  Instant currentTime,
  @Nullable CustomData customData
) implements Ocpp201Response {
  public HeartbeatResponse {
    Objects.requireNonNull(
      currentTime,
      "currentTime"
    );
  }

  public static HeartbeatResponse of(Instant currentTime) {
    return new HeartbeatResponse(
      currentTime,
      null
    );
  }
  public static HeartbeatResponse of(
    Instant currentTime,
    @Nullable CustomData customData
  ) {
    return new HeartbeatResponse(
      currentTime,
      customData
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
    return Ocpp201Action.HEARTBEAT;
  }
}
