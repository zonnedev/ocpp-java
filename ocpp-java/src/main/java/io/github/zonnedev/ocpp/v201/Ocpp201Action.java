package io.github.zonnedev.ocpp.v201;

import io.github.zonnedev.ocpp.api.OcppAction;
import io.github.zonnedev.ocpp.api.OcppVersion;
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
import java.util.Objects;

/** Complete finite action inventory for v201. */
public enum Ocpp201Action implements OcppAction {
  AUTHORIZE("Authorize", AuthorizeRequest.class, AuthorizeResponse.class), BOOT_NOTIFICATION(
    "BootNotification", BootNotificationRequest.class, BootNotificationResponse.class
  ), CANCEL_RESERVATION(
    "CancelReservation", CancelReservationRequest.class, CancelReservationResponse.class
  ), CERTIFICATE_SIGNED(
    "CertificateSigned", CertificateSignedRequest.class, CertificateSignedResponse.class
  ), CHANGE_AVAILABILITY(
    "ChangeAvailability", ChangeAvailabilityRequest.class, ChangeAvailabilityResponse.class
  ), CLEAR_CACHE(
    "ClearCache", ClearCacheRequest.class, ClearCacheResponse.class
  ), CLEAR_CHARGING_PROFILE(
    "ClearChargingProfile", ClearChargingProfileRequest.class, ClearChargingProfileResponse.class
  ), CLEAR_DISPLAY_MESSAGE(
    "ClearDisplayMessage", ClearDisplayMessageRequest.class, ClearDisplayMessageResponse.class
  ), CLEAR_VARIABLE_MONITORING(
    "ClearVariableMonitoring", ClearVariableMonitoringRequest.class,
    ClearVariableMonitoringResponse.class
  ), CLEARED_CHARGING_LIMIT(
    "ClearedChargingLimit", ClearedChargingLimitRequest.class, ClearedChargingLimitResponse.class
  ), COST_UPDATED(
    "CostUpdated", CostUpdatedRequest.class, CostUpdatedResponse.class
  ), CUSTOMER_INFORMATION(
    "CustomerInformation", CustomerInformationRequest.class, CustomerInformationResponse.class
  ), DATA_TRANSFER(
    "DataTransfer", DataTransferRequest.class, DataTransferResponse.class
  ), DELETE_CERTIFICATE(
    "DeleteCertificate", DeleteCertificateRequest.class, DeleteCertificateResponse.class
  ), FIRMWARE_STATUS_NOTIFICATION(
    "FirmwareStatusNotification", FirmwareStatusNotificationRequest.class,
    FirmwareStatusNotificationResponse.class
  ), GET15118_EVCERTIFICATE(
    "Get15118EVCertificate", Get15118EVCertificateRequest.class, Get15118EVCertificateResponse.class
  ), GET_BASE_REPORT(
    "GetBaseReport", GetBaseReportRequest.class, GetBaseReportResponse.class
  ), GET_CERTIFICATE_STATUS(
    "GetCertificateStatus", GetCertificateStatusRequest.class, GetCertificateStatusResponse.class
  ), GET_CHARGING_PROFILES(
    "GetChargingProfiles", GetChargingProfilesRequest.class, GetChargingProfilesResponse.class
  ), GET_COMPOSITE_SCHEDULE(
    "GetCompositeSchedule", GetCompositeScheduleRequest.class, GetCompositeScheduleResponse.class
  ), GET_DISPLAY_MESSAGES(
    "GetDisplayMessages", GetDisplayMessagesRequest.class, GetDisplayMessagesResponse.class
  ), GET_INSTALLED_CERTIFICATE_IDS(
    "GetInstalledCertificateIds", GetInstalledCertificateIdsRequest.class,
    GetInstalledCertificateIdsResponse.class
  ), GET_LOCAL_LIST_VERSION(
    "GetLocalListVersion", GetLocalListVersionRequest.class, GetLocalListVersionResponse.class
  ), GET_LOG("GetLog", GetLogRequest.class, GetLogResponse.class), GET_MONITORING_REPORT(
    "GetMonitoringReport", GetMonitoringReportRequest.class, GetMonitoringReportResponse.class
  ), GET_REPORT(
    "GetReport", GetReportRequest.class, GetReportResponse.class
  ), GET_TRANSACTION_STATUS(
    "GetTransactionStatus", GetTransactionStatusRequest.class, GetTransactionStatusResponse.class
  ), GET_VARIABLES(
    "GetVariables", GetVariablesRequest.class, GetVariablesResponse.class
  ), HEARTBEAT("Heartbeat", HeartbeatRequest.class, HeartbeatResponse.class), INSTALL_CERTIFICATE(
    "InstallCertificate", InstallCertificateRequest.class, InstallCertificateResponse.class
  ), LOG_STATUS_NOTIFICATION(
    "LogStatusNotification", LogStatusNotificationRequest.class, LogStatusNotificationResponse.class
  ), METER_VALUES(
    "MeterValues", MeterValuesRequest.class, MeterValuesResponse.class
  ), NOTIFY_CHARGING_LIMIT(
    "NotifyChargingLimit", NotifyChargingLimitRequest.class, NotifyChargingLimitResponse.class
  ), NOTIFY_CUSTOMER_INFORMATION(
    "NotifyCustomerInformation", NotifyCustomerInformationRequest.class,
    NotifyCustomerInformationResponse.class
  ), NOTIFY_DISPLAY_MESSAGES(
    "NotifyDisplayMessages", NotifyDisplayMessagesRequest.class, NotifyDisplayMessagesResponse.class
  ), NOTIFY_EVCHARGING_NEEDS(
    "NotifyEVChargingNeeds", NotifyEVChargingNeedsRequest.class, NotifyEVChargingNeedsResponse.class
  ), NOTIFY_EVCHARGING_SCHEDULE(
    "NotifyEVChargingSchedule", NotifyEVChargingScheduleRequest.class,
    NotifyEVChargingScheduleResponse.class
  ), NOTIFY_EVENT(
    "NotifyEvent", NotifyEventRequest.class, NotifyEventResponse.class
  ), NOTIFY_MONITORING_REPORT(
    "NotifyMonitoringReport", NotifyMonitoringReportRequest.class,
    NotifyMonitoringReportResponse.class
  ), NOTIFY_REPORT(
    "NotifyReport", NotifyReportRequest.class, NotifyReportResponse.class
  ), PUBLISH_FIRMWARE(
    "PublishFirmware", PublishFirmwareRequest.class, PublishFirmwareResponse.class
  ), PUBLISH_FIRMWARE_STATUS_NOTIFICATION(
    "PublishFirmwareStatusNotification", PublishFirmwareStatusNotificationRequest.class,
    PublishFirmwareStatusNotificationResponse.class
  ), REPORT_CHARGING_PROFILES(
    "ReportChargingProfiles", ReportChargingProfilesRequest.class,
    ReportChargingProfilesResponse.class
  ), REQUEST_START_TRANSACTION(
    "RequestStartTransaction", RequestStartTransactionRequest.class,
    RequestStartTransactionResponse.class
  ), REQUEST_STOP_TRANSACTION(
    "RequestStopTransaction", RequestStopTransactionRequest.class,
    RequestStopTransactionResponse.class
  ), RESERVATION_STATUS_UPDATE(
    "ReservationStatusUpdate", ReservationStatusUpdateRequest.class,
    ReservationStatusUpdateResponse.class
  ), RESERVE_NOW("ReserveNow", ReserveNowRequest.class, ReserveNowResponse.class), RESET(
    "Reset", ResetRequest.class, ResetResponse.class
  ), SECURITY_EVENT_NOTIFICATION(
    "SecurityEventNotification", SecurityEventNotificationRequest.class,
    SecurityEventNotificationResponse.class
  ), SEND_LOCAL_LIST(
    "SendLocalList", SendLocalListRequest.class, SendLocalListResponse.class
  ), SET_CHARGING_PROFILE(
    "SetChargingProfile", SetChargingProfileRequest.class, SetChargingProfileResponse.class
  ), SET_DISPLAY_MESSAGE(
    "SetDisplayMessage", SetDisplayMessageRequest.class, SetDisplayMessageResponse.class
  ), SET_MONITORING_BASE(
    "SetMonitoringBase", SetMonitoringBaseRequest.class, SetMonitoringBaseResponse.class
  ), SET_MONITORING_LEVEL(
    "SetMonitoringLevel", SetMonitoringLevelRequest.class, SetMonitoringLevelResponse.class
  ), SET_NETWORK_PROFILE(
    "SetNetworkProfile", SetNetworkProfileRequest.class, SetNetworkProfileResponse.class
  ), SET_VARIABLE_MONITORING(
    "SetVariableMonitoring", SetVariableMonitoringRequest.class, SetVariableMonitoringResponse.class
  ), SET_VARIABLES(
    "SetVariables", SetVariablesRequest.class, SetVariablesResponse.class
  ), SIGN_CERTIFICATE(
    "SignCertificate", SignCertificateRequest.class, SignCertificateResponse.class
  ), STATUS_NOTIFICATION(
    "StatusNotification", StatusNotificationRequest.class, StatusNotificationResponse.class
  ), TRANSACTION_EVENT(
    "TransactionEvent", TransactionEventRequest.class, TransactionEventResponse.class
  ), TRIGGER_MESSAGE(
    "TriggerMessage", TriggerMessageRequest.class, TriggerMessageResponse.class
  ), UNLOCK_CONNECTOR(
    "UnlockConnector", UnlockConnectorRequest.class, UnlockConnectorResponse.class
  ), UNPUBLISH_FIRMWARE(
    "UnpublishFirmware", UnpublishFirmwareRequest.class, UnpublishFirmwareResponse.class
  ), UPDATE_FIRMWARE("UpdateFirmware", UpdateFirmwareRequest.class, UpdateFirmwareResponse.class);

