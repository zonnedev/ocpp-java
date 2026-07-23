# Protocol modeling rules

## Schema fidelity

Treat the corresponding file under `schemas/v16` or `schemas/v201` as the source of truth before changing a protocol model. Preserve:

- required, optional, and explicitly nullable properties;
- exact JSON property names;
- string lengths and patterns;
- numeric bounds;
- collection sizes and element nullability;
- enum wire values;
- date-time formats;
- referenced and reusable definitions;
- `additionalProperties` rules;
- custom-data extension points;
- descriptions and deprecation metadata where represented.

Do not weaken constraints, make required fields nullable, accept unknown closed-enum values, coerce scalar types, normalize values beyond protocol rules, or silently discard forbidden properties.

When Java and JSON Schema differ, preserve wire compatibility first, represent nullability accurately, prefer compile-time safety, and isolate unavoidable dynamic content behind `JsonNode`. Document mismatches that Java cannot represent exactly.

## Records and factories

Represent each object schema with an immutable record. Every publicly instantiable record exposes `of(...)`:

- For required-only records, provide one complete factory.
- For records with optional components, provide a minimal required-only factory and one complete factory.
- Do not create a combinatorial overload for every optional-property subset.
- Cache the instance returned by `of()` for zero-component records.

Generate or add semantic factories only when an official finite outcome makes the meaning unambiguous. Such factories set only their named outcome, retain every other required argument, and never invent protocol defaults.

## Constructors and immutability

Use compact constructors for inexpensive local invariants:

- reject required nulls;
- enforce lengths, patterns, ranges, and collection sizes;
- defensively copy collections and maps;
- preserve `null` for absent optional collections instead of converting it to empty;
- reject null elements or values unless explicitly permitted.

Prefer `List.copyOf` and `Map.copyOf`. Avoid mutable arrays; defensively copy them on input and access when unavoidable.

## Nullability

Every public package is JSpecify `@NullMarked`. Under that contract:

- unannotated references are non-null;
- optional or nullable schema values use `@Nullable`;
- collection instance, element, key, and value nullness are modeled independently;
- required constructor and factory parameters reject null;
- missing and explicit-null required JSON properties fail;
- `Optional` is not used as a record component;
- `@NullUnmarked` is allowed only at a documented interoperability boundary.

Introduce a dedicated presence type only when the wire semantics distinguish missing, explicit `null`, and a present value.

## Enums and extensible values

Closed schema enums use explicit wire values with strict lookup. Never rely on Java constant names matching JSON. Unknown wire values throw; they do not return `null` or a fallback.

If a schema explicitly permits custom values, model that individual value family with a sealed extensible representation rather than weakening every enum.

## Value types

Add a value record when it represents a reusable named schema, enforces meaningful constraints, prevents mixing semantically distinct values, or materially improves the API. Do not mechanically wrap every primitive or string.

## Date and time

Use `Instant` for unambiguous protocol timestamps and other `java.time` types when their semantics require them. Never use `Date`, `Calendar`, or numeric timestamp serialization. Ensure JSON remains protocol-compatible ISO-8601 text.

## Additional properties

Model official extension mechanisms explicitly. Where arbitrary properties are permitted, use an immutable `Map<String, JsonNode>` or a controlled `ObjectNode`, never `Map<String, Object>`. Ordinary schema-defined objects remain typed records.
