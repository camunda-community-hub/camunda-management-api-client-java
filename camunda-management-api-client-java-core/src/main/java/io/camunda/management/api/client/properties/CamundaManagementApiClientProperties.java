package io.camunda.management.api.client.properties;

import static io.camunda.management.api.client.properties.PropertiesConstants.Default.*;
import static io.camunda.management.api.client.properties.PropertiesConstants.Environment.*;
import static io.camunda.management.api.client.properties.PropertiesConstants.Properties.*;

import java.util.Map;
import java.util.Properties;

public record CamundaManagementApiClientProperties(
    String baseUrl, String clientId, String clientSecret, String oAuthUrl, String oAuthAudience) {
  public static CamundaManagementApiClientProperties fromEnv() {
    return fromEnv(System.getenv());
  }

  public static CamundaManagementApiClientProperties fromEnv(Map<String, String> environment) {
    return new CamundaManagementApiClientProperties(
        environment.getOrDefault(
            ENV_CAMUNDA_MANAGEMENT_API_BASE_URL, CAMUNDA_MANAGEMENT_API_SAAS_BASE_URL),
        environment.get(ENV_CAMUNDA_MANAGEMENT_API_CLIENT_ID),
        environment.get(ENV_CAMUNDA_MANAGEMENT_API_CLIENT_SECRET),
        environment.getOrDefault(ENV_CAMUNDA_OAUTH_URL, CAMUNDA_SAAS_OAUTH_URL),
        environment.getOrDefault(
            ENV_CAMUNDA_MANAGEMENT_API_OAUTH_AUDIENCE, CAMUNDA_MANAGEMENT_API_SAAS_OAUTH_AUDIENCE));
  }

  public static CamundaManagementApiClientProperties fromProperties(Properties properties) {
    return new CamundaManagementApiClientProperties(
        properties.getProperty(
            PROP_CAMUNDA_MANAGEMENT_API_BASE_URL, CAMUNDA_MANAGEMENT_API_SAAS_BASE_URL),
        properties.getProperty(PROP_CAMUNDA_MANAGEMENT_API_CLIENT_ID),
        properties.getProperty(PROP_CAMUNDA_MANAGEMENT_API_CLIENT_SECRET),
        properties.getProperty(PROP_CAMUNDA_OAUTH_URL, CAMUNDA_SAAS_OAUTH_URL),
        properties.getProperty(
            PROP_CAMUNDA_MANAGEMENT_API_OAUTH_AUDIENCE,
            CAMUNDA_MANAGEMENT_API_SAAS_OAUTH_AUDIENCE));
  }
}
