package io.camunda.saas.administration.api.client;

import static org.assertj.core.api.Assertions.*;

import io.camunda.saas.administration.api.client.properties.CamundaSaasAdministrationApiClientProperties;
import io.camunda.saas.administration.api.client.properties.PropertiesConstants.Default;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import org.junit.jupiter.api.Test;

public class CamundaSaasAdministrationApiClientPropertiesTest {
  @Test
  void shouldBootstrapFromProperties() throws IOException {
    Properties properties = new Properties();
    try (InputStream in =
        getClass()
            .getClassLoader()
            .getResourceAsStream("camunda-saas-administration-api-client.properties")) {
      properties.load(in);
    }
    CamundaSaasAdministrationApiClientProperties camundaSaasAdministrationApiClientProperties =
        CamundaSaasAdministrationApiClientProperties.fromProperties(properties);
    assertThat(camundaSaasAdministrationApiClientProperties.clientId()).isEqualTo("clientId");
    assertThat(camundaSaasAdministrationApiClientProperties.clientSecret())
        .isEqualTo("clientSecret");
    assertThat(camundaSaasAdministrationApiClientProperties.baseUrl())
        .isEqualTo("https://api.my.camunda.io");
    assertThat(camundaSaasAdministrationApiClientProperties.oAuthUrl())
        .isEqualTo("https://login.my.camunda.io/oauth/token");
    assertThat(camundaSaasAdministrationApiClientProperties.oAuthAudience())
        .isEqualTo("api.my.camunda.io");
  }

  @Test
  void shouldBootstrapFromProperties_applyDefaults() throws IOException {
    Properties properties = new Properties();
    try (InputStream in =
        getClass()
            .getClassLoader()
            .getResourceAsStream(
                "camunda-saas-administration-api-client-omit-defaults.properties")) {
      properties.load(in);
    }
    CamundaSaasAdministrationApiClientProperties camundaSaasAdministrationApiClientProperties =
        CamundaSaasAdministrationApiClientProperties.fromProperties(properties);
    assertThat(camundaSaasAdministrationApiClientProperties.clientId()).isEqualTo("clientId");
    assertThat(camundaSaasAdministrationApiClientProperties.clientSecret())
        .isEqualTo("clientSecret");
    assertThat(camundaSaasAdministrationApiClientProperties.baseUrl())
        .isEqualTo(Default.CAMUNDA_SAAS_ADMINISTRATION_API_SAAS_BASE_URL);
    assertThat(camundaSaasAdministrationApiClientProperties.oAuthUrl())
        .isEqualTo(Default.CAMUNDA_SAAS_OAUTH_URL);
    assertThat(camundaSaasAdministrationApiClientProperties.oAuthAudience())
        .isEqualTo(Default.CAMUNDA_SAAS_ADMINISTRATION_API_SAAS_OAUTH_AUDIENCE);
  }

  @Test
  void shouldBootstrapFromEnv() {
    Map<String, String> environment = new HashMap<>();
    environment.put("CAMUNDA_SAAS_ADMINISTRATION_API_CLIENT_ID", "clientId");
    environment.put("CAMUNDA_SAAS_ADMINISTRATION_API_CLIENT_SECRET", "clientSecret");
    environment.put("CAMUNDA_OAUTH_URL", "https://login.my.camunda.io/oauth/token");
    environment.put("CAMUNDA_SAAS_ADMINISTRATION_API_BASE_URL", "https://api.my.camunda.io");
    environment.put("CAMUNDA_SAAS_ADMINISTRATION_API_OAUTH_AUDIENCE", "api.my.camunda.io");
    CamundaSaasAdministrationApiClientProperties camundaSaasAdministrationApiClientProperties =
        CamundaSaasAdministrationApiClientProperties.fromEnv(environment);
    assertThat(camundaSaasAdministrationApiClientProperties.clientId()).isEqualTo("clientId");
    assertThat(camundaSaasAdministrationApiClientProperties.clientSecret())
        .isEqualTo("clientSecret");
    assertThat(camundaSaasAdministrationApiClientProperties.baseUrl())
        .isEqualTo("https://api.my.camunda.io");
    assertThat(camundaSaasAdministrationApiClientProperties.oAuthUrl())
        .isEqualTo("https://login.my.camunda.io/oauth/token");
    assertThat(camundaSaasAdministrationApiClientProperties.oAuthAudience())
        .isEqualTo("api.my.camunda.io");
  }

  @Test
  void shouldBootstrapFromEnv_applyDefaults() {
    Map<String, String> environment = new HashMap<>();
    environment.put("CAMUNDA_SAAS_ADMINISTRATION_API_CLIENT_ID", "clientId");
    environment.put("CAMUNDA_SAAS_ADMINISTRATION_API_CLIENT_SECRET", "clientSecret");
    CamundaSaasAdministrationApiClientProperties camundaSaasAdministrationApiClientProperties =
        CamundaSaasAdministrationApiClientProperties.fromEnv(environment);
    assertThat(camundaSaasAdministrationApiClientProperties.clientId()).isEqualTo("clientId");
    assertThat(camundaSaasAdministrationApiClientProperties.clientSecret())
        .isEqualTo("clientSecret");
    assertThat(camundaSaasAdministrationApiClientProperties.baseUrl())
        .isEqualTo(Default.CAMUNDA_SAAS_ADMINISTRATION_API_SAAS_BASE_URL);
    assertThat(camundaSaasAdministrationApiClientProperties.oAuthUrl())
        .isEqualTo(Default.CAMUNDA_SAAS_OAUTH_URL);
    assertThat(camundaSaasAdministrationApiClientProperties.oAuthAudience())
        .isEqualTo(Default.CAMUNDA_SAAS_ADMINISTRATION_API_SAAS_OAUTH_AUDIENCE);
  }
}
