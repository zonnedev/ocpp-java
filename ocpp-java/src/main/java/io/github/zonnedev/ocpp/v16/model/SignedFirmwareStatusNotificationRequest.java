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
 * Immutable schema type generated from
 * schemas/v16/SignedFirmwareStatusNotification.json.
 */
public record SignedFirmwareStatusNotificationRequest(
  @Nullable Integer requestId,
  FirmwareStatusEnum status
) implements Ocpp16Request {
  public SignedFirmwareStatusNotificationRequest {
    Objects.requireNonNull(
      status,
      "status"
    );
  }

  public static SignedFirmwareStatusNotificationRequest of(FirmwareStatusEnum status) {
    return new SignedFirmwareStatusNotificationRequest(
      null,
      status
    );
  }
  public static SignedFirmwareStatusNotificationRequest of(
    @Nullable Integer requestId,
    FirmwareStatusEnum status
  ) {
    return new SignedFirmwareStatusNotificationRequest(
      requestId,
      status
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
    return Ocpp16Action.SIGNED_FIRMWARE_STATUS_NOTIFICATION;
  }

  /**
   * Closed wire enumeration generated from v16 reusable definition
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
