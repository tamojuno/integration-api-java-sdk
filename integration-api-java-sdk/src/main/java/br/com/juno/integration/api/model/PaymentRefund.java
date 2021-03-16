package br.com.juno.integration.api.model;

import java.math.BigDecimal;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class PaymentRefund extends BaseModel {

    private static final long serialVersionUID = 1539599625216489779L;

    private String releaseDate;
    private String paybackDate;

    private BigDecimal amount;
    private BigDecimal fee;

    private String status;
    private String chargeId;

    private String transactionId;

    protected PaymentRefund() {
        // NTD
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public String getPaybackDate() {
        return paybackDate;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public BigDecimal getFee() {
        return fee;
    }

    public String getStatus() {
        return status;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public void setPaybackDate(String paybackDate) {
        this.paybackDate = paybackDate;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public void setFee(BigDecimal fee) {
        this.fee = fee;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getChargeId() {
        return chargeId;
    }

    public void setChargeId(String chargeId) {
        this.chargeId = chargeId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    @Override
    public String toString() {
        ToStringBuilder builder = new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE);
        builder.append(getId());
        builder.append(chargeId);
        builder.append(releaseDate);
        builder.append(paybackDate);
        builder.append(amount);
        builder.append(fee);
        builder.append(status);
        builder.append(transactionId);
        return builder.toString();
    }

}
