package io.camunda.console.client.impl;

import io.camunda.console.client.api.CamundaConsoleClient.Members;
import io.camunda.console.client.exception.CamundaConsoleClientException;
import io.camunda.console.client.invoker.ApiException;
import io.camunda.console.client.model.Member;
import java.util.List;

public class MembersImpl extends AbstractCamundaConsoleClient implements Members {
  public MembersImpl(AbstractCamundaConsoleClient consoleClient) {
    super(consoleClient);
  }

  @Override
  public List<Member> get() {
    try {
      return getApi().getMembers();
    } catch (ApiException e) {
      throw new CamundaConsoleClientException(e);
    }
  }
}
