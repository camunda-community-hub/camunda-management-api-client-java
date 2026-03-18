package io.camunda.saas.administration.api.client.impl;

import io.camunda.saas.administration.api.client.api.CamundaSaasAdministrationApiClient.Cluster.Client;
import io.camunda.saas.administration.api.client.api.model.ClusterClientDetailsResponse;
import io.camunda.saas.administration.api.client.exception.CamundaConsoleClientException;
import io.camunda.saas.administration.api.client.gen.invoker.ApiException;

public class ClientImpl extends AbstractCluster implements Client {
  private final String clientId;

  public ClientImpl(AbstractCluster cluster, String clientId) {
    super(cluster);
    this.clientId = clientId;
  }

  @Override
  public ClusterClientDetailsResponse get() {
    try {
      return ModelMapper.from(getApi().getClient(getClusterId(), clientId));
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
