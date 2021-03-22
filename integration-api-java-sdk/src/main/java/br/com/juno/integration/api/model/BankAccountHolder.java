package br.com.juno.integration.api.model;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public final class BankAccountHolder extends BaseModel {

    private static final long serialVersionUID = -433960489721775059L;

    private String name;
    private String document;

    protected BankAccountHolder() {
        // NTD
    }

    public String getName() {
        return name;
    }

    public String getDocument() {
        return document;
    }

    protected void setName(String name) {
        this.name = name;
    }

    protected void setDocument(String document) {
        this.document = document;
    }

    @Override
    public String toString() {
        ToStringBuilder builder = new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE);
        builder.append(getName());
        builder.append(getDocument());
        return builder.toString();
    }

}