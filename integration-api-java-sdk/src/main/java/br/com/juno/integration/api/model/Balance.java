package br.com.juno.integration.api.model;

import java.math.BigDecimal;

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

}
