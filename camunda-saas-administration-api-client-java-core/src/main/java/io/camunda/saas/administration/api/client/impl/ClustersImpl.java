package io.camunda.saas.administration.api.client.impl;

import io.camunda.saas.administration.api.client.api.CamundaSaasAdministrationApiClient.Clusters;
import io.camunda.saas.administration.api.client.exception.CamundaConsoleClientException;
import io.camunda.saas.administration.api.client.invoker.ApiException;
import io.camunda.saas.administration.api.client.model.CreateCluster200Response;
import io.camunda.saas.administration.api.client.model.CreateClusterRequest;
import java.util.List;

public class ClustersImpl extends AbstractCamundaSaasAdministrationApiClient implements Clusters {
  public ClustersImpl(AbstractCamundaSaasAdministrationApiClient saasAdministrationApiClient) {
    super(saasAdministrationApiClient);
  }

  @Override
  public List<io.camunda.saas.administration.api.client.model.Cluster> get() {
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
