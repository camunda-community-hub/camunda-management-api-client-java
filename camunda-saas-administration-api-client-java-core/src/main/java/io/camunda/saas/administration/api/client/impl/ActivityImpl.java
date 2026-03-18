package io.camunda.saas.administration.api.client.impl;

import io.camunda.saas.administration.api.client.api.CamundaSaasAdministrationApiClient.Activity;
import io.camunda.saas.administration.api.client.api.CamundaSaasAdministrationApiClient.Csv;
import io.camunda.saas.administration.api.client.api.CamundaSaasAdministrationApiClient.Json;

public class ActivityImpl extends AbstractCamundaSaasAdministrationApiClient implements Activity {

  public ActivityImpl(AbstractCamundaSaasAdministrationApiClient saasAdministrationApiClient) {
    super(saasAdministrationApiClient);
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
