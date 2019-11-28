package br.com.juno.integration.api.services.request.document;

import java.io.InputStream;

public class DocumentUploadEncryptedRequest extends AbstractDocumentRequest {

    private static final long serialVersionUID = 2909141109506130998L;

    private final String fileName;
    private final transient InputStream file;

    public DocumentUploadEncryptedRequest(String resourceToken, String documentId, String fileName, InputStream file) {
        super(resourceToken, documentId);
        this.file = file;
        this.fileName = fileName;
    }

    public DocumentUploadEncryptedRequest(String documentId, String fileName, InputStream file) {
        super(documentId);
        this.file = file;
        this.fileName = fileName;
    }

    public InputStream getFile() {
        return file;
    }

    public String getFileName() {
        return fileName;
    }

}
