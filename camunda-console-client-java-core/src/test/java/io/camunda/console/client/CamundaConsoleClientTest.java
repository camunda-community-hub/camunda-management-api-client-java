package io.camunda.console.client;

import io.camunda.console.client.api.CamundaConsoleClient;
import io.camunda.console.client.model.Cluster;
import io.camunda.console.client.properties.CamundaConsoleClientProperties;
import java.util.List;
import org.junit.jupiter.api.Test;

public class CamundaConsoleClientTest {
  @Test
  void shouldWork() {
    CamundaConsoleClient client =
        CamundaConsoleClient.create(
            new CamundaConsoleClientProperties(
                "https://api.cloud.camunda.io",
                "GOvWi1GG21tiKFF1",
                "aRKx4266p~AeemKZQ_DdBoD7J8Dbpl72",
                "https://login.cloud.camunda.io/oauth/token",
                "api.cloud.camunda.io"));
    List<Cluster> clusters = client.clusters().get();
  }
}
