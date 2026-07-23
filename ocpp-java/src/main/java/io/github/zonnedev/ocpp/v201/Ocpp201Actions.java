package io.github.zonnedev.ocpp.v201;

import io.github.zonnedev.ocpp.api.OcppActionDefinition;
import io.github.zonnedev.ocpp.api.datatransfer.DataTransferOperationDefinition;
import io.github.zonnedev.ocpp.api.datatransfer.DataTransferRequestPayload;
import io.github.zonnedev.ocpp.api.datatransfer.DataTransferResponsePayload;
import io.github.zonnedev.ocpp.v201.model.AuthorizeRequest;
import io.github.zonnedev.ocpp.v201.model.AuthorizeResponse;
import io.github.zonnedev.ocpp.v201.model.BootNotificationRequest;
import io.github.zonnedev.ocpp.v201.model.BootNotificationResponse;
import io.github.zonnedev.ocpp.v201.model.CancelReservationRequest;
import io.github.zonnedev.ocpp.v201.model.CancelReservationResponse;
import io.github.zonnedev.ocpp.v201.model.CertificateSignedRequest;
import io.github.zonnedev.ocpp.v201.model.CertificateSignedResponse;
import io.github.zonnedev.ocpp.v201.model.ChangeAvailabilityRequest;
import io.github.zonnedev.ocpp.v201.model.ChangeAvailabilityResponse;
import io.github.zonnedev.ocpp.v201.model.ClearCacheRequest;
import io.github.zonnedev.ocpp.v201.model.ClearCacheResponse;
import io.github.zonnedev.ocpp.v201.model.ClearChargingProfileRequest;
import io.github.zonnedev.ocpp.v201.model.ClearChargingProfileResponse;
import io.github.zonnedev.ocpp.v201.model.ClearDisplayMessageRequest;
import io.github.zonnedev.ocpp.v201.model.ClearDisplayMessageResponse;
import io.github.zonnedev.ocpp.v201.model.ClearVariableMonitoringRequest;
import io.github.zonnedev.ocpp.v201.model.ClearVariableMonitoringResponse;
import io.github.zonnedev.ocpp.v201.model.ClearedChargingLimitRequest;
import io.github.zonnedev.ocpp.v201.model.ClearedChargingLimitResponse;
import io.github.zonnedev.ocpp.v201.model.CostUpdatedRequest;
import io.github.zonnedev.ocpp.v201.model.CostUpdatedResponse;
import io.github.zonnedev.ocpp.v201.model.CustomerInformationRequest;
import io.github.zonnedev.ocpp.v201.model.CustomerInformationResponse;
import io.github.zonnedev.ocpp.v201.model.DataTransferRequest;
import io.github.zonnedev.ocpp.v201.model.DataTransferResponse;
import io.github.zonnedev.ocpp.v201.model.DeleteCertificateRequest;
import io.github.zonnedev.ocpp.v201.model.DeleteCertificateResponse;
import io.github.zonnedev.ocpp.v201.model.FirmwareStatusNotificationRequest;
import io.github.zonnedev.ocpp.v201.model.FirmwareStatusNotificationResponse;
import io.github.zonnedev.ocpp.v201.model.Get15118EVCertificateRequest;
import io.github.zonnedev.ocpp.v201.model.Get15118EVCertificateResponse;
import io.github.zonnedev.ocpp.v201.model.GetBaseReportRequest;
import io.github.zonnedev.ocpp.v201.model.GetBaseReportResponse;
import io.github.zonnedev.ocpp.v201.model.GetCertificateStatusRequest;
import io.github.zonnedev.ocpp.v201.model.GetCertificateStatusResponse;
import io.github.zonnedev.ocpp.v201.model.GetChargingProfilesRequest;
import io.github.zonnedev.ocpp.v201.model.GetChargingProfilesResponse;
import io.github.zonnedev.ocpp.v201.model.GetCompositeScheduleRequest;
import io.github.zonnedev.ocpp.v201.model.GetCompositeScheduleResponse;
import io.github.zonnedev.ocpp.v201.model.GetDisplayMessagesRequest;
import io.github.zonnedev.ocpp.v201.model.GetDisplayMessagesResponse;
import io.github.zonnedev.ocpp.v201.model.GetInstalledCertificateIdsRequest;
import io.github.zonnedev.ocpp.v201.model.GetInstalledCertificateIdsResponse;
import io.github.zonnedev.ocpp.v201.model.GetLocalListVersionRequest;
import io.github.zonnedev.ocpp.v201.model.GetLocalListVersionResponse;
import io.github.zonnedev.ocpp.v201.model.GetLogRequest;
import io.github.zonnedev.ocpp.v201.model.GetLogResponse;
import io.github.zonnedev.ocpp.v201.model.GetMonitoringReportRequest;
import io.github.zonnedev.ocpp.v201.model.GetMonitoringReportResponse;
import io.github.zonnedev.ocpp.v201.model.GetReportRequest;
import io.github.zonnedev.ocpp.v201.model.GetReportResponse;
import io.github.zonnedev.ocpp.v201.model.GetTransactionStatusRequest;
import io.github.zonnedev.ocpp.v201.model.GetTransactionStatusResponse;
import io.github.zonnedev.ocpp.v201.model.GetVariablesRequest;
import io.github.zonnedev.ocpp.v201.model.GetVariablesResponse;
import io.github.zonnedev.ocpp.v201.model.HeartbeatRequest;
import io.github.zonnedev.ocpp.v201.model.HeartbeatResponse;
import io.github.zonnedev.ocpp.v201.model.InstallCertificateRequest;
import io.github.zonnedev.ocpp.v201.model.InstallCertificateResponse;
import io.github.zonnedev.ocpp.v201.model.LogStatusNotificationRequest;
import io.github.zonnedev.ocpp.v201.model.LogStatusNotificationResponse;
import io.github.zonnedev.ocpp.v201.model.MeterValuesRequest;
import io.github.zonnedev.ocpp.v201.model.MeterValuesResponse;
import io.github.zonnedev.ocpp.v201.model.NotifyChargingLimitRequest;
import io.github.zonnedev.ocpp.v201.model.NotifyChargingLimitResponse;
import io.github.zonnedev.ocpp.v201.model.NotifyCustomerInformationRequest;
import io.github.zonnedev.ocpp.v201.model.NotifyCustomerInformationResponse;
import io.github.zonnedev.ocpp.v201.model.NotifyDisplayMessagesRequest;
import io.github.zonnedev.ocpp.v201.model.NotifyDisplayMessagesResponse;
import io.github.zonnedev.ocpp.v201.model.NotifyEVChargingNeedsRequest;
import io.github.zonnedev.ocpp.v201.model.NotifyEVChargingNeedsResponse;
import io.github.zonnedev.ocpp.v201.model.NotifyEVChargingScheduleRequest;
import io.github.zonnedev.ocpp.v201.model.NotifyEVChargingScheduleResponse;
import io.github.zonnedev.ocpp.v201.model.NotifyEventRequest;
import io.github.zonnedev.ocpp.v201.model.NotifyEventResponse;
import io.github.zonnedev.ocpp.v201.model.NotifyMonitoringReportRequest;
import io.github.zonnedev.ocpp.v201.model.NotifyMonitoringReportResponse;
import io.github.zonnedev.ocpp.v201.model.NotifyReportRequest;
import io.github.zonnedev.ocpp.v201.model.NotifyReportResponse;
import io.github.zonnedev.ocpp.v201.model.PublishFirmwareRequest;
import io.github.zonnedev.ocpp.v201.model.PublishFirmwareResponse;
import io.github.zonnedev.ocpp.v201.model.PublishFirmwareStatusNotificationRequest;
import io.github.zonnedev.ocpp.v201.model.PublishFirmwareStatusNotificationResponse;
import io.github.zonnedev.ocpp.v201.model.ReportChargingProfilesRequest;
import io.github.zonnedev.ocpp.v201.model.ReportChargingProfilesResponse;
import io.github.zonnedev.ocpp.v201.model.RequestStartTransactionRequest;
import io.github.zonnedev.ocpp.v201.model.RequestStartTransactionResponse;
import io.github.zonnedev.ocpp.v201.model.RequestStopTransactionRequest;
import io.github.zonnedev.ocpp.v201.model.RequestStopTransactionResponse;
import io.github.zonnedev.ocpp.v201.model.ReservationStatusUpdateRequest;
import io.github.zonnedev.ocpp.v201.model.ReservationStatusUpdateResponse;
import io.github.zonnedev.ocpp.v201.model.ReserveNowRequest;
import io.github.zonnedev.ocpp.v201.model.ReserveNowResponse;
import io.github.zonnedev.ocpp.v201.model.ResetRequest;
import io.github.zonnedev.ocpp.v201.model.ResetResponse;
import io.github.zonnedev.ocpp.v201.model.SecurityEventNotificationRequest;
import io.github.zonnedev.ocpp.v201.model.SecurityEventNotificationResponse;
import io.github.zonnedev.ocpp.v201.model.SendLocalListRequest;
import io.github.zonnedev.ocpp.v201.model.SendLocalListResponse;
import io.github.zonnedev.ocpp.v201.model.SetChargingProfileRequest;
import io.github.zonnedev.ocpp.v201.model.SetChargingProfileResponse;
import io.github.zonnedev.ocpp.v201.model.SetDisplayMessageRequest;
import io.github.zonnedev.ocpp.v201.model.SetDisplayMessageResponse;
import io.github.zonnedev.ocpp.v201.model.SetMonitoringBaseRequest;
import io.github.zonnedev.ocpp.v201.model.SetMonitoringBaseResponse;
import io.github.zonnedev.ocpp.v201.model.SetMonitoringLevelRequest;
import io.github.zonnedev.ocpp.v201.model.SetMonitoringLevelResponse;
import io.github.zonnedev.ocpp.v201.model.SetNetworkProfileRequest;
import io.github.zonnedev.ocpp.v201.model.SetNetworkProfileResponse;
import io.github.zonnedev.ocpp.v201.model.SetVariableMonitoringRequest;
import io.github.zonnedev.ocpp.v201.model.SetVariableMonitoringResponse;
import io.github.zonnedev.ocpp.v201.model.SetVariablesRequest;
import io.github.zonnedev.ocpp.v201.model.SetVariablesResponse;
import io.github.zonnedev.ocpp.v201.model.SignCertificateRequest;
import io.github.zonnedev.ocpp.v201.model.SignCertificateResponse;
import io.github.zonnedev.ocpp.v201.model.StatusNotificationRequest;
import io.github.zonnedev.ocpp.v201.model.StatusNotificationResponse;
import io.github.zonnedev.ocpp.v201.model.TransactionEventRequest;
import io.github.zonnedev.ocpp.v201.model.TransactionEventResponse;
import io.github.zonnedev.ocpp.v201.model.TriggerMessageRequest;
import io.github.zonnedev.ocpp.v201.model.TriggerMessageResponse;
import io.github.zonnedev.ocpp.v201.model.UnlockConnectorRequest;
import io.github.zonnedev.ocpp.v201.model.UnlockConnectorResponse;
import io.github.zonnedev.ocpp.v201.model.UnpublishFirmwareRequest;
import io.github.zonnedev.ocpp.v201.model.UnpublishFirmwareResponse;
import io.github.zonnedev.ocpp.v201.model.UpdateFirmwareRequest;
import io.github.zonnedev.ocpp.v201.model.UpdateFirmwareResponse;

