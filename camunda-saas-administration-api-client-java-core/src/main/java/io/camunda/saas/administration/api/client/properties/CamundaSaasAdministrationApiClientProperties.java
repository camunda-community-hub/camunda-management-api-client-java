package io.camunda.saas.administration.api.client.properties;

import static io.camunda.saas.administration.api.client.properties.PropertiesConstants.Default.*;
import static io.camunda.saas.administration.api.client.properties.PropertiesConstants.Environment.*;
import static io.camunda.saas.administration.api.client.properties.PropertiesConstants.Properties.*;

import java.util.Map;
import java.util.Properties;

public record CamundaSaasAdministrationApiClientProperties(
    String baseUrl, String clientId, String clientSecret, String oAuthUrl, String oAuthAudience) {
  public static CamundaSaasAdministrationApiClientProperties fromEnv() {
    return fromEnv(System.getenv());
  }

  public static CamundaSaasAdministrationApiClientProperties fromEnv(
      Map<String, String> environment) {
    return new CamundaSaasAdministrationApiClientProperties(
        environment.getOrDefault(
            ENV_CAMUNDA_SAAS_ADMINISTRATION_API_BASE_URL,
            CAMUNDA_SAAS_ADMINISTRATION_API_SAAS_BASE_URL),
        environment.get(ENV_CAMUNDA_SAAS_ADMINISTRATION_API_CLIENT_ID),
        environment.get(ENV_CAMUNDA_SAAS_ADMINISTRATION_API_CLIENT_SECRET),
        environment.getOrDefault(ENV_CAMUNDA_OAUTH_URL, CAMUNDA_SAAS_OAUTH_URL),
        environment.getOrDefault(
            ENV_CAMUNDA_SAAS_ADMINISTRATION_API_OAUTH_AUDIENCE,
            CAMUNDA_SAAS_ADMINISTRATION_API_SAAS_OAUTH_AUDIENCE));
  }

  public static CamundaSaasAdministrationApiClientProperties fromProperties(Properties properties) {
    return new CamundaSaasAdministrationApiClientProperties(
        properties.getProperty(
            PROP_CAMUNDA_SAAS_ADMINISTRATION_API_BASE_URL,
            CAMUNDA_SAAS_ADMINISTRATION_API_SAAS_BASE_URL),
        properties.getProperty(PROP_CAMUNDA_SAAS_ADMINISTRATION_API_CLIENT_ID),
        properties.getProperty(PROP_CAMUNDA_SAAS_ADMINISTRATION_API_CLIENT_SECRET),
        properties.getProperty(PROP_CAMUNDA_OAUTH_URL, CAMUNDA_SAAS_OAUTH_URL),
        properties.getProperty(
            PROP_CAMUNDA_SAAS_ADMINISTRATION_API_OAUTH_AUDIENCE,
            CAMUNDA_SAAS_ADMINISTRATION_API_SAAS_OAUTH_AUDIENCE));
  }
}
