package io.camunda.management.api.client.impl;

import io.camunda.management.api.client.api.CamundaManagementApiClient.Cluster.Wake;
import io.camunda.management.api.client.exception.CamundaConsoleClientException;
import io.camunda.management.api.client.invoker.ApiException;

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
