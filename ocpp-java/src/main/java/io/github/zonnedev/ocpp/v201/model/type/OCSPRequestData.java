package io.github.zonnedev.ocpp.v201.model.type;

import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * Immutable schema type generated from v201 reusable definition
 * OCSPRequestDataType.
 */
public record OCSPRequestData(
  @Nullable CustomData customData,
  HashAlgorithmEnum hashAlgorithm,
  String issuerKeyHash,
  String issuerNameHash,
  String responderURL,
  String serialNumber
) {
  public OCSPRequestData {
    Objects.requireNonNull(
      hashAlgorithm,
      "hashAlgorithm"
    );
    Objects.requireNonNull(
      issuerKeyHash,
      "issuerKeyHash"
    );
    if (issuerKeyHash.length() > 128) {
      throw new IllegalArgumentException("issuerKeyHash length violates schema constraints");
    }
    Objects.requireNonNull(
      issuerNameHash,
      "issuerNameHash"
    );
    if (issuerNameHash.length() > 128) {
      throw new IllegalArgumentException("issuerNameHash length violates schema constraints");
    }
    Objects.requireNonNull(
      responderURL,
      "responderURL"
    );
    if (responderURL.length() > 512) {
      throw new IllegalArgumentException("responderURL length violates schema constraints");
    }
    Objects.requireNonNull(
      serialNumber,
      "serialNumber"
    );
    if (serialNumber.length() > 40) {
      throw new IllegalArgumentException("serialNumber length violates schema constraints");
    }
  }

  public static OCSPRequestData of(
    HashAlgorithmEnum hashAlgorithm,
    String issuerKeyHash,
    String issuerNameHash,
    String responderURL,
    String serialNumber
  ) {
    return new OCSPRequestData(
      null,
      hashAlgorithm,
      issuerKeyHash,
      issuerNameHash,
      responderURL,
      serialNumber
    );
  }
  public static OCSPRequestData of(
    @Nullable CustomData customData,
    HashAlgorithmEnum hashAlgorithm,
    String issuerKeyHash,
    String issuerNameHash,
    String responderURL,
    String serialNumber
  ) {
    return new OCSPRequestData(
      customData,
      hashAlgorithm,
      issuerKeyHash,
      issuerNameHash,
      responderURL,
      serialNumber
    );
  }
}
