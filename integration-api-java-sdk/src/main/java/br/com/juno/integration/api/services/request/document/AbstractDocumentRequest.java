package br.com.juno.integration.api.services.request.document;

import br.com.juno.integration.api.services.JunoApiManager;
import br.com.juno.integration.api.services.request.BaseRequest;

public abstract class AbstractDocumentRequest extends BaseRequest {

    private static final long serialVersionUID = -8458153295313257412L;

    protected final String documentId;

    public AbstractDocumentRequest(String documentId) {
        this(JunoApiManager.config().getResourceToken(), documentId);
    }

    public AbstractDocumentRequest(String resourceToken, String documentId) {
        this.documentId = documentId;
        setResourceToken(resourceToken);
    }

    public String getDocumentId() {
        return documentId;
    }
}
