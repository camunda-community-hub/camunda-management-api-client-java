package io.camunda.console.client.impl;

import io.camunda.console.client.api.CamundaConsoleClient.Cluster.Secrets;
import io.camunda.console.client.exception.CamundaConsoleClientException;
import io.camunda.console.client.invoker.ApiException;
import io.camunda.console.client.model.CreateSecretBody;
import java.util.Map;

public class SecretsImpl extends AbstractCluster implements Secrets {
  public SecretsImpl(AbstractCluster cluster) {
    super(cluster);
  }

  @Override
  public Map<String, String> get() {
    try {
      return getApi().getSecrets(getClusterId());
    } catch (ApiException e) {
      throw new CamundaConsoleClientException(e);
    }
  }

  @Override
  public void post(CreateSecretBody request) {
    try {
      getApi().createSecret(getClusterId(), request);
    } catch (ApiException e) {
      throw new CamundaConsoleClientException(e);
    }
  }
}
