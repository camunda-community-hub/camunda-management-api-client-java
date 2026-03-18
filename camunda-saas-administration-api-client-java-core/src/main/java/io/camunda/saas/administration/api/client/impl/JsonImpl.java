package io.camunda.saas.administration.api.client.impl;

import io.camunda.saas.administration.api.client.api.CamundaSaasAdministrationApiClient.Json;
import io.camunda.saas.administration.api.client.exception.CamundaConsoleClientException;
import io.camunda.saas.administration.api.client.invoker.ApiException;
import io.camunda.saas.administration.api.client.model.AuditDto;
import java.util.List;

public class JsonImpl extends AbstractCamundaSaasAdministrationApiClient implements Json {
  public JsonImpl(AbstractCamundaSaasAdministrationApiClient saasAdministrationApiClient) {
    super(saasAdministrationApiClient);
  }

  @Override
  public List<AuditDto> get() {
    try {
      return getApi().getJson();
    } catch (ApiException e) {
      throw new CamundaConsoleClientException(e);
    }
  }
}
