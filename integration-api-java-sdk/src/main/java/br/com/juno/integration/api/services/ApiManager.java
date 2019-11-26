package br.com.juno.integration.api.services;

import com.fasterxml.jackson.core.JsonProcessingException;

import br.com.juno.integration.api.utils.ResponseUtils;
import kong.unirest.ObjectMapper;
import kong.unirest.Unirest;

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

    private DataService dataService = new DataService();
    private BalanceService balanceService = new BalanceService();
    private AuthorizationService authorizationService = new AuthorizationService();

    private ApiManager(String clientId, String clientSecret, String resourceToken, boolean production) {
        apiConfig = new ApiConfig(clientId, clientSecret, resourceToken, production);
        configUnirest();
    }

    ApiConfig getApiConfig() {
        return apiConfig;
    }

    private void configUnirest() {
        Unirest.config().setDefaultHeader("X-API-Version", "2");
        Unirest.config().setObjectMapper(new ObjectMapper() {

            @Override
            public String writeValue(Object value) {
                try {
                    return ResponseUtils.getObjectMapper().writeValueAsString(value);
                } catch (JsonProcessingException e) {
                    throw new RuntimeException(e);
                }
            }

            @Override
            public <T> T readValue(String value, Class<T> valueType) {
                try {
                    return ResponseUtils.getObjectMapper().readValue(value, valueType);
                } catch (JsonProcessingException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }

    public DataService getDataService() {
        return dataService;
    }

    public BalanceService getBalanceService() {
        return balanceService;
    }

    AuthorizationService getAuthorizationService() {
        return authorizationService;
    }
}
