package io.camunda.management.api.client.api;

import io.camunda.management.api.client.DefaultApiFactory;
import io.camunda.management.api.client.impl.CamundaManagementApiClientImpl;
import io.camunda.management.api.client.model.AuditDto;
import io.camunda.management.api.client.model.BackupDto;
import io.camunda.management.api.client.model.ClusterClient;
import io.camunda.management.api.client.model.ClusterClientConnectionDetails;
import io.camunda.management.api.client.model.CreateCluster200Response;
import io.camunda.management.api.client.model.CreateClusterBody;
import io.camunda.management.api.client.model.CreateClusterClientBody;
import io.camunda.management.api.client.model.CreateSecretBody;
import io.camunda.management.api.client.model.CreatedClusterClient;
import io.camunda.management.api.client.model.GenerationUpgradeForClusterDto;
import io.camunda.management.api.client.model.IpAllowListBody;
import io.camunda.management.api.client.model.IpWhiteListBody;
import io.camunda.management.api.client.model.MetaDto;
import io.camunda.management.api.client.model.PostMemberBody;
import io.camunda.management.api.client.model.UpdateClusterBody;
import io.camunda.management.api.client.properties.CamundaManagementApiClientProperties;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public interface CamundaManagementApiClient {

  static CamundaManagementApiClient create(CamundaManagementApiClientProperties properties) {
    return new CamundaManagementApiClientImpl(DefaultApiFactory.getInstance(properties).get());
  }

  static CamundaManagementApiClient fromEnv() {
    return create(CamundaManagementApiClientProperties.fromEnv());
  }

  static CamundaManagementApiClient fromProperties(Properties properties) {
    return create(CamundaManagementApiClientProperties.fromProperties(properties));
  }

  Clusters clusters();

  Cluster clusters(String clusterId);

  Members members();

  Member members(String email);

  Meta meta();

  Activity activity();

  interface Clusters {
    List<io.camunda.management.api.client.model.Cluster> get();

    CreateCluster200Response post(CreateClusterBody request);

    Parameters parameters();

    interface Parameters {
      io.camunda.management.api.client.model.Parameters get();
    }
  }

  interface Cluster {
    io.camunda.management.api.client.model.Cluster get();

    void delete();

    void patch(UpdateClusterBody request);

    Upgrade upgrade();

    Backups backups();

    Backup backups(String backupId);

    @Deprecated
    IpWhiteList ipwhitelist();

    IpAllowList ipallowlist();

    Wake wake();

    Clients clients();

    Client clients(String clientId);

    Secrets secrets();

    Secret secrets(String secretName);

    interface Backups {
      List<BackupDto> get();

      BackupDto post();
    }

    interface Backup {
      BackupDto delete();
    }

    @Deprecated
    interface IpWhiteList {
      void put(IpWhiteListBody request);
    }

    interface IpAllowList {
      void put(IpAllowListBody request);
    }

    interface Wake {
      void put();
    }

    interface Clients {
      List<ClusterClient> get();

      CreatedClusterClient post(CreateClusterClientBody request);
    }

    interface Client {
      ClusterClientConnectionDetails get();

      void delete();
    }

    interface Secrets {
      Map<String, String> get();

      void post(CreateSecretBody request);
    }

    interface Secret {
      void delete();
    }
  }

  interface Members {
    List<io.camunda.management.api.client.model.Member> get();
  }

  interface Member {
    void post(PostMemberBody request);

    void delete();
  }

  interface Upgrade {
    GenerationUpgradeForClusterDto put();
  }

  interface Meta {
    IpRanges ipRanges();
  }

  interface IpRanges {
    MetaDto ipRanges();
  }

  interface Activity {
    Json json();

    Csv csv();
  }

  interface Json {
    List<AuditDto> get();
  }

  interface Csv {
    String get();
  }
}
