# Request correlation

## Why correlation is required

An OCPP `CALL` contains an action:

```json
[2,"message-1","Heartbeat",{}]
```

Its `CALLRESULT` contains only the original message ID and payload:

```json
[3,"message-1",{"currentTime":"2026-07-23T12:00:00Z"}]
```

The response payload class therefore cannot be selected from the response frame alone. `OcppRequestRepository` lets the application decide where the required source-request context is stored.

## Repository contract

```java
public interface OcppRequestRepository {
  void save(
    String messageId,
    OcppRequestContext context
  );

  Optional<OcppRequestContext> find(String messageId);

  Optional<OcppRequestContext> remove(String messageId);
}
```

`OcppRequestContext` contains the action definition and, for DataTransfer, the resolved vendor operation.

## Codec behavior

| Event | Repository operation |
|---|---|
| Encode a request frame | `save(messageId, context)` |
| Decode a correlated response | `remove(messageId)` |
| Decode an error | `remove(messageId)` |
| Decode with an explicit action definition | no repository lookup |
| Encode or decode only a payload | no repository operation |

A correlated response fails with `OcppDecodingException` if no source request is stored.

## Default implementation

```java
OcppMessageCodec codec = JacksonOcppMessageCodec.createDefault();
```

This uses `InMemoryOcppRequestRepository`, backed by a concurrent map. It rejects duplicate outstanding message IDs and removes entries when terminal response or error frames are decoded.

The implementation is suitable when encoding requests and decoding their replies occur in the same process and codec lifecycle. It does not provide expiration, persistence, cross-node visibility, or recovery after restart.

## Application-provided storage

```java
OcppMessageCodec codec = JacksonOcppMessageCodec
  .builder()
  .requestRepository(repository)
  .build();
```

A production implementation may use a database or distributed cache. It should:

- treat the OCPP message ID as the key;
- preserve the complete `OcppRequestContext` without weakening its type metadata;
- reject or deliberately handle duplicate outstanding IDs;
- make `remove` atomic when multiple consumers can process a reply;
- apply an application-appropriate expiry policy;
- be safe for the application's concurrency and deployment model.

Serialization of `Class` and action-definition objects is generally unsuitable for a language-neutral external store. A durable implementation can store stable version, action, vendor, and DataTransfer message identifiers and reconstruct the corresponding definitions on retrieval.

## Explicit response definitions

When the caller already knows the source action, bypass correlation and retain the exact response type:

```java
OcppResponseMessage<HeartbeatResponse> response = codec.decodeResponse(
  Ocpp16Actions.HEARTBEAT,
  json
);
```

This is appropriate when correlation is managed by a surrounding application. It cannot be used to decode a typed DataTransfer response because `DataTransfer` alone does not identify the vendor operation. DataTransfer response decoding requires the stored request context.
