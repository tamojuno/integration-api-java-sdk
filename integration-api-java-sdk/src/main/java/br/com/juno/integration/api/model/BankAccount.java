package br.com.juno.integration.api.model;

import org.apache.commons.lang3.BooleanUtils;
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
        this(null, null, accountNumber, null, null);
    }

    protected BankAccount(String bankNumber, String agencyNumber, String accountNumber, String accountComplementNumber, BankAccountType accountType) {
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

    public boolean isCaixa() {
        return !StringUtils.isBlank(accountComplementNumber);
    }

    public boolean isP2P() {
        return StringUtils.isAllBlank(bankNumber, agencyNumber, accountComplementNumber);
    }

    @Override
    public String toString() {
        ToStringBuilder builder = new ToStringBuilder(this, ToStringStyle.JSON_STYLE);

        if (BooleanUtils.isTrue(isP2P())) {
            builder.append("accountNumber", accountNumber);
        } else {
            builder.append("bankNumber", bankNumber);
            builder.append("agencyNumber", agencyNumber);
            builder.append("accountNumber", accountNumber);

            if (BooleanUtils.isTrue(isCaixa())) {
                builder.append("accountComplementNumber", accountComplementNumber);
            }

            builder.append("accountType", accountType);
        }
        return builder.toString();
    }

}