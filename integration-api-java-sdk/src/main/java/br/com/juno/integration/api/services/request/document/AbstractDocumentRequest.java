package br.com.juno.integration.api.services.request.document;

import java.io.File;
import java.io.InputStream;
import java.io.Serializable;

import org.apache.commons.lang3.StringUtils;

import br.com.juno.integration.api.base.exception.Assert;
import br.com.juno.integration.api.services.request.BaseTemplatedRequest;

public abstract class AbstractDocumentRequest extends BaseTemplatedRequest<String> {

    private static final long serialVersionUID = -8458153295313257412L;

    public AbstractDocumentRequest(String id) {
        super(id);
    }

    public AbstractDocumentRequest(String resourceToken, String id) {
        super(resourceToken, id);
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
