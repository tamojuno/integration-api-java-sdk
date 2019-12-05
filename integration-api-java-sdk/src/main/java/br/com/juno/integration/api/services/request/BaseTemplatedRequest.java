package br.com.juno.integration.api.services.request;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.juno.integration.api.base.exception.Assert;
import br.com.juno.integration.api.services.JunoApiManager;

public abstract class BaseTemplatedRequest<T extends Serializable> extends BaseResourceRequest {

    private static final long serialVersionUID = -1057539787053201068L;

    @JsonIgnore
    private T id;

    public BaseTemplatedRequest(T id) {
        this(JunoApiManager.config().getResourceToken(), id);
    }

    public BaseTemplatedRequest(String resourceToken, T id) {
        super(resourceToken);
        setId(id);
    }

    protected void setId(T id) {
        Assert.notNull(id, "Id cannot be null or empty");
        this.id = id;
    }

    public T getId() {
        return id;
    }

}
