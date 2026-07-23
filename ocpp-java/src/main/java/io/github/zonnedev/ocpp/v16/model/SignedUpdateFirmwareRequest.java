package io.github.zonnedev.ocpp.v16.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.github.zonnedev.ocpp.api.OcppVersion;
import io.github.zonnedev.ocpp.v16.Ocpp16Action;
import io.github.zonnedev.ocpp.v16.Ocpp16Request;
import java.time.Instant;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * Immutable schema type generated from schemas/v16/SignedUpdateFirmware.json.
 */
public record SignedUpdateFirmwareRequest(
  Firmware firmware,
  int requestId,
  @Nullable Integer retries,
  @Nullable Integer retryInterval
) implements Ocpp16Request {
  public SignedUpdateFirmwareRequest {
    Objects.requireNonNull(
      firmware,
      "firmware"
    );
  }

  public static SignedUpdateFirmwareRequest of(
    Firmware firmware,
    int requestId
  ) {
    return new SignedUpdateFirmwareRequest(
      firmware,
      requestId,
      null,
      null
    );
  }
  public static SignedUpdateFirmwareRequest of(
    Firmware firmware,
    int requestId,
    @Nullable Integer retries,
    @Nullable Integer retryInterval
  ) {
    return new SignedUpdateFirmwareRequest(
      firmware,
      requestId,
      retries,
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
    return Ocpp16Action.SIGNED_UPDATE_FIRMWARE;
  }

  /**
   * Immutable schema type generated from v16 reusable definition FirmwareType.
   */
  public record Firmware(
    @Nullable Instant installDateTime,
    String location,
    Instant retrieveDateTime,
    String signature,
    String signingCertificate
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
      Objects.requireNonNull(
        signature,
        "signature"
      );
      if (signature.length() > 800) {
        throw new IllegalArgumentException("signature length violates schema constraints");
      }
      Objects.requireNonNull(
        signingCertificate,
        "signingCertificate"
      );
      if (signingCertificate.length() > 5500) {
        throw new IllegalArgumentException("signingCertificate length violates schema constraints");
      }
    }

    public static Firmware of(
      String location,
      Instant retrieveDateTime,
      String signature,
      String signingCertificate
    ) {
      return new Firmware(
        null,
        location,
        retrieveDateTime,
        signature,
        signingCertificate
      );
    }
    public static Firmware of(
      @Nullable Instant installDateTime,
      String location,
      Instant retrieveDateTime,
      String signature,
      String signingCertificate
    ) {
      return new Firmware(
        installDateTime,
        location,
        retrieveDateTime,
        signature,
        signingCertificate
      );
    }
  }
}
