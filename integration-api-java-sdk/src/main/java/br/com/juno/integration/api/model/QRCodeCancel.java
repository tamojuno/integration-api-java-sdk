package br.com.juno.integration.api.model;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class QRCodeCancel extends BaseModel {

    private static final long serialVersionUID = 3674234333369079747L;

    private Boolean success;
    private String cancellationId;

    protected QRCodeCancel() {
        // NTD
    }

    public boolean getSuccess() {
        return success;
    }

    public String getCancellationId() {
        return cancellationId;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public void setCancellationId(String cancellationId) {
        this.cancellationId = cancellationId;
    }

    @Override
    public String toString() {
        ToStringBuilder builder = new ToStringBuilder(this, ToStringStyle.JSON_STYLE);
        builder.append("success", getSuccess());
        builder.append("cancellationId", getCancellationId());
        return builder.toString();
    }
}