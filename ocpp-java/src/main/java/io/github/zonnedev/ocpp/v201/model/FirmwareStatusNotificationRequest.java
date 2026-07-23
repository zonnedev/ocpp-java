package io.github.zonnedev.ocpp.v201.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.zonnedev.ocpp.api.OcppVersion;
import io.github.zonnedev.ocpp.v201.Ocpp201Action;
import io.github.zonnedev.ocpp.v201.Ocpp201Request;
import io.github.zonnedev.ocpp.v201.model.type.CustomData;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * Immutable schema type generated from
 * schemas/v201/FirmwareStatusNotificationRequest.json.
 */
public record FirmwareStatusNotificationRequest(
  @Nullable CustomData customData,
  @Nullable Integer requestId,
  FirmwareStatusEnum status
) implements Ocpp201Request {
  public FirmwareStatusNotificationRequest {
    Objects.requireNonNull(
      status,
      "status"
    );
  }

  public static FirmwareStatusNotificationRequest of(FirmwareStatusEnum status) {
    return new FirmwareStatusNotificationRequest(
      null,
      null,
      status
    );
  }
  public static FirmwareStatusNotificationRequest of(
    @Nullable CustomData customData,
    @Nullable Integer requestId,
    FirmwareStatusEnum status
  ) {
    return new FirmwareStatusNotificationRequest(
      customData,
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
    return Ocpp201Action.FIRMWARE_STATUS_NOTIFICATION;
  }

  /**
   * Closed wire enumeration generated from v201 reusable definition
   * FirmwareStatusEnumType.
   */
  public enum FirmwareStatusEnum {
    DOWNLOADED("Downloaded"), DOWNLOAD_FAILED("DownloadFailed"), DOWNLOADING(
      "Downloading"
    ), DOWNLOAD_SCHEDULED("DownloadScheduled"), DOWNLOAD_PAUSED(
      "DownloadPaused"
    ), IDLE("Idle"), INSTALLATION_FAILED("InstallationFailed"), INSTALLING("Installing"), INSTALLED(
      "Installed"
    ), INSTALL_REBOOTING("InstallRebooting"), INSTALL_SCHEDULED(
      "InstallScheduled"
    ), INSTALL_VERIFICATION_FAILED(
      "InstallVerificationFailed"
    ), INVALID_SIGNATURE("InvalidSignature"), SIGNATURE_VERIFIED("SignatureVerified");

    private final String wireValue;

    FirmwareStatusEnum(String wireValue) {
      this.wireValue = wireValue;
    }

    @JsonValue
    public String wireValue() {
      return wireValue;
    }

    @JsonCreator
    public static FirmwareStatusEnum fromWireValue(String wireValue) {
      Objects.requireNonNull(
        wireValue,
        "wireValue"
      );
      return switch (wireValue) {
        case "Downloaded" -> DOWNLOADED;
        case "DownloadFailed" -> DOWNLOAD_FAILED;
        case "Downloading" -> DOWNLOADING;
        case "DownloadScheduled" -> DOWNLOAD_SCHEDULED;
        case "DownloadPaused" -> DOWNLOAD_PAUSED;
        case "Idle" -> IDLE;
        case "InstallationFailed" -> INSTALLATION_FAILED;
        case "Installing" -> INSTALLING;
        case "Installed" -> INSTALLED;
        case "InstallRebooting" -> INSTALL_REBOOTING;
        case "InstallScheduled" -> INSTALL_SCHEDULED;
        case "InstallVerificationFailed" -> INSTALL_VERIFICATION_FAILED;
        case "InvalidSignature" -> INVALID_SIGNATURE;
        case "SignatureVerified" -> SIGNATURE_VERIFIED;
        default -> throw new IllegalArgumentException("Unknown FirmwareStatusEnum: " + wireValue);
      };
    }
  }
}
