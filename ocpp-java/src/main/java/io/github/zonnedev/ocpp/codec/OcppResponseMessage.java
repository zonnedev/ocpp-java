package io.github.zonnedev.ocpp.codec;

import io.github.zonnedev.ocpp.api.OcppActionDefinition;
import io.github.zonnedev.ocpp.api.OcppResponse;
import java.util.Objects;

public record OcppResponseMessage<S extends OcppResponse>(
  String messageId,
  OcppActionDefinition<?, S> definition,
  S payload
) implements OcppFrame {
  public static final int MESSAGE_TYPE_ID = 3;

  public OcppResponseMessage {
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
    if (!definition.responseType()
      .isInstance(payload)
      || payload.action() != definition.action()) {
      throw new IllegalArgumentException("Payload does not match action definition");
    }
  }

  public static <S extends OcppResponse> OcppResponseMessage<S> of(
    String id,
    OcppActionDefinition<?, S> definition,
    S payload
  ) {
    return new OcppResponseMessage<>(
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
