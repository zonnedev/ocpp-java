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
 * Immutable schema type generated from
 * schemas/v201/ClearChargingProfileResponse.json.
 */
public record ClearChargingProfileResponse(
  @Nullable CustomData customData,
  ClearChargingProfileStatusEnum status,
  @Nullable StatusInfo statusInfo
) implements Ocpp201Response {
  public ClearChargingProfileResponse {
    Objects.requireNonNull(
      status,
      "status"
    );
  }

  public static ClearChargingProfileResponse of(ClearChargingProfileStatusEnum status) {
    return new ClearChargingProfileResponse(
      null,
      status,
      null
    );
  }
  public static ClearChargingProfileResponse of(
    @Nullable CustomData customData,
    ClearChargingProfileStatusEnum status,
    @Nullable StatusInfo statusInfo
  ) {
    return new ClearChargingProfileResponse(
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
    return Ocpp201Action.CLEAR_CHARGING_PROFILE;
  }

  /**
   * Closed wire enumeration generated from v201 reusable definition
   * ClearChargingProfileStatusEnumType.
   */
  public enum ClearChargingProfileStatusEnum {
    ACCEPTED("Accepted"), UNKNOWN("Unknown");

    private final String wireValue;

    ClearChargingProfileStatusEnum(String wireValue) {
      this.wireValue = wireValue;
    }

    @JsonValue
    public String wireValue() {
      return wireValue;
    }

    @JsonCreator
    public static ClearChargingProfileStatusEnum fromWireValue(String wireValue) {
      Objects.requireNonNull(
        wireValue,
        "wireValue"
      );
      return switch (wireValue) {
        case "Accepted" -> ACCEPTED;
        case "Unknown" -> UNKNOWN;
        default ->
          throw new IllegalArgumentException(
            "Unknown ClearChargingProfileStatusEnum: " + wireValue
          );
      };
    }
  }
}
