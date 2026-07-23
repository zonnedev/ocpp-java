# Getting started

## Requirements

- Java 25 or newer
- The `io.github.zonnedev:ocpp-java` artifact and its runtime dependencies

The project currently has version `0.1.0-SNAPSHOT`. If consuming it from the repository, publish it to a local Maven repository or add the Gradle project as a dependency in a composite or multi-project build.

For a published release, add the library to a Gradle build with:

```kotlin
dependencies {
  implementation("io.github.zonnedev:ocpp-java:0.1.0")
}
```

## Create the codec

Program against `OcppMessageCodec` and use the Jackson implementation as the default entry point:

```java
import io.github.zonnedev.ocpp.codec.JacksonOcppMessageCodec;
import io.github.zonnedev.ocpp.codec.OcppMessageCodec;

OcppMessageCodec codec = JacksonOcppMessageCodec
  .builder()
  .build();
```

This configuration uses the library's strict `ObjectMapper` and a thread-safe, process-local request repository.

## Encode a `CALL`

The action definition provides the compile-time association between the request and response types:

```java
import io.github.zonnedev.ocpp.codec.OcppRequestMessage;
import io.github.zonnedev.ocpp.v16.Ocpp16Actions;
import io.github.zonnedev.ocpp.v16.model.HeartbeatRequest;

HeartbeatRequest request = HeartbeatRequest.of();

OcppRequestMessage<HeartbeatRequest> message = OcppRequestMessage.of(
  "message-1",
  Ocpp16Actions.HEARTBEAT,
  request
);

String json = codec.encode(message);
```

The result is a complete OCPP `CALL` frame:

```json
[2,"message-1","Heartbeat",{}]
```

Encoding a request also stores its action context in the configured `OcppRequestRepository`. That context is needed because a `CALLRESULT` does not contain an action name.

## Decode a `CALL`

Supply the protocol version because the same action name can have different payload classes in OCPP 1.6 and OCPP 2.0.1:

```java
import io.github.zonnedev.ocpp.api.OcppVersion;
import io.github.zonnedev.ocpp.codec.OcppRequestMessage;

OcppRequestMessage<?> decoded = codec.decodeRequest(
  OcppVersion.OCPP_1_6_JSON,
  json
);
```

The decoded payload is the exact schema record selected by the action metadata:

```java
if (decoded.payload() instanceof HeartbeatRequest heartbeat) {
  // Handle the request and retain decoded.messageId() for the response.
}
```

## Encode a `CALLRESULT`

```java
import io.github.zonnedev.ocpp.codec.OcppResponseMessage;
import io.github.zonnedev.ocpp.v16.model.HeartbeatResponse;
import java.time.Instant;

HeartbeatResponse response = HeartbeatResponse.of(Instant.now());

OcppResponseMessage<HeartbeatResponse> responseMessage = OcppResponseMessage.of(
  "message-1",
  Ocpp16Actions.HEARTBEAT,
  response
);

String responseJson = codec.encode(responseMessage);
```

The action is Java-side metadata and is not written to the response frame:

```json
[3,"message-1",{"currentTime":"2026-07-23T12:00:00Z"}]
```

## Decode a `CALLRESULT`

When this codec encoded the source request, decode through the stored correlation context:

```java
OcppResponseMessage<?> decodedResponse = codec.decodeResponse(responseJson);
```

When the action is already known, use the typed overload:

```java
OcppResponseMessage<HeartbeatResponse> decodedResponse = codec.decodeResponse(
  Ocpp16Actions.HEARTBEAT,
  responseJson
);
```

The typed overload does not need repository lookup. DataTransfer responses are the exception: their exact vendor operation is only recoverable from the stored source-request context.

## Next steps

- Read the [codec guide](codec-guide.md) for generic dispatch and payload-only operations.
- Read [request correlation](request-correlation.md) before using the codec across processes or instances.
- Read [DataTransfer modules](data-transfer-modules.md) before enabling vendor extensions.
