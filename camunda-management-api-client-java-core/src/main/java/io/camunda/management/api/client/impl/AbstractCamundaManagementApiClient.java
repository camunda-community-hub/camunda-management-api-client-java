package io.camunda.management.api.client.impl;

import io.camunda.management.api.client.api.DefaultApi;

public abstract class AbstractCamundaManagementApiClient {
  private final DefaultApi api;

  public AbstractCamundaManagementApiClient(DefaultApi api) {
    this.api = api;
  }

  public AbstractCamundaManagementApiClient(
      AbstractCamundaManagementApiClient managementApiClient) {
    this.api = managementApiClient.api;
  }

  protected DefaultApi getApi() {
    return api;
  }
}
