package io.github.zonnedev.ocpp.v16.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.github.zonnedev.ocpp.api.datatransfer.DataTransferRequestPayload;
import java.util.Objects;
import org.jspecify.annotations.Nullable;
import io.github.zonnedev.ocpp.api.OcppVersion;
import io.github.zonnedev.ocpp.v16.Ocpp16Action;
import io.github.zonnedev.ocpp.v16.Ocpp16Request;

/** Immutable schema type generated from schemas/v16/DataTransfer.json. */
public record DataTransferRequest<Q extends DataTransferRequestPayload>(
  @Nullable Q data,
  @Nullable String messageId,
  String vendorId
) implements Ocpp16Request {
  public DataTransferRequest {
    if (messageId != null && (messageId.length() > 50)) {
      throw new IllegalArgumentException("messageId length violates schema constraints");
    }
    Objects.requireNonNull(
      vendorId,
      "vendorId"
    );
    if (vendorId.length() > 255) {
      throw new IllegalArgumentException("vendorId length violates schema constraints");
    }
  }

  public static <Q extends DataTransferRequestPayload> DataTransferRequest<Q> of(String vendorId) {
    return new DataTransferRequest<>(
      null,
      null,
      vendorId
    );
  }
  public static <Q extends DataTransferRequestPayload> DataTransferRequest<Q> of(
    @Nullable Q data,
    @Nullable String messageId,
    String vendorId
  ) {
    return new DataTransferRequest<>(
      data,
      messageId,
      vendorId
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
    return Ocpp16Action.DATA_TRANSFER;
  }
}
