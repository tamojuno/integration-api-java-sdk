package br.com.juno.integration.api.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.math.BigDecimal;

import com.fasterxml.jackson.core.type.TypeReference;

import org.junit.jupiter.api.Test;
import org.springframework.hateoas.Resource;

import br.com.juno.integration.api.services.response.Response;
import br.com.juno.test.AbstractTest;

public class PaymentTest extends AbstractTest {

    private static final String PAYMENT_ID = "pay_FF2EFFF1226D7EAC71DFE00B27A2424A";
    private static final String CHARGE_ID = "chr_962B27718883F7818BA12F1EA7FE6A80";
    private static final String PAYMENT_DATE = "2021-03-12";
    private static final String RELEASE_DATE = "2021-04-12";
    private static final BigDecimal AMOUNT = BigDecimal.valueOf(50.00D);
    private static final BigDecimal FEE = BigDecimal.valueOf(2.15D);
    private static final String PAYMENT_TYPE = "INSTALLMENT_CREDIT_CARD";
    private static final String PAYMENT_STATUS = "AUTHORIZED";
    private static final String TRANSACTION_ID = "30745db7d4869f";

    @Test
    public void constructors() {
        Payment payment = new Payment();
        assertNull(payment.getId());
        assertNull(payment.getChargeId());
        assertNull(payment.getDate());
        assertNull(payment.getReleaseDate());
        assertNull(payment.getAmount());
        assertNull(payment.getFee());
        assertNull(payment.getType());
        assertNull(payment.getStatus());
        assertNull(payment.getTransactionId());
        assertNull(payment.getFailReason());

        payment = new Payment();
        payment.setId(PAYMENT_ID);
        payment.setChargeId(CHARGE_ID);
        payment.setDate(PAYMENT_DATE);
        payment.setReleaseDate(RELEASE_DATE);
        payment.setAmount(AMOUNT);
        payment.setFee(FEE);
        payment.setType(PAYMENT_TYPE);
        payment.setStatus(PAYMENT_STATUS);
        payment.setTransactionId(TRANSACTION_ID);
        payment.setFailReason(null);

        assertEquals(PAYMENT_ID, payment.getId());
        assertEquals(CHARGE_ID, payment.getChargeId());
        assertEquals(PAYMENT_DATE, payment.getDate());
        assertEquals(RELEASE_DATE, payment.getReleaseDate());
        assertEquals(AMOUNT, payment.getAmount());
        assertEquals(FEE, payment.getFee());
        assertEquals(PAYMENT_TYPE, payment.getType());
        assertEquals(PAYMENT_STATUS, payment.getStatus());
        assertEquals(TRANSACTION_ID, payment.getTransactionId());
        assertEquals(null, payment.getFailReason());
    }

    @Test
    public void toStringComplete() {
        Payment payment = new Payment();
        payment.setId(PAYMENT_ID);
        payment.setChargeId(CHARGE_ID);
        payment.setDate(PAYMENT_DATE);
        payment.setReleaseDate(RELEASE_DATE);
        payment.setAmount(AMOUNT);
        payment.setFee(FEE);
        payment.setType(PAYMENT_TYPE);
        payment.setStatus(PAYMENT_STATUS);
        payment.setTransactionId(TRANSACTION_ID);
        payment.setFailReason(null);
        assertEquals(
                "Payment[pay_FF2EFFF1226D7EAC71DFE00B27A2424A,chr_962B27718883F7818BA12F1EA7FE6A80,2021-03-12,2021-04-12,50.0,2.15,INSTALLMENT_CREDIT_CARD,AUTHORIZED,30745db7d4869f,<null>]",
                payment.toString());
    }

    @Test
    public void toStringEmpty() {
        Payment payment = new Payment();
        assertEquals("Payment[<null>,<null>,<null>,<null>,<null>,<null>,<null>,<null>,<null>,<null>]", payment.toString());
    }

    @Test
    public void jsonToObject() throws Exception {
        Response<Payment> res = new Response<>(getObjectMapper().readValue(findOne(), new TypeReference<Resource<Payment>>() {
            // NTD
        }));

        assertEquals(null, res.getHrefSelf());

        Payment payment = res.getContent();

        assertEquals(CHARGE_ID, payment.getChargeId());
        assertEquals(PAYMENT_DATE, payment.getDate());
        assertEquals(RELEASE_DATE, payment.getReleaseDate());
        assertEquals(AMOUNT, payment.getAmount());
        assertEquals(FEE, payment.getFee());
        assertEquals(PAYMENT_TYPE, payment.getType());
        assertEquals(PAYMENT_STATUS, payment.getStatus());
        assertEquals(TRANSACTION_ID, payment.getTransactionId());
        assertEquals(null, payment.getFailReason());

    }

    public String findOne() {
        return "{\"id\":\"pay_FF2EFFF1226D7EAC71DFE00B27A2424A\",\"chargeId\":\"chr_962B27718883F7818BA12F1EA7FE6A80\",\"date\":\"2021-03-12\",\"releaseDate\":\"2021-04-12\",\"amount\":50.0,\"fee\":2.15,\"type\":\"INSTALLMENT_CREDIT_CARD\",\"status\":\"AUTHORIZED\",\"transactionId\":\"30745db7d4869f\",\"failReason\":null}";
    }
}
