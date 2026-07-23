# OCPP Java repository instructions

## Project scope

- Build an immutable Java 25 library for OCPP 1.6 JSON and OCPP 2.0.1 models and JSON codecs.
- Use `io.github.zonnedev.ocpp` as the base package.
- Keep networking, WebSockets, sessions, routing, retries, timeouts, persistence, and charging behavior outside this library.
- Treat `OcppMessageCodec` as the main public entry point and `JacksonOcppMessageCodec` as its default implementation.

## Source maintenance

- Maintain models as ordinary Java source under `ocpp-java/src/main/java`.
- Never recreate, invoke, or add a source generator unless the user explicitly reverses this decision.
- Treat `schemas/` as read-only protocol reference and provenance material.
- Inspect the corresponding schema before changing a protocol model.
- Preserve exact wire names, required properties, nullability, constraints, and extension rules.

## Model design

- Represent schema objects with immutable records and closed values with enums.
- Give every publicly instantiable record an `of(...)` factory.
- Use semantic factories only for official protocol outcomes and never invent defaults.
- Use compact constructors for required null checks, local constraints, and defensive collection copies.
- Use JSpecify `@NullMarked` packages and `@Nullable` only for schema-optional or nullable values.
- Do not use `Optional` as a record component.
- Keep OCPP 1.6 and OCPP 2.0.1 models separate.
- Expose requests and responses directly in each version's `model` package.
- Nest a type used by only one message inside that message; put reusable types in `model.type`.
- Keep request and response hierarchies sealed with explicit, exhaustive `permits` clauses.
- Do not add mutable JavaBeans, setters, public mutable fields, serializer-only constructors, raw types, or unbounded `Object` values.

## Actions and codec

- Keep every action associated with exactly one request type and one response type.
- Use `OcppActionDefinition<Q, S>` to preserve the compile-time request/response association.
- Use `OcppRequestMessage`, `OcppResponseMessage`, and `OcppErrorMessage` for complete `CALL`, `CALLRESULT`, and `CALLERROR` frames.
- Never infer a response action from payload shape.
- Delegate response and error correlation to `OcppRequestRepository`.
- Do not add routing, session state, retry policy, or network behavior to the codec.
- Reject malformed frames, unknown actions, unknown enums, forbidden properties, and scalar coercion strictly.
- Isolate unavoidable dynamic JSON at `JsonNode` boundaries.

## DataTransfer

- Register vendor operations only through `DataTransferModule`; do not expose individual operation registration.
- Keep operation definitions version-specific even when their data classes look similar.
- Store the resolved DataTransfer operation in the source-request context for response decoding.
- Reject unknown vendors, unknown message IDs, and missing message IDs with `UnknownDataTransferOperationException`.
- Do not preserve unknown DataTransfer data as raw `String`, `Object`, or `JsonNode`.
- Place extensions under `io.github.zonnedev.ocpp.extension.<version>.<extension-name>`.

## Style and tests

- Use the checked-in Spotless Eclipse formatter with two-space indentation and detached closing parentheses.
- Indent fluent call chains by one level.
- Always use braces for control-flow bodies.
- Name tests `it_describes_expected_behavior()` and add a readable `@DisplayName` to every test.
- Add positive round-trip and negative boundary tests for public behavior changes.
- Update `docs/` whenever public API behavior or usage changes.

## Verification

After Java, Gradle, or schema-related changes, run:

```shell
./gradlew spotlessApply check
git diff --check
```

Read `.agents/skills/ocpp-java-project/SKILL.md` for the task-specific maintenance workflow and reference routing.
