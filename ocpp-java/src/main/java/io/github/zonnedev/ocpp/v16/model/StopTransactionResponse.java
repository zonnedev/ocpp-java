package io.github.zonnedev.ocpp.v16.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.zonnedev.ocpp.api.OcppVersion;
import io.github.zonnedev.ocpp.v16.Ocpp16Action;
import io.github.zonnedev.ocpp.v16.Ocpp16Response;
import java.time.Instant;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * Immutable schema type generated from
 * schemas/v16/StopTransactionResponse.json.
 */
public record StopTransactionResponse(
  @Nullable IdTagInfo idTagInfo
) implements Ocpp16Response {
  public StopTransactionResponse {

  }

  public static StopTransactionResponse of() {
    return new StopTransactionResponse(null);
  }
  public static StopTransactionResponse of(@Nullable IdTagInfo idTagInfo) {
    return new StopTransactionResponse(idTagInfo);
  }

  @JsonIgnore
  @Override
  public OcppVersion version() {
    return OcppVersion.OCPP_1_6_JSON;
  }

  @JsonIgnore
  @Override
  public Ocpp16Action action() {
    return Ocpp16Action.STOP_TRANSACTION;
  }

  /**
   * Immutable schema type generated from schemas/v16/StopTransactionResponse.json
   * inline object.
   */
  public record IdTagInfo(
    @Nullable Instant expiryDate,
    @Nullable String parentIdTag,
    Status status
  ) {
    public IdTagInfo {
      if (parentIdTag != null && (parentIdTag.length() > 20)) {
        throw new IllegalArgumentException("parentIdTag length violates schema constraints");
      }
      Objects.requireNonNull(
        status,
        "status"
      );
    }

    public static IdTagInfo of(Status status) {
      return new IdTagInfo(
        null,
        null,
        status
      );
    }
    public static IdTagInfo of(
      @Nullable Instant expiryDate,
      @Nullable String parentIdTag,
      Status status
    ) {
      return new IdTagInfo(
        expiryDate,
        parentIdTag,
        status
      );
    }

    /** Closed wire enumeration generated from v16 inline enumeration. */
    public enum Status {
      ACCEPTED("Accepted"), BLOCKED("Blocked"), EXPIRED("Expired"), INVALID(
        "Invalid"
      ), CONCURRENT_TX(
        "ConcurrentTx"
      );

      private final String wireValue;

      Status(String wireValue) {
        this.wireValue = wireValue;
      }

      @JsonValue
      public String wireValue() {
        return wireValue;
      }

      @JsonCreator
      public static Status fromWireValue(String wireValue) {
        Objects.requireNonNull(
          wireValue,
          "wireValue"
        );
        return switch (wireValue) {
          case "Accepted" -> ACCEPTED;
          case "Blocked" -> BLOCKED;
          case "Expired" -> EXPIRED;
          case "Invalid" -> INVALID;
          case "ConcurrentTx" -> CONCURRENT_TX;
          default -> throw new IllegalArgumentException(
            "Unknown Status: " + wireValue
          );
        };
      }
    }
  }
}
