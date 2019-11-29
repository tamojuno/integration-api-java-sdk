package br.com.juno.integration.api.services;

import org.apache.commons.lang3.StringUtils;

import br.com.juno.integration.api.config.UnirestConfig;

public final class JunoApiConfig {

    public static final Long TOKEN_TIMEOUT = 5000L;
    public static final Long CACHE_TIMEOUT = 6 * 60 * 60 * 1000L;

    private String clientId;
    private String clientSecret;
    private String resourceToken;
    private Environment env;

    JunoApiConfig() {
        sandbox();
        UnirestConfig.configure();
    }

    public JunoApiConfig production() {
        this.env = new ProductionEnviroment();
        return this;
    }

    public JunoApiConfig sandbox() {
        this.env = new SandboxEnvironment();
        return this;
    }

    public JunoApiConfig development() {
        this.env = new DevelopmentEnviroment();
        return this;
    }

    public JunoApiConfig clientId(String clientId) {
        this.clientId = clientId;
        return this;
    }

    public JunoApiConfig clientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
        return this;
    }

    public JunoApiConfig resourceToken(String resourceToken) {
        this.resourceToken = resourceToken;
        return this;
    }

    public Environment getEnv() {
        return env;
    }

    public String getAuthorizationEndpoint() {
        return env.getAuthorizationServerEndpoint();
    }

    public String getResourceEndpoint() {
        return env.getResourceServerEndpoint();
    }

    public String getClientId() {
        return clientId;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public String getResourceToken() {
        return resourceToken;
    }

    public boolean isConfigured() {
        return StringUtils.isNoneBlank(clientId, clientSecret, resourceToken) && env != null;
    }

    public interface Environment {

        String getAuthorizationServerEndpoint();

        String getResourceServerEndpoint();

    }

    public static class DevelopmentEnviroment implements Environment {

        private static final String AUTHORIZATION_SERVER = "http://localhost:8084";
        private static final String RESOURCE_SERVER = "http://localhost:8082";

        @Override
        public String getAuthorizationServerEndpoint() {
            return AUTHORIZATION_SERVER;
        }

        @Override
        public String getResourceServerEndpoint() {
            return RESOURCE_SERVER;
        }

    }

    public static class SandboxEnvironment implements Environment {

        private static final String AUTHORIZATION_SERVER = "https://sandbox.boletobancario.com/authorization-server";
        private static final String RESOURCE_SERVER = "https://sandbox.boletobancario.com/api-integration";

        @Override
        public String getAuthorizationServerEndpoint() {
            return AUTHORIZATION_SERVER;
        }

        @Override
        public String getResourceServerEndpoint() {
            return RESOURCE_SERVER;
        }

    }

    public static class ProductionEnviroment implements Environment {

        private static final String AUTHORIZATION_SERVER = "https://api.juno.com.br/authorization-server";
        private static final String RESOURCE_SERVER = "https://api.juno.com.br";

        @Override
        public String getAuthorizationServerEndpoint() {
            return AUTHORIZATION_SERVER;
        }

        @Override
        public String getResourceServerEndpoint() {
            return RESOURCE_SERVER;
        }

    }

}
