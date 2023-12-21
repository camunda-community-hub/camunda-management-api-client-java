package io.camunda.console.client.auth;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import io.camunda.console.client.properties.CamundaConsoleClientProperties;
import java.io.IOException;
import java.net.URI;
import java.time.LocalDateTime;
import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.ClassicHttpRequest;
import org.apache.hc.core5.http.ContentType;
import org.apache.hc.core5.http.EntityDetails;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.HttpHeaders;
import org.apache.hc.core5.http.HttpRequest;
import org.apache.hc.core5.http.HttpRequestInterceptor;
import org.apache.hc.core5.http.io.entity.StringEntity;
import org.apache.hc.core5.http.protocol.HttpContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TokenRequestInterceptor implements HttpRequestInterceptor {
  private static final Logger LOG = LoggerFactory.getLogger(TokenRequestInterceptor.class);
  private final CamundaConsoleClientProperties properties;
  private final JsonClientResponseHandler responseHandler;
  private String token;
  private LocalDateTime timeout = LocalDateTime.now();

  public TokenRequestInterceptor(
      CamundaConsoleClientProperties properties, JsonClientResponseHandler responseHandler) {
    this.properties = properties;
    this.responseHandler = responseHandler;
  }

  @Override
  public void process(HttpRequest request, EntityDetails entity, HttpContext context) {
    if (timedOut()) {
      LOG.debug("Token is timed out, fetching new token");
      getNewToken();
      LOG.debug("Got new token, expires at {}", timeout);
    }
    addToken(request);
    LOG.debug("Token added to request");
  }

  private void addToken(HttpRequest request) {
    request.setHeader(HttpHeaders.AUTHORIZATION, "Bearer " + token);
  }

  private void getNewToken() {
    try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
      ClassicHttpRequest request = new HttpPost(URI.create(properties.oAuthUrl()));
      HttpEntity entity = new StringEntity(createRequest(), ContentType.APPLICATION_JSON);
      request.setEntity(entity);
      JsonNode response = httpClient.execute(request, responseHandler);
      token = response.get("access_token").textValue();
      timeout = LocalDateTime.now().plusSeconds(response.get("expires_in").asInt());
    } catch (IOException e) {
      throw new RuntimeException("Error while fetching token", e);
    }
  }

  private String createRequest() {
    ObjectNode node = JsonNodeFactory.instance.objectNode();
    node.put("grant_type", "client_credentials");
    node.put("audience", properties.oAuthAudience());
    node.put("client_id", properties.clientId());
    node.put("client_secret", properties.clientSecret());
    return node.toPrettyString();
  }

  private boolean timedOut() {
    return timeout.minusSeconds(10).isBefore(LocalDateTime.now());
  }
}
