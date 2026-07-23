package io.github.zonnedev.ocpp.codec;

import org.jspecify.annotations.Nullable;

public final class OcppEncodingException extends OcppCodecException {
  private static final long serialVersionUID = 1L;
  public OcppEncodingException(
    String message,
    @Nullable Throwable cause
  ) {
    super(message, cause);
  }
}
