package io.github.zonnedev.ocpp.v201.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.zonnedev.ocpp.api.OcppVersion;
import io.github.zonnedev.ocpp.v201.Ocpp201Action;
import io.github.zonnedev.ocpp.v201.Ocpp201Response;
import io.github.zonnedev.ocpp.v201.model.type.CustomData;
import io.github.zonnedev.ocpp.v201.model.type.IdTokenInfo;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/** Immutable schema type generated from schemas/v201/AuthorizeResponse.json. */
public record AuthorizeResponse(
  @Nullable AuthorizeCertificateStatusEnum certificateStatus,
  @Nullable CustomData customData,
  IdTokenInfo idTokenInfo
) implements Ocpp201Response {
  public AuthorizeResponse {
    Objects.requireNonNull(
      idTokenInfo,
      "idTokenInfo"
    );
  }

  public static AuthorizeResponse of(IdTokenInfo idTokenInfo) {
    return new AuthorizeResponse(
      null,
      null,
      idTokenInfo
    );
  }
  public static AuthorizeResponse of(
    @Nullable AuthorizeCertificateStatusEnum certificateStatus,
    @Nullable CustomData customData,
    IdTokenInfo idTokenInfo
  ) {
    return new AuthorizeResponse(
      certificateStatus,
      customData,
      idTokenInfo
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
    return Ocpp201Action.AUTHORIZE;
  }

  /**
   * Closed wire enumeration generated from v201 reusable definition
   * AuthorizeCertificateStatusEnumType.
   */
  public enum AuthorizeCertificateStatusEnum {
    ACCEPTED("Accepted"), SIGNATURE_ERROR("SignatureError"), CERTIFICATE_EXPIRED(
      "CertificateExpired"
    ), CERTIFICATE_REVOKED("CertificateRevoked"), NO_CERTIFICATE_AVAILABLE(
      "NoCertificateAvailable"
    ), CERT_CHAIN_ERROR("CertChainError"), CONTRACT_CANCELLED("ContractCancelled");

    private final String wireValue;

    AuthorizeCertificateStatusEnum(String wireValue) {
      this.wireValue = wireValue;
    }

    @JsonValue
    public String wireValue() {
      return wireValue;
    }

    @JsonCreator
    public static AuthorizeCertificateStatusEnum fromWireValue(String wireValue) {
      Objects.requireNonNull(
        wireValue,
        "wireValue"
      );
      return switch (wireValue) {
        case "Accepted" -> ACCEPTED;
        case "SignatureError" -> SIGNATURE_ERROR;
        case "CertificateExpired" -> CERTIFICATE_EXPIRED;
        case "CertificateRevoked" -> CERTIFICATE_REVOKED;
        case "NoCertificateAvailable" -> NO_CERTIFICATE_AVAILABLE;
        case "CertChainError" -> CERT_CHAIN_ERROR;
        case "ContractCancelled" -> CONTRACT_CANCELLED;
        default ->
          throw new IllegalArgumentException(
            "Unknown AuthorizeCertificateStatusEnum: " + wireValue
          );
      };
    }
  }
}
