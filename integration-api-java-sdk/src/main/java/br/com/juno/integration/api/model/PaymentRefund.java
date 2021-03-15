package br.com.juno.integration.api.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import br.com.juno.integration.api.utils.CalendarUtils;

public class PaymentRefund extends BaseModel {

    private static final long serialVersionUID = 1539599625216489779L;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = CalendarUtils.API_DATE_FORMAT)
    private LocalDate releaseDate;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = CalendarUtils.API_DATE_FORMAT)
    private LocalDate paybackDate;

    private BigDecimal amount;
    private BigDecimal fee;

    private String status;
    private String chargeId;

    private String transactionId;

    protected PaymentRefund() {
        // NTD
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public LocalDate getPaybackDate() {
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

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public void setPaybackDate(LocalDate paybackDate) {
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
        ToStringBuilder builder = new ToStringBuilder(this, ToStringStyle.JSON_STYLE);
        builder.append("id", getId());
        builder.append("chargeId", chargeId);
        builder.append("releaseDate", releaseDate);
        builder.append("paybackDate", paybackDate);
        builder.append("amount", amount);
        builder.append("fee", fee);
        builder.append("status", status);
        builder.append("transactionId", transactionId);
        return builder.toString();
    }

}
