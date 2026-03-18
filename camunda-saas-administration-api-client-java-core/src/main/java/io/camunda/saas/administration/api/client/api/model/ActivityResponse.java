package io.camunda.saas.administration.api.client.api.model;

public record ActivityResponse(
    String service,
    String orgId,
    Double timestamp,
    String audit,
    AuditType auditType,
    String entity,
    String entityId,
    String parentEntity,
    String parentEntityId,
    String userId,
    String entityAttribute,
    String entityAttributeValueFrom,
    String entityAttributeValueTo) {
  public enum AuditType {
    C,
    R,
    U,
    D
  }
}
