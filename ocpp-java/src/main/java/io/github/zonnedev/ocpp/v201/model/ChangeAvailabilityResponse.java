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
 * schemas/v201/ChangeAvailabilityResponse.json.
 */
public record ChangeAvailabilityResponse(
  @Nullable CustomData customData,
  ChangeAvailabilityStatusEnum status,
  @Nullable StatusInfo statusInfo
) implements Ocpp201Response {
  public ChangeAvailabilityResponse {
    Objects.requireNonNull(
      status,
      "status"
    );
  }

  public static ChangeAvailabilityResponse of(ChangeAvailabilityStatusEnum status) {
    return new ChangeAvailabilityResponse(
      null,
      status,
      null
    );
  }
  public static ChangeAvailabilityResponse of(
    @Nullable CustomData customData,
    ChangeAvailabilityStatusEnum status,
    @Nullable StatusInfo statusInfo
  ) {
    return new ChangeAvailabilityResponse(
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
    return Ocpp201Action.CHANGE_AVAILABILITY;
  }

  /**
   * Closed wire enumeration generated from v201 reusable definition
   * ChangeAvailabilityStatusEnumType.
   */
  public enum ChangeAvailabilityStatusEnum {
    ACCEPTED("Accepted"), REJECTED("Rejected"), SCHEDULED("Scheduled");

    private final String wireValue;

    ChangeAvailabilityStatusEnum(String wireValue) {
      this.wireValue = wireValue;
    }

    @JsonValue
    public String wireValue() {
      return wireValue;
    }

    @JsonCreator
    public static ChangeAvailabilityStatusEnum fromWireValue(String wireValue) {
      Objects.requireNonNull(
        wireValue,
        "wireValue"
      );
      return switch (wireValue) {
        case "Accepted" -> ACCEPTED;
        case "Rejected" -> REJECTED;
        case "Scheduled" -> SCHEDULED;
        default ->
          throw new IllegalArgumentException("Unknown ChangeAvailabilityStatusEnum: " + wireValue);
      };
    }
  }
}
