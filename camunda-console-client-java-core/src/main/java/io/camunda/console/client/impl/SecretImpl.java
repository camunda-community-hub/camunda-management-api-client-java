package io.camunda.console.client.impl;

import io.camunda.console.client.api.CamundaConsoleClient.Cluster.Secret;
import io.camunda.console.client.exception.CamundaConsoleClientException;
import io.camunda.console.client.invoker.ApiException;

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
