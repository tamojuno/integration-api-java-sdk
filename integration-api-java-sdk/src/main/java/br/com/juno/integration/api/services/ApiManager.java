package br.com.juno.integration.api.services;

public final class ApiManager {

    private static ApiManager apiManager = null;

    public static synchronized void initialize(String clientId, String clientSecret, String resourceToken) {
        initialize(clientId, clientSecret, resourceToken, false);
    }

    public static synchronized void initialize(String clientId, String clientSecret, String resourceToken, boolean production) {
        if (apiManager != null) {
            throw new IllegalStateException("ApiManager is already initialized");
        }

        apiManager = new ApiManager(clientId, clientSecret, resourceToken, production);
    }

    public static synchronized ApiManager getInstance() {
        if (apiManager == null) {
            throw new IllegalStateException("ApiManager is not initialized");
        }

        return apiManager;
    }

    private final ApiConfig apiConfig;

    private BalanceService balanceService = new BalanceService();
    private AuthorizationService authorizationService = new AuthorizationService();

    public BalanceService getBalanceService() {
        return balanceService;
    }

    private ApiManager(String clientId, String clientSecret, String resourceToken, boolean production) {
        apiConfig = new ApiConfig(clientId, clientSecret, resourceToken, production);
    }

    AuthorizationService getAuthorizationService() {
        return authorizationService;
    }

    ApiConfig getApiConfig() {
        return apiConfig;
    }

}
