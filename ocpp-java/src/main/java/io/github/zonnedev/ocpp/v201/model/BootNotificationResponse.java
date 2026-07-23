package io.github.zonnedev.ocpp.v201.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.zonnedev.ocpp.api.OcppVersion;
import io.github.zonnedev.ocpp.v201.Ocpp201Action;
import io.github.zonnedev.ocpp.v201.Ocpp201Response;
import io.github.zonnedev.ocpp.v201.model.type.CustomData;
import io.github.zonnedev.ocpp.v201.model.type.StatusInfo;
import java.time.Instant;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * Immutable schema type generated from
 * schemas/v201/BootNotificationResponse.json.
 */
public record BootNotificationResponse(
  Instant currentTime,
  @Nullable CustomData customData,
  int interval,
  RegistrationStatusEnum status,
  @Nullable StatusInfo statusInfo
) implements Ocpp201Response {
  public BootNotificationResponse {
    Objects.requireNonNull(
      currentTime,
      "currentTime"
    );
    Objects.requireNonNull(
      status,
      "status"
    );
  }

  public static BootNotificationResponse of(
    Instant currentTime,
    int interval,
    RegistrationStatusEnum status
  ) {
    return new BootNotificationResponse(
      currentTime,
      null,
      interval,
      status,
      null
    );
  }
  public static BootNotificationResponse of(
    Instant currentTime,
    @Nullable CustomData customData,
    int interval,
    RegistrationStatusEnum status,
    @Nullable StatusInfo statusInfo
  ) {
    return new BootNotificationResponse(
      currentTime,
      customData,
      interval,
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
    return Ocpp201Action.BOOT_NOTIFICATION;
  }

  /**
   * Closed wire enumeration generated from v201 reusable definition
   * RegistrationStatusEnumType.
   */
  public enum RegistrationStatusEnum {
    ACCEPTED("Accepted"), PENDING("Pending"), REJECTED("Rejected");

    private final String wireValue;

    RegistrationStatusEnum(String wireValue) {
      this.wireValue = wireValue;
    }

    @JsonValue
    public String wireValue() {
      return wireValue;
    }

    @JsonCreator
    public static RegistrationStatusEnum fromWireValue(String wireValue) {
      Objects.requireNonNull(
        wireValue,
        "wireValue"
      );
      return switch (wireValue) {
        case "Accepted" -> ACCEPTED;
        case "Pending" -> PENDING;
        case "Rejected" -> REJECTED;
        default ->
          throw new IllegalArgumentException("Unknown RegistrationStatusEnum: " + wireValue);
      };
    }
  }
}
