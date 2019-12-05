package br.com.juno.integration.api.model;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class PaymentRefundTransaction extends AbstractPaymentTransaction {

    private static final long serialVersionUID = 3232693680524612838L;

    private final List<PaymentRefund> refunds = new ArrayList<>();

    protected PaymentRefundTransaction() {
        // NTD
    }

    public List<PaymentRefund> getRefunds() {
        return refunds;
    }

    @Override
    public String toString() {
        ToStringBuilder builder = new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE);
        builder.append(transactionId);
        builder.append(installments);
        builder.append(refunds);
        return builder.toString();
    }
}
