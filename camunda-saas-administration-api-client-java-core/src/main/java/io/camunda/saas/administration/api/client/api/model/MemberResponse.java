package io.camunda.saas.administration.api.client.api.model;

import java.util.List;

public record MemberResponse(String name, String email, List<Role> roles, Boolean invitePending) {
  public enum Role {
    MEMBER,
    ADMIN,
    ORGANIZATIONADMIN,
    ORGANIZATIONOWNER,
    OWNER,
    SUPPORTAGENT,
    OPERATIONSENGINEER,
    TASKUSER,
    ANALYST,
    DEVELOPER,
    VISITOR,
    MODELER
  }
}
