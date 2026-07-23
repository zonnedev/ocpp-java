package io.github.zonnedev.ocpp.codec;

import com.fasterxml.jackson.databind.JsonNode;
import io.github.zonnedev.ocpp.api.OcppActionDefinition;
import io.github.zonnedev.ocpp.api.OcppPayload;
import io.github.zonnedev.ocpp.api.OcppRequest;
import io.github.zonnedev.ocpp.api.OcppResponse;
import io.github.zonnedev.ocpp.api.OcppVersion;
import org.jspecify.annotations.Nullable;

public interface OcppMessageCodec {
  String encode(OcppFrame message);
  JsonNode encodeTree(OcppFrame message);
  String encodePayload(OcppPayload payload);
  JsonNode encodePayloadTree(OcppPayload payload);
  OcppRequestMessage<?> decodeRequest(
    OcppVersion version,
    String json
  );
  OcppRequestMessage<?> decodeRequest(
    OcppVersion version,
    JsonNode json
  );
  <Q extends OcppRequest, S extends OcppResponse> OcppResponseMessage<S> decodeResponse(
    OcppActionDefinition<Q, S> definition,
    String json
  );
  <Q extends OcppRequest, S extends OcppResponse> OcppResponseMessage<S> decodeResponse(
    OcppActionDefinition<Q, S> definition,
    JsonNode json
  );
  OcppResponseMessage<?> decodeResponse(String json);
  OcppResponseMessage<?> decodeResponse(JsonNode json);
  OcppErrorMessage decodeError(String json);
  OcppErrorMessage decodeError(JsonNode json);
  OcppFrame decode(
    OcppVersion version,
    String json,
    @Nullable OcppActionDefinition<?, ?> responseDefinition
  );
  OcppFrame decode(
    OcppVersion version,
    JsonNode json,
    @Nullable OcppActionDefinition<?, ?> responseDefinition
  );
  <Q extends OcppRequest, S extends OcppResponse> Q decodeRequestPayload(
    OcppActionDefinition<Q, S> definition,
    String json
  );
  <Q extends OcppRequest, S extends OcppResponse> Q decodeRequestPayload(
    OcppActionDefinition<Q, S> definition,
    JsonNode json
  );
  <Q extends OcppRequest, S extends OcppResponse> S decodeResponsePayload(
    OcppActionDefinition<Q, S> definition,
    String json
  );
  <Q extends OcppRequest, S extends OcppResponse> S decodeResponsePayload(
    OcppActionDefinition<Q, S> definition,
    JsonNode json
  );
}
