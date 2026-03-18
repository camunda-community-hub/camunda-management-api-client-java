package io.camunda.saas.administration.api.client.impl;

import io.camunda.saas.administration.api.client.api.CamundaSaasAdministrationApiClient.IpRanges;
import io.camunda.saas.administration.api.client.api.model.IpRangesResponse;
import io.camunda.saas.administration.api.client.exception.CamundaConsoleClientException;
import io.camunda.saas.administration.api.client.gen.invoker.ApiException;

public class IpRangesImpl extends AbstractCamundaSaasAdministrationApiClient implements IpRanges {
  public IpRangesImpl(AbstractCamundaSaasAdministrationApiClient saasAdministrationApiClient) {
    super(saasAdministrationApiClient);
  }

  @Override
  public IpRangesResponse get() {
    try {
      return ModelMapper.from(getApi().getMeta());
    } catch (ApiException e) {
      throw new CamundaConsoleClientException(e);
    }
  }
}
