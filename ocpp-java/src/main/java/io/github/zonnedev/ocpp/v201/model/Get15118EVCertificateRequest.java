package io.github.zonnedev.ocpp.v201.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.zonnedev.ocpp.api.OcppVersion;
import io.github.zonnedev.ocpp.v201.Ocpp201Action;
import io.github.zonnedev.ocpp.v201.Ocpp201Request;
import io.github.zonnedev.ocpp.v201.model.type.CustomData;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * Immutable schema type generated from
 * schemas/v201/Get15118EVCertificateRequest.json.
 */
public record Get15118EVCertificateRequest(
  @JsonProperty("action") CertificateActionEnum actionValue,
  @Nullable CustomData customData,
  String exiRequest,
  String iso15118SchemaVersion
) implements Ocpp201Request {
  public Get15118EVCertificateRequest {
    Objects.requireNonNull(
      actionValue,
      "actionValue"
    );
    Objects.requireNonNull(
      exiRequest,
      "exiRequest"
    );
    if (exiRequest.length() > 5600) {
      throw new IllegalArgumentException("exiRequest length violates schema constraints");
    }
    Objects.requireNonNull(
      iso15118SchemaVersion,
      "iso15118SchemaVersion"
    );
    if (iso15118SchemaVersion.length() > 50) {
      throw new IllegalArgumentException(
        "iso15118SchemaVersion length violates schema constraints"
      );
    }
  }

  public static Get15118EVCertificateRequest of(
    CertificateActionEnum actionValue,
    String exiRequest,
    String iso15118SchemaVersion
  ) {
    return new Get15118EVCertificateRequest(
      actionValue,
      null,
      exiRequest,
      iso15118SchemaVersion
    );
  }
  public static Get15118EVCertificateRequest of(
    CertificateActionEnum actionValue,
    @Nullable CustomData customData,
    String exiRequest,
    String iso15118SchemaVersion
  ) {
    return new Get15118EVCertificateRequest(
      actionValue,
      customData,
      exiRequest,
      iso15118SchemaVersion
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
   * CertificateActionEnumType.
   */
  public enum CertificateActionEnum {
    INSTALL("Install"), UPDATE("Update");

    private final String wireValue;

    CertificateActionEnum(String wireValue) {
      this.wireValue = wireValue;
    }

    @JsonValue
    public String wireValue() {
      return wireValue;
    }

    @JsonCreator
    public static CertificateActionEnum fromWireValue(String wireValue) {
      Objects.requireNonNull(
        wireValue,
        "wireValue"
      );
      return switch (wireValue) {
        case "Install" -> INSTALL;
        case "Update" -> UPDATE;
        default ->
          throw new IllegalArgumentException("Unknown CertificateActionEnum: " + wireValue);
      };
    }
  }
}
