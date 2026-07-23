package io.github.zonnedev.ocpp.v16.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.github.zonnedev.ocpp.api.OcppVersion;
import io.github.zonnedev.ocpp.v16.Ocpp16Action;
import io.github.zonnedev.ocpp.v16.Ocpp16Response;

/**
 * Immutable schema type generated from
 * schemas/v16/GetLocalListVersionResponse.json.
 */
public record GetLocalListVersionResponse(
  int listVersion
) implements Ocpp16Response {
  public GetLocalListVersionResponse {

  }

  public static GetLocalListVersionResponse of(int listVersion) {
    return new GetLocalListVersionResponse(listVersion);
  }

  @JsonIgnore
  @Override
  public OcppVersion version() {
    return OcppVersion.OCPP_1_6_JSON;
  }

  @JsonIgnore
  @Override
  public Ocpp16Action action() {
    return Ocpp16Action.GET_LOCAL_LIST_VERSION;
  }
}
