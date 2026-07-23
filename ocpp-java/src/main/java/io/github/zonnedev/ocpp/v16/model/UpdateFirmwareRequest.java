package io.github.zonnedev.ocpp.v16.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.time.Instant;
import java.util.Objects;
import org.jspecify.annotations.Nullable;
import io.github.zonnedev.ocpp.api.OcppVersion;
import io.github.zonnedev.ocpp.v16.Ocpp16Action;
import io.github.zonnedev.ocpp.v16.Ocpp16Request;

/** Immutable schema type generated from schemas/v16/UpdateFirmware.json. */
public record UpdateFirmwareRequest(
  String location,
  @Nullable Integer retries,
  Instant retrieveDate,
  @Nullable Integer retryInterval
) implements Ocpp16Request {
  public UpdateFirmwareRequest {
    Objects.requireNonNull(
      location,
      "location"
    );
    Objects.requireNonNull(
      retrieveDate,
      "retrieveDate"
    );
  }

  public static UpdateFirmwareRequest of(
    String location,
    Instant retrieveDate
  ) {
    return new UpdateFirmwareRequest(
      location,
      null,
      retrieveDate,
      null
    );
  }
  public static UpdateFirmwareRequest of(
    String location,
    @Nullable Integer retries,
    Instant retrieveDate,
    @Nullable Integer retryInterval
  ) {
    return new UpdateFirmwareRequest(
      location,
      retries,
      retrieveDate,
      retryInterval
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
    return Ocpp16Action.UPDATE_FIRMWARE;
  }
}
