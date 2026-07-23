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
 * Immutable schema type generated from
 * schemas/v201/CustomerInformationResponse.json.
 */
public record CustomerInformationResponse(
  @Nullable CustomData customData,
  CustomerInformationStatusEnum status,
  @Nullable StatusInfo statusInfo
) implements Ocpp201Response {
  public CustomerInformationResponse {
    Objects.requireNonNull(
      status,
      "status"
    );
  }

  public static CustomerInformationResponse of(CustomerInformationStatusEnum status) {
    return new CustomerInformationResponse(
      null,
      status,
      null
    );
  }
  public static CustomerInformationResponse of(
    @Nullable CustomData customData,
    CustomerInformationStatusEnum status,
    @Nullable StatusInfo statusInfo
  ) {
    return new CustomerInformationResponse(
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
    return Ocpp201Action.CUSTOMER_INFORMATION;
  }

  /**
   * Closed wire enumeration generated from v201 reusable definition
   * CustomerInformationStatusEnumType.
   */
  public enum CustomerInformationStatusEnum {
    ACCEPTED("Accepted"), REJECTED("Rejected"), INVALID("Invalid");

    private final String wireValue;

    CustomerInformationStatusEnum(String wireValue) {
      this.wireValue = wireValue;
    }

    @JsonValue
    public String wireValue() {
      return wireValue;
    }

    @JsonCreator
    public static CustomerInformationStatusEnum fromWireValue(String wireValue) {
      Objects.requireNonNull(
        wireValue,
        "wireValue"
      );
      return switch (wireValue) {
        case "Accepted" -> ACCEPTED;
        case "Rejected" -> REJECTED;
        case "Invalid" -> INVALID;
        default ->
          throw new IllegalArgumentException("Unknown CustomerInformationStatusEnum: " + wireValue);
      };
    }
  }
}
