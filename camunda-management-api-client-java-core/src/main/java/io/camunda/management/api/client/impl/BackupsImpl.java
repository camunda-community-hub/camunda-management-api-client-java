package io.camunda.management.api.client.impl;

import io.camunda.management.api.client.api.CamundaManagementApiClient.Cluster.Backups;
import io.camunda.management.api.client.exception.CamundaConsoleClientException;
import io.camunda.management.api.client.invoker.ApiException;
import io.camunda.management.api.client.model.BackupDto;
import java.util.List;

public class BackupsImpl extends AbstractCluster implements Backups {

  public BackupsImpl(AbstractCluster cluster) {
    super(cluster);
  }

  @Override
  public List<BackupDto> get() {
    try {
      return getApi().getBackups(getClusterId());
    } catch (ApiException e) {
      throw new CamundaConsoleClientException(e);
    }
  }

  @Override
  public BackupDto post() {
    try {
      return getApi().createBackup(getClusterId());
    } catch (ApiException e) {
      throw new CamundaConsoleClientException(e);
    }
  }
}
