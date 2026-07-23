package io.github.zonnedev.ocpp.v201.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.github.zonnedev.ocpp.api.OcppVersion;
import io.github.zonnedev.ocpp.v201.Ocpp201Action;
import io.github.zonnedev.ocpp.v201.Ocpp201Request;
import io.github.zonnedev.ocpp.v201.model.type.CustomData;
import org.jspecify.annotations.Nullable;

/**
 * Immutable schema type generated from
 * schemas/v201/ClearDisplayMessageRequest.json.
 */
public record ClearDisplayMessageRequest(
  @Nullable CustomData customData,
  int id
) implements Ocpp201Request {
  public ClearDisplayMessageRequest {

  }

  public static ClearDisplayMessageRequest of(int id) {
    return new ClearDisplayMessageRequest(
      null,
      id
    );
  }
  public static ClearDisplayMessageRequest of(
    @Nullable CustomData customData,
    int id
  ) {
    return new ClearDisplayMessageRequest(
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
    return Ocpp201Action.CLEAR_DISPLAY_MESSAGE;
  }
}
