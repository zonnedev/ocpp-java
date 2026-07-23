package io.github.zonnedev.ocpp.v201.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.zonnedev.ocpp.api.OcppVersion;
import io.github.zonnedev.ocpp.v201.Ocpp201Action;
import io.github.zonnedev.ocpp.v201.Ocpp201Request;
import io.github.zonnedev.ocpp.v201.model.type.CustomData;
import io.github.zonnedev.ocpp.v201.model.type.IdToken;
import io.github.zonnedev.ocpp.v201.model.type.IdTokenInfo;
import java.util.List;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * Immutable schema type generated from schemas/v201/SendLocalListRequest.json.
 */
public record SendLocalListRequest(
  @Nullable CustomData customData,
  @Nullable List<AuthorizationData> localAuthorizationList,
  UpdateEnum updateType,
  int versionNumber
) implements Ocpp201Request {
  public SendLocalListRequest {
    localAuthorizationList = localAuthorizationList == null
      ? null
      : List.copyOf(localAuthorizationList);
    if (localAuthorizationList != null && (localAuthorizationList.size() < 1)) {
      throw new IllegalArgumentException("localAuthorizationList size violates schema constraints");
    }
    Objects.requireNonNull(
      updateType,
      "updateType"
    );
  }

  public static SendLocalListRequest of(
    UpdateEnum updateType,
    int versionNumber
  ) {
    return new SendLocalListRequest(
      null,
      null,
      updateType,
      versionNumber
    );
  }
  public static SendLocalListRequest of(
    @Nullable CustomData customData,
    @Nullable List<AuthorizationData> localAuthorizationList,
    UpdateEnum updateType,
    int versionNumber
  ) {
    return new SendLocalListRequest(
      customData,
      localAuthorizationList,
      updateType,
      versionNumber
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
    return Ocpp201Action.SEND_LOCAL_LIST;
  }

  /**
   * Immutable schema type generated from v201 reusable definition
   * AuthorizationData.
   */
  public record AuthorizationData(
    @Nullable CustomData customData,
    IdToken idToken,
    @Nullable IdTokenInfo idTokenInfo
  ) {
    public AuthorizationData {
      Objects.requireNonNull(
        idToken,
        "idToken"
      );
    }

    public static AuthorizationData of(IdToken idToken) {
      return new AuthorizationData(
        null,
        idToken,
        null
      );
    }
    public static AuthorizationData of(
      @Nullable CustomData customData,
      IdToken idToken,
      @Nullable IdTokenInfo idTokenInfo
    ) {
      return new AuthorizationData(
        customData,
        idToken,
        idTokenInfo
      );
    }
  }

  /**
   * Closed wire enumeration generated from v201 reusable definition
   * UpdateEnumType.
   */
  public enum UpdateEnum {
    DIFFERENTIAL("Differential"), FULL("Full");

    private final String wireValue;

    UpdateEnum(String wireValue) {
      this.wireValue = wireValue;
    }

    @JsonValue
    public String wireValue() {
      return wireValue;
    }

    @JsonCreator
    public static UpdateEnum fromWireValue(String wireValue) {
      Objects.requireNonNull(
        wireValue,
        "wireValue"
      );
      return switch (wireValue) {
        case "Differential" -> DIFFERENTIAL;
        case "Full" -> FULL;
        default -> throw new IllegalArgumentException("Unknown UpdateEnum: " + wireValue);
      };
    }
  }
}
