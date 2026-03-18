package io.camunda.saas.administration.api.client.impl;

import io.camunda.saas.administration.api.client.api.CamundaSaasAdministrationApiClient.Cluster.Secrets;
import io.camunda.saas.administration.api.client.api.model.CreateSecretRequest;
import io.camunda.saas.administration.api.client.exception.CamundaConsoleClientException;
import io.camunda.saas.administration.api.client.gen.invoker.ApiException;
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
  public void post(CreateSecretRequest request) {
    try {
      getApi().createSecret(getClusterId(), ModelMapper.from(request));
    } catch (ApiException e) {
      throw new CamundaConsoleClientException(e);
    }
  }
}
