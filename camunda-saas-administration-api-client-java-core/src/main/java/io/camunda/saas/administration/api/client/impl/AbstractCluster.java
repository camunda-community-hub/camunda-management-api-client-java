package io.camunda.saas.administration.api.client.impl;

public abstract class AbstractCluster extends AbstractCamundaSaasAdministrationApiClient {
  private final String clusterId;

  public AbstractCluster(
      AbstractCamundaSaasAdministrationApiClient saasAdministrationApiClient, String clusterId) {
    super(saasAdministrationApiClient);
    this.clusterId = clusterId;
  }

  public AbstractCluster(AbstractCluster cluster) {
    super(cluster);
    this.clusterId = cluster.clusterId;
  }

  protected String getClusterId() {
    return clusterId;
  }
}
