package io.github.zonnedev.ocpp.v201.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.github.zonnedev.ocpp.api.OcppVersion;
import io.github.zonnedev.ocpp.v201.Ocpp201Action;
import io.github.zonnedev.ocpp.v201.Ocpp201Request;
import io.github.zonnedev.ocpp.v201.model.type.CustomData;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * Immutable schema type generated from
 * schemas/v201/PublishFirmwareRequest.json.
 */
public record PublishFirmwareRequest(
  String checksum,
  @Nullable CustomData customData,
  String location,
  int requestId,
  @Nullable Integer retries,
  @Nullable Integer retryInterval
) implements Ocpp201Request {
  public PublishFirmwareRequest {
    Objects.requireNonNull(
      checksum,
      "checksum"
    );
    if (checksum.length() > 32) {
      throw new IllegalArgumentException("checksum length violates schema constraints");
    }
    Objects.requireNonNull(
      location,
      "location"
    );
    if (location.length() > 512) {
      throw new IllegalArgumentException("location length violates schema constraints");
    }
  }

  public static PublishFirmwareRequest of(
    String checksum,
    String location,
    int requestId
  ) {
    return new PublishFirmwareRequest(
      checksum,
      null,
      location,
      requestId,
      null,
      null
    );
  }
  public static PublishFirmwareRequest of(
    String checksum,
    @Nullable CustomData customData,
    String location,
    int requestId,
    @Nullable Integer retries,
    @Nullable Integer retryInterval
  ) {
    return new PublishFirmwareRequest(
      checksum,
      customData,
      location,
      requestId,
      retries,
      retryInterval
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
    return Ocpp201Action.PUBLISH_FIRMWARE;
  }
}
