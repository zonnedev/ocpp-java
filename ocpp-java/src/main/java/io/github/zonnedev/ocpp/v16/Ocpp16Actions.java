package io.github.zonnedev.ocpp.v16;

import io.github.zonnedev.ocpp.api.OcppActionDefinition;
import io.github.zonnedev.ocpp.api.datatransfer.DataTransferOperationDefinition;
import io.github.zonnedev.ocpp.api.datatransfer.DataTransferRequestPayload;
import io.github.zonnedev.ocpp.api.datatransfer.DataTransferResponsePayload;
import io.github.zonnedev.ocpp.v16.model.AuthorizeRequest;
import io.github.zonnedev.ocpp.v16.model.AuthorizeResponse;
import io.github.zonnedev.ocpp.v16.model.BootNotificationRequest;
import io.github.zonnedev.ocpp.v16.model.BootNotificationResponse;
import io.github.zonnedev.ocpp.v16.model.CancelReservationRequest;
import io.github.zonnedev.ocpp.v16.model.CancelReservationResponse;
import io.github.zonnedev.ocpp.v16.model.CertificateSignedRequest;
import io.github.zonnedev.ocpp.v16.model.CertificateSignedResponse;
import io.github.zonnedev.ocpp.v16.model.ChangeAvailabilityRequest;
import io.github.zonnedev.ocpp.v16.model.ChangeAvailabilityResponse;
import io.github.zonnedev.ocpp.v16.model.ChangeConfigurationRequest;
import io.github.zonnedev.ocpp.v16.model.ChangeConfigurationResponse;
import io.github.zonnedev.ocpp.v16.model.ClearCacheRequest;
import io.github.zonnedev.ocpp.v16.model.ClearCacheResponse;
import io.github.zonnedev.ocpp.v16.model.ClearChargingProfileRequest;
import io.github.zonnedev.ocpp.v16.model.ClearChargingProfileResponse;
import io.github.zonnedev.ocpp.v16.model.DataTransferRequest;
import io.github.zonnedev.ocpp.v16.model.DataTransferResponse;
import io.github.zonnedev.ocpp.v16.model.DeleteCertificateRequest;
import io.github.zonnedev.ocpp.v16.model.DeleteCertificateResponse;
import io.github.zonnedev.ocpp.v16.model.DiagnosticsStatusNotificationRequest;
import io.github.zonnedev.ocpp.v16.model.DiagnosticsStatusNotificationResponse;
import io.github.zonnedev.ocpp.v16.model.ExtendedTriggerMessageRequest;
import io.github.zonnedev.ocpp.v16.model.ExtendedTriggerMessageResponse;
import io.github.zonnedev.ocpp.v16.model.FirmwareStatusNotificationRequest;
import io.github.zonnedev.ocpp.v16.model.FirmwareStatusNotificationResponse;
import io.github.zonnedev.ocpp.v16.model.GetCompositeScheduleRequest;
import io.github.zonnedev.ocpp.v16.model.GetCompositeScheduleResponse;
import io.github.zonnedev.ocpp.v16.model.GetConfigurationRequest;
import io.github.zonnedev.ocpp.v16.model.GetConfigurationResponse;
import io.github.zonnedev.ocpp.v16.model.GetDiagnosticsRequest;
import io.github.zonnedev.ocpp.v16.model.GetDiagnosticsResponse;
import io.github.zonnedev.ocpp.v16.model.GetInstalledCertificateIdsRequest;
import io.github.zonnedev.ocpp.v16.model.GetInstalledCertificateIdsResponse;
import io.github.zonnedev.ocpp.v16.model.GetLocalListVersionRequest;
import io.github.zonnedev.ocpp.v16.model.GetLocalListVersionResponse;
import io.github.zonnedev.ocpp.v16.model.GetLogRequest;
import io.github.zonnedev.ocpp.v16.model.GetLogResponse;
import io.github.zonnedev.ocpp.v16.model.HeartbeatRequest;
import io.github.zonnedev.ocpp.v16.model.HeartbeatResponse;
import io.github.zonnedev.ocpp.v16.model.InstallCertificateRequest;
import io.github.zonnedev.ocpp.v16.model.InstallCertificateResponse;
import io.github.zonnedev.ocpp.v16.model.LogStatusNotificationRequest;
import io.github.zonnedev.ocpp.v16.model.LogStatusNotificationResponse;
import io.github.zonnedev.ocpp.v16.model.MeterValuesRequest;
import io.github.zonnedev.ocpp.v16.model.MeterValuesResponse;
import io.github.zonnedev.ocpp.v16.model.RemoteStartTransactionRequest;
import io.github.zonnedev.ocpp.v16.model.RemoteStartTransactionResponse;
import io.github.zonnedev.ocpp.v16.model.RemoteStopTransactionRequest;
import io.github.zonnedev.ocpp.v16.model.RemoteStopTransactionResponse;
import io.github.zonnedev.ocpp.v16.model.ReserveNowRequest;
import io.github.zonnedev.ocpp.v16.model.ReserveNowResponse;
import io.github.zonnedev.ocpp.v16.model.ResetRequest;
import io.github.zonnedev.ocpp.v16.model.ResetResponse;
import io.github.zonnedev.ocpp.v16.model.SecurityEventNotificationRequest;
import io.github.zonnedev.ocpp.v16.model.SecurityEventNotificationResponse;
import io.github.zonnedev.ocpp.v16.model.SendLocalListRequest;
import io.github.zonnedev.ocpp.v16.model.SendLocalListResponse;
import io.github.zonnedev.ocpp.v16.model.SetChargingProfileRequest;
import io.github.zonnedev.ocpp.v16.model.SetChargingProfileResponse;
import io.github.zonnedev.ocpp.v16.model.SignCertificateRequest;
import io.github.zonnedev.ocpp.v16.model.SignCertificateResponse;
import io.github.zonnedev.ocpp.v16.model.SignedFirmwareStatusNotificationRequest;
import io.github.zonnedev.ocpp.v16.model.SignedFirmwareStatusNotificationResponse;
import io.github.zonnedev.ocpp.v16.model.SignedUpdateFirmwareRequest;
import io.github.zonnedev.ocpp.v16.model.SignedUpdateFirmwareResponse;
import io.github.zonnedev.ocpp.v16.model.StartTransactionRequest;
import io.github.zonnedev.ocpp.v16.model.StartTransactionResponse;
import io.github.zonnedev.ocpp.v16.model.StatusNotificationRequest;
import io.github.zonnedev.ocpp.v16.model.StatusNotificationResponse;
import io.github.zonnedev.ocpp.v16.model.StopTransactionRequest;
import io.github.zonnedev.ocpp.v16.model.StopTransactionResponse;
import io.github.zonnedev.ocpp.v16.model.TriggerMessageRequest;
import io.github.zonnedev.ocpp.v16.model.TriggerMessageResponse;
import io.github.zonnedev.ocpp.v16.model.UnlockConnectorRequest;
import io.github.zonnedev.ocpp.v16.model.UnlockConnectorResponse;
import io.github.zonnedev.ocpp.v16.model.UpdateFirmwareRequest;
import io.github.zonnedev.ocpp.v16.model.UpdateFirmwareResponse;

