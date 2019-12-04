package br.com.juno.integration.api.services.request;

import br.com.juno.integration.api.services.JunoApiManager;

public abstract class BaseResourceRequest extends BaseRequest {

    private static final long serialVersionUID = -1057539787053201068L;

    public BaseResourceRequest() {
        this(JunoApiManager.config().getResourceToken());
    }

    public BaseResourceRequest(String resourceToken) {
        setResourceToken(resourceToken);
    }

}