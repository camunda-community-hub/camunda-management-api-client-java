package io.camunda.console.client.impl;

import io.camunda.console.client.api.CamundaConsoleClient.Cluster.IpWhiteList;
import io.camunda.console.client.exception.CamundaConsoleClientException;
import io.camunda.console.client.invoker.ApiException;
import io.camunda.console.client.model.IpWhiteListBody;

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
