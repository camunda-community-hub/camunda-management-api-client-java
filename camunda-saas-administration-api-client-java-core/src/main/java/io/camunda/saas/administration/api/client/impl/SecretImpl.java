package io.camunda.saas.administration.api.client.impl;

import io.camunda.saas.administration.api.client.api.CamundaSaasAdministrationApiClient.Cluster.Secret;
import io.camunda.saas.administration.api.client.exception.CamundaConsoleClientException;
import io.camunda.saas.administration.api.client.invoker.ApiException;

public class SecretImpl extends AbstractCluster implements Secret {
  private final String secretName;

  public SecretImpl(AbstractCluster cluster, String secretName) {
    super(cluster);
    this.secretName = secretName;
  }

  @Override
  public void delete() {
    try {
      getApi().deleteSecret(getClusterId(), secretName);
    } catch (ApiException e) {
      throw new CamundaConsoleClientException(e);
    }
  }
}
