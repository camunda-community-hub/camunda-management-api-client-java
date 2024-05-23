package io.camunda.management.api.client.impl;

import io.camunda.management.api.client.api.CamundaManagementApiClient.Cluster.Secret;
import io.camunda.management.api.client.exception.CamundaConsoleClientException;
import io.camunda.management.api.client.invoker.ApiException;

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
