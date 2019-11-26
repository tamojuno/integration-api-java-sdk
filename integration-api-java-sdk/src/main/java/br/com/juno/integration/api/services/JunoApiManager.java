package br.com.juno.integration.api.services;

public final class JunoApiManager {

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
