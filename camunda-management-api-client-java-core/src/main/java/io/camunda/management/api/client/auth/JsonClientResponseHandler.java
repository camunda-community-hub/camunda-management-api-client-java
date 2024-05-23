package io.camunda.management.api.client.auth;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.InputStream;
import org.apache.hc.client5.http.impl.classic.AbstractHttpClientResponseHandler;
import org.apache.hc.core5.http.HttpEntity;

public class JsonClientResponseHandler extends AbstractHttpClientResponseHandler<JsonNode> {
  private final ObjectMapper objectMapper;

  public JsonClientResponseHandler(ObjectMapper objectMapper) {
    this.objectMapper = objectMapper;
  }

  @Override
  public JsonNode handleEntity(HttpEntity entity) throws IOException {
    try (InputStream in = entity.getContent()) {
      return objectMapper.readTree(in);
    }
  }
}
