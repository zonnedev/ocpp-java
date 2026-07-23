package io.github.zonnedev.ocpp.v201.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.zonnedev.ocpp.api.OcppVersion;
import io.github.zonnedev.ocpp.v201.Ocpp201Action;
import io.github.zonnedev.ocpp.v201.Ocpp201Request;
import io.github.zonnedev.ocpp.v201.model.type.CustomData;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * Immutable schema type generated from
 * schemas/v201/SetNetworkProfileRequest.json.
 */
public record SetNetworkProfileRequest(
  int configurationSlot,
  NetworkConnectionProfile connectionData,
  @Nullable CustomData customData
) implements Ocpp201Request {
  public SetNetworkProfileRequest {
    Objects.requireNonNull(
      connectionData,
      "connectionData"
    );
  }

  public static SetNetworkProfileRequest of(
    int configurationSlot,
    NetworkConnectionProfile connectionData
  ) {
    return new SetNetworkProfileRequest(
      configurationSlot,
      connectionData,
      null
    );
  }
  public static SetNetworkProfileRequest of(
    int configurationSlot,
    NetworkConnectionProfile connectionData,
    @Nullable CustomData customData
  ) {
    return new SetNetworkProfileRequest(
      configurationSlot,
      connectionData,
      customData
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
    return Ocpp201Action.SET_NETWORK_PROFILE;
  }

  /**
   * Immutable schema type generated from v201 reusable definition
   * NetworkConnectionProfileType.
   */
  public record NetworkConnectionProfile(
    @Nullable APN apn,
    @Nullable CustomData customData,
    int messageTimeout,
    String ocppCsmsUrl,
    OCPPInterfaceEnum ocppInterface,
    OCPPTransportEnum ocppTransport,
    OCPPVersionEnum ocppVersion,
    int securityProfile,
    @Nullable VPN vpn
  ) {
    public NetworkConnectionProfile {
      Objects.requireNonNull(
        ocppCsmsUrl,
        "ocppCsmsUrl"
      );
      if (ocppCsmsUrl.length() > 512) {
        throw new IllegalArgumentException("ocppCsmsUrl length violates schema constraints");
      }
      Objects.requireNonNull(
        ocppInterface,
        "ocppInterface"
      );
      Objects.requireNonNull(
        ocppTransport,
        "ocppTransport"
      );
      Objects.requireNonNull(
        ocppVersion,
        "ocppVersion"
      );
    }

    public static NetworkConnectionProfile of(
      int messageTimeout,
      String ocppCsmsUrl,
      OCPPInterfaceEnum ocppInterface,
      OCPPTransportEnum ocppTransport,
      OCPPVersionEnum ocppVersion,
      int securityProfile
    ) {
      return new NetworkConnectionProfile(
        null,
        null,
        messageTimeout,
        ocppCsmsUrl,
        ocppInterface,
        ocppTransport,
        ocppVersion,
        securityProfile,
        null
      );
    }
    public static NetworkConnectionProfile of(
      @Nullable APN apn,
      @Nullable CustomData customData,
      int messageTimeout,
      String ocppCsmsUrl,
      OCPPInterfaceEnum ocppInterface,
      OCPPTransportEnum ocppTransport,
      OCPPVersionEnum ocppVersion,
      int securityProfile,
      @Nullable VPN vpn
    ) {
      return new NetworkConnectionProfile(
        apn,
        customData,
        messageTimeout,
        ocppCsmsUrl,
        ocppInterface,
        ocppTransport,
        ocppVersion,
        securityProfile,
        vpn
      );
    }

    /** Immutable schema type generated from v201 reusable definition APNType. */
    public record APN(
      String apn,
      AuthenticationEnum apnAuthentication,
      @Nullable String apnPassword,
      @Nullable String apnUserName,
      @Nullable CustomData customData,
      @Nullable String preferredNetwork,
      @Nullable Integer simPin,
      @Nullable Boolean useOnlyPreferredNetwork
    ) {
      public APN {
        Objects.requireNonNull(
          apn,
          "apn"
        );
        if (apn.length() > 512) {
          throw new IllegalArgumentException("apn length violates schema constraints");
        }
        Objects.requireNonNull(
          apnAuthentication,
          "apnAuthentication"
        );
        if (apnPassword != null && (apnPassword.length() > 20)) {
          throw new IllegalArgumentException("apnPassword length violates schema constraints");
        }
        if (apnUserName != null && (apnUserName.length() > 20)) {
          throw new IllegalArgumentException("apnUserName length violates schema constraints");
        }
        if (preferredNetwork != null && (preferredNetwork.length() > 6)) {
          throw new IllegalArgumentException("preferredNetwork length violates schema constraints");
        }
      }

      public static APN of(
        String apn,
        AuthenticationEnum apnAuthentication
      ) {
        return new APN(
          apn,
          apnAuthentication,
          null,
          null,
          null,
          null,
          null,
          null
        );
      }
      public static APN of(
        String apn,
        AuthenticationEnum apnAuthentication,
        @Nullable String apnPassword,
        @Nullable String apnUserName,
        @Nullable CustomData customData,
        @Nullable String preferredNetwork,
        @Nullable Integer simPin,
        @Nullable Boolean useOnlyPreferredNetwork
      ) {
        return new APN(
          apn,
          apnAuthentication,
          apnPassword,
          apnUserName,
          customData,
          preferredNetwork,
          simPin,
          useOnlyPreferredNetwork
        );
      }

      /**
       * Closed wire enumeration generated from v201 reusable definition
       * APNAuthenticationEnumType.
       */
      public enum AuthenticationEnum {
        CHAP("CHAP"), NONE("NONE"), PAP("PAP"), AUTO("AUTO");

        private final String wireValue;

        AuthenticationEnum(String wireValue) {
          this.wireValue = wireValue;
        }

        @JsonValue
        public String wireValue() {
          return wireValue;
        }

        @JsonCreator
        public static AuthenticationEnum fromWireValue(String wireValue) {
          Objects.requireNonNull(
            wireValue,
            "wireValue"
          );
          return switch (wireValue) {
            case "CHAP" -> CHAP;
            case "NONE" -> NONE;
            case "PAP" -> PAP;
            case "AUTO" -> AUTO;
            default ->
              throw new IllegalArgumentException("Unknown AuthenticationEnum: " + wireValue);
          };
        }
      }
    }

    /**
     * Closed wire enumeration generated from v201 reusable definition
     * OCPPInterfaceEnumType.
     */
    public enum OCPPInterfaceEnum {
      WIRED0("Wired0"), WIRED1("Wired1"), WIRED2("Wired2"), WIRED3("Wired3"), WIRELESS0(
        "Wireless0"
      ), WIRELESS1("Wireless1"), WIRELESS2("Wireless2"), WIRELESS3("Wireless3");

      private final String wireValue;

      OCPPInterfaceEnum(String wireValue) {
        this.wireValue = wireValue;
      }

      @JsonValue
      public String wireValue() {
        return wireValue;
      }

      @JsonCreator
      public static OCPPInterfaceEnum fromWireValue(String wireValue) {
        Objects.requireNonNull(
          wireValue,
          "wireValue"
        );
        return switch (wireValue) {
          case "Wired0" -> WIRED0;
          case "Wired1" -> WIRED1;
          case "Wired2" -> WIRED2;
          case "Wired3" -> WIRED3;
          case "Wireless0" -> WIRELESS0;
          case "Wireless1" -> WIRELESS1;
          case "Wireless2" -> WIRELESS2;
          case "Wireless3" -> WIRELESS3;
          default -> throw new IllegalArgumentException("Unknown OCPPInterfaceEnum: " + wireValue);
        };
      }
    }

    /**
     * Closed wire enumeration generated from v201 reusable definition
     * OCPPTransportEnumType.
     */
    public enum OCPPTransportEnum {
      JSON("JSON"), SOAP("SOAP");

      private final String wireValue;

      OCPPTransportEnum(String wireValue) {
        this.wireValue = wireValue;
      }

      @JsonValue
      public String wireValue() {
        return wireValue;
      }

      @JsonCreator
      public static OCPPTransportEnum fromWireValue(String wireValue) {
        Objects.requireNonNull(
          wireValue,
          "wireValue"
        );
        return switch (wireValue) {
          case "JSON" -> JSON;
          case "SOAP" -> SOAP;
          default -> throw new IllegalArgumentException("Unknown OCPPTransportEnum: " + wireValue);
        };
      }
    }

    /**
     * Closed wire enumeration generated from v201 reusable definition
     * OCPPVersionEnumType.
     */
    public enum OCPPVersionEnum {
      OCPP12("OCPP12"), OCPP15("OCPP15"), OCPP16("OCPP16"), OCPP20("OCPP20");

      private final String wireValue;

      OCPPVersionEnum(String wireValue) {
        this.wireValue = wireValue;
      }

      @JsonValue
      public String wireValue() {
        return wireValue;
      }

      @JsonCreator
      public static OCPPVersionEnum fromWireValue(String wireValue) {
        Objects.requireNonNull(
          wireValue,
          "wireValue"
        );
        return switch (wireValue) {
          case "OCPP12" -> OCPP12;
          case "OCPP15" -> OCPP15;
          case "OCPP16" -> OCPP16;
          case "OCPP20" -> OCPP20;
          default -> throw new IllegalArgumentException("Unknown OCPPVersionEnum: " + wireValue);
        };
      }
    }

    /** Immutable schema type generated from v201 reusable definition VPNType. */
    public record VPN(
      @Nullable CustomData customData,
      @Nullable String group,
      String key,
      String password,
      String server,
      Enum type,
      String user
    ) {
      public VPN {
        if (group != null && (group.length() > 20)) {
          throw new IllegalArgumentException("group length violates schema constraints");
        }
        Objects.requireNonNull(
          key,
          "key"
        );
        if (key.length() > 255) {
          throw new IllegalArgumentException("key length violates schema constraints");
        }
        Objects.requireNonNull(
          password,
          "password"
        );
        if (password.length() > 20) {
          throw new IllegalArgumentException("password length violates schema constraints");
        }
        Objects.requireNonNull(
          server,
          "server"
        );
        if (server.length() > 512) {
          throw new IllegalArgumentException("server length violates schema constraints");
        }
        Objects.requireNonNull(
          type,
          "type"
        );
        Objects.requireNonNull(
          user,
          "user"
        );
        if (user.length() > 20) {
          throw new IllegalArgumentException("user length violates schema constraints");
        }
      }

      public static VPN of(
        String key,
        String password,
        String server,
        Enum type,
        String user
      ) {
        return new VPN(
          null,
          null,
          key,
          password,
          server,
          type,
          user
        );
      }
      public static VPN of(
        @Nullable CustomData customData,
        @Nullable String group,
        String key,
        String password,
        String server,
        Enum type,
        String user
      ) {
        return new VPN(
          customData,
          group,
          key,
          password,
          server,
          type,
          user
        );
      }

      /**
       * Closed wire enumeration generated from v201 reusable definition VPNEnumType.
       */
      public enum Enum {
        IKEV2("IKEv2"), IPSEC("IPSec"), L2_TP("L2TP"), PPTP("PPTP");

        private final String wireValue;

        Enum(String wireValue) {
          this.wireValue = wireValue;
        }

        @JsonValue
        public String wireValue() {
          return wireValue;
        }

        @JsonCreator
        public static Enum fromWireValue(String wireValue) {
          Objects.requireNonNull(
            wireValue,
            "wireValue"
          );
          return switch (wireValue) {
            case "IKEv2" -> IKEV2;
            case "IPSec" -> IPSEC;
            case "L2TP" -> L2_TP;
            case "PPTP" -> PPTP;
            default -> throw new IllegalArgumentException("Unknown Enum: " + wireValue);
          };
        }
      }
    }
  }
}
