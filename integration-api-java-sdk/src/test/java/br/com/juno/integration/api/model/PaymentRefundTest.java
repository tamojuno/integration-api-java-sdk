package br.com.juno.integration.api.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.math.BigDecimal;

import com.fasterxml.jackson.core.type.TypeReference;

import org.junit.jupiter.api.Test;
import org.springframework.hateoas.Resource;

import br.com.juno.integration.api.services.response.Response;
import br.com.juno.test.AbstractTest;

public class PaymentRefundTest extends AbstractTest {

    private static final String PAYMENT_ID = "pay_F7D91CFFB91772D418C6EFE50A13189D";
    private static final String CHARGE_ID = "chr_D43B9080A155F46093479FF952C17187";
    private static final String RELEASE_DATE = "2021-04-16";
    private static final String PAYBACK_DATE = "2021-03-15";
    private static final BigDecimal AMOUNT = BigDecimal.valueOf(50.00D);
    private static final BigDecimal FEE = BigDecimal.valueOf(0.00D);
    private static final String STATUS = "CUSTOMER_PAID_BACK";
    private static final String TRANSACTION_ID = "30749a58830c7c";

    @Test
    public void constructors() {
        PaymentRefund paymentRefund = new PaymentRefund();
        assertNull(paymentRefund.getId());
        assertNull(paymentRefund.getChargeId());
        assertNull(paymentRefund.getReleaseDate());
        assertNull(paymentRefund.getPaybackDate());
        assertNull(paymentRefund.getAmount());
        assertNull(paymentRefund.getStatus());
        assertNull(paymentRefund.getTransactionId());

        paymentRefund = new PaymentRefund();
        paymentRefund.setId(PAYMENT_ID);
        paymentRefund.setChargeId(CHARGE_ID);
        paymentRefund.setReleaseDate(RELEASE_DATE);
        paymentRefund.setPaybackDate(PAYBACK_DATE);
        paymentRefund.setAmount(AMOUNT);
        paymentRefund.setFee(FEE);
        paymentRefund.setStatus(STATUS);
        paymentRefund.setTransactionId(TRANSACTION_ID);

        assertEquals(PAYMENT_ID, paymentRefund.getId());
        assertEquals(CHARGE_ID, paymentRefund.getChargeId());
        assertEquals(RELEASE_DATE, paymentRefund.getReleaseDate());
        assertEquals(PAYBACK_DATE, paymentRefund.getPaybackDate());
        assertEquals(AMOUNT, paymentRefund.getAmount());
        assertEquals(FEE, paymentRefund.getFee());
        assertEquals(STATUS, paymentRefund.getStatus());
        assertEquals(TRANSACTION_ID, paymentRefund.getTransactionId());

    }

    @Test
    public void toStringComplete() {
        PaymentRefund paymentRefund = new PaymentRefund();
        paymentRefund.setId(PAYMENT_ID);
        paymentRefund.setChargeId(CHARGE_ID);
        paymentRefund.setReleaseDate(RELEASE_DATE);
        paymentRefund.setPaybackDate(PAYBACK_DATE);
        paymentRefund.setAmount(AMOUNT);
        paymentRefund.setFee(FEE);
        paymentRefund.setStatus(STATUS);
        paymentRefund.setTransactionId(TRANSACTION_ID);
        assertEquals(
                "PaymentRefund[pay_F7D91CFFB91772D418C6EFE50A13189D,chr_D43B9080A155F46093479FF952C17187,2021-04-16,2021-03-15,50.0,0.0,CUSTOMER_PAID_BACK,30749a58830c7c]",
                paymentRefund.toString());
    }

    @Test
    public void toStringEmpty() {
        PaymentRefund paymentRefund = new PaymentRefund();
        assertEquals("PaymentRefund[<null>,<null>,<null>,<null>,<null>,<null>,<null>,<null>]", paymentRefund.toString());
    }

    //TODO: create equality test

    @Test
    public void jsonToObject() throws Exception {
        Response<PaymentRefund> res = new Response<>(getObjectMapper().readValue(findOne(), new TypeReference<Resource<PaymentRefund>>() {
            // NTD
        }));

        assertEquals(null, res.getHrefSelf());

        PaymentRefund paymentRefund = res.getContent();

        assertEquals(CHARGE_ID, paymentRefund.getChargeId());
        assertEquals(RELEASE_DATE, paymentRefund.getReleaseDate());
        assertEquals(PAYBACK_DATE, paymentRefund.getPaybackDate());
        assertEquals(AMOUNT, paymentRefund.getAmount());
        assertEquals(FEE, paymentRefund.getFee());
        assertEquals(STATUS, paymentRefund.getStatus());
        assertEquals(TRANSACTION_ID, paymentRefund.getTransactionId());

    }

    private String findOne() {
        return "{\"id\":\"pay_F7D91CFFB91772D418C6EFE50A13189D\",\"chargeId\":\"chr_D43B9080A155F46093479FF952C17187\",\"releaseDate\":\"2021-04-16\",\"paybackDate\":\"2021-03-15\",\"amount\":50.0,\"fee\":0.0,\"status\":\"CUSTOMER_PAID_BACK\",\"transactionId\":\"30749a58830c7c\"}";
    }
}
