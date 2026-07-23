package io.github.zonnedev.ocpp.codec;

import java.util.Objects;

public record OcppErrorMessage(String messageId, OcppError error) implements OcppFrame {
  public static final int MESSAGE_TYPE_ID = 4;
  public OcppErrorMessage {
    if (Objects.requireNonNull(
      messageId,
      "messageId"
    )
      .isEmpty()) {
      throw new IllegalArgumentException("messageId is empty");
    }
    Objects.requireNonNull(
      error,
      "error"
    );
  }
  public static OcppErrorMessage of(
    String id,
    OcppError error
  ) {
    return new OcppErrorMessage(
      id,
      error
    );
  }
  @Override
  public int messageTypeId() {
    return MESSAGE_TYPE_ID;
  }
}
