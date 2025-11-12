package io.camunda.management.api.client.impl;

import io.camunda.management.api.client.api.CamundaManagementApiClient.Activity;
import io.camunda.management.api.client.api.CamundaManagementApiClient.Csv;
import io.camunda.management.api.client.api.CamundaManagementApiClient.Json;

public class ActivityImpl extends AbstractCamundaManagementApiClient implements Activity {

  public ActivityImpl(AbstractCamundaManagementApiClient managementApiClient) {
    super(managementApiClient);
  }

  @Override
  public Json json() {
    return new JsonImpl(this);
  }

  @Override
  public Csv csv() {
    return new CsvImpl(this);
  }
}
