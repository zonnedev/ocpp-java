package io.github.zonnedev.ocpp.codec;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import io.github.zonnedev.ocpp.api.OcppActionDefinition;
import io.github.zonnedev.ocpp.api.OcppPayload;
import io.github.zonnedev.ocpp.api.OcppRequest;
import io.github.zonnedev.ocpp.api.OcppResponse;
import io.github.zonnedev.ocpp.api.OcppVersion;
import io.github.zonnedev.ocpp.api.datatransfer.DataTransferModuleRegistrar;
import io.github.zonnedev.ocpp.api.datatransfer.DataTransferOperationDefinition;
import io.github.zonnedev.ocpp.api.datatransfer.DataTransferPayload;
import io.github.zonnedev.ocpp.api.datatransfer.DataTransferRequestPayload;
import io.github.zonnedev.ocpp.api.datatransfer.DataTransferResponsePayload;
import io.github.zonnedev.ocpp.codec.internal.DataTransferRegistry;
import io.github.zonnedev.ocpp.jackson.OcppObjectMapperFactory;
import io.github.zonnedev.ocpp.v16.Ocpp16Action;
import io.github.zonnedev.ocpp.v16.Ocpp16Actions;
import io.github.zonnedev.ocpp.v201.model.type.CustomData;
import io.github.zonnedev.ocpp.v201.model.type.StatusInfo;
import io.github.zonnedev.ocpp.v201.Ocpp201Action;
import io.github.zonnedev.ocpp.v201.Ocpp201Actions;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Consumer;
import org.jspecify.annotations.Nullable;

/** Strict Jackson codec for complete OCPP-J frames and payloads. */
public final class JacksonOcppMessageCodec implements OcppMessageCodec {
  private final ObjectMapper mapper;
  private final OcppRequestRepository repository;
  private final DataTransferRegistry dataTransfers;

  /** The supplied mapper is defensively copied and is never mutated. */
  public JacksonOcppMessageCodec(
    ObjectMapper mapper,
    OcppRequestRepository repository
  ) {
    this(
      mapper,
      repository,
      new DataTransferRegistry()
        .freeze()
    );
  }

  private JacksonOcppMessageCodec(
    ObjectMapper mapper,
    OcppRequestRepository repository,
    DataTransferRegistry dataTransfers
  ) {
    this.mapper = Objects.requireNonNull(
      mapper,
      "mapper"
    )
      .copy();
    this.repository = Objects.requireNonNull(
      repository,
      "repository"
    );
    this.dataTransfers = Objects.requireNonNull(
      dataTransfers,
      "dataTransfers"
    );
  }

  public static JacksonOcppMessageCodec createDefault() {
    return builder().build();
  }

  public static JacksonOcppMessageCodec of(
    ObjectMapper mapper,
    OcppRequestRepository repository
  ) {
    return new JacksonOcppMessageCodec(
      mapper,
      repository
    );
  }

  public static Builder builder() {
    return new Builder();
  }

  @Override
  public String encode(OcppFrame message) {
    try {
      return mapper.writeValueAsString(encodeTree(message));
    } catch (JsonProcessingException e) {
      throw new OcppEncodingException(
        "Could not encode OCPP frame",
        e
      );
    }
  }

  @Override
  public JsonNode encodeTree(OcppFrame message) {
    Objects.requireNonNull(
      message,
      "message"
    );
    try {
      ArrayNode frame = mapper.createArrayNode();
      switch (message) {
        case OcppRequestMessage<?> request -> {
          frame.add(2)
            .add(request.messageId())
            .add(
              request.definition()
                .action()
                .wireName()
            );
          EncodedRequest encoded = encodeRequestPayload(request.payload());
          frame.add(encoded.payload());
          repository.save(
            request.messageId(),
            encoded.operation() == null
              ? OcppRequestContext.of(request.definition())
              : OcppRequestContext.of(
                request.definition(),
                encoded.operation()
              )
          );
        }
        case OcppResponseMessage<?> response -> {
          frame.add(3)
            .add(response.messageId());
          frame.add(encodeResponsePayload(response.payload()));
        }
        case OcppErrorMessage error -> {
          frame.add(4)
            .add(error.messageId())
            .add(
              error.error()
                .code()
                .wireValue()
            )
            .add(
              error.error()
                .description()
            )
            .add(
              mapper.valueToTree(
                error.error()
                  .details()
              )
            );
        }
      }
      return frame;
    } catch (RuntimeException e) {
      if (e instanceof OcppCodecException) {
        throw e;
      }
      throw new OcppEncodingException(
        "Could not encode OCPP frame type " + message.getClass()
          .getSimpleName(),
        e
      );
    }
  }

