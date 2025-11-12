package io.camunda.management.api.client.impl;

import io.camunda.management.api.client.api.CamundaManagementApiClient.Upgrade;
import io.camunda.management.api.client.exception.CamundaConsoleClientException;
import io.camunda.management.api.client.invoker.ApiException;
import io.camunda.management.api.client.model.GenerationUpgradeForClusterDto;

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
