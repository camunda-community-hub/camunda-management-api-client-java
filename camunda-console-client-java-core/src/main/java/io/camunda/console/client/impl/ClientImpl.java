package io.camunda.console.client.impl;

import io.camunda.console.client.api.CamundaConsoleClient.Cluster.Client;
import io.camunda.console.client.exception.CamundaConsoleClientException;
import io.camunda.console.client.invoker.ApiException;
import io.camunda.console.client.model.ClusterClientConnectionDetails;

public class ClientImpl extends AbstractCluster implements Client {
  private final String clientId;

  public ClientImpl(AbstractCluster cluster, String clientId) {
    super(cluster);
    this.clientId = clientId;
  }

  @Override
  public ClusterClientConnectionDetails get() {
    try {
      return getApi().getClient(getClusterId(), clientId);
    } catch (ApiException e) {
      throw new CamundaConsoleClientException(e);
    }
  }

  @Override
  public void delete() {
    try {
      getApi().deleteClient(getClusterId(), clientId);
    } catch (ApiException e) {
      throw new CamundaConsoleClientException(e);
    }
  }
}
