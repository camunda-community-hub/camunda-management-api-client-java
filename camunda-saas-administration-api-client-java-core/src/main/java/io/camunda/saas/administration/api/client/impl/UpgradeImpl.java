package io.camunda.saas.administration.api.client.impl;

import io.camunda.saas.administration.api.client.api.CamundaSaasAdministrationApiClient.Upgrade;
import io.camunda.saas.administration.api.client.api.model.ClusterUpgradeResponse;
import io.camunda.saas.administration.api.client.exception.CamundaConsoleClientException;
import io.camunda.saas.administration.api.client.gen.invoker.ApiException;

public class UpgradeImpl extends AbstractCluster implements Upgrade {

  public UpgradeImpl(AbstractCluster cluster) {
    super(cluster);
  }

  @Override
  public ClusterUpgradeResponse put() {
    try {
      return ModelMapper.from(getApi().upgradeCluster(getClusterId()));
    } catch (ApiException e) {
      throw new CamundaConsoleClientException(e);
    }
  }
}
