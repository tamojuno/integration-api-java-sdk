package br.com.juno.integration.api.services.request.document;

import java.util.LinkedList;
import java.util.List;

public final class DocumentUploadRequest extends AbstractDocumentRequest {

    private static final long serialVersionUID = 2909141109506130998L;

    private final transient List<JunoFile> files = new LinkedList<>();

    public DocumentUploadRequest(String documentId) {
        super(documentId);
    }

    public DocumentUploadRequest(String resourceToken, String documentId) {
        super(resourceToken, documentId);
    }

    public List<JunoFile> getFiles() {
        return files;
    }

}
