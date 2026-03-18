package io.camunda.saas.administration.api.client.impl;

import io.camunda.saas.administration.api.client.api.CamundaSaasAdministrationApiClient.Json;
import io.camunda.saas.administration.api.client.api.model.ActivityResponse;
import io.camunda.saas.administration.api.client.exception.CamundaConsoleClientException;
import io.camunda.saas.administration.api.client.gen.invoker.ApiException;
import java.util.List;

public class JsonImpl extends AbstractCamundaSaasAdministrationApiClient implements Json {
  public JsonImpl(AbstractCamundaSaasAdministrationApiClient saasAdministrationApiClient) {
    super(saasAdministrationApiClient);
  }

  @Override
  public List<ActivityResponse> get() {
    try {
      return ModelMapper.fromAuditDtoList(getApi().getJson());
    } catch (ApiException e) {
      throw new CamundaConsoleClientException(e);
    }
  }
}
