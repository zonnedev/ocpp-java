package io.github.zonnedev.ocpp.v201.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.github.zonnedev.ocpp.api.OcppVersion;
import io.github.zonnedev.ocpp.v201.Ocpp201Action;
import io.github.zonnedev.ocpp.v201.Ocpp201Request;
import io.github.zonnedev.ocpp.v201.model.type.CustomData;
import io.github.zonnedev.ocpp.v201.model.type.MessageInfo;
import java.util.List;
import org.jspecify.annotations.Nullable;

/**
 * Immutable schema type generated from
 * schemas/v201/NotifyDisplayMessagesRequest.json.
 */
public record NotifyDisplayMessagesRequest(
  @Nullable CustomData customData,
  @Nullable List<MessageInfo> messageInfo,
  int requestId,
  @Nullable Boolean tbc
) implements Ocpp201Request {
  public NotifyDisplayMessagesRequest {
    messageInfo = messageInfo == null ? null : List.copyOf(messageInfo);
    if (messageInfo != null && (messageInfo.size() < 1)) {
      throw new IllegalArgumentException("messageInfo size violates schema constraints");
    }
  }

  public static NotifyDisplayMessagesRequest of(int requestId) {
    return new NotifyDisplayMessagesRequest(
      null,
      null,
      requestId,
      null
    );
  }
  public static NotifyDisplayMessagesRequest of(
    @Nullable CustomData customData,
    @Nullable List<MessageInfo> messageInfo,
    int requestId,
    @Nullable Boolean tbc
  ) {
    return new NotifyDisplayMessagesRequest(
      customData,
      messageInfo,
      requestId,
      tbc
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
    return Ocpp201Action.NOTIFY_DISPLAY_MESSAGES;
  }
}
