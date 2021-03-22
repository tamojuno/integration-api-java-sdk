package br.com.juno.integration.api.services;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import br.com.juno.integration.api.services.request.billpayment.RegisterBillPaymentRequest;
import br.com.juno.test.AbstractServiceTest;

@Disabled
public class BillPaymentServiceTest extends AbstractServiceTest {

    @Test
    public void registerBillPayment() {
        RegisterBillPaymentRequest billPaymentRequest = new RegisterBillPaymentRequest("96645892098", //
                BigDecimal.valueOf(134.73D), //
                LocalDate.of(2021, 03, 28), //
                "34191101213456788005871234570001616670000012345", //
                BigDecimal.valueOf(134.73D), //
                LocalDate.now()); //

        JunoApiManager.getBillPaymentService().registerBillPayment(billPaymentRequest);
    }
}
