package io.github.zonnedev.ocpp.v201.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.github.zonnedev.ocpp.api.OcppVersion;
import io.github.zonnedev.ocpp.v201.Ocpp201Action;
import io.github.zonnedev.ocpp.v201.Ocpp201Request;
import io.github.zonnedev.ocpp.v201.model.type.CustomData;
import java.time.Instant;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * Immutable schema type generated from
 * schemas/v201/NotifyCustomerInformationRequest.json.
 */
public record NotifyCustomerInformationRequest(
  @Nullable CustomData customData,
  String data,
  Instant generatedAt,
  int requestId,
  int seqNo,
  @Nullable Boolean tbc
) implements Ocpp201Request {
  public NotifyCustomerInformationRequest {
    Objects.requireNonNull(
      data,
      "data"
    );
    if (data.length() > 512) {
      throw new IllegalArgumentException("data length violates schema constraints");
    }
    Objects.requireNonNull(
      generatedAt,
      "generatedAt"
    );
  }

  public static NotifyCustomerInformationRequest of(
    String data,
    Instant generatedAt,
    int requestId,
    int seqNo
  ) {
    return new NotifyCustomerInformationRequest(
      null,
      data,
      generatedAt,
      requestId,
      seqNo,
      null
    );
  }
  public static NotifyCustomerInformationRequest of(
    @Nullable CustomData customData,
    String data,
    Instant generatedAt,
    int requestId,
    int seqNo,
    @Nullable Boolean tbc
  ) {
    return new NotifyCustomerInformationRequest(
      customData,
      data,
      generatedAt,
      requestId,
      seqNo,
      tbc
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
    return Ocpp201Action.NOTIFY_CUSTOMER_INFORMATION;
  }
}
