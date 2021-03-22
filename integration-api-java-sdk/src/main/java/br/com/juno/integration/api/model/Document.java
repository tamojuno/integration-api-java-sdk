package br.com.juno.integration.api.model;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class Document extends BaseModel {

    private static final long serialVersionUID = -8913714640641753259L;

    private String type;
    private String description;
    private String approvalStatus;
    private String rejectionReason;
    private String details;

    protected Document() {
        // NTD
    }

    public String getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }

    public String getApprovalStatus() {
        return approvalStatus;
    }

    public String getRejectionReason() {
        return rejectionReason;
    }

    public String getDetails() {
        return details;
    }

    protected void setType(String type) {
        this.type = type;
    }

    protected void setDescription(String description) {
        this.description = description;
    }

    protected void setApprovalStatus(String approvalStatus) {
        this.approvalStatus = approvalStatus;
    }

    protected void setRejectionReason(String rejectionReason) {
        this.rejectionReason = rejectionReason;
    }

    protected void setDetails(String details) {
        this.details = details;
    }

    @Override
    public String toString() {
        ToStringBuilder builder = new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE);
        builder.append(getId());
        builder.append(type);
        builder.append(description);
        builder.append(approvalStatus);
        builder.append(rejectionReason);
        builder.append(details);
        return builder.toString();
    }
}
