package io.camunda.saas.administration.api.client.impl;

import io.camunda.saas.administration.api.client.api.CamundaSaasAdministrationApiClient.Cluster.Backup;
import io.camunda.saas.administration.api.client.api.model.BackupResponse;
import io.camunda.saas.administration.api.client.exception.CamundaConsoleClientException;
import io.camunda.saas.administration.api.client.gen.invoker.ApiException;

public class BackupImpl extends AbstractCluster implements Backup {
  private final String backupId;

  public BackupImpl(AbstractCluster abstractCluster, String backupId) {
    super(abstractCluster);
    this.backupId = backupId;
  }

  @Override
  public BackupResponse delete() {
    try {
      return ModelMapper.from(getApi().deleteBackup(getClusterId(), backupId));
    } catch (ApiException e) {
      throw new CamundaConsoleClientException(e);
    }
  }
}
