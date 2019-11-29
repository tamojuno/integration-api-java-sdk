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

    public static DataService getDataService() {
        return resources.getDataService();
    }

    public static ChargeService getChargeService() {
        return resources.getChargeService();
    }

    public static BalanceService getBalanceService() {
        return resources.getBalanceService();
    }

    public static CredentialsService getCredentialsService() {
        return resources.getCredentialsService();
    }

    public static AuthorizationService getAuthorizationService() {
        return resources.getAuthorizationService();
    }

}
