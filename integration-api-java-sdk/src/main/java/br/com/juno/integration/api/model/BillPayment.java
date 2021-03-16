package br.com.juno.integration.api.model;

import java.math.BigDecimal;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class BillPayment extends BaseModel {

    private static final long serialVersionUID = -8913714640641753259L;

    private String beneficiaryDocument;
    private BigDecimal billAmount;
    private String billType;

    private String createdOn;

    private String dueDate;
    private String paymentDate;

    private String numericalBarCode;
    private BigDecimal paidAmount;
    private String digitalAccountId;
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

    public String getCreatedOn() {
        return createdOn;
    }

    public String getDueDate() {
        return dueDate;
    }

    public String getNumericalBarCode() {
        return numericalBarCode;
    }

    public BigDecimal getPaidAmount() {
        return paidAmount;
    }

    public String getDigitalAccountId() {
        return digitalAccountId;
    }

    public String getPaymentDate() {
        return paymentDate;
    }

    public String getPaymentDescription() {
        return paymentDescription;
    }

    public String getStatus() {
        return status;
    }

    public void setBeneficiaryDocument(String beneficiaryDocument) {
        this.beneficiaryDocument = beneficiaryDocument;
    }

    public void setBillAmount(BigDecimal billAmount) {
        this.billAmount = billAmount;
    }

    public void setBillType(String billType) {
        this.billType = billType;
    }

    public void setCreatedOn(String createdOn) {
        this.createdOn = createdOn;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public void setNumericalBarCode(String numericalBarCode) {
        this.numericalBarCode = numericalBarCode;
    }

    public void setPaidAmount(BigDecimal paidAmount) {
        this.paidAmount = paidAmount;
    }

    public void setDigitalAccountId(String digitalAccountId) {
        this.digitalAccountId = digitalAccountId;
    }

    public void setPaymentDate(String paymentDate) {
        this.paymentDate = paymentDate;
    }

    public void setPaymentDescription(String paymentDescription) {
        this.paymentDescription = paymentDescription;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        ToStringBuilder builder = new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE);
        builder.append(getId());
        builder.append(numericalBarCode);
        builder.append(billAmount);
        builder.append(dueDate);
        builder.append(billType);
        builder.append(digitalAccountId);
        builder.append(paidAmount);
        builder.append(paymentDate);
        builder.append(paymentDescription);
        builder.append(beneficiaryDocument);
        builder.append(status);
        builder.append(createdOn);
        return builder.toString();
    }
}
