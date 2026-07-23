package io.github.zonnedev.ocpp.codec;

import com.fasterxml.jackson.databind.JsonNode;
import java.util.Map;
import java.util.Objects;

public record OcppError(OcppErrorCode code, String description, Map<String, JsonNode> details) {
  public OcppError {
    Objects.requireNonNull(
      code,
      "code"
    );
    Objects.requireNonNull(
      description,
      "description"
    );
    details = Map.copyOf(
      Objects.requireNonNull(
        details,
        "details"
      )
    );
  }
  public static OcppError of(
    OcppErrorCode code,
    String description
  ) {
    return new OcppError(
      code,
      description,
      Map.of()
    );
  }
  public static OcppError of(
    OcppErrorCode code,
    String description,
    Map<String, JsonNode> details
  ) {
    return new OcppError(
      code,
      description,
      details
    );
  }
}
