# OCPP Java

Immutable OCPP 1.6 JSON and OCPP 2.0.1 models and a strict Jackson codec for Java 25.

## Documentation

- [Getting started](docs/getting-started.md)
- [Codec guide](docs/codec-guide.md)
- [Request correlation](docs/request-correlation.md)
- [DataTransfer modules](docs/data-transfer-modules.md)
- [Model guide](docs/model-guide.md)
- [Errors and validation](docs/errors-and-validation.md)
- [Architecture](docs/architecture.md)
- [Design decisions](docs/design-decisions.md)
- [Contributing](CONTRIBUTING.md)
- [Security policy](SECURITY.md)

Start with the [getting-started guide](docs/getting-started.md) to encode and decode your first OCPP message. The documentation uses the official terms `CALL`, `CALLRESULT`, and `CALLERROR` alongside the corresponding Java types.

Development snapshots use the Maven coordinate `io.github.zonnedev:ocpp-java`. See
[releasing](docs/releasing.md) for Maven Central publication requirements and the release workflow.

Every push and pull request is compiled, formatted, statically checked, and tested on Java 25.
Semantic-version tags publish signed artifacts to Maven Central and create a GitHub Release.

The library contains no networking, WebSocket, session, retry, or charging-station business logic. Complete request, response, and error JSON frames are supported. Because a `CALLRESULT` and `CALLERROR` frame does not carry an action, correlation is delegated to `OcppRequestRepository`; applications can supply durable storage or use the included thread-safe in-memory implementation.

All model, action, API, and codec sources are maintained as ordinary Java code under `ocpp-java/src/main/java`. The project has no source generator and no generation step in its Gradle build. The original schemas remain checked in as protocol provenance and maintenance references.

Each version's `model` package exposes only request and response payload records. A type used exclusively by one message is a public nested record or enum under that message, for example `AuthorizeResponse.IdTagInfo.Status`. Reusable protocol types referenced by multiple messages live in the corresponding `model.type` package.

## DataTransfer modules

Vendor DataTransfer operations are registered explicitly as modules when building the codec. Individual operations cannot be registered directly:

```java
OcppMessageCodec codec = JacksonOcppMessageCodec.builder()
  .requestRepository(requestRepository)
  .dataTransferModules(modules -> modules
    .register(Ocpp16Iso15118DataTransferModule.create())
    .register(new ApplicationDataTransferModule())
  )
  .build();
```

The outer payload remains the version-specific generic `DataTransferRequest<Q>` or `DataTransferResponse<S>`. Registered vendor values are available directly through the payload's `data()` component:

```java
OcppRequestMessage<?> message = codec.decodeRequest(version, json);

if (message.payload() instanceof DataTransferRequest<?> transfer) {
  AuthorizeRequest request = Ocpp16Iso15118DataTransferModule.AUTHORIZE
    .requestType()
    .cast(transfer.data());
}
```

`Q` must implement `DataTransferRequestPayload`, and `S` must implement `DataTransferResponsePayload`. `OcppRequestMessage` and `OcppResponseMessage` contain no DataTransfer-specific fields.

Resolution is strict. Unknown vendors, unknown message IDs, and missing message IDs throw `UnknownDataTransferOperationException`; there is no raw `String`, `JsonNode`, or `Object` fallback. The exception contains the version, vendor ID, optional message ID, and a structured reason that applications can map to the corresponding DataTransfer response status.

OCPP 1.6 module data is encoded and decoded as JSON inside the protocol's textual `data` property. OCPP 2.0.1 module data uses native JSON. For responses, the codec stores the resolved operation in `OcppRequestContext`, allowing the application-provided `OcppRequestRepository` to recover the exact response type from the source request.

For statically typed message construction, use the version-specific operation binding:

```java
OcppRequestMessage<DataTransferRequest<AuthorizeRequest>> message =
  OcppRequestMessage.of(
    "message-1",
    Ocpp16Actions.dataTransfer(
      Ocpp16Iso15118DataTransferModule.AUTHORIZE
    ),
    DataTransferRequest.of(
      authorizeRequest,
      "Authorize",
      "iso15118"
    )
  );
```

The included `Ocpp16Iso15118DataTransferModule` implements the nine operations defined as implemented by has-to-be's OCPP 1.6 ISO 15118 Extension v1.3. It is opt-in and is not registered by `createDefault()`.

## Formatting

The build uses Spotless with the checked-in `config/eclipse-java-formatter.xml` profile. Run `./gradlew spotlessApply` to format Java sources and `./gradlew spotlessCheck` to verify them. The profile uses two-space indentation, Kotlin-like detached closing parentheses for wrapped declarations and invocations, and one-level indentation for fluent call chains.

Checkstyle's `NeedBraces` rule complements Spotless by requiring braces for every `if`, `else`, `for`, `while`, and `do` body, including single statements. This structural rule runs as part of `check`; Spotless then formats the required blocks consistently.

See [`schemas/provenance/PROVENANCE.md`](schemas/provenance/PROVENANCE.md) for schema origin and licensing.
