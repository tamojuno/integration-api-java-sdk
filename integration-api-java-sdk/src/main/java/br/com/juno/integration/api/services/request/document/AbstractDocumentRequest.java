package br.com.juno.integration.api.services.request.document;

import java.io.File;
import java.io.InputStream;
import java.io.Serializable;

import org.apache.commons.lang3.StringUtils;
import org.springframework.util.Assert;

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

    public static class JunoFile implements Serializable {

        private static final long serialVersionUID = -5615097493302374165L;

        private transient InputStream stream;
        private String fileName;
        private File file;

        public JunoFile(InputStream stream, String fileName) {
            Assert.notNull(stream, "Stream must not be null");
            Assert.isTrue(StringUtils.isNotBlank(fileName), "Filename must not be null or empty");
            this.stream = stream;
            this.fileName = fileName;
        }

        public JunoFile(File file) {
            Assert.notNull(file, "File must not be null");
            this.file = file;
        }

        public InputStream getStream() {
            return stream;
        }

        public String getFileName() {
            return fileName;
        }

        public File getFile() {
            return file;
        }

        public boolean hasFile() {
            return file != null;
        }

        public boolean hasStream() {
            return stream != null;
        }

    }
}
