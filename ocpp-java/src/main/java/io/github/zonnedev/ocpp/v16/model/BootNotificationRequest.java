package io.github.zonnedev.ocpp.v16.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Objects;
import org.jspecify.annotations.Nullable;
import io.github.zonnedev.ocpp.api.OcppVersion;
import io.github.zonnedev.ocpp.v16.Ocpp16Action;
import io.github.zonnedev.ocpp.v16.Ocpp16Request;

/** Immutable schema type generated from schemas/v16/BootNotification.json. */
public record BootNotificationRequest(
  @Nullable String chargeBoxSerialNumber,
  String chargePointModel,
  @Nullable String chargePointSerialNumber,
  String chargePointVendor,
  @Nullable String firmwareVersion,
  @Nullable String iccid,
  @Nullable String imsi,
  @Nullable String meterSerialNumber,
  @Nullable String meterType
) implements Ocpp16Request {
  public BootNotificationRequest {
    if (chargeBoxSerialNumber != null && (chargeBoxSerialNumber.length() > 25)) {
      throw new IllegalArgumentException(
        "chargeBoxSerialNumber length violates schema constraints"
      );
    }
    Objects.requireNonNull(
      chargePointModel,
      "chargePointModel"
    );
    if (chargePointModel.length() > 20) {
      throw new IllegalArgumentException("chargePointModel length violates schema constraints");
    }
    if (chargePointSerialNumber != null && (chargePointSerialNumber.length() > 25)) {
      throw new IllegalArgumentException(
        "chargePointSerialNumber length violates schema constraints"
      );
    }
    Objects.requireNonNull(
      chargePointVendor,
      "chargePointVendor"
    );
    if (chargePointVendor.length() > 20) {
      throw new IllegalArgumentException("chargePointVendor length violates schema constraints");
    }
    if (firmwareVersion != null && (firmwareVersion.length() > 50)) {
      throw new IllegalArgumentException("firmwareVersion length violates schema constraints");
    }
    if (iccid != null && (iccid.length() > 20)) {
      throw new IllegalArgumentException("iccid length violates schema constraints");
    }
    if (imsi != null && (imsi.length() > 20)) {
      throw new IllegalArgumentException("imsi length violates schema constraints");
    }
    if (meterSerialNumber != null && (meterSerialNumber.length() > 25)) {
      throw new IllegalArgumentException("meterSerialNumber length violates schema constraints");
    }
    if (meterType != null && (meterType.length() > 25)) {
      throw new IllegalArgumentException("meterType length violates schema constraints");
    }
  }

  public static BootNotificationRequest of(
    String chargePointModel,
    String chargePointVendor
  ) {
    return new BootNotificationRequest(
      null,
      chargePointModel,
      null,
      chargePointVendor,
      null,
      null,
      null,
      null,
      null
    );
  }
  public static BootNotificationRequest of(
    @Nullable String chargeBoxSerialNumber,
    String chargePointModel,
    @Nullable String chargePointSerialNumber,
    String chargePointVendor,
    @Nullable String firmwareVersion,
    @Nullable String iccid,
    @Nullable String imsi,
    @Nullable String meterSerialNumber,
    @Nullable String meterType
  ) {
    return new BootNotificationRequest(
      chargeBoxSerialNumber,
      chargePointModel,
      chargePointSerialNumber,
      chargePointVendor,
      firmwareVersion,
      iccid,
      imsi,
      meterSerialNumber,
      meterType
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
    return Ocpp16Action.BOOT_NOTIFICATION;
  }
}
