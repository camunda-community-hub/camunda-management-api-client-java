package io.camunda.management.api.client.impl;

import io.camunda.management.api.client.api.CamundaManagementApiClient.Members;
import io.camunda.management.api.client.exception.CamundaConsoleClientException;
import io.camunda.management.api.client.invoker.ApiException;
import io.camunda.management.api.client.model.Member;
import java.util.List;

public class MembersImpl extends AbstractCamundaManagementApiClient implements Members {
  public MembersImpl(AbstractCamundaManagementApiClient managementApiClient) {
    super(managementApiClient);
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
