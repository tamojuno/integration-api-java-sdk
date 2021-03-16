package br.com.juno.integration.api.model;

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
    private String accountNumber;

    protected DigitalAccount() {
        // NTD
    }

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

    public String getAccountNumber() {
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

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    @Override
    public String toString() {
        ToStringBuilder builder = new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE);
        builder.append(getId());
        builder.append(getType());
        builder.append(getStatus());
        builder.append(getPersonType());
        builder.append(getDocument());
        builder.append(getCreatedOn());
        builder.append(getResourceToken());
        builder.append(getAccountNumber());
        return builder.toString();
    }
}
