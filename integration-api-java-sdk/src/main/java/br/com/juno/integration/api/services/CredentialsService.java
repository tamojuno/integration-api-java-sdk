package br.com.juno.integration.api.services;

import static br.com.juno.integration.api.services.JunoApiManager.CONTENT_TYPE_HEADER;
import static br.com.juno.integration.api.services.JunoApiManager.X_RESOURCE_TOKEN;

import org.springframework.http.MediaType;

import br.com.juno.integration.api.model.JunoPublicKey;
import br.com.juno.integration.api.services.request.credentials.CredentialsRequest;
import br.com.juno.integration.api.utils.ResponseUtils;
import kong.unirest.HttpResponse;
import kong.unirest.Unirest;

public class CredentialsService extends BaseService {

    CredentialsService() {
        // NTD
    }

    public JunoPublicKey getPublicCredentials(CredentialsRequest request) {
        HttpResponse<String> response = Unirest.get(JunoApiManager.config().getResourceEndpoint() + "/credentials/public-key") //
                .headers(JunoApiManager.getAuthorizationService().getAuthorizationHeader()) //
                .header(X_RESOURCE_TOKEN, request.getResourceToken()) //
                .header(CONTENT_TYPE_HEADER, MediaType.TEXT_PLAIN_VALUE) //
                .asString(); //

        ResponseUtils.validateSuccess(response);

        return new JunoPublicKey(response.getBody());
    }

}
