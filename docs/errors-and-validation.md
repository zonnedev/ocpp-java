# Errors and validation

## Codec exception hierarchy

Codec failures are unchecked and library-specific:

```text
OcppCodecException
├── OcppEncodingException
└── OcppDecodingException
    └── UnknownDataTransferOperationException
```

Jackson implementation exceptions are wrapped rather than exposed as the primary public contract.

## Encoding failures

`OcppEncodingException` reports failures while converting a payload or complete frame to JSON. Common causes include an incompatible custom `ObjectMapper` or invalid DataTransfer data.

## Decoding failures

`OcppDecodingException` covers malformed JSON, invalid frame shapes, unsupported message type IDs, unknown actions, missing correlation state, and payload/schema mismatches.

```java
try {
  OcppFrame frame = codec.decode(version, json, null);
} catch (OcppDecodingException exception) {
  // Reject the frame or map it to application-level handling.
}
```

Do not rely on parsing exception-message text. Use a specific subtype and its structured properties when one is available.

## DataTransfer lookup failures

`UnknownDataTransferOperationException` exposes:

- `version()`
- `vendorId()`
- nullable `messageId()`
- `reason()`

Its reason is one of `UNKNOWN_VENDOR_ID`, `UNKNOWN_MESSAGE_ID`, or `MISSING_MESSAGE_ID`.

## `CALLERROR`

Protocol error frames use `OcppErrorMessage` and `OcppError`:

```java
OcppError error = OcppError.of(
  OcppErrorCode.FORMATION_VIOLATION,
  "Invalid request payload"
);

OcppErrorMessage message = OcppErrorMessage.of(
  "message-1",
  error
);

String json = codec.encode(message);
```

Error details are represented by immutable `Map<String, JsonNode>` rather than unbounded `Object` values.

```java
OcppErrorMessage decoded = codec.decodeError(json);
```

Decoding a `CALLERROR` removes any stored request context with the same message ID.

## Validation layers

Model constructors enforce inexpensive local schema constraints such as required values, length limits, ranges, and immutable collection ownership. The codec additionally validates frame structure and delegates strict payload binding to its configured mapper.

The schema source remains checked in as protocol provenance and a maintenance reference. Invalid inputs are never silently normalized, coerced, or assigned fallback enum values.

## Handling untrusted input

- Bound incoming frame sizes at the transport boundary; exception messages intentionally do not echo complete raw frames.
- Treat unknown actions and enums as protocol failures.
- Do not enable Jackson default typing.
- Preserve strict mapper settings when supplying a custom `ObjectMapper`.
- Apply application-level authorization and business validation after successful schema decoding.

Networking, authentication, session state, request timeouts, and retry policy remain outside this library.
