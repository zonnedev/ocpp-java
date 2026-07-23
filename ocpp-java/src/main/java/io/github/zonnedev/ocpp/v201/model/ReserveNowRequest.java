package io.github.zonnedev.ocpp.v201.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.zonnedev.ocpp.api.OcppVersion;
import io.github.zonnedev.ocpp.v201.Ocpp201Action;
import io.github.zonnedev.ocpp.v201.Ocpp201Request;
import io.github.zonnedev.ocpp.v201.model.type.CustomData;
import io.github.zonnedev.ocpp.v201.model.type.IdToken;
import java.time.Instant;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/** Immutable schema type generated from schemas/v201/ReserveNowRequest.json. */
public record ReserveNowRequest(
  @Nullable ConnectorEnum connectorType,
  @Nullable CustomData customData,
  @Nullable Integer evseId,
  Instant expiryDateTime,
  @Nullable IdToken groupIdToken,
  int id,
  IdToken idToken
) implements Ocpp201Request {
  public ReserveNowRequest {
    Objects.requireNonNull(
      expiryDateTime,
      "expiryDateTime"
    );
    Objects.requireNonNull(
      idToken,
      "idToken"
    );
  }

  public static ReserveNowRequest of(
    Instant expiryDateTime,
    int id,
    IdToken idToken
  ) {
    return new ReserveNowRequest(
      null,
      null,
      null,
      expiryDateTime,
      null,
      id,
      idToken
    );
  }
  public static ReserveNowRequest of(
    @Nullable ConnectorEnum connectorType,
    @Nullable CustomData customData,
    @Nullable Integer evseId,
    Instant expiryDateTime,
    @Nullable IdToken groupIdToken,
    int id,
    IdToken idToken
  ) {
    return new ReserveNowRequest(
      connectorType,
      customData,
      evseId,
      expiryDateTime,
      groupIdToken,
      id,
      idToken
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
    return Ocpp201Action.RESERVE_NOW;
  }

  /**
   * Closed wire enumeration generated from v201 reusable definition
   * ConnectorEnumType.
   */
  public enum ConnectorEnum {
    C_CCS1("cCCS1"), C_CCS2("cCCS2"), C_G105("cG105"), C_TESLA("cTesla"), C_TYPE1(
      "cType1"
    ), C_TYPE2(
      "cType2"
    ), S309_1_P_16_A("s309-1P-16A"), S309_1_P_32_A("s309-1P-32A"), S309_3_P_16_A(
      "s309-3P-16A"
    ), S309_3_P_32_A("s309-3P-32A"), S_BS1361("sBS1361"), S_CEE_7_7("sCEE-7-7"), S_TYPE2(
      "sType2"
    ), S_TYPE3("sType3"), OTHER1_PH_MAX16_A("Other1PhMax16A"), OTHER1_PH_OVER16_A(
      "Other1PhOver16A"
    ), OTHER3_PH("Other3Ph"), PAN("Pan"), W_INDUCTIVE(
      "wInductive"
    ), W_RESONANT("wResonant"), UNDETERMINED("Undetermined"), UNKNOWN("Unknown");

    private final String wireValue;

    ConnectorEnum(String wireValue) {
      this.wireValue = wireValue;
    }

    @JsonValue
    public String wireValue() {
      return wireValue;
    }

    @JsonCreator
    public static ConnectorEnum fromWireValue(String wireValue) {
      Objects.requireNonNull(
        wireValue,
        "wireValue"
      );
      return switch (wireValue) {
        case "cCCS1" -> C_CCS1;
        case "cCCS2" -> C_CCS2;
        case "cG105" -> C_G105;
        case "cTesla" -> C_TESLA;
        case "cType1" -> C_TYPE1;
        case "cType2" -> C_TYPE2;
        case "s309-1P-16A" -> S309_1_P_16_A;
        case "s309-1P-32A" -> S309_1_P_32_A;
        case "s309-3P-16A" -> S309_3_P_16_A;
        case "s309-3P-32A" -> S309_3_P_32_A;
        case "sBS1361" -> S_BS1361;
        case "sCEE-7-7" -> S_CEE_7_7;
        case "sType2" -> S_TYPE2;
        case "sType3" -> S_TYPE3;
        case "Other1PhMax16A" -> OTHER1_PH_MAX16_A;
        case "Other1PhOver16A" -> OTHER1_PH_OVER16_A;
        case "Other3Ph" -> OTHER3_PH;
        case "Pan" -> PAN;
        case "wInductive" -> W_INDUCTIVE;
        case "wResonant" -> W_RESONANT;
        case "Undetermined" -> UNDETERMINED;
        case "Unknown" -> UNKNOWN;
        default -> throw new IllegalArgumentException("Unknown ConnectorEnum: " + wireValue);
      };
    }
  }
}
