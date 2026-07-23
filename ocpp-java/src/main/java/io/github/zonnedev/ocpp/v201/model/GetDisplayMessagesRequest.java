package io.github.zonnedev.ocpp.v201.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.github.zonnedev.ocpp.api.OcppVersion;
import io.github.zonnedev.ocpp.v201.Ocpp201Action;
import io.github.zonnedev.ocpp.v201.Ocpp201Request;
import io.github.zonnedev.ocpp.v201.model.type.CustomData;
import io.github.zonnedev.ocpp.v201.model.type.MessagePriorityEnum;
import io.github.zonnedev.ocpp.v201.model.type.MessageStateEnum;
import java.util.List;
import org.jspecify.annotations.Nullable;

/**
 * Immutable schema type generated from
 * schemas/v201/GetDisplayMessagesRequest.json.
 */
public record GetDisplayMessagesRequest(
  @Nullable CustomData customData,
  @Nullable List<Integer> id,
  @Nullable MessagePriorityEnum priority,
  int requestId,
  @Nullable MessageStateEnum state
) implements Ocpp201Request {
  public GetDisplayMessagesRequest {
    id = id == null ? null : List.copyOf(id);
    if (id != null && (id.size() < 1)) {
      throw new IllegalArgumentException("id size violates schema constraints");
    }
  }

  public static GetDisplayMessagesRequest of(int requestId) {
    return new GetDisplayMessagesRequest(
      null,
      null,
      null,
      requestId,
      null
    );
  }
  public static GetDisplayMessagesRequest of(
    @Nullable CustomData customData,
    @Nullable List<Integer> id,
    @Nullable MessagePriorityEnum priority,
    int requestId,
    @Nullable MessageStateEnum state
  ) {
    return new GetDisplayMessagesRequest(
      customData,
      id,
      priority,
      requestId,
      state
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
    return Ocpp201Action.GET_DISPLAY_MESSAGES;
  }
}
