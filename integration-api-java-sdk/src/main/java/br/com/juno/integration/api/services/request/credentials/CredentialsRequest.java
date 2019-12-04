package br.com.juno.integration.api.services.request.credentials;

import br.com.juno.integration.api.services.request.BaseResourceRequest;

public final class CredentialsRequest extends BaseResourceRequest {

    private static final long serialVersionUID = 9131125917965515040L;

    public CredentialsRequest() {
        super();
    }

    public CredentialsRequest(String resourceToken) {
        super(resourceToken);
    }

}
