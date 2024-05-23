package io.camunda.management.api.client.impl;

import io.camunda.management.api.client.api.CamundaManagementApiClient.Cluster.Clients;
import io.camunda.management.api.client.exception.CamundaConsoleClientException;
import io.camunda.management.api.client.invoker.ApiException;
import io.camunda.management.api.client.model.ClusterClient;
import io.camunda.management.api.client.model.CreateClusterClientBody;
import io.camunda.management.api.client.model.CreatedClusterClient;
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
