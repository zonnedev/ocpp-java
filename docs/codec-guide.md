# Codec guide

`OcppMessageCodec` is the main serialization API. `JacksonOcppMessageCodec` is its strict Jackson-based implementation.

## Constructing a codec

Use the defaults for ordinary process-local use:

```java
OcppMessageCodec codec = JacksonOcppMessageCodec.createDefault();
```

Use the builder when configuring dependencies:

```java
OcppMessageCodec codec = JacksonOcppMessageCodec
  .builder()
  .objectMapper(applicationMapper)
  .requestRepository(requestRepository)
  .dataTransferModules(modules -> modules
    .register(Ocpp16Iso15118DataTransferModule.create())
  )
  .build();
```

The codec defensively copies a supplied `ObjectMapper`; it does not mutate the caller's mapper. The caller is responsible for ensuring that a custom mapper remains compatible with strict OCPP decoding.

## Encoding complete frames

`encode(OcppFrame)` returns JSON text. `encodeTree(OcppFrame)` returns a Jackson `JsonNode`.

```java
String json = codec.encode(message);
JsonNode tree = codec.encodeTree(message);
```

The codec constructs protocol arrays explicitly:

- request (`CALL`): `[2, messageId, action, payload]`
- response (`CALLRESULT`): `[3, messageId, payload]`
- error (`CALLERROR`): `[4, messageId, code, description, details]`

It never serializes frame records as incidental JSON objects.

## Decoding requests

```java
OcppRequestMessage<?> request = codec.decodeRequest(
  OcppVersion.OCPP_2_0_1,
  json
);
```

Request decoding validates the array length, message type, non-empty message ID, action, and object payload before deserializing the exact request type. Unknown actions and malformed frames fail strictly.

## Decoding responses

There are two response workflows.

Use a known action definition for a statically typed result:

```java
OcppResponseMessage<HeartbeatResponse> response = codec.decodeResponse(
  Ocpp16Actions.HEARTBEAT,
  json
);
```

Use repository correlation when only the frame is available:

```java
OcppResponseMessage<?> response = codec.decodeResponse(json);
```

The second form removes the source request context from the repository after finding it. See [request correlation](request-correlation.md).

## Decoding errors

```java
OcppErrorMessage error = codec.decodeError(json);
```

The codec validates the complete five-element `CALLERROR` frame, parses the error code strictly, preserves details as immutable `Map<String, JsonNode>`, and removes any correlation entry for the message ID.

## Generic frame dispatch

Use `decode` when the frame type is not known in advance:

```java
OcppFrame frame = codec.decode(
  version,
  json,
  null
);
```

Dispatch follows the message type ID:

- `2` decodes a request using the supplied version.
- `3` uses the supplied response definition, or repository correlation when it is `null`.
- `4` decodes an error.
- Any other ID fails.

If an ordinary response action is known, it can be supplied directly:

```java
OcppFrame frame = codec.decode(
  OcppVersion.OCPP_1_6_JSON,
  json,
  Ocpp16Actions.HEARTBEAT
);
```

The version parameter selects request action metadata. A response definition itself already carries its version metadata.

## Payload-only operations

Payload APIs omit all frame metadata:

```java
String payloadJson = codec.encodePayload(request);
JsonNode payloadTree = codec.encodePayloadTree(request);

HeartbeatRequest decodedRequest = codec.decodeRequestPayload(
  Ocpp16Actions.HEARTBEAT,
  payloadJson
);

HeartbeatResponse decodedResponse = codec.decodeResponsePayload(
  Ocpp16Actions.HEARTBEAT,
  responsePayloadJson
);
```

Payload-only decoding requires an action definition because no action appears inside a payload object. These methods do not save or remove request correlation state.

## Lifecycle and thread safety

The codec contains an immutable mapper configuration and registry after construction. Actual correlation concurrency guarantees depend on the supplied `OcppRequestRepository`. The default `InMemoryOcppRequestRepository` is thread-safe, process-local, and has no expiry policy.

The library does not send frames, manage WebSockets, route messages, retry operations, or impose a session model.
