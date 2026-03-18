package io.camunda.saas.administration.api.client.api.model;

import java.util.List;

public record CreateClusterClientResponse(
    String name,
    String uuid,
    String clientId,
    String clientSecret,
    List<String> permissions,
    Links links) {
  public record Links(
      String oauth,
      String connectors,
      String console,
      String optimize,
      String tasklist,
      String operate,
      String zeebe) {}
}
