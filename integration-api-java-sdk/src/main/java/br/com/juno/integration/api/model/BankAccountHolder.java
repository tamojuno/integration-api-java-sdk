package br.com.juno.integration.api.model;

public final class BankAccountHolder extends BaseModel {

    private static final long serialVersionUID = -433960489721775059L;

    private String name;
    private String document;

    public BankAccountHolder() {
        // NTD
    }

    public BankAccountHolder(String name, String document) {
        this.name = name;
        this.document = document;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }
}