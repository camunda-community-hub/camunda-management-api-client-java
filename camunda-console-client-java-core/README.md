# Camunda Console Client Java

## How to use

To use the Camunda console client, add the dependency to your project:

```xml
<dependency>
  <groupId>io.camunda</groupId>
  <artifactId>camunda-console-client-java-core</artifactId>
  <version>${version.camunda-console-client-java}</version>
</dependency>
```

Then, you can bootstrap the client:

* by providing `CamundaConsoleClientProperties`:

```java
var consoleClient = CamundaConsoleClient.create(camundaConsoleClientProperties);
```

* by using env variables:

```java
var consoleClient = CamundaConsoleClient.fromEnv();
```

The environment variables are:

```
CAMUNDA_CONSOLE_CLIENT_ID (mandatory)
CAMUNDA_CONSOLE_CLIENT_SECRET (mandatory)
CAMUNDA_OAUTH_URL (default: 'https://login.cloud.camunda.io/oauth/token')
CAMUNDA_CONSOLE_BASE_URL (default: 'https://api.cloud.camunda.io')
CAMUNDA_CONSOLE_OAUTH_AUDIENCE (default: 'api.cloud.camunda.io')
```

* by using a properties file:

```java
var consoleClient = CamundaConsoleClient.fromProperties(properties);
```

The properties are:

```
camunda.console.client-id (mandatory)
camunda.console.client-secret (mandatory)
camunda.oauth-url (default: 'https://login.cloud.camunda.io/oauth/token')
camunda.console.base-url (default: 'https://api.cloud.camunda.io')
camunda.console.oauth-audience (default: 'api.cloud.camunda.io')
```
