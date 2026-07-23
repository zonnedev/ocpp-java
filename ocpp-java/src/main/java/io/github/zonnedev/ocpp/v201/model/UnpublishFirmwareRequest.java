package io.github.zonnedev.ocpp.v201.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.github.zonnedev.ocpp.api.OcppVersion;
import io.github.zonnedev.ocpp.v201.Ocpp201Action;
import io.github.zonnedev.ocpp.v201.Ocpp201Request;
import io.github.zonnedev.ocpp.v201.model.type.CustomData;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * Immutable schema type generated from
 * schemas/v201/UnpublishFirmwareRequest.json.
 */
public record UnpublishFirmwareRequest(
  String checksum,
  @Nullable CustomData customData
) implements Ocpp201Request {
  public UnpublishFirmwareRequest {
    Objects.requireNonNull(
      checksum,
      "checksum"
    );
    if (checksum.length() > 32) {
      throw new IllegalArgumentException("checksum length violates schema constraints");
    }
  }

  public static UnpublishFirmwareRequest of(String checksum) {
    return new UnpublishFirmwareRequest(
      checksum,
      null
    );
  }
  public static UnpublishFirmwareRequest of(
    String checksum,
    @Nullable CustomData customData
  ) {
    return new UnpublishFirmwareRequest(
      checksum,
      customData
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
    return Ocpp201Action.UNPUBLISH_FIRMWARE;
  }
}
