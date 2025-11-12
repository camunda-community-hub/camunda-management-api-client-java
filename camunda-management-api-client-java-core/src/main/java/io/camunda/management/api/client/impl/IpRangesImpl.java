package io.camunda.management.api.client.impl;

import io.camunda.management.api.client.api.CamundaManagementApiClient.IpRanges;
import io.camunda.management.api.client.exception.CamundaConsoleClientException;
import io.camunda.management.api.client.invoker.ApiException;
import io.camunda.management.api.client.model.MetaDto;

public class IpRangesImpl extends AbstractCamundaManagementApiClient implements IpRanges {
  public IpRangesImpl(AbstractCamundaManagementApiClient managementApiClient) {
    super(managementApiClient);
  }

  @Override
  public MetaDto ipRanges() {
    try {
      return getApi().getMeta();
    } catch (ApiException e) {
      throw new CamundaConsoleClientException(e);
    }
  }
}
