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
 * schemas/v201/CertificateSignedResponse.json.
 */
public record CertificateSignedResponse(
  @Nullable CustomData customData,
  CertificateSignedStatusEnum status,
  @Nullable StatusInfo statusInfo
) implements Ocpp201Response {
  public CertificateSignedResponse {
    Objects.requireNonNull(
      status,
      "status"
    );
  }

  public static CertificateSignedResponse of(CertificateSignedStatusEnum status) {
    return new CertificateSignedResponse(
      null,
      status,
      null
    );
  }
  public static CertificateSignedResponse of(
    @Nullable CustomData customData,
    CertificateSignedStatusEnum status,
    @Nullable StatusInfo statusInfo
  ) {
    return new CertificateSignedResponse(
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
    return Ocpp201Action.CERTIFICATE_SIGNED;
  }

  /**
   * Closed wire enumeration generated from v201 reusable definition
   * CertificateSignedStatusEnumType.
   */
  public enum CertificateSignedStatusEnum {
    ACCEPTED("Accepted"), REJECTED("Rejected");

    private final String wireValue;

    CertificateSignedStatusEnum(String wireValue) {
      this.wireValue = wireValue;
    }

    @JsonValue
    public String wireValue() {
      return wireValue;
    }

    @JsonCreator
    public static CertificateSignedStatusEnum fromWireValue(String wireValue) {
      Objects.requireNonNull(
        wireValue,
        "wireValue"
      );
      return switch (wireValue) {
        case "Accepted" -> ACCEPTED;
        case "Rejected" -> REJECTED;
        default ->
          throw new IllegalArgumentException("Unknown CertificateSignedStatusEnum: " + wireValue);
      };
    }
  }
}
