package br.com.juno.integration.api.services.request;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.juno.integration.api.base.exception.Assert;

public abstract class BaseRequest implements Serializable {

    private static final long serialVersionUID = -4768246046334462809L;

    @JsonIgnore
    protected String resourceToken;

    public String getResourceToken() {
        return resourceToken;
    }

    protected void setResourceToken(String resourceToken) {
        Assert.notNull(resourceToken, "Resource cannot be null or empty");
        this.resourceToken = resourceToken;
    }

}
