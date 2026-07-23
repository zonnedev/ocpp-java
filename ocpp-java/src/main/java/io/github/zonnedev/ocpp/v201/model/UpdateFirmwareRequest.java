package io.github.zonnedev.ocpp.v201.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.github.zonnedev.ocpp.api.OcppVersion;
import io.github.zonnedev.ocpp.v201.Ocpp201Action;
import io.github.zonnedev.ocpp.v201.Ocpp201Request;
import io.github.zonnedev.ocpp.v201.model.type.CustomData;
import java.time.Instant;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * Immutable schema type generated from schemas/v201/UpdateFirmwareRequest.json.
 */
public record UpdateFirmwareRequest(
  @Nullable CustomData customData,
  Firmware firmware,
  int requestId,
  @Nullable Integer retries,
  @Nullable Integer retryInterval
) implements Ocpp201Request {
  public UpdateFirmwareRequest {
    Objects.requireNonNull(
      firmware,
      "firmware"
    );
  }

  public static UpdateFirmwareRequest of(
    Firmware firmware,
    int requestId
  ) {
    return new UpdateFirmwareRequest(
      null,
      firmware,
      requestId,
      null,
      null
    );
  }
  public static UpdateFirmwareRequest of(
    @Nullable CustomData customData,
    Firmware firmware,
    int requestId,
    @Nullable Integer retries,
    @Nullable Integer retryInterval
  ) {
    return new UpdateFirmwareRequest(
      customData,
      firmware,
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
    return Ocpp201Action.UPDATE_FIRMWARE;
  }

  /**
   * Immutable schema type generated from v201 reusable definition FirmwareType.
   */
  public record Firmware(
    @Nullable CustomData customData,
    @Nullable Instant installDateTime,
    String location,
    Instant retrieveDateTime,
    @Nullable String signature,
    @Nullable String signingCertificate
  ) {
    public Firmware {
      Objects.requireNonNull(
        location,
        "location"
      );
      if (location.length() > 512) {
        throw new IllegalArgumentException("location length violates schema constraints");
      }
      Objects.requireNonNull(
        retrieveDateTime,
        "retrieveDateTime"
      );
      if (signature != null && (signature.length() > 800)) {
        throw new IllegalArgumentException("signature length violates schema constraints");
      }
      if (signingCertificate != null && (signingCertificate.length() > 5500)) {
        throw new IllegalArgumentException("signingCertificate length violates schema constraints");
      }
    }

    public static Firmware of(
      String location,
      Instant retrieveDateTime
    ) {
      return new Firmware(
        null,
        null,
        location,
        retrieveDateTime,
        null,
        null
      );
    }
    public static Firmware of(
      @Nullable CustomData customData,
      @Nullable Instant installDateTime,
      String location,
      Instant retrieveDateTime,
      @Nullable String signature,
      @Nullable String signingCertificate
    ) {
      return new Firmware(
        customData,
        installDateTime,
        location,
        retrieveDateTime,
        signature,
        signingCertificate
      );
    }
  }
}
