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

/**
 * Immutable schema type generated from schemas/v201/ReserveNowResponse.json.
 */
public record ReserveNowResponse(
  @Nullable CustomData customData,
  ReserveNowStatusEnum status,
  @Nullable StatusInfo statusInfo
) implements Ocpp201Response {
  public ReserveNowResponse {
    Objects.requireNonNull(
      status,
      "status"
    );
  }

  public static ReserveNowResponse of(ReserveNowStatusEnum status) {
    return new ReserveNowResponse(
      null,
      status,
      null
    );
  }
  public static ReserveNowResponse of(
    @Nullable CustomData customData,
    ReserveNowStatusEnum status,
    @Nullable StatusInfo statusInfo
  ) {
    return new ReserveNowResponse(
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
    return Ocpp201Action.RESERVE_NOW;
  }

  /**
   * Closed wire enumeration generated from v201 reusable definition
   * ReserveNowStatusEnumType.
   */
  public enum ReserveNowStatusEnum {
    ACCEPTED("Accepted"), FAULTED("Faulted"), OCCUPIED("Occupied"), REJECTED(
      "Rejected"
    ), UNAVAILABLE(
      "Unavailable"
    );

    private final String wireValue;

    ReserveNowStatusEnum(String wireValue) {
      this.wireValue = wireValue;
    }

    @JsonValue
    public String wireValue() {
      return wireValue;
    }

    @JsonCreator
    public static ReserveNowStatusEnum fromWireValue(String wireValue) {
      Objects.requireNonNull(
        wireValue,
        "wireValue"
      );
      return switch (wireValue) {
        case "Accepted" -> ACCEPTED;
        case "Faulted" -> FAULTED;
        case "Occupied" -> OCCUPIED;
        case "Rejected" -> REJECTED;
        case "Unavailable" -> UNAVAILABLE;
        default -> throw new IllegalArgumentException("Unknown ReserveNowStatusEnum: " + wireValue);
      };
    }
  }
}
