package io.github.zonnedev.ocpp.v16.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Objects;
import io.github.zonnedev.ocpp.api.OcppVersion;
import io.github.zonnedev.ocpp.v16.Ocpp16Action;
import io.github.zonnedev.ocpp.v16.Ocpp16Request;

/**
 * Immutable schema type generated from schemas/v16/ChangeConfiguration.json.
 */
public record ChangeConfigurationRequest(
  String key,
  String value
) implements Ocpp16Request {
  public ChangeConfigurationRequest {
    Objects.requireNonNull(
      key,
      "key"
    );
    if (key.length() > 50) {
      throw new IllegalArgumentException("key length violates schema constraints");
    }
    Objects.requireNonNull(
      value,
      "value"
    );
    if (value.length() > 500) {
      throw new IllegalArgumentException("value length violates schema constraints");
    }
  }

  public static ChangeConfigurationRequest of(
    String key,
    String value
  ) {
    return new ChangeConfigurationRequest(
      key,
      value
    );
  }

  @JsonIgnore
  @Override
  public OcppVersion version() {
    return OcppVersion.OCPP_1_6_JSON;
  }

  @JsonIgnore
  @Override
  public Ocpp16Action action() {
    return Ocpp16Action.CHANGE_CONFIGURATION;
  }
}
