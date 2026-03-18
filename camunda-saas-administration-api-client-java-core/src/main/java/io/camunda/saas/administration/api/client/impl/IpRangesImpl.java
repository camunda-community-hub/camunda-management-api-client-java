package io.camunda.saas.administration.api.client.impl;

import io.camunda.saas.administration.api.client.api.CamundaSaasAdministrationApiClient.IpRanges;
import io.camunda.saas.administration.api.client.exception.CamundaConsoleClientException;
import io.camunda.saas.administration.api.client.invoker.ApiException;
import io.camunda.saas.administration.api.client.model.MetaDto;

public class IpRangesImpl extends AbstractCamundaSaasAdministrationApiClient implements IpRanges {
  public IpRangesImpl(AbstractCamundaSaasAdministrationApiClient saasAdministrationApiClient) {
    super(saasAdministrationApiClient);
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
