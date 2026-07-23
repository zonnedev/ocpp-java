package io.github.zonnedev.ocpp.api.datatransfer;

/**
 * Builder-time registration surface. Operations can only be registered through
 * a module.
 */
public interface DataTransferModuleRegistrar {
  DataTransferModuleRegistrar register(DataTransferModule module);
}
