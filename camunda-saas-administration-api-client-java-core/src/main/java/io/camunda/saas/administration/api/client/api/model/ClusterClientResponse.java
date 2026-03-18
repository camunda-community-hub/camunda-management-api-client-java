package io.camunda.saas.administration.api.client.api.model;

import java.util.List;

public record ClusterClientResponse(String name, String clientId, List<Permission> permissions) {}
