package io.github.zonnedev.ocpp.v201.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.zonnedev.ocpp.api.OcppVersion;
import io.github.zonnedev.ocpp.v201.Ocpp201Action;
import io.github.zonnedev.ocpp.v201.Ocpp201Response;
import io.github.zonnedev.ocpp.v201.model.type.CustomData;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * Immutable schema type generated from
 * schemas/v201/UnpublishFirmwareResponse.json.
 */
public record UnpublishFirmwareResponse(
  @Nullable CustomData customData,
  UnpublishFirmwareStatusEnum status
) implements Ocpp201Response {
  public UnpublishFirmwareResponse {
    Objects.requireNonNull(
      status,
      "status"
    );
  }

  public static UnpublishFirmwareResponse of(UnpublishFirmwareStatusEnum status) {
    return new UnpublishFirmwareResponse(
      null,
      status
    );
  }
  public static UnpublishFirmwareResponse of(
    @Nullable CustomData customData,
    UnpublishFirmwareStatusEnum status
  ) {
    return new UnpublishFirmwareResponse(
      customData,
      status
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

  /**
   * Closed wire enumeration generated from v201 reusable definition
   * UnpublishFirmwareStatusEnumType.
   */
  public enum UnpublishFirmwareStatusEnum {
    DOWNLOAD_ONGOING("DownloadOngoing"), NO_FIRMWARE("NoFirmware"), UNPUBLISHED("Unpublished");

    private final String wireValue;

    UnpublishFirmwareStatusEnum(String wireValue) {
      this.wireValue = wireValue;
    }

    @JsonValue
    public String wireValue() {
      return wireValue;
    }

    @JsonCreator
    public static UnpublishFirmwareStatusEnum fromWireValue(String wireValue) {
      Objects.requireNonNull(
        wireValue,
        "wireValue"
      );
      return switch (wireValue) {
        case "DownloadOngoing" -> DOWNLOAD_ONGOING;
        case "NoFirmware" -> NO_FIRMWARE;
        case "Unpublished" -> UNPUBLISHED;
        default ->
          throw new IllegalArgumentException("Unknown UnpublishFirmwareStatusEnum: " + wireValue);
      };
    }
  }
}
