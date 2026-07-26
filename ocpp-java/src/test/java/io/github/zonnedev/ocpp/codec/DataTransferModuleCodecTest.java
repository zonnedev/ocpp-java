package io.github.zonnedev.ocpp.codec;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import io.github.zonnedev.ocpp.api.OcppVersion;
import io.github.zonnedev.ocpp.api.datatransfer.DataTransferModule;
import io.github.zonnedev.ocpp.api.datatransfer.DataTransferOperationDefinition;
import io.github.zonnedev.ocpp.api.datatransfer.DataTransferRequestPayload;
import io.github.zonnedev.ocpp.api.datatransfer.DataTransferResponsePayload;
import io.github.zonnedev.ocpp.api.datatransfer.Ocpp201DataTransferOperation;
import io.github.zonnedev.ocpp.extension.v16.iso15118.Ocpp16Iso15118DataTransferModule;
import io.github.zonnedev.ocpp.extension.v16.iso15118.Ocpp16Iso15118DataTransferModule.AuthorizeRequest;
import io.github.zonnedev.ocpp.extension.v16.iso15118.Ocpp16Iso15118DataTransferModule.AuthorizeResponse;
import io.github.zonnedev.ocpp.extension.v16.iso15118.Ocpp16Iso15118DataTransferModule.AuthorizationStatus;
import io.github.zonnedev.ocpp.extension.v16.iso15118.Ocpp16Iso15118DataTransferModule.CertificateAuthorizationStatus;
import io.github.zonnedev.ocpp.extension.v16.iso15118.Ocpp16Iso15118DataTransferModule.ExtendedTrigger;
import io.github.zonnedev.ocpp.extension.v16.iso15118.Ocpp16Iso15118DataTransferModule.ExtendedTriggerMessageRequest;
import io.github.zonnedev.ocpp.extension.v16.iso15118.Ocpp16Iso15118DataTransferModule.HashAlgorithm;
import io.github.zonnedev.ocpp.extension.v16.iso15118.Ocpp16Iso15118DataTransferModule.IdToken;
import io.github.zonnedev.ocpp.extension.v16.iso15118.Ocpp16Iso15118DataTransferModule.IdTokenInfo;
import io.github.zonnedev.ocpp.extension.v16.iso15118.Ocpp16Iso15118DataTransferModule.OcspRequestData;
import io.github.zonnedev.ocpp.v16.Ocpp16Actions;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DataTransferModuleCodecTest {
  private static final Ocpp201DataTransferOperation<Echo201Request, Echo201Response> ECHO_201 = Ocpp201DataTransferOperation
    .of(
      "dev.example",
      "Echo",
      Echo201Request.class,
      Echo201Response.class
    );

  @Test
  @DisplayName("The ISO 15118 module exposes every implemented v1.3 operation")
  void it_exposes_every_implemented_iso_15118_operation() {
    assertThat(
      Ocpp16Iso15118DataTransferModule.create()
        .operations()
    )
      .hasSize(9)
      .extracting(DataTransferOperationDefinition::messageId)
      .containsExactly(
        "Authorize",
        "CertificateSigned",
        "DeleteCertificate",
        "Get15118EVCertificate",
        "GetCertificateStatus",
        "GetInstalledCertificateIds",
        "InstallCertificate",
        "SignCertificate",
        "ExtendedTriggerMessage"
      )
      .doesNotContain("Update15118EVCertificate");
  }

  @Test
  @DisplayName("Registered OCPP 1.6 request data is exposed through the DataTransfer payload")
  void it_decodes_registered_ocpp_16_request_data_through_the_payload() {
    OcppRequestMessage<?> message = iso15118Codec().decodeRequest(
      OcppVersion.OCPP_1_6_JSON,
      authorizeRequestFrame("iso-1")
    );

    assertThat(message.payload())
      .isInstanceOf(io.github.zonnedev.ocpp.v16.model.DataTransferRequest.class);
    var transfer = (io.github.zonnedev.ocpp.v16.model.DataTransferRequest<?>) message.payload();
    AuthorizeRequest request = Ocpp16Iso15118DataTransferModule.AUTHORIZE.requestType()
      .cast(transfer.data());
    assertThat(
      request.idToken()
        .idToken()
    ).isEqualTo("DE-EMAID-1");
    assertThat(request.iso15118CertificateHashData()).hasSize(1);
  }

  @Test
  @DisplayName("The corrected SignV2GCertificate trigger round-trips")
  void it_round_trips_the_corrected_sign_v2g_certificate_trigger() {
    OcppMessageCodec codec = iso15118Codec();
    var payload = io.github.zonnedev.ocpp.v16.model.DataTransferRequest.of(
      ExtendedTriggerMessageRequest.of(ExtendedTrigger.SIGN_V2G_CERTIFICATE),
      "ExtendedTriggerMessage",
      Ocpp16Iso15118DataTransferModule.VENDOR_ID
    );

    String json = codec.encode(
      OcppRequestMessage.of(
        "trigger-1",
        Ocpp16Actions.dataTransfer(Ocpp16Iso15118DataTransferModule.EXTENDED_TRIGGER_MESSAGE),
        payload
      )
    );

    assertThat(json).contains("\\\"requestedMessage\\\":\\\"SignV2GCertificate\\\"");

    OcppRequestMessage<?> decoded = iso15118Codec().decodeRequest(
      OcppVersion.OCPP_1_6_JSON,
      json
    );
    var transfer = (io.github.zonnedev.ocpp.v16.model.DataTransferRequest<?>) decoded.payload();
    ExtendedTriggerMessageRequest request = Ocpp16Iso15118DataTransferModule.EXTENDED_TRIGGER_MESSAGE
      .requestType()
      .cast(transfer.data());
    assertThat(request.requestedMessage()).isEqualTo(ExtendedTrigger.SIGN_V2G_CERTIFICATE);
  }

  @Test
  @DisplayName("The misspelled SignV2GCertifcate trigger is rejected")
  void it_rejects_the_misspelled_sign_v2g_certificate_trigger() {
    assertThatThrownBy(
      () -> iso15118Codec().decodeRequest(
        OcppVersion.OCPP_1_6_JSON,
        "[2,\"trigger-typo\",\"DataTransfer\",{\"vendorId\":\"iso15118\",\"messageId\":\"ExtendedTriggerMessage\",\"data\":\"{\\\"requestedMessage\\\":\\\"SignV2GCertifcate\\\"}\"}]"
      )
    ).isInstanceOf(OcppDecodingException.class);
  }

  @Test
  @DisplayName("OCPP messages do not expose DataTransfer-specific frame metadata")
  void it_keeps_datatransfer_metadata_out_of_ocpp_message_wrappers() {
    assertThat(OcppRequestMessage.class.getRecordComponents())
      .extracting(component -> component.getName())
      .containsExactly(
        "messageId",
        "definition",
        "payload"
      );
    assertThat(OcppResponseMessage.class.getRecordComponents())
      .extracting(component -> component.getName())
      .containsExactly(
        "messageId",
        "definition",
        "payload"
      );
  }

  @Test
  @DisplayName("Typed OCPP 1.6 requests encode JSON inside the textual data property")
  void it_encodes_typed_ocpp_16_requests_as_textual_json_data() {
    OcppMessageCodec codec = iso15118Codec();
    var payload = io.github.zonnedev.ocpp.v16.model.DataTransferRequest.of(
      authorizeRequest(),
      "Authorize",
      Ocpp16Iso15118DataTransferModule.VENDOR_ID
    );

    String json = codec.encode(
      OcppRequestMessage.of(
        "iso-2",
        Ocpp16Actions.dataTransfer(Ocpp16Iso15118DataTransferModule.AUTHORIZE),
        payload
      )
    );

    assertThat(json).contains(
      "\"vendorId\":\"iso15118\"",
      "\"messageId\":\"Authorize\"",
      "\"data\":\"{\\\"idToken\\\""
    );
  }

  @Test
  @DisplayName("Typed OCPP 1.6 responses encode JSON inside the textual data property")
  void it_encodes_typed_ocpp_16_responses_as_textual_json_data() {
    OcppMessageCodec codec = iso15118Codec();
    var payload = io.github.zonnedev.ocpp.v16.model.DataTransferResponse.of(
      authorizeResponse(),
      io.github.zonnedev.ocpp.v16.model.DataTransferResponse.Status.ACCEPTED
    );

    String json = codec.encode(
      OcppResponseMessage.of(
        "iso-response-1",
        Ocpp16Actions.dataTransfer(Ocpp16Iso15118DataTransferModule.AUTHORIZE),
        payload
      )
    );

    assertThat(json).isEqualTo(
      "[3,\"iso-response-1\",{\"data\":\"{\\\"certificateStatus\\\":\\\"Accepted\\\",\\\"idTokenInfo\\\":{\\\"status\\\":\\\"Accepted\\\"}}\",\"status\":\"Accepted\"}]"
    );
  }

  @Test
  @DisplayName(
    "DataTransfer responses decode through the operation stored with their source request"
  )
  void it_decodes_responses_using_the_operation_stored_with_the_source_request() {
    OcppMessageCodec codec = iso15118Codec();
    codec.encode(
      OcppRequestMessage.of(
        "iso-3",
        Ocpp16Actions.dataTransfer(Ocpp16Iso15118DataTransferModule.AUTHORIZE),
        io.github.zonnedev.ocpp.v16.model.DataTransferRequest.of(
          authorizeRequest(),
          "Authorize",
          Ocpp16Iso15118DataTransferModule.VENDOR_ID
        )
      )
    );

    OcppResponseMessage<?> message = codec.decodeResponse(
      "[3,\"iso-3\",{\"status\":\"Accepted\",\"data\":\"{\\\"certificateStatus\\\":\\\"Accepted\\\",\\\"idTokenInfo\\\":{\\\"status\\\":\\\"Accepted\\\"}}\"}]"
    );

    assertThat(message.payload())
      .isInstanceOf(io.github.zonnedev.ocpp.v16.model.DataTransferResponse.class);
    var transfer = (io.github.zonnedev.ocpp.v16.model.DataTransferResponse<?>) message.payload();
    assertThat(
      Ocpp16Iso15118DataTransferModule.AUTHORIZE.responseType()
        .cast(transfer.data())
    ).isEqualTo(authorizeResponse());
  }

  @Test
  @DisplayName("OCPP 2.0.1 requests decode native JSON through their DataTransfer payload")
  void it_decodes_ocpp_201_native_json_through_the_payload() {
    OcppMessageCodec codec = codecWith(new TestDataTransferModule("echo-201", List.of(ECHO_201)));

    OcppRequestMessage<?> message = codec.decodeRequest(
      OcppVersion.OCPP_2_0_1,
      "[2,\"echo-1\",\"DataTransfer\",{\"vendorId\":\"dev.example\",\"messageId\":\"Echo\",\"data\":{\"text\":\"hello\"}}]"
    );

    var transfer = (io.github.zonnedev.ocpp.v201.model.DataTransferRequest<?>) message.payload();
    assertThat(
      ECHO_201.requestType()
        .cast(transfer.data())
    ).isEqualTo(Echo201Request.of("hello"));
  }

  @Test
  @DisplayName("OCPP 2.0.1 responses decode native JSON using request correlation")
  void it_decodes_ocpp_201_native_json_responses_using_request_correlation() {
    OcppMessageCodec codec = codecWith(new TestDataTransferModule("echo-201", List.of(ECHO_201)));
    codec.encode(
      OcppRequestMessage.of(
        "echo-2",
        io.github.zonnedev.ocpp.v201.Ocpp201Actions.dataTransfer(ECHO_201),
        io.github.zonnedev.ocpp.v201.model.DataTransferRequest.of(
          null,
          Echo201Request.of("hello"),
          "Echo",
          "dev.example"
        )
      )
    );

    OcppResponseMessage<?> message = codec.decodeResponse(
      "[3,\"echo-2\",{\"status\":\"Accepted\",\"data\":{\"text\":\"world\"}}]"
    );

    var transfer = (io.github.zonnedev.ocpp.v201.model.DataTransferResponse<?>) message.payload();
    assertThat(
      ECHO_201.responseType()
        .cast(transfer.data())
    ).isEqualTo(Echo201Response.of("world"));
  }

  @Test
  @DisplayName("Unknown DataTransfer vendors fail with structured decoding context")
  void it_rejects_unknown_datatransfer_vendors_with_structured_context() {
    assertThatThrownBy(
      () -> iso15118Codec().decodeRequest(
        OcppVersion.OCPP_1_6_JSON,
        "[2,\"unknown-1\",\"DataTransfer\",{\"vendorId\":\"other\",\"messageId\":\"Authorize\",\"data\":\"{}\"}]"
      )
    )
      .isInstanceOfSatisfying(
        UnknownDataTransferOperationException.class,
        exception -> {
          assertThat(exception.reason()).isEqualTo(
            UnknownDataTransferOperationException.Reason.UNKNOWN_VENDOR_ID
          );
          assertThat(exception.version()).isEqualTo(OcppVersion.OCPP_1_6_JSON);
          assertThat(exception.vendorId()).isEqualTo("other");
          assertThat(exception.messageId()).isEqualTo("Authorize");
        }
      );
  }

  @Test
  @DisplayName("Unknown DataTransfer message IDs fail with structured decoding context")
  void it_rejects_unknown_datatransfer_message_ids_with_structured_context() {
    assertThatThrownBy(
      () -> iso15118Codec().decodeRequest(
        OcppVersion.OCPP_1_6_JSON,
        "[2,\"unknown-2\",\"DataTransfer\",{\"vendorId\":\"iso15118\",\"messageId\":\"Missing\",\"data\":\"{}\"}]"
      )
    )
      .isInstanceOfSatisfying(
        UnknownDataTransferOperationException.class,
        exception -> assertThat(exception.reason()).isEqualTo(
          UnknownDataTransferOperationException.Reason.UNKNOWN_MESSAGE_ID
        )
      );
  }

  @Test
  @DisplayName("Missing DataTransfer message IDs fail with a structured reason")
  void it_rejects_missing_datatransfer_message_ids_with_a_structured_reason() {
    assertThatThrownBy(
      () -> iso15118Codec().decodeRequest(
        OcppVersion.OCPP_1_6_JSON,
        "[2,\"unknown-3\",\"DataTransfer\",{\"vendorId\":\"iso15118\",\"data\":\"{}\"}]"
      )
    )
      .isInstanceOfSatisfying(
        UnknownDataTransferOperationException.class,
        exception -> assertThat(exception.reason()).isEqualTo(
          UnknownDataTransferOperationException.Reason.MISSING_MESSAGE_ID
        )
      );
  }

  @Test
  @DisplayName("The default codec rejects every unregistered DataTransfer operation")
  void it_rejects_datatransfers_when_no_modules_are_registered() {
    assertThatThrownBy(
      () -> JacksonOcppMessageCodec.createDefault()
        .decodeRequest(
          OcppVersion.OCPP_1_6_JSON,
          authorizeRequestFrame("default-1")
        )
    ).isInstanceOf(UnknownDataTransferOperationException.class);
  }

  @Test
  @DisplayName("Registered DataTransfer requests reject missing data")
  void it_rejects_registered_datatransfer_requests_without_data() {
    assertThatThrownBy(
      () -> iso15118Codec().decodeRequest(
        OcppVersion.OCPP_1_6_JSON,
        "[2,\"missing-data\",\"DataTransfer\",{\"vendorId\":\"iso15118\",\"messageId\":\"Authorize\"}]"
      )
    )
      .isInstanceOf(OcppDecodingException.class)
      .hasMessageContaining("requires a data payload");
  }

  @Test
  @DisplayName("OCPP 1.6 registered DataTransfer requests reject non-textual data")
  void it_rejects_non_textual_ocpp_16_datatransfer_data() {
    assertThatThrownBy(
      () -> iso15118Codec().decodeRequest(
        OcppVersion.OCPP_1_6_JSON,
        "[2,\"invalid-data\",\"DataTransfer\",{\"vendorId\":\"iso15118\",\"messageId\":\"Authorize\",\"data\":{}}]"
      )
    )
      .isInstanceOf(OcppDecodingException.class)
      .hasMessageContaining("must be a JSON string");
  }

  @Test
  @DisplayName("Direct DataTransfer response decoding rejects missing source-operation metadata")
  void it_rejects_direct_datatransfer_response_decoding_without_source_metadata() {
    assertThatThrownBy(
      () -> iso15118Codec().decodeResponse(
        Ocpp16Actions.DATA_TRANSFER,
        "[3,\"direct-1\",{\"status\":\"Accepted\",\"data\":\"{}\"}]"
      )
    )
      .isInstanceOf(OcppDecodingException.class)
      .hasMessageContaining("stored source request");
  }

  @Test
  @DisplayName("Duplicate DataTransfer module names fail during registration")
  void it_rejects_duplicate_datatransfer_module_names() {
    var module = Ocpp16Iso15118DataTransferModule.create();

    assertThatThrownBy(
      () -> JacksonOcppMessageCodec.builder()
        .dataTransferModules(
          modules -> modules
            .register(module)
            .register(module)
        )
    )
      .isInstanceOf(IllegalArgumentException.class)
      .hasMessageContaining("Duplicate DataTransfer module");
  }

  @Test
  @DisplayName("Duplicate operation keys across modules fail during registration")
  void it_rejects_duplicate_datatransfer_operation_keys() {
    var first = new TestDataTransferModule("first", List.of(ECHO_201));
    var duplicate = Ocpp201DataTransferOperation.of(
      "dev.example",
      "Echo",
      AlternateEchoRequest.class,
      AlternateEchoResponse.class
    );

    assertThatThrownBy(
      () -> JacksonOcppMessageCodec.builder()
        .dataTransferModules(
          modules -> modules
            .register(first)
            .register(new TestDataTransferModule("second", List.of(duplicate)))
        )
    )
      .isInstanceOf(IllegalArgumentException.class)
      .hasMessageContaining("Duplicate DataTransfer operation");
  }

  @Test
  @DisplayName("A response class cannot be shared by two operations in one protocol version")
  void it_rejects_ambiguous_datatransfer_response_classes() {
    var duplicateResponse = Ocpp201DataTransferOperation.of(
      "dev.example",
      "OtherEcho",
      AlternateEchoRequest.class,
      Echo201Response.class
    );

    assertThatThrownBy(
      () -> codecWith(
        new TestDataTransferModule(
          "ambiguous",
          List.of(
            ECHO_201,
            duplicateResponse
          )
        )
      )
    )
      .isInstanceOf(IllegalArgumentException.class)
      .hasMessageContaining("response type is already registered");
  }

  @Test
  @DisplayName("Empty DataTransfer modules fail during registration")
  void it_rejects_empty_datatransfer_modules() {
    assertThatThrownBy(
      () -> codecWith(new TestDataTransferModule("empty", List.of()))
    )
      .isInstanceOf(IllegalArgumentException.class)
      .hasMessageContaining("at least one operation");
  }

  @Test
  @DisplayName("Payload-only OCPP 1.6 encoding retains textual JSON DataTransfer semantics")
  void it_encodes_ocpp_16_datatransfer_payloads_as_textual_json() {
    OcppMessageCodec codec = iso15118Codec();
    var transfer = io.github.zonnedev.ocpp.v16.model.DataTransferRequest.of(
      authorizeRequest(),
      "Authorize",
      "iso15118"
    );

    JsonNodeAssertions.assertTextualData(codec.encodePayloadTree(transfer));
  }

  @Test
  @DisplayName("Payload-only OCPP 2.0.1 encoding retains native JSON DataTransfer semantics")
  void it_encodes_ocpp_201_datatransfer_payloads_as_native_json() {
    OcppMessageCodec codec = codecWith(new TestDataTransferModule("echo-201", List.of(ECHO_201)));
    var transfer = io.github.zonnedev.ocpp.v201.model.DataTransferRequest.of(
      null,
      Echo201Request.of("hello"),
      "Echo",
      "dev.example"
    );

    var tree = codec.encodePayloadTree(transfer);
    assertThat(
      tree.get("data")
        .isObject()
    ).isTrue();
    assertThat(
      tree.path("data")
        .path("text")
        .textValue()
    ).isEqualTo("hello");
  }

  @Test
  @DisplayName("Encoding an unregistered DataTransfer request fails strictly")
  void it_rejects_encoding_unregistered_datatransfer_requests() {
    var transfer = io.github.zonnedev.ocpp.v201.model.DataTransferRequest.of(
      null,
      Echo201Request.of("hello"),
      "Echo",
      "dev.example"
    );

    assertThatThrownBy(
      () -> JacksonOcppMessageCodec.createDefault()
        .encodePayload(transfer)
    )
      .isInstanceOf(OcppEncodingException.class)
      .hasMessageContaining("not registered");
  }

  @Test
  @DisplayName("Encoding an unregistered DataTransfer response type fails strictly")
  void it_rejects_encoding_unregistered_datatransfer_response_types() {
    var transfer = io.github.zonnedev.ocpp.v201.model.DataTransferResponse.of(
      null,
      Echo201Response.of("world"),
      io.github.zonnedev.ocpp.v201.model.DataTransferResponse.DataTransferStatusEnum.ACCEPTED,
      null
    );

    assertThatThrownBy(
      () -> JacksonOcppMessageCodec.createDefault()
        .encodePayload(transfer)
    )
      .isInstanceOf(OcppEncodingException.class)
      .hasMessageContaining("No registered DataTransfer operation");
  }

  @Test
  @DisplayName("Malformed embedded OCPP 1.6 DataTransfer JSON fails decoding")
  void it_rejects_malformed_embedded_ocpp_16_json() {
    assertThatThrownBy(
      () -> iso15118Codec().decodeRequest(
        OcppVersion.OCPP_1_6_JSON,
        "[2,\"bad-json\",\"DataTransfer\",{\"vendorId\":\"iso15118\",\"messageId\":\"Authorize\",\"data\":\"{bad}\"}]"
      )
    )
      .isInstanceOf(OcppDecodingException.class)
      .hasMessageContaining("Malformed JSON");
  }

  @Test
  @DisplayName("Registered DataTransfer responses reject missing data after correlation")
  void it_rejects_correlated_datatransfer_responses_without_data() {
    OcppMessageCodec codec = iso15118Codec();
    codec.encode(
      OcppRequestMessage.of(
        "missing-response-data",
        Ocpp16Actions.dataTransfer(Ocpp16Iso15118DataTransferModule.AUTHORIZE),
        io.github.zonnedev.ocpp.v16.model.DataTransferRequest.of(
          authorizeRequest(),
          "Authorize",
          "iso15118"
        )
      )
    );

    assertThatThrownBy(
      () -> codec.decodeResponse(
        "[3,\"missing-response-data\",{\"status\":\"Accepted\"}]"
      )
    )
      .isInstanceOf(OcppDecodingException.class)
      .hasMessageContaining("requires a data payload");
  }

  @Test
  @DisplayName("Version-specific typed action metadata rejects operations from another protocol")
  void it_rejects_datatransfer_operations_from_the_wrong_protocol_version() {
    assertThatThrownBy(
      () -> Ocpp16Actions.dataTransfer(ECHO_201)
    )
      .isInstanceOf(IllegalArgumentException.class)
      .hasMessageContaining("not an OCPP 1.6");
  }

  @Test
  @DisplayName("Every ISO 15118 operation uses directional payload marker types")
  void it_exposes_directionally_typed_iso_15118_payload_classes() {
    assertThat(
      Ocpp16Iso15118DataTransferModule.create()
        .operations()
    ).allSatisfy(
      operation -> {
        assertThat(DataTransferRequestPayload.class).isAssignableFrom(operation.requestType());
        assertThat(DataTransferResponsePayload.class).isAssignableFrom(operation.responseType());
        assertThat(operation.version()).isEqualTo(OcppVersion.OCPP_1_6_JSON);
        assertThat(operation.vendorId()).isEqualTo("iso15118");
      }
    );
  }

  @Test
  @DisplayName("Unknown-operation reasons map to OCPP 1.6 DataTransfer response factories")
  void it_maps_unknown_operation_reasons_to_ocpp_16_response_factories() {
    var unknownVendor = io.github.zonnedev.ocpp.v16.model.DataTransferResponse
      .<AuthorizeResponse>unknownVendorId();
    var unknownMessage = io.github.zonnedev.ocpp.v16.model.DataTransferResponse
      .<AuthorizeResponse>unknownMessageId();

    assertThat(unknownVendor.status()).isEqualTo(
      io.github.zonnedev.ocpp.v16.model.DataTransferResponse.Status.UNKNOWN_VENDOR_ID
    );
    assertThat(unknownMessage.status()).isEqualTo(
      io.github.zonnedev.ocpp.v16.model.DataTransferResponse.Status.UNKNOWN_MESSAGE_ID
    );
    assertThat(unknownVendor.data()).isNull();
    assertThat(unknownMessage.data()).isNull();
  }

  @Test
  @DisplayName("Unknown-operation responses encode without registering the rejected operation")
  void it_encodes_unknown_operation_responses_without_a_registered_operation() {
    var response = io.github.zonnedev.ocpp.v16.model.DataTransferResponse
      .<AuthorizeResponse>unknownVendorId();

    String json = JacksonOcppMessageCodec.createDefault()
      .encode(
        OcppResponseMessage.of(
          "unknown-response",
          Ocpp16Actions.dataTransfer(Ocpp16Iso15118DataTransferModule.AUTHORIZE),
          response
        )
      );

    assertThat(json).isEqualTo(
      "[3,\"unknown-response\",{\"status\":\"UnknownVendorId\"}]"
    );
  }

  private static OcppMessageCodec iso15118Codec() {
    return codecWith(Ocpp16Iso15118DataTransferModule.create());
  }

  private static OcppMessageCodec codecWith(DataTransferModule module) {
    return JacksonOcppMessageCodec.builder()
      .dataTransferModules(modules -> modules.register(module))
      .build();
  }

  private static AuthorizeRequest authorizeRequest() {
    return AuthorizeRequest.of(
      IdToken.of("DE-EMAID-1"),
      List.of(
        OcspRequestData.of(
          HashAlgorithm.SHA256,
          "name",
          "key",
          "42"
        )
      )
    );
  }

  private static AuthorizeResponse authorizeResponse() {
    return AuthorizeResponse.of(
      CertificateAuthorizationStatus.ACCEPTED,
      IdTokenInfo.of(AuthorizationStatus.ACCEPTED)
    );
  }

  private static String authorizeRequestFrame(String messageId) {
    return "[2,\"" + messageId
      + "\",\"DataTransfer\",{\"vendorId\":\"iso15118\",\"messageId\":\"Authorize\",\"data\":\"{\\\"idToken\\\":{\\\"idToken\\\":\\\"DE-EMAID-1\\\",\\\"type\\\":\\\"eMAID\\\"},\\\"15118CertificateHashData\\\":[{\\\"hashAlgorithm\\\":\\\"SHA256\\\",\\\"issuerNameHash\\\":\\\"name\\\",\\\"issuerKeyHash\\\":\\\"key\\\",\\\"serialNumber\\\":\\\"42\\\"}]}\"}]";
  }

  private record Echo201Request(String text) implements DataTransferRequestPayload {
    private Echo201Request {
      if (text == null) {
        throw new IllegalArgumentException("text is required");
      }
    }

    private static Echo201Request of(String text) {
      return new Echo201Request(text);
    }
  }

  private record Echo201Response(String text) implements DataTransferResponsePayload {
    private static Echo201Response of(String text) {
      return new Echo201Response(text);
    }
  }

  private record AlternateEchoRequest(String text) implements DataTransferRequestPayload {
  }

  private record AlternateEchoResponse(String text) implements DataTransferResponsePayload {
  }

  private record TestDataTransferModule(
    String name,
    List<DataTransferOperationDefinition<?, ?>> operations
  ) implements DataTransferModule {
    private TestDataTransferModule {
      operations = List.copyOf(operations);
    }
  }

  private static final class JsonNodeAssertions {
    private JsonNodeAssertions() {
    }

    private static void assertTextualData(com.fasterxml.jackson.databind.JsonNode tree) {
      assertThat(
        tree.get("data")
          .isTextual()
      ).isTrue();
      assertThat(
        tree.get("data")
          .textValue()
      ).contains("\"idToken\"");
    }
  }
}
