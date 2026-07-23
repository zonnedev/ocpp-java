# Security Policy

## Supported versions

Security fixes are provided for the latest released version of OCPP Java. Older releases
may not receive patches. Users should upgrade to the newest Maven Central release before
reporting an issue and when a security release becomes available.

The project is currently pre-1.0. Until `1.0.0`, minor releases may contain compatibility
changes in addition to security fixes.

## Reporting a vulnerability

Do not report suspected vulnerabilities in a public GitHub issue, discussion, pull
request, or social-media post.

Report them privately by email to:

```text
zonnedev@gmail.com
```

Use a clear subject such as `Security report: ocpp-java`. Include:

- The affected version and component.
- A description of the vulnerability and its impact.
- Reproduction steps or a minimal proof of concept.
- Any relevant configuration or environment details.
- Suggested mitigations, if known.
- Whether the report or its details have been shared elsewhere.

Do not include credentials, private keys, production data, or other unrelated sensitive
information. Use synthetic test data whenever possible.

## What to expect

The maintainer will acknowledge the report, investigate it, and coordinate remediation
and disclosure with the reporter. Response and release timing depends on severity,
complexity, and maintainer availability; this project does not promise a fixed service
level.

Please allow a reasonable remediation period before public disclosure. If the report is
not a security vulnerability, you may be asked to open a normal public issue.

## Scope

Relevant security reports include vulnerabilities involving:

- Unsafe or inconsistent parsing of untrusted OCPP frames.
- Validation bypasses with a material security impact.
- Unexpected type handling or unsafe Jackson configuration.
- Denial-of-service behavior caused by bounded, realistic protocol inputs.
- Exposure or corruption of request-correlation data.
- Vulnerabilities in bundled or runtime dependencies that affect this library.

Networking, WebSocket transport, authentication, authorization, session management,
persistence, retry behavior, and charging-station business logic are outside this
library's scope unless the issue is directly caused by OCPP Java.

Protocol non-conformance, ordinary bugs, feature requests, and documentation corrections
without a security impact should be reported through a public GitHub issue.
