package io.github.zonnedev.ocpp.v201.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.zonnedev.ocpp.api.OcppVersion;
import io.github.zonnedev.ocpp.v201.Ocpp201Action;
import io.github.zonnedev.ocpp.v201.Ocpp201Response;
import io.github.zonnedev.ocpp.v201.model.type.CustomData;
import io.github.zonnedev.ocpp.v201.model.type.StatusInfo;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * Immutable schema type generated from schemas/v201/ClearCacheResponse.json.
 */
public record ClearCacheResponse(
  @Nullable CustomData customData,
  ClearCacheStatusEnum status,
  @Nullable StatusInfo statusInfo
) implements Ocpp201Response {
  public ClearCacheResponse {
    Objects.requireNonNull(
      status,
      "status"
    );
  }

  public static ClearCacheResponse of(ClearCacheStatusEnum status) {
    return new ClearCacheResponse(
      null,
      status,
      null
    );
  }
  public static ClearCacheResponse of(
    @Nullable CustomData customData,
    ClearCacheStatusEnum status,
    @Nullable StatusInfo statusInfo
  ) {
    return new ClearCacheResponse(
      customData,
      status,
      statusInfo
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
    return Ocpp201Action.CLEAR_CACHE;
  }

  /**
   * Closed wire enumeration generated from v201 reusable definition
   * ClearCacheStatusEnumType.
   */
  public enum ClearCacheStatusEnum {
    ACCEPTED("Accepted"), REJECTED("Rejected");

    private final String wireValue;

    ClearCacheStatusEnum(String wireValue) {
      this.wireValue = wireValue;
    }

    @JsonValue
    public String wireValue() {
      return wireValue;
    }

    @JsonCreator
    public static ClearCacheStatusEnum fromWireValue(String wireValue) {
      Objects.requireNonNull(
        wireValue,
        "wireValue"
      );
      return switch (wireValue) {
        case "Accepted" -> ACCEPTED;
        case "Rejected" -> REJECTED;
        default -> throw new IllegalArgumentException("Unknown ClearCacheStatusEnum: " + wireValue);
      };
    }
  }
}
