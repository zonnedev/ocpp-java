package io.github.zonnedev.ocpp.v201.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.github.zonnedev.ocpp.api.OcppVersion;
import io.github.zonnedev.ocpp.v201.Ocpp201Action;
import io.github.zonnedev.ocpp.v201.Ocpp201Response;
import io.github.zonnedev.ocpp.v201.model.type.CustomData;
import io.github.zonnedev.ocpp.v201.model.type.GenericStatusEnum;
import io.github.zonnedev.ocpp.v201.model.type.StatusInfo;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * Immutable schema type generated from
 * schemas/v201/PublishFirmwareResponse.json.
 */
public record PublishFirmwareResponse(
  @Nullable CustomData customData,
  GenericStatusEnum status,
  @Nullable StatusInfo statusInfo
) implements Ocpp201Response {
  public PublishFirmwareResponse {
    Objects.requireNonNull(
      status,
      "status"
    );
  }

  public static PublishFirmwareResponse of(GenericStatusEnum status) {
    return new PublishFirmwareResponse(
      null,
      status,
      null
    );
  }
  public static PublishFirmwareResponse of(
    @Nullable CustomData customData,
    GenericStatusEnum status,
    @Nullable StatusInfo statusInfo
  ) {
    return new PublishFirmwareResponse(
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
    return Ocpp201Action.PUBLISH_FIRMWARE;
  }
}
