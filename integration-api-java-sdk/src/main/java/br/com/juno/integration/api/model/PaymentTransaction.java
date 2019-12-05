package br.com.juno.integration.api.model;

import java.util.ArrayList;
import java.util.List;

public class PaymentTransaction extends AbstractPaymentTransaction {

    private static final long serialVersionUID = 12054073510463252L;

    private final List<Payment> payments = new ArrayList<>();

    protected PaymentTransaction() {
        // NTD
    }

    public List<Payment> getPayments() {
        return payments;
    }

}
