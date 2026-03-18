package io.camunda.saas.administration.api.client.properties;

public interface PropertiesConstants {
  interface Environment {
    String ENV_CAMUNDA_SAAS_ADMINISTRATION_API_CLIENT_ID =
        "CAMUNDA_SAAS_ADMINISTRATION_API_CLIENT_ID";
    String ENV_CAMUNDA_SAAS_ADMINISTRATION_API_CLIENT_SECRET =
        "CAMUNDA_SAAS_ADMINISTRATION_API_CLIENT_SECRET";
    String ENV_CAMUNDA_OAUTH_URL = "CAMUNDA_OAUTH_URL";
    String ENV_CAMUNDA_SAAS_ADMINISTRATION_API_BASE_URL =
        "CAMUNDA_SAAS_ADMINISTRATION_API_BASE_URL";
    String ENV_CAMUNDA_SAAS_ADMINISTRATION_API_OAUTH_AUDIENCE =
        "CAMUNDA_SAAS_ADMINISTRATION_API_OAUTH_AUDIENCE";
  }

  interface Default {
    String CAMUNDA_SAAS_ADMINISTRATION_API_SAAS_BASE_URL = "https://api.cloud.camunda.io";
    String CAMUNDA_SAAS_OAUTH_URL = "https://login.cloud.camunda.io/oauth/token";
    String CAMUNDA_SAAS_ADMINISTRATION_API_SAAS_OAUTH_AUDIENCE = "api.cloud.camunda.io";
  }

  interface Properties {
    String PROP_CAMUNDA_SAAS_ADMINISTRATION_API_CLIENT_ID =
        "camunda.saas.administration.api.client-id";
    String PROP_CAMUNDA_SAAS_ADMINISTRATION_API_CLIENT_SECRET =
        "camunda.saas.administration.api.client-secret";
    String PROP_CAMUNDA_OAUTH_URL = "camunda.oauth-url";
    String PROP_CAMUNDA_SAAS_ADMINISTRATION_API_BASE_URL =
        "camunda.saas.administration.api.base-url";
    String PROP_CAMUNDA_SAAS_ADMINISTRATION_API_OAUTH_AUDIENCE =
        "camunda.saas.administration.api.oauth-audience";
  }
}
