package io.github.zonnedev.ocpp.v16.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.github.zonnedev.ocpp.api.OcppVersion;
import io.github.zonnedev.ocpp.v16.Ocpp16Action;
import io.github.zonnedev.ocpp.v16.Ocpp16Response;

/**
 * Immutable schema type generated from
 * schemas/v16/DiagnosticsStatusNotificationResponse.json.
 */
public record DiagnosticsStatusNotificationResponse(

) implements Ocpp16Response {
  public DiagnosticsStatusNotificationResponse {

  }

  private static final DiagnosticsStatusNotificationResponse INSTANCE = new DiagnosticsStatusNotificationResponse();

  public static DiagnosticsStatusNotificationResponse of() {
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
    return Ocpp16Action.DIAGNOSTICS_STATUS_NOTIFICATION;
  }
}
