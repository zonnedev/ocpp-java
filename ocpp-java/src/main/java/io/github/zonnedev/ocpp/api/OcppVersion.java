package io.github.zonnedev.ocpp.api;

import java.util.Objects;

public enum OcppVersion {
  OCPP_1_6_JSON("1.6", "ocpp1.6"), OCPP_2_0_1("2.0.1", "ocpp2.0.1");

  private final String value;
  private final String websocketSubprotocol;

  OcppVersion(
    String value,
    String websocketSubprotocol
  ) {
    this.value = value;
    this.websocketSubprotocol = websocketSubprotocol;
  }

  public String value() {
    return value;
  }
  public String websocketSubprotocol() {
    return websocketSubprotocol;
  }

  public static OcppVersion fromValue(String value) {
    Objects.requireNonNull(
      value,
      "value"
    );
    return switch (value) {
      case "1.6" -> OCPP_1_6_JSON;
      case "2.0.1" -> OCPP_2_0_1;
      default -> throw new IllegalArgumentException("Unsupported OCPP version: " + value);
    };
  }
}
