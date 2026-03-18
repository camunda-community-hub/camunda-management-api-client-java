package io.camunda.saas.administration.api.client.impl;

import io.camunda.saas.administration.api.client.api.CamundaSaasAdministrationApiClient.Upgrade;
import io.camunda.saas.administration.api.client.exception.CamundaConsoleClientException;
import io.camunda.saas.administration.api.client.invoker.ApiException;
import io.camunda.saas.administration.api.client.model.GenerationUpgradeForClusterDto;

public class UpgradeImpl extends AbstractCluster implements Upgrade {

  public UpgradeImpl(AbstractCluster cluster) {
    super(cluster);
  }

  @Override
  public GenerationUpgradeForClusterDto put() {
    try {
      return getApi().upgradeCluster(getClusterId());
    } catch (ApiException e) {
      throw new CamundaConsoleClientException(e);
    }
  }
}
