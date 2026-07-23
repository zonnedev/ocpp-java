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
 * schemas/v201/SetChargingProfileResponse.json.
 */
public record SetChargingProfileResponse(
  @Nullable CustomData customData,
  ChargingProfileStatusEnum status,
  @Nullable StatusInfo statusInfo
) implements Ocpp201Response {
  public SetChargingProfileResponse {
    Objects.requireNonNull(
      status,
      "status"
    );
  }

  public static SetChargingProfileResponse of(ChargingProfileStatusEnum status) {
    return new SetChargingProfileResponse(
      null,
      status,
      null
    );
  }
  public static SetChargingProfileResponse of(
    @Nullable CustomData customData,
    ChargingProfileStatusEnum status,
    @Nullable StatusInfo statusInfo
  ) {
    return new SetChargingProfileResponse(
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
    return Ocpp201Action.SET_CHARGING_PROFILE;
  }

  /**
   * Closed wire enumeration generated from v201 reusable definition
   * ChargingProfileStatusEnumType.
   */
  public enum ChargingProfileStatusEnum {
    ACCEPTED("Accepted"), REJECTED("Rejected");

    private final String wireValue;

    ChargingProfileStatusEnum(String wireValue) {
      this.wireValue = wireValue;
    }

    @JsonValue
    public String wireValue() {
      return wireValue;
    }

    @JsonCreator
    public static ChargingProfileStatusEnum fromWireValue(String wireValue) {
      Objects.requireNonNull(
        wireValue,
        "wireValue"
      );
      return switch (wireValue) {
        case "Accepted" -> ACCEPTED;
        case "Rejected" -> REJECTED;
        default ->
          throw new IllegalArgumentException("Unknown ChargingProfileStatusEnum: " + wireValue);
      };
    }
  }
}
