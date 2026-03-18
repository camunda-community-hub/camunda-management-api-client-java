package io.camunda.saas.administration.api.client.impl;

import io.camunda.saas.administration.api.client.api.CamundaSaasAdministrationApiClient.Cluster.IpAllowList;
import io.camunda.saas.administration.api.client.api.model.IpAllowListRequest;
import io.camunda.saas.administration.api.client.exception.CamundaConsoleClientException;
import io.camunda.saas.administration.api.client.gen.invoker.ApiException;

public class IpAllowListImpl extends AbstractCluster implements IpAllowList {

  public IpAllowListImpl(AbstractCluster cluster) {
    super(cluster);
  }

  @Override
  public void put(IpAllowListRequest request) {
    try {
      getApi().updateIpAllowlist(getClusterId(), ModelMapper.from(request));
    } catch (ApiException e) {
      throw new CamundaConsoleClientException(e);
    }
  }
}
