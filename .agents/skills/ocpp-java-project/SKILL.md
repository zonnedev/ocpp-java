---
name: ocpp-java-project
description: Maintain the io.github.zonnedev OCPP Java project safely and consistently. Use when adding, changing, reviewing, or diagnosing OCPP 1.6 or OCPP 2.0.1 models, nested or shared schema types, action metadata, sealed hierarchies, Jackson codec behavior, request correlation, validation, DataTransfer modules, protocol extensions, tests, schemas, Gradle configuration, or public API documentation.
---

# Maintain the OCPP Java project

Read the repository-root `AGENTS.md` before acting. Treat it as mandatory policy and this skill as the task workflow.

## Load only the relevant references

- For package, hierarchy, action, or module changes, read [architecture.md](references/architecture.md).
- For records, enums, factories, nullability, or schema constraints, read [model-conventions.md](references/model-conventions.md).
- For frames, Jackson, errors, repositories, or validation, read [codec-contract.md](references/codec-contract.md).
- For DataTransfer or vendor extensions, read [data-transfer.md](references/data-transfer.md).

Consult the matching checked-in JSON schema before changing a protocol type. Do not load unrelated schemas.

## Workflow

1. Identify the affected OCPP version, action, payload direction, and wire schema.
2. Inspect the current implementation, action definition, sealed hierarchy, codec paths, and tests before editing.
3. Compare the Java representation with the matching file in `schemas/v16` or `schemas/v201`.
4. Preserve wire compatibility, requiredness, nullability, constraints, and finite type relationships.
5. Modify ordinary Java source manually. Never invoke, restore, or emulate a generator.
6. Update action metadata and explicit `permits` clauses when adding or removing messages.
7. Add positive round-trip tests and focused negative tests using the repository naming conventions.
8. Update user documentation when public construction, encoding, decoding, correlation, or extension behavior changes.
9. Run `./gradlew spotlessApply check` and `git diff --check`.
10. Report the changed behavior, important design implications, and verification outcome.

## Decision rules

- Preserve protocol correctness over convenience.
- Do not infer response actions from payload shapes.
- Do not merge same-named types across protocol versions.
- Do not broaden closed enums or sealed hierarchies unless the official schema defines extensibility.
- Keep dynamic JSON confined to documented extension boundaries.
- Record intentional architecture changes in `docs/design-decisions.md`.
- Stop and explain an ambiguity when valid wire behavior cannot be determined from the schema or checked-in provenance.

Use `rg` for file and text discovery. Preserve unrelated worktree changes. Keep changes scoped to the requested behavior.
