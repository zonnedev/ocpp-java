package io.github.zonnedev.ocpp.v201.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.github.zonnedev.ocpp.api.OcppVersion;
import io.github.zonnedev.ocpp.v201.Ocpp201Action;
import io.github.zonnedev.ocpp.v201.Ocpp201Response;
import io.github.zonnedev.ocpp.v201.model.type.CustomData;
import org.jspecify.annotations.Nullable;

/**
 * Immutable schema type generated from
 * schemas/v201/LogStatusNotificationResponse.json.
 */
public record LogStatusNotificationResponse(
  @Nullable CustomData customData
) implements Ocpp201Response {
  public LogStatusNotificationResponse {

  }

  public static LogStatusNotificationResponse of() {
    return new LogStatusNotificationResponse(null);
  }
  public static LogStatusNotificationResponse of(@Nullable CustomData customData) {
    return new LogStatusNotificationResponse(customData);
  }

  @JsonIgnore
  @Override
  public OcppVersion version() {
    return OcppVersion.OCPP_2_0_1;
  }

  @JsonIgnore
  @Override
  public Ocpp201Action action() {
    return Ocpp201Action.LOG_STATUS_NOTIFICATION;
  }
}
