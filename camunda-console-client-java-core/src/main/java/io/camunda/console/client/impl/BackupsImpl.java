package io.camunda.console.client.impl;

import io.camunda.console.client.api.CamundaConsoleClient.Cluster.Backups;
import io.camunda.console.client.exception.CamundaConsoleClientException;
import io.camunda.console.client.invoker.ApiException;
import io.camunda.console.client.model.BackupDto;
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
