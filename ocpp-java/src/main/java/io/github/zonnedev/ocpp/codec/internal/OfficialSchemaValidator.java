package io.github.zonnedev.ocpp.codec.internal;

import com.fasterxml.jackson.databind.JsonNode;
import com.networknt.schema.SchemaRegistry;
import com.networknt.schema.SpecificationVersion;
import com.networknt.schema.Schema;
import io.github.zonnedev.ocpp.api.OcppVersion;
import io.github.zonnedev.ocpp.codec.OcppDecodingException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

/** Validates ordinary OCPP payloads against the checked-in official schemas. */
public final class OfficialSchemaValidator {
  private static final SchemaRegistry V16_REGISTRY = SchemaRegistry.withDefaultDialect(
    SpecificationVersion.DRAFT_4
  );
  private static final SchemaRegistry V201_REGISTRY = SchemaRegistry.withDefaultDialect(
    SpecificationVersion.DRAFT_2020_12
  );

  private final Map<SchemaKey, Schema> schemas = new ConcurrentHashMap<>();

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
    var errors = schemas.computeIfAbsent(
      new SchemaKey(
        version,
        payloadType
      ),
      this::load
    )
      .validate(payload);
    if (!errors.isEmpty()) {
      var first = errors.get(0);
      throw new OcppDecodingException(
        "Payload does not conform to " + payloadType.getName() + ": " + first.getMessage(),
        null
      );
    }
  }

  private Schema load(SchemaKey key) {
    String resource = resourceName(
      key.version(),
      key.payloadType()
    );
    InputStream input = OfficialSchemaValidator.class.getResourceAsStream(resource);
    if (input == null) {
      throw new IllegalStateException("Missing bundled OCPP schema " + resource);
    }
    return registry(key.version()).getSchema(input);
  }

  private static SchemaRegistry registry(OcppVersion version) {
    return version == OcppVersion.OCPP_1_6_JSON ? V16_REGISTRY : V201_REGISTRY;
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