  private final String wireName;
  private final Class<? extends Ocpp201Request> requestType;
  private final Class<? extends Ocpp201Response> responseType;

  Ocpp201Action(
    String wireName,
    Class<? extends Ocpp201Request> requestType,
    Class<? extends Ocpp201Response> responseType
  ) {
    this.wireName = Objects.requireNonNull(
      wireName,
      "wireName"
    );
    this.requestType = Objects.requireNonNull(
      requestType,
      "requestType"
    );
    this.responseType = Objects.requireNonNull(
      responseType,
      "responseType"
    );
  }
  public String wireName() {
    return wireName;
  }
  public OcppVersion version() {
    return OcppVersion.OCPP_2_0_1;
  }
  public Class<? extends Ocpp201Request> requestType() {
    return requestType;
  }
  public Class<? extends Ocpp201Response> responseType() {
    return responseType;
  }
  public static Ocpp201Action fromWireName(String wireName) {
    Objects.requireNonNull(
      wireName,
      "wireName"
    );
    return switch (wireName) {
      case "Authorize" -> AUTHORIZE;
      case "BootNotification" -> BOOT_NOTIFICATION;
      case "CancelReservation" -> CANCEL_RESERVATION;
      case "CertificateSigned" -> CERTIFICATE_SIGNED;
      case "ChangeAvailability" -> CHANGE_AVAILABILITY;
      case "ClearCache" -> CLEAR_CACHE;
      case "ClearChargingProfile" -> CLEAR_CHARGING_PROFILE;
      case "ClearDisplayMessage" -> CLEAR_DISPLAY_MESSAGE;
      case "ClearVariableMonitoring" -> CLEAR_VARIABLE_MONITORING;
      case "ClearedChargingLimit" -> CLEARED_CHARGING_LIMIT;
      case "CostUpdated" -> COST_UPDATED;
      case "CustomerInformation" -> CUSTOMER_INFORMATION;
      case "DataTransfer" -> DATA_TRANSFER;
      case "DeleteCertificate" -> DELETE_CERTIFICATE;
      case "FirmwareStatusNotification" -> FIRMWARE_STATUS_NOTIFICATION;
      case "Get15118EVCertificate" -> GET15118_EVCERTIFICATE;
      case "GetBaseReport" -> GET_BASE_REPORT;
      case "GetCertificateStatus" -> GET_CERTIFICATE_STATUS;
      case "GetChargingProfiles" -> GET_CHARGING_PROFILES;
      case "GetCompositeSchedule" -> GET_COMPOSITE_SCHEDULE;
      case "GetDisplayMessages" -> GET_DISPLAY_MESSAGES;
      case "GetInstalledCertificateIds" -> GET_INSTALLED_CERTIFICATE_IDS;
      case "GetLocalListVersion" -> GET_LOCAL_LIST_VERSION;
      case "GetLog" -> GET_LOG;
      case "GetMonitoringReport" -> GET_MONITORING_REPORT;
      case "GetReport" -> GET_REPORT;
      case "GetTransactionStatus" -> GET_TRANSACTION_STATUS;
      case "GetVariables" -> GET_VARIABLES;
      case "Heartbeat" -> HEARTBEAT;
      case "InstallCertificate" -> INSTALL_CERTIFICATE;
      case "LogStatusNotification" -> LOG_STATUS_NOTIFICATION;
      case "MeterValues" -> METER_VALUES;
      case "NotifyChargingLimit" -> NOTIFY_CHARGING_LIMIT;
      case "NotifyCustomerInformation" -> NOTIFY_CUSTOMER_INFORMATION;
      case "NotifyDisplayMessages" -> NOTIFY_DISPLAY_MESSAGES;
      case "NotifyEVChargingNeeds" -> NOTIFY_EVCHARGING_NEEDS;
      case "NotifyEVChargingSchedule" -> NOTIFY_EVCHARGING_SCHEDULE;
      case "NotifyEvent" -> NOTIFY_EVENT;
      case "NotifyMonitoringReport" -> NOTIFY_MONITORING_REPORT;
      case "NotifyReport" -> NOTIFY_REPORT;
      case "PublishFirmware" -> PUBLISH_FIRMWARE;
      case "PublishFirmwareStatusNotification" -> PUBLISH_FIRMWARE_STATUS_NOTIFICATION;
      case "ReportChargingProfiles" -> REPORT_CHARGING_PROFILES;
      case "RequestStartTransaction" -> REQUEST_START_TRANSACTION;
      case "RequestStopTransaction" -> REQUEST_STOP_TRANSACTION;
      case "ReservationStatusUpdate" -> RESERVATION_STATUS_UPDATE;
      case "ReserveNow" -> RESERVE_NOW;
      case "Reset" -> RESET;
      case "SecurityEventNotification" -> SECURITY_EVENT_NOTIFICATION;
      case "SendLocalList" -> SEND_LOCAL_LIST;
      case "SetChargingProfile" -> SET_CHARGING_PROFILE;
      case "SetDisplayMessage" -> SET_DISPLAY_MESSAGE;
      case "SetMonitoringBase" -> SET_MONITORING_BASE;
      case "SetMonitoringLevel" -> SET_MONITORING_LEVEL;
      case "SetNetworkProfile" -> SET_NETWORK_PROFILE;
      case "SetVariableMonitoring" -> SET_VARIABLE_MONITORING;
      case "SetVariables" -> SET_VARIABLES;
      case "SignCertificate" -> SIGN_CERTIFICATE;
      case "StatusNotification" -> STATUS_NOTIFICATION;
      case "TransactionEvent" -> TRANSACTION_EVENT;
      case "TriggerMessage" -> TRIGGER_MESSAGE;
      case "UnlockConnector" -> UNLOCK_CONNECTOR;
      case "UnpublishFirmware" -> UNPUBLISH_FIRMWARE;
      case "UpdateFirmware" -> UPDATE_FIRMWARE;
      default -> throw new IllegalArgumentException("Unknown v201 action: " + wireName);
    };
  }
}
