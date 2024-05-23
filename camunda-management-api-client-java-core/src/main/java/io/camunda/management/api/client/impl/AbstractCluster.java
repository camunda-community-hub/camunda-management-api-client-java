package io.camunda.management.api.client.impl;

public abstract class AbstractCluster extends AbstractCamundaManagementApiClient {
  private final String clusterId;

  public AbstractCluster(AbstractCamundaManagementApiClient managementApiClient, String clusterId) {
    super(managementApiClient);
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
