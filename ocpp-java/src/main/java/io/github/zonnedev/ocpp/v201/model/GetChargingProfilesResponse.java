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
 * schemas/v201/GetChargingProfilesResponse.json.
 */
public record GetChargingProfilesResponse(
  @Nullable CustomData customData,
  GetChargingProfileStatusEnum status,
  @Nullable StatusInfo statusInfo
) implements Ocpp201Response {
  public GetChargingProfilesResponse {
    Objects.requireNonNull(
      status,
      "status"
    );
  }

  public static GetChargingProfilesResponse of(GetChargingProfileStatusEnum status) {
    return new GetChargingProfilesResponse(
      null,
      status,
      null
    );
  }
  public static GetChargingProfilesResponse of(
    @Nullable CustomData customData,
    GetChargingProfileStatusEnum status,
    @Nullable StatusInfo statusInfo
  ) {
    return new GetChargingProfilesResponse(
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
    return Ocpp201Action.GET_CHARGING_PROFILES;
  }

  /**
   * Closed wire enumeration generated from v201 reusable definition
   * GetChargingProfileStatusEnumType.
   */
  public enum GetChargingProfileStatusEnum {
    ACCEPTED("Accepted"), NO_PROFILES("NoProfiles");

    private final String wireValue;

    GetChargingProfileStatusEnum(String wireValue) {
      this.wireValue = wireValue;
    }

    @JsonValue
    public String wireValue() {
      return wireValue;
    }

    @JsonCreator
    public static GetChargingProfileStatusEnum fromWireValue(String wireValue) {
      Objects.requireNonNull(
        wireValue,
        "wireValue"
      );
      return switch (wireValue) {
        case "Accepted" -> ACCEPTED;
        case "NoProfiles" -> NO_PROFILES;
        default ->
          throw new IllegalArgumentException("Unknown GetChargingProfileStatusEnum: " + wireValue);
      };
    }
  }
}
