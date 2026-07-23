package io.github.zonnedev.ocpp.v201.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.github.zonnedev.ocpp.api.OcppVersion;
import io.github.zonnedev.ocpp.v201.Ocpp201Action;
import io.github.zonnedev.ocpp.v201.Ocpp201Request;
import io.github.zonnedev.ocpp.v201.model.type.CustomData;
import java.util.List;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * Immutable schema type generated from
 * schemas/v201/ClearVariableMonitoringRequest.json.
 */
public record ClearVariableMonitoringRequest(
  @Nullable CustomData customData,
  List<Integer> id
) implements Ocpp201Request {
  public ClearVariableMonitoringRequest {
    Objects.requireNonNull(
      id,
      "id"
    );
    id = List.copyOf(id);
    if (id.size() < 1) {
      throw new IllegalArgumentException("id size violates schema constraints");
    }
  }

  public static ClearVariableMonitoringRequest of(List<Integer> id) {
    return new ClearVariableMonitoringRequest(
      null,
      id
    );
  }
  public static ClearVariableMonitoringRequest of(
    @Nullable CustomData customData,
    List<Integer> id
  ) {
    return new ClearVariableMonitoringRequest(
      customData,
      id
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
    return Ocpp201Action.CLEAR_VARIABLE_MONITORING;
  }
}
