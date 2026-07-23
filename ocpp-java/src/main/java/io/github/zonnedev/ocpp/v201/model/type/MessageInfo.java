package io.github.zonnedev.ocpp.v201.model.type;

import java.time.Instant;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * Immutable schema type generated from v201 reusable definition
 * MessageInfoType.
 */
public record MessageInfo(
  @Nullable CustomData customData,
  @Nullable Component display,
  @Nullable Instant endDateTime,
  int id,
  MessageContent message,
  MessagePriorityEnum priority,
  @Nullable Instant startDateTime,
  @Nullable MessageStateEnum state,
  @Nullable String transactionId
) {
  public MessageInfo {
    Objects.requireNonNull(
      message,
      "message"
    );
    Objects.requireNonNull(
      priority,
      "priority"
    );
    if (transactionId != null && (transactionId.length() > 36)) {
      throw new IllegalArgumentException("transactionId length violates schema constraints");
    }
  }

  public static MessageInfo of(
    int id,
    MessageContent message,
    MessagePriorityEnum priority
  ) {
    return new MessageInfo(
      null,
      null,
      null,
      id,
      message,
      priority,
      null,
      null,
      null
    );
  }
  public static MessageInfo of(
    @Nullable CustomData customData,
    @Nullable Component display,
    @Nullable Instant endDateTime,
    int id,
    MessageContent message,
    MessagePriorityEnum priority,
    @Nullable Instant startDateTime,
    @Nullable MessageStateEnum state,
    @Nullable String transactionId
  ) {
    return new MessageInfo(
      customData,
      display,
      endDateTime,
      id,
      message,
      priority,
      startDateTime,
      state,
      transactionId
    );
  }
}
