package io.camunda.management.api.client.impl;

import io.camunda.management.api.client.api.CamundaManagementApiClient.Cluster.IpWhiteList;
import io.camunda.management.api.client.exception.CamundaConsoleClientException;
import io.camunda.management.api.client.invoker.ApiException;
import io.camunda.management.api.client.model.IpWhiteListBody;

public class IpWhiteListImpl extends AbstractCluster implements IpWhiteList {

  public IpWhiteListImpl(AbstractCluster cluster) {
    super(cluster);
  }

  @Override
  public void put(IpWhiteListBody request) {
    try {
      getApi().updateIpWhitelist(getClusterId(), request);
    } catch (ApiException e) {
      throw new CamundaConsoleClientException(e);
    }
  }
}
