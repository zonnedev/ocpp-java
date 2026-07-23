# Model guide

## Versioned packages

OCPP 1.6 and OCPP 2.0.1 use separate Java packages. Types with the same protocol name are not merged:

```text
io.github.zonnedev.ocpp.v16.model.BootNotificationRequest
io.github.zonnedev.ocpp.v201.model.BootNotificationRequest
```

Import the type for the protocol version being handled. Avoid wildcard imports when code works with both versions.

## Immutable records

Every schema object is represented by an immutable record. Required values are checked by record constructors, and collection components are defensively copied. Each instantiable record exposes an `of(...)` factory.

```java
AuthorizeRequest request = AuthorizeRequest.of("ABC-123");
```

Empty payloads use cached zero-component records:

```java
HeartbeatRequest request = HeartbeatRequest.of();
```

Where justified by protocol semantics, response types also expose factories such as `accepted(...)`, `rejected(...)`, or `pending(...)`.

## Message-specific and reusable types

The public `model` packages contain request and response payload records.

- A type used by only one message is nested under that request or response.
- A type shared by multiple messages lives in the version's `model.type` package.

For example, message-specific status details may be addressed through a response class, while shared OCPP 2.0.1 types are imported from `io.github.zonnedev.ocpp.v201.model.type`.

This organization makes ownership visible without creating a flat package containing hundreds of unrelated schema implementation types.

## Action metadata

Each payload reports its version and action, but those metadata methods are ignored during JSON serialization.

Version-specific action enums provide finite runtime metadata. Companion action-definition classes preserve the request-to-response type relationship:

```java
Ocpp16Actions.HEARTBEAT
Ocpp201Actions.BOOT_NOTIFICATION
```

Use action definitions when constructing frames or decoding payloads. They prevent associating a request with the wrong response type.

## Nullability

Public packages are JSpecify `@NullMarked`:

- unannotated references are non-null;
- optional schema properties use `@Nullable`;
- record components do not use `Optional`;
- absent optional collections remain distinct from empty collections where the schema distinguishes them.

Required nulls fail at construction or decoding. Missing required JSON properties, explicit nulls for required values, unknown fields where forbidden, scalar coercion, and unknown enum values fail strictly.

## Date and time

Protocol timestamps use Java time types such as `Instant`. The configured mapper emits textual ISO-8601 values rather than numeric timestamps.

## Exhaustive payload handling

Root and version-specific request and response types are sealed. Applications can use pattern matching to handle the finite protocol model without external subtype implementations.

When handling both versions, first discriminate by version or version-specific sealed interface so equally named model classes remain unambiguous.
