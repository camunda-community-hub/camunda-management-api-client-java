package io.camunda.saas.administration.api.client.api.model;

public record UpdateClusterRequest(
    String name, String description, StageLabel stageLabel, Double numberOfAllocatedHwPackages) {}
