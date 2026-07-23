package io.github.zonnedev.ocpp.codec;

import io.github.zonnedev.ocpp.api.OcppVersion;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * Strict decoding failure for a DataTransfer request not provided by a
 * registered module.
 */
public final class UnknownDataTransferOperationException extends OcppDecodingException {
  private static final long serialVersionUID = 1L;

  private final OcppVersion version;
  private final String vendorId;
  private final @Nullable String messageId;
  private final Reason reason;

  public UnknownDataTransferOperationException(
    OcppVersion version,
    String vendorId,
    @Nullable String messageId,
    Reason reason
  ) {
    super(
      message(
        version,
        vendorId,
        messageId,
        reason
      ),
      null
    );
    this.version = Objects.requireNonNull(
      version,
      "version"
    );
    this.vendorId = Objects.requireNonNull(
      vendorId,
      "vendorId"
    );
    this.messageId = messageId;
    this.reason = Objects.requireNonNull(
      reason,
      "reason"
    );
  }

  public OcppVersion version() {
    return version;
  }

  public String vendorId() {
    return vendorId;
  }

  public @Nullable String messageId() {
    return messageId;
  }

  public Reason reason() {
    return reason;
  }

  private static String message(
    OcppVersion version,
    String vendorId,
    @Nullable String messageId,
    Reason reason
  ) {
    Objects.requireNonNull(
      version,
      "version"
    );
    Objects.requireNonNull(
      vendorId,
      "vendorId"
    );
    Objects.requireNonNull(
      reason,
      "reason"
    );
    return switch (reason) {
      case UNKNOWN_VENDOR_ID -> "No DataTransfer module is registered for vendor " + vendorId
        + " and version " + version;
      case UNKNOWN_MESSAGE_ID -> "No DataTransfer operation is registered for " + version + "/"
        + vendorId + "/" + messageId;
      case MISSING_MESSAGE_ID -> "A messageId is required for registered DataTransfer modules: "
        + version + "/" + vendorId;
    };
  }

  public enum Reason {
    UNKNOWN_VENDOR_ID, UNKNOWN_MESSAGE_ID, MISSING_MESSAGE_ID
  }
}
