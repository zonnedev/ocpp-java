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
 * schemas/v201/DeleteCertificateResponse.json.
 */
public record DeleteCertificateResponse(
  @Nullable CustomData customData,
  DeleteCertificateStatusEnum status,
  @Nullable StatusInfo statusInfo
) implements Ocpp201Response {
  public DeleteCertificateResponse {
    Objects.requireNonNull(
      status,
      "status"
    );
  }

  public static DeleteCertificateResponse of(DeleteCertificateStatusEnum status) {
    return new DeleteCertificateResponse(
      null,
      status,
      null
    );
  }
  public static DeleteCertificateResponse of(
    @Nullable CustomData customData,
    DeleteCertificateStatusEnum status,
    @Nullable StatusInfo statusInfo
  ) {
    return new DeleteCertificateResponse(
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
    return Ocpp201Action.DELETE_CERTIFICATE;
  }

  /**
   * Closed wire enumeration generated from v201 reusable definition
   * DeleteCertificateStatusEnumType.
   */
  public enum DeleteCertificateStatusEnum {
    ACCEPTED("Accepted"), FAILED("Failed"), NOT_FOUND("NotFound");

    private final String wireValue;

    DeleteCertificateStatusEnum(String wireValue) {
      this.wireValue = wireValue;
    }

    @JsonValue
    public String wireValue() {
      return wireValue;
    }

    @JsonCreator
    public static DeleteCertificateStatusEnum fromWireValue(String wireValue) {
      Objects.requireNonNull(
        wireValue,
        "wireValue"
      );
      return switch (wireValue) {
        case "Accepted" -> ACCEPTED;
        case "Failed" -> FAILED;
        case "NotFound" -> NOT_FOUND;
        default ->
          throw new IllegalArgumentException("Unknown DeleteCertificateStatusEnum: " + wireValue);
      };
    }
  }
}
