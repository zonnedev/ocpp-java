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
 * schemas/v201/NotifyEVChargingNeedsResponse.json.
 */
public record NotifyEVChargingNeedsResponse(
  @Nullable CustomData customData,
  NotifyEVChargingNeedsStatusEnum status,
  @Nullable StatusInfo statusInfo
) implements Ocpp201Response {
  public NotifyEVChargingNeedsResponse {
    Objects.requireNonNull(
      status,
      "status"
    );
  }

  public static NotifyEVChargingNeedsResponse of(NotifyEVChargingNeedsStatusEnum status) {
    return new NotifyEVChargingNeedsResponse(
      null,
      status,
      null
    );
  }
  public static NotifyEVChargingNeedsResponse of(
    @Nullable CustomData customData,
    NotifyEVChargingNeedsStatusEnum status,
    @Nullable StatusInfo statusInfo
  ) {
    return new NotifyEVChargingNeedsResponse(
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
    return Ocpp201Action.NOTIFY_EVCHARGING_NEEDS;
  }

  /**
   * Closed wire enumeration generated from v201 reusable definition
   * NotifyEVChargingNeedsStatusEnumType.
   */
  public enum NotifyEVChargingNeedsStatusEnum {
    ACCEPTED("Accepted"), REJECTED("Rejected"), PROCESSING("Processing");

    private final String wireValue;

    NotifyEVChargingNeedsStatusEnum(String wireValue) {
      this.wireValue = wireValue;
    }

    @JsonValue
    public String wireValue() {
      return wireValue;
    }

    @JsonCreator
    public static NotifyEVChargingNeedsStatusEnum fromWireValue(String wireValue) {
      Objects.requireNonNull(
        wireValue,
        "wireValue"
      );
      return switch (wireValue) {
        case "Accepted" -> ACCEPTED;
        case "Rejected" -> REJECTED;
        case "Processing" -> PROCESSING;
        default ->
          throw new IllegalArgumentException(
            "Unknown NotifyEVChargingNeedsStatusEnum: " + wireValue
          );
      };
    }
  }
}