  @Override
  public String encodePayload(OcppPayload payload) {
    try {
      return mapper.writeValueAsString(encodePayloadTree(payload));
    } catch (JsonProcessingException e) {
      throw new OcppEncodingException(
        "Could not encode OCPP payload",
        e
      );
    }
  }
  @Override
  public JsonNode encodePayloadTree(OcppPayload payload) {
    try {
      Objects.requireNonNull(
        payload,
        "payload"
      );
      return switch (payload) {
        case OcppRequest request -> encodeRequestPayload(request)
          .payload();
        case OcppResponse response -> encodeResponsePayload(response);
      };
    } catch (IllegalArgumentException e) {
      throw new OcppEncodingException(
        "Could not encode payload",
        e
      );
    }
  }

  private EncodedRequest encodeRequestPayload(OcppRequest request) {
    return switch (request) {
      case io.github.zonnedev.ocpp.v16.model.DataTransferRequest<?> transfer ->
        encodeDataTransferRequest(
          transfer,
          OcppVersion.OCPP_1_6_JSON
        );
      case io.github.zonnedev.ocpp.v201.model.DataTransferRequest<?> transfer ->
        encodeDataTransferRequest(
          transfer,
          OcppVersion.OCPP_2_0_1
        );
      default -> new EncodedRequest(
        mapper.valueToTree(request),
        null
      );
    };
  }

  private EncodedRequest encodeDataTransferRequest(
    OcppRequest request,
    OcppVersion version
  ) {
    ObjectNode envelope = mapper.valueToTree(request);
    String vendorId = encodingTextProperty(
      envelope,
      "vendorId"
    );
    String messageId = encodingTextProperty(
      envelope,
      "messageId"
    );
    DataTransferOperationDefinition<?, ?> operation = dataTransfers.find(
      version,
      vendorId,
      messageId
    )
      .orElseThrow(
        () -> new OcppEncodingException(
          "DataTransfer operation is not registered: " + version + "/" + vendorId + "/" + messageId,
          null
        )
      );
    DataTransferRequestPayload data = switch (request) {
      case io.github.zonnedev.ocpp.v16.model.DataTransferRequest<?> transfer -> transfer.data();
      case io.github.zonnedev.ocpp.v201.model.DataTransferRequest<?> transfer -> transfer.data();
      default -> throw new OcppEncodingException("Payload is not a DataTransfer request", null);
    };
    if (data == null || !operation.requestType()
      .isInstance(data)) {
      throw new OcppEncodingException(
        "DataTransfer request data must match " + operation.requestType()
          .getName(),
        null
      );
    }
    envelope.set(
      "data",
      encodeDataTransferValue(
        version,
        data,
        operation.vendorId(),
        operation.messageId()
      )
    );
    return new EncodedRequest(
      envelope,
      operation
    );
  }

  private ObjectNode encodeResponsePayload(OcppResponse response) {
    return switch (response) {
      case io.github.zonnedev.ocpp.v16.model.DataTransferResponse<?> transfer ->
        encodeDataTransferResponse(
          transfer,
          OcppVersion.OCPP_1_6_JSON
        );
      case io.github.zonnedev.ocpp.v201.model.DataTransferResponse<?> transfer ->
        encodeDataTransferResponse(
          transfer,
          OcppVersion.OCPP_2_0_1
        );
      default -> mapper.valueToTree(response);
    };
  }

  private ObjectNode encodeDataTransferResponse(
    OcppResponse response,
    OcppVersion version
  ) {
    ObjectNode envelope = mapper.valueToTree(response);
    DataTransferResponsePayload data = switch (response) {
      case io.github.zonnedev.ocpp.v16.model.DataTransferResponse<?> transfer -> transfer.data();
      case io.github.zonnedev.ocpp.v201.model.DataTransferResponse<?> transfer -> transfer.data();
      default -> throw new OcppEncodingException("Payload is not a DataTransfer response", null);
    };
    if (data == null) {
      return envelope;
    }
    DataTransferOperationDefinition<?, ?> operation;
    try {
      operation = dataTransfers.findByResponse(
        version,
        data
      );
    } catch (IllegalArgumentException e) {
      throw new OcppEncodingException(
        e.getMessage(),
        e
      );
    }
    envelope.set(
      "data",
      encodeDataTransferValue(
        version,
        data,
        operation.vendorId(),
        operation.messageId()
      )
    );
    return envelope;
  }

