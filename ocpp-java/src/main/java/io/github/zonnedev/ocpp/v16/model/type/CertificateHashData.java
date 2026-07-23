package io.github.zonnedev.ocpp.v16.model.type;

import java.util.Objects;

/**
 * Immutable schema type generated from v16 reusable definition
 * CertificateHashDataType.
 */
public record CertificateHashData(
  HashAlgorithmEnum hashAlgorithm,
  String issuerKeyHash,
  String issuerNameHash,
  String serialNumber
) {
  public CertificateHashData {
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
      serialNumber,
      "serialNumber"
    );
    if (serialNumber.length() > 40) {
      throw new IllegalArgumentException("serialNumber length violates schema constraints");
    }
  }

  public static CertificateHashData of(
    HashAlgorithmEnum hashAlgorithm,
    String issuerKeyHash,
    String issuerNameHash,
    String serialNumber
  ) {
    return new CertificateHashData(
      hashAlgorithm,
      issuerKeyHash,
      issuerNameHash,
      serialNumber
    );
  }
}
