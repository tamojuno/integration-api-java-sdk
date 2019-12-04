package br.com.juno.integration.api.model;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class ErrorDetail extends Error {

    private static final long serialVersionUID = 6629135241307840566L;

    private final String timestamp;
    private final String status;
    private final String error;
    private final String details;
    private final String path;

    protected ErrorDetail(String timestamp, String status, String error, String details, String path) {
        this.timestamp = timestamp;
        this.status = status;
        this.error = error;
        this.details = details;
        this.path = path;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public String getStatus() {
        return status;
    }

    public String getError() {
        return error;
    }

    public String getDetails() {
        return details;
    }

    public String getPath() {
        return path;
    }

    @Override
    public String toString() {
        ToStringBuilder builder = new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE);
        builder.append(timestamp);
        builder.append(status);
        builder.append(error);
        builder.append(details);
        builder.append(path);
        return builder.toString();
    }

}
