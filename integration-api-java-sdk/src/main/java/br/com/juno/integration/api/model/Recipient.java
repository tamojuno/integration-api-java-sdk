package br.com.juno.integration.api.model;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public final class Recipient extends BaseModel {

    private static final long serialVersionUID = 2713548342303665977L;

    private String name;
    private String document;
    private BankAccount bankAccount;

    protected Recipient() {
        // NTD
    }

    public String getName() {
        return name;
    }

    public String getDocument() {
        return document;
    }

    public BankAccount getBankAccount() {
        return bankAccount;
    }

    protected void setName(String name) {
        this.name = name;
    }

    protected void setDocument(String document) {
        this.document = document;
    }

    protected void setBankAccount(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    @Override
    public String toString() {
        ToStringBuilder builder = new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE);
        builder.append(getName());
        builder.append(getDocument());
        builder.append(getBankAccount());
        return builder.toString();
    }
}
