package io.github.zonnedev.ocpp.v16.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.zonnedev.ocpp.api.OcppVersion;
import io.github.zonnedev.ocpp.v16.Ocpp16Action;
import io.github.zonnedev.ocpp.v16.Ocpp16Request;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * Immutable schema type generated from schemas/v16/ClearChargingProfile.json.
 */
public record ClearChargingProfileRequest(
  @Nullable ChargingProfilePurpose chargingProfilePurpose,
  @Nullable Integer connectorId,
  @Nullable Integer id,
  @Nullable Integer stackLevel
) implements Ocpp16Request {
  public ClearChargingProfileRequest {

  }

  public static ClearChargingProfileRequest of() {
    return new ClearChargingProfileRequest(
      null,
      null,
      null,
      null
    );
  }
  public static ClearChargingProfileRequest of(
    @Nullable ChargingProfilePurpose chargingProfilePurpose,
    @Nullable Integer connectorId,
    @Nullable Integer id,
    @Nullable Integer stackLevel
  ) {
    return new ClearChargingProfileRequest(
      chargingProfilePurpose,
      connectorId,
      id,
      stackLevel
    );
  }

  @JsonIgnore
  @Override
  public OcppVersion version() {
    return OcppVersion.OCPP_1_6_JSON;
  }

  @JsonIgnore
  @Override
  public Ocpp16Action action() {
    return Ocpp16Action.CLEAR_CHARGING_PROFILE;
  }

  /** Closed wire enumeration generated from v16 inline enumeration. */
  public enum ChargingProfilePurpose {
    CHARGE_POINT_MAX_PROFILE("ChargePointMaxProfile"), TX_DEFAULT_PROFILE(
      "TxDefaultProfile"
    ), TX_PROFILE("TxProfile");

    private final String wireValue;

    ChargingProfilePurpose(String wireValue) {
      this.wireValue = wireValue;
    }

    @JsonValue
    public String wireValue() {
      return wireValue;
    }

    @JsonCreator
    public static ChargingProfilePurpose fromWireValue(String wireValue) {
      Objects.requireNonNull(
        wireValue,
        "wireValue"
      );
      return switch (wireValue) {
        case "ChargePointMaxProfile" -> CHARGE_POINT_MAX_PROFILE;
        case "TxDefaultProfile" -> TX_DEFAULT_PROFILE;
        case "TxProfile" -> TX_PROFILE;
        default -> throw new IllegalArgumentException(
          "Unknown ChargingProfilePurpose: " + wireValue
        );
      };
    }
  }
}
