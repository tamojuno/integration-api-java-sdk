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
        this.env = Environment.PRODUCTION;
        return this;
    }

    public JunoApiConfig sandbox() {
        this.env = Environment.SANDBOX;
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

    public String getEnvironmentUrl() {
        return env.getUrl();
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

    public enum Environment {

        PRODUCTION("https://api.juno.com.br"),
        SANDBOX("https://sandbox.boletobancario.com");

        private String url;

        private Environment(String url) {
            this.url = url;
        }

        public String getUrl() {
            return url;
        }
    }

}
