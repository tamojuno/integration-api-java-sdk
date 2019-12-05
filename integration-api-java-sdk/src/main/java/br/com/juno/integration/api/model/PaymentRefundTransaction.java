package br.com.juno.integration.api.model;

import java.util.ArrayList;
import java.util.List;

public class PaymentRefundTransaction extends AbstractPaymentTransaction {

    private static final long serialVersionUID = 3232693680524612838L;

    private final List<PaymentRefund> refunds = new ArrayList<>();

    protected PaymentRefundTransaction() {
        // NTD
    }

    public List<PaymentRefund> getRefunds() {
        return refunds;
    }
}
