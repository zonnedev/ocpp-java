package io.github.zonnedev.ocpp.v16.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.github.zonnedev.ocpp.api.OcppVersion;
import io.github.zonnedev.ocpp.v16.Ocpp16Action;
import io.github.zonnedev.ocpp.v16.Ocpp16Request;

/**
 * Immutable schema type generated from schemas/v16/GetLocalListVersion.json.
 */
public record GetLocalListVersionRequest(

) implements Ocpp16Request {
  public GetLocalListVersionRequest {

  }

  private static final GetLocalListVersionRequest INSTANCE = new GetLocalListVersionRequest();

  public static GetLocalListVersionRequest of() {
    return INSTANCE;
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
