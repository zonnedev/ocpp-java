package io.github.zonnedev.ocpp.v201.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.zonnedev.ocpp.api.OcppVersion;
import io.github.zonnedev.ocpp.v201.Ocpp201Action;
import io.github.zonnedev.ocpp.v201.Ocpp201Request;
import io.github.zonnedev.ocpp.v201.model.type.CustomData;
import io.github.zonnedev.ocpp.v201.model.type.EVSE;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * Immutable schema type generated from
 * schemas/v201/ChangeAvailabilityRequest.json.
 */
public record ChangeAvailabilityRequest(
  @Nullable CustomData customData,
  @Nullable EVSE evse,
  OperationalStatusEnum operationalStatus
) implements Ocpp201Request {
  public ChangeAvailabilityRequest {
    Objects.requireNonNull(
      operationalStatus,
      "operationalStatus"
    );
  }

  public static ChangeAvailabilityRequest of(OperationalStatusEnum operationalStatus) {
    return new ChangeAvailabilityRequest(
      null,
      null,
      operationalStatus
    );
  }
  public static ChangeAvailabilityRequest of(
    @Nullable CustomData customData,
    @Nullable EVSE evse,
    OperationalStatusEnum operationalStatus
  ) {
    return new ChangeAvailabilityRequest(
      customData,
      evse,
      operationalStatus
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
   * OperationalStatusEnumType.
   */
  public enum OperationalStatusEnum {
    INOPERATIVE("Inoperative"), OPERATIVE("Operative");

    private final String wireValue;

    OperationalStatusEnum(String wireValue) {
      this.wireValue = wireValue;
    }

    @JsonValue
    public String wireValue() {
      return wireValue;
    }

    @JsonCreator
    public static OperationalStatusEnum fromWireValue(String wireValue) {
      Objects.requireNonNull(
        wireValue,
        "wireValue"
      );
      return switch (wireValue) {
        case "Inoperative" -> INOPERATIVE;
        case "Operative" -> OPERATIVE;
        default ->
          throw new IllegalArgumentException("Unknown OperationalStatusEnum: " + wireValue);
      };
    }
  }
}
