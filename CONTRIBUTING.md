# Contributing to OCPP Java

Thank you for contributing to OCPP Java. Contributions that improve protocol correctness,
API clarity, documentation, tests, and maintainability are welcome.

## Before you start

For a substantial change, open an issue before investing significant implementation work.
Describe the problem, the affected OCPP version and action, the proposed behavior, and any
public API implications. Small corrections and focused fixes can be submitted directly.

Security vulnerabilities must not be reported through public issues. Follow
[SECURITY.md](SECURITY.md) instead.

## Development requirements

- Java 25
- The checked-in Gradle wrapper
- Git

Clone the repository and run the complete verification suite:

```shell
./gradlew spotlessApply check
git diff --check
```

`check` compiles with warnings treated as errors, runs Spotless, Checkstyle, the complete
test suite, schema inventory verification, and binary API compatibility checks.

## Project boundaries

This project provides immutable OCPP 1.6 JSON and OCPP 2.0.1 models and JSON codecs. Keep
networking, WebSockets, sessions, routing, retries, timeouts, persistence, and charging
behavior outside the library.

Protocol models are maintained manually as ordinary Java source under
`ocpp-java/src/main/java`. Do not add or invoke a source generator. Files under `schemas/`
are read-only protocol references and provenance material.

When changing protocol behavior:

1. Identify the OCPP version, action, and request or response direction.
2. Inspect the corresponding checked-in schema.
3. Preserve exact wire names, required properties, nullability, bounds, enums, and
   extension rules.
4. Keep OCPP 1.6 and OCPP 2.0.1 types separate.
5. Update action definitions and sealed hierarchies when the message inventory changes.
6. Add positive round-trip tests and focused negative boundary tests.
7. Update documentation for public API or behavior changes.

See [docs/architecture.md](docs/architecture.md),
[docs/protocol-modeling.md](docs/protocol-modeling.md), and
[docs/testing-strategy.md](docs/testing-strategy.md) for the detailed design and test
contracts.

## Java and test conventions

- Use immutable records for schema objects and enums for closed values.
- Give every publicly instantiable record an `of(...)` factory.
- Use `@Nullable` only for schema-optional or nullable values.
- Do not use `Optional` as a record component.
- Defensively copy collections.
- Keep dynamic JSON at documented `JsonNode` boundaries.
- Always use braces for control-flow bodies.
- Name tests `it_describes_expected_behavior()`.
- Add a readable `@DisplayName` to every test.

Spotless uses the checked-in Eclipse formatter with two-space indentation. Run
`./gradlew spotlessApply` instead of formatting Java manually.

## Pull requests

Keep each pull request focused. Include:

- A concise description of the problem and solution.
- The affected OCPP versions and actions.
- Public API or compatibility implications.
- Tests added or updated.
- Documentation changes, when applicable.

Before submitting:

```shell
./gradlew spotlessApply check
git diff --check
```

Do not commit generated build output, local credentials, signing keys, Maven Central
tokens, or IDE-specific files. All CI checks must pass before merge.

## API compatibility

The build compares the current public API with the immutable Maven Central version in
`apiBaselineVersion`. Treat compatibility failures as design decisions, not as checks to
bypass. During `1.x`, incompatible public API changes require a new major version.

## Licensing

By submitting a contribution, you agree that it may be distributed under the project's
[MIT License](LICENSE). Only contribute material that you have the right to submit.
