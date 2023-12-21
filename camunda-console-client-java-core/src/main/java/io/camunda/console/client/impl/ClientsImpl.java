package io.camunda.console.client.impl;

import io.camunda.console.client.api.CamundaConsoleClient.Cluster.Clients;
import io.camunda.console.client.exception.CamundaConsoleClientException;
import io.camunda.console.client.invoker.ApiException;
import io.camunda.console.client.model.ClusterClient;
import io.camunda.console.client.model.CreateClusterClientBody;
import io.camunda.console.client.model.CreatedClusterClient;
import java.util.List;

public class ClientsImpl extends AbstractCluster implements Clients {

  public ClientsImpl(AbstractCluster cluster) {
    super(cluster);
  }

  @Override
  public List<ClusterClient> get() {
    try {
      return getApi().getClients(getClusterId());
    } catch (ApiException e) {
      throw new CamundaConsoleClientException(e);
    }
  }

  @Override
  public CreatedClusterClient post(CreateClusterClientBody request) {
    try {
      return getApi().createClient(getClusterId(), request);
    } catch (ApiException e) {
      throw new CamundaConsoleClientException(e);
    }
  }
}
