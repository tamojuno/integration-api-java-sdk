package br.com.juno.integration.api.services.request.document;

public final class DocumentGetRequest extends AbstractDocumentRequest {

    private static final long serialVersionUID = 928711404709080291L;

    public DocumentGetRequest(String documentId) {
        super(documentId);
    }

    public DocumentGetRequest(String resourceToken, String documentId) {
        super(resourceToken, documentId);
    }

}