  private JsonNode encodeDataTransferValue(
    OcppVersion version,
    DataTransferPayload value,
    String vendorId,
    String messageId
  ) {
    try {
      JsonNode tree = mapper.valueToTree(value);
      return switch (version) {
        case OCPP_1_6_JSON -> mapper.getNodeFactory()
          .textNode(mapper.writeValueAsString(tree));
        case OCPP_2_0_1 -> tree;
      };
    } catch (IOException | IllegalArgumentException e) {
      throw new OcppEncodingException(
        "Could not encode DataTransfer " + vendorId + "/" + messageId,
        e
      );
    }
  }

  private static String encodingTextProperty(
    ObjectNode object,
    String name
  ) {
    JsonNode value = object.get(name);
    if (value == null || !value.isTextual() || value.textValue()
      .isEmpty()) {
      throw new OcppEncodingException(
        "DataTransfer " + name + " must be a non-empty string",
        null
      );
    }
    return value.textValue();
  }

  private record EncodedRequest(
    ObjectNode payload,
    @Nullable DataTransferOperationDefinition<?, ?> operation
  ) {
  }

  private JsonNode parse(String json) {
    try {
      return mapper.readTree(
        Objects.requireNonNull(
          json,
          "json"
        )
      );
    } catch (JsonProcessingException e) {
      throw new OcppDecodingException(
        "Malformed JSON",
        e
      );
    }
  }
  @Override
  public OcppRequestMessage<?> decodeRequest(
    OcppVersion version,
    String json
  ) {
    return decodeRequest(
      version,
      parse(json)
    );
  }
  @Override
  public OcppRequestMessage<?> decodeRequest(
    OcppVersion version,
    JsonNode json
  ) {
    try {
      ArrayNode frame = requireFrame(
        json,
        4,
        2
      );
      String id = requireText(
        frame,
        1,
        "message ID",
        true
      );
      String actionName = requireText(
        frame,
        2,
        "action",
        true
      );
      ObjectNode payload = requireObject(
        frame,
        3,
        "request payload"
      );
      if ("DataTransfer".equals(actionName)) {
        return decodeDataTransferRequest(
          version,
          id,
          payload
        );
      }
      OcppActionDefinition<?, ?> definition = switch (version) {
        case OCPP_1_6_JSON -> Ocpp16Actions.definitionFor(Ocpp16Action.fromWireName(actionName));
        case OCPP_2_0_1 -> Ocpp201Actions.definitionFor(Ocpp201Action.fromWireName(actionName));
      };
      return decodeCapturedRequest(
        id,
        definition,
        payload
      );
    } catch (RuntimeException e) {
      throw decoding(
        "Could not decode OCPP request",
        e
      );
    }
  }

  private <Q extends OcppRequest, S extends OcppResponse> OcppRequestMessage<Q> decodeCapturedRequest(
    String id,
    OcppActionDefinition<Q, S> definition,
    JsonNode payload
  ) {
    return OcppRequestMessage.of(
      id,
      definition,
      tree(
        payload,
        definition.requestType()
      )
    );
  }

  private OcppRequestMessage<?> decodeDataTransferRequest(
    OcppVersion version,
    String id,
    ObjectNode envelope
  ) {
    String vendorId = requireTextProperty(
      envelope,
      "vendorId"
    );
    JsonNode messageIdNode = envelope.get("messageId");
    if (messageIdNode == null || messageIdNode.isNull() || !messageIdNode.isTextual()
      || messageIdNode.textValue()
        .isEmpty()) {
      throw new UnknownDataTransferOperationException(
        version,
        vendorId,
        null,
        UnknownDataTransferOperationException.Reason.MISSING_MESSAGE_ID
      );
    }
    String messageId = messageIdNode.textValue();
    var operation = dataTransfers.find(
      version,
      vendorId,
      messageId
    );
    if (operation.isEmpty()) {
      throw new UnknownDataTransferOperationException(
        version,
        vendorId,
        messageId,
        dataTransfers.containsVendor(
          version,
          vendorId
        )
          ? UnknownDataTransferOperationException.Reason.UNKNOWN_MESSAGE_ID
          : UnknownDataTransferOperationException.Reason.UNKNOWN_VENDOR_ID
      );
    }
    return decodeCapturedDataTransferRequest(
      id,
      vendorId,
      messageId,
      envelope,
      operation.orElseThrow()
    );
  }

