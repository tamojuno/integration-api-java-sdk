package br.com.juno.integration.api.services.request.document;

import br.com.juno.integration.api.services.JunoApiManager;

public final class DocumentUploadEncryptedRequest extends AbstractDocumentRequest {

    private static final long serialVersionUID = 2909141109506130998L;

    private final transient JunoFile file;

    public DocumentUploadEncryptedRequest(String documentId, JunoFile file) {
        this(JunoApiManager.config().getResourceToken(), documentId, file);
    }

    public DocumentUploadEncryptedRequest(String resourceToken, String documentId, JunoFile file) {
        super(resourceToken, documentId);
        this.file = file;
    }

    public JunoFile getFile() {
        return file;
    }

}
