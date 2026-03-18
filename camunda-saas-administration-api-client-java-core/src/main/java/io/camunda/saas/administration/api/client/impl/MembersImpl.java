package io.camunda.saas.administration.api.client.impl;

import io.camunda.saas.administration.api.client.api.CamundaSaasAdministrationApiClient.Members;
import io.camunda.saas.administration.api.client.exception.CamundaConsoleClientException;
import io.camunda.saas.administration.api.client.invoker.ApiException;
import io.camunda.saas.administration.api.client.model.Member;
import java.util.List;

public class MembersImpl extends AbstractCamundaSaasAdministrationApiClient implements Members {
  public MembersImpl(AbstractCamundaSaasAdministrationApiClient saasAdministrationApiClient) {
    super(saasAdministrationApiClient);
  }

  @Override
  public List<Member> get() {
    try {
      return getApi().getMembers();
    } catch (ApiException e) {
      throw new CamundaConsoleClientException(e);
    }
  }
}
