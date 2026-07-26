# Testing strategy

## Naming and structure

Use JUnit 5 and AssertJ. Every test method has a behavior-oriented snake-case name and readable display name:

```java
@Test
@DisplayName("Encodes and decodes OCPP messages round-trip")
void it_encodes_and_decodes_ocpp_messages_roundtrip() {
}
```

## Model coverage

Tests should prove that every official message has exactly one record, every payload appears in the correct explicit `permits` clause, every action has exactly one request and response type, and every payload reports its correct version and action. Exhaustive switches over sealed families should require no default branch.

## Factory and nullability coverage

Verify `of(...)` availability, cached empty payloads, minimal and complete factories, semantic outcomes, required null rejection, optional absence, immutable collection ownership, enum wire values, and strict unknown enum handling.

## Codec round trips

For every action, cover a valid request and response fixture. Verify message ID, action definition, exact payload class, payload equality, and semantic JSON equality.

Request tests assert `[2, id, action, payload]`. Response tests assert `[3, id, payload]` and specifically verify the absence of an action element. Error tests cover every standard code, empty and populated details, and strict malformed-frame handling.

`OfficialProtocolFixtureTest` builds the smallest valid payload from each checked-in schema and exercises both the String and JSON-tree codec entry points. Its parameterized inventory covers every ordinary request and response action in OCPP 1.6 and OCPP 2.0.1. DataTransfer is covered separately because its payload type is selected by an explicitly registered vendor module rather than the base protocol action alone.

## Invalid frames

Cover non-array roots, malformed JSON, unsupported or non-integer message types, wrong element counts, invalid message IDs, unknown actions, non-object payloads, missing correlation, required nulls, scalar coercion, forbidden properties, and unknown enum or error-code values.

`OfficialSchemaConformanceTest` derives negative cases from every reachable constraint in each minimal official fixture. It verifies missing and null required properties, unknown fields and enums, wrong JSON types, disabled scalar coercion, string bounds, numeric bounds, and array bounds through both String and JSON-tree payload entry points.

Focused codec tests verify that strict schema validation is enabled by default and that explicitly disabling it skips only official schema enforcement while preserving Jackson's unknown-property rejection.

## Correlation and DataTransfer

Test repository save/remove behavior, duplicate outstanding IDs, absent source contexts, error cleanup, and custom repository integration.

For DataTransfer, test both protocol versions, module registration, duplicate definitions, typed data, OCPP 1.6 textual JSON, OCPP 2.0.1 native JSON, response operation recovery, and all structured unknown-operation reasons. Confirm there is no raw-data fallback.

## Build verification

Run:

```shell
./gradlew spotlessApply check
git diff --check
```

## API compatibility

The `apiCompatibilityCheck` task compares the current JAR with the released version declared by `apiBaselineVersion` in `gradle.properties`. It checks exported `io.github.zonnedev.ocpp` packages and excludes the non-exported `codec.internal` implementation package.

Compatibility enforcement is temporarily detached from the `check` lifecycle while preparing `1.0.0-rc2`, which intentionally replaces the misspelled ISO 15118 extension API inherited from the `0.2.0` baseline. After `1.0.0-rc2` is published, update `apiBaselineVersion` to that immutable release and restore `check`'s dependency on `apiCompatibilityCheck`.

The task writes text and HTML reports under `ocpp-java/build/reports/`. After publishing a release, update `apiBaselineVersion` to that immutable Maven Central version in a dedicated reviewed change. Never use a dynamic version such as `latest.release`, because the same commit must resolve the same compatibility baseline over time.

During `0.x`, an intentional breaking change still requires an explicit baseline or compatibility-policy decision. Do not bypass the task silently. For `1.x`, preserve binary compatibility throughout the major release line unless the project deliberately prepares a new major version.
