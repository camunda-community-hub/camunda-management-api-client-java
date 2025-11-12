package io.camunda.management.api.client.impl;

import io.camunda.management.api.client.api.CamundaManagementApiClient.IpRanges;
import io.camunda.management.api.client.api.CamundaManagementApiClient.Meta;

public class MetaImpl extends AbstractCamundaManagementApiClient implements Meta {
  public MetaImpl(AbstractCamundaManagementApiClient managementApiClient) {
    super(managementApiClient);
  }

  @Override
  public IpRanges ipRanges() {
    return new IpRangesImpl(this);
  }
}
