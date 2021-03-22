package br.com.juno.integration.api.services;

import org.junit.jupiter.api.Test;

import br.com.juno.integration.api.services.request.payment.PaymentCreateRequest;
import br.com.juno.integration.api.services.request.payment.PaymentCreateRequest.Billing;
import br.com.juno.integration.api.services.request.payment.PaymentCreateRequest.CreditCardDetails;
import br.com.juno.test.AbstractServiceTest;
import br.com.juno.test.FixtureHelper;

public class PaymentServiceTest extends AbstractServiceTest {

    @Test
    public void createPayment() {
        Billing billing = new Billing();
        billing.setName(FixtureHelper.HOLDER_NAME);
        billing.setDocument(FixtureHelper.HOLDER_DOCUMENT);
        billing.setEmail(FixtureHelper.PAYER_EMAIL);
        CreditCardDetails creditCardDetails = new CreditCardDetails("ab41f0bc-955e-4e7a-ab95-fdade922235c");

        PaymentCreateRequest paymentRequest = new PaymentCreateRequest("chr_5413E71B1A8EABFD89D8FC330A37492A", billing, creditCardDetails);
        System.out.println(paymentRequest);
    }

}
