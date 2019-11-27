package br.com.juno.integration.api.services;

public final class JunoApiManager {

    public static final String X_RESOURCE_TOKEN = "X-Resource-Token";
    public static final String X_API_VERSION = "X-API-Version";

    private JunoApiManager() {
        // Private Constructor
    }

    private static final JunoApiConfig config = new JunoApiConfig();
    private static final JunoApiResources resources = new JunoApiResources();

    public static JunoApiConfig config() {
        return config;
    }

    public static JunoApiResources resources() {
        return resources;
    }

}
