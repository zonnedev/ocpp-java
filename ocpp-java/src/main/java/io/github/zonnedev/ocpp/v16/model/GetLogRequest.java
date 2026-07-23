package io.github.zonnedev.ocpp.v16.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.zonnedev.ocpp.api.OcppVersion;
import io.github.zonnedev.ocpp.v16.Ocpp16Action;
import io.github.zonnedev.ocpp.v16.Ocpp16Request;
import java.time.Instant;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/** Immutable schema type generated from schemas/v16/GetLog.json. */
public record GetLogRequest(
  LogParameters log,
  LogEnum logType,
  int requestId,
  @Nullable Integer retries,
  @Nullable Integer retryInterval
) implements Ocpp16Request {
  public GetLogRequest {
    Objects.requireNonNull(
      log,
      "log"
    );
    Objects.requireNonNull(
      logType,
      "logType"
    );
  }

  public static GetLogRequest of(
    LogParameters log,
    LogEnum logType,
    int requestId
  ) {
    return new GetLogRequest(
      log,
      logType,
      requestId,
      null,
      null
    );
  }
  public static GetLogRequest of(
    LogParameters log,
    LogEnum logType,
    int requestId,
    @Nullable Integer retries,
    @Nullable Integer retryInterval
  ) {
    return new GetLogRequest(
      log,
      logType,
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
    return Ocpp16Action.GET_LOG;
  }

  /**
   * Closed wire enumeration generated from v16 reusable definition LogEnumType.
   */
  public enum LogEnum {
    DIAGNOSTICS_LOG("DiagnosticsLog"), SECURITY_LOG("SecurityLog");

    private final String wireValue;

    LogEnum(String wireValue) {
      this.wireValue = wireValue;
    }

    @JsonValue
    public String wireValue() {
      return wireValue;
    }

    @JsonCreator
    public static LogEnum fromWireValue(String wireValue) {
      Objects.requireNonNull(
        wireValue,
        "wireValue"
      );
      return switch (wireValue) {
        case "DiagnosticsLog" -> DIAGNOSTICS_LOG;
        case "SecurityLog" -> SECURITY_LOG;
        default -> throw new IllegalArgumentException("Unknown LogEnum: " + wireValue);
      };
    }
  }

  /**
   * Immutable schema type generated from v16 reusable definition
   * LogParametersType.
   */
  public record LogParameters(
    @Nullable Instant latestTimestamp,
    @Nullable Instant oldestTimestamp,
    String remoteLocation
  ) {
    public LogParameters {
      Objects.requireNonNull(
        remoteLocation,
        "remoteLocation"
      );
      if (remoteLocation.length() > 512) {
        throw new IllegalArgumentException("remoteLocation length violates schema constraints");
      }
    }

    public static LogParameters of(String remoteLocation) {
      return new LogParameters(
        null,
        null,
        remoteLocation
      );
    }
    public static LogParameters of(
      @Nullable Instant latestTimestamp,
      @Nullable Instant oldestTimestamp,
      String remoteLocation
    ) {
      return new LogParameters(
        latestTimestamp,
        oldestTimestamp,
        remoteLocation
      );
    }
  }
}
