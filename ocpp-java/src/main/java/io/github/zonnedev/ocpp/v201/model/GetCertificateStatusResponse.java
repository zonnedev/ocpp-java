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
 * schemas/v201/GetCertificateStatusResponse.json.
 */
public record GetCertificateStatusResponse(
  @Nullable CustomData customData,
  @Nullable String ocspResult,
  GetCertificateStatusEnum status,
  @Nullable StatusInfo statusInfo
) implements Ocpp201Response {
  public GetCertificateStatusResponse {
    if (ocspResult != null && (ocspResult.length() > 5500)) {
      throw new IllegalArgumentException("ocspResult length violates schema constraints");
    }
    Objects.requireNonNull(
      status,
      "status"
    );
  }

  public static GetCertificateStatusResponse of(GetCertificateStatusEnum status) {
    return new GetCertificateStatusResponse(
      null,
      null,
      status,
      null
    );
  }
  public static GetCertificateStatusResponse of(
    @Nullable CustomData customData,
    @Nullable String ocspResult,
    GetCertificateStatusEnum status,
    @Nullable StatusInfo statusInfo
  ) {
    return new GetCertificateStatusResponse(
      customData,
      ocspResult,
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
    return Ocpp201Action.GET_CERTIFICATE_STATUS;
  }

  /**
   * Closed wire enumeration generated from v201 reusable definition
   * GetCertificateStatusEnumType.
   */
  public enum GetCertificateStatusEnum {
    ACCEPTED("Accepted"), FAILED("Failed");

    private final String wireValue;

    GetCertificateStatusEnum(String wireValue) {
      this.wireValue = wireValue;
    }

    @JsonValue
    public String wireValue() {
      return wireValue;
    }

    @JsonCreator
    public static GetCertificateStatusEnum fromWireValue(String wireValue) {
      Objects.requireNonNull(
        wireValue,
        "wireValue"
      );
      return switch (wireValue) {
        case "Accepted" -> ACCEPTED;
        case "Failed" -> FAILED;
        default ->
          throw new IllegalArgumentException("Unknown GetCertificateStatusEnum: " + wireValue);
      };
    }
  }
}
