package io.github.zonnedev.ocpp.v16.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;
import org.jspecify.annotations.Nullable;
import io.github.zonnedev.ocpp.api.OcppVersion;
import io.github.zonnedev.ocpp.v16.Ocpp16Action;
import io.github.zonnedev.ocpp.v16.Ocpp16Request;

/** Immutable schema type generated from schemas/v16/GetConfiguration.json. */
public record GetConfigurationRequest(
  @Nullable List<String> key
) implements Ocpp16Request {
  public GetConfigurationRequest {
    key = key == null ? null : List.copyOf(key);
  }

  public static GetConfigurationRequest of() {
    return new GetConfigurationRequest(null);
  }
  public static GetConfigurationRequest of(@Nullable List<String> key) {
    return new GetConfigurationRequest(key);
  }

  @JsonIgnore
  @Override
  public OcppVersion version() {
    return OcppVersion.OCPP_1_6_JSON;
  }

  @JsonIgnore
  @Override
  public Ocpp16Action action() {
    return Ocpp16Action.GET_CONFIGURATION;
  }
}
