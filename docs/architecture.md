# Architecture

## Scope

The project publishes one Java 25 library containing immutable OCPP 1.6 JSON and OCPP 2.0.1 schema models, action metadata, complete JSON frame types, a strict Jackson codec, optional schema validation, request-correlation abstractions, and typed DataTransfer extensions.

Networking and application protocol behavior are deliberately excluded. The library does not create WebSocket connections, manage sessions, route messages, schedule retries, track timeouts, persist application data, or implement charging-station or CSMS behavior.

## Repository layout

```text
ocpp-java/
├── ocpp-java/          Published Java library and tests
├── schemas/            Read-only official schema references and provenance
├── docs/               User and architecture documentation
├── config/             Formatter and static-analysis configuration
└── .agents/skills/     Project-local Codex maintenance workflow
```

Models are maintained manually. The checked-in schemas are the protocol source of truth for reviews, not source-generator inputs.

## Payload hierarchy

```text
OcppPayload
├── OcppRequest
│   ├── Ocpp16Request
│   └── Ocpp201Request
└── OcppResponse
    ├── Ocpp16Response
    └── Ocpp201Response
```

These are finite sealed hierarchies with explicit `permits` clauses. Each concrete message belongs to exactly one version-specific request or response hierarchy. External implementations and `non-sealed` escape hatches are intentionally prohibited.

## Package organization

OCPP versions remain separate even when the protocol uses the same type name:

```text
io.github.zonnedev.ocpp.v16.model.BootNotificationRequest
io.github.zonnedev.ocpp.v201.model.BootNotificationRequest
```

Requests and responses are public top-level records. A schema type owned by one message is nested inside that message. A type shared by multiple messages lives in the corresponding `model.type` package.

## Action metadata

Version-specific action enums provide finite runtime metadata: wire name, protocol version, request class, and response class. `OcppActionDefinition<Q, S>` adds the generic association Java enum constants cannot retain individually.

Every action must have exactly one request and response. Each payload must report the same action and version as its definition. Action inventories are explicit; runtime scanning and reflection-based subtype discovery are not used.

## Complete frames

| Protocol frame | Message type | Java type | Shape |
|---|---:|---|---|
| `CALL` | 2 | `OcppRequestMessage<Q>` | `[2, id, action, payload]` |
| `CALLRESULT` | 3 | `OcppResponseMessage<S>` | `[3, id, payload]` |
| `CALLERROR` | 4 | `OcppErrorMessage` | `[4, id, code, description, details]` |

The codec constructs these arrays explicitly. Frame records are never serialized as incidental JSON objects. Response action definitions are Java-side metadata and never appear in a `CALLRESULT`.

## Request correlation

A response or error does not carry its source action. Encoding a request therefore saves `OcppRequestContext` through an application-configurable `OcppRequestRepository`. Repository-correlated response or error decoding removes that context.

The default repository is concurrent and process-local. Applications can provide durable or distributed storage. This is metadata delegation, not a session, timeout, retry, or request-routing subsystem.

Explicit typed response decoding can bypass repository lookup when the caller already knows the action. DataTransfer responses require source-request context because the ordinary `DataTransfer` action does not identify the vendor operation.

## DataTransfer extension model

Vendor operations are grouped in explicit `DataTransferModule` implementations. Each operation binds protocol version, vendor ID, message ID, request data class, and response data class.

OCPP 1.6 encodes extension data as JSON inside a textual `data` property; OCPP 2.0.1 carries native JSON. The public API exposes typed values for both. Unknown operations fail instead of falling back to unbounded dynamic data.

## Dependency boundaries

Jackson is the serialization implementation and `JsonNode` is the dynamic JSON boundary. JSpecify defines public nullness. Java time types represent protocol timestamps. The project must not add networking or framework integration dependencies.

The supported export and compatibility boundaries are defined in the
[public API policy](public-api.md).
