package io.camunda.management.api.client.impl;

import io.camunda.management.api.client.api.CamundaManagementApiClient.Cluster.Backup;
import io.camunda.management.api.client.exception.CamundaConsoleClientException;
import io.camunda.management.api.client.invoker.ApiException;
import io.camunda.management.api.client.model.BackupDto;

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
