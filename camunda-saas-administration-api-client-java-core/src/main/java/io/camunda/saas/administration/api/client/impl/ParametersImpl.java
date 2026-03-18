package io.camunda.saas.administration.api.client.impl;

import io.camunda.saas.administration.api.client.api.CamundaSaasAdministrationApiClient.Clusters.Parameters;
import io.camunda.saas.administration.api.client.exception.CamundaConsoleClientException;
import io.camunda.saas.administration.api.client.invoker.ApiException;

public class ParametersImpl extends AbstractCamundaSaasAdministrationApiClient
    implements Parameters {
  public ParametersImpl(AbstractCamundaSaasAdministrationApiClient saasAdministrationApiClient) {
    super(saasAdministrationApiClient);
  }

  @Override
  public io.camunda.saas.administration.api.client.model.Parameters get() {
    try {
      return getApi().getParameters();
    } catch (ApiException e) {
      throw new CamundaConsoleClientException(e);
    }
  }
}
