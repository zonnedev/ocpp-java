package io.github.zonnedev.ocpp.v16.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.zonnedev.ocpp.api.OcppVersion;
import io.github.zonnedev.ocpp.v16.Ocpp16Action;
import io.github.zonnedev.ocpp.v16.Ocpp16Request;
import java.util.Objects;

/**
 * Immutable schema type generated from
 * schemas/v16/FirmwareStatusNotification.json.
 */
public record FirmwareStatusNotificationRequest(
  Status status
) implements Ocpp16Request {
  public FirmwareStatusNotificationRequest {
    Objects.requireNonNull(
      status,
      "status"
    );
  }

  public static FirmwareStatusNotificationRequest of(
    Status status
  ) {
    return new FirmwareStatusNotificationRequest(status);
  }

  @JsonIgnore
  @Override
  public OcppVersion version() {
    return OcppVersion.OCPP_1_6_JSON;
  }

  @JsonIgnore
  @Override
  public Ocpp16Action action() {
    return Ocpp16Action.FIRMWARE_STATUS_NOTIFICATION;
  }

  /** Closed wire enumeration generated from v16 inline enumeration. */
  public enum Status {
    DOWNLOADED("Downloaded"), DOWNLOAD_FAILED("DownloadFailed"), DOWNLOADING("Downloading"), IDLE(
      "Idle"
    ), INSTALLATION_FAILED("InstallationFailed"), INSTALLING("Installing"), INSTALLED("Installed");

    private final String wireValue;

    Status(String wireValue) {
      this.wireValue = wireValue;
    }

    @JsonValue
    public String wireValue() {
      return wireValue;
    }

    @JsonCreator
    public static Status fromWireValue(String wireValue) {
      Objects.requireNonNull(
        wireValue,
        "wireValue"
      );
      return switch (wireValue) {
        case "Downloaded" -> DOWNLOADED;
        case "DownloadFailed" -> DOWNLOAD_FAILED;
        case "Downloading" -> DOWNLOADING;
        case "Idle" -> IDLE;
        case "InstallationFailed" -> INSTALLATION_FAILED;
        case "Installing" -> INSTALLING;
        case "Installed" -> INSTALLED;
        default -> throw new IllegalArgumentException(
          "Unknown Status: " + wireValue
        );
      };
    }
  }
}
