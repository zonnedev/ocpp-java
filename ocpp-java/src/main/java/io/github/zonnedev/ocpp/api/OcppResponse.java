package io.github.zonnedev.ocpp.api;

import io.github.zonnedev.ocpp.v16.Ocpp16Response;
import io.github.zonnedev.ocpp.v201.Ocpp201Response;

public sealed interface OcppResponse extends OcppPayload permits Ocpp16Response, Ocpp201Response {
}
