package io.github.zonnedev.ocpp.v201.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.github.zonnedev.ocpp.api.OcppVersion;
import io.github.zonnedev.ocpp.v201.Ocpp201Action;
import io.github.zonnedev.ocpp.v201.Ocpp201Request;
import io.github.zonnedev.ocpp.v201.model.type.CustomData;
import org.jspecify.annotations.Nullable;

/**
 * Immutable schema type generated from
 * schemas/v201/GetLocalListVersionRequest.json.
 */
public record GetLocalListVersionRequest(
  @Nullable CustomData customData
) implements Ocpp201Request {
  public GetLocalListVersionRequest {

  }

  public static GetLocalListVersionRequest of() {
    return new GetLocalListVersionRequest(null);
  }
  public static GetLocalListVersionRequest of(@Nullable CustomData customData) {
    return new GetLocalListVersionRequest(customData);
  }

  @JsonIgnore
  @Override
  public OcppVersion version() {
    return OcppVersion.OCPP_2_0_1;
  }

  @JsonIgnore
  @Override
  public Ocpp201Action action() {
    return Ocpp201Action.GET_LOCAL_LIST_VERSION;
  }
}
