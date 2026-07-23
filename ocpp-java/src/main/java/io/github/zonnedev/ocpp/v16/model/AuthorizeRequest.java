package io.github.zonnedev.ocpp.v16.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Objects;
import io.github.zonnedev.ocpp.api.OcppVersion;
import io.github.zonnedev.ocpp.v16.Ocpp16Action;
import io.github.zonnedev.ocpp.v16.Ocpp16Request;

/** Immutable schema type generated from schemas/v16/Authorize.json. */
public record AuthorizeRequest(
  String idTag
) implements Ocpp16Request {
  public AuthorizeRequest {
    Objects.requireNonNull(
      idTag,
      "idTag"
    );
    if (idTag.length() > 20) {
      throw new IllegalArgumentException("idTag length violates schema constraints");
    }
  }

  public static AuthorizeRequest of(String idTag) {
    return new AuthorizeRequest(idTag);
  }

  @JsonIgnore
  @Override
  public OcppVersion version() {
    return OcppVersion.OCPP_1_6_JSON;
  }

  @JsonIgnore
  @Override
  public Ocpp16Action action() {
    return Ocpp16Action.AUTHORIZE;
  }
}
