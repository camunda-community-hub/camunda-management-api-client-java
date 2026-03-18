package io.camunda.saas.administration.api.client.impl;

import io.camunda.saas.administration.api.client.api.CamundaSaasAdministrationApiClient.Cluster.Clients;
import io.camunda.saas.administration.api.client.exception.CamundaConsoleClientException;
import io.camunda.saas.administration.api.client.invoker.ApiException;
import io.camunda.saas.administration.api.client.model.ClusterClient;
import io.camunda.saas.administration.api.client.model.CreateClusterClientBody;
import io.camunda.saas.administration.api.client.model.CreatedClusterClient;
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
