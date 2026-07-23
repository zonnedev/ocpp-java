package io.github.zonnedev.ocpp.api;

import io.github.zonnedev.ocpp.v16.Ocpp16Request;
import io.github.zonnedev.ocpp.v201.Ocpp201Request;

public sealed interface OcppRequest extends OcppPayload permits Ocpp16Request, Ocpp201Request {
}
