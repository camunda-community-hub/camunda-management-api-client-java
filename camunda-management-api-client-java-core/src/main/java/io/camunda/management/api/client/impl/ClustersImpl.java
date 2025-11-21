package io.camunda.management.api.client.impl;

import io.camunda.management.api.client.api.CamundaManagementApiClient.Clusters;
import io.camunda.management.api.client.exception.CamundaConsoleClientException;
import io.camunda.management.api.client.invoker.ApiException;
import io.camunda.management.api.client.model.CreateCluster200Response;
import io.camunda.management.api.client.model.CreateClusterRequest;
import java.util.List;

public class ClustersImpl extends AbstractCamundaManagementApiClient implements Clusters {
  public ClustersImpl(AbstractCamundaManagementApiClient managementApiClient) {
    super(managementApiClient);
  }

  @Override
  public List<io.camunda.management.api.client.model.Cluster> get() {
    try {
      return getApi().getClusters();
    } catch (ApiException e) {
      throw new CamundaConsoleClientException(e);
    }
  }

  @Override
  public CreateCluster200Response post(CreateClusterRequest request) {
    try {
      return getApi().createCluster(request);
    } catch (ApiException e) {
      throw new CamundaConsoleClientException(e);
    }
  }

  @Override
  public Parameters parameters() {
    return new ParametersImpl(this);
  }
}
