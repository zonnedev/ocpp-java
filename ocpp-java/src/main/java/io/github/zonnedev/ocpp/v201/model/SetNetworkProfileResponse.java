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
 * schemas/v201/SetNetworkProfileResponse.json.
 */
public record SetNetworkProfileResponse(
  @Nullable CustomData customData,
  SetNetworkProfileStatusEnum status,
  @Nullable StatusInfo statusInfo
) implements Ocpp201Response {
  public SetNetworkProfileResponse {
    Objects.requireNonNull(
      status,
      "status"
    );
  }

  public static SetNetworkProfileResponse of(SetNetworkProfileStatusEnum status) {
    return new SetNetworkProfileResponse(
      null,
      status,
      null
    );
  }
  public static SetNetworkProfileResponse of(
    @Nullable CustomData customData,
    SetNetworkProfileStatusEnum status,
    @Nullable StatusInfo statusInfo
  ) {
    return new SetNetworkProfileResponse(
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
    return Ocpp201Action.SET_NETWORK_PROFILE;
  }

  /**
   * Closed wire enumeration generated from v201 reusable definition
   * SetNetworkProfileStatusEnumType.
   */
  public enum SetNetworkProfileStatusEnum {
    ACCEPTED("Accepted"), REJECTED("Rejected"), FAILED("Failed");

    private final String wireValue;

    SetNetworkProfileStatusEnum(String wireValue) {
      this.wireValue = wireValue;
    }

    @JsonValue
    public String wireValue() {
      return wireValue;
    }

    @JsonCreator
    public static SetNetworkProfileStatusEnum fromWireValue(String wireValue) {
      Objects.requireNonNull(
        wireValue,
        "wireValue"
      );
      return switch (wireValue) {
        case "Accepted" -> ACCEPTED;
        case "Rejected" -> REJECTED;
        case "Failed" -> FAILED;
        default ->
          throw new IllegalArgumentException("Unknown SetNetworkProfileStatusEnum: " + wireValue);
      };
    }
  }
}
