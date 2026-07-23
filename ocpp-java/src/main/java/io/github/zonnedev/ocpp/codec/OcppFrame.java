package io.github.zonnedev.ocpp.codec;

public sealed interface OcppFrame
  permits OcppRequestMessage, OcppResponseMessage, OcppErrorMessage {
  int messageTypeId();
  String messageId();
}
