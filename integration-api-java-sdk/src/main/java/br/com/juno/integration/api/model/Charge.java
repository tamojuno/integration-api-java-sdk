package br.com.juno.integration.api.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class Charge extends BaseModel {

    private static final long serialVersionUID = -3918516666752671116L;

    private Long code;
    private String reference;
    private Calendar dueDate;
    private String link;
    private String checkoutUrl;
    private String installmentLink;
    private String payNumber;
    private BigDecimal amount;
    private BilletDetails billetDetails;
    private List<Payment> payments;

    public static class BilletDetails implements Serializable {

        private static final long serialVersionUID = -7529098091565545942L;

        private String bankAccount;
        private String ourNumber;
        private String barcodeNumber;
        private String portfolio;

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

    public Calendar getDueDate() {
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

    public BilletDetails getBilletDetails() {
        return billetDetails;
    }

    public List<Payment> getPayments() {
        return payments;
    }

    @Override
    public String toString() {
        ToStringBuilder builder = new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE);
        builder.append(code);
        builder.append(reference);
        builder.append(dueDate);
        builder.append(link);
        builder.append(checkoutUrl);
        builder.append(installmentLink);
        builder.append(payNumber);
        builder.append(amount);
        builder.append(billetDetails);
        builder.append(payments);
        return builder.toString();
    }
}
