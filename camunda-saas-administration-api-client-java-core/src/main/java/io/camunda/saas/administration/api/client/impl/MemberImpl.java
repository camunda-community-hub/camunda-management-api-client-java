package io.camunda.saas.administration.api.client.impl;

import io.camunda.saas.administration.api.client.api.CamundaSaasAdministrationApiClient.Member;
import io.camunda.saas.administration.api.client.exception.CamundaConsoleClientException;
import io.camunda.saas.administration.api.client.invoker.ApiException;
import io.camunda.saas.administration.api.client.model.PostMemberBody;

public class MemberImpl extends AbstractCamundaSaasAdministrationApiClient implements Member {
  private final String email;

  public MemberImpl(
      AbstractCamundaSaasAdministrationApiClient saasAdministrationApiClient, String email) {
    super(saasAdministrationApiClient);
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
