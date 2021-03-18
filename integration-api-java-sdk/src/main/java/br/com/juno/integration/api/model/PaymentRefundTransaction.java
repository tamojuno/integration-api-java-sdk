package br.com.juno.integration.api.model;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class PaymentRefundTransaction extends BaseModel {

    private static final long serialVersionUID = 2744803271932442751L;

    protected String transactionId;
    protected int installments;

    private List<Payment> payments = new ArrayList<>();
    private List<PaymentRefund> refunds = new ArrayList<>();

    protected PaymentRefundTransaction() {
        // NTD
    }

    public List<PaymentRefund> getRefunds() {
        return refunds;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public int getInstallments() {
        return installments;
    }

    public List<Payment> getPayments() {
        return payments;
    }

    protected void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    protected void setInstallments(int installments) {
        this.installments = installments;
    }

    protected void setPayments(List<Payment> payments) {
        this.payments = payments;
    }

    protected void setRefunds(List<PaymentRefund> refunds) {
        this.refunds = refunds;
    }

    @Override
    public String toString() {
        ToStringBuilder builder = new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE);
        builder.append(transactionId);
        builder.append(installments);
        builder.append(payments);
        builder.append(refunds);
        return builder.toString();
    }
}
