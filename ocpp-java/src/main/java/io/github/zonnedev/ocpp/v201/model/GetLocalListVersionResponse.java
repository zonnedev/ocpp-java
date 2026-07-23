package io.github.zonnedev.ocpp.v201.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.github.zonnedev.ocpp.api.OcppVersion;
import io.github.zonnedev.ocpp.v201.Ocpp201Action;
import io.github.zonnedev.ocpp.v201.Ocpp201Response;
import io.github.zonnedev.ocpp.v201.model.type.CustomData;
import org.jspecify.annotations.Nullable;

/**
 * Immutable schema type generated from
 * schemas/v201/GetLocalListVersionResponse.json.
 */
public record GetLocalListVersionResponse(
  @Nullable CustomData customData,
  int versionNumber
) implements Ocpp201Response {
  public GetLocalListVersionResponse {

  }

  public static GetLocalListVersionResponse of(int versionNumber) {
    return new GetLocalListVersionResponse(
      null,
      versionNumber
    );
  }
  public static GetLocalListVersionResponse of(
    @Nullable CustomData customData,
    int versionNumber
  ) {
    return new GetLocalListVersionResponse(
      customData,
      versionNumber
    );
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
