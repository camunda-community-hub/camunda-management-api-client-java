package io.camunda.saas.administration.api.client.impl;

import io.camunda.saas.administration.api.client.api.CamundaSaasAdministrationApiClient.Clusters.Parameters;
import io.camunda.saas.administration.api.client.api.model.ParametersResponse;
import io.camunda.saas.administration.api.client.exception.CamundaConsoleClientException;
import io.camunda.saas.administration.api.client.gen.invoker.ApiException;

public class ParametersImpl extends AbstractCamundaSaasAdministrationApiClient
    implements Parameters {
  public ParametersImpl(AbstractCamundaSaasAdministrationApiClient saasAdministrationApiClient) {
    super(saasAdministrationApiClient);
  }

  @Override
  public ParametersResponse get() {
    try {
      return ModelMapper.from(getApi().getParameters());
    } catch (ApiException e) {
      throw new CamundaConsoleClientException(e);
    }
  }
}
