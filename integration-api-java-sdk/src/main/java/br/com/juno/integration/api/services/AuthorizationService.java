package br.com.juno.integration.api.services;

import br.com.juno.integration.api.model.AuthorizationToken;

public final class AuthorizationService {

    private AuthorizationToken authorizationToken;

    public String getToken() {
        if (authorizationToken == null || authorizationToken.isExpired(ApiConfig.TOKEN_VALIDITY_MIN_TIME_AMOUNT)) {
            refresh();
        }

        return authorizationToken.getAccessToken();
    }

    private void refresh() {
        authorizationToken = new AuthorizationToken();
    }

}
