# Codec contract

Read `docs/codec-guide.md`, `docs/request-correlation.md`, `docs/errors-and-validation.md`, and `docs/architecture.md` before changing codec behavior.

## Frame invariants

- `CALL`: exactly `[2, messageId, action, objectPayload]`.
- `CALLRESULT`: exactly `[3, messageId, objectPayload]`.
- `CALLERROR`: exactly `[4, messageId, errorCode, description, objectDetails]`.
- Require non-empty textual IDs and actions.
- Construct protocol arrays explicitly.
- Never encode Java action metadata in a response.

## Decode paths

- Request decoding requires `OcppVersion` and performs exact action lookup.
- Typed response decoding uses the supplied `OcppActionDefinition<Q, S>`.
- Correlated response decoding removes `OcppRequestContext` by message ID.
- Error decoding removes correlation state by message ID.
- DataTransfer response decoding requires the stored operation.
- Payload-only methods do not mutate repository state.

## Jackson boundary

- Copy caller-provided mappers instead of mutating them.
- Keep strict null, creator-property, unknown-property, enum, and scalar-coercion behavior.
- Never enable default typing or serialize Java class names.
- Wrap implementation failures in the narrow codec exception hierarchy.
- Keep exception messages contextual but do not include unbounded raw input.

## Tests

Cover both String and tree entry points when behavior differs, exact frame shapes, malformed element types and counts, correlation cleanup, wrong definitions, unknown actions, payload constraints, and exception subtypes.
