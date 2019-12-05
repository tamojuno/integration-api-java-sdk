package br.com.juno.integration.api.model;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class PaymentTransaction extends AbstractPaymentTransaction {

    private static final long serialVersionUID = 12054073510463252L;

    private final List<Payment> payments = new ArrayList<>();

    protected PaymentTransaction() {
        // NTD
    }

    public List<Payment> getPayments() {
        return payments;
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
