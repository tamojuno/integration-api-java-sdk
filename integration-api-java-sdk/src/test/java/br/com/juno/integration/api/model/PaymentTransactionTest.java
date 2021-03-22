package br.com.juno.integration.api.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;

import org.junit.jupiter.api.Test;
import org.springframework.hateoas.Resource;

import br.com.juno.integration.api.services.response.Response;
import br.com.juno.test.AbstractTest;

public class PaymentTransactionTest extends AbstractTest {

    private static final String TRANSACTION_ID = "30749a58830c7c";
    private static final int INSTALLMENTS = 1;
    private static final List<Payment> PAYMENTS = new ArrayList<>();
    private static final List<PaymentRefund> REFUNDS = new ArrayList<>();

    @Test
    public void constructors() {
        PaymentRefundTransaction paymentRefundTransaction = new PaymentRefundTransaction();
        assertNull(paymentRefundTransaction.getTransactionId());

        paymentRefundTransaction = new PaymentRefundTransaction();
        paymentRefundTransaction.setTransactionId(TRANSACTION_ID);
        paymentRefundTransaction.setInstallments(INSTALLMENTS);
        paymentRefundTransaction.setPayments(PAYMENTS);
        paymentRefundTransaction.setRefunds(REFUNDS);

        assertEquals(TRANSACTION_ID, paymentRefundTransaction.getTransactionId());
        assertEquals(INSTALLMENTS, paymentRefundTransaction.getInstallments());
        assertEquals(PAYMENTS, paymentRefundTransaction.getPayments());
        assertEquals(REFUNDS, paymentRefundTransaction.getRefunds());

    }

    @Test
    public void toStringComplete() {
        PaymentRefundTransaction paymentRefundTransaction = new PaymentRefundTransaction();
        paymentRefundTransaction.setTransactionId(TRANSACTION_ID);
        paymentRefundTransaction.setInstallments(INSTALLMENTS);
        paymentRefundTransaction.setPayments(PAYMENTS);
        paymentRefundTransaction.setRefunds(REFUNDS);
        assertEquals("PaymentRefundTransaction[30749a58830c7c,1,[],[]]", paymentRefundTransaction.toString());
    }

    @Test
    public void toStringEmpty() {
        PaymentRefundTransaction paymentRefundTransaction = new PaymentRefundTransaction();
        assertEquals("PaymentRefundTransaction[<null>,0,[],[]]", paymentRefundTransaction.toString());
    }

    //TODO: create equality test

    @Test
    public void jsonToObject() throws Exception {
        Response<PaymentRefundTransaction> res = new Response<>(
                getObjectMapper().readValue(findOne(), new TypeReference<Resource<PaymentRefundTransaction>>() {
                    // NTD
                }));

        assertEquals(null, res.getHrefSelf());

        PaymentRefundTransaction paymentRefundTransaction = res.getContent();

        assertEquals(TRANSACTION_ID, paymentRefundTransaction.getTransactionId());
        assertEquals(INSTALLMENTS, paymentRefundTransaction.getInstallments());
        assertEquals(PAYMENTS, paymentRefundTransaction.getPayments());
        assertEquals(REFUNDS, paymentRefundTransaction.getRefunds());

    }

    private String findOne() {
        return "{\"transactionId\":\"30749a58830c7c\",\"installments\":1,\"payments\":[],\"refunds\":[]}";
    }
}
