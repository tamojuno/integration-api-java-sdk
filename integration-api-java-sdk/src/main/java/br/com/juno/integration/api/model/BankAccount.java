package br.com.juno.integration.api.model;

public final class BankAccount extends BaseModel {

    private static final long serialVersionUID = 1087792530478512362L;

    private String bankNumber;
    private String agencyNumber;
    private String accountNumber;
    private String accountComplementNumber;
    private BankAccountType accountType;
    private BankAccountHolder accountHolder;

    protected BankAccount() {
        // NTD
    }

    protected BankAccount(String bankNumber, String agencyNumber, String accountNumber, String accountComplementNumber, BankAccountType accountType,
            BankAccountHolder accountHolder) {
        this.bankNumber = bankNumber;
        this.agencyNumber = agencyNumber;
        this.accountNumber = accountNumber;
        this.accountComplementNumber = accountComplementNumber;
        this.accountType = accountType;
        this.accountHolder = accountHolder;
    }

    public String getBankNumber() {
        return bankNumber;
    }

    public void setBankNumber(String bankNumber) {
        this.bankNumber = bankNumber;
    }

    public String getAgencyNumber() {
        return agencyNumber;
    }

    public void setAgencyNumber(String agencyNumber) {
        this.agencyNumber = agencyNumber;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountComplementNumber() {
        return accountComplementNumber;
    }

    public void setAccountComplementNumber(String accountComplementNumber) {
        this.accountComplementNumber = accountComplementNumber;
    }

    public BankAccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(BankAccountType accountType) {
        this.accountType = accountType;
    }

    public BankAccountHolder getAccountHolder() {
        return accountHolder;
    }

    public void setAccountHolder(BankAccountHolder accountHolder) {
        this.accountHolder = accountHolder;
    }
}