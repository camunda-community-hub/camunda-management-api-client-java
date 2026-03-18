package io.camunda.saas.administration.api.client.api;

import io.camunda.saas.administration.api.client.DefaultApiFactory;
import io.camunda.saas.administration.api.client.api.model.ActivityResponse;
import io.camunda.saas.administration.api.client.api.model.BackupResponse;
import io.camunda.saas.administration.api.client.api.model.ClusterClientDetailsResponse;
import io.camunda.saas.administration.api.client.api.model.ClusterClientResponse;
import io.camunda.saas.administration.api.client.api.model.ClusterResponse;
import io.camunda.saas.administration.api.client.api.model.ClusterUpgradeResponse;
import io.camunda.saas.administration.api.client.api.model.CreateClusterClientRequest;
import io.camunda.saas.administration.api.client.api.model.CreateClusterClientResponse;
import io.camunda.saas.administration.api.client.api.model.CreateClusterRequest;
import io.camunda.saas.administration.api.client.api.model.CreateClusterResponse;
import io.camunda.saas.administration.api.client.api.model.CreateSecretRequest;
import io.camunda.saas.administration.api.client.api.model.IpAllowListRequest;
import io.camunda.saas.administration.api.client.api.model.IpRangesResponse;
import io.camunda.saas.administration.api.client.api.model.MemberResponse;
import io.camunda.saas.administration.api.client.api.model.ParametersResponse;
import io.camunda.saas.administration.api.client.api.model.PostMemberRequest;
import io.camunda.saas.administration.api.client.api.model.UpdateClusterRequest;
import io.camunda.saas.administration.api.client.impl.CamundaSaasAdministrationApiClientImpl;
import io.camunda.saas.administration.api.client.properties.CamundaSaasAdministrationApiClientProperties;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public interface CamundaSaasAdministrationApiClient {

  static CamundaSaasAdministrationApiClient create(
      CamundaSaasAdministrationApiClientProperties properties) {
    return new CamundaSaasAdministrationApiClientImpl(
        DefaultApiFactory.getInstance(properties).get());
  }

  static CamundaSaasAdministrationApiClient fromEnv() {
    return create(CamundaSaasAdministrationApiClientProperties.fromEnv());
  }

  static CamundaSaasAdministrationApiClient fromProperties(Properties properties) {
    return create(CamundaSaasAdministrationApiClientProperties.fromProperties(properties));
  }

  Clusters clusters();

  Cluster clusters(String clusterId);

  Members members();

  Member members(String email);

  Meta meta();

  Activity activity();

  interface Clusters {
    List<ClusterResponse> get();

    CreateClusterResponse post(CreateClusterRequest request);

    Parameters parameters();

    interface Parameters {
      ParametersResponse get();
    }
  }

  interface Cluster {
    ClusterResponse get();

    void delete();

    void patch(UpdateClusterRequest request);

    Upgrade upgrade();

    Backups backups();

    Backup backups(String backupId);

    IpAllowList ipallowlist();

    Wake wake();

    Clients clients();

    Client clients(String clientId);

    Secrets secrets();

    Secret secrets(String secretName);

    interface Backups {
      List<BackupResponse> get();

      BackupResponse post();
    }

    interface Backup {
      BackupResponse delete();
    }

    interface IpAllowList {
      void put(IpAllowListRequest request);
    }

    interface Wake {
      void put();
    }

    interface Clients {
      List<ClusterClientResponse> get();

      CreateClusterClientResponse post(CreateClusterClientRequest request);
    }

    interface Client {
      ClusterClientDetailsResponse get();

      void delete();
    }

    interface Secrets {
      Map<String, String> get();

      void post(CreateSecretRequest request);
    }

    interface Secret {
      void delete();
    }
  }

  interface Members {
    List<MemberResponse> get();
  }

  interface Member {
    void post(PostMemberRequest request);

    void delete();
  }

  interface Upgrade {
    ClusterUpgradeResponse put();
  }

  interface Meta {
    IpRanges ipRanges();
  }

  interface IpRanges {
    IpRangesResponse get();
  }

  interface Activity {
    Json json();

    Csv csv();
  }

  interface Json {
    List<ActivityResponse> get();
  }

  interface Csv {
    String get();
  }
}
