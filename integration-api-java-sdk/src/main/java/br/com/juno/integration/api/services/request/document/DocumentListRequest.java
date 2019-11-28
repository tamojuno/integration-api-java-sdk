package br.com.juno.integration.api.services.request.document;

import br.com.juno.integration.api.services.JunoApiManager;
import br.com.juno.integration.api.services.request.BaseRequest;

public class DocumentListRequest extends BaseRequest {

    private static final long serialVersionUID = 3175598211179607287L;

    public DocumentListRequest() {
        this(JunoApiManager.config().getResourceToken());
    }

    public DocumentListRequest(String resourceToken) {
        setResourceToken(resourceToken);
    }

}
