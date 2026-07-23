package io.github.zonnedev.ocpp.v16;

import io.github.zonnedev.ocpp.api.OcppAction;
import io.github.zonnedev.ocpp.api.OcppVersion;
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
import java.util.Objects;

/** Complete finite action inventory for v16. */
public enum Ocpp16Action implements OcppAction {
  AUTHORIZE("Authorize", AuthorizeRequest.class, AuthorizeResponse.class), BOOT_NOTIFICATION(
    "BootNotification", BootNotificationRequest.class, BootNotificationResponse.class
  ), CANCEL_RESERVATION(
    "CancelReservation", CancelReservationRequest.class, CancelReservationResponse.class
  ), CERTIFICATE_SIGNED(
    "CertificateSigned", CertificateSignedRequest.class, CertificateSignedResponse.class
  ), CHANGE_AVAILABILITY(
    "ChangeAvailability", ChangeAvailabilityRequest.class, ChangeAvailabilityResponse.class
  ), CHANGE_CONFIGURATION(
    "ChangeConfiguration", ChangeConfigurationRequest.class, ChangeConfigurationResponse.class
  ), CLEAR_CACHE(
    "ClearCache", ClearCacheRequest.class, ClearCacheResponse.class
  ), CLEAR_CHARGING_PROFILE(
    "ClearChargingProfile", ClearChargingProfileRequest.class, ClearChargingProfileResponse.class
  ), DATA_TRANSFER(
    "DataTransfer", DataTransferRequest.class, DataTransferResponse.class
  ), DELETE_CERTIFICATE(
    "DeleteCertificate", DeleteCertificateRequest.class, DeleteCertificateResponse.class
  ), DIAGNOSTICS_STATUS_NOTIFICATION(
    "DiagnosticsStatusNotification", DiagnosticsStatusNotificationRequest.class,
    DiagnosticsStatusNotificationResponse.class
  ), EXTENDED_TRIGGER_MESSAGE(
    "ExtendedTriggerMessage", ExtendedTriggerMessageRequest.class,
    ExtendedTriggerMessageResponse.class
  ), FIRMWARE_STATUS_NOTIFICATION(
    "FirmwareStatusNotification", FirmwareStatusNotificationRequest.class,
    FirmwareStatusNotificationResponse.class
  ), GET_COMPOSITE_SCHEDULE(
    "GetCompositeSchedule", GetCompositeScheduleRequest.class, GetCompositeScheduleResponse.class
  ), GET_CONFIGURATION(
    "GetConfiguration", GetConfigurationRequest.class, GetConfigurationResponse.class
  ), GET_DIAGNOSTICS(
    "GetDiagnostics", GetDiagnosticsRequest.class, GetDiagnosticsResponse.class
  ), GET_INSTALLED_CERTIFICATE_IDS(
    "GetInstalledCertificateIds", GetInstalledCertificateIdsRequest.class,
    GetInstalledCertificateIdsResponse.class
  ), GET_LOCAL_LIST_VERSION(
    "GetLocalListVersion", GetLocalListVersionRequest.class, GetLocalListVersionResponse.class
  ), GET_LOG("GetLog", GetLogRequest.class, GetLogResponse.class), HEARTBEAT(
    "Heartbeat", HeartbeatRequest.class, HeartbeatResponse.class
  ), INSTALL_CERTIFICATE(
    "InstallCertificate", InstallCertificateRequest.class, InstallCertificateResponse.class
  ), LOG_STATUS_NOTIFICATION(
    "LogStatusNotification", LogStatusNotificationRequest.class, LogStatusNotificationResponse.class
  ), METER_VALUES(
    "MeterValues", MeterValuesRequest.class, MeterValuesResponse.class
  ), REMOTE_START_TRANSACTION(
    "RemoteStartTransaction", RemoteStartTransactionRequest.class,
    RemoteStartTransactionResponse.class
  ), REMOTE_STOP_TRANSACTION(
    "RemoteStopTransaction", RemoteStopTransactionRequest.class, RemoteStopTransactionResponse.class
  ), RESERVE_NOW("ReserveNow", ReserveNowRequest.class, ReserveNowResponse.class), RESET(
    "Reset", ResetRequest.class, ResetResponse.class
  ), SECURITY_EVENT_NOTIFICATION(
    "SecurityEventNotification", SecurityEventNotificationRequest.class,
    SecurityEventNotificationResponse.class
  ), SEND_LOCAL_LIST(
    "SendLocalList", SendLocalListRequest.class, SendLocalListResponse.class
  ), SET_CHARGING_PROFILE(
    "SetChargingProfile", SetChargingProfileRequest.class, SetChargingProfileResponse.class
  ), SIGN_CERTIFICATE(
    "SignCertificate", SignCertificateRequest.class, SignCertificateResponse.class
  ), SIGNED_FIRMWARE_STATUS_NOTIFICATION(
    "SignedFirmwareStatusNotification", SignedFirmwareStatusNotificationRequest.class,
    SignedFirmwareStatusNotificationResponse.class
  ), SIGNED_UPDATE_FIRMWARE(
    "SignedUpdateFirmware", SignedUpdateFirmwareRequest.class, SignedUpdateFirmwareResponse.class
  ), START_TRANSACTION(
    "StartTransaction", StartTransactionRequest.class, StartTransactionResponse.class
  ), STATUS_NOTIFICATION(
    "StatusNotification", StatusNotificationRequest.class, StatusNotificationResponse.class
  ), STOP_TRANSACTION(
    "StopTransaction", StopTransactionRequest.class, StopTransactionResponse.class
  ), TRIGGER_MESSAGE(
    "TriggerMessage", TriggerMessageRequest.class, TriggerMessageResponse.class
  ), UNLOCK_CONNECTOR(
    "UnlockConnector", UnlockConnectorRequest.class, UnlockConnectorResponse.class
  ), UPDATE_FIRMWARE("UpdateFirmware", UpdateFirmwareRequest.class, UpdateFirmwareResponse.class);

