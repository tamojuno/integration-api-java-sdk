package br.com.juno.integration.api.services.request.balance;

import br.com.juno.integration.api.services.JunoApiManager;
import br.com.juno.integration.api.services.request.BaseRequest;

public class GetBalanceRequest extends BaseRequest {

    private static final long serialVersionUID = 4513663922487454055L;

    public GetBalanceRequest() {
        this(JunoApiManager.config().getResourceToken());
    }

    public GetBalanceRequest(String resourceToken) {
        setResourceToken(resourceToken);
    }

}
