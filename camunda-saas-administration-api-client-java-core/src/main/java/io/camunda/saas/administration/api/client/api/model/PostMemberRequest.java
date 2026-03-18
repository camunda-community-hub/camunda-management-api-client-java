package io.camunda.saas.administration.api.client.api.model;

import java.util.List;

public record PostMemberRequest(List<Role> orgRoles) {
  public enum Role {
    ADMIN,
    OPERATIONSENGINEER,
    TASKUSER,
    ANALYST,
    DEVELOPER,
    VISITOR,
    MODELER;
  }
}
