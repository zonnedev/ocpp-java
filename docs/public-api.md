# Public API policy

This document records the public API audit performed against release `0.2.0` in preparation
for `1.0.0`.

## Supported API surface

The Java module descriptor is the authority for supported packages. OCPP Java exports:

- `io.github.zonnedev.ocpp.api`
- `io.github.zonnedev.ocpp.api.datatransfer`
- `io.github.zonnedev.ocpp.codec`
- `io.github.zonnedev.ocpp.extension.v16.iso15118`
- `io.github.zonnedev.ocpp.jackson`
- `io.github.zonnedev.ocpp.v16`
- `io.github.zonnedev.ocpp.v16.model`
- `io.github.zonnedev.ocpp.v16.model.type`
- `io.github.zonnedev.ocpp.v201`
- `io.github.zonnedev.ocpp.v201.model`
- `io.github.zonnedev.ocpp.v201.model.type`

Public types in these packages are supported API. Their binary signatures, generic
associations, record components, sealed hierarchies, enum constants, factories, and
documented behavior are compatibility-sensitive.

Packages not exported by `module-info.java`, including `codec.internal`, are implementation
details. They may change without notice and must not be used by applications, even if a
public implementation class is technically visible when the JAR is placed on the
classpath instead of the module path.

## Audited boundaries

The audit confirmed these intended boundaries:

- `OcppMessageCodec` is the primary codec contract.
- `JacksonOcppMessageCodec` and `OcppObjectMapperFactory` are the supported Jackson
  implementation surface.
- Frame records expose complete `CALL`, `CALLRESULT`, and `CALLERROR` messages.
- `OcppRequestRepository` and `OcppRequestContext` are the complete correlation extension
  point; no session, routing, retry, or networking API is exposed.
- Version-specific action enums and typed action definitions preserve request/response
  associations.
- Request and response payload families remain sealed and exhaustive.
- OCPP 1.6 and OCPP 2.0.1 models remain separate.
- DataTransfer customization is exposed only through version-specific operation
  definitions and complete modules.
- Dynamic application data is limited to documented `JsonNode` boundaries.

No exported package or core abstraction was identified as accidental during the `0.2.0`
audit.

## Model compatibility

Protocol models are immutable records. Every publicly reachable record must provide a
public static `of(...)` factory and must not use `Optional` or unbounded `Object` record
components.

Record component names, types, and ordering are constructor and binary API. Changing them
is an incompatible change even when the JSON wire representation remains unchanged.
Likewise, removing or renaming enum constants, action constants, factories, permitted
subtypes, or public methods is incompatible.

Schema corrections take precedence over convenience. If an official protocol correction
requires an incompatible Java change, document the reason and release it according to the
semantic-versioning policy.

## Compatibility enforcement

`PublicApiContractTest` verifies the exact JPMS export list and the public record
construction rules. JApiCmp compares each build with the immutable Maven Central version
declared by `apiBaselineVersion`.

Before `1.0.0`, incompatible cleanup may be released in a new minor version when it is
intentional and documented. Starting with `1.0.0`, incompatible exported API changes
require a new major version.
