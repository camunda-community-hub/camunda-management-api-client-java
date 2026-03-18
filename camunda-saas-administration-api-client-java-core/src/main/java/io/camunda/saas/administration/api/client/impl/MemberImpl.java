package io.camunda.saas.administration.api.client.impl;

import io.camunda.saas.administration.api.client.api.CamundaSaasAdministrationApiClient.Member;
import io.camunda.saas.administration.api.client.api.model.PostMemberRequest;
import io.camunda.saas.administration.api.client.exception.CamundaConsoleClientException;
import io.camunda.saas.administration.api.client.gen.invoker.ApiException;

public class MemberImpl extends AbstractCamundaSaasAdministrationApiClient implements Member {
  private final String email;

  public MemberImpl(
      AbstractCamundaSaasAdministrationApiClient saasAdministrationApiClient, String email) {
    super(saasAdministrationApiClient);
    this.email = email;
  }

  @Override
  public void post(PostMemberRequest request) {
    try {
      getApi().updateMembers(email, ModelMapper.from(request));
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
