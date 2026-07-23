package io.github.zonnedev.ocpp.api;

public sealed interface OcppPayload permits OcppRequest, OcppResponse {
  OcppVersion version();
  OcppAction action();
}
