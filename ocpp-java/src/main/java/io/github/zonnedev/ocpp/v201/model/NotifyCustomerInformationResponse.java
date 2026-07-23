package io.github.zonnedev.ocpp.v201.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.github.zonnedev.ocpp.api.OcppVersion;
import io.github.zonnedev.ocpp.v201.Ocpp201Action;
import io.github.zonnedev.ocpp.v201.Ocpp201Response;
import io.github.zonnedev.ocpp.v201.model.type.CustomData;
import org.jspecify.annotations.Nullable;

/**
 * Immutable schema type generated from
 * schemas/v201/NotifyCustomerInformationResponse.json.
 */
public record NotifyCustomerInformationResponse(
  @Nullable CustomData customData
) implements Ocpp201Response {
  public NotifyCustomerInformationResponse {

  }

  public static NotifyCustomerInformationResponse of() {
    return new NotifyCustomerInformationResponse(null);
  }
  public static NotifyCustomerInformationResponse of(@Nullable CustomData customData) {
    return new NotifyCustomerInformationResponse(customData);
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