/**
 * Strongly typed action definitions generated from the same inventory as
 * {@link Ocpp16Action}.
 */
public final class Ocpp16Actions {
  public static final OcppActionDefinition<AuthorizeRequest, AuthorizeResponse> AUTHORIZE = OcppActionDefinition
    .of(
      Ocpp16Action.AUTHORIZE,
      AuthorizeRequest.class,
      AuthorizeResponse.class
    );
  public static final OcppActionDefinition<BootNotificationRequest, BootNotificationResponse> BOOT_NOTIFICATION = OcppActionDefinition
    .of(
      Ocpp16Action.BOOT_NOTIFICATION,
      BootNotificationRequest.class,
      BootNotificationResponse.class
    );
  public static final OcppActionDefinition<CancelReservationRequest, CancelReservationResponse> CANCEL_RESERVATION = OcppActionDefinition
    .of(
      Ocpp16Action.CANCEL_RESERVATION,
      CancelReservationRequest.class,
      CancelReservationResponse.class
    );
  public static final OcppActionDefinition<CertificateSignedRequest, CertificateSignedResponse> CERTIFICATE_SIGNED = OcppActionDefinition
    .of(
      Ocpp16Action.CERTIFICATE_SIGNED,
      CertificateSignedRequest.class,
      CertificateSignedResponse.class
    );
  public static final OcppActionDefinition<ChangeAvailabilityRequest, ChangeAvailabilityResponse> CHANGE_AVAILABILITY = OcppActionDefinition
    .of(
      Ocpp16Action.CHANGE_AVAILABILITY,
      ChangeAvailabilityRequest.class,
      ChangeAvailabilityResponse.class
    );
  public static final OcppActionDefinition<ChangeConfigurationRequest, ChangeConfigurationResponse> CHANGE_CONFIGURATION = OcppActionDefinition
    .of(
      Ocpp16Action.CHANGE_CONFIGURATION,
      ChangeConfigurationRequest.class,
      ChangeConfigurationResponse.class
    );
  public static final OcppActionDefinition<ClearCacheRequest, ClearCacheResponse> CLEAR_CACHE = OcppActionDefinition
    .of(
      Ocpp16Action.CLEAR_CACHE,
      ClearCacheRequest.class,
      ClearCacheResponse.class
    );
  public static final OcppActionDefinition<ClearChargingProfileRequest, ClearChargingProfileResponse> CLEAR_CHARGING_PROFILE = OcppActionDefinition
    .of(
      Ocpp16Action.CLEAR_CHARGING_PROFILE,
      ClearChargingProfileRequest.class,
      ClearChargingProfileResponse.class
    );
  @SuppressWarnings("rawtypes")
  public static final OcppActionDefinition<DataTransferRequest, DataTransferResponse> DATA_TRANSFER = OcppActionDefinition
    .of(
      Ocpp16Action.DATA_TRANSFER,
      DataTransferRequest.class,
      DataTransferResponse.class
    );

