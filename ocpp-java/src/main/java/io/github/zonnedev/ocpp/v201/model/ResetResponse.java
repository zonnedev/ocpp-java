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

/** Immutable schema type generated from schemas/v201/ResetResponse.json. */
public record ResetResponse(
  @Nullable CustomData customData,
  ResetStatusEnum status,
  @Nullable StatusInfo statusInfo
) implements Ocpp201Response {
  public ResetResponse {
    Objects.requireNonNull(
      status,
      "status"
    );
  }

  public static ResetResponse of(ResetStatusEnum status) {
    return new ResetResponse(
      null,
      status,
      null
    );
  }
  public static ResetResponse of(
    @Nullable CustomData customData,
    ResetStatusEnum status,
    @Nullable StatusInfo statusInfo
  ) {
    return new ResetResponse(
      customData,
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
    return Ocpp201Action.RESET;
  }

  /**
   * Closed wire enumeration generated from v201 reusable definition
   * ResetStatusEnumType.
   */
  public enum ResetStatusEnum {
    ACCEPTED("Accepted"), REJECTED("Rejected"), SCHEDULED("Scheduled");

    private final String wireValue;

    ResetStatusEnum(String wireValue) {
      this.wireValue = wireValue;
    }

    @JsonValue
    public String wireValue() {
      return wireValue;
    }

    @JsonCreator
    public static ResetStatusEnum fromWireValue(String wireValue) {
      Objects.requireNonNull(
        wireValue,
        "wireValue"
      );
      return switch (wireValue) {
        case "Accepted" -> ACCEPTED;
        case "Rejected" -> REJECTED;
        case "Scheduled" -> SCHEDULED;
        default -> throw new IllegalArgumentException("Unknown ResetStatusEnum: " + wireValue);
      };
    }
  }
}
