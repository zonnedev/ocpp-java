package io.github.zonnedev.ocpp.v16.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.github.zonnedev.ocpp.api.OcppVersion;
import io.github.zonnedev.ocpp.v16.Ocpp16Action;
import io.github.zonnedev.ocpp.v16.Ocpp16Response;
import java.util.List;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * Immutable schema type generated from
 * schemas/v16/GetConfigurationResponse.json.
 */
public record GetConfigurationResponse(
  @Nullable List<ConfigurationKeyItem> configurationKey,
  @Nullable List<String> unknownKey
) implements Ocpp16Response {
  public GetConfigurationResponse {
    configurationKey = configurationKey == null ? null : List.copyOf(configurationKey);
    unknownKey = unknownKey == null ? null : List.copyOf(unknownKey);
  }

  public static GetConfigurationResponse of() {
    return new GetConfigurationResponse(
      null,
      null
    );
  }
  public static GetConfigurationResponse of(
    @Nullable List<ConfigurationKeyItem> configurationKey,
    @Nullable List<String> unknownKey
  ) {
    return new GetConfigurationResponse(
      configurationKey,
      unknownKey
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
    return Ocpp16Action.GET_CONFIGURATION;
  }

  /**
   * Immutable schema type generated from
   * schemas/v16/GetConfigurationResponse.json inline object.
   */
  public record ConfigurationKeyItem(
    String key,
    boolean readonly,
    @Nullable String value
  ) {
    public ConfigurationKeyItem {
      Objects.requireNonNull(
        key,
        "key"
      );
      if (key.length() > 50) {
        throw new IllegalArgumentException("key length violates schema constraints");
      }
      if (value != null && (value.length() > 500)) {
        throw new IllegalArgumentException("value length violates schema constraints");
      }
    }

    public static ConfigurationKeyItem of(
      String key,
      boolean readonly
    ) {
      return new ConfigurationKeyItem(
        key,
        readonly,
        null
      );
    }
    public static ConfigurationKeyItem of(
      String key,
      boolean readonly,
      @Nullable String value
    ) {
      return new ConfigurationKeyItem(
        key,
        readonly,
        value
      );
    }
  }
}
