package io.github.zonnedev.ocpp.v201.model.type;

import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * Immutable schema type generated from v201 reusable definition
 * SignedMeterValueType.
 */
public record SignedMeterValue(
  @Nullable CustomData customData,
  String encodingMethod,
  String publicKey,
  String signedMeterData,
  String signingMethod
) {
  public SignedMeterValue {
    Objects.requireNonNull(
      encodingMethod,
      "encodingMethod"
    );
    if (encodingMethod.length() > 50) {
      throw new IllegalArgumentException("encodingMethod length violates schema constraints");
    }
    Objects.requireNonNull(
      publicKey,
      "publicKey"
    );
    if (publicKey.length() > 2500) {
      throw new IllegalArgumentException("publicKey length violates schema constraints");
    }
    Objects.requireNonNull(
      signedMeterData,
      "signedMeterData"
    );
    if (signedMeterData.length() > 2500) {
      throw new IllegalArgumentException("signedMeterData length violates schema constraints");
    }
    Objects.requireNonNull(
      signingMethod,
      "signingMethod"
    );
    if (signingMethod.length() > 50) {
      throw new IllegalArgumentException("signingMethod length violates schema constraints");
    }
  }

  public static SignedMeterValue of(
    String encodingMethod,
    String publicKey,
    String signedMeterData,
    String signingMethod
  ) {
    return new SignedMeterValue(
      null,
      encodingMethod,
      publicKey,
      signedMeterData,
      signingMethod
    );
  }
  public static SignedMeterValue of(
    @Nullable CustomData customData,
    String encodingMethod,
    String publicKey,
    String signedMeterData,
    String signingMethod
  ) {
    return new SignedMeterValue(
      customData,
      encodingMethod,
      publicKey,
      signedMeterData,
      signingMethod
    );
  }
}
