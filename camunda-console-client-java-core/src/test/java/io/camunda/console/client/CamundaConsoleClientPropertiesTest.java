package io.camunda.console.client;

import static io.camunda.console.client.properties.PropertiesConstants.Default.*;
import static org.assertj.core.api.Assertions.*;

import io.camunda.console.client.properties.CamundaConsoleClientProperties;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import org.junit.jupiter.api.Test;

public class CamundaConsoleClientPropertiesTest {
  @Test
  void shouldBootstrapFromProperties() throws IOException {
    Properties properties = new Properties();
    try (InputStream in =
        getClass().getClassLoader().getResourceAsStream("camunda-console-client.properties")) {
      properties.load(in);
    }
    CamundaConsoleClientProperties camundaConsoleClientProperties =
        CamundaConsoleClientProperties.fromProperties(properties);
    assertThat(camundaConsoleClientProperties.clientId()).isEqualTo("clientId");
    assertThat(camundaConsoleClientProperties.clientSecret()).isEqualTo("clientSecret");
    assertThat(camundaConsoleClientProperties.baseUrl()).isEqualTo("https://api.my.camunda.io");
    assertThat(camundaConsoleClientProperties.oAuthUrl())
        .isEqualTo("https://login.my.camunda.io/oauth/token");
    assertThat(camundaConsoleClientProperties.oAuthAudience()).isEqualTo("api.my.camunda.io");
  }

  @Test
  void shouldBootstrapFromProperties_applyDefaults() throws IOException {
    Properties properties = new Properties();
    try (InputStream in =
        getClass()
            .getClassLoader()
            .getResourceAsStream("camunda-console-client-omit-defaults.properties")) {
      properties.load(in);
    }
    CamundaConsoleClientProperties camundaConsoleClientProperties =
        CamundaConsoleClientProperties.fromProperties(properties);
    assertThat(camundaConsoleClientProperties.clientId()).isEqualTo("clientId");
    assertThat(camundaConsoleClientProperties.clientSecret()).isEqualTo("clientSecret");
    assertThat(camundaConsoleClientProperties.baseUrl()).isEqualTo(CAMUNDA_CONSOLE_SAAS_BASE_URL);
    assertThat(camundaConsoleClientProperties.oAuthUrl()).isEqualTo(CAMUNDA_SAAS_OAUTH_URL);
    assertThat(camundaConsoleClientProperties.oAuthAudience())
        .isEqualTo(CAMUNDA_CONSOLE_SAAS_OAUTH_AUDIENCE);
  }

  @Test
  void shouldBootstrapFromEnv() {
    Map<String, String> environment = new HashMap<>();
    environment.put("CAMUNDA_CONSOLE_CLIENT_ID", "clientId");
    environment.put("CAMUNDA_CONSOLE_CLIENT_SECRET", "clientSecret");
    environment.put("CAMUNDA_OAUTH_URL", "https://login.my.camunda.io/oauth/token");
    environment.put("CAMUNDA_CONSOLE_BASE_URL", "https://api.my.camunda.io");
    environment.put("CAMUNDA_CONSOLE_OAUTH_AUDIENCE", "api.my.camunda.io");
    CamundaConsoleClientProperties camundaConsoleClientProperties =
        CamundaConsoleClientProperties.fromEnv(environment);
    assertThat(camundaConsoleClientProperties.clientId()).isEqualTo("clientId");
    assertThat(camundaConsoleClientProperties.clientSecret()).isEqualTo("clientSecret");
    assertThat(camundaConsoleClientProperties.baseUrl()).isEqualTo("https://api.my.camunda.io");
    assertThat(camundaConsoleClientProperties.oAuthUrl())
        .isEqualTo("https://login.my.camunda.io/oauth/token");
    assertThat(camundaConsoleClientProperties.oAuthAudience()).isEqualTo("api.my.camunda.io");
  }

  @Test
  void shouldBootstrapFromEnv_applyDefaults() {
    Map<String, String> environment = new HashMap<>();
    environment.put("CAMUNDA_CONSOLE_CLIENT_ID", "clientId");
    environment.put("CAMUNDA_CONSOLE_CLIENT_SECRET", "clientSecret");
    CamundaConsoleClientProperties camundaConsoleClientProperties =
        CamundaConsoleClientProperties.fromEnv(environment);
    assertThat(camundaConsoleClientProperties.clientId()).isEqualTo("clientId");
    assertThat(camundaConsoleClientProperties.clientSecret()).isEqualTo("clientSecret");
    assertThat(camundaConsoleClientProperties.baseUrl()).isEqualTo(CAMUNDA_CONSOLE_SAAS_BASE_URL);
    assertThat(camundaConsoleClientProperties.oAuthUrl()).isEqualTo(CAMUNDA_SAAS_OAUTH_URL);
    assertThat(camundaConsoleClientProperties.oAuthAudience())
        .isEqualTo(CAMUNDA_CONSOLE_SAAS_OAUTH_AUDIENCE);
  }
}
