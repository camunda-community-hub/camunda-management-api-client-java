package io.camunda.saas.administration.api.client.impl;

import io.camunda.saas.administration.api.client.api.CamundaSaasAdministrationApiClient.Clusters;
import io.camunda.saas.administration.api.client.api.model.ClusterResponse;
import io.camunda.saas.administration.api.client.api.model.CreateClusterRequest;
import io.camunda.saas.administration.api.client.api.model.CreateClusterResponse;
import io.camunda.saas.administration.api.client.exception.CamundaConsoleClientException;
import io.camunda.saas.administration.api.client.gen.invoker.ApiException;
import java.util.List;

public class ClustersImpl extends AbstractCamundaSaasAdministrationApiClient implements Clusters {
  public ClustersImpl(AbstractCamundaSaasAdministrationApiClient saasAdministrationApiClient) {
    super(saasAdministrationApiClient);
  }

  @Override
  public List<ClusterResponse> get() {
    try {
      return ModelMapper.fromClusterList(getApi().getClusters());
    } catch (ApiException e) {
      throw new CamundaConsoleClientException(e);
    }
  }

  @Override
  public CreateClusterResponse post(CreateClusterRequest request) {
    try {
      return ModelMapper.from(getApi().createCluster(ModelMapper.from(request)));
    } catch (ApiException e) {
      throw new CamundaConsoleClientException(e);
    }
  }

  @Override
  public Parameters parameters() {
    return new ParametersImpl(this);
  }
}
