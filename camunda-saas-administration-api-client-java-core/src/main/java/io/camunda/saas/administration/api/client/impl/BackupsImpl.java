package io.camunda.saas.administration.api.client.impl;

import io.camunda.saas.administration.api.client.api.CamundaSaasAdministrationApiClient.Cluster.Backups;
import io.camunda.saas.administration.api.client.api.model.BackupResponse;
import io.camunda.saas.administration.api.client.exception.CamundaConsoleClientException;
import io.camunda.saas.administration.api.client.gen.invoker.ApiException;
import java.util.List;

public class BackupsImpl extends AbstractCluster implements Backups {

  public BackupsImpl(AbstractCluster cluster) {
    super(cluster);
  }

  @Override
  public List<BackupResponse> get() {
    try {
      return ModelMapper.fromBackupList(getApi().getBackups(getClusterId()));
    } catch (ApiException e) {
      throw new CamundaConsoleClientException(e);
    }
  }

  @Override
  public BackupResponse post() {
    try {
      return ModelMapper.from(getApi().createBackup(getClusterId()));
    } catch (ApiException e) {
      throw new CamundaConsoleClientException(e);
    }
  }
}
