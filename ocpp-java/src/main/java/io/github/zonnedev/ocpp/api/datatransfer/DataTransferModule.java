package io.github.zonnedev.ocpp.api.datatransfer;

import java.util.List;

/** Explicitly registered bundle of vendor DataTransfer operations. */
public interface DataTransferModule {
  String name();

  List<DataTransferOperationDefinition<?, ?>> operations();
}
