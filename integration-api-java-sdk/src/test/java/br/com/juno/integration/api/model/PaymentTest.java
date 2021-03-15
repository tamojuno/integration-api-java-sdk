package br.com.juno.integration.api.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import br.com.juno.test.AbstractTest;

public class PaymentTest extends AbstractTest {

    @Test
    public void constructors() {
        //        assertEquals(findOneNull(), findIncompleteObject());
        assertEquals(findOneComplete(), findCompleteObject());
    }

    @Test
    public void toStringEmpty() {
        assertEquals(findOneNull(), findIncompleteObject());
    }

    @Test
    public void toStringFull() {
        assertEquals(findOneComplete(), findCompleteObject());
    }

    public String findOneNull() {
        return "{\"id\":null,\"chargeId\":null,\"date\":null,\"releaseDate\":null,\"amount\":null,\"fee\":null,\"type\":null,\"status\":null,\"transactionId\":null,\"failReason\":null}";
    }

    public String findOneComplete() {
        return "{\"id\":\"pay_FF2EFFF1226D7EAC71DFE00B27A2424A\",\"chargeId\":\"chr_962B27718883F7818BA12F1EA7FE6A80\",\"date\":\"2021-03-12\",\"releaseDate\":\"2021-04-12\",\"amount\":50.0,\"fee\":2.15,\"type\":\"INSTALLMENT_CREDIT_CARD\",\"status\":\"AUTHORIZED\",\"transactionId\":\"30745db7d4869f\",\"failReason\":null}";
    }

    public String findCompleteObject() {
        Payment payment = new Payment();
        payment.setId("pay_FF2EFFF1226D7EAC71DFE00B27A2424A");
        payment.setChargeId("chr_962B27718883F7818BA12F1EA7FE6A80");
        payment.setDate(LocalDate.of(2021, 03, 12));
        payment.setReleaseDate(LocalDate.of(2021, 04, 12));
        payment.setAmount(BigDecimal.valueOf(50.00D));
        payment.setFee(BigDecimal.valueOf(2.15));
        payment.setType("INSTALLMENT_CREDIT_CARD");
        payment.setStatus("AUTHORIZED");
        payment.setTransactionId("30745db7d4869f");
        payment.setFailReason(null);
        return payment.toString();
    }

    public String findIncompleteObject() {
        Payment payment = new Payment();
        payment.getId();
        payment.getChargeId();
        payment.getDate();
        payment.getReleaseDate();
        payment.getAmount();
        payment.getFee();
        payment.getType();
        payment.getStatus();
        payment.getTransactionId();
        payment.getFailReason();
        return payment.toString();
    }
}
