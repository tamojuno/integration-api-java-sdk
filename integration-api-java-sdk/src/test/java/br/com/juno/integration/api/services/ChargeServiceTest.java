package br.com.juno.integration.api.services;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.util.List;

import org.junit.jupiter.api.Test;

import br.com.juno.integration.api.services.request.charge.ChargeCreateRequest;
import br.com.juno.integration.api.services.request.charge.ChargeCreateRequest.Billing;
import br.com.juno.integration.api.services.request.charge.ChargeCreateRequest.Billing.Address;
import br.com.juno.integration.api.services.request.charge.ChargeCreateRequest.Charge;
import br.com.juno.test.AbstractServiceTest;
import br.com.juno.test.FixtureHelper;

public class ChargeServiceTest extends AbstractServiceTest {

    @Test
    public void create() {
        ChargeCreateRequest request = createChargeRequest();

        mockServer().expectCreateCharge(request);

        List<br.com.juno.integration.api.model.Charge> createdCharges = JunoApiManager.getChargeService().create(request);

        assertEquals(1, createdCharges.size());
        br.com.juno.integration.api.model.Charge createdCharge = createdCharges.get(0);
        assertEquals("chr_94DAB08CC02C6E061EE70DF3AEA9BECC", createdCharge.getId());
        assertEquals(188852014, createdCharge.getCode());
        assertEquals("", createdCharge.getReference());
        assertEquals("2021-04-27", createdCharge.getDueDate());
        assertEquals("https://unit-test/checkout/EA1D4E9B6F937704C92E67A70D8BA893830FCC80803563AC", createdCharge.getCheckoutUrl());
        assertEquals(1000.00D, createdCharge.getAmount().doubleValue());
        assertEquals("ACTIVE", createdCharge.getStatus());
    }

    private ChargeCreateRequest createChargeRequest() {
        ChargeCreateRequest.Charge charge = new Charge("CobrancaTest");
        charge.setAmount(BigDecimal.valueOf(10.0D));
        ChargeCreateRequest.Billing billing = new Billing();
        billing.setName(FixtureHelper.HOLDER_NAME);
        billing.setDocument(FixtureHelper.HOLDER_DOCUMENT);
        billing.setEmail(FixtureHelper.PAYER_EMAIL);
        ChargeCreateRequest.Billing.Address address = new Address();
        address.setStreet("Rua Alguma coisa");
        address.setNumber("12");
        address.setCity("Curitiba");
        address.setState("PR");
        address.setPostCode("81270350");
        billing.setAddress(address);

        ChargeCreateRequest request = new ChargeCreateRequest(charge, billing);
        return request;
    }

}
