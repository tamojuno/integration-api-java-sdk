package br.com.juno.integration.api.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import br.com.juno.test.AbstractTest;

public class PaymentRefundTest extends AbstractTest {

    @Test
    public void constructors() {
        // NTD
        assertEquals(findOneComplete(), findCompleteObject());
    }

    @Test
    public void toStringEmpty() {
        // NTD
        assertEquals(findOneNull(), findIncompleteObject());
    }

    @Test
    public void toStringComplete() {
        // NTD
        assertEquals(findOneComplete(), findCompleteObject());
    }

    @Test
    public void equality() {
        // NTD
    }

    public String findOneComplete() {
        // NTD
        return "{\"id\":\"pay_F7D91CFFB91772D418C6EFE50A13189D\",\"chargeId\":\"chr_D43B9080A155F46093479FF952C17187\",\"releaseDate\":\"2021-04-16\",\"paybackDate\":\"2021-03-15\",\"amount\":50.0,\"fee\":0.0,\"status\":\"CUSTOMER_PAID_BACK\",\"transactionId\":\"30749a58830c7c\"}";
    }

    public String findOneNull() {
        // NTD
        return "{\"id\":null,\"chargeId\":null,\"releaseDate\":null,\"paybackDate\":null,\"amount\":null,\"fee\":null,\"status\":null,\"transactionId\":null}";
    }

    public String findCompleteObject() {
        PaymentRefund paymentRefund = new PaymentRefund();
        paymentRefund.setId("pay_F7D91CFFB91772D418C6EFE50A13189D");
        paymentRefund.setChargeId("chr_D43B9080A155F46093479FF952C17187");
        paymentRefund.setReleaseDate(LocalDate.of(2021, 04, 16));
        paymentRefund.setPaybackDate(LocalDate.of(2021, 03, 15));
        paymentRefund.setAmount(BigDecimal.valueOf(50.00D));
        paymentRefund.setFee(BigDecimal.valueOf(0.00D));
        paymentRefund.setStatus("CUSTOMER_PAID_BACK");
        paymentRefund.setTransactionId("30749a58830c7c");
        return paymentRefund.toString();

    }

    public String findIncompleteObject() {
        PaymentRefund paymentRefund = new PaymentRefund();
        paymentRefund.getId();
        paymentRefund.getChargeId();
        paymentRefund.getReleaseDate();
        paymentRefund.getPaybackDate();
        paymentRefund.getAmount();
        paymentRefund.getStatus();
        paymentRefund.getTransactionId();
        return paymentRefund.toString();
    }
}