  private <D extends DataTransferRequestPayload> OcppRequestMessage<?> decodeCapturedDataTransferRequest(
    String id,
    String vendorId,
    String messageId,
    ObjectNode envelope,
    DataTransferOperationDefinition<D, ?> operation
  ) {
    JsonNode data = requireDataTransferData(
      envelope,
      operation.version()
    );
    D value = dataTransferTree(
      data,
      operation.requestType()
    );
    return switch (operation.version()) {
      case OCPP_1_6_JSON -> OcppRequestMessage.of(
        id,
        Ocpp16Actions.dataTransfer(operation),
        new io.github.zonnedev.ocpp.v16.model.DataTransferRequest<>(
          value,
          messageId,
          vendorId
        )
      );
      case OCPP_2_0_1 -> OcppRequestMessage.of(
        id,
        Ocpp201Actions.dataTransfer(operation),
        new io.github.zonnedev.ocpp.v201.model.DataTransferRequest<>(
          nullableTree(
            envelope.get("customData"),
            CustomData.class
          ),
          value,
          messageId,
          vendorId
        )
      );
    };
  }

  @Override
  public <Q extends OcppRequest, S extends OcppResponse> OcppResponseMessage<S> decodeResponse(
    OcppActionDefinition<Q, S> definition,
    String json
  ) {
    return decodeResponse(
      definition,
      parse(json)
    );
  }
  @Override
  public <Q extends OcppRequest, S extends OcppResponse> OcppResponseMessage<S> decodeResponse(
    OcppActionDefinition<Q, S> definition,
    JsonNode json
  ) {
    try {
      if ("DataTransfer".equals(
        definition.action()
          .wireName()
      )) {
        throw new OcppDecodingException(
          "A stored source request is required to decode a DataTransfer response",
          null
        );
      }
      ArrayNode frame = requireFrame(
        json,
        3,
        3
      );
      String id = requireText(
        frame,
        1,
        "message ID",
        true
      );
      ObjectNode payload = requireObject(
        frame,
        2,
        "response payload"
      );
      return OcppResponseMessage.of(
        id,
        definition,
        tree(
          payload,
          definition.responseType()
        )
      );
    } catch (RuntimeException e) {
      throw decoding(
        "Could not decode response for " + definition.action()
          .wireName(),
        e
      );
    }
  }
  @Override
  public OcppResponseMessage<?> decodeResponse(String json) {
    return decodeResponse(parse(json));
  }
  @Override
  public OcppResponseMessage<?> decodeResponse(JsonNode json) {
    ArrayNode frame = requireFrame(
      json,
      3,
      3
    );
    String id = requireText(
      frame,
      1,
      "message ID",
      true
    );
    OcppRequestContext context = repository.remove(id)
      .orElseThrow(
        () -> new OcppDecodingException(
          "No source request is stored for OCPP response "
            + id,
          null
        )
      );
    if (context.dataTransferOperation() != null) {
      return decodeCapturedDataTransferResponse(
        id,
        requireObject(
          frame,
          2,
          "response payload"
        ),
        context.dataTransferOperation()
      );
    }
    return decodeCapturedResponse(
      context.action(),
      frame
    );
  }
  private <Q extends OcppRequest, S extends OcppResponse> OcppResponseMessage<S> decodeCapturedResponse(
    OcppActionDefinition<Q, S> definition,
    JsonNode frame
  ) {
    return decodeResponse(
      definition,
      frame
    );
  }

  private <Q extends DataTransferRequestPayload, D extends DataTransferResponsePayload> OcppResponseMessage<?> decodeCapturedDataTransferResponse(
    String id,
    ObjectNode envelope,
    DataTransferOperationDefinition<Q, D> operation
  ) {
    JsonNode data = requireDataTransferData(
      envelope,
      operation.version()
    );
    D value = dataTransferTree(
      data,
      operation.responseType()
    );
    return switch (operation.version()) {
      case OCPP_1_6_JSON -> OcppResponseMessage.of(
        id,
        Ocpp16Actions.dataTransfer(operation),
        new io.github.zonnedev.ocpp.v16.model.DataTransferResponse<>(
          value,
          io.github.zonnedev.ocpp.v16.model.DataTransferResponse.Status.fromWireValue(
            requireTextProperty(
              envelope,
              "status"
            )
          )
        )
      );
      case OCPP_2_0_1 -> OcppResponseMessage.of(
        id,
        Ocpp201Actions.dataTransfer(operation),
        new io.github.zonnedev.ocpp.v201.model.DataTransferResponse<>(
          nullableTree(
            envelope.get("customData"),
            CustomData.class
          ),
          value,
          io.github.zonnedev.ocpp.v201.model.DataTransferResponse.DataTransferStatusEnum
            .fromWireValue(
              requireTextProperty(
                envelope,
                "status"
              )
            ),
          nullableTree(
            envelope.get("statusInfo"),
            StatusInfo.class
          )
        )
      );
    };
  }

