package io.github.zonnedev.ocpp.v201.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.zonnedev.ocpp.api.OcppVersion;
import io.github.zonnedev.ocpp.v201.Ocpp201Action;
import io.github.zonnedev.ocpp.v201.Ocpp201Request;
import io.github.zonnedev.ocpp.v201.model.type.CustomData;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/** Immutable schema type generated from schemas/v201/ResetRequest.json. */
public record ResetRequest(
  @Nullable CustomData customData,
  @Nullable Integer evseId,
  ResetEnum type
) implements Ocpp201Request {
  public ResetRequest {
    Objects.requireNonNull(
      type,
      "type"
    );
  }

  public static ResetRequest of(ResetEnum type) {
    return new ResetRequest(
      null,
      null,
      type
    );
  }
  public static ResetRequest of(
    @Nullable CustomData customData,
    @Nullable Integer evseId,
    ResetEnum type
  ) {
    return new ResetRequest(
      customData,
      evseId,
      type
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
    return Ocpp201Action.RESET;
  }

  /**
   * Closed wire enumeration generated from v201 reusable definition
   * ResetEnumType.
   */
  public enum ResetEnum {
    IMMEDIATE("Immediate"), ON_IDLE("OnIdle");

    private final String wireValue;

    ResetEnum(String wireValue) {
      this.wireValue = wireValue;
    }

    @JsonValue
    public String wireValue() {
      return wireValue;
    }

    @JsonCreator
    public static ResetEnum fromWireValue(String wireValue) {
      Objects.requireNonNull(
        wireValue,
        "wireValue"
      );
      return switch (wireValue) {
        case "Immediate" -> IMMEDIATE;
        case "OnIdle" -> ON_IDLE;
        default -> throw new IllegalArgumentException("Unknown ResetEnum: " + wireValue);
      };
    }
  }
}
