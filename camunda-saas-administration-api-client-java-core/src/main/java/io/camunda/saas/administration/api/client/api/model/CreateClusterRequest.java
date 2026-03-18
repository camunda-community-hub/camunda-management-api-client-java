package io.camunda.saas.administration.api.client.api.model;

public record CreateClusterRequest(
    String name,
    String description,
    String planTypeId,
    String channelId,
    String generationId,
    String regionId,
    String backupRegionId,
    Boolean autoUpdate,
    StageLabel stageLabel,
    Encryption encryption,
    Double hardwarePackages,
    Boolean identityBackendChecksEnabled) {

  public enum Encryption {
    SOFTWARE,
    HARDWARE,
    PROVIDER,
    EXTERNAL
  }
}
