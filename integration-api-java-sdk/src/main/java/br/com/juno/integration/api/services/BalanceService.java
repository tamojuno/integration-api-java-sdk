package br.com.juno.integration.api.services;

import br.com.juno.integration.api.model.Balance;
import br.com.juno.integration.api.utils.Response;

public final class BalanceService {

    BalanceService() {
        // NTD
    }

    public Response<Balance> getBalance() {
        return getBalance(ApiManager.getInstance().getApiConfig().getResourceToken());
    }

    public Response<Balance> getBalance(String resourceToken) {
        resourceToken.getClass();
        return null;
    }
}
