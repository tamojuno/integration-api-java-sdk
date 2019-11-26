package br.com.juno.integration.api.services;

import java.util.HashMap;
import java.util.Map;

import br.com.juno.integration.api.base.exception.JunoApiException;
import br.com.juno.integration.api.model.AuthorizationToken;
import kong.unirest.HttpResponse;
import kong.unirest.Unirest;

public final class AuthorizationService {

    private AuthorizationToken authorizationToken;

    public synchronized String getToken() {
        if (authorizationToken == null || authorizationToken.isExpired(JunoApiConfig.TOKEN_TIMEOUT)) {
            refresh();
        }

        return authorizationToken.getAccessToken();
    }

    public Map<String, String> getAuthorizationHeader() {
        Map<String, String> authorizationHeader = new HashMap<>();
        authorizationHeader.put("Authorization", "Bearer" + getToken());
        return authorizationHeader;
    }

    private void refresh() {
        HttpResponse<AuthorizationToken> httpResponse = //
                Unirest.post(JunoApiManager.config().getEnvironmentUrl() + "/authorization-server/oauth/token") //
                        .basicAuth(JunoApiManager.config().getClientId(), JunoApiManager.config().getClientSecret()) //
                        .header("Content-Type", "application/x-www-form-urlencoded") //
                        .field("grant_type", "client_credentials") //
                        .asObject(AuthorizationToken.class);

        if (!httpResponse.isSuccess()) {
            throw new JunoApiException(httpResponse.getParsingError().orElse(null));
        }

        authorizationToken = httpResponse.getBody();
    }
}