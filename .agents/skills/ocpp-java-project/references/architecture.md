# Architecture reference

Read `docs/architecture.md` and `docs/design-decisions.md` before changing module layout, package ownership, public abstractions, action metadata, or sealed hierarchies.

## Key source locations

- Root API: `ocpp-java/src/main/java/io/github/zonnedev/ocpp/api`
- OCPP 1.6 actions and models: `ocpp-java/src/main/java/io/github/zonnedev/ocpp/v16`
- OCPP 2.0.1 actions and models: `ocpp-java/src/main/java/io/github/zonnedev/ocpp/v201`
- Frames and codec: `ocpp-java/src/main/java/io/github/zonnedev/ocpp/codec`
- Jackson configuration: `ocpp-java/src/main/java/io/github/zonnedev/ocpp/jackson`
- Validation: `ocpp-java/src/main/java/io/github/zonnedev/ocpp/validation`
- Extensions: `ocpp-java/src/main/java/io/github/zonnedev/ocpp/extension`
- Reference schemas: `schemas/v16` and `schemas/v201`

## Cross-cutting change checklist

When adding or removing a message, inspect and update together:

1. The request or response record.
2. Its version-specific sealed `permits` clause.
3. Its version-specific action enum.
4. Its typed action definition.
5. Action lookup and inventory tests.
6. Request and response codec fixtures.
7. JPMS exports or opens only when package visibility truly changes.

Do not introduce runtime subtype scanning. Compilation should expose mismatches between models, action metadata, and sealed hierarchies.
