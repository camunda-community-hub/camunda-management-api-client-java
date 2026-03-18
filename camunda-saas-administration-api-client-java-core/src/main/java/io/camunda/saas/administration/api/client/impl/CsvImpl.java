package io.camunda.saas.administration.api.client.impl;

import io.camunda.saas.administration.api.client.api.CamundaSaasAdministrationApiClient.Csv;
import io.camunda.saas.administration.api.client.exception.CamundaConsoleClientException;
import io.camunda.saas.administration.api.client.gen.invoker.ApiException;

public class CsvImpl extends AbstractCamundaSaasAdministrationApiClient implements Csv {
  public CsvImpl(AbstractCamundaSaasAdministrationApiClient saasAdministrationApiClient) {
    super(saasAdministrationApiClient);
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
