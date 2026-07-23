# DataTransfer reference

Read `docs/data-transfer-modules.md`, `docs/request-correlation.md`, and `docs/design-decisions.md` before changing DataTransfer behavior.

## Registration

- Accept complete `DataTransferModule` bundles only.
- Freeze registration at codec construction.
- Reject empty, invalid, or duplicate operation definitions.
- Key operations by protocol version, vendor ID, and message ID.
- Keep OCPP 1.6 and OCPP 2.0.1 definitions separate.

## Typed envelopes

- Request data implements `DataTransferRequestPayload`.
- Response data implements `DataTransferResponsePayload`.
- Preserve the version-specific outer `DataTransferRequest<Q>` and `DataTransferResponse<S>`.
- OCPP 1.6 serializes data as JSON text.
- OCPP 2.0.1 serializes data as native JSON.

## Correlation and unknown operations

- Save the resolved operation with the source request.
- Use it to select the exact response data class.
- Throw `UnknownDataTransferOperationException` for unknown vendors, unknown message IDs, and missing message IDs.
- Preserve its structured version, vendor, message ID, and reason fields.
- Never add raw-data fallback behavior.

## Extensions

Place bundled extensions under `io.github.zonnedev.ocpp.extension.<version>.<name>`. Keep the OCPP 1.6 ISO 15118 module opt-in and aligned with its checked-in provenance. Test every exposed operation plus registration and failure boundaries.
