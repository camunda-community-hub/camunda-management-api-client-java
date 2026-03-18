package io.camunda.saas.administration.api.client.api.model;

import java.util.List;

public record ParametersResponse(
    List<Channel> channel, List<ClusterPlanType> clusterPlanTypes, List<Region> regions) {
  public record Channel(
      List<ClusterPlanType> allowedGenerations,
      ClusterPlanType defaultGeneration,
      String name,
      String uuid) {}

  public record ClusterPlanType(String name, String uuid) {}

  public record Region(List<Backup> backups, String provider, String name, String uuid) {
    public record Backup(List<BackupRegion> regions, String uuid) {
      public record BackupRegion(String label, String id) {}
    }
  }
}
