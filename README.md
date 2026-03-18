# Camunda SaaS Administration API Client Java

## How to use

To use the Camunda SaaS administration api client, add the dependency to your project:

```xml
<dependency>
  <groupId>io.camunda</groupId>
  <artifactId>camunda-saas-administration-api-client-java-core</artifactId>
  <version>${version.camunda-saas-administration-api-client-java}</version>
</dependency>
```

Then, you can bootstrap the client:

* by providing `CamundaSaasAdministrationApiClientProperties`:

```java
var saasAdministrationApiClient = CamundaSaasAdministrationApiClient.create(camundaSaasAdministrationApiClientProperties);
```

* by using env variables:

```java
var saasAdministrationApiClient = CamundaSaasAdministrationApiClient.fromEnv();
```

The environment variables are:

```
CAMUNDA_SAAS_ADMINISTRATION_API_CLIENT_ID # (mandatory)
CAMUNDA_SAAS_ADMINISTRATION_API_CLIENT_SECRET # (mandatory)
CAMUNDA_OAUTH_URL # (optional, default: 'https://login.cloud.camunda.io/oauth/token')
CAMUNDA_SAAS_ADMINISTRATION_API_BASE_URL # (optional, default: 'https://api.cloud.camunda.io')
CAMUNDA_SAAS_ADMINISTRATION_API_OAUTH_AUDIENCE # (optional, default: 'api.cloud.camunda.io')
```

* by using a properties file:

```java
var saasAdministrationApiClient = CamundaSaasAdministrationApiClient.fromProperties(properties);
```

The properties are:

```
camunda.saas.administration.api.client-id (mandatory)
camunda.saas.administration.api.client-secret (mandatory)
camunda.oauth-url (default: 'https://login.cloud.camunda.io/oauth/token')
camunda.saas.administration.api.base-url (default: 'https://api.cloud.camunda.io')
camunda.saas.administration.api.oauth-audience (default: 'api.cloud.camunda.io')
```
