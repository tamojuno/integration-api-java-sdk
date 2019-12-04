package br.com.juno.integration.api.services.request;

import java.io.Serializable;

import br.com.juno.integration.api.services.JunoApiManager;

public abstract class BaseTemplatedRequest<T extends Serializable> extends BaseResourceRequest {

    private static final long serialVersionUID = -1057539787053201068L;

    private final T id;

    public BaseTemplatedRequest(T id) {
        this(JunoApiManager.config().getResourceToken(), id);
    }

    public BaseTemplatedRequest(String resourceToken, T id) {
        super(resourceToken);
        this.id = id;
    }

    public T getId() {
        return id;
    }

}
