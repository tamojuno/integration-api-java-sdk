package br.com.juno.integration.api.model;

import java.math.BigDecimal;
import java.util.Calendar;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class Payment extends BaseModel {

    private static final long serialVersionUID = 1378601766705618751L;

    private Calendar date;
    private Calendar releaseDate;
    private BigDecimal amount;
    private BigDecimal fee;

    private String type;
    private String status;
    private String transactionId;
    private String creditCardId;

    protected Payment() {
        // NTD
    }

    public Calendar getDate() {
        return date;
    }

    public Calendar getReleaseDate() {
        return releaseDate;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public BigDecimal getFee() {
        return fee;
    }

    public String getType() {
        return type;
    }

    public String getStatus() {
        return status;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public String getCreditCardId() {
        return creditCardId;
    }

    @Override
    public String toString() {
        ToStringBuilder builder = new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE);
        builder.append(date);
        builder.append(releaseDate);
        builder.append(amount);
        builder.append(fee);
        builder.append(type);
        builder.append(status);
        builder.append(transactionId);
        builder.append(creditCardId);
        return builder.toString();
    }
}
