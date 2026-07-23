package io.github.zonnedev.ocpp.v201.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.github.zonnedev.ocpp.api.OcppVersion;
import io.github.zonnedev.ocpp.v201.Ocpp201Action;
import io.github.zonnedev.ocpp.v201.Ocpp201Request;
import io.github.zonnedev.ocpp.v201.model.type.CustomData;
import io.github.zonnedev.ocpp.v201.model.type.MessageInfo;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * Immutable schema type generated from
 * schemas/v201/SetDisplayMessageRequest.json.
 */
public record SetDisplayMessageRequest(
  @Nullable CustomData customData,
  MessageInfo message
) implements Ocpp201Request {
  public SetDisplayMessageRequest {
    Objects.requireNonNull(
      message,
      "message"
    );
  }

  public static SetDisplayMessageRequest of(MessageInfo message) {
    return new SetDisplayMessageRequest(
      null,
      message
    );
  }
  public static SetDisplayMessageRequest of(
    @Nullable CustomData customData,
    MessageInfo message
  ) {
    return new SetDisplayMessageRequest(
      customData,
      message
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
    return Ocpp201Action.SET_DISPLAY_MESSAGE;
  }
}
