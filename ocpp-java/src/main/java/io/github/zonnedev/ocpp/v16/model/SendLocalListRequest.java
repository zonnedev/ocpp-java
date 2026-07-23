package io.github.zonnedev.ocpp.v16.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.zonnedev.ocpp.api.OcppVersion;
import io.github.zonnedev.ocpp.v16.Ocpp16Action;
import io.github.zonnedev.ocpp.v16.Ocpp16Request;
import java.time.Instant;
import java.util.List;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/** Immutable schema type generated from schemas/v16/SendLocalList.json. */
public record SendLocalListRequest(
  int listVersion,
  @Nullable List<LocalAuthorizationListItem> localAuthorizationList,
  UpdateType updateType
) implements Ocpp16Request {
  public SendLocalListRequest {
    localAuthorizationList = localAuthorizationList == null
      ? null
      : List.copyOf(localAuthorizationList);
    Objects.requireNonNull(
      updateType,
      "updateType"
    );
  }

  public static SendLocalListRequest of(
    int listVersion,
    UpdateType updateType
  ) {
    return new SendLocalListRequest(
      listVersion,
      null,
      updateType
    );
  }
  public static SendLocalListRequest of(
    int listVersion,
    @Nullable List<LocalAuthorizationListItem> localAuthorizationList,
    UpdateType updateType
  ) {
    return new SendLocalListRequest(
      listVersion,
      localAuthorizationList,
      updateType
    );
  }

  @JsonIgnore
  @Override
  public OcppVersion version() {
    return OcppVersion.OCPP_1_6_JSON;
  }

  @JsonIgnore
  @Override
  public Ocpp16Action action() {
    return Ocpp16Action.SEND_LOCAL_LIST;
  }

  /**
   * Immutable schema type generated from schemas/v16/SendLocalList.json inline
   * object.
   */
  public record LocalAuthorizationListItem(
    String idTag,
    @Nullable IdTagInfo idTagInfo
  ) {
    public LocalAuthorizationListItem {
      Objects.requireNonNull(
        idTag,
        "idTag"
      );
      if (idTag.length() > 20) {
        throw new IllegalArgumentException("idTag length violates schema constraints");
      }
    }

    public static LocalAuthorizationListItem of(String idTag) {
      return new LocalAuthorizationListItem(
        idTag,
        null
      );
    }
    public static LocalAuthorizationListItem of(
      String idTag,
      @Nullable IdTagInfo idTagInfo
    ) {
      return new LocalAuthorizationListItem(
        idTag,
        idTagInfo
      );
    }

    /**
     * Immutable schema type generated from schemas/v16/SendLocalList.json inline
     * object.
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

      public static IdTagInfo of(
        Status status
      ) {
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
        public static Status fromWireValue(
          String wireValue
        ) {
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

  /** Closed wire enumeration generated from v16 inline enumeration. */
  public enum UpdateType {
    DIFFERENTIAL("Differential"), FULL("Full");

    private final String wireValue;

    UpdateType(String wireValue) {
      this.wireValue = wireValue;
    }

    @JsonValue
    public String wireValue() {
      return wireValue;
    }

    @JsonCreator
    public static UpdateType fromWireValue(String wireValue) {
      Objects.requireNonNull(
        wireValue,
        "wireValue"
      );
      return switch (wireValue) {
        case "Differential" -> DIFFERENTIAL;
        case "Full" -> FULL;
        default ->
          throw new IllegalArgumentException("Unknown UpdateType: " + wireValue);
      };
    }
  }
}
