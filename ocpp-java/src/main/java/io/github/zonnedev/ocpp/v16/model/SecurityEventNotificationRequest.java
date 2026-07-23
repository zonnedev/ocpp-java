package io.github.zonnedev.ocpp.v16.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.time.Instant;
import java.util.Objects;
import org.jspecify.annotations.Nullable;
import io.github.zonnedev.ocpp.api.OcppVersion;
import io.github.zonnedev.ocpp.v16.Ocpp16Action;
import io.github.zonnedev.ocpp.v16.Ocpp16Request;

/**
 * Immutable schema type generated from
 * schemas/v16/SecurityEventNotification.json.
 */
public record SecurityEventNotificationRequest(
  @Nullable String techInfo,
  Instant timestamp,
  String type
) implements Ocpp16Request {
  public SecurityEventNotificationRequest {
    if (techInfo != null && (techInfo.length() > 255)) {
      throw new IllegalArgumentException("techInfo length violates schema constraints");
    }
    Objects.requireNonNull(
      timestamp,
      "timestamp"
    );
    Objects.requireNonNull(
      type,
      "type"
    );
    if (type.length() > 50) {
      throw new IllegalArgumentException("type length violates schema constraints");
    }
  }

  public static SecurityEventNotificationRequest of(
    Instant timestamp,
    String type
  ) {
    return new SecurityEventNotificationRequest(
      null,
      timestamp,
      type
    );
  }
  public static SecurityEventNotificationRequest of(
    @Nullable String techInfo,
    Instant timestamp,
    String type
  ) {
    return new SecurityEventNotificationRequest(
      techInfo,
      timestamp,
      type
    );
  }

  @JsonIgnore
  @Override
  public OcppVersion version() {
    return OcppVersion.OCPP_1_6_JSON;
  }

  @JsonIgnore
  @Override
  public Ocpp16Action action() {
    return Ocpp16Action.SECURITY_EVENT_NOTIFICATION;
  }
}
