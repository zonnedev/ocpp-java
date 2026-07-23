package io.github.zonnedev.ocpp.v16.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.github.zonnedev.ocpp.api.OcppVersion;
import io.github.zonnedev.ocpp.v16.Ocpp16Action;
import io.github.zonnedev.ocpp.v16.Ocpp16Request;

/** Immutable schema type generated from schemas/v16/ClearCache.json. */
public record ClearCacheRequest(

) implements Ocpp16Request {
  public ClearCacheRequest {

  }

  private static final ClearCacheRequest INSTANCE = new ClearCacheRequest();

  public static ClearCacheRequest of() {
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
    return Ocpp16Action.CLEAR_CACHE;
  }
}
