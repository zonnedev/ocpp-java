package io.github.zonnedev.ocpp.v16.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.zonnedev.ocpp.api.OcppVersion;
import io.github.zonnedev.ocpp.v16.Ocpp16Action;
import io.github.zonnedev.ocpp.v16.Ocpp16Response;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/** Immutable schema type generated from schemas/v16/GetLogResponse.json. */
public record GetLogResponse(
  @Nullable String filename,
  LogStatusEnum status
) implements Ocpp16Response {
  public GetLogResponse {
    if (filename != null && (filename.length() > 255)) {
      throw new IllegalArgumentException("filename length violates schema constraints");
    }
    Objects.requireNonNull(
      status,
      "status"
    );
  }

  public static GetLogResponse of(LogStatusEnum status) {
    return new GetLogResponse(
      null,
      status
    );
  }
  public static GetLogResponse of(
    @Nullable String filename,
    LogStatusEnum status
  ) {
    return new GetLogResponse(
      filename,
      status
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
   * Closed wire enumeration generated from v16 reusable definition
   * LogStatusEnumType.
   */
  public enum LogStatusEnum {
    ACCEPTED("Accepted"), REJECTED("Rejected"), ACCEPTED_CANCELED("AcceptedCanceled");

    private final String wireValue;

    LogStatusEnum(String wireValue) {
      this.wireValue = wireValue;
    }

    @JsonValue
    public String wireValue() {
      return wireValue;
    }

    @JsonCreator
    public static LogStatusEnum fromWireValue(String wireValue) {
      Objects.requireNonNull(
        wireValue,
        "wireValue"
      );
      return switch (wireValue) {
        case "Accepted" -> ACCEPTED;
        case "Rejected" -> REJECTED;
        case "AcceptedCanceled" -> ACCEPTED_CANCELED;
        default -> throw new IllegalArgumentException("Unknown LogStatusEnum: " + wireValue);
      };
    }
  }
}
