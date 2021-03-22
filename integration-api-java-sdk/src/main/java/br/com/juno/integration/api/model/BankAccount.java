package br.com.juno.integration.api.model;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public final class BankAccount extends BaseModel {

    private static final long serialVersionUID = 1087792530478512362L;

    private String bankNumber;
    private String agencyNumber;
    private String accountNumber;
    private String accountComplementNumber;
    private BankAccountType accountType;

    public BankAccount() {
        // NTD
    }

    public BankAccount(String accountNumber) {
        this(null, null, accountNumber, null, null);
    }

    public BankAccount(String bankNumber, String agencyNumber, String accountNumber, String accountComplementNumber, BankAccountType accountType) {
        this.bankNumber = bankNumber;
        this.agencyNumber = agencyNumber;
        this.accountNumber = accountNumber;
        this.accountComplementNumber = accountComplementNumber;
        this.accountType = accountType;
    }

    public String getBankNumber() {
        return bankNumber;
    }

    public String getAgencyNumber() {
        return agencyNumber;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountComplementNumber() {
        return accountComplementNumber;
    }

    public BankAccountType getAccountType() {
        return accountType;
    }

    public void setBankNumber(String bankNumber) {
        this.bankNumber = bankNumber;
    }

    public void setAgencyNumber(String agencyNumber) {
        this.agencyNumber = agencyNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setAccountComplementNumber(String accountComplementNumber) {
        this.accountComplementNumber = accountComplementNumber;
    }

    public void setAccountType(BankAccountType accountType) {
        this.accountType = accountType;
    }

    @Override
    public String toString() {
        ToStringBuilder builder = new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE);

        builder.append(bankNumber);
        builder.append(agencyNumber);
        builder.append(accountNumber);
        builder.append(accountComplementNumber);
        builder.append(accountType);
        return builder.toString();
    }

}