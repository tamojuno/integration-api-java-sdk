package br.com.juno.integration.api.model;

import java.math.BigDecimal;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class Payment extends BaseModel {

    private static final long serialVersionUID = 1378601766705618751L;

    private String date;
    private String releaseDate;

    private BigDecimal amount;
    private BigDecimal fee;

    private String type;
    private String status;
    private String transactionId;
    private String chargeId;
    private String failReason;

    protected Payment() {
        // NTD
    }

    public String getDate() {
        return date;
    }

    public String getReleaseDate() {
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

    public String getFailReason() {
        return failReason;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public void setFee(BigDecimal fee) {
        this.fee = fee;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public void setChargeId(String chargeId) {
        this.chargeId = chargeId;
    }

    public void setFailReason(String failReason) {
        this.failReason = failReason;
    }

    @Override
    public String toString() {
        ToStringBuilder builder = new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE);
        builder.append(getId());
        builder.append(chargeId);
        builder.append(date);
        builder.append(releaseDate);
        builder.append(amount);
        builder.append(fee);
        builder.append(type);
        builder.append(status);
        builder.append(transactionId);
        builder.append(failReason);
        return builder.toString();
    }

    public String getChargeId() {
        return chargeId;
    }
}
