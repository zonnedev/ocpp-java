package io.github.zonnedev.ocpp.codec;

import java.util.Optional;

/**
 * Application-provided correlation storage. Implementations may use a database,
 * cache, or another durable store. Codec calls use the OCPP message ID as the
 * key. Implementations must be safe for their application's concurrency model.
 */
public interface OcppRequestRepository {
  void save(
    String messageId,
    OcppRequestContext context
  );
  Optional<OcppRequestContext> find(String messageId);
  Optional<OcppRequestContext> remove(String messageId);
}