  private final String wireName;
  private final Class<? extends Ocpp16Request> requestType;
  private final Class<? extends Ocpp16Response> responseType;

  Ocpp16Action(
    String wireName,
    Class<? extends Ocpp16Request> requestType,
    Class<? extends Ocpp16Response> responseType
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
    return OcppVersion.OCPP_1_6_JSON;
  }
  public Class<? extends Ocpp16Request> requestType() {
    return requestType;
  }
  public Class<? extends Ocpp16Response> responseType() {
    return responseType;
  }
  public static Ocpp16Action fromWireName(String wireName) {
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
      case "ChangeConfiguration" -> CHANGE_CONFIGURATION;
      case "ClearCache" -> CLEAR_CACHE;
      case "ClearChargingProfile" -> CLEAR_CHARGING_PROFILE;
      case "DataTransfer" -> DATA_TRANSFER;
      case "DeleteCertificate" -> DELETE_CERTIFICATE;
      case "DiagnosticsStatusNotification" -> DIAGNOSTICS_STATUS_NOTIFICATION;
      case "ExtendedTriggerMessage" -> EXTENDED_TRIGGER_MESSAGE;
      case "FirmwareStatusNotification" -> FIRMWARE_STATUS_NOTIFICATION;
      case "GetCompositeSchedule" -> GET_COMPOSITE_SCHEDULE;
      case "GetConfiguration" -> GET_CONFIGURATION;
      case "GetDiagnostics" -> GET_DIAGNOSTICS;
      case "GetInstalledCertificateIds" -> GET_INSTALLED_CERTIFICATE_IDS;
      case "GetLocalListVersion" -> GET_LOCAL_LIST_VERSION;
      case "GetLog" -> GET_LOG;
      case "Heartbeat" -> HEARTBEAT;
      case "InstallCertificate" -> INSTALL_CERTIFICATE;
      case "LogStatusNotification" -> LOG_STATUS_NOTIFICATION;
      case "MeterValues" -> METER_VALUES;
      case "RemoteStartTransaction" -> REMOTE_START_TRANSACTION;
      case "RemoteStopTransaction" -> REMOTE_STOP_TRANSACTION;
      case "ReserveNow" -> RESERVE_NOW;
      case "Reset" -> RESET;
      case "SecurityEventNotification" -> SECURITY_EVENT_NOTIFICATION;
      case "SendLocalList" -> SEND_LOCAL_LIST;
      case "SetChargingProfile" -> SET_CHARGING_PROFILE;
      case "SignCertificate" -> SIGN_CERTIFICATE;
      case "SignedFirmwareStatusNotification" -> SIGNED_FIRMWARE_STATUS_NOTIFICATION;
      case "SignedUpdateFirmware" -> SIGNED_UPDATE_FIRMWARE;
      case "StartTransaction" -> START_TRANSACTION;
      case "StatusNotification" -> STATUS_NOTIFICATION;
      case "StopTransaction" -> STOP_TRANSACTION;
      case "TriggerMessage" -> TRIGGER_MESSAGE;
      case "UnlockConnector" -> UNLOCK_CONNECTOR;
      case "UpdateFirmware" -> UPDATE_FIRMWARE;
      default -> throw new IllegalArgumentException("Unknown v16 action: " + wireName);
    };
  }
}
