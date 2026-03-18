package io.camunda.saas.administration.api.client.impl;

import io.camunda.saas.administration.api.client.api.CamundaSaasAdministrationApiClient.Cluster.Backups;
import io.camunda.saas.administration.api.client.exception.CamundaConsoleClientException;
import io.camunda.saas.administration.api.client.invoker.ApiException;
import io.camunda.saas.administration.api.client.model.BackupDto;
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
