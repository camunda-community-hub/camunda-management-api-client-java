package io.camunda.console.client;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.assertj.core.api.Assertions.*;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.github.tomakehurst.wiremock.junit5.WireMockRuntimeInfo;
import com.github.tomakehurst.wiremock.junit5.WireMockTest;
import io.camunda.console.client.api.CamundaConsoleClient;
import io.camunda.console.client.model.Cluster;
import io.camunda.console.client.properties.CamundaConsoleClientProperties;
import java.util.List;
import java.util.UUID;
import org.junit.jupiter.api.Test;

@WireMockTest
public class CamundaConsoleClientTest {
  private static CamundaConsoleClientProperties mockProperties(WireMockRuntimeInfo runtimeInfo) {
    return new CamundaConsoleClientProperties(
        runtimeInfo.getHttpBaseUrl() + "/api",
        "id",
        "secret",
        runtimeInfo.getHttpBaseUrl() + "/token",
        "console");
  }

  @Test
  void shouldExecuteRequest(WireMockRuntimeInfo runtimeInfo) {
    stubFor(post("/token").willReturn(ok().withJsonBody(tokenBody())));
    stubFor(get("/api/clusters").willReturn(ok().withJsonBody(clusters())));
    CamundaConsoleClient client = CamundaConsoleClient.create(mockProperties(runtimeInfo));
    List<Cluster> clusters = client.clusters().get();
    assertThat(clusters).hasSize(1);
    assertThat(clusters.get(0)).matches(c -> c.getName().equals("Test cluster"));
  }

  private JsonNode clusters() {
    Cluster cluster = new Cluster().uuid(UUID.randomUUID().toString()).name("Test cluster");
    return new ObjectMapper().valueToTree(List.of(cluster));
  }

  private JsonNode tokenBody() {
    ObjectNode token = JsonNodeFactory.instance.objectNode();
    token.put("access_token", "abc");
    token.put("expires_in", 60000);
    return token;
  }
}
