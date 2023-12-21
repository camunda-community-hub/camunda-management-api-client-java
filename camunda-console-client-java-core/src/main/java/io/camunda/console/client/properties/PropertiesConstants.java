package io.camunda.console.client.properties;

public interface PropertiesConstants {
  interface Environment {
    String ENV_CAMUNDA_CONSOLE_CLIENT_ID = "CAMUNDA_CONSOLE_CLIENT_ID";
    String ENV_CAMUNDA_CONSOLE_CLIENT_SECRET = "CAMUNDA_CONSOLE_CLIENT_SECRET";
    String ENV_CAMUNDA_OAUTH_URL = "CAMUNDA_OAUTH_URL";
    String ENV_CAMUNDA_CONSOLE_BASE_URL = "CAMUNDA_CONSOLE_BASE_URL";
    String ENV_CAMUNDA_CONSOLE_OAUTH_AUDIENCE = "CAMUNDA_CONSOLE_OAUTH_AUDIENCE";
  }

  interface Default {
    String CAMUNDA_CONSOLE_SAAS_BASE_URL = "https://api.cloud.camunda.io";
    String CAMUNDA_SAAS_OAUTH_URL = "https://login.cloud.camunda.io/oauth/token";
    String CAMUNDA_CONSOLE_SAAS_OAUTH_AUDIENCE = "api.cloud.camunda.io";
  }

  interface Properties {
    String PROP_CAMUNDA_CONSOLE_CLIENT_ID = "camunda.console.client-id";
    String PROP_CAMUNDA_CONSOLE_CLIENT_SECRET = "camunda.console.client-secret";
    String PROP_CAMUNDA_OAUTH_URL = "camunda.oauth-url";
    String PROP_CAMUNDA_CONSOLE_BASE_URL = "camunda.console.base-url";
    String PROP_CAMUNDA_CONSOLE_OAUTH_AUDIENCE = "camunda.console.oauth-audience";
  }
}
