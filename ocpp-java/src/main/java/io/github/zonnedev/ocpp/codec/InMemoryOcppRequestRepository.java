package io.github.zonnedev.ocpp.codec;

import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * Thread-safe, process-local correlation storage. Entries are removed when a
 * response or error is decoded.
 */
public final class InMemoryOcppRequestRepository implements OcppRequestRepository {
  private final ConcurrentMap<String, OcppRequestContext> entries = new ConcurrentHashMap<>();

  public InMemoryOcppRequestRepository() {
  }

  public static InMemoryOcppRequestRepository create() {
    return new InMemoryOcppRequestRepository();
  }
  @Override
  public void save(
    String id,
    OcppRequestContext context
  ) {
    Objects.requireNonNull(
      id,
      "id"
    );
    Objects.requireNonNull(
      context,
      "context"
    );
    if (entries.putIfAbsent(
      id,
      context
    ) != null) {
      throw new IllegalStateException("Duplicate OCPP message ID: " + id);
    }
  }
  @Override
  public Optional<OcppRequestContext> find(String id) {
    return Optional.ofNullable(entries.get(id));
  }
  @Override
  public Optional<OcppRequestContext> remove(String id) {
    return Optional.ofNullable(entries.remove(id));
  }
}
