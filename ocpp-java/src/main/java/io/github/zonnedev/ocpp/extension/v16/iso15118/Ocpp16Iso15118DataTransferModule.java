package io.github.zonnedev.ocpp.extension.v16.iso15118;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.zonnedev.ocpp.api.datatransfer.DataTransferModule;
import io.github.zonnedev.ocpp.api.datatransfer.DataTransferOperationDefinition;
import io.github.zonnedev.ocpp.api.datatransfer.DataTransferRequestPayload;
import io.github.zonnedev.ocpp.api.datatransfer.DataTransferResponsePayload;
import io.github.zonnedev.ocpp.api.datatransfer.Ocpp16DataTransferOperation;
import java.time.Instant;
import java.util.List;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * DataTransfer module defined by has-to-be's “OCPP 1.6 - ISO 15118 Extension”,
 * version 1.3. The extension uses vendor ID {@value #VENDOR_ID} and JSON
 * serialized into OCPP 1.6's textual {@code data} property.
 */
public final class Ocpp16Iso15118DataTransferModule implements DataTransferModule {
  public static final String VENDOR_ID = "iso15118";

  public static final Ocpp16DataTransferOperation<AuthorizeRequest, AuthorizeResponse> AUTHORIZE = operation(
    "Authorize",
    AuthorizeRequest.class,
    AuthorizeResponse.class
  );
  public static final Ocpp16DataTransferOperation<CertificateSignedRequest, CertificateSignedResponse> CERTIFICATE_SIGNED = operation(
    "CertificateSigned",
    CertificateSignedRequest.class,
    CertificateSignedResponse.class
  );
  public static final Ocpp16DataTransferOperation<DeleteCertificateRequest, DeleteCertificateResponse> DELETE_CERTIFICATE = operation(
    "DeleteCertificate",
    DeleteCertificateRequest.class,
    DeleteCertificateResponse.class
  );
  public static final Ocpp16DataTransferOperation<Get15118EVCertificateRequest, Get15118EVCertificateResponse> GET15118_EV_CERTIFICATE = operation(
    "Get15118EVCertificate",
    Get15118EVCertificateRequest.class,
    Get15118EVCertificateResponse.class
  );
  public static final Ocpp16DataTransferOperation<GetCertificateStatusRequest, GetCertificateStatusResponse> GET_CERTIFICATE_STATUS = operation(
    "GetCertificateStatus",
    GetCertificateStatusRequest.class,
    GetCertificateStatusResponse.class
  );
  public static final Ocpp16DataTransferOperation<GetInstalledCertificateIdsRequest, GetInstalledCertificateIdsResponse> GET_INSTALLED_CERTIFICATE_IDS = operation(
    "GetInstalledCertificateIds",
    GetInstalledCertificateIdsRequest.class,
    GetInstalledCertificateIdsResponse.class
  );
  public static final Ocpp16DataTransferOperation<InstallCertificateRequest, InstallCertificateResponse> INSTALL_CERTIFICATE = operation(
    "InstallCertificate",
    InstallCertificateRequest.class,
    InstallCertificateResponse.class
  );
  public static final Ocpp16DataTransferOperation<SignCertificateRequest, SignCertificateResponse> SIGN_CERTIFICATE = operation(
    "SignCertificate",
    SignCertificateRequest.class,
    SignCertificateResponse.class
  );
  public static final Ocpp16DataTransferOperation<ExtendedTriggerMessageRequest, ExtendedTriggerMessageResponse> EXTENDED_TRIGGER_MESSAGE = operation(
    "ExtendedTriggerMessage",
    ExtendedTriggerMessageRequest.class,
    ExtendedTriggerMessageResponse.class
  );

  private static final List<DataTransferOperationDefinition<?, ?>> OPERATIONS = List.of(
    AUTHORIZE,
    CERTIFICATE_SIGNED,
    DELETE_CERTIFICATE,
    GET15118_EV_CERTIFICATE,
    GET_CERTIFICATE_STATUS,
    GET_INSTALLED_CERTIFICATE_IDS,
    INSTALL_CERTIFICATE,
    SIGN_CERTIFICATE,
    EXTENDED_TRIGGER_MESSAGE
  );

  public Ocpp16Iso15118DataTransferModule() {
  }

  public static Ocpp16Iso15118DataTransferModule create() {
    return new Ocpp16Iso15118DataTransferModule();
  }

  @Override
  public String name() {
    return "has-to-be-ocpp16-iso15118-v1.3";
  }

  @Override
  public List<DataTransferOperationDefinition<?, ?>> operations() {
    return OPERATIONS;
  }

  private static <Q extends DataTransferRequestPayload, S extends DataTransferResponsePayload> Ocpp16DataTransferOperation<Q, S> operation(
    String messageId,
    Class<Q> requestType,
    Class<S> responseType
  ) {
    return Ocpp16DataTransferOperation.of(
      VENDOR_ID,
      messageId,
      requestType,
      responseType
    );
  }

  public record AuthorizeRequest(
    IdToken idToken,
    @JsonProperty("15118CertificateHashData") List<OcspRequestData> iso15118CertificateHashData
  ) implements DataTransferRequestPayload {
    public AuthorizeRequest {
      Objects.requireNonNull(
        idToken,
        "idToken"
      );
      iso15118CertificateHashData = List.copyOf(
        Objects.requireNonNull(
          iso15118CertificateHashData,
          "iso15118CertificateHashData"
        )
      );
      requireSize(
        iso15118CertificateHashData,
        1,
        4,
        "iso15118CertificateHashData"
      );
    }

    public static AuthorizeRequest of(
      IdToken idToken,
      List<OcspRequestData> certificateHashData
    ) {
      return new AuthorizeRequest(
        idToken,
        certificateHashData
      );
    }
  }

  public record AuthorizeResponse(
    CertificateAuthorizationStatus certificateStatus,
    IdTokenInfo idTokenInfo
  ) implements DataTransferResponsePayload {
    public AuthorizeResponse {
      Objects.requireNonNull(
        certificateStatus,
        "certificateStatus"
      );
      Objects.requireNonNull(
        idTokenInfo,
        "idTokenInfo"
      );
    }

    public static AuthorizeResponse of(
      CertificateAuthorizationStatus certificateStatus,
      IdTokenInfo idTokenInfo
    ) {
      return new AuthorizeResponse(
        certificateStatus,
        idTokenInfo
      );
    }
  }

  public record CertificateSignedRequest(
    String cert,
    @Nullable CertificateSigningUse typeOfCertificate
  ) implements DataTransferRequestPayload {
    public CertificateSignedRequest {
      requireMaximumLength(
        cert,
        800,
        "cert"
      );
    }

    public static CertificateSignedRequest of(String cert) {
      return new CertificateSignedRequest(
        cert,
        null
      );
    }

    public static CertificateSignedRequest of(
      String cert,
      @Nullable CertificateSigningUse typeOfCertificate
    ) {
      return new CertificateSignedRequest(
        cert,
        typeOfCertificate
      );
    }
  }

  public record CertificateSignedResponse(AcceptedRejectedStatus status)
    implements
      DataTransferResponsePayload {
    public CertificateSignedResponse {
      Objects.requireNonNull(
        status,
        "status"
      );
    }

    public static CertificateSignedResponse of(AcceptedRejectedStatus status) {
      return new CertificateSignedResponse(status);
    }
  }

  public record DeleteCertificateRequest(CertificateHashData certificateHashData)
    implements
      DataTransferRequestPayload {
    public DeleteCertificateRequest {
      Objects.requireNonNull(
        certificateHashData,
        "certificateHashData"
      );
    }

    public static DeleteCertificateRequest of(CertificateHashData certificateHashData) {
      return new DeleteCertificateRequest(certificateHashData);
    }
  }

  public record DeleteCertificateResponse(DeleteCertificateStatus status)
    implements
      DataTransferResponsePayload {
    public DeleteCertificateResponse {
      Objects.requireNonNull(
        status,
        "status"
      );
    }

    public static DeleteCertificateResponse of(DeleteCertificateStatus status) {
      return new DeleteCertificateResponse(status);
    }
  }

  public record Get15118EVCertificateRequest(
    @JsonProperty("15118SchemaVersion") String iso15118SchemaVersion,
    String exiRequest
  ) implements DataTransferRequestPayload {
    public Get15118EVCertificateRequest {
      requireMaximumLength(
        iso15118SchemaVersion,
        50,
        "iso15118SchemaVersion"
      );
      requireMaximumLength(
        exiRequest,
        5500,
        "exiRequest"
      );
    }

    public static Get15118EVCertificateRequest of(
      String iso15118SchemaVersion,
      String exiRequest
    ) {
      return new Get15118EVCertificateRequest(
        iso15118SchemaVersion,
        exiRequest
      );
    }
  }

  public record Get15118EVCertificateResponse(
    CertificateProcessingStatus status,
    String exiResponse,
    CertificateChain contractSignatureCertificateChain,
    CertificateChain saProvisioningCertificateChain
  ) implements DataTransferResponsePayload {
    public Get15118EVCertificateResponse {
      Objects.requireNonNull(
        status,
        "status"
      );
      requireMaximumLength(
        exiResponse,
        5500,
        "exiResponse"
      );
      Objects.requireNonNull(
        contractSignatureCertificateChain,
        "contractSignatureCertificateChain"
      );
      Objects.requireNonNull(
        saProvisioningCertificateChain,
        "saProvisioningCertificateChain"
      );
    }

    public static Get15118EVCertificateResponse of(
      CertificateProcessingStatus status,
      String exiResponse,
      CertificateChain contractSignatureCertificateChain,
      CertificateChain saProvisioningCertificateChain
    ) {
      return new Get15118EVCertificateResponse(
        status,
        exiResponse,
        contractSignatureCertificateChain,
        saProvisioningCertificateChain
      );
    }
  }

  public record GetCertificateStatusRequest(OcspRequestData ocspRequestData)
    implements
      DataTransferRequestPayload {
    public GetCertificateStatusRequest {
      Objects.requireNonNull(
        ocspRequestData,
        "ocspRequestData"
      );
    }

    public static GetCertificateStatusRequest of(OcspRequestData ocspRequestData) {
      return new GetCertificateStatusRequest(ocspRequestData);
    }
  }

  public record GetCertificateStatusResponse(
    AcceptedRejectedStatus status,
    @Nullable String ocspResult
  ) implements DataTransferResponsePayload {
    public GetCertificateStatusResponse {
      Objects.requireNonNull(
        status,
        "status"
      );
      if (ocspResult != null && ocspResult.length() > 5500) {
        throw new IllegalArgumentException("ocspResult length must not exceed 5500");
      }
    }

    public static GetCertificateStatusResponse of(AcceptedRejectedStatus status) {
      return new GetCertificateStatusResponse(
        status,
        null
      );
    }

    public static GetCertificateStatusResponse of(
      AcceptedRejectedStatus status,
      @Nullable String ocspResult
    ) {
      return new GetCertificateStatusResponse(
        status,
        ocspResult
      );
    }
  }

  public record GetInstalledCertificateIdsRequest(CertificateUse typeOfCertificate)
    implements
      DataTransferRequestPayload {
    public GetInstalledCertificateIdsRequest {
      Objects.requireNonNull(
        typeOfCertificate,
        "typeOfCertificate"
      );
    }

    public static GetInstalledCertificateIdsRequest of(CertificateUse typeOfCertificate) {
      return new GetInstalledCertificateIdsRequest(typeOfCertificate);
    }
  }

  public record GetInstalledCertificateIdsResponse(
    InstalledCertificateStatus status,
    List<CertificateHashData> certificateHashData
  ) implements DataTransferResponsePayload {
    public GetInstalledCertificateIdsResponse {
      Objects.requireNonNull(
        status,
        "status"
      );
      certificateHashData = List.copyOf(
        Objects.requireNonNull(
          certificateHashData,
          "certificateHashData"
        )
      );
    }

    public static GetInstalledCertificateIdsResponse of(
      InstalledCertificateStatus status,
      List<CertificateHashData> certificateHashData
    ) {
      return new GetInstalledCertificateIdsResponse(
        status,
        certificateHashData
      );
    }
  }

  public record InstallCertificateRequest(
    CertificateUse certificateType,
    String certificate
  ) implements DataTransferRequestPayload {
    public InstallCertificateRequest {
      Objects.requireNonNull(
        certificateType,
        "certificateType"
      );
      requireMaximumLength(
        certificate,
        800,
        "certificate"
      );
    }

    public static InstallCertificateRequest of(
      CertificateUse certificateType,
      String certificate
    ) {
      return new InstallCertificateRequest(
        certificateType,
        certificate
      );
    }
  }

  public record InstallCertificateResponse(CertificateInstallationStatus status)
    implements
      DataTransferResponsePayload {
    public InstallCertificateResponse {
      Objects.requireNonNull(
        status,
        "status"
      );
    }

    public static InstallCertificateResponse of(CertificateInstallationStatus status) {
      return new InstallCertificateResponse(status);
    }
  }

  public record SignCertificateRequest(
    String csr,
    @Nullable CertificateSigningUse typeOfCertificate
  ) implements DataTransferRequestPayload {
    public SignCertificateRequest {
      requireMaximumLength(
        csr,
        800,
        "csr"
      );
    }

    public static SignCertificateRequest of(String csr) {
      return new SignCertificateRequest(
        csr,
        null
      );
    }

    public static SignCertificateRequest of(
      String csr,
      @Nullable CertificateSigningUse typeOfCertificate
    ) {
      return new SignCertificateRequest(
        csr,
        typeOfCertificate
      );
    }
  }

  public record SignCertificateResponse(AcceptedRejectedStatus status)
    implements
      DataTransferResponsePayload {
    public SignCertificateResponse {
      Objects.requireNonNull(
        status,
        "status"
      );
    }

    public static SignCertificateResponse of(AcceptedRejectedStatus status) {
      return new SignCertificateResponse(status);
    }
  }

  public record ExtendedTriggerMessageRequest(ExtendedTrigger requestedMessage)
    implements
      DataTransferRequestPayload {
    public ExtendedTriggerMessageRequest {
      Objects.requireNonNull(
        requestedMessage,
        "requestedMessage"
      );
    }

    public static ExtendedTriggerMessageRequest of(ExtendedTrigger requestedMessage) {
      return new ExtendedTriggerMessageRequest(requestedMessage);
    }
  }

  public record ExtendedTriggerMessageResponse(ExtendedTriggerStatus status)
    implements
      DataTransferResponsePayload {
    public ExtendedTriggerMessageResponse {
      Objects.requireNonNull(
        status,
        "status"
      );
    }

    public static ExtendedTriggerMessageResponse of(ExtendedTriggerStatus status) {
      return new ExtendedTriggerMessageResponse(status);
    }
  }

  public record IdToken(
    String idToken,
    IdTokenType type
  ) {
    public IdToken {
      Objects.requireNonNull(
        idToken,
        "idToken"
      );
      Objects.requireNonNull(
        type,
        "type"
      );
    }

    public static IdToken of(String idToken) {
      return new IdToken(
        idToken,
        IdTokenType.EMAID
      );
    }
  }

  public record IdTokenInfo(
    AuthorizationStatus status,
    @Nullable Instant cacheExpiryDateTime
  ) {
    public IdTokenInfo {
      Objects.requireNonNull(
        status,
        "status"
      );
    }

    public static IdTokenInfo of(AuthorizationStatus status) {
      return new IdTokenInfo(
        status,
        null
      );
    }

    public static IdTokenInfo of(
      AuthorizationStatus status,
      @Nullable Instant cacheExpiryDateTime
    ) {
      return new IdTokenInfo(
        status,
        cacheExpiryDateTime
      );
    }
  }

  public record CertificateHashData(
    HashAlgorithm hashAlgorithm,
    String issuerNameHash,
    String issuerKeyHash,
    String serialNumber
  ) {
    public CertificateHashData {
      Objects.requireNonNull(
        hashAlgorithm,
        "hashAlgorithm"
      );
      requireText(
        issuerNameHash,
        "issuerNameHash"
      );
      requireText(
        issuerKeyHash,
        "issuerKeyHash"
      );
      requireText(
        serialNumber,
        "serialNumber"
      );
    }

    public static CertificateHashData of(
      HashAlgorithm hashAlgorithm,
      String issuerNameHash,
      String issuerKeyHash,
      String serialNumber
    ) {
      return new CertificateHashData(
        hashAlgorithm,
        issuerNameHash,
        issuerKeyHash,
        serialNumber
      );
    }
  }

  public record OcspRequestData(
    HashAlgorithm hashAlgorithm,
    String issuerNameHash,
    String issuerKeyHash,
    String serialNumber,
    @Nullable String responderURL
  ) {
    public OcspRequestData {
      Objects.requireNonNull(
        hashAlgorithm,
        "hashAlgorithm"
      );
      requireText(
        issuerNameHash,
        "issuerNameHash"
      );
      requireText(
        issuerKeyHash,
        "issuerKeyHash"
      );
      requireText(
        serialNumber,
        "serialNumber"
      );
    }

    public static OcspRequestData of(
      HashAlgorithm hashAlgorithm,
      String issuerNameHash,
      String issuerKeyHash,
      String serialNumber
    ) {
      return new OcspRequestData(
        hashAlgorithm,
        issuerNameHash,
        issuerKeyHash,
        serialNumber,
        null
      );
    }

    public static OcspRequestData of(
      HashAlgorithm hashAlgorithm,
      String issuerNameHash,
      String issuerKeyHash,
      String serialNumber,
      @Nullable String responderURL
    ) {
      return new OcspRequestData(
        hashAlgorithm,
        issuerNameHash,
        issuerKeyHash,
        serialNumber,
        responderURL
      );
    }
  }

  public record CertificateChain(
    String certificate,
    String childCertificate
  ) {
    public CertificateChain {
      requireText(
        certificate,
        "certificate"
      );
      requireText(
        childCertificate,
        "childCertificate"
      );
    }

    public static CertificateChain of(
      String certificate,
      String childCertificate
    ) {
      return new CertificateChain(
        certificate,
        childCertificate
      );
    }
  }

  public enum HashAlgorithm {
    @JsonProperty("SHA256")
    SHA256, @JsonProperty("SHA384")
    SHA384, @JsonProperty("SHA512")
    SHA512
  }

  public enum IdTokenType {
    @JsonProperty("eMAID")
    EMAID
  }

  public enum CertificateAuthorizationStatus {
    @JsonProperty("Accepted")
    ACCEPTED, @JsonProperty("CertificateRevoked")
    CERTIFICATE_REVOKED
  }

  public enum AuthorizationStatus {
    @JsonProperty("Accepted")
    ACCEPTED, @JsonProperty("Blocked")
    BLOCKED, @JsonProperty("ConcurrentTx")
    CONCURRENT_TX, @JsonProperty("Expired")
    EXPIRED, @JsonProperty("Invalid")
    INVALID, @JsonProperty("NoCredit")
    NO_CREDIT, @JsonProperty("NotAllowedTypeEVSE")
    NOT_ALLOWED_TYPE_EVSE, @JsonProperty("NotAtThisLocation")
    NOT_AT_THIS_LOCATION, @JsonProperty("NotAtThisTime")
    NOT_AT_THIS_TIME, @JsonProperty("Unknown")
    UNKNOWN
  }

  public enum CertificateSigningUse {
    @JsonProperty("ChargingStationCertificate")
    CHARGING_STATION_CERTIFICATE, @JsonProperty("V2GCertificate")
    V2G_CERTIFICATE
  }

  public enum CertificateUse {
    @JsonProperty("V2GRootCertificate")
    V2G_ROOT_CERTIFICATE, @JsonProperty("MORootCertificate")
    MO_ROOT_CERTIFICATE, @JsonProperty("CSMSRootCertificate")
    CSMS_ROOT_CERTIFICATE, @JsonProperty("V2GCertificateChain")
    V2G_CERTIFICATE_CHAIN, @JsonProperty("ManufacturerRootCertificate")
    MANUFACTURER_ROOT_CERTIFICATE
  }

  public enum AcceptedRejectedStatus {
    @JsonProperty("Accepted")
    ACCEPTED, @JsonProperty("Rejected")
    REJECTED
  }

  public enum CertificateProcessingStatus {
    @JsonProperty("Accepted")
    ACCEPTED, @JsonProperty("Failed")
    FAILED
  }

  public enum DeleteCertificateStatus {
    @JsonProperty("Accepted")
    ACCEPTED, @JsonProperty("Failed")
    FAILED, @JsonProperty("NotFound")
    NOT_FOUND
  }

  public enum InstalledCertificateStatus {
    @JsonProperty("Accepted")
    ACCEPTED, @JsonProperty("NotFound")
    NOT_FOUND
  }

  public enum CertificateInstallationStatus {
    @JsonProperty("Accepted")
    ACCEPTED, @JsonProperty("Failed")
    FAILED, @JsonProperty("Rejected")
    REJECTED
  }

  public enum ExtendedTrigger {
    @JsonProperty("SignChargingStationCertificate")
    SIGN_CHARGING_STATION_CERTIFICATE, @JsonProperty("SignV2GCertificate")
    SIGN_V2G_CERTIFICATE
  }

  public enum ExtendedTriggerStatus {
    @JsonProperty("Accepted")
    ACCEPTED, @JsonProperty("Rejected")
    REJECTED, @JsonProperty("NotImplemented")
    NOT_IMPLEMENTED
  }

  private static void requireMaximumLength(
    String value,
    int maximumLength,
    String name
  ) {
    Objects.requireNonNull(
      value,
      name
    );
    if (value.length() > maximumLength) {
      throw new IllegalArgumentException(name + " length must not exceed " + maximumLength);
    }
  }

  private static void requireText(
    String value,
    String name
  ) {
    Objects.requireNonNull(
      value,
      name
    );
    if (value.isEmpty()) {
      throw new IllegalArgumentException(name + " must not be empty");
    }
  }

  private static void requireSize(
    List<?> values,
    int minimum,
    int maximum,
    String name
  ) {
    if (values.size() < minimum || values.size() > maximum) {
      throw new IllegalArgumentException(
        name + " size must be between " + minimum + " and " + maximum
      );
    }
  }
}
