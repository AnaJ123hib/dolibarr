package utils;

import net.serenitybdd.model.environment.ConfiguredEnvironment;
import net.thucydides.model.util.EnvironmentVariables;

public class ConfigManager {
    private static final EnvironmentVariables environmentVariables =
            ConfiguredEnvironment.getEnvironmentVariables();

    public static String getUsername() {
        return environmentVariables.getProperty("username");
    }
    public static String getPassword() {
        return environmentVariables.getProperty("password");
    }
}
