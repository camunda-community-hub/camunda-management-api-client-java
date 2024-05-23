package io.camunda.management.api.client;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.camunda.management.api.client.api.DefaultApi;
import io.camunda.management.api.client.auth.JsonClientResponseHandler;
import io.camunda.management.api.client.auth.TokenRequestInterceptor;
import io.camunda.management.api.client.invoker.ApiClient;
import io.camunda.management.api.client.properties.CamundaManagementApiClientProperties;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.HttpRequestInterceptor;

public class DefaultApiFactory {
  private final CamundaManagementApiClientProperties properties;
  private final ObjectMapper objectMapper;
  private DefaultApi api;

  private DefaultApiFactory(
      CamundaManagementApiClientProperties properties, ObjectMapper objectMapper) {
    this.properties = properties;
    this.objectMapper = objectMapper;
  }

  public static DefaultApiFactory getInstance(CamundaManagementApiClientProperties properties) {
    return getInstance(properties, new ObjectMapper());
  }

  public static DefaultApiFactory getInstance(
      CamundaManagementApiClientProperties properties, ObjectMapper objectMapper) {
    return new DefaultApiFactory(properties, objectMapper);
  }

  public DefaultApi get() {
    ensureApiClient();
    return api;
  }

  private void ensureApiClient() {
    if (api == null) {
      HttpRequestInterceptor interceptor =
          new TokenRequestInterceptor(properties, new JsonClientResponseHandler(objectMapper));
      CloseableHttpClient httpClient =
          HttpClients.custom().addRequestInterceptorFirst(interceptor).build();
      ApiClient apiClient = new ApiClient(httpClient);
      apiClient.setBasePath(properties.baseUrl());
      api = new DefaultApi(apiClient);
    }
  }
}
