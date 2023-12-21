package io.camunda.console.client.properties;

public class Util {
  private Util() {}

  public static String getEnv(String envName, String defaultValue) {
    String env = System.getenv(envName);
    if (env == null) {
      return defaultValue;
    }
    return env;
  }

  public static String getEnv(String envName) {
    String env = System.getenv(envName);
    if (env == null) {
      throw new IllegalStateException("No env defined for " + envName);
    }
    return env;
  }
}
