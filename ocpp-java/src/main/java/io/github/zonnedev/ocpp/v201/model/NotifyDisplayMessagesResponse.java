package io.github.zonnedev.ocpp.v201.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.github.zonnedev.ocpp.api.OcppVersion;
import io.github.zonnedev.ocpp.v201.Ocpp201Action;
import io.github.zonnedev.ocpp.v201.Ocpp201Response;
import io.github.zonnedev.ocpp.v201.model.type.CustomData;
import org.jspecify.annotations.Nullable;

/**
 * Immutable schema type generated from
 * schemas/v201/NotifyDisplayMessagesResponse.json.
 */
public record NotifyDisplayMessagesResponse(
  @Nullable CustomData customData
) implements Ocpp201Response {
  public NotifyDisplayMessagesResponse {

  }

  public static NotifyDisplayMessagesResponse of() {
    return new NotifyDisplayMessagesResponse(null);
  }
  public static NotifyDisplayMessagesResponse of(@Nullable CustomData customData) {
    return new NotifyDisplayMessagesResponse(customData);
  }

  @JsonIgnore
  @Override
  public OcppVersion version() {
    return OcppVersion.OCPP_2_0_1;
  }

  @JsonIgnore
  @Override
  public Ocpp201Action action() {
    return Ocpp201Action.NOTIFY_DISPLAY_MESSAGES;
  }
}
