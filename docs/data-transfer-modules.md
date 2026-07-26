# DataTransfer modules

DataTransfer is the official OCPP extension envelope for vendor-defined messages. This library keeps the outer OCPP payload schema-defined while making its `data` value strongly typed through explicitly registered modules.

## Register modules

All operations must be supplied through a `DataTransferModule`; individual operation registration is intentionally not exposed.

```java
OcppMessageCodec codec = JacksonOcppMessageCodec
  .builder()
  .dataTransferModules(modules -> modules
    .register(Ocpp16Iso15118DataTransferModule.create())
    .register(new ApplicationDataTransferModule())
  )
  .build();
```

Registration is finalized when `build()` is called. Registering duplicate operation keys or invalid modules fails during codec construction.

## Module contract

```java
public interface DataTransferModule {
  String name();

  List<DataTransferOperationDefinition<?, ?>> operations();
}
```

The module name identifies the Java module bundle; operation lookup uses protocol version, vendor ID, and message ID.

Request data implements `DataTransferRequestPayload`, and response data implements `DataTransferResponsePayload`:

```java
public record EchoRequest(
  String value
) implements DataTransferRequestPayload {
}

public record EchoResponse(
  String value
) implements DataTransferResponsePayload {
}
```

Create version-specific operation definitions. Do not reuse an OCPP 1.6 definition for OCPP 2.0.1 merely because its Java data records happen to match:

```java
Ocpp16DataTransferOperation<EchoRequest, EchoResponse> echo =
  Ocpp16DataTransferOperation.of(
    "com.example.vendor",
    "Echo",
    EchoRequest.class,
    EchoResponse.class
  );
```

A module returns its complete immutable operation list:

```java
public final class ApplicationDataTransferModule
    implements DataTransferModule {

  public static final Ocpp16DataTransferOperation<EchoRequest, EchoResponse> ECHO =
    Ocpp16DataTransferOperation.of(
      "com.example.vendor",
      "Echo",
      EchoRequest.class,
      EchoResponse.class
    );

  @Override
  public String name() {
    return "application-data-transfer";
  }

  @Override
  public List<DataTransferOperationDefinition<?, ?>> operations() {
    return List.of(ECHO);
  }
}
```

## Construct a typed request

```java
EchoRequest data = new EchoRequest("hello");

OcppRequestMessage<DataTransferRequest<EchoRequest>> message =
  OcppRequestMessage.of(
    "message-1",
    Ocpp16Actions.dataTransfer(ECHO),
    DataTransferRequest.of(
      data,
      "Echo",
      "com.example.vendor"
    )
  );
```

Encoding records the selected operation in `OcppRequestContext`, allowing the response decoder to select `EchoResponse` later.

## Decode typed data

The decoded message retains the ordinary version-specific `DataTransferRequest<?>` envelope:

```java
OcppRequestMessage<?> message = codec.decodeRequest(
  OcppVersion.OCPP_1_6_JSON,
  json
);

if (message.payload() instanceof DataTransferRequest<?> transfer) {
  EchoRequest request = ECHO
    .requestType()
    .cast(transfer.data());
}
```

Decode the corresponding response through repository correlation:

```java
OcppResponseMessage<?> response = codec.decodeResponse(responseJson);
```

The generic `DataTransfer` action definition is insufficient for response decoding because it does not identify a vendor or operation.

## Wire representation differences

- OCPP 1.6 carries module data as JSON encoded inside the textual `data` property.
- OCPP 2.0.1 carries module data as native JSON.

The codec handles this difference while presenting typed Java values in both versions.

## Unknown operations

Resolution is deliberately strict. Unknown vendor IDs, unknown message IDs, and missing message IDs throw `UnknownDataTransferOperationException`.

```java
try {
  codec.decodeRequest(version, json);
} catch (UnknownDataTransferOperationException exception) {
  switch (exception.reason()) {
    case UNKNOWN_VENDOR_ID -> {
      // Map to the protocol-appropriate unknown-vendor result.
    }
    case UNKNOWN_MESSAGE_ID, MISSING_MESSAGE_ID -> {
      // Map to the protocol-appropriate unknown-message result.
    }
  }
}
```

Unknown data is not returned as `String`, `Object`, or `JsonNode`. Applications must explicitly register every supported operation.

## ISO 15118 extension

`Ocpp16Iso15118DataTransferModule` is an opt-in implementation of the nine implemented operations described by the has-to-be OCPP 1.6 ISO 15118 Extension v1.3.

The published v1.3 document misspells the `ExtendedTriggerMessage`
`requestedMessage` value `SignV2GCertificate` as `SignV2GCertifcate`. This
module exposes and accepts only the corrected `SignV2GCertificate` spelling.

```java
modules.register(
  Ocpp16Iso15118DataTransferModule.create()
);
```

It is located in `io.github.zonnedev.ocpp.extension.v16.iso15118` and is not registered by `createDefault()`.
