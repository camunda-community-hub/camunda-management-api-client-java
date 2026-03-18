package io.camunda.saas.administration.api.client.impl;

import io.camunda.saas.administration.api.client.api.CamundaSaasAdministrationApiClient.IpRanges;
import io.camunda.saas.administration.api.client.api.CamundaSaasAdministrationApiClient.Meta;

public class MetaImpl extends AbstractCamundaSaasAdministrationApiClient implements Meta {
  public MetaImpl(AbstractCamundaSaasAdministrationApiClient saasAdministrationApiClient) {
    super(saasAdministrationApiClient);
  }

  @Override
  public IpRanges ipRanges() {
    return new IpRangesImpl(this);
  }
}
