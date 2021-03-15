package br.com.juno.integration.api.model;

import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public final class DigitalAccount extends BaseModel {

    private static final long serialVersionUID = 6272846700161236665L;

    private String resourceToken;
    private String type;
    private String status;
    private char personType;
    private String document;
    private String createdOn;
    private Long accountNumber;

    public String getResourceToken() {
        return resourceToken;
    }

    public String getType() {
        return type;
    }

    public String getStatus() {
        return status;
    }

    public char getPersonType() {
        return personType;
    }

    public String getDocument() {
        return document;
    }

    public String getCreatedOn() {
        return createdOn;
    }

    public Long getAccountNumber() {
        return accountNumber;
    }

    public void setResourceToken(String resourceToken) {
        this.resourceToken = resourceToken;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setPersonType(char personType) {
        this.personType = personType;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public void setCreatedOn(String createdOn) {
        this.createdOn = createdOn;
    }

    public void setAccountNumber(Long accountNumber) {
        this.accountNumber = accountNumber;
    }

    protected DigitalAccount() {
        // NTD
    }

    public boolean isCreateDigitalAccount() {
        return !StringUtils.isEmpty(resourceToken);
    }

    @Override
    public String toString() {
        ToStringBuilder builder = new ToStringBuilder(this, ToStringStyle.JSON_STYLE);

        builder.append("id", getId());
        builder.append("type", getType());
        builder.append("status", getStatus());
        builder.append("personType", getPersonType());
        builder.append("document", getDocument());
        builder.append("createdOn", getCreatedOn());
        if (BooleanUtils.isTrue(isCreateDigitalAccount())) {
            builder.append("resourceToken", resourceToken);
        }
        builder.append("accountNumber", getAccountNumber());
        return builder.toString();
    }
}
