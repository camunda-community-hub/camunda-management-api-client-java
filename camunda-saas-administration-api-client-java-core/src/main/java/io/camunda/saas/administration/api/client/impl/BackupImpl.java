package io.camunda.saas.administration.api.client.impl;

import io.camunda.saas.administration.api.client.api.CamundaSaasAdministrationApiClient.Cluster.Backup;
import io.camunda.saas.administration.api.client.exception.CamundaConsoleClientException;
import io.camunda.saas.administration.api.client.invoker.ApiException;
import io.camunda.saas.administration.api.client.model.BackupDto;

public class BackupImpl extends AbstractCluster implements Backup {
  private final String backupId;

  public BackupImpl(AbstractCluster abstractCluster, String backupId) {
    super(abstractCluster);
    this.backupId = backupId;
  }

  @Override
  public BackupDto delete() {
    try {
      return getApi().deleteBackup(getClusterId(), backupId);
    } catch (ApiException e) {
      throw new CamundaConsoleClientException(e);
    }
  }
}
