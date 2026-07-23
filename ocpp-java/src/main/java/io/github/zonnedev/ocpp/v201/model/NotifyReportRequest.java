package io.github.zonnedev.ocpp.v201.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.zonnedev.ocpp.api.OcppVersion;
import io.github.zonnedev.ocpp.v201.Ocpp201Action;
import io.github.zonnedev.ocpp.v201.Ocpp201Request;
import io.github.zonnedev.ocpp.v201.model.type.AttributeEnum;
import io.github.zonnedev.ocpp.v201.model.type.Component;
import io.github.zonnedev.ocpp.v201.model.type.CustomData;
import io.github.zonnedev.ocpp.v201.model.type.Variable;
import java.time.Instant;
import java.util.List;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * Immutable schema type generated from schemas/v201/NotifyReportRequest.json.
 */
public record NotifyReportRequest(
  @Nullable CustomData customData,
  Instant generatedAt,
  @Nullable List<ReportData> reportData,
  int requestId,
  int seqNo,
  @Nullable Boolean tbc
) implements Ocpp201Request {
  public NotifyReportRequest {
    Objects.requireNonNull(
      generatedAt,
      "generatedAt"
    );
    reportData = reportData == null ? null : List.copyOf(reportData);
    if (reportData != null && (reportData.size() < 1)) {
      throw new IllegalArgumentException("reportData size violates schema constraints");
    }
  }

  public static NotifyReportRequest of(
    Instant generatedAt,
    int requestId,
    int seqNo
  ) {
    return new NotifyReportRequest(
      null,
      generatedAt,
      null,
      requestId,
      seqNo,
      null
    );
  }
  public static NotifyReportRequest of(
    @Nullable CustomData customData,
    Instant generatedAt,
    @Nullable List<ReportData> reportData,
    int requestId,
    int seqNo,
    @Nullable Boolean tbc
  ) {
    return new NotifyReportRequest(
      customData,
      generatedAt,
      reportData,
      requestId,
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
    return Ocpp201Action.NOTIFY_REPORT;
  }

  /**
   * Immutable schema type generated from v201 reusable definition ReportDataType.
   */
  public record ReportData(
    Component component,
    @Nullable CustomData customData,
    Variable variable,
    List<VariableAttribute> variableAttribute,
    @Nullable VariableCharacteristics variableCharacteristics
  ) {
    public ReportData {
      Objects.requireNonNull(
        component,
        "component"
      );
      Objects.requireNonNull(
        variable,
        "variable"
      );
      Objects.requireNonNull(
        variableAttribute,
        "variableAttribute"
      );
      variableAttribute = List.copyOf(variableAttribute);
      if (variableAttribute.size() < 1 || variableAttribute.size() > 4) {
        throw new IllegalArgumentException("variableAttribute size violates schema constraints");
      }
    }

    public static ReportData of(
      Component component,
      Variable variable,
      List<VariableAttribute> variableAttribute
    ) {
      return new ReportData(
        component,
        null,
        variable,
        variableAttribute,
        null
      );
    }
    public static ReportData of(
      Component component,
      @Nullable CustomData customData,
      Variable variable,
      List<VariableAttribute> variableAttribute,
      @Nullable VariableCharacteristics variableCharacteristics
    ) {
      return new ReportData(
        component,
        customData,
        variable,
        variableAttribute,
        variableCharacteristics
      );
    }

    /**
     * Immutable schema type generated from v201 reusable definition
     * VariableAttributeType.
     */
    public record VariableAttribute(
      @Nullable Boolean constant,
      @Nullable CustomData customData,
      @Nullable MutabilityEnum mutability,
      @Nullable Boolean persistent,
      @Nullable AttributeEnum type,
      @Nullable String value
    ) {
      public VariableAttribute {
        if (value != null && (value.length() > 2500)) {
          throw new IllegalArgumentException("value length violates schema constraints");
        }
      }

      public static VariableAttribute of() {
        return new VariableAttribute(
          null,
          null,
          null,
          null,
          null,
          null
        );
      }
      public static VariableAttribute of(
        @Nullable Boolean constant,
        @Nullable CustomData customData,
        @Nullable MutabilityEnum mutability,
        @Nullable Boolean persistent,
        @Nullable AttributeEnum type,
        @Nullable String value
      ) {
        return new VariableAttribute(
          constant,
          customData,
          mutability,
          persistent,
          type,
          value
        );
      }

      /**
       * Closed wire enumeration generated from v201 reusable definition
       * MutabilityEnumType.
       */
      public enum MutabilityEnum {
        READ_ONLY("ReadOnly"), WRITE_ONLY("WriteOnly"), READ_WRITE("ReadWrite");

        private final String wireValue;

        MutabilityEnum(String wireValue) {
          this.wireValue = wireValue;
        }

        @JsonValue
        public String wireValue() {
          return wireValue;
        }

        @JsonCreator
        public static MutabilityEnum fromWireValue(String wireValue) {
          Objects.requireNonNull(
            wireValue,
            "wireValue"
          );
          return switch (wireValue) {
            case "ReadOnly" -> READ_ONLY;
            case "WriteOnly" -> WRITE_ONLY;
            case "ReadWrite" -> READ_WRITE;
            default -> throw new IllegalArgumentException("Unknown MutabilityEnum: " + wireValue);
          };
        }
      }
    }

    /**
     * Immutable schema type generated from v201 reusable definition
     * VariableCharacteristicsType.
     */
    public record VariableCharacteristics(
      @Nullable CustomData customData,
      DataEnum dataType,
      @Nullable Double maxLimit,
      @Nullable Double minLimit,
      boolean supportsMonitoring,
      @Nullable String unit,
      @Nullable String valuesList
    ) {
      public VariableCharacteristics {
        Objects.requireNonNull(
          dataType,
          "dataType"
        );
        if (unit != null && (unit.length() > 16)) {
          throw new IllegalArgumentException("unit length violates schema constraints");
        }
        if (valuesList != null && (valuesList.length() > 1000)) {
          throw new IllegalArgumentException("valuesList length violates schema constraints");
        }
      }

      public static VariableCharacteristics of(
        DataEnum dataType,
        boolean supportsMonitoring
      ) {
        return new VariableCharacteristics(
          null,
          dataType,
          null,
          null,
          supportsMonitoring,
          null,
          null
        );
      }
      public static VariableCharacteristics of(
        @Nullable CustomData customData,
        DataEnum dataType,
        @Nullable Double maxLimit,
        @Nullable Double minLimit,
        boolean supportsMonitoring,
        @Nullable String unit,
        @Nullable String valuesList
      ) {
        return new VariableCharacteristics(
          customData,
          dataType,
          maxLimit,
          minLimit,
          supportsMonitoring,
          unit,
          valuesList
        );
      }

      /**
       * Closed wire enumeration generated from v201 reusable definition DataEnumType.
       */
      public enum DataEnum {
        STRING("string"), DECIMAL("decimal"), INTEGER("integer"), DATE_TIME("dateTime"), BOOLEAN(
          "boolean"
        ), OPTION_LIST("OptionList"), SEQUENCE_LIST("SequenceList"), MEMBER_LIST("MemberList");

        private final String wireValue;

        DataEnum(String wireValue) {
          this.wireValue = wireValue;
        }

        @JsonValue
        public String wireValue() {
          return wireValue;
        }

        @JsonCreator
        public static DataEnum fromWireValue(String wireValue) {
          Objects.requireNonNull(
            wireValue,
            "wireValue"
          );
          return switch (wireValue) {
            case "string" -> STRING;
            case "decimal" -> DECIMAL;
            case "integer" -> INTEGER;
            case "dateTime" -> DATE_TIME;
            case "boolean" -> BOOLEAN;
            case "OptionList" -> OPTION_LIST;
            case "SequenceList" -> SEQUENCE_LIST;
            case "MemberList" -> MEMBER_LIST;
            default -> throw new IllegalArgumentException("Unknown DataEnum: " + wireValue);
          };
        }
      }
    }
  }
}