/**
 * Strongly typed action definitions generated from the same inventory as
 * {@link Ocpp201Action}.
 */
public final class Ocpp201Actions {
  public static final OcppActionDefinition<AuthorizeRequest, AuthorizeResponse> AUTHORIZE = OcppActionDefinition
    .of(
      Ocpp201Action.AUTHORIZE,
      AuthorizeRequest.class,
      AuthorizeResponse.class
    );
  public static final OcppActionDefinition<BootNotificationRequest, BootNotificationResponse> BOOT_NOTIFICATION = OcppActionDefinition
    .of(
      Ocpp201Action.BOOT_NOTIFICATION,
      BootNotificationRequest.class,
      BootNotificationResponse.class
    );
  public static final OcppActionDefinition<CancelReservationRequest, CancelReservationResponse> CANCEL_RESERVATION = OcppActionDefinition
    .of(
      Ocpp201Action.CANCEL_RESERVATION,
      CancelReservationRequest.class,
      CancelReservationResponse.class
    );
  public static final OcppActionDefinition<CertificateSignedRequest, CertificateSignedResponse> CERTIFICATE_SIGNED = OcppActionDefinition
    .of(
      Ocpp201Action.CERTIFICATE_SIGNED,
      CertificateSignedRequest.class,
      CertificateSignedResponse.class
    );
  public static final OcppActionDefinition<ChangeAvailabilityRequest, ChangeAvailabilityResponse> CHANGE_AVAILABILITY = OcppActionDefinition
    .of(
      Ocpp201Action.CHANGE_AVAILABILITY,
      ChangeAvailabilityRequest.class,
      ChangeAvailabilityResponse.class
    );
  public static final OcppActionDefinition<ClearCacheRequest, ClearCacheResponse> CLEAR_CACHE = OcppActionDefinition
    .of(
      Ocpp201Action.CLEAR_CACHE,
      ClearCacheRequest.class,
      ClearCacheResponse.class
    );
  public static final OcppActionDefinition<ClearChargingProfileRequest, ClearChargingProfileResponse> CLEAR_CHARGING_PROFILE = OcppActionDefinition
    .of(
      Ocpp201Action.CLEAR_CHARGING_PROFILE,
      ClearChargingProfileRequest.class,
      ClearChargingProfileResponse.class
    );
  public static final OcppActionDefinition<ClearDisplayMessageRequest, ClearDisplayMessageResponse> CLEAR_DISPLAY_MESSAGE = OcppActionDefinition
    .of(
      Ocpp201Action.CLEAR_DISPLAY_MESSAGE,
      ClearDisplayMessageRequest.class,
      ClearDisplayMessageResponse.class
    );
  public static final OcppActionDefinition<ClearVariableMonitoringRequest, ClearVariableMonitoringResponse> CLEAR_VARIABLE_MONITORING = OcppActionDefinition
    .of(
      Ocpp201Action.CLEAR_VARIABLE_MONITORING,
      ClearVariableMonitoringRequest.class,
      ClearVariableMonitoringResponse.class
    );
  public static final OcppActionDefinition<ClearedChargingLimitRequest, ClearedChargingLimitResponse> CLEARED_CHARGING_LIMIT = OcppActionDefinition
    .of(
      Ocpp201Action.CLEARED_CHARGING_LIMIT,
      ClearedChargingLimitRequest.class,
      ClearedChargingLimitResponse.class
    );
  public static final OcppActionDefinition<CostUpdatedRequest, CostUpdatedResponse> COST_UPDATED = OcppActionDefinition
    .of(
      Ocpp201Action.COST_UPDATED,
      CostUpdatedRequest.class,
      CostUpdatedResponse.class
    );
  public static final OcppActionDefinition<CustomerInformationRequest, CustomerInformationResponse> CUSTOMER_INFORMATION = OcppActionDefinition
    .of(
      Ocpp201Action.CUSTOMER_INFORMATION,
      CustomerInformationRequest.class,
      CustomerInformationResponse.class
    );
  @SuppressWarnings("rawtypes")
  public static final OcppActionDefinition<DataTransferRequest, DataTransferResponse> DATA_TRANSFER = OcppActionDefinition
    .of(
      Ocpp201Action.DATA_TRANSFER,
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
    if (operation.version() != io.github.zonnedev.ocpp.api.OcppVersion.OCPP_2_0_1) {
      throw new IllegalArgumentException("Operation is not an OCPP 2.0.1 DataTransfer operation");
    }
    return (OcppActionDefinition<DataTransferRequest<Q>, DataTransferResponse<S>>) (OcppActionDefinition<?, ?>) DATA_TRANSFER;
  }
  public static final OcppActionDefinition<DeleteCertificateRequest, DeleteCertificateResponse> DELETE_CERTIFICATE = OcppActionDefinition
    .of(
      Ocpp201Action.DELETE_CERTIFICATE,
      DeleteCertificateRequest.class,
      DeleteCertificateResponse.class
    );
  public static final OcppActionDefinition<FirmwareStatusNotificationRequest, FirmwareStatusNotificationResponse> FIRMWARE_STATUS_NOTIFICATION = OcppActionDefinition
    .of(
      Ocpp201Action.FIRMWARE_STATUS_NOTIFICATION,
      FirmwareStatusNotificationRequest.class,
      FirmwareStatusNotificationResponse.class
    );
  public static final OcppActionDefinition<Get15118EVCertificateRequest, Get15118EVCertificateResponse> GET15118_EVCERTIFICATE = OcppActionDefinition
    .of(
      Ocpp201Action.GET15118_EVCERTIFICATE,
      Get15118EVCertificateRequest.class,
      Get15118EVCertificateResponse.class
    );
  public static final OcppActionDefinition<GetBaseReportRequest, GetBaseReportResponse> GET_BASE_REPORT = OcppActionDefinition
    .of(
      Ocpp201Action.GET_BASE_REPORT,
      GetBaseReportRequest.class,
      GetBaseReportResponse.class
    );
  public static final OcppActionDefinition<GetCertificateStatusRequest, GetCertificateStatusResponse> GET_CERTIFICATE_STATUS = OcppActionDefinition
    .of(
      Ocpp201Action.GET_CERTIFICATE_STATUS,
      GetCertificateStatusRequest.class,
      GetCertificateStatusResponse.class
    );
  public static final OcppActionDefinition<GetChargingProfilesRequest, GetChargingProfilesResponse> GET_CHARGING_PROFILES = OcppActionDefinition
    .of(
      Ocpp201Action.GET_CHARGING_PROFILES,
      GetChargingProfilesRequest.class,
      GetChargingProfilesResponse.class
    );
  public static final OcppActionDefinition<GetCompositeScheduleRequest, GetCompositeScheduleResponse> GET_COMPOSITE_SCHEDULE = OcppActionDefinition
    .of(
      Ocpp201Action.GET_COMPOSITE_SCHEDULE,
      GetCompositeScheduleRequest.class,
      GetCompositeScheduleResponse.class
    );
  public static final OcppActionDefinition<GetDisplayMessagesRequest, GetDisplayMessagesResponse> GET_DISPLAY_MESSAGES = OcppActionDefinition
    .of(
      Ocpp201Action.GET_DISPLAY_MESSAGES,
      GetDisplayMessagesRequest.class,
      GetDisplayMessagesResponse.class
    );
  public static final OcppActionDefinition<GetInstalledCertificateIdsRequest, GetInstalledCertificateIdsResponse> GET_INSTALLED_CERTIFICATE_IDS = OcppActionDefinition
    .of(
      Ocpp201Action.GET_INSTALLED_CERTIFICATE_IDS,
      GetInstalledCertificateIdsRequest.class,
      GetInstalledCertificateIdsResponse.class
    );
  public static final OcppActionDefinition<GetLocalListVersionRequest, GetLocalListVersionResponse> GET_LOCAL_LIST_VERSION = OcppActionDefinition
    .of(
      Ocpp201Action.GET_LOCAL_LIST_VERSION,
      GetLocalListVersionRequest.class,
      GetLocalListVersionResponse.class
    );
  public static final OcppActionDefinition<GetLogRequest, GetLogResponse> GET_LOG = OcppActionDefinition
    .of(
      Ocpp201Action.GET_LOG,
      GetLogRequest.class,
      GetLogResponse.class
    );
  public static final OcppActionDefinition<GetMonitoringReportRequest, GetMonitoringReportResponse> GET_MONITORING_REPORT = OcppActionDefinition
    .of(
      Ocpp201Action.GET_MONITORING_REPORT,
      GetMonitoringReportRequest.class,
      GetMonitoringReportResponse.class
    );
  public static final OcppActionDefinition<GetReportRequest, GetReportResponse> GET_REPORT = OcppActionDefinition
    .of(
      Ocpp201Action.GET_REPORT,
      GetReportRequest.class,
      GetReportResponse.class
    );
  public static final OcppActionDefinition<GetTransactionStatusRequest, GetTransactionStatusResponse> GET_TRANSACTION_STATUS = OcppActionDefinition
    .of(
      Ocpp201Action.GET_TRANSACTION_STATUS,
      GetTransactionStatusRequest.class,
      GetTransactionStatusResponse.class
    );
  public static final OcppActionDefinition<GetVariablesRequest, GetVariablesResponse> GET_VARIABLES = OcppActionDefinition
    .of(
      Ocpp201Action.GET_VARIABLES,
      GetVariablesRequest.class,
      GetVariablesResponse.class
    );
  public static final OcppActionDefinition<HeartbeatRequest, HeartbeatResponse> HEARTBEAT = OcppActionDefinition
    .of(
      Ocpp201Action.HEARTBEAT,
      HeartbeatRequest.class,
      HeartbeatResponse.class
    );
  public static final OcppActionDefinition<InstallCertificateRequest, InstallCertificateResponse> INSTALL_CERTIFICATE = OcppActionDefinition
    .of(
      Ocpp201Action.INSTALL_CERTIFICATE,
      InstallCertificateRequest.class,
      InstallCertificateResponse.class
    );
  public static final OcppActionDefinition<LogStatusNotificationRequest, LogStatusNotificationResponse> LOG_STATUS_NOTIFICATION = OcppActionDefinition
    .of(
      Ocpp201Action.LOG_STATUS_NOTIFICATION,
      LogStatusNotificationRequest.class,
      LogStatusNotificationResponse.class
    );
  public static final OcppActionDefinition<MeterValuesRequest, MeterValuesResponse> METER_VALUES = OcppActionDefinition
    .of(
      Ocpp201Action.METER_VALUES,
      MeterValuesRequest.class,
      MeterValuesResponse.class
    );
  public static final OcppActionDefinition<NotifyChargingLimitRequest, NotifyChargingLimitResponse> NOTIFY_CHARGING_LIMIT = OcppActionDefinition
    .of(
      Ocpp201Action.NOTIFY_CHARGING_LIMIT,
      NotifyChargingLimitRequest.class,
      NotifyChargingLimitResponse.class
    );
  public static final OcppActionDefinition<NotifyCustomerInformationRequest, NotifyCustomerInformationResponse> NOTIFY_CUSTOMER_INFORMATION = OcppActionDefinition
    .of(
      Ocpp201Action.NOTIFY_CUSTOMER_INFORMATION,
      NotifyCustomerInformationRequest.class,
      NotifyCustomerInformationResponse.class
    );
  public static final OcppActionDefinition<NotifyDisplayMessagesRequest, NotifyDisplayMessagesResponse> NOTIFY_DISPLAY_MESSAGES = OcppActionDefinition
    .of(
      Ocpp201Action.NOTIFY_DISPLAY_MESSAGES,
      NotifyDisplayMessagesRequest.class,
      NotifyDisplayMessagesResponse.class
    );
  public static final OcppActionDefinition<NotifyEVChargingNeedsRequest, NotifyEVChargingNeedsResponse> NOTIFY_EVCHARGING_NEEDS = OcppActionDefinition
    .of(
      Ocpp201Action.NOTIFY_EVCHARGING_NEEDS,
      NotifyEVChargingNeedsRequest.class,
      NotifyEVChargingNeedsResponse.class
    );
  public static final OcppActionDefinition<NotifyEVChargingScheduleRequest, NotifyEVChargingScheduleResponse> NOTIFY_EVCHARGING_SCHEDULE = OcppActionDefinition
    .of(
      Ocpp201Action.NOTIFY_EVCHARGING_SCHEDULE,
      NotifyEVChargingScheduleRequest.class,
      NotifyEVChargingScheduleResponse.class
    );
  public static final OcppActionDefinition<NotifyEventRequest, NotifyEventResponse> NOTIFY_EVENT = OcppActionDefinition
    .of(
      Ocpp201Action.NOTIFY_EVENT,
      NotifyEventRequest.class,
      NotifyEventResponse.class
    );
  public static final OcppActionDefinition<NotifyMonitoringReportRequest, NotifyMonitoringReportResponse> NOTIFY_MONITORING_REPORT = OcppActionDefinition
    .of(
      Ocpp201Action.NOTIFY_MONITORING_REPORT,
      NotifyMonitoringReportRequest.class,
      NotifyMonitoringReportResponse.class
    );
  public static final OcppActionDefinition<NotifyReportRequest, NotifyReportResponse> NOTIFY_REPORT = OcppActionDefinition
    .of(
      Ocpp201Action.NOTIFY_REPORT,
      NotifyReportRequest.class,
      NotifyReportResponse.class
    );
  public static final OcppActionDefinition<PublishFirmwareRequest, PublishFirmwareResponse> PUBLISH_FIRMWARE = OcppActionDefinition
    .of(
      Ocpp201Action.PUBLISH_FIRMWARE,
      PublishFirmwareRequest.class,
      PublishFirmwareResponse.class
    );
  public static final OcppActionDefinition<PublishFirmwareStatusNotificationRequest, PublishFirmwareStatusNotificationResponse> PUBLISH_FIRMWARE_STATUS_NOTIFICATION = OcppActionDefinition
    .of(
      Ocpp201Action.PUBLISH_FIRMWARE_STATUS_NOTIFICATION,
      PublishFirmwareStatusNotificationRequest.class,
      PublishFirmwareStatusNotificationResponse.class
    );
  public static final OcppActionDefinition<ReportChargingProfilesRequest, ReportChargingProfilesResponse> REPORT_CHARGING_PROFILES = OcppActionDefinition
    .of(
      Ocpp201Action.REPORT_CHARGING_PROFILES,
      ReportChargingProfilesRequest.class,
      ReportChargingProfilesResponse.class
    );
  public static final OcppActionDefinition<RequestStartTransactionRequest, RequestStartTransactionResponse> REQUEST_START_TRANSACTION = OcppActionDefinition
    .of(
      Ocpp201Action.REQUEST_START_TRANSACTION,
      RequestStartTransactionRequest.class,
      RequestStartTransactionResponse.class
    );
  public static final OcppActionDefinition<RequestStopTransactionRequest, RequestStopTransactionResponse> REQUEST_STOP_TRANSACTION = OcppActionDefinition
    .of(
      Ocpp201Action.REQUEST_STOP_TRANSACTION,
      RequestStopTransactionRequest.class,
      RequestStopTransactionResponse.class
    );
  public static final OcppActionDefinition<ReservationStatusUpdateRequest, ReservationStatusUpdateResponse> RESERVATION_STATUS_UPDATE = OcppActionDefinition
    .of(
      Ocpp201Action.RESERVATION_STATUS_UPDATE,
      ReservationStatusUpdateRequest.class,
      ReservationStatusUpdateResponse.class
    );
  public static final OcppActionDefinition<ReserveNowRequest, ReserveNowResponse> RESERVE_NOW = OcppActionDefinition
    .of(
      Ocpp201Action.RESERVE_NOW,
      ReserveNowRequest.class,
      ReserveNowResponse.class
    );
  public static final OcppActionDefinition<ResetRequest, ResetResponse> RESET = OcppActionDefinition
    .of(
      Ocpp201Action.RESET,
      ResetRequest.class,
      ResetResponse.class
    );
  public static final OcppActionDefinition<SecurityEventNotificationRequest, SecurityEventNotificationResponse> SECURITY_EVENT_NOTIFICATION = OcppActionDefinition
    .of(
      Ocpp201Action.SECURITY_EVENT_NOTIFICATION,
      SecurityEventNotificationRequest.class,
      SecurityEventNotificationResponse.class
    );
  public static final OcppActionDefinition<SendLocalListRequest, SendLocalListResponse> SEND_LOCAL_LIST = OcppActionDefinition
    .of(
      Ocpp201Action.SEND_LOCAL_LIST,
      SendLocalListRequest.class,
      SendLocalListResponse.class
    );
  public static final OcppActionDefinition<SetChargingProfileRequest, SetChargingProfileResponse> SET_CHARGING_PROFILE = OcppActionDefinition
    .of(
      Ocpp201Action.SET_CHARGING_PROFILE,
      SetChargingProfileRequest.class,
      SetChargingProfileResponse.class
    );
  public static final OcppActionDefinition<SetDisplayMessageRequest, SetDisplayMessageResponse> SET_DISPLAY_MESSAGE = OcppActionDefinition
    .of(
      Ocpp201Action.SET_DISPLAY_MESSAGE,
      SetDisplayMessageRequest.class,
      SetDisplayMessageResponse.class
    );
  public static final OcppActionDefinition<SetMonitoringBaseRequest, SetMonitoringBaseResponse> SET_MONITORING_BASE = OcppActionDefinition
    .of(
      Ocpp201Action.SET_MONITORING_BASE,
      SetMonitoringBaseRequest.class,
      SetMonitoringBaseResponse.class
    );
  public static final OcppActionDefinition<SetMonitoringLevelRequest, SetMonitoringLevelResponse> SET_MONITORING_LEVEL = OcppActionDefinition
    .of(
      Ocpp201Action.SET_MONITORING_LEVEL,
      SetMonitoringLevelRequest.class,
      SetMonitoringLevelResponse.class
    );
  public static final OcppActionDefinition<SetNetworkProfileRequest, SetNetworkProfileResponse> SET_NETWORK_PROFILE = OcppActionDefinition
    .of(
      Ocpp201Action.SET_NETWORK_PROFILE,
      SetNetworkProfileRequest.class,
      SetNetworkProfileResponse.class
    );
  public static final OcppActionDefinition<SetVariableMonitoringRequest, SetVariableMonitoringResponse> SET_VARIABLE_MONITORING = OcppActionDefinition
    .of(
      Ocpp201Action.SET_VARIABLE_MONITORING,
      SetVariableMonitoringRequest.class,
      SetVariableMonitoringResponse.class
    );
  public static final OcppActionDefinition<SetVariablesRequest, SetVariablesResponse> SET_VARIABLES = OcppActionDefinition
    .of(
      Ocpp201Action.SET_VARIABLES,
      SetVariablesRequest.class,
      SetVariablesResponse.class
    );
  public static final OcppActionDefinition<SignCertificateRequest, SignCertificateResponse> SIGN_CERTIFICATE = OcppActionDefinition
    .of(
      Ocpp201Action.SIGN_CERTIFICATE,
      SignCertificateRequest.class,
      SignCertificateResponse.class
    );
  public static final OcppActionDefinition<StatusNotificationRequest, StatusNotificationResponse> STATUS_NOTIFICATION = OcppActionDefinition
    .of(
      Ocpp201Action.STATUS_NOTIFICATION,
      StatusNotificationRequest.class,
      StatusNotificationResponse.class
    );
  public static final OcppActionDefinition<TransactionEventRequest, TransactionEventResponse> TRANSACTION_EVENT = OcppActionDefinition
    .of(
      Ocpp201Action.TRANSACTION_EVENT,
      TransactionEventRequest.class,
      TransactionEventResponse.class
    );
  public static final OcppActionDefinition<TriggerMessageRequest, TriggerMessageResponse> TRIGGER_MESSAGE = OcppActionDefinition
    .of(
      Ocpp201Action.TRIGGER_MESSAGE,
      TriggerMessageRequest.class,
      TriggerMessageResponse.class
    );
  public static final OcppActionDefinition<UnlockConnectorRequest, UnlockConnectorResponse> UNLOCK_CONNECTOR = OcppActionDefinition
    .of(
      Ocpp201Action.UNLOCK_CONNECTOR,
      UnlockConnectorRequest.class,
      UnlockConnectorResponse.class
    );
  public static final OcppActionDefinition<UnpublishFirmwareRequest, UnpublishFirmwareResponse> UNPUBLISH_FIRMWARE = OcppActionDefinition
    .of(
      Ocpp201Action.UNPUBLISH_FIRMWARE,
      UnpublishFirmwareRequest.class,
      UnpublishFirmwareResponse.class
    );
  public static final OcppActionDefinition<UpdateFirmwareRequest, UpdateFirmwareResponse> UPDATE_FIRMWARE = OcppActionDefinition
    .of(
      Ocpp201Action.UPDATE_FIRMWARE,
      UpdateFirmwareRequest.class,
      UpdateFirmwareResponse.class
    );
  private Ocpp201Actions() {
  }

