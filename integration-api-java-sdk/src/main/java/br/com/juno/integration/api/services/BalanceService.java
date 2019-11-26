package br.com.juno.integration.api.services;

import org.springframework.hateoas.Resource;

import br.com.juno.integration.api.model.Balance;
import br.com.juno.integration.api.utils.Response;
import kong.unirest.GenericType;
import kong.unirest.HttpResponse;
import kong.unirest.Unirest;

public final class BalanceService extends BaseService {

    BalanceService() {
        // NTD
    }

    public Balance get() {
        return get(JunoApiManager.config().getResourceToken());
    }

    public Balance get(String resourceToken) {

        HttpResponse<Resource<Balance>> balanceResponse = Unirest.get(JunoApiManager.config().getEnvironmentUrl() + "/api-integration/balance") //
                .headers(JunoApiManager.resources().authorization().getAuthorizationHeader()) //
                .header("X-Resource-Token", resourceToken) //
                .asObject(new GenericType<Resource<Balance>>() {
                    // NTD
                });

        return new Response<>(balanceResponse.getBody()).getContent();
    }

}
