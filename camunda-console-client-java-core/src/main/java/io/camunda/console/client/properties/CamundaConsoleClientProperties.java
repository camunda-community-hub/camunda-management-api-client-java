package io.camunda.console.client.properties;

import static io.camunda.console.client.properties.PropertiesConstants.Default.*;
import static io.camunda.console.client.properties.PropertiesConstants.Environment.*;
import static io.camunda.console.client.properties.PropertiesConstants.Properties.*;
import static io.camunda.console.client.properties.Util.*;

import java.util.Properties;

public record CamundaConsoleClientProperties(
    String baseUrl, String clientId, String clientSecret, String oAuthUrl, String oAuthAudience) {
  public static CamundaConsoleClientProperties fromEnv() {
    return new CamundaConsoleClientProperties(
        getEnv(ENV_CAMUNDA_CONSOLE_BASE_URL, CAMUNDA_CONSOLE_SAAS_BASE_URL),
        getEnv(ENV_CAMUNDA_CONSOLE_CLIENT_ID),
        getEnv(ENV_CAMUNDA_CONSOLE_CLIENT_SECRET),
        getEnv(ENV_CAMUNDA_OAUTH_URL, CAMUNDA_SAAS_OAUTH_URL),
        getEnv(ENV_CAMUNDA_CONSOLE_OAUTH_AUDIENCE, CAMUNDA_CONSOLE_SAAS_OAUTH_AUDIENCE));
  }

  public static CamundaConsoleClientProperties fromProperties(Properties properties) {
    return new CamundaConsoleClientProperties(
        properties.getProperty(PROP_CAMUNDA_CONSOLE_BASE_URL, CAMUNDA_CONSOLE_SAAS_BASE_URL),
        properties.getProperty(PROP_CAMUNDA_CONSOLE_CLIENT_ID),
        properties.getProperty(PROP_CAMUNDA_CONSOLE_CLIENT_SECRET),
        properties.getProperty(PROP_CAMUNDA_OAUTH_URL, CAMUNDA_SAAS_OAUTH_URL),
        properties.getProperty(
            PROP_CAMUNDA_CONSOLE_OAUTH_AUDIENCE, CAMUNDA_CONSOLE_SAAS_OAUTH_AUDIENCE));
  }
}
