package io.github.zonnedev.ocpp.v201.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.github.zonnedev.ocpp.api.OcppVersion;
import io.github.zonnedev.ocpp.v201.Ocpp201Action;
import io.github.zonnedev.ocpp.v201.Ocpp201Request;
import io.github.zonnedev.ocpp.v201.model.type.CustomData;
import java.time.Instant;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * Immutable schema type generated from
 * schemas/v201/SecurityEventNotificationRequest.json.
 */
public record SecurityEventNotificationRequest(
  @Nullable CustomData customData,
  @Nullable String techInfo,
  Instant timestamp,
  String type
) implements Ocpp201Request {
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
      null,
      timestamp,
      type
    );
  }
  public static SecurityEventNotificationRequest of(
    @Nullable CustomData customData,
    @Nullable String techInfo,
    Instant timestamp,
    String type
  ) {
    return new SecurityEventNotificationRequest(
      customData,
      techInfo,
      timestamp,
      type
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
    return Ocpp201Action.SECURITY_EVENT_NOTIFICATION;
  }
}
