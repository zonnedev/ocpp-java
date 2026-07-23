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
 * schemas/v201/Get15118EVCertificateResponse.json.
 */
public record Get15118EVCertificateResponse(
  @Nullable CustomData customData,
  String exiResponse,
  Iso15118EVCertificateStatusEnum status,
  @Nullable StatusInfo statusInfo
) implements Ocpp201Response {
  public Get15118EVCertificateResponse {
    Objects.requireNonNull(
      exiResponse,
      "exiResponse"
    );
    if (exiResponse.length() > 7500) {
      throw new IllegalArgumentException("exiResponse length violates schema constraints");
    }
    Objects.requireNonNull(
      status,
      "status"
    );
  }

  public static Get15118EVCertificateResponse of(
    String exiResponse,
    Iso15118EVCertificateStatusEnum status
  ) {
    return new Get15118EVCertificateResponse(
      null,
      exiResponse,
      status,
      null
    );
  }
  public static Get15118EVCertificateResponse of(
    @Nullable CustomData customData,
    String exiResponse,
    Iso15118EVCertificateStatusEnum status,
    @Nullable StatusInfo statusInfo
  ) {
    return new Get15118EVCertificateResponse(
      customData,
      exiResponse,
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
    return Ocpp201Action.GET15118_EVCERTIFICATE;
  }

  /**
   * Closed wire enumeration generated from v201 reusable definition
   * Iso15118EVCertificateStatusEnumType.
   */
  public enum Iso15118EVCertificateStatusEnum {
    ACCEPTED("Accepted"), FAILED("Failed");

    private final String wireValue;

    Iso15118EVCertificateStatusEnum(String wireValue) {
      this.wireValue = wireValue;
    }

    @JsonValue
    public String wireValue() {
      return wireValue;
    }

    @JsonCreator
    public static Iso15118EVCertificateStatusEnum fromWireValue(String wireValue) {
      Objects.requireNonNull(
        wireValue,
        "wireValue"
      );
      return switch (wireValue) {
        case "Accepted" -> ACCEPTED;
        case "Failed" -> FAILED;
        default ->
          throw new IllegalArgumentException(
            "Unknown Iso15118EVCertificateStatusEnum: " + wireValue
          );
      };
    }
  }
}
