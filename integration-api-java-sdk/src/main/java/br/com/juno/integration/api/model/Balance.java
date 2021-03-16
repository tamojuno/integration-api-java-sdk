package br.com.juno.integration.api.model;

import java.math.BigDecimal;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public final class Balance {

    private BigDecimal balance;
    private BigDecimal withheldBalance;
    private BigDecimal transferableBalance;

    protected Balance() {
        // NTD
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public BigDecimal getWithheldBalance() {
        return withheldBalance;
    }

    public BigDecimal getTransferableBalance() {
        return transferableBalance;
    }

    protected void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    protected void setWithheldBalance(BigDecimal withheldBalance) {
        this.withheldBalance = withheldBalance;
    }

    protected void setTransferableBalance(BigDecimal transferableBalance) {
        this.transferableBalance = transferableBalance;
    }

    @Override
    public String toString() {
        ToStringBuilder builder = new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE);
        builder.append(balance);
        builder.append(withheldBalance);
        builder.append(transferableBalance);
        return builder.toString();
    }
}
