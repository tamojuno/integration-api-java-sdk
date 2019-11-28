package br.com.juno.integration.api.model;

public class Document extends BaseModel {

    private static final long serialVersionUID = -8913714640641753259L;

    private String type;
    private String description;
    private String approvalStatus;
    private String rejectionReason;
    private String details;

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

}
