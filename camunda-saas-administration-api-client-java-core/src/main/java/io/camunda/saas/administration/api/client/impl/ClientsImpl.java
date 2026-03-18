package io.camunda.saas.administration.api.client.impl;

import io.camunda.saas.administration.api.client.api.CamundaSaasAdministrationApiClient.Cluster.Clients;
import io.camunda.saas.administration.api.client.api.model.ClusterClientResponse;
import io.camunda.saas.administration.api.client.api.model.CreateClusterClientRequest;
import io.camunda.saas.administration.api.client.api.model.CreateClusterClientResponse;
import io.camunda.saas.administration.api.client.exception.CamundaConsoleClientException;
import io.camunda.saas.administration.api.client.gen.invoker.ApiException;
import java.util.List;

public class ClientsImpl extends AbstractCluster implements Clients {

  public ClientsImpl(AbstractCluster cluster) {
    super(cluster);
  }

  @Override
  public List<ClusterClientResponse> get() {
    try {
      return ModelMapper.fromClientList(getApi().getClients(getClusterId()));
    } catch (ApiException e) {
      throw new CamundaConsoleClientException(e);
    }
  }

  @Override
  public CreateClusterClientResponse post(CreateClusterClientRequest request) {
    try {
      return ModelMapper.from(getApi().createClient(getClusterId(), ModelMapper.from(request)));
    } catch (ApiException e) {
      throw new CamundaConsoleClientException(e);
    }
  }
}
