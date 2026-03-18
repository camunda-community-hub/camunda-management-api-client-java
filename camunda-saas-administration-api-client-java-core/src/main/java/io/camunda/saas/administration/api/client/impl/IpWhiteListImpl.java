package io.camunda.saas.administration.api.client.impl;

import io.camunda.saas.administration.api.client.api.CamundaSaasAdministrationApiClient.Cluster.IpWhiteList;
import io.camunda.saas.administration.api.client.exception.CamundaConsoleClientException;
import io.camunda.saas.administration.api.client.invoker.ApiException;
import io.camunda.saas.administration.api.client.model.IpWhiteListBody;

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
