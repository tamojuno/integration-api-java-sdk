package br.com.juno.integration.api.services;

import org.springframework.hateoas.hal.Jackson2HalModule;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import com.fasterxml.jackson.core.JsonProcessingException;

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

    private BalanceService balanceService = new BalanceService();
    private AuthorizationService authorizationService = new AuthorizationService();

    public BalanceService getBalanceService() {
        return balanceService;
    }

    private ApiManager(String clientId, String clientSecret, String resourceToken, boolean production) {
        apiConfig = new ApiConfig(clientId, clientSecret, resourceToken, production);
        configUnirest();
    }

    private void configUnirest() {
        Unirest.config().setDefaultHeader("X-API-VERSION", "2");
        Unirest.config().setObjectMapper(new ObjectMapper() {

            com.fasterxml.jackson.databind.ObjectMapper mapper = Jackson2ObjectMapperBuilder.json().modules(new Jackson2HalModule()).build();

            @Override
            public String writeValue(Object value) {
                try {
                    return mapper.writeValueAsString(value);
                } catch (JsonProcessingException e) {
                    throw new RuntimeException(e);
                }
            }

            @Override
            public <T> T readValue(String value, Class<T> valueType) {
                try {
                    return mapper.readValue(value, valueType);
                } catch (JsonProcessingException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }

    AuthorizationService getAuthorizationService() {
        return authorizationService;
    }

    ApiConfig getApiConfig() {
        return apiConfig;
    }
}
