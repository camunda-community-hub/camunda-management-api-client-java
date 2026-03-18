package io.camunda.saas.administration.api.client.api.model;

import java.util.List;

public record IpAllowListRequest(List<IpAllow> ipallowlist) {}
