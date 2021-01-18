package br.com.juno.integration.api.model;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public final class BankAccount extends BaseModel {

    private static final long serialVersionUID = 1087792530478512362L;

    private String bankNumber;
    private String agencyNumber;
    private String accountNumber;
    private String accountComplementNumber;
    private BankAccountType accountType;

    protected BankAccount() {
        // NTD
    }
    
    protected BankAccount(String accountNumber) {
    	this.accountNumber = accountNumber;
    }

    protected BankAccount(String bankNumber, String agencyNumber, String accountNumber, String accountComplementNumber, BankAccountType accountType) {
        this.bankNumber = bankNumber;
        this.agencyNumber = agencyNumber;
        this.accountNumber = accountNumber;
        if (StringUtils.isNotBlank(accountComplementNumber)) {
        	this.accountComplementNumber = accountComplementNumber;
        }
        this.accountType = accountType;
    
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
    
    @Override
    public String toString() {
        ToStringBuilder builder = new ToStringBuilder(this, ToStringStyle.JSON_STYLE);
        builder.append("bankNumber", bankNumber);
        builder.append("agencyNumber", agencyNumber);
        builder.append("accountNumber", accountNumber);
        builder.append("accountComplementNumber", accountComplementNumber);
        builder.append("accountType", accountType);
        return builder.toString();
    }

}