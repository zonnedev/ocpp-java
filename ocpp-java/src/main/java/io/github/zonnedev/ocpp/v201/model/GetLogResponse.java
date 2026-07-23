package io.github.zonnedev.ocpp.v201.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.zonnedev.ocpp.api.OcppVersion;
import io.github.zonnedev.ocpp.v201.Ocpp201Action;
import io.github.zonnedev.ocpp.v201.Ocpp201Response;
import io.github.zonnedev.ocpp.v201.model.type.CustomData;
import io.github.zonnedev.ocpp.v201.model.type.StatusInfo;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/** Immutable schema type generated from schemas/v201/GetLogResponse.json. */
public record GetLogResponse(
  @Nullable CustomData customData,
  @Nullable String filename,
  LogStatusEnum status,
  @Nullable StatusInfo statusInfo
) implements Ocpp201Response {
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
      null,
      status,
      null
    );
  }
  public static GetLogResponse of(
    @Nullable CustomData customData,
    @Nullable String filename,
    LogStatusEnum status,
    @Nullable StatusInfo statusInfo
  ) {
    return new GetLogResponse(
      customData,
      filename,
      status,
      statusInfo
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
   * Closed wire enumeration generated from v201 reusable definition
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
