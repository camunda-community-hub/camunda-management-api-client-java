package io.camunda.saas.administration.api.client.api.model;

public record ClusterClientDetailsResponse(
    String name, String zeebeAddress, String zeebeClientId, String zeebeAuthorizationServerUrl) {}
