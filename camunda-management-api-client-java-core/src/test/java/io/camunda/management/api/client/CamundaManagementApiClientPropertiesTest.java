package io.camunda.management.api.client;

import static org.assertj.core.api.Assertions.*;

import io.camunda.management.api.client.properties.CamundaManagementApiClientProperties;
import io.camunda.management.api.client.properties.PropertiesConstants.Default;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import org.junit.jupiter.api.Test;

public class CamundaManagementApiClientPropertiesTest {
  @Test
  void shouldBootstrapFromProperties() throws IOException {
    Properties properties = new Properties();
    try (InputStream in =
        getClass().getClassLoader().getResourceAsStream("camunda-management-api-client.properties")) {
      properties.load(in);
    }
    CamundaManagementApiClientProperties camundaManagementApiClientProperties =
        CamundaManagementApiClientProperties.fromProperties(properties);
    assertThat(camundaManagementApiClientProperties.clientId()).isEqualTo("clientId");
    assertThat(camundaManagementApiClientProperties.clientSecret()).isEqualTo("clientSecret");
    assertThat(camundaManagementApiClientProperties.baseUrl()).isEqualTo("https://api.my.camunda.io");
    assertThat(camundaManagementApiClientProperties.oAuthUrl())
        .isEqualTo("https://login.my.camunda.io/oauth/token");
    assertThat(camundaManagementApiClientProperties.oAuthAudience()).isEqualTo("api.my.camunda.io");
  }

  @Test
  void shouldBootstrapFromProperties_applyDefaults() throws IOException {
    Properties properties = new Properties();
    try (InputStream in =
        getClass()
            .getClassLoader()
            .getResourceAsStream("camunda-management-api-client-omit-defaults.properties")) {
      properties.load(in);
    }
    CamundaManagementApiClientProperties camundaManagementApiClientProperties =
        CamundaManagementApiClientProperties.fromProperties(properties);
    assertThat(camundaManagementApiClientProperties.clientId()).isEqualTo("clientId");
    assertThat(camundaManagementApiClientProperties.clientSecret()).isEqualTo("clientSecret");
    assertThat(camundaManagementApiClientProperties.baseUrl())
        .isEqualTo(Default.CAMUNDA_MANAGEMENT_API_SAAS_BASE_URL);
    assertThat(camundaManagementApiClientProperties.oAuthUrl()).isEqualTo(Default.CAMUNDA_SAAS_OAUTH_URL);
    assertThat(camundaManagementApiClientProperties.oAuthAudience())
        .isEqualTo(Default.CAMUNDA_MANAGEMENT_API_SAAS_OAUTH_AUDIENCE);
  }

  @Test
  void shouldBootstrapFromEnv() {
    Map<String, String> environment = new HashMap<>();
    environment.put("CAMUNDA_MANAGEMENT_API_CLIENT_ID", "clientId");
    environment.put("CAMUNDA_MANAGEMENT_API_CLIENT_SECRET", "clientSecret");
    environment.put("CAMUNDA_OAUTH_URL", "https://login.my.camunda.io/oauth/token");
    environment.put("CAMUNDA_MANAGEMENT_API_BASE_URL", "https://api.my.camunda.io");
    environment.put("CAMUNDA_MANAGEMENT_API_OAUTH_AUDIENCE", "api.my.camunda.io");
    CamundaManagementApiClientProperties camundaManagementApiClientProperties =
        CamundaManagementApiClientProperties.fromEnv(environment);
    assertThat(camundaManagementApiClientProperties.clientId()).isEqualTo("clientId");
    assertThat(camundaManagementApiClientProperties.clientSecret()).isEqualTo("clientSecret");
    assertThat(camundaManagementApiClientProperties.baseUrl()).isEqualTo("https://api.my.camunda.io");
    assertThat(camundaManagementApiClientProperties.oAuthUrl())
        .isEqualTo("https://login.my.camunda.io/oauth/token");
    assertThat(camundaManagementApiClientProperties.oAuthAudience()).isEqualTo("api.my.camunda.io");
  }

  @Test
  void shouldBootstrapFromEnv_applyDefaults() {
    Map<String, String> environment = new HashMap<>();
    environment.put("CAMUNDA_MANAGEMENT_API_CLIENT_ID", "clientId");
    environment.put("CAMUNDA_MANAGEMENT_API_CLIENT_SECRET", "clientSecret");
    CamundaManagementApiClientProperties camundaManagementApiClientProperties =
        CamundaManagementApiClientProperties.fromEnv(environment);
    assertThat(camundaManagementApiClientProperties.clientId()).isEqualTo("clientId");
    assertThat(camundaManagementApiClientProperties.clientSecret()).isEqualTo("clientSecret");
    assertThat(camundaManagementApiClientProperties.baseUrl())
        .isEqualTo(Default.CAMUNDA_MANAGEMENT_API_SAAS_BASE_URL);
    assertThat(camundaManagementApiClientProperties.oAuthUrl()).isEqualTo(Default.CAMUNDA_SAAS_OAUTH_URL);
    assertThat(camundaManagementApiClientProperties.oAuthAudience())
        .isEqualTo(Default.CAMUNDA_MANAGEMENT_API_SAAS_OAUTH_AUDIENCE);
  }
}
