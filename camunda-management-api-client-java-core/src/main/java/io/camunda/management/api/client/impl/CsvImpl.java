package io.camunda.management.api.client.impl;

import io.camunda.management.api.client.api.CamundaManagementApiClient.Csv;
import io.camunda.management.api.client.exception.CamundaConsoleClientException;
import io.camunda.management.api.client.invoker.ApiException;

public class CsvImpl extends AbstractCamundaManagementApiClient implements Csv {
  public CsvImpl(AbstractCamundaManagementApiClient managementApiClient) {
    super(managementApiClient);
  }

  @Override
  public String get() {
    try {
      return getApi().getCsv();
    } catch (ApiException e) {
      throw new CamundaConsoleClientException(e);
    }
  }
}
