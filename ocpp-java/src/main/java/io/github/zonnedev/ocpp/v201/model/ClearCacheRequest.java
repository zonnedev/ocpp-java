package io.github.zonnedev.ocpp.v201.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.github.zonnedev.ocpp.api.OcppVersion;
import io.github.zonnedev.ocpp.v201.Ocpp201Action;
import io.github.zonnedev.ocpp.v201.Ocpp201Request;
import io.github.zonnedev.ocpp.v201.model.type.CustomData;
import org.jspecify.annotations.Nullable;

/** Immutable schema type generated from schemas/v201/ClearCacheRequest.json. */
public record ClearCacheRequest(
  @Nullable CustomData customData
) implements Ocpp201Request {
  public ClearCacheRequest {

  }

  public static ClearCacheRequest of() {
    return new ClearCacheRequest(null);
  }
  public static ClearCacheRequest of(@Nullable CustomData customData) {
    return new ClearCacheRequest(customData);
  }

  @JsonIgnore
  @Override
  public OcppVersion version() {
    return OcppVersion.OCPP_2_0_1;
  }

  @JsonIgnore
  @Override
  public Ocpp201Action action() {
    return Ocpp201Action.CLEAR_CACHE;
  }
}
