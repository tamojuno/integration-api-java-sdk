package br.com.juno.integration.api.services;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import br.com.juno.integration.api.model.BillPayment;
import br.com.juno.integration.api.services.request.billpayment.RegisterBillPaymentRequest;
import br.com.juno.test.AbstractTest;

public class BillPaymentServiceTest extends AbstractTest {

    @Test
    public void testRegisterBillPayment() {

        JunoApiManager.config().setClientId("JfzNWs79Mcdn6jfw").setClientSecret("mh7=jU*=!@OPiNFG^n6Ug|>f7uw6;%73").setResourceToken(
                "0153B6F504FC71A0EF1EB69116010986AA4C4B2C3755F79042366E9D00B915D3").sandbox();

        RegisterBillPaymentRequest billPaymentRequest = new RegisterBillPaymentRequest("96645892098", //
                BigDecimal.valueOf(134.73D), //
                LocalDate.of(2021, 03, 18), //
                "34191101213456788005871234570001616670000012345", //
                BigDecimal.valueOf(134.73D), //
                LocalDate.now()); //

        BillPayment billPayment = JunoApiManager.getBillPaymentService().registerBillPayment(billPaymentRequest);
        System.out.println(billPayment);
    }
}
