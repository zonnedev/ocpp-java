package io.github.zonnedev.ocpp.v201.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.zonnedev.ocpp.api.OcppVersion;
import io.github.zonnedev.ocpp.v201.Ocpp201Action;
import io.github.zonnedev.ocpp.v201.Ocpp201Request;
import io.github.zonnedev.ocpp.v201.model.type.CustomData;
import java.util.List;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * Immutable schema type generated from
 * schemas/v201/PublishFirmwareStatusNotificationRequest.json.
 */
public record PublishFirmwareStatusNotificationRequest(
  @Nullable CustomData customData,
  @Nullable List<String> location,
  @Nullable Integer requestId,
  PublishFirmwareStatusEnum status
) implements Ocpp201Request {
  public PublishFirmwareStatusNotificationRequest {
    location = location == null ? null : List.copyOf(location);
    if (location != null && (location.size() < 1)) {
      throw new IllegalArgumentException("location size violates schema constraints");
    }
    Objects.requireNonNull(
      status,
      "status"
    );
  }

  public static PublishFirmwareStatusNotificationRequest of(PublishFirmwareStatusEnum status) {
    return new PublishFirmwareStatusNotificationRequest(
      null,
      null,
      null,
      status
    );
  }
  public static PublishFirmwareStatusNotificationRequest of(
    @Nullable CustomData customData,
    @Nullable List<String> location,
    @Nullable Integer requestId,
    PublishFirmwareStatusEnum status
  ) {
    return new PublishFirmwareStatusNotificationRequest(
      customData,
      location,
      requestId,
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
    return Ocpp201Action.PUBLISH_FIRMWARE_STATUS_NOTIFICATION;
  }

  /**
   * Closed wire enumeration generated from v201 reusable definition
   * PublishFirmwareStatusEnumType.
   */
  public enum PublishFirmwareStatusEnum {
    IDLE("Idle"), DOWNLOAD_SCHEDULED("DownloadScheduled"), DOWNLOADING("Downloading"), DOWNLOADED(
      "Downloaded"
    ), PUBLISHED("Published"), DOWNLOAD_FAILED("DownloadFailed"), DOWNLOAD_PAUSED(
      "DownloadPaused"
    ), INVALID_CHECKSUM(
      "InvalidChecksum"
    ), CHECKSUM_VERIFIED("ChecksumVerified"), PUBLISH_FAILED("PublishFailed");

    private final String wireValue;

    PublishFirmwareStatusEnum(String wireValue) {
      this.wireValue = wireValue;
    }

    @JsonValue
    public String wireValue() {
      return wireValue;
    }

    @JsonCreator
    public static PublishFirmwareStatusEnum fromWireValue(String wireValue) {
      Objects.requireNonNull(
        wireValue,
        "wireValue"
      );
      return switch (wireValue) {
        case "Idle" -> IDLE;
        case "DownloadScheduled" -> DOWNLOAD_SCHEDULED;
        case "Downloading" -> DOWNLOADING;
        case "Downloaded" -> DOWNLOADED;
        case "Published" -> PUBLISHED;
        case "DownloadFailed" -> DOWNLOAD_FAILED;
        case "DownloadPaused" -> DOWNLOAD_PAUSED;
        case "InvalidChecksum" -> INVALID_CHECKSUM;
        case "ChecksumVerified" -> CHECKSUM_VERIFIED;
        case "PublishFailed" -> PUBLISH_FAILED;
        default ->
          throw new IllegalArgumentException("Unknown PublishFirmwareStatusEnum: " + wireValue);
      };
    }
  }
}
