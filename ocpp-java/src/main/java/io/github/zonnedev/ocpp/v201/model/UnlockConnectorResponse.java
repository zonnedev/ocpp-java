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
 * schemas/v201/UnlockConnectorResponse.json.
 */
public record UnlockConnectorResponse(
  @Nullable CustomData customData,
  UnlockStatusEnum status,
  @Nullable StatusInfo statusInfo
) implements Ocpp201Response {
  public UnlockConnectorResponse {
    Objects.requireNonNull(
      status,
      "status"
    );
  }

  public static UnlockConnectorResponse of(UnlockStatusEnum status) {
    return new UnlockConnectorResponse(
      null,
      status,
      null
    );
  }
  public static UnlockConnectorResponse of(
    @Nullable CustomData customData,
    UnlockStatusEnum status,
    @Nullable StatusInfo statusInfo
  ) {
    return new UnlockConnectorResponse(
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
    return Ocpp201Action.UNLOCK_CONNECTOR;
  }

  /**
   * Closed wire enumeration generated from v201 reusable definition
   * UnlockStatusEnumType.
   */
  public enum UnlockStatusEnum {
    UNLOCKED("Unlocked"), UNLOCK_FAILED("UnlockFailed"), ONGOING_AUTHORIZED_TRANSACTION(
      "OngoingAuthorizedTransaction"
    ), UNKNOWN_CONNECTOR("UnknownConnector");

    private final String wireValue;

    UnlockStatusEnum(String wireValue) {
      this.wireValue = wireValue;
    }

    @JsonValue
    public String wireValue() {
      return wireValue;
    }

    @JsonCreator
    public static UnlockStatusEnum fromWireValue(String wireValue) {
      Objects.requireNonNull(
        wireValue,
        "wireValue"
      );
      return switch (wireValue) {
        case "Unlocked" -> UNLOCKED;
        case "UnlockFailed" -> UNLOCK_FAILED;
        case "OngoingAuthorizedTransaction" -> ONGOING_AUTHORIZED_TRANSACTION;
        case "UnknownConnector" -> UNKNOWN_CONNECTOR;
        default -> throw new IllegalArgumentException("Unknown UnlockStatusEnum: " + wireValue);
      };
    }
  }
}
