package io.github.zonnedev.ocpp.v201.model.type;

import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * Immutable schema type generated from v201 reusable definition
 * MessageContentType.
 */
public record MessageContent(
  String content,
  @Nullable CustomData customData,
  MessageFormatEnum format,
  @Nullable String language
) {
  public MessageContent {
    Objects.requireNonNull(
      content,
      "content"
    );
    if (content.length() > 512) {
      throw new IllegalArgumentException("content length violates schema constraints");
    }
    Objects.requireNonNull(
      format,
      "format"
    );
    if (language != null && (language.length() > 8)) {
      throw new IllegalArgumentException("language length violates schema constraints");
    }
  }

  public static MessageContent of(
    String content,
    MessageFormatEnum format
  ) {
    return new MessageContent(
      content,
      null,
      format,
      null
    );
  }
  public static MessageContent of(
    String content,
    @Nullable CustomData customData,
    MessageFormatEnum format,
    @Nullable String language
  ) {
    return new MessageContent(
      content,
      customData,
      format,
      language
    );
  }
}
