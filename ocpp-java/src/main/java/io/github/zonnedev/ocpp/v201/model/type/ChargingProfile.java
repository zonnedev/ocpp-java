package io.github.zonnedev.ocpp.v201.model.type;

import java.time.Instant;
import java.util.List;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * Immutable schema type generated from v201 reusable definition
 * ChargingProfileType.
 */
public record ChargingProfile(
  ChargingProfileKindEnum chargingProfileKind,
  ChargingProfilePurposeEnum chargingProfilePurpose,
  List<ChargingSchedule> chargingSchedule,
  @Nullable CustomData customData,
  int id,
  @Nullable RecurrencyKindEnum recurrencyKind,
  int stackLevel,
  @Nullable String transactionId,
  @Nullable Instant validFrom,
  @Nullable Instant validTo
) {
  public ChargingProfile {
    Objects.requireNonNull(
      chargingProfileKind,
      "chargingProfileKind"
    );
    Objects.requireNonNull(
      chargingProfilePurpose,
      "chargingProfilePurpose"
    );
    Objects.requireNonNull(
      chargingSchedule,
      "chargingSchedule"
    );
    chargingSchedule = List.copyOf(chargingSchedule);
    if (chargingSchedule.size() < 1 || chargingSchedule.size() > 3) {
      throw new IllegalArgumentException("chargingSchedule size violates schema constraints");
    }
    if (transactionId != null && (transactionId.length() > 36)) {
      throw new IllegalArgumentException("transactionId length violates schema constraints");
    }
  }

  public static ChargingProfile of(
    ChargingProfileKindEnum chargingProfileKind,
    ChargingProfilePurposeEnum chargingProfilePurpose,
    List<ChargingSchedule> chargingSchedule,
    int id,
    int stackLevel
  ) {
    return new ChargingProfile(
      chargingProfileKind,
      chargingProfilePurpose,
      chargingSchedule,
      null,
      id,
      null,
      stackLevel,
      null,
      null,
      null
    );
  }
  public static ChargingProfile of(
    ChargingProfileKindEnum chargingProfileKind,
    ChargingProfilePurposeEnum chargingProfilePurpose,
    List<ChargingSchedule> chargingSchedule,
    @Nullable CustomData customData,
    int id,
    @Nullable RecurrencyKindEnum recurrencyKind,
    int stackLevel,
    @Nullable String transactionId,
    @Nullable Instant validFrom,
    @Nullable Instant validTo
  ) {
    return new ChargingProfile(
      chargingProfileKind,
      chargingProfilePurpose,
      chargingSchedule,
      customData,
      id,
      recurrencyKind,
      stackLevel,
      transactionId,
      validFrom,
      validTo
    );
  }
}
