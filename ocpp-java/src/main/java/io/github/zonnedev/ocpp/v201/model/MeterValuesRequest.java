package io.github.zonnedev.ocpp.v201.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.github.zonnedev.ocpp.api.OcppVersion;
import io.github.zonnedev.ocpp.v201.Ocpp201Action;
import io.github.zonnedev.ocpp.v201.Ocpp201Request;
import io.github.zonnedev.ocpp.v201.model.type.CustomData;
import io.github.zonnedev.ocpp.v201.model.type.MeterValue;
import java.util.List;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * Immutable schema type generated from schemas/v201/MeterValuesRequest.json.
 */
public record MeterValuesRequest(
  @Nullable CustomData customData,
  int evseId,
  List<MeterValue> meterValue
) implements Ocpp201Request {
  public MeterValuesRequest {
    Objects.requireNonNull(
      meterValue,
      "meterValue"
    );
    meterValue = List.copyOf(meterValue);
    if (meterValue.size() < 1) {
      throw new IllegalArgumentException("meterValue size violates schema constraints");
    }
  }

  public static MeterValuesRequest of(
    int evseId,
    List<MeterValue> meterValue
  ) {
    return new MeterValuesRequest(
      null,
      evseId,
      meterValue
    );
  }
  public static MeterValuesRequest of(
    @Nullable CustomData customData,
    int evseId,
    List<MeterValue> meterValue
  ) {
    return new MeterValuesRequest(
      customData,
      evseId,
      meterValue
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
    return Ocpp201Action.METER_VALUES;
  }
}
