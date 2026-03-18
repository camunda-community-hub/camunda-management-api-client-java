package io.camunda.saas.administration.api.client.api.model;

public record BackupResponse(
    String uuid,
    String name,
    String created,
    String completed,
    Status status,
    Status zeebeStatus,
    Status tasklistStatus,
    Status operateStatus,
    Status optimizeStatus) {

  public enum Status {
    IN_PROGRESS,
    FAILED,
    COMPLETE,
    MINUS
  }
}
