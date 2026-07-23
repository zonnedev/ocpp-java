package io.github.zonnedev.ocpp.v201.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.github.zonnedev.ocpp.api.OcppVersion;
import io.github.zonnedev.ocpp.api.datatransfer.DataTransferRequestPayload;
import io.github.zonnedev.ocpp.v201.Ocpp201Action;
import io.github.zonnedev.ocpp.v201.Ocpp201Request;
import io.github.zonnedev.ocpp.v201.model.type.CustomData;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * Immutable schema type generated from schemas/v201/DataTransferRequest.json.
 */
public record DataTransferRequest<Q extends DataTransferRequestPayload>(
  @Nullable CustomData customData,
  @Nullable Q data,
  @Nullable String messageId,
  String vendorId
) implements Ocpp201Request {
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
      null,
      vendorId
    );
  }
  public static <Q extends DataTransferRequestPayload> DataTransferRequest<Q> of(
    @Nullable CustomData customData,
    @Nullable Q data,
    @Nullable String messageId,
    String vendorId
  ) {
    return new DataTransferRequest<>(
      customData,
      data,
      messageId,
      vendorId
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
    return Ocpp201Action.DATA_TRANSFER;
  }
}
