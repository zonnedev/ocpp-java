package io.github.zonnedev.ocpp.codec;

import org.jspecify.annotations.Nullable;

public sealed class OcppCodecException extends RuntimeException
  permits OcppEncodingException, OcppDecodingException {
  private static final long serialVersionUID = 1L;
  protected OcppCodecException(
    String message,
    @Nullable Throwable cause
  ) {
    super(message, cause);
  }
}
