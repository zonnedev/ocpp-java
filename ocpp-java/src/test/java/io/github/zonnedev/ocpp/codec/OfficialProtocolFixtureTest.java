package io.github.zonnedev.ocpp.codec;

import static org.assertj.core.api.Assertions.assertThat;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import io.github.zonnedev.ocpp.api.OcppActionDefinition;
import io.github.zonnedev.ocpp.v16.Ocpp16Action;
import io.github.zonnedev.ocpp.v16.Ocpp16Actions;
import io.github.zonnedev.ocpp.v201.Ocpp201Action;
import io.github.zonnedev.ocpp.v201.Ocpp201Actions;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class OfficialProtocolFixtureTest {
  private static final JsonNodeFactory JSON = JsonNodeFactory.instance;
  private static final ObjectMapper MAPPER = new ObjectMapper();
  private static final Path SCHEMA_DIRECTORY = Path.of(
    System.getProperty("ocpp.schema.directory")
  );

  private final OcppMessageCodec codec = JacksonOcppMessageCodec.createDefault();

  @ParameterizedTest(name = "{0} {1}")
  @MethodSource("ordinaryActions")
  @DisplayName("Every official request accepts and round-trips a schema-valid fixture")
  void it_round_trips_every_official_request_fixture(
    String version,
    OcppActionDefinition<?, ?> definition
  ) throws IOException {
    JsonNode fixture = fixtureFor(
      version,
      definition.requestType()
    );
    ArrayNode frame = JSON.arrayNode()
      .add(2)
      .add(
        "request-" + definition.action()
          .wireName()
      )
      .add(
        definition.action()
          .wireName()
      )
      .add(fixture);

    OcppRequestMessage<?> decodedFromTree = codec.decodeRequest(
      definition.action()
        .version(),
      frame
    );
    OcppRequestMessage<?> decodedFromString = codec.decodeRequest(
      definition.action()
        .version(),
      frame.toString()
    );

    assertThat(decodedFromTree.definition()).isEqualTo(definition);
    assertThat(decodedFromTree.payload()).isInstanceOf(definition.requestType());
    assertThat(decodedFromTree.payload()).isEqualTo(decodedFromString.payload());
    assertJsonEquals(
      frame,
      codec.encodeTree(decodedFromTree)
    );
    assertJsonEquals(
      fixture,
      codec.encodePayloadTree(decodedFromString.payload())
    );
  }

  @ParameterizedTest(name = "{0} {1}")
  @MethodSource("ordinaryActions")
  @DisplayName("Every official response accepts and round-trips a schema-valid fixture")
  void it_round_trips_every_official_response_fixture(
    String version,
    OcppActionDefinition<?, ?> definition
  ) throws IOException {
    JsonNode fixture = fixtureFor(
      version,
      definition.responseType()
    );
    ArrayNode frame = JSON.arrayNode()
      .add(3)
      .add(
        "response-" + definition.action()
          .wireName()
      )
      .add(fixture);

    OcppResponseMessage<?> decodedFromTree = decodeResponse(
      definition,
      frame
    );
    OcppResponseMessage<?> decodedFromString = decodeResponse(
      definition,
      frame.toString()
    );

    assertThat(decodedFromTree.payload()).isInstanceOf(definition.responseType());
    assertThat(decodedFromTree.payload()).isEqualTo(decodedFromString.payload());
    assertJsonEquals(
      frame,
      codec.encodeTree(decodedFromTree)
    );
    assertJsonEquals(
      frame,
      MAPPER.readTree(codec.encode(decodedFromString))
    );
    assertJsonEquals(
      fixture,
      codec.encodePayloadTree(decodedFromTree.payload())
    );
  }

  private static Stream<Arguments> ordinaryActions() {
    return Stream.concat(
      Arrays.stream(Ocpp16Action.values())
        .filter(action -> action != Ocpp16Action.DATA_TRANSFER)
        .map(
          action -> Arguments.of(
            "OCPP 1.6",
            Ocpp16Actions.definitionFor(action)
          )
        ),
      Arrays.stream(Ocpp201Action.values())
        .filter(action -> action != Ocpp201Action.DATA_TRANSFER)
        .map(
          action -> Arguments.of(
            "OCPP 2.0.1",
            Ocpp201Actions.definitionFor(action)
          )
        )
    );
  }

  private static JsonNode fixtureFor(
    String version,
    Class<?> payloadType
  ) throws IOException {
    Path schema = SCHEMA_DIRECTORY.resolve(
      version.equals("OCPP 1.6") ? "v16" : "v201"
    )
      .resolve(
        schemaFileName(
          version,
          payloadType
        )
      );
    JsonNode root = MAPPER.readTree(schema.toFile());
    return minimalValue(
      root,
      root
    );
  }

  private static String schemaFileName(
    String version,
    Class<?> payloadType
  ) {
    String name = payloadType.getSimpleName();
    if (version.equals("OCPP 1.6") && name.endsWith("Request")) {
      name = name.substring(
        0,
        name.length() - "Request".length()
      );
    }
    return name + ".json";
  }

  private static JsonNode minimalValue(
    JsonNode schema,
    JsonNode root
  ) {
    if (schema.has("$ref")) {
      return minimalValue(
        resolveReference(
          schema.get("$ref")
            .textValue(),
          root
        ),
        root
      );
    }
    if (schema.has("enum")) {
      return schema.get("enum")
        .get(0);
    }
    return switch (schema.path("type")
      .asText()) {
      case "object" -> minimalObject(
        schema,
        root
      );
      case "array" -> minimalArray(
        schema,
        root
      );
      case "integer" -> JSON.numberNode(
        schema.path("minimum")
          .asLong(0)
      );
      case "number" -> JSON.numberNode(
        schema.path("minimum")
          .asDouble(0)
      );
      case "boolean" -> JSON.booleanNode(false);
      case "string" -> minimalString(schema);
      default -> throw new IllegalArgumentException("Unsupported schema: " + schema);
    };
  }

  private static ObjectNode minimalObject(
    JsonNode schema,
    JsonNode root
  ) {
    ObjectNode value = JSON.objectNode();
    for (JsonNode required : schema.path("required")) {
      String property = required.textValue();
      value.set(
        property,
        minimalValue(
          schema.path("properties")
            .path(property),
          root
        )
      );
    }
    return value;
  }

  private static ArrayNode minimalArray(
    JsonNode schema,
    JsonNode root
  ) {
    ArrayNode value = JSON.arrayNode();
    int size = schema.path("minItems")
      .asInt(0);
    for (int index = 0; index < size; index++) {
      value.add(
        minimalValue(
          schema.path("items"),
          root
        )
      );
    }
    return value;
  }

  private static JsonNode minimalString(JsonNode schema) {
    String format = schema.path("format")
      .asText();
    if (format.equals("date-time")) {
      return JSON.textNode("2026-01-01T00:00:00Z");
    }
    if (format.equals("uri")) {
      return JSON.textNode("https://example.com");
    }
    int length = Math.max(
      1,
      schema.path("minLength")
        .asInt(1)
    );
    return JSON.textNode("x".repeat(length));
  }

  private static JsonNode resolveReference(
    String reference,
    JsonNode root
  ) {
    if (!reference.startsWith("#/")) {
      throw new IllegalArgumentException("External schema reference: " + reference);
    }
    JsonNode resolved = root.at(reference.substring(1));
    if (resolved.isMissingNode()) {
      throw new IllegalArgumentException("Unknown schema reference: " + reference);
    }
    return resolved;
  }

  private static void assertJsonEquals(
    JsonNode expected,
    JsonNode actual
  ) {
    assertThat(
      jsonEquals(
        actual,
        expected
      )
    )
      .as(
        "JSON equality%nexpected: %s%nactual:   %s",
        expected,
        actual
      )
      .isTrue();
  }

  private static boolean jsonEquals(
    JsonNode left,
    JsonNode right
  ) {
    if (left.isNumber() && right.isNumber()) {
      return left.decimalValue()
        .compareTo(right.decimalValue()) == 0;
    }
    if (left.isArray() && right.isArray()) {
      if (left.size() != right.size()) {
        return false;
      }
      for (int index = 0; index < left.size(); index++) {
        if (!jsonEquals(
          left.get(index),
          right.get(index)
        )) {
          return false;
        }
      }
      return true;
    }
    if (left.isObject() && right.isObject()) {
      if (left.size() != right.size()) {
        return false;
      }
      Iterator<Map.Entry<String, JsonNode>> fields = left.properties()
        .iterator();
      while (fields.hasNext()) {
        Map.Entry<String, JsonNode> field = fields.next();
        JsonNode rightValue = right.get(field.getKey());
        if (rightValue == null || !jsonEquals(
          field.getValue(),
          rightValue
        )) {
          return false;
        }
      }
      return true;
    }
    return left.equals(right);
  }

  @SuppressWarnings(
    {
      "rawtypes", "unchecked"
    }
  )
  private OcppResponseMessage<?> decodeResponse(
    OcppActionDefinition<?, ?> definition,
    JsonNode frame
  ) {
    return codec.decodeResponse(
      (OcppActionDefinition) definition,
      frame
    );
  }

  @SuppressWarnings(
    {
      "rawtypes", "unchecked"
    }
  )
  private OcppResponseMessage<?> decodeResponse(
    OcppActionDefinition<?, ?> definition,
    String frame
  ) {
    return codec.decodeResponse(
      (OcppActionDefinition) definition,
      frame
    );
  }
}
