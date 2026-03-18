package io.camunda.saas.administration.api.client.impl;

import io.camunda.saas.administration.api.client.api.CamundaSaasAdministrationApiClient.Cluster;
import io.camunda.saas.administration.api.client.api.CamundaSaasAdministrationApiClient.Upgrade;
import io.camunda.saas.administration.api.client.exception.CamundaConsoleClientException;
import io.camunda.saas.administration.api.client.invoker.ApiException;
import io.camunda.saas.administration.api.client.model.UpdateClusterBody;

public class ClusterImpl extends AbstractCluster implements Cluster {

  public ClusterImpl(
      AbstractCamundaSaasAdministrationApiClient saasAdministrationApiClient, String clusterId) {
    super(saasAdministrationApiClient, clusterId);
  }

  @Override
  public io.camunda.saas.administration.api.client.model.Cluster get() {
    try {
      return getApi().getCluster(getClusterId());
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
  public void patch(UpdateClusterBody request) {
    try {
      getApi().updateCluster(getClusterId(), request);
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
  @Deprecated
  public IpWhiteList ipwhitelist() {
    return new IpWhiteListImpl(this);
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
