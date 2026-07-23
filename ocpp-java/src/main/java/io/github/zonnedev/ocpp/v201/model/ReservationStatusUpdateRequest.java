package io.github.zonnedev.ocpp.v201.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.zonnedev.ocpp.api.OcppVersion;
import io.github.zonnedev.ocpp.v201.Ocpp201Action;
import io.github.zonnedev.ocpp.v201.Ocpp201Request;
import io.github.zonnedev.ocpp.v201.model.type.CustomData;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * Immutable schema type generated from
 * schemas/v201/ReservationStatusUpdateRequest.json.
 */
public record ReservationStatusUpdateRequest(
  @Nullable CustomData customData,
  int reservationId,
  ReservationUpdateStatusEnum reservationUpdateStatus
) implements Ocpp201Request {
  public ReservationStatusUpdateRequest {
    Objects.requireNonNull(
      reservationUpdateStatus,
      "reservationUpdateStatus"
    );
  }

  public static ReservationStatusUpdateRequest of(
    int reservationId,
    ReservationUpdateStatusEnum reservationUpdateStatus
  ) {
    return new ReservationStatusUpdateRequest(
      null,
      reservationId,
      reservationUpdateStatus
    );
  }
  public static ReservationStatusUpdateRequest of(
    @Nullable CustomData customData,
    int reservationId,
    ReservationUpdateStatusEnum reservationUpdateStatus
  ) {
    return new ReservationStatusUpdateRequest(
      customData,
      reservationId,
      reservationUpdateStatus
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
    return Ocpp201Action.RESERVATION_STATUS_UPDATE;
  }

  /**
   * Closed wire enumeration generated from v201 reusable definition
   * ReservationUpdateStatusEnumType.
   */
  public enum ReservationUpdateStatusEnum {
    EXPIRED("Expired"), REMOVED("Removed");

    private final String wireValue;

    ReservationUpdateStatusEnum(String wireValue) {
      this.wireValue = wireValue;
    }

    @JsonValue
    public String wireValue() {
      return wireValue;
    }

    @JsonCreator
    public static ReservationUpdateStatusEnum fromWireValue(String wireValue) {
      Objects.requireNonNull(
        wireValue,
        "wireValue"
      );
      return switch (wireValue) {
        case "Expired" -> EXPIRED;
        case "Removed" -> REMOVED;
        default ->
          throw new IllegalArgumentException("Unknown ReservationUpdateStatusEnum: " + wireValue);
      };
    }
  }
}
