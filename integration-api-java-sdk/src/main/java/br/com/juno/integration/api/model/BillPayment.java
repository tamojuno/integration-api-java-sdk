package br.com.juno.integration.api.model;

import java.math.BigDecimal;
import java.util.Calendar;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class BillPayment extends BaseModel {

    private static final long serialVersionUID = -8913714640641753259L;

    private String beneficiaryDocument;
    private BigDecimal billAmount;
    private String billType;
    private Calendar createdOn;
    private Calendar dueDate;
    private String numericalBarCode;
    private BigDecimal paidAmount;
    private Long payeeId;
    private Calendar paymentDate;
    private String paymentDescription;
    private String status;

    protected BillPayment() {
        // NTD
    }

    public String getBeneficiaryDocument() {
        return beneficiaryDocument;
    }

    public BigDecimal getBillAmount() {
        return billAmount;
    }

    public String getBillType() {
        return billType;
    }

    public Calendar getCreatedOn() {
        return createdOn;
    }

    public Calendar getDueDate() {
        return dueDate;
    }

    public String getNumericalBarCode() {
        return numericalBarCode;
    }

    public BigDecimal getPaidAmount() {
        return paidAmount;
    }

    public Long getPayeeId() {
        return payeeId;
    }

    public Calendar getPaymentDate() {
        return paymentDate;
    }

    public String getPaymentDescription() {
        return paymentDescription;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        ToStringBuilder builder = new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE);
        builder.append(getId());
        builder.append(beneficiaryDocument);
        builder.append(billAmount);
        builder.append(billType);
        builder.append(createdOn);
        builder.append(dueDate);
        builder.append(numericalBarCode);
        builder.append(paidAmount);
        builder.append(payeeId);
        builder.append(paymentDate);
        builder.append(paymentDescription);
        builder.append(status);
        return builder.toString();
    }
}