  @Override
  public OcppErrorMessage decodeError(String json) {
    return decodeError(parse(json));
  }
  @Override
  public OcppErrorMessage decodeError(JsonNode json) {
    try {
      ArrayNode frame = requireFrame(
        json,
        5,
        4
      );
      String id = requireText(
        frame,
        1,
        "message ID",
        true
      );
      OcppErrorCode code = OcppErrorCode.fromWireValue(
        requireText(
          frame,
          2,
          "error code",
          true
        )
      );
      String description = requireText(
        frame,
        3,
        "error description",
        false
      );
      ObjectNode details = requireObject(
        frame,
        4,
        "error details"
      );
      Map<String, JsonNode> values = new LinkedHashMap<>();
      details.properties()
        .forEach(
          entry -> values.put(
            entry.getKey(),
            entry.getValue()
              .deepCopy()
          )
        );
      repository.remove(id);
      return OcppErrorMessage.of(
        id,
        OcppError.of(
          code,
          description,
          values
        )
      );
    } catch (RuntimeException e) {
      throw decoding(
        "Could not decode OCPP error",
        e
      );
    }
  }

  @Override
  public OcppFrame decode(
    OcppVersion version,
    String json,
    @Nullable OcppActionDefinition<?, ?> definition
  ) {
    return decode(
      version,
      parse(json),
      definition
    );
  }
  @Override
  public OcppFrame decode(
    OcppVersion version,
    JsonNode json,
    @Nullable OcppActionDefinition<?, ?> definition
  ) {
    ArrayNode frame = requireArray(json);
    int type = requireType(frame);
    return switch (type) {
      case 2 -> decodeRequest(
        version,
        frame
      );
      case 3 -> definition == null
        ? decodeResponse(frame)
        : decodeCapturedResponse(
          definition,
          frame
        );
      case 4 -> decodeError(frame);
      default -> throw new OcppDecodingException(
        "Unsupported OCPP message type ID: " + type,
        null
      );
    };
  }

  @Override
  public <Q extends OcppRequest, S extends OcppResponse> Q decodeRequestPayload(
    OcppActionDefinition<Q, S> definition,
    String json
  ) {
    return decodeRequestPayload(
      definition,
      parse(json)
    );
  }
  @Override
  public <Q extends OcppRequest, S extends OcppResponse> Q decodeRequestPayload(
    OcppActionDefinition<Q, S> definition,
    JsonNode json
  ) {
    return tree(
      requirePayloadObject(json),
      definition.requestType()
    );
  }
  @Override
  public <Q extends OcppRequest, S extends OcppResponse> S decodeResponsePayload(
    OcppActionDefinition<Q, S> definition,
    String json
  ) {
    return decodeResponsePayload(
      definition,
      parse(json)
    );
  }
  @Override
  public <Q extends OcppRequest, S extends OcppResponse> S decodeResponsePayload(
    OcppActionDefinition<Q, S> definition,
    JsonNode json
  ) {
    return tree(
      requirePayloadObject(json),
      definition.responseType()
    );
  }

  private <T> T tree(
    JsonNode node,
    Class<T> type
  ) {
    try {
      return mapper.treeToValue(
        node,
        type
      );
    } catch (JsonProcessingException | IllegalArgumentException e) {
      throw new OcppDecodingException(
        "Payload does not conform to " + type.getName(),
        e
      );
    }
  }

  private <T> T dataTransferTree(
    JsonNode node,
    Class<T> type
  ) {
    try {
      return mapper.treeToValue(
        node,
        type
      );
    } catch (JsonProcessingException | IllegalArgumentException e) {
      throw new OcppDecodingException(
        "DataTransfer data does not conform to " + type.getName(),
        e
      );
    }
  }

  private <T> @Nullable T nullableTree(
    @Nullable JsonNode node,
    Class<T> type
  ) {
    if (node == null || node.isNull()) {
      return null;
    }
    return tree(
      node,
      type
    );
  }

