package io.camunda.saas.administration.api.client.impl;

import io.camunda.saas.administration.api.client.api.CamundaSaasAdministrationApiClient.Cluster;
import io.camunda.saas.administration.api.client.api.CamundaSaasAdministrationApiClient.Upgrade;
import io.camunda.saas.administration.api.client.api.model.ClusterResponse;
import io.camunda.saas.administration.api.client.api.model.UpdateClusterRequest;
import io.camunda.saas.administration.api.client.exception.CamundaConsoleClientException;
import io.camunda.saas.administration.api.client.gen.invoker.ApiException;

public class ClusterImpl extends AbstractCluster implements Cluster {

  public ClusterImpl(
      AbstractCamundaSaasAdministrationApiClient saasAdministrationApiClient, String clusterId) {
    super(saasAdministrationApiClient, clusterId);
  }

  @Override
  public ClusterResponse get() {
    try {
      return ModelMapper.from(getApi().getCluster(getClusterId()));
    } catch (ApiException e) {
      throw new CamundaConsoleClientException(e);
    }
  }

  @Override
  public void delete() {
    try {
      getApi().deleteCluster(getClusterId());
    } catch (ApiException e) {
      throw new CamundaConsoleClientException(e);
    }
  }

  @Override
  public void patch(UpdateClusterRequest request) {
    try {
      getApi().updateCluster(getClusterId(), ModelMapper.from(request));
    } catch (ApiException e) {
      throw new CamundaConsoleClientException(e);
    }
  }

  @Override
  public Upgrade upgrade() {
    return new UpgradeImpl(this);
  }

  @Override
  public Backups backups() {
    return new BackupsImpl(this);
  }

  @Override
  public Backup backups(String backupId) {
    return new BackupImpl(this, backupId);
  }

  @Override
  public IpAllowList ipallowlist() {
    return new IpAllowListImpl(this);
  }

  @Override
  public Wake wake() {
    return new WakeImpl(this);
  }

  @Override
  public Clients clients() {
    return new ClientsImpl(this);
  }

  @Override
  public Client clients(String clientId) {
    return new ClientImpl(this, clientId);
  }

  @Override
  public Secrets secrets() {
    return new SecretsImpl(this);
  }

  @Override
  public Secret secrets(String secretName) {
    return new SecretImpl(this, secretName);
  }
}
