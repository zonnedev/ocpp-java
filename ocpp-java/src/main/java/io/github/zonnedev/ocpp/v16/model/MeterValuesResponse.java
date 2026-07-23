package io.github.zonnedev.ocpp.v16.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.github.zonnedev.ocpp.api.OcppVersion;
import io.github.zonnedev.ocpp.v16.Ocpp16Action;
import io.github.zonnedev.ocpp.v16.Ocpp16Response;

/**
 * Immutable schema type generated from schemas/v16/MeterValuesResponse.json.
 */
public record MeterValuesResponse(

) implements Ocpp16Response {
  public MeterValuesResponse {

  }

  private static final MeterValuesResponse INSTANCE = new MeterValuesResponse();

  public static MeterValuesResponse of() {
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
    return Ocpp16Action.METER_VALUES;
  }
}