  private JsonNode requireDataTransferData(
    ObjectNode envelope,
    OcppVersion version
  ) {
    JsonNode data = envelope.get("data");
    if (data == null || data.isNull()) {
      throw new OcppDecodingException(
        "Registered DataTransfer operation requires a data payload",
        null
      );
    }
    if (version == OcppVersion.OCPP_2_0_1) {
      return data;
    }
    if (!data.isTextual()) {
      throw new OcppDecodingException(
        "OCPP 1.6 DataTransfer data must be a JSON string",
        null
      );
    }
    return parse(data.textValue());
  }

  private static String requireTextProperty(
    ObjectNode object,
    String name
  ) {
    JsonNode value = object.get(name);
    if (value == null || !value.isTextual() || value.textValue()
      .isEmpty()) {
      throw new OcppDecodingException(
        "DataTransfer " + name + " must be a non-empty string",
        null
      );
    }
    return value.textValue();
  }
  private static ObjectNode requirePayloadObject(JsonNode node) {
    if (node instanceof ObjectNode object) {
      return object;
    }
    throw new OcppDecodingException(
      "Payload must be a JSON object",
      null
    );
  }
  private static ArrayNode requireArray(JsonNode node) {
    if (node instanceof ArrayNode array) {
      return array;
    }
    throw new OcppDecodingException(
      "OCPP frame root must be a JSON array",
      null
    );
  }
  private static ArrayNode requireFrame(
    JsonNode node,
    int size,
    int type
  ) {
    ArrayNode frame = requireArray(node);
    if (frame.size() != size) {
      throw new OcppDecodingException(
        "OCPP type " + type + " frame must contain " + size + " elements",
        null
      );
    }
    if (requireType(frame) != type) {
      throw new OcppDecodingException(
        "Expected OCPP message type ID " + type,
        null
      );
    }
    return frame;
  }
  private static int requireType(ArrayNode frame) {
    if (frame.isEmpty() || !frame.get(0)
      .isIntegralNumber()) {
      throw new OcppDecodingException(
        "Frame index 0 must be an integer message type ID",
        null
      );
    }
    return frame.get(0)
      .intValue();
  }
  private static String requireText(
    ArrayNode frame,
    int index,
    String label,
    boolean nonEmpty
  ) {
    if (index >= frame.size() || !frame.get(index)
      .isTextual()) {
      throw new OcppDecodingException(
        "Frame index " + index + " must be textual " + label,
        null
      );
    }
    String value = frame.get(index)
      .textValue();
    if (nonEmpty && value.isEmpty()) {
      throw new OcppDecodingException(
        label + " must not be empty",
        null
      );
    }
    return value;
  }
  private static ObjectNode requireObject(
    ArrayNode frame,
    int index,
    String label
  ) {
    if (index >= frame.size() || !(frame.get(index) instanceof ObjectNode object)) {
      throw new OcppDecodingException(
        "Frame index " + index + " must be an object " + label,
        null
      );
    }
    return object;
  }
  private static OcppDecodingException decoding(
    String message,
    RuntimeException cause
  ) {
    return cause instanceof OcppDecodingException existing
      ? existing
      : new OcppDecodingException(
        message,
        cause
      );
  }

  /**
   * Builder for codec dependencies and explicitly registered DataTransfer
   * modules.
   */
  public static final class Builder {
    private ObjectMapper mapper = OcppObjectMapperFactory.create();
    private OcppRequestRepository repository = InMemoryOcppRequestRepository.create();
    private final DataTransferRegistry dataTransfers = new DataTransferRegistry();

    private Builder() {
    }

    public Builder objectMapper(ObjectMapper objectMapper) {
      mapper = Objects.requireNonNull(
        objectMapper,
        "objectMapper"
      );
      return this;
    }

    public Builder requestRepository(OcppRequestRepository requestRepository) {
      repository = Objects.requireNonNull(
        requestRepository,
        "requestRepository"
      );
      return this;
    }

    public Builder dataTransferModules(
      Consumer<DataTransferModuleRegistrar> configuration
    ) {
      Objects.requireNonNull(
        configuration,
        "configuration"
      )
        .accept(dataTransfers);
      return this;
    }

    public JacksonOcppMessageCodec build() {
      return new JacksonOcppMessageCodec(
        mapper,
        repository,
        dataTransfers.freeze()
      );
    }
  }
}
