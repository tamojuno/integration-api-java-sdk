package br.com.juno.integration.api.services;

import org.springframework.hateoas.Resource;

import br.com.juno.integration.api.model.Balance;
import br.com.juno.integration.api.model.response.Response;
import br.com.juno.integration.api.utils.ResponseUtils;
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
        HttpResponse<Resource<Balance>> httpResponse = Unirest.get(JunoApiManager.config().getEnvironmentUrl() + "/api-integration/balance") //
                .headers(JunoApiManager.resources().authorization().getAuthorizationHeader()) //
                .header(JunoApiManager.X_RESOURCE_TOKEN, resourceToken) //
                .asObject(new GenericType<Resource<Balance>>() {
                    // NTD
                });

        ResponseUtils.validateSuccess(httpResponse);

        return new Response<>(httpResponse.getBody()).getContent();
    }

}