  /**
   * Returns the erased OCPP DataTransfer action with the operation's exact
   * payload types restored.
   */
  @SuppressWarnings("unchecked")
  public static <Q extends DataTransferRequestPayload, S extends DataTransferResponsePayload> OcppActionDefinition<DataTransferRequest<Q>, DataTransferResponse<S>> dataTransfer(
    DataTransferOperationDefinition<Q, S> operation
  ) {
    if (operation.version() != io.github.zonnedev.ocpp.api.OcppVersion.OCPP_1_6_JSON) {
      throw new IllegalArgumentException("Operation is not an OCPP 1.6 DataTransfer operation");
    }
    return (OcppActionDefinition<DataTransferRequest<Q>, DataTransferResponse<S>>) (OcppActionDefinition<?, ?>) DATA_TRANSFER;
  }
  public static final OcppActionDefinition<DeleteCertificateRequest, DeleteCertificateResponse> DELETE_CERTIFICATE = OcppActionDefinition
    .of(
      Ocpp16Action.DELETE_CERTIFICATE,
      DeleteCertificateRequest.class,
      DeleteCertificateResponse.class
    );
  public static final OcppActionDefinition<DiagnosticsStatusNotificationRequest, DiagnosticsStatusNotificationResponse> DIAGNOSTICS_STATUS_NOTIFICATION = OcppActionDefinition
    .of(
      Ocpp16Action.DIAGNOSTICS_STATUS_NOTIFICATION,
      DiagnosticsStatusNotificationRequest.class,
      DiagnosticsStatusNotificationResponse.class
    );
  public static final OcppActionDefinition<ExtendedTriggerMessageRequest, ExtendedTriggerMessageResponse> EXTENDED_TRIGGER_MESSAGE = OcppActionDefinition
    .of(
      Ocpp16Action.EXTENDED_TRIGGER_MESSAGE,
      ExtendedTriggerMessageRequest.class,
      ExtendedTriggerMessageResponse.class
    );
  public static final OcppActionDefinition<FirmwareStatusNotificationRequest, FirmwareStatusNotificationResponse> FIRMWARE_STATUS_NOTIFICATION = OcppActionDefinition
    .of(
      Ocpp16Action.FIRMWARE_STATUS_NOTIFICATION,
      FirmwareStatusNotificationRequest.class,
      FirmwareStatusNotificationResponse.class
    );
  public static final OcppActionDefinition<GetCompositeScheduleRequest, GetCompositeScheduleResponse> GET_COMPOSITE_SCHEDULE = OcppActionDefinition
    .of(
      Ocpp16Action.GET_COMPOSITE_SCHEDULE,
      GetCompositeScheduleRequest.class,
      GetCompositeScheduleResponse.class
    );
  public static final OcppActionDefinition<GetConfigurationRequest, GetConfigurationResponse> GET_CONFIGURATION = OcppActionDefinition
    .of(
      Ocpp16Action.GET_CONFIGURATION,
      GetConfigurationRequest.class,
      GetConfigurationResponse.class
    );
  public static final OcppActionDefinition<GetDiagnosticsRequest, GetDiagnosticsResponse> GET_DIAGNOSTICS = OcppActionDefinition
    .of(
      Ocpp16Action.GET_DIAGNOSTICS,
      GetDiagnosticsRequest.class,
      GetDiagnosticsResponse.class
    );
  public static final OcppActionDefinition<GetInstalledCertificateIdsRequest, GetInstalledCertificateIdsResponse> GET_INSTALLED_CERTIFICATE_IDS = OcppActionDefinition
    .of(
      Ocpp16Action.GET_INSTALLED_CERTIFICATE_IDS,
      GetInstalledCertificateIdsRequest.class,
      GetInstalledCertificateIdsResponse.class
    );
  public static final OcppActionDefinition<GetLocalListVersionRequest, GetLocalListVersionResponse> GET_LOCAL_LIST_VERSION = OcppActionDefinition
    .of(
      Ocpp16Action.GET_LOCAL_LIST_VERSION,
      GetLocalListVersionRequest.class,
      GetLocalListVersionResponse.class
    );
  public static final OcppActionDefinition<GetLogRequest, GetLogResponse> GET_LOG = OcppActionDefinition
    .of(
      Ocpp16Action.GET_LOG,
      GetLogRequest.class,
      GetLogResponse.class
    );
  public static final OcppActionDefinition<HeartbeatRequest, HeartbeatResponse> HEARTBEAT = OcppActionDefinition
    .of(
      Ocpp16Action.HEARTBEAT,
      HeartbeatRequest.class,
      HeartbeatResponse.class
    );
  public static final OcppActionDefinition<InstallCertificateRequest, InstallCertificateResponse> INSTALL_CERTIFICATE = OcppActionDefinition
    .of(
      Ocpp16Action.INSTALL_CERTIFICATE,
      InstallCertificateRequest.class,
      InstallCertificateResponse.class
    );
  public static final OcppActionDefinition<LogStatusNotificationRequest, LogStatusNotificationResponse> LOG_STATUS_NOTIFICATION = OcppActionDefinition
    .of(
      Ocpp16Action.LOG_STATUS_NOTIFICATION,
      LogStatusNotificationRequest.class,
      LogStatusNotificationResponse.class
    );
  public static final OcppActionDefinition<MeterValuesRequest, MeterValuesResponse> METER_VALUES = OcppActionDefinition
    .of(
      Ocpp16Action.METER_VALUES,
      MeterValuesRequest.class,
      MeterValuesResponse.class
    );
  public static final OcppActionDefinition<RemoteStartTransactionRequest, RemoteStartTransactionResponse> REMOTE_START_TRANSACTION = OcppActionDefinition
    .of(
      Ocpp16Action.REMOTE_START_TRANSACTION,
      RemoteStartTransactionRequest.class,
      RemoteStartTransactionResponse.class
    );
  public static final OcppActionDefinition<RemoteStopTransactionRequest, RemoteStopTransactionResponse> REMOTE_STOP_TRANSACTION = OcppActionDefinition
    .of(
      Ocpp16Action.REMOTE_STOP_TRANSACTION,
      RemoteStopTransactionRequest.class,
      RemoteStopTransactionResponse.class
    );
  public static final OcppActionDefinition<ReserveNowRequest, ReserveNowResponse> RESERVE_NOW = OcppActionDefinition
    .of(
      Ocpp16Action.RESERVE_NOW,
      ReserveNowRequest.class,
      ReserveNowResponse.class
    );
  public static final OcppActionDefinition<ResetRequest, ResetResponse> RESET = OcppActionDefinition
    .of(
      Ocpp16Action.RESET,
      ResetRequest.class,
      ResetResponse.class
    );
  public static final OcppActionDefinition<SecurityEventNotificationRequest, SecurityEventNotificationResponse> SECURITY_EVENT_NOTIFICATION = OcppActionDefinition
    .of(
      Ocpp16Action.SECURITY_EVENT_NOTIFICATION,
      SecurityEventNotificationRequest.class,
      SecurityEventNotificationResponse.class
    );
  public static final OcppActionDefinition<SendLocalListRequest, SendLocalListResponse> SEND_LOCAL_LIST = OcppActionDefinition
    .of(
      Ocpp16Action.SEND_LOCAL_LIST,
      SendLocalListRequest.class,
      SendLocalListResponse.class
    );
  public static final OcppActionDefinition<SetChargingProfileRequest, SetChargingProfileResponse> SET_CHARGING_PROFILE = OcppActionDefinition
    .of(
      Ocpp16Action.SET_CHARGING_PROFILE,
      SetChargingProfileRequest.class,
      SetChargingProfileResponse.class
    );
  public static final OcppActionDefinition<SignCertificateRequest, SignCertificateResponse> SIGN_CERTIFICATE = OcppActionDefinition
    .of(
      Ocpp16Action.SIGN_CERTIFICATE,
      SignCertificateRequest.class,
      SignCertificateResponse.class
    );
  public static final OcppActionDefinition<SignedFirmwareStatusNotificationRequest, SignedFirmwareStatusNotificationResponse> SIGNED_FIRMWARE_STATUS_NOTIFICATION = OcppActionDefinition
    .of(
      Ocpp16Action.SIGNED_FIRMWARE_STATUS_NOTIFICATION,
      SignedFirmwareStatusNotificationRequest.class,
      SignedFirmwareStatusNotificationResponse.class
    );
  public static final OcppActionDefinition<SignedUpdateFirmwareRequest, SignedUpdateFirmwareResponse> SIGNED_UPDATE_FIRMWARE = OcppActionDefinition
    .of(
      Ocpp16Action.SIGNED_UPDATE_FIRMWARE,
      SignedUpdateFirmwareRequest.class,
      SignedUpdateFirmwareResponse.class
    );
  public static final OcppActionDefinition<StartTransactionRequest, StartTransactionResponse> START_TRANSACTION = OcppActionDefinition
    .of(
      Ocpp16Action.START_TRANSACTION,
      StartTransactionRequest.class,
      StartTransactionResponse.class
    );
  public static final OcppActionDefinition<StatusNotificationRequest, StatusNotificationResponse> STATUS_NOTIFICATION = OcppActionDefinition
    .of(
      Ocpp16Action.STATUS_NOTIFICATION,
      StatusNotificationRequest.class,
      StatusNotificationResponse.class
    );
  public static final OcppActionDefinition<StopTransactionRequest, StopTransactionResponse> STOP_TRANSACTION = OcppActionDefinition
    .of(
      Ocpp16Action.STOP_TRANSACTION,
      StopTransactionRequest.class,
      StopTransactionResponse.class
    );
  public static final OcppActionDefinition<TriggerMessageRequest, TriggerMessageResponse> TRIGGER_MESSAGE = OcppActionDefinition
    .of(
      Ocpp16Action.TRIGGER_MESSAGE,
      TriggerMessageRequest.class,
      TriggerMessageResponse.class
    );
  public static final OcppActionDefinition<UnlockConnectorRequest, UnlockConnectorResponse> UNLOCK_CONNECTOR = OcppActionDefinition
    .of(
      Ocpp16Action.UNLOCK_CONNECTOR,
      UnlockConnectorRequest.class,
      UnlockConnectorResponse.class
    );
  public static final OcppActionDefinition<UpdateFirmwareRequest, UpdateFirmwareResponse> UPDATE_FIRMWARE = OcppActionDefinition
    .of(
      Ocpp16Action.UPDATE_FIRMWARE,
      UpdateFirmwareRequest.class,
      UpdateFirmwareResponse.class
    );
  private Ocpp16Actions() {
  }

