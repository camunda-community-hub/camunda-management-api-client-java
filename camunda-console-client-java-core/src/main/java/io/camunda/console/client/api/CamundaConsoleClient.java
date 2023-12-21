package io.camunda.console.client.api;

import io.camunda.console.client.DefaultApiFactory;
import io.camunda.console.client.impl.CamundaConsoleClientImpl;
import io.camunda.console.client.model.BackupDto;
import io.camunda.console.client.model.ClusterClient;
import io.camunda.console.client.model.ClusterClientConnectionDetails;
import io.camunda.console.client.model.CreateCluster200Response;
import io.camunda.console.client.model.CreateClusterBody;
import io.camunda.console.client.model.CreateClusterClientBody;
import io.camunda.console.client.model.CreateSecretBody;
import io.camunda.console.client.model.CreatedClusterClient;
import io.camunda.console.client.model.IpWhiteListBody;
import io.camunda.console.client.model.PostMemberBody;
import io.camunda.console.client.properties.CamundaConsoleClientProperties;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public interface CamundaConsoleClient {

  static CamundaConsoleClient create(CamundaConsoleClientProperties properties) {
    return new CamundaConsoleClientImpl(DefaultApiFactory.getInstance(properties).get());
  }

  static CamundaConsoleClient fromEnv() {
    return create(CamundaConsoleClientProperties.fromEnv());
  }

  static CamundaConsoleClient fromProperties(Properties properties) {
    return create(CamundaConsoleClientProperties.fromProperties(properties));
  }

  Clusters clusters();

  Cluster clusters(String clusterId);

  Members members();

  Member members(String email);

  interface Clusters {
    List<io.camunda.console.client.model.Cluster> get();

    CreateCluster200Response post(CreateClusterBody request);

    io.camunda.console.client.model.Parameters parameters();

    interface Parameters {
      io.camunda.console.client.model.Parameters get();
    }
  }

  interface Cluster {
    io.camunda.console.client.model.Cluster get();

    void delete();

    Backups backups();

    Backup backups(String backupId);

    IpWhiteList ipwhitelist();

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

    interface IpWhiteList {
      void put(IpWhiteListBody request);
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
    List<io.camunda.console.client.model.Member> get();
  }

  interface Member {
    void post(PostMemberBody request);

    void delete();
  }
}
