package io.camunda.saas.administration.api.client.impl;

import io.camunda.saas.administration.api.client.api.DefaultApi;

public abstract class AbstractCamundaSaasAdministrationApiClient {
  private final DefaultApi api;

  public AbstractCamundaSaasAdministrationApiClient(DefaultApi api) {
    this.api = api;
  }

  public AbstractCamundaSaasAdministrationApiClient(
      AbstractCamundaSaasAdministrationApiClient saasAdministrationApiClient) {
    this.api = saasAdministrationApiClient.api;
  }

  protected DefaultApi getApi() {
    return api;
  }
}
