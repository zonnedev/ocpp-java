package io.github.zonnedev.ocpp.v201.model.type;

import java.time.Instant;
import java.util.List;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * Immutable schema type generated from v201 reusable definition
 * IdTokenInfoType.
 */
public record IdTokenInfo(
  @Nullable Instant cacheExpiryDateTime,
  @Nullable Integer chargingPriority,
  @Nullable CustomData customData,
  @Nullable List<Integer> evseId,
  @Nullable IdToken groupIdToken,
  @Nullable String language1,
  @Nullable String language2,
  @Nullable MessageContent personalMessage,
  AuthorizationStatusEnum status
) {
  public IdTokenInfo {
    evseId = evseId == null ? null : List.copyOf(evseId);
    if (evseId != null && (evseId.size() < 1)) {
      throw new IllegalArgumentException("evseId size violates schema constraints");
    }
    if (language1 != null && (language1.length() > 8)) {
      throw new IllegalArgumentException("language1 length violates schema constraints");
    }
    if (language2 != null && (language2.length() > 8)) {
      throw new IllegalArgumentException("language2 length violates schema constraints");
    }
    Objects.requireNonNull(
      status,
      "status"
    );
  }

  public static IdTokenInfo of(AuthorizationStatusEnum status) {
    return new IdTokenInfo(
      null,
      null,
      null,
      null,
      null,
      null,
      null,
      null,
      status
    );
  }
  public static IdTokenInfo of(
    @Nullable Instant cacheExpiryDateTime,
    @Nullable Integer chargingPriority,
    @Nullable CustomData customData,
    @Nullable List<Integer> evseId,
    @Nullable IdToken groupIdToken,
    @Nullable String language1,
    @Nullable String language2,
    @Nullable MessageContent personalMessage,
    AuthorizationStatusEnum status
  ) {
    return new IdTokenInfo(
      cacheExpiryDateTime,
      chargingPriority,
      customData,
      evseId,
      groupIdToken,
      language1,
      language2,
      personalMessage,
      status
    );
  }
}
