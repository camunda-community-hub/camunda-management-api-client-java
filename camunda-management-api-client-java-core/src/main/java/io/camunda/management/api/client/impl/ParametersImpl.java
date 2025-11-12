package io.camunda.management.api.client.impl;

import io.camunda.management.api.client.api.CamundaManagementApiClient.Clusters.Parameters;
import io.camunda.management.api.client.exception.CamundaConsoleClientException;
import io.camunda.management.api.client.invoker.ApiException;

public class ParametersImpl extends AbstractCamundaManagementApiClient implements Parameters {
  public ParametersImpl(AbstractCamundaManagementApiClient managementApiClient) {
    super(managementApiClient);
  }

  @Override
  public io.camunda.management.api.client.model.Parameters get() {
    try {
      return getApi().getParameters();
    } catch (ApiException e) {
      throw new CamundaConsoleClientException(e);
    }
  }
}
