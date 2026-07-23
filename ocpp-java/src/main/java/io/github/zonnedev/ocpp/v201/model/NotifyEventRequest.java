package io.github.zonnedev.ocpp.v201.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.zonnedev.ocpp.api.OcppVersion;
import io.github.zonnedev.ocpp.v201.Ocpp201Action;
import io.github.zonnedev.ocpp.v201.Ocpp201Request;
import io.github.zonnedev.ocpp.v201.model.type.Component;
import io.github.zonnedev.ocpp.v201.model.type.CustomData;
import io.github.zonnedev.ocpp.v201.model.type.Variable;
import java.time.Instant;
import java.util.List;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * Immutable schema type generated from schemas/v201/NotifyEventRequest.json.
 */
public record NotifyEventRequest(
  @Nullable CustomData customData,
  List<EventData> eventData,
  Instant generatedAt,
  int seqNo,
  @Nullable Boolean tbc
) implements Ocpp201Request {
  public NotifyEventRequest {
    Objects.requireNonNull(
      eventData,
      "eventData"
    );
    eventData = List.copyOf(eventData);
    if (eventData.size() < 1) {
      throw new IllegalArgumentException("eventData size violates schema constraints");
    }
    Objects.requireNonNull(
      generatedAt,
      "generatedAt"
    );
  }

  public static NotifyEventRequest of(
    List<EventData> eventData,
    Instant generatedAt,
    int seqNo
  ) {
    return new NotifyEventRequest(
      null,
      eventData,
      generatedAt,
      seqNo,
      null
    );
  }
  public static NotifyEventRequest of(
    @Nullable CustomData customData,
    List<EventData> eventData,
    Instant generatedAt,
    int seqNo,
    @Nullable Boolean tbc
  ) {
    return new NotifyEventRequest(
      customData,
      eventData,
      generatedAt,
      seqNo,
      tbc
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
    return Ocpp201Action.NOTIFY_EVENT;
  }

  /**
   * Immutable schema type generated from v201 reusable definition EventDataType.
   */
  public record EventData(
    String actualValue,
    @Nullable Integer cause,
    @Nullable Boolean cleared,
    Component component,
    @Nullable CustomData customData,
    int eventId,
    EventNotificationEnum eventNotificationType,
    @Nullable String techCode,
    @Nullable String techInfo,
    Instant timestamp,
    @Nullable String transactionId,
    EventTriggerEnum trigger,
    Variable variable,
    @Nullable Integer variableMonitoringId
  ) {
    public EventData {
      Objects.requireNonNull(
        actualValue,
        "actualValue"
      );
      if (actualValue.length() > 2500) {
        throw new IllegalArgumentException("actualValue length violates schema constraints");
      }
      Objects.requireNonNull(
        component,
        "component"
      );
      Objects.requireNonNull(
        eventNotificationType,
        "eventNotificationType"
      );
      if (techCode != null && (techCode.length() > 50)) {
        throw new IllegalArgumentException("techCode length violates schema constraints");
      }
      if (techInfo != null && (techInfo.length() > 500)) {
        throw new IllegalArgumentException("techInfo length violates schema constraints");
      }
      Objects.requireNonNull(
        timestamp,
        "timestamp"
      );
      if (transactionId != null && (transactionId.length() > 36)) {
        throw new IllegalArgumentException("transactionId length violates schema constraints");
      }
      Objects.requireNonNull(
        trigger,
        "trigger"
      );
      Objects.requireNonNull(
        variable,
        "variable"
      );
    }

    public static EventData of(
      String actualValue,
      Component component,
      int eventId,
      EventNotificationEnum eventNotificationType,
      Instant timestamp,
      EventTriggerEnum trigger,
      Variable variable
    ) {
      return new EventData(
        actualValue,
        null,
        null,
        component,
        null,
        eventId,
        eventNotificationType,
        null,
        null,
        timestamp,
        null,
        trigger,
        variable,
        null
      );
    }
    public static EventData of(
      String actualValue,
      @Nullable Integer cause,
      @Nullable Boolean cleared,
      Component component,
      @Nullable CustomData customData,
      int eventId,
      EventNotificationEnum eventNotificationType,
      @Nullable String techCode,
      @Nullable String techInfo,
      Instant timestamp,
      @Nullable String transactionId,
      EventTriggerEnum trigger,
      Variable variable,
      @Nullable Integer variableMonitoringId
    ) {
      return new EventData(
        actualValue,
        cause,
        cleared,
        component,
        customData,
        eventId,
        eventNotificationType,
        techCode,
        techInfo,
        timestamp,
        transactionId,
        trigger,
        variable,
        variableMonitoringId
      );
    }

    /**
     * Closed wire enumeration generated from v201 reusable definition
     * EventNotificationEnumType.
     */
    public enum EventNotificationEnum {
      HARD_WIRED_NOTIFICATION("HardWiredNotification"), HARD_WIRED_MONITOR(
        "HardWiredMonitor"
      ), PRECONFIGURED_MONITOR("PreconfiguredMonitor"), CUSTOM_MONITOR("CustomMonitor");

      private final String wireValue;

      EventNotificationEnum(String wireValue) {
        this.wireValue = wireValue;
      }

      @JsonValue
      public String wireValue() {
        return wireValue;
      }

      @JsonCreator
      public static EventNotificationEnum fromWireValue(String wireValue) {
        Objects.requireNonNull(
          wireValue,
          "wireValue"
        );
        return switch (wireValue) {
          case "HardWiredNotification" -> HARD_WIRED_NOTIFICATION;
          case "HardWiredMonitor" -> HARD_WIRED_MONITOR;
          case "PreconfiguredMonitor" -> PRECONFIGURED_MONITOR;
          case "CustomMonitor" -> CUSTOM_MONITOR;
          default ->
            throw new IllegalArgumentException("Unknown EventNotificationEnum: " + wireValue);
        };
      }
    }

    /**
     * Closed wire enumeration generated from v201 reusable definition
     * EventTriggerEnumType.
     */
    public enum EventTriggerEnum {
      ALERTING("Alerting"), DELTA("Delta"), PERIODIC("Periodic");

      private final String wireValue;

      EventTriggerEnum(String wireValue) {
        this.wireValue = wireValue;
      }

      @JsonValue
      public String wireValue() {
        return wireValue;
      }

      @JsonCreator
      public static EventTriggerEnum fromWireValue(String wireValue) {
        Objects.requireNonNull(
          wireValue,
          "wireValue"
        );
        return switch (wireValue) {
          case "Alerting" -> ALERTING;
          case "Delta" -> DELTA;
          case "Periodic" -> PERIODIC;
          default -> throw new IllegalArgumentException("Unknown EventTriggerEnum: " + wireValue);
        };
      }
    }
  }
}
