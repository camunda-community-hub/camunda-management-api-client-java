package io.camunda.management.api.client.impl;

import io.camunda.management.api.client.api.CamundaManagementApiClient.Cluster.IpAllowList;
import io.camunda.management.api.client.exception.CamundaConsoleClientException;
import io.camunda.management.api.client.invoker.ApiException;
import io.camunda.management.api.client.model.IpAllowListBody;

public class IpAllowListImpl extends AbstractCluster implements IpAllowList {

  public IpAllowListImpl(AbstractCluster cluster) {
    super(cluster);
  }

  @Override
  public void put(IpAllowListBody request) {
    try {
      getApi().updateIpAllowlist(getClusterId(), request);
    } catch (ApiException e) {
      throw new CamundaConsoleClientException(e);
    }
  }
}
