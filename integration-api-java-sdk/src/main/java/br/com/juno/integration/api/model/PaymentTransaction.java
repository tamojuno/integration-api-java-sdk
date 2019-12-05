package br.com.juno.integration.api.model;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class PaymentTransaction extends BaseModel {

    private static final long serialVersionUID = 2744803271932442751L;

    protected String transactionId;
    protected int installments;

    private final List<Payment> payments = new ArrayList<>();

    protected PaymentTransaction() {
        // NTD
    }

    public List<Payment> getPayments() {
        return payments;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public int getInstallments() {
        return installments;
    }

    @Override
    public String toString() {
        ToStringBuilder builder = new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE);
        builder.append(transactionId);
        builder.append(installments);
        builder.append(payments);
        return builder.toString();
    }

}
