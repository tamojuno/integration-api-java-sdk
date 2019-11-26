package br.com.juno.integration.api.services;

import br.com.juno.integration.api.model.AuthorizationToken;
import kong.unirest.HttpResponse;
import kong.unirest.Unirest;

public final class AuthorizationService {

    private AuthorizationToken authorizationToken;

    public synchronized String getToken() {
        if (authorizationToken == null || authorizationToken.isExpired(ApiConfig.TOKEN_VALIDITY_MIN_TIME_AMOUNT)) {
            refresh(ApiManager.getInstance().getApiConfig());
        }

        return authorizationToken.getAccessToken();
    }

    private void refresh(ApiConfig apiConfig) {
        HttpResponse<AuthorizationToken> response = //
                Unirest.post(apiConfig.getEnv().getUrl() + "/authorization-server/oauth/token") //
                        .basicAuth(apiConfig.getClientId(), apiConfig.getClientSecret()) //
                        .header("Content-Type", "application/x-www-form-urlencoded") //
                        .field("grant_type", "client_credentials") //
                        .asObject(AuthorizationToken.class);

        if (response.getStatus() / 100 != 2) {
            throw new RuntimeException(response.getParsingError().get());
        }

        authorizationToken = response.getBody();
    }
}