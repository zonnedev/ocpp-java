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

## Invalid frames

Cover non-array roots, malformed JSON, unsupported or non-integer message types, wrong element counts, invalid message IDs, unknown actions, non-object payloads, missing correlation, required nulls, scalar coercion, forbidden properties, and unknown enum or error-code values.

## Correlation and DataTransfer

Test repository save/remove behavior, duplicate outstanding IDs, absent source contexts, error cleanup, and custom repository integration.

For DataTransfer, test both protocol versions, module registration, duplicate definitions, typed data, OCPP 1.6 textual JSON, OCPP 2.0.1 native JSON, response operation recovery, and all structured unknown-operation reasons. Confirm there is no raw-data fallback.

## Build verification

Run:

```shell
./gradlew spotlessApply check
git diff --check
```