  public static OcppActionDefinition<?, ?> definitionFor(Ocpp16Action action) {
    return switch (action) {
      case AUTHORIZE -> Ocpp16Actions.AUTHORIZE;
      case BOOT_NOTIFICATION -> Ocpp16Actions.BOOT_NOTIFICATION;
      case CANCEL_RESERVATION -> Ocpp16Actions.CANCEL_RESERVATION;
      case CERTIFICATE_SIGNED -> Ocpp16Actions.CERTIFICATE_SIGNED;
      case CHANGE_AVAILABILITY -> Ocpp16Actions.CHANGE_AVAILABILITY;
      case CHANGE_CONFIGURATION -> Ocpp16Actions.CHANGE_CONFIGURATION;
      case CLEAR_CACHE -> Ocpp16Actions.CLEAR_CACHE;
      case CLEAR_CHARGING_PROFILE -> Ocpp16Actions.CLEAR_CHARGING_PROFILE;
      case DATA_TRANSFER -> Ocpp16Actions.DATA_TRANSFER;
      case DELETE_CERTIFICATE -> Ocpp16Actions.DELETE_CERTIFICATE;
      case DIAGNOSTICS_STATUS_NOTIFICATION -> Ocpp16Actions.DIAGNOSTICS_STATUS_NOTIFICATION;
      case EXTENDED_TRIGGER_MESSAGE -> Ocpp16Actions.EXTENDED_TRIGGER_MESSAGE;
      case FIRMWARE_STATUS_NOTIFICATION -> Ocpp16Actions.FIRMWARE_STATUS_NOTIFICATION;
      case GET_COMPOSITE_SCHEDULE -> Ocpp16Actions.GET_COMPOSITE_SCHEDULE;
      case GET_CONFIGURATION -> Ocpp16Actions.GET_CONFIGURATION;
      case GET_DIAGNOSTICS -> Ocpp16Actions.GET_DIAGNOSTICS;
      case GET_INSTALLED_CERTIFICATE_IDS -> Ocpp16Actions.GET_INSTALLED_CERTIFICATE_IDS;
      case GET_LOCAL_LIST_VERSION -> Ocpp16Actions.GET_LOCAL_LIST_VERSION;
      case GET_LOG -> Ocpp16Actions.GET_LOG;
      case HEARTBEAT -> Ocpp16Actions.HEARTBEAT;
      case INSTALL_CERTIFICATE -> Ocpp16Actions.INSTALL_CERTIFICATE;
      case LOG_STATUS_NOTIFICATION -> Ocpp16Actions.LOG_STATUS_NOTIFICATION;
      case METER_VALUES -> Ocpp16Actions.METER_VALUES;
      case REMOTE_START_TRANSACTION -> Ocpp16Actions.REMOTE_START_TRANSACTION;
      case REMOTE_STOP_TRANSACTION -> Ocpp16Actions.REMOTE_STOP_TRANSACTION;
      case RESERVE_NOW -> Ocpp16Actions.RESERVE_NOW;
      case RESET -> Ocpp16Actions.RESET;
      case SECURITY_EVENT_NOTIFICATION -> Ocpp16Actions.SECURITY_EVENT_NOTIFICATION;
      case SEND_LOCAL_LIST -> Ocpp16Actions.SEND_LOCAL_LIST;
      case SET_CHARGING_PROFILE -> Ocpp16Actions.SET_CHARGING_PROFILE;
      case SIGN_CERTIFICATE -> Ocpp16Actions.SIGN_CERTIFICATE;
      case SIGNED_FIRMWARE_STATUS_NOTIFICATION -> Ocpp16Actions.SIGNED_FIRMWARE_STATUS_NOTIFICATION;
      case SIGNED_UPDATE_FIRMWARE -> Ocpp16Actions.SIGNED_UPDATE_FIRMWARE;
      case START_TRANSACTION -> Ocpp16Actions.START_TRANSACTION;
      case STATUS_NOTIFICATION -> Ocpp16Actions.STATUS_NOTIFICATION;
      case STOP_TRANSACTION -> Ocpp16Actions.STOP_TRANSACTION;
      case TRIGGER_MESSAGE -> Ocpp16Actions.TRIGGER_MESSAGE;
      case UNLOCK_CONNECTOR -> Ocpp16Actions.UNLOCK_CONNECTOR;
      case UPDATE_FIRMWARE -> Ocpp16Actions.UPDATE_FIRMWARE;
    };
  }
}
