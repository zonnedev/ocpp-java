package io.github.zonnedev.ocpp.v201.model.type;

import java.util.List;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * Immutable schema type generated from v201 reusable definition IdTokenType.
 */
public record IdToken(
  @Nullable List<AdditionalInfo> additionalInfo,
  @Nullable CustomData customData,
  String idToken,
  IdTokenEnum type
) {
  public IdToken {
    additionalInfo = additionalInfo == null ? null : List.copyOf(additionalInfo);
    if (additionalInfo != null && (additionalInfo.size() < 1)) {
      throw new IllegalArgumentException("additionalInfo size violates schema constraints");
    }
    Objects.requireNonNull(
      idToken,
      "idToken"
    );
    if (idToken.length() > 36) {
      throw new IllegalArgumentException("idToken length violates schema constraints");
    }
    Objects.requireNonNull(
      type,
      "type"
    );
  }

  public static IdToken of(
    String idToken,
    IdTokenEnum type
  ) {
    return new IdToken(
      null,
      null,
      idToken,
      type
    );
  }
  public static IdToken of(
    @Nullable List<AdditionalInfo> additionalInfo,
    @Nullable CustomData customData,
    String idToken,
    IdTokenEnum type
  ) {
    return new IdToken(
      additionalInfo,
      customData,
      idToken,
      type
    );
  }
}
