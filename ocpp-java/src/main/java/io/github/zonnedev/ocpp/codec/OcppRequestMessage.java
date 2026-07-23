package io.github.zonnedev.ocpp.codec;

import io.github.zonnedev.ocpp.api.OcppActionDefinition;
import io.github.zonnedev.ocpp.api.OcppRequest;
import java.util.Objects;

public record OcppRequestMessage<Q extends OcppRequest>(
  String messageId,
  OcppActionDefinition<Q, ?> definition,
  Q payload
) implements OcppFrame {
  public static final int MESSAGE_TYPE_ID = 2;

  public OcppRequestMessage {
    if (Objects.requireNonNull(
      messageId,
      "messageId"
    )
      .isEmpty()) {
      throw new IllegalArgumentException("messageId is empty");
    }
    Objects.requireNonNull(
      definition,
      "definition"
    );
    Objects.requireNonNull(
      payload,
      "payload"
    );
    if (!definition.requestType()
      .isInstance(payload)
      || payload.action() != definition.action()) {
      throw new IllegalArgumentException("Payload does not match action definition");
    }
  }

  public static <Q extends OcppRequest> OcppRequestMessage<Q> of(
    String id,
    OcppActionDefinition<Q, ?> definition,
    Q payload
  ) {
    return new OcppRequestMessage<>(
      id,
      definition,
      payload
    );
  }

  @Override
  public int messageTypeId() {
    return MESSAGE_TYPE_ID;
  }
}
