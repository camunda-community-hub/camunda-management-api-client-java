package io.camunda.saas.administration.api.client.impl;

import io.camunda.saas.administration.api.client.api.CamundaSaasAdministrationApiClient.Members;
import io.camunda.saas.administration.api.client.api.model.MemberResponse;
import io.camunda.saas.administration.api.client.exception.CamundaConsoleClientException;
import io.camunda.saas.administration.api.client.gen.invoker.ApiException;
import java.util.List;

public class MembersImpl extends AbstractCamundaSaasAdministrationApiClient implements Members {
  public MembersImpl(AbstractCamundaSaasAdministrationApiClient saasAdministrationApiClient) {
    super(saasAdministrationApiClient);
  }

  @Override
  public List<MemberResponse> get() {
    try {
      return ModelMapper.fromMemberList(getApi().getMembers());
    } catch (ApiException e) {
      throw new CamundaConsoleClientException(e);
    }
  }
}
