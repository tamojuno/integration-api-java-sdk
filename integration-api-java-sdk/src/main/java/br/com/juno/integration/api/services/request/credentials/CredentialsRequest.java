package br.com.juno.integration.api.services.request.credentials;

import br.com.juno.integration.api.services.JunoApiManager;
import br.com.juno.integration.api.services.request.BaseRequest;

public class CredentialsRequest extends BaseRequest {

    private static final long serialVersionUID = 9131125917965515040L;

    public CredentialsRequest() {
        this(JunoApiManager.config().getResourceToken());
    }

    public CredentialsRequest(String resourceToken) {
        setResourceToken(resourceToken);
    }

}
