package br.com.juno.integration.api.services;

import org.springframework.hateoas.Resource;

import br.com.juno.integration.api.model.Balance;
import br.com.juno.integration.api.services.request.balance.GetBalanceRequest;
import br.com.juno.integration.api.services.response.Response;
import br.com.juno.integration.api.utils.ResponseUtils;
import kong.unirest.GenericType;
import kong.unirest.HttpResponse;
import kong.unirest.Unirest;

public final class BalanceService extends BaseService {

    BalanceService() {
        // NTD
    }

    public Balance getBalance(GetBalanceRequest request) {
        HttpResponse<Resource<Balance>> httpResponse = Unirest.get(JunoApiManager.config().getEnvironmentUrl() + "/api-integration/balance") //
                .headers(JunoApiManager.getAuthorizationService().getAuthorizationHeader()) //
                .header(JunoApiManager.X_RESOURCE_TOKEN, request.getResourceToken()) //
                .asObject(new GenericType<Resource<Balance>>() {
                    // NTD
                });

        ResponseUtils.validateSuccess(httpResponse);

        return new Response<>(httpResponse.getBody()).getContent();
    }

}
