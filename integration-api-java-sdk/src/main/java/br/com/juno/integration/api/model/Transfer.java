package br.com.juno.integration.api.model;

import java.math.BigDecimal;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class Transfer extends BaseModel {

    private static final long serialVersionUID = -2887521733291703660L;

    private String digitalAccountId;
    private String creationDate;
    private String transferDate;
    private BigDecimal amount;
    private String status;
    private Recipient recipient;

    protected Transfer() {
        // NTD
    }

    public String getDigitalAccountId() {
        return digitalAccountId;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public String getTransferDate() {
        return transferDate;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public String getStatus() {
        return status;
    }

    public Recipient getRecipient() {
        return recipient;
    }

    protected void setDigitalAccountId(String digitalAccountId) {
        this.digitalAccountId = digitalAccountId;
    }

    protected void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    protected void setTransferDate(String transferDate) {
        this.transferDate = transferDate;
    }

    protected void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    protected void setStatus(String status) {
        this.status = status;
    }

    protected void setRecipient(Recipient recipient) {
        this.recipient = recipient;
    }

    @Override
    public String toString() {
        ToStringBuilder builder = new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE);
        builder.append(getId());
        builder.append(getDigitalAccountId());
        builder.append(getCreationDate());
        builder.append(getTransferDate());
        builder.append(getAmount());
        builder.append(getStatus());
        builder.append(getRecipient());
        return builder.toString();
    }
}
