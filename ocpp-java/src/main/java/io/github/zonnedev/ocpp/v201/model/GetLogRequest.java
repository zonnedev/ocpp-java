package io.github.zonnedev.ocpp.v201.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.zonnedev.ocpp.api.OcppVersion;
import io.github.zonnedev.ocpp.v201.Ocpp201Action;
import io.github.zonnedev.ocpp.v201.Ocpp201Request;
import io.github.zonnedev.ocpp.v201.model.type.CustomData;
import java.time.Instant;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/** Immutable schema type generated from schemas/v201/GetLogRequest.json. */
public record GetLogRequest(
  @Nullable CustomData customData,
  LogParameters log,
  LogEnum logType,
  int requestId,
  @Nullable Integer retries,
  @Nullable Integer retryInterval
) implements Ocpp201Request {
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
      null,
      log,
      logType,
      requestId,
      null,
      null
    );
  }
  public static GetLogRequest of(
    @Nullable CustomData customData,
    LogParameters log,
    LogEnum logType,
    int requestId,
    @Nullable Integer retries,
    @Nullable Integer retryInterval
  ) {
    return new GetLogRequest(
      customData,
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
    return OcppVersion.OCPP_2_0_1;
  }

  @JsonIgnore
  @Override
  public Ocpp201Action action() {
    return Ocpp201Action.GET_LOG;
  }

  /**
   * Closed wire enumeration generated from v201 reusable definition LogEnumType.
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
   * Immutable schema type generated from v201 reusable definition
   * LogParametersType.
   */
  public record LogParameters(
    @Nullable CustomData customData,
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
        null,
        remoteLocation
      );
    }
    public static LogParameters of(
      @Nullable CustomData customData,
      @Nullable Instant latestTimestamp,
      @Nullable Instant oldestTimestamp,
      String remoteLocation
    ) {
      return new LogParameters(
        customData,
        latestTimestamp,
        oldestTimestamp,
        remoteLocation
      );
    }
  }
}
