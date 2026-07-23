package io.github.zonnedev.ocpp.codec;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import com.fasterxml.jackson.databind.JsonNode;
import io.github.zonnedev.ocpp.api.OcppVersion;
import io.github.zonnedev.ocpp.v16.Ocpp16Actions;
import io.github.zonnedev.ocpp.v16.model.HeartbeatRequest;
import io.github.zonnedev.ocpp.v16.model.HeartbeatResponse;
import java.time.Instant;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class JacksonOcppMessageCodecTest {
  private final OcppMessageCodec codec = JacksonOcppMessageCodec.createDefault();

  @Test
  @DisplayName("Request frames round-trip with the exact OCPP wire shape")
  void it_encodes_and_decodes_request_frames_with_the_exact_wire_shape() {
    var message = OcppRequestMessage.of(
      "m-1",
      Ocpp16Actions.HEARTBEAT,
      HeartbeatRequest.of()
    );
    String json = codec.encode(message);

    assertThat(json).isEqualTo("[2,\"m-1\",\"Heartbeat\",{}]");
    var decoded = codec.decodeRequest(
      OcppVersion.OCPP_1_6_JSON,
      json
    );
    assertThat(decoded.messageId()).isEqualTo("m-1");
    assertThat(decoded.payload()).isEqualTo(HeartbeatRequest.of());
  }

  @Test
  @DisplayName("Responses are decoded using their stored source requests")
  void it_decodes_responses_using_the_stored_source_request() {
    codec.encode(
      OcppRequestMessage.of(
        "m-2",
        Ocpp16Actions.HEARTBEAT,
        HeartbeatRequest.of()
      )
    );
    Instant now = Instant.parse("2026-07-22T10:15:30Z");

    OcppResponseMessage<?> decoded = codec.decodeResponse(
      "[3,\"m-2\",{\"currentTime\":\"2026-07-22T10:15:30Z\"}]"
    );

    assertThat(decoded.payload()).isEqualTo(HeartbeatResponse.of(now));
    assertThatThrownBy(
      () -> codec.decodeResponse("[3,\"m-2\",{\"currentTime\":\"2026-07-22T10:15:30Z\"}]")
    )
      .isInstanceOf(OcppDecodingException.class)
      .hasMessageContaining("No source request");
  }

  @Test
  @DisplayName("Error frames preserve JSON details and clear request correlation")
  void it_preserves_error_details_and_clears_request_correlation() {
    codec.encode(
      OcppRequestMessage.of(
        "m-3",
        Ocpp16Actions.HEARTBEAT,
        HeartbeatRequest.of()
      )
    );
    OcppErrorMessage decoded = codec.decodeError(
      "[4,\"m-3\",\"FormationViolation\",\"Invalid payload\",{\"property\":\"idTag\"}]"
    );

    assertThat(
      decoded.error()
        .code()
    ).isEqualTo(OcppErrorCode.FORMATION_VIOLATION);
    assertThat(
      decoded.error()
        .details()
    ).containsEntry(
      "property",
      JsonNodeFactoryHolder.text("idTag")
    );
  }

  @Test
  @DisplayName("Malformed OCPP frames fail strict decoding")
  void it_rejects_malformed_ocpp_frames_strictly() {
    assertThatThrownBy(
      () -> codec.decodeRequest(
        OcppVersion.OCPP_1_6_JSON,
        "{}"
      )
    )
      .isInstanceOf(OcppDecodingException.class)
      .hasMessageContaining("array");
    assertThatThrownBy(
      () -> codec.decodeRequest(
        OcppVersion.OCPP_1_6_JSON,
        "[2,\"id\",\"NoSuchAction\",{}]"
      )
    )
      .isInstanceOf(OcppDecodingException.class);
    assertThatThrownBy(() -> codec.decodeError("[4,\"id\",\"Unknown\",\"bad\",{}]"))
      .isInstanceOf(
        OcppDecodingException.class
      );
  }

  private static final class JsonNodeFactoryHolder {
    private static JsonNode text(String value) {
      return com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.textNode(value);
    }
  }
}
