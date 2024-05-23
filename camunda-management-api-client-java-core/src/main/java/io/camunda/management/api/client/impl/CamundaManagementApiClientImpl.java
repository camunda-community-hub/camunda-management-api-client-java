package io.camunda.management.api.client.impl;

import io.camunda.management.api.client.api.CamundaManagementApiClient;
import io.camunda.management.api.client.api.DefaultApi;

public class CamundaManagementApiClientImpl extends AbstractCamundaManagementApiClient
    implements CamundaManagementApiClient {

  public CamundaManagementApiClientImpl(DefaultApi api) {
    super(api);
  }

  @Override
  public Clusters clusters() {
    return new ClustersImpl(this);
  }

  @Override
  public Cluster clusters(String id) {
    return new ClusterImpl(this, id);
  }

  @Override
  public Members members() {
    return new MembersImpl(this);
  }

  @Override
  public Member members(String email) {
    return new MemberImpl(this, email);
  }
}
