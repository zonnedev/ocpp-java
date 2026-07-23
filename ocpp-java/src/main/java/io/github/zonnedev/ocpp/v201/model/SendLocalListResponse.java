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
 * Immutable schema type generated from schemas/v201/SendLocalListResponse.json.
 */
public record SendLocalListResponse(
  @Nullable CustomData customData,
  SendLocalListStatusEnum status,
  @Nullable StatusInfo statusInfo
) implements Ocpp201Response {
  public SendLocalListResponse {
    Objects.requireNonNull(
      status,
      "status"
    );
  }

  public static SendLocalListResponse of(SendLocalListStatusEnum status) {
    return new SendLocalListResponse(
      null,
      status,
      null
    );
  }
  public static SendLocalListResponse of(
    @Nullable CustomData customData,
    SendLocalListStatusEnum status,
    @Nullable StatusInfo statusInfo
  ) {
    return new SendLocalListResponse(
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
    return Ocpp201Action.SEND_LOCAL_LIST;
  }

  /**
   * Closed wire enumeration generated from v201 reusable definition
   * SendLocalListStatusEnumType.
   */
  public enum SendLocalListStatusEnum {
    ACCEPTED("Accepted"), FAILED("Failed"), VERSION_MISMATCH("VersionMismatch");

    private final String wireValue;

    SendLocalListStatusEnum(String wireValue) {
      this.wireValue = wireValue;
    }

    @JsonValue
    public String wireValue() {
      return wireValue;
    }

    @JsonCreator
    public static SendLocalListStatusEnum fromWireValue(String wireValue) {
      Objects.requireNonNull(
        wireValue,
        "wireValue"
      );
      return switch (wireValue) {
        case "Accepted" -> ACCEPTED;
        case "Failed" -> FAILED;
        case "VersionMismatch" -> VERSION_MISMATCH;
        default ->
          throw new IllegalArgumentException("Unknown SendLocalListStatusEnum: " + wireValue);
      };
    }
  }
}
