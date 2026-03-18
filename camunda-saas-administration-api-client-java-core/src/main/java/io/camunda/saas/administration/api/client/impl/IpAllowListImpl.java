package io.camunda.saas.administration.api.client.impl;

import io.camunda.saas.administration.api.client.api.CamundaSaasAdministrationApiClient.Cluster.IpAllowList;
import io.camunda.saas.administration.api.client.exception.CamundaConsoleClientException;
import io.camunda.saas.administration.api.client.invoker.ApiException;
import io.camunda.saas.administration.api.client.model.IpAllowListBody;

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
