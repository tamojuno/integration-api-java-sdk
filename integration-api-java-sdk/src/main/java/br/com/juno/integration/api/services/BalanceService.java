package br.com.juno.integration.api.services;

import static br.com.juno.integration.api.services.JunoApiManager.CONTENT_TYPE_HEADER;

import org.springframework.hateoas.Resource;
import org.springframework.http.MediaType;

import br.com.juno.integration.api.model.Balance;
import br.com.juno.integration.api.services.request.balance.GetBalanceRequest;
import br.com.juno.integration.api.services.response.Response;
import kong.unirest.GenericType;
import kong.unirest.HttpResponse;
import kong.unirest.Unirest;

public final class BalanceService extends BaseService {

    public static final String BALANCE_ENDPOINT = "/balance";

    BalanceService() {
        // NTD
    }

    public Balance getBalance(GetBalanceRequest request) {
        HttpResponse<Resource<Balance>> response = Unirest.get(JunoApiManager.config().getResourceEndpoint() + BALANCE_ENDPOINT) //
                .header(JunoApiManager.X_RESOURCE_TOKEN, request.getResourceToken()) //
                .header(CONTENT_TYPE_HEADER, MediaType.APPLICATION_JSON_VALUE) //
                .asObject(new GenericType<Resource<Balance>>() {
                    // NTD
                });

        return new Response<>(response.getBody()).getContent();
    }

}
