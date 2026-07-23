package io.github.zonnedev.ocpp.api;

import io.github.zonnedev.ocpp.v16.Ocpp16Action;
import io.github.zonnedev.ocpp.v201.Ocpp201Action;

public sealed interface OcppAction permits Ocpp16Action, Ocpp201Action {
  String wireName();
  OcppVersion version();
  Class<? extends OcppRequest> requestType();
  Class<? extends OcppResponse> responseType();
}
