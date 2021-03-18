package br.com.juno.integration.api.services;

import java.math.BigDecimal;
import java.util.List;

import org.junit.jupiter.api.Test;

import br.com.juno.integration.api.services.request.charge.ChargeCreateRequest;
import br.com.juno.integration.api.services.request.charge.ChargeCreateRequest.Billing;
import br.com.juno.integration.api.services.request.charge.ChargeCreateRequest.Billing.Address;
import br.com.juno.integration.api.services.request.charge.ChargeCreateRequest.Charge;
import br.com.juno.test.AbstractTest;

public class ChargeServiceTest extends AbstractTest {

    @Test
    public void testCreateCharge() {

        ChargeCreateRequest.Charge charge = new Charge("CobrancaTest");
        charge.setAmount(BigDecimal.valueOf(10.0D));
        ChargeCreateRequest.Billing billing = new Billing();
        billing.setName(HOLDER_NAME);
        billing.setDocument(HOLDER_DOCUMENT);
        billing.setEmail(PAYER_EMAIL);
        ChargeCreateRequest.Billing.Address address = new Address();
        address.setStreet("Rua Alguma coisa");
        address.setNumber("12");
        address.setCity("Curitiba");
        address.setState("PR");
        address.setPostCode("81270350");
        billing.setAddress(address);

        ChargeCreateRequest chargeCreateRequest = new ChargeCreateRequest(charge, billing);

        List<br.com.juno.integration.api.model.Charge> createdCharges = JunoApiManager.getChargeService().create(chargeCreateRequest);

        createdCharges.forEach(System.out::println);
    }
}
