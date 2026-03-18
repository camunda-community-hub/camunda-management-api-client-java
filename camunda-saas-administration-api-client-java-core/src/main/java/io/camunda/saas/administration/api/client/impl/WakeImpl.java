package io.camunda.saas.administration.api.client.impl;

import io.camunda.saas.administration.api.client.api.CamundaSaasAdministrationApiClient.Cluster.Wake;
import io.camunda.saas.administration.api.client.exception.CamundaConsoleClientException;
import io.camunda.saas.administration.api.client.gen.invoker.ApiException;

public class WakeImpl extends AbstractCluster implements Wake {

  public WakeImpl(AbstractCluster cluster) {
    super(cluster);
  }

  @Override
  public void put() {
    try {
      getApi().wake(getClusterId());
    } catch (ApiException e) {
      throw new CamundaConsoleClientException(e);
    }
  }
}
