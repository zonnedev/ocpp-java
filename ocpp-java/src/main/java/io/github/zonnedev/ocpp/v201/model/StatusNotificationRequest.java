package io.github.zonnedev.ocpp.v201.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.zonnedev.ocpp.api.OcppVersion;
import io.github.zonnedev.ocpp.v201.Ocpp201Action;
import io.github.zonnedev.ocpp.v201.Ocpp201Request;
import io.github.zonnedev.ocpp.v201.model.type.CustomData;
import java.time.Instant;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * Immutable schema type generated from
 * schemas/v201/StatusNotificationRequest.json.
 */
public record StatusNotificationRequest(
  int connectorId,
  ConnectorStatusEnum connectorStatus,
  @Nullable CustomData customData,
  int evseId,
  Instant timestamp
) implements Ocpp201Request {
  public StatusNotificationRequest {
    Objects.requireNonNull(
      connectorStatus,
      "connectorStatus"
    );
    Objects.requireNonNull(
      timestamp,
      "timestamp"
    );
  }

  public static StatusNotificationRequest of(
    int connectorId,
    ConnectorStatusEnum connectorStatus,
    int evseId,
    Instant timestamp
  ) {
    return new StatusNotificationRequest(
      connectorId,
      connectorStatus,
      null,
      evseId,
      timestamp
    );
  }
  public static StatusNotificationRequest of(
    int connectorId,
    ConnectorStatusEnum connectorStatus,
    @Nullable CustomData customData,
    int evseId,
    Instant timestamp
  ) {
    return new StatusNotificationRequest(
      connectorId,
      connectorStatus,
      customData,
      evseId,
      timestamp
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
    return Ocpp201Action.STATUS_NOTIFICATION;
  }

  /**
   * Closed wire enumeration generated from v201 reusable definition
   * ConnectorStatusEnumType.
   */
  public enum ConnectorStatusEnum {
    AVAILABLE("Available"), OCCUPIED("Occupied"), RESERVED("Reserved"), UNAVAILABLE(
      "Unavailable"
    ), FAULTED("Faulted");

    private final String wireValue;

    ConnectorStatusEnum(String wireValue) {
      this.wireValue = wireValue;
    }

    @JsonValue
    public String wireValue() {
      return wireValue;
    }

    @JsonCreator
    public static ConnectorStatusEnum fromWireValue(String wireValue) {
      Objects.requireNonNull(
        wireValue,
        "wireValue"
      );
      return switch (wireValue) {
        case "Available" -> AVAILABLE;
        case "Occupied" -> OCCUPIED;
        case "Reserved" -> RESERVED;
        case "Unavailable" -> UNAVAILABLE;
        case "Faulted" -> FAULTED;
        default -> throw new IllegalArgumentException("Unknown ConnectorStatusEnum: " + wireValue);
      };
    }
  }
}
