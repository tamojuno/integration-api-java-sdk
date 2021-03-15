package br.com.juno.integration.api.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import br.com.juno.integration.api.utils.CalendarUtils;

public class Payment extends BaseModel {

    private static final long serialVersionUID = 1378601766705618751L;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = CalendarUtils.API_DATE_FORMAT)
    private LocalDate date;
    private LocalDate releaseDate;

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

    public LocalDate getDate() {
        return date;
    }

    public LocalDate getReleaseDate() {
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

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setReleaseDate(LocalDate releaseDate) {
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
        ToStringBuilder builder = new ToStringBuilder(this, ToStringStyle.JSON_STYLE);
        builder.append("id", getId());
        builder.append("chargeId", chargeId);
        builder.append("date", date);
        builder.append("releaseDate", releaseDate);
        builder.append("amount", amount);
        builder.append("fee", fee);
        builder.append("type", type);
        builder.append("status", status);
        builder.append("transactionId", transactionId);
        builder.append("failReason", failReason);
        return builder.toString();
    }

    public String getChargeId() {
        return chargeId;
    }

}
