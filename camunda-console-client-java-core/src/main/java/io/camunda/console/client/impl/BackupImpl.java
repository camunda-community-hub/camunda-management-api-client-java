package io.camunda.console.client.impl;

import io.camunda.console.client.api.CamundaConsoleClient.Cluster.Backup;
import io.camunda.console.client.exception.CamundaConsoleClientException;
import io.camunda.console.client.invoker.ApiException;
import io.camunda.console.client.model.BackupDto;

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
