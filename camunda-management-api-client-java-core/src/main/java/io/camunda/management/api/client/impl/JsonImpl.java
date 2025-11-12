package io.camunda.management.api.client.impl;

import io.camunda.management.api.client.api.CamundaManagementApiClient.Json;
import io.camunda.management.api.client.exception.CamundaConsoleClientException;
import io.camunda.management.api.client.invoker.ApiException;
import io.camunda.management.api.client.model.AuditDto;
import java.util.List;

public class JsonImpl extends AbstractCamundaManagementApiClient implements Json {
  public JsonImpl(AbstractCamundaManagementApiClient managementApiClient) {
    super(managementApiClient);
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
