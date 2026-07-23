# Model conventions

Read `docs/protocol-modeling.md` and the exact matching schema before changing a model.

## Ownership

- Keep requests and responses as public top-level records in `model`.
- Nest a type referenced by only one message under that message.
- Move a type to `model.type` only when multiple messages genuinely share the protocol definition.
- Do not merge version-specific types.

## Construction

- Require non-null required components in the compact constructor.
- Defensively copy collections and maps.
- Preserve absent optional collections as `null`.
- Provide minimal and complete `of(...)` factories without combinatorial overloads.
- Cache zero-component records.
- Add semantic factories only for explicit official outcomes.

## Wire behavior

- Preserve exact `@JsonProperty` names where Java naming differs.
- Keep `version()` and `action()` ignored by Jackson.
- Give enums explicit wire values and strict lookup.
- Reject unknown fields where the schema forbids additional properties.
- Use `JsonNode`, not `Object`, only where arbitrary JSON is officially permitted.

## Verification focus

Test constructor constraints, missing and null JSON properties, enum lookup, immutable collections, minimal and complete factories, exact property names, and JSON round trips.