  public static OcppActionDefinition<?, ?> definitionFor(Ocpp201Action action) {
    return switch (action) {
      case AUTHORIZE -> Ocpp201Actions.AUTHORIZE;
      case BOOT_NOTIFICATION -> Ocpp201Actions.BOOT_NOTIFICATION;
      case CANCEL_RESERVATION -> Ocpp201Actions.CANCEL_RESERVATION;
      case CERTIFICATE_SIGNED -> Ocpp201Actions.CERTIFICATE_SIGNED;
      case CHANGE_AVAILABILITY -> Ocpp201Actions.CHANGE_AVAILABILITY;
      case CLEAR_CACHE -> Ocpp201Actions.CLEAR_CACHE;
      case CLEAR_CHARGING_PROFILE -> Ocpp201Actions.CLEAR_CHARGING_PROFILE;
      case CLEAR_DISPLAY_MESSAGE -> Ocpp201Actions.CLEAR_DISPLAY_MESSAGE;
      case CLEAR_VARIABLE_MONITORING -> Ocpp201Actions.CLEAR_VARIABLE_MONITORING;
      case CLEARED_CHARGING_LIMIT -> Ocpp201Actions.CLEARED_CHARGING_LIMIT;
      case COST_UPDATED -> Ocpp201Actions.COST_UPDATED;
      case CUSTOMER_INFORMATION -> Ocpp201Actions.CUSTOMER_INFORMATION;
      case DATA_TRANSFER -> Ocpp201Actions.DATA_TRANSFER;
      case DELETE_CERTIFICATE -> Ocpp201Actions.DELETE_CERTIFICATE;
      case FIRMWARE_STATUS_NOTIFICATION -> Ocpp201Actions.FIRMWARE_STATUS_NOTIFICATION;
      case GET15118_EVCERTIFICATE -> Ocpp201Actions.GET15118_EVCERTIFICATE;
      case GET_BASE_REPORT -> Ocpp201Actions.GET_BASE_REPORT;
      case GET_CERTIFICATE_STATUS -> Ocpp201Actions.GET_CERTIFICATE_STATUS;
      case GET_CHARGING_PROFILES -> Ocpp201Actions.GET_CHARGING_PROFILES;
      case GET_COMPOSITE_SCHEDULE -> Ocpp201Actions.GET_COMPOSITE_SCHEDULE;
      case GET_DISPLAY_MESSAGES -> Ocpp201Actions.GET_DISPLAY_MESSAGES;
      case GET_INSTALLED_CERTIFICATE_IDS -> Ocpp201Actions.GET_INSTALLED_CERTIFICATE_IDS;
      case GET_LOCAL_LIST_VERSION -> Ocpp201Actions.GET_LOCAL_LIST_VERSION;
      case GET_LOG -> Ocpp201Actions.GET_LOG;
      case GET_MONITORING_REPORT -> Ocpp201Actions.GET_MONITORING_REPORT;
      case GET_REPORT -> Ocpp201Actions.GET_REPORT;
      case GET_TRANSACTION_STATUS -> Ocpp201Actions.GET_TRANSACTION_STATUS;
      case GET_VARIABLES -> Ocpp201Actions.GET_VARIABLES;
      case HEARTBEAT -> Ocpp201Actions.HEARTBEAT;
      case INSTALL_CERTIFICATE -> Ocpp201Actions.INSTALL_CERTIFICATE;
      case LOG_STATUS_NOTIFICATION -> Ocpp201Actions.LOG_STATUS_NOTIFICATION;
      case METER_VALUES -> Ocpp201Actions.METER_VALUES;
      case NOTIFY_CHARGING_LIMIT -> Ocpp201Actions.NOTIFY_CHARGING_LIMIT;
      case NOTIFY_CUSTOMER_INFORMATION -> Ocpp201Actions.NOTIFY_CUSTOMER_INFORMATION;
      case NOTIFY_DISPLAY_MESSAGES -> Ocpp201Actions.NOTIFY_DISPLAY_MESSAGES;
      case NOTIFY_EVCHARGING_NEEDS -> Ocpp201Actions.NOTIFY_EVCHARGING_NEEDS;
      case NOTIFY_EVCHARGING_SCHEDULE -> Ocpp201Actions.NOTIFY_EVCHARGING_SCHEDULE;
      case NOTIFY_EVENT -> Ocpp201Actions.NOTIFY_EVENT;
      case NOTIFY_MONITORING_REPORT -> Ocpp201Actions.NOTIFY_MONITORING_REPORT;
      case NOTIFY_REPORT -> Ocpp201Actions.NOTIFY_REPORT;
      case PUBLISH_FIRMWARE -> Ocpp201Actions.PUBLISH_FIRMWARE;
      case PUBLISH_FIRMWARE_STATUS_NOTIFICATION ->
        Ocpp201Actions.PUBLISH_FIRMWARE_STATUS_NOTIFICATION;
      case REPORT_CHARGING_PROFILES -> Ocpp201Actions.REPORT_CHARGING_PROFILES;
      case REQUEST_START_TRANSACTION -> Ocpp201Actions.REQUEST_START_TRANSACTION;
      case REQUEST_STOP_TRANSACTION -> Ocpp201Actions.REQUEST_STOP_TRANSACTION;
      case RESERVATION_STATUS_UPDATE -> Ocpp201Actions.RESERVATION_STATUS_UPDATE;
      case RESERVE_NOW -> Ocpp201Actions.RESERVE_NOW;
      case RESET -> Ocpp201Actions.RESET;
      case SECURITY_EVENT_NOTIFICATION -> Ocpp201Actions.SECURITY_EVENT_NOTIFICATION;
      case SEND_LOCAL_LIST -> Ocpp201Actions.SEND_LOCAL_LIST;
      case SET_CHARGING_PROFILE -> Ocpp201Actions.SET_CHARGING_PROFILE;
      case SET_DISPLAY_MESSAGE -> Ocpp201Actions.SET_DISPLAY_MESSAGE;
      case SET_MONITORING_BASE -> Ocpp201Actions.SET_MONITORING_BASE;
      case SET_MONITORING_LEVEL -> Ocpp201Actions.SET_MONITORING_LEVEL;
      case SET_NETWORK_PROFILE -> Ocpp201Actions.SET_NETWORK_PROFILE;
      case SET_VARIABLE_MONITORING -> Ocpp201Actions.SET_VARIABLE_MONITORING;
      case SET_VARIABLES -> Ocpp201Actions.SET_VARIABLES;
      case SIGN_CERTIFICATE -> Ocpp201Actions.SIGN_CERTIFICATE;
      case STATUS_NOTIFICATION -> Ocpp201Actions.STATUS_NOTIFICATION;
      case TRANSACTION_EVENT -> Ocpp201Actions.TRANSACTION_EVENT;
      case TRIGGER_MESSAGE -> Ocpp201Actions.TRIGGER_MESSAGE;
      case UNLOCK_CONNECTOR -> Ocpp201Actions.UNLOCK_CONNECTOR;
      case UNPUBLISH_FIRMWARE -> Ocpp201Actions.UNPUBLISH_FIRMWARE;
      case UPDATE_FIRMWARE -> Ocpp201Actions.UPDATE_FIRMWARE;
    };
  }
}
