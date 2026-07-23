package io.github.zonnedev.ocpp.api.datatransfer;

import io.github.zonnedev.ocpp.api.OcppVersion;

/**
 * Typed definition of one vendor operation transported by the OCPP DataTransfer
 * action.
 */
public sealed interface DataTransferOperationDefinition<Q extends DataTransferRequestPayload, S extends DataTransferResponsePayload>
  permits Ocpp16DataTransferOperation, Ocpp201DataTransferOperation {
  OcppVersion version();

  String vendorId();

  String messageId();

  Class<Q> requestType();

  Class<S> responseType();
}
