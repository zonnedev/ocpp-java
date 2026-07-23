package io.github.zonnedev.ocpp.codec;

import org.jspecify.annotations.Nullable;

public sealed class OcppDecodingException extends OcppCodecException
  permits UnknownDataTransferOperationException {
  private static final long serialVersionUID = 1L;
  public OcppDecodingException(
    String message,
    @Nullable Throwable cause
  ) {
    super(message, cause);
  }
}
