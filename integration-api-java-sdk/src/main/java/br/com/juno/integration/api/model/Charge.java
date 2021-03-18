package br.com.juno.integration.api.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class Charge extends BaseModel {

    private static final long serialVersionUID = -3918516666752671116L;

    private Long code;
    private String reference;
    private String dueDate;
    private String link;
    private String checkoutUrl;
    private String installmentLink;
    private String payNumber;
    private BigDecimal amount;
    private String status;
    private BilletDetails billetDetails;
    private List<Payment> payments;
    private List<PixStaticQRCode> pix;

    protected Charge() {
        // NTD
    }

    public static class BilletDetails implements Serializable {

        private static final long serialVersionUID = -7529098091565545942L;

        private String bankAccount;
        private String ourNumber;
        private String barcodeNumber;
        private String portfolio;

        protected BilletDetails() {
            // NTD
        }

        protected BilletDetails(String bankAccount, String ourNumber, String barcodeNumber, String portfolio) {
            super();
            this.bankAccount = bankAccount;
            this.ourNumber = ourNumber;
            this.barcodeNumber = barcodeNumber;
            this.portfolio = portfolio;
        }

        public String getBankAccount() {
            return bankAccount;
        }

        public String getOurNumber() {
            return ourNumber;
        }

        public String getBarcodeNumber() {
            return barcodeNumber;
        }

        public String getPortfolio() {
            return portfolio;
        }

        protected void setBankAccount(String bankAccount) {
            this.bankAccount = bankAccount;
        }

        protected void setOurNumber(String ourNumber) {
            this.ourNumber = ourNumber;
        }

        protected void setBarcodeNumber(String barcodeNumber) {
            this.barcodeNumber = barcodeNumber;
        }

        protected void setPortfolio(String portfolio) {
            this.portfolio = portfolio;
        }

        @Override
        public String toString() {
            ToStringBuilder builder = new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE);
            builder.append(bankAccount);
            builder.append(ourNumber);
            builder.append(barcodeNumber);
            builder.append(portfolio);
            return builder.toString();
        }
    }

    public Long getCode() {
        return code;
    }

    public String getReference() {
        return reference;
    }

    public String getDueDate() {
        return dueDate;
    }

    public String getLink() {
        return link;
    }

    public String getCheckoutUrl() {
        return checkoutUrl;
    }

    public String getInstallmentLink() {
        return installmentLink;
    }

    public String getPayNumber() {
        return payNumber;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public String getStatus() {
        return status;
    }

    public BilletDetails getBilletDetails() {
        return billetDetails;
    }

    public List<Payment> getPayments() {
        return payments;
    }

    public List<PixStaticQRCode> getPix() {
        return pix;
    }

    protected void setCode(Long code) {
        this.code = code;
    }

    protected void setReference(String reference) {
        this.reference = reference;
    }

    protected void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    protected void setLink(String link) {
        this.link = link;
    }

    protected void setCheckoutUrl(String checkoutUrl) {
        this.checkoutUrl = checkoutUrl;
    }

    protected void setInstallmentLink(String installmentLink) {
        this.installmentLink = installmentLink;
    }

    protected void setPayNumber(String payNumber) {
        this.payNumber = payNumber;
    }

    protected void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    protected void setStatus(String status) {
        this.status = status;
    }

    protected void setBilletDetails(BilletDetails billetDetails) {
        this.billetDetails = billetDetails;
    }

    protected void setPayments(List<Payment> payments) {
        this.payments = payments;
    }

    protected void setPix(List<PixStaticQRCode> pix) {
        this.pix = pix;
    }

    @Override
    public String toString() {
        ToStringBuilder builder = new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE);
        builder.append(getId());
        builder.append(code);
        builder.append(reference);
        builder.append(dueDate);
        builder.append(link);
        builder.append(checkoutUrl);
        builder.append(installmentLink);
        builder.append(payNumber);
        builder.append(amount);
        builder.append(status);
        builder.append(billetDetails);
        builder.append(payments);
        builder.append(pix);
        return builder.toString();
    }
}
