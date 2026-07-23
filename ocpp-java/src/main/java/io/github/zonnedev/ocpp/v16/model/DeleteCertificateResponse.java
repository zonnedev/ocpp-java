package io.github.zonnedev.ocpp.v16.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.zonnedev.ocpp.api.OcppVersion;
import io.github.zonnedev.ocpp.v16.Ocpp16Action;
import io.github.zonnedev.ocpp.v16.Ocpp16Response;
import java.util.Objects;

/**
 * Immutable schema type generated from
 * schemas/v16/DeleteCertificateResponse.json.
 */
public record DeleteCertificateResponse(
  DeleteCertificateStatusEnum status
) implements Ocpp16Response {
  public DeleteCertificateResponse {
    Objects.requireNonNull(
      status,
      "status"
    );
  }

  public static DeleteCertificateResponse of(DeleteCertificateStatusEnum status) {
    return new DeleteCertificateResponse(status);
  }

  @JsonIgnore
  @Override
  public OcppVersion version() {
    return OcppVersion.OCPP_1_6_JSON;
  }

  @JsonIgnore
  @Override
  public Ocpp16Action action() {
    return Ocpp16Action.DELETE_CERTIFICATE;
  }

  /**
   * Closed wire enumeration generated from v16 reusable definition
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
