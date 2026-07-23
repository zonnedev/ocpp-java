package io.github.zonnedev.ocpp.codec.internal;

import com.fasterxml.jackson.databind.JsonNode;
import com.networknt.schema.JsonSchema;
import com.networknt.schema.JsonSchemaFactory;
import com.networknt.schema.SpecVersion.VersionFlag;
import com.networknt.schema.ValidationMessage;
import io.github.zonnedev.ocpp.api.OcppVersion;
import io.github.zonnedev.ocpp.codec.OcppDecodingException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

/** Validates ordinary OCPP payloads against the checked-in official schemas. */
public final class OfficialSchemaValidator {
  private static final JsonSchemaFactory V16_FACTORY = JsonSchemaFactory.getInstance(
    VersionFlag.V4
  );
  private static final JsonSchemaFactory V201_FACTORY = JsonSchemaFactory.getInstance(
    VersionFlag.V6
  );

  private final Map<SchemaKey, JsonSchema> schemas = new ConcurrentHashMap<>();

  public void validate(
    OcppVersion version,
    Class<?> payloadType,
    JsonNode payload
  ) {
    Objects.requireNonNull(
      version,
      "version"
    );
    Objects.requireNonNull(
      payloadType,
      "payloadType"
    );
    Objects.requireNonNull(
      payload,
      "payload"
    );
    var messages = schemas.computeIfAbsent(
      new SchemaKey(
        version,
        payloadType
      ),
      this::load
    )
      .validate(payload);
    if (!messages.isEmpty()) {
      ValidationMessage first = messages.iterator()
        .next();
      throw new OcppDecodingException(
        "Payload does not conform to " + payloadType.getName() + ": " + first,
        null
      );
    }
  }

  private JsonSchema load(SchemaKey key) {
    String resource = resourceName(
      key.version(),
      key.payloadType()
    );
    try (InputStream input = OfficialSchemaValidator.class.getResourceAsStream(resource)) {
      if (input == null) {
        throw new IllegalStateException("Missing bundled OCPP schema " + resource);
      }
      return factory(key.version()).getSchema(input);
    } catch (IOException exception) {
      throw new IllegalStateException("Could not load bundled OCPP schema " + resource, exception);
    }
  }

  private static JsonSchemaFactory factory(OcppVersion version) {
    return switch (version) {
      case OCPP_1_6_JSON -> V16_FACTORY;
      case OCPP_2_0_1 -> V201_FACTORY;
    };
  }

  private static String resourceName(
    OcppVersion version,
    Class<?> payloadType
  ) {
    String name = payloadType.getSimpleName();
    if (version == OcppVersion.OCPP_1_6_JSON && name.endsWith("Request")) {
      name = name.substring(
        0,
        name.length() - "Request".length()
      );
    }
    String directory = version == OcppVersion.OCPP_1_6_JSON ? "v16" : "v201";
    return "/"
      + directory
      + "/"
      + name
      + ".json";
  }

  private record SchemaKey(
    OcppVersion version, Class<?> payloadType
  ) {
  }
}
