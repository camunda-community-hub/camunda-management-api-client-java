# Camunda Management API Client Java

## How to use

To use the Camunda management api client, add the dependency to your project:

```xml
<dependency>
  <groupId>io.camunda</groupId>
  <artifactId>camunda-management-api-client-java-core</artifactId>
  <version>${version.camunda-management-api-client-java}</version>
</dependency>
```

Then, you can bootstrap the client:

* by providing `CamundaManagementApiClientProperties`:

```java
var managementApiClient = CamundaManagementApiClient.create(camundaManagementApiClientProperties);
```

* by using env variables:

```java
var managementApiClient = CamundaManagementApiClient.fromEnv();
```

The environment variables are:

```
CAMUNDA_MANAGEMENT_API_CLIENT_ID (mandatory)
CAMUNDA_MANAGEMENT_API_CLIENT_SECRET (mandatory)
CAMUNDA_OAUTH_URL (default: 'https://login.cloud.camunda.io/oauth/token')
CAMUNDA_MANAGEMENT_API_BASE_URL (default: 'https://api.cloud.camunda.io')
CAMUNDA_MANAGEMENT_API_OAUTH_AUDIENCE (default: 'api.cloud.camunda.io')
```

* by using a properties file:

```java
var managementApiClient = CamundaManagementApiClient.fromProperties(properties);
```

The properties are:

```
camunda.management.api.client-id (mandatory)
camunda.management.api.client-secret (mandatory)
camunda.oauth-url (default: 'https://login.cloud.camunda.io/oauth/token')
camunda.management.api.base-url (default: 'https://api.cloud.camunda.io')
camunda.management.api.oauth-audience (default: 'api.cloud.camunda.io')
```
