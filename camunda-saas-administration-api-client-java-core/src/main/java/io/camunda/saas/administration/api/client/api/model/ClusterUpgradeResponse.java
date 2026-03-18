package io.camunda.saas.administration.api.client.api.model;

public record ClusterUpgradeResponse(
    Generation cluster, Generation oldGeneration, Generation newGeneration, String orgId) {
  public record Generation(String id, String name) {}
}
