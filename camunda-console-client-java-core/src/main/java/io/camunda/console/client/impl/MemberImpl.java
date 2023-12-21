package io.camunda.console.client.impl;

import io.camunda.console.client.api.CamundaConsoleClient.Member;
import io.camunda.console.client.exception.CamundaConsoleClientException;
import io.camunda.console.client.invoker.ApiException;
import io.camunda.console.client.model.PostMemberBody;

public class MemberImpl extends AbstractCamundaConsoleClient implements Member {
  private final String email;

  public MemberImpl(AbstractCamundaConsoleClient consoleClient, String email) {
    super(consoleClient);
    this.email = email;
  }

  @Override
  public void post(PostMemberBody request) {
    try {
      getApi().updateMembers(email, request);
    } catch (ApiException e) {
      throw new CamundaConsoleClientException(e);
    }
  }

  @Override
  public void delete() {
    try {
      getApi().deleteMember(email);
    } catch (ApiException e) {
      throw new CamundaConsoleClientException(e);
    }
  }
}
