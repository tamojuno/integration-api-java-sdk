package br.com.juno.integration.api.services;

public final class ApiConfig {

    public static final Long TOKEN_VALIDITY_MIN_TIME_AMOUNT = 5000L;

    private final Environment env;
    private final String clientId;
    private final String clientSecret;
    private final String resourceToken;

    public ApiConfig(String clientId, String clientSecret, String resourceToken, boolean production) {
        this.env = production ? Environment.PRODUCTION : Environment.SANDBOX;
        this.clientId = clientId;
        this.clientSecret = clientSecret;
        this.resourceToken = resourceToken;
    }

    public Environment getEnv() {
        return env;
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

    public enum Environment {

        PRODUCTION("https://api.juno.com.br"),
        SANDBOX("https://boletobancario.com.br");

        private String url;

        private Environment(String url) {
            this.url = url;
        }

        public String getUrl() {
            return url;
        }
    }

}
