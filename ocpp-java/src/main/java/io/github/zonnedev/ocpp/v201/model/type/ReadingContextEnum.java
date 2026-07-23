package io.github.zonnedev.ocpp.v201.model.type;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.Objects;

/**
 * Closed wire enumeration generated from v201 reusable definition
 * ReadingContextEnumType.
 */
public enum ReadingContextEnum {
  INTERRUPTION_BEGIN("Interruption.Begin"), INTERRUPTION_END("Interruption.End"), OTHER(
    "Other"
  ), SAMPLE_CLOCK("Sample.Clock"), SAMPLE_PERIODIC(
    "Sample.Periodic"
  ), TRANSACTION_BEGIN("Transaction.Begin"), TRANSACTION_END("Transaction.End"), TRIGGER("Trigger");

  private final String wireValue;

  ReadingContextEnum(String wireValue) {
    this.wireValue = wireValue;
  }

  @JsonValue
  public String wireValue() {
    return wireValue;
  }

  @JsonCreator
  public static ReadingContextEnum fromWireValue(String wireValue) {
    Objects.requireNonNull(
      wireValue,
      "wireValue"
    );
    return switch (wireValue) {
      case "Interruption.Begin" -> INTERRUPTION_BEGIN;
      case "Interruption.End" -> INTERRUPTION_END;
      case "Other" -> OTHER;
      case "Sample.Clock" -> SAMPLE_CLOCK;
      case "Sample.Periodic" -> SAMPLE_PERIODIC;
      case "Transaction.Begin" -> TRANSACTION_BEGIN;
      case "Transaction.End" -> TRANSACTION_END;
      case "Trigger" -> TRIGGER;
      default -> throw new IllegalArgumentException("Unknown ReadingContextEnum: " + wireValue);
    };
  }
}
