# Design decisions

This file records intentional changes from the project's original design brief. Future maintenance must not revert them accidentally.

## Java 25 is the baseline

The original brief named Java 21. The project now intentionally compiles and tests with Java 25 as its minimum and default toolchain.

## Models are maintained manually

The original brief required deterministic schema-driven generation. The models were generated once and moved into ordinary source. There is no generator, generated-source directory, generation task, semantic-factory configuration, normalization pipeline, or reproducibility test.

Model changes are reviewed and tested like other Java changes. `schemas/` remains checked in as read-only protocol reference and provenance material. Do not recreate generation infrastructure without an explicit new decision.

## The project publishes one library module

The original brief proposed separate API, schema, code-generation, versioned model, codec, validation, and schema-test Gradle modules. The current project intentionally uses one `ocpp-java` subproject. Static schemas and documentation are top-level repository material rather than Gradle subprojects.

## Request correlation is delegated by the codec

The original brief excluded pending-request tracking and required callers to supply a response action definition. The current API additionally supports decoding a response or error from its message ID through `OcppRequestRepository`.

The library exposes the repository contract and provides a process-local, thread-safe default. Applications may provide durable or distributed storage. This does not authorize sessions, routing, retries, timeouts, or application business behavior.

Explicit action-definition response decoding remains available for ordinary actions. DataTransfer responses require stored source context because their exact vendor operation is not carried by `CALLRESULT`.

## DataTransfer extensions are module-based and strict

Applications register complete `DataTransferModule` bundles, not individual operations. Definitions are version-specific because the OCPP 1.6 and OCPP 2.0.1 envelope and model types differ.

Unknown vendors, unknown message IDs, and missing message IDs throw `UnknownDataTransferOperationException`. Unknown payloads are not preserved as raw strings, objects, or JSON nodes.

The bundled OCPP 1.6 ISO 15118 extension is opt-in and lives under `io.github.zonnedev.ocpp.extension.v16.iso15118`.

The has-to-be v1.3 document misspells the `ExtendedTriggerMessage`
`SignV2GCertificate` value as `SignV2GCertifcate`. The bundled module
intentionally uses only the corrected spelling and rejects the published typo.

## Message ownership shapes model packages

The original brief described flat versioned model packages. The current API exposes request and response records directly, nests types owned by exactly one message, and places types shared by multiple messages in `model.type`.

## Java frame names differ from protocol frame names

Both OCPP versions call their JSON frames `CALL`, `CALLRESULT`, and `CALLERROR`. The public Java API intentionally uses `OcppRequestMessage`, `OcppResponseMessage`, and `OcppErrorMessage` while documentation retains official terminology.
