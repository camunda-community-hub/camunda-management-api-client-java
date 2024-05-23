package io.camunda.management.api.client.impl;

import io.camunda.management.api.client.api.CamundaManagementApiClient.Member;
import io.camunda.management.api.client.exception.CamundaConsoleClientException;
import io.camunda.management.api.client.invoker.ApiException;
import io.camunda.management.api.client.model.PostMemberBody;

public class MemberImpl extends AbstractCamundaManagementApiClient implements Member {
  private final String email;

  public MemberImpl(AbstractCamundaManagementApiClient managementApiClient, String email) {
    super(managementApiClient);
    this.email = email;
  }

  @Override
  public void post(PostMemberBody request) {
    try {
      getApi().updateMembers(email, request);
    } catch (ApiException e) {
      throw new CamundaConsoleClientException(e);
    }
  }

  @Override
  public void delete() {
    try {
      getApi().deleteMember(email);
    } catch (ApiException e) {
      throw new CamundaConsoleClientException(e);
    }
  }
}
