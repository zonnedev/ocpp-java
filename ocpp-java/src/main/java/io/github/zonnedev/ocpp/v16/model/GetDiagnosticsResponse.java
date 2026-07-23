package io.github.zonnedev.ocpp.v16.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.jspecify.annotations.Nullable;
import io.github.zonnedev.ocpp.api.OcppVersion;
import io.github.zonnedev.ocpp.v16.Ocpp16Action;
import io.github.zonnedev.ocpp.v16.Ocpp16Response;

/**
 * Immutable schema type generated from schemas/v16/GetDiagnosticsResponse.json.
 */
public record GetDiagnosticsResponse(
  @Nullable String fileName
) implements Ocpp16Response {
  public GetDiagnosticsResponse {
    if (fileName != null && (fileName.length() > 255)) {
      throw new IllegalArgumentException("fileName length violates schema constraints");
    }
  }

  public static GetDiagnosticsResponse of() {
    return new GetDiagnosticsResponse(null);
  }
  public static GetDiagnosticsResponse of(@Nullable String fileName) {
    return new GetDiagnosticsResponse(fileName);
  }

  @JsonIgnore
  @Override
  public OcppVersion version() {
    return OcppVersion.OCPP_1_6_JSON;
  }

  @JsonIgnore
  @Override
  public Ocpp16Action action() {
    return Ocpp16Action.GET_DIAGNOSTICS;
  }
}
