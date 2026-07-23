package io.github.zonnedev.ocpp.v16.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.github.zonnedev.ocpp.api.OcppVersion;
import io.github.zonnedev.ocpp.v16.Ocpp16Action;
import io.github.zonnedev.ocpp.v16.Ocpp16Response;

/**
 * Immutable schema type generated from
 * schemas/v16/LogStatusNotificationResponse.json.
 */
public record LogStatusNotificationResponse(

) implements Ocpp16Response {
  public LogStatusNotificationResponse {

  }

  private static final LogStatusNotificationResponse INSTANCE = new LogStatusNotificationResponse();

  public static LogStatusNotificationResponse of() {
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
    return Ocpp16Action.LOG_STATUS_NOTIFICATION;
  }
}
