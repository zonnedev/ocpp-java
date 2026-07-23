# OCPP Java user guide

This guide documents the public API of the OCPP Java model and codec library. The library supports OCPP 1.6 JSON and OCPP 2.0.1 payloads and JSON frames. It does not provide networking, WebSocket connections, sessions, retries, routing, or protocol business logic.

Release maintainers should also read [releasing](releasing.md).

## Guides

1. [Getting started](getting-started.md) — create a codec and exchange a request and response.
2. [Codec guide](codec-guide.md) — complete frames, payload-only operations, tree APIs, and dispatch.
3. [Request correlation](request-correlation.md) — decode responses and errors using application-owned state.
4. [DataTransfer modules](data-transfer-modules.md) — register and implement typed vendor extensions.
5. [Model guide](model-guide.md) — immutable records, factories, nested types, shared types, and nullability.
6. [Errors and validation](errors-and-validation.md) — failure types and strict decoding behavior.

## Maintainer documentation

- [Architecture](architecture.md)
- [Protocol modeling rules](protocol-modeling.md)
- [Testing strategy](testing-strategy.md)
- [Design decisions](design-decisions.md)

## Protocol terminology

Both supported JSON protocol versions use these frame names:

| OCPP term | Message type ID | Java type |
|---|---:|---|
| `CALL` | 2 | `OcppRequestMessage<Q>` |
| `CALLRESULT` | 3 | `OcppResponseMessage<S>` |
| `CALLERROR` | 4 | `OcppErrorMessage` |

The Java names describe the role of each message while the documentation retains the official OCPP terminology.
