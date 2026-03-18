package io.camunda.saas.administration.api.client.impl;

import io.camunda.saas.administration.api.client.api.CamundaSaasAdministrationApiClient;
import io.camunda.saas.administration.api.client.api.DefaultApi;

public class CamundaSaasAdministrationApiClientImpl
    extends AbstractCamundaSaasAdministrationApiClient
    implements CamundaSaasAdministrationApiClient {

  public CamundaSaasAdministrationApiClientImpl(DefaultApi api) {
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

  @Override
  public Meta meta() {
    return new MetaImpl(this);
  }

  @Override
  public Activity activity() {
    return new ActivityImpl(this);
  }
}
