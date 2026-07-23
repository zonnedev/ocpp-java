package io.github.zonnedev.ocpp.v16.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.github.zonnedev.ocpp.api.OcppVersion;
import io.github.zonnedev.ocpp.v16.Ocpp16Action;
import io.github.zonnedev.ocpp.v16.Ocpp16Response;

/**
 * Immutable schema type generated from
 * schemas/v16/SignedFirmwareStatusNotificationResponse.json.
 */
public record SignedFirmwareStatusNotificationResponse(

) implements Ocpp16Response {
  public SignedFirmwareStatusNotificationResponse {

  }

  private static final SignedFirmwareStatusNotificationResponse INSTANCE = new SignedFirmwareStatusNotificationResponse();

  public static SignedFirmwareStatusNotificationResponse of() {
    return INSTANCE;
  }

  @JsonIgnore
  @Override
  public OcppVersion version() {
    return OcppVersion.OCPP_1_6_JSON;
  }

  @JsonIgnore
  @Override
  public Ocpp16Action action() {
    return Ocpp16Action.SIGNED_FIRMWARE_STATUS_NOTIFICATION;
  }
}
