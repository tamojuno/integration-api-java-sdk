package br.com.juno.integration.api.model;

import static br.com.juno.test.FixtureHelper.BANK_NAME;
import static br.com.juno.test.FixtureHelper.BANK_NUMBER;
import static br.com.juno.test.FixtureHelper.BASE_URI;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;

import org.junit.jupiter.api.Test;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;

import br.com.juno.integration.api.services.response.Response;
import br.com.juno.integration.api.services.response.Responses;
import br.com.juno.test.AbstractTest;

public class BankTest extends AbstractTest {

    @Test
    public void constructors() {
        Bank bank = new Bank();
        assertNull(bank.getNumber());
        assertNull(bank.getName());

        bank = new Bank();
        bank.setNumber(BANK_NUMBER);
        bank.setName(BANK_NAME);

        assertEquals(BANK_NUMBER, bank.getNumber());
        assertEquals(BANK_NAME, bank.getName());
    }

    @Test
    public void toStringComplete() {
        Bank bank = new Bank();
        bank.setNumber(BANK_NUMBER);
        bank.setName(BANK_NAME);
        assertEquals("Bank[104,Caixa Econômica Federal]", bank.toString());
    }

    @Test
    public void toStringEmpty() {
        Bank bank = new Bank();
        assertEquals("Bank[<null>,<null>]", bank.toString());
    }

    //TODO: create equality test

    @Test
    public void jsonToObject() throws Exception {
        Response<Bank> res = new Response<>(getObjectMapper().readValue(findOne(), new TypeReference<Resource<Bank>>() {
            // NTD
        }));

        assertEquals(null, res.getHrefSelf());

        Bank bank = res.getContent();

        assertEquals(BANK_NUMBER, bank.getNumber());
        assertEquals(BANK_NAME, bank.getName());
    }

    @Test
    public void jsonToCollection() throws Exception {
        Responses<Bank> res = new Responses<>(getObjectMapper().readValue(findAll(), new TypeReference<Resources<Resource<Bank>>>() {
            // NTD
        }));

        assertEquals(BASE_URI + "/data/banks", res.getHrefSelf());
        assertEquals(null, res.getHrefNext());
        assertEquals(null, res.getHrefPrevious());

        List<Response<Bank>> list = res.getContent();

        assertEquals(null, list.get(0).getHrefSelf());
        assertEquals("001", list.get(0).getContent().getNumber());
        assertEquals("Banco do Brasil", list.get(0).getContent().getName());

        assertEquals(null, list.get(1).getHrefSelf());
        assertEquals("104", list.get(1).getContent().getNumber());
        assertEquals("Caixa Econômica Federal", list.get(1).getContent().getName());
    }

    private String findOne() {
        return "{\"number\": \"104\",\"name\": \"Caixa Econômica Federal\"}";
    }

    private String findAll() {
        return "{\"_embedded\": {\"banks\": [{\"number\": \"001\",\"name\": \"Banco do Brasil\"},{\"number\": \"104\",\"name\": \"Caixa Econômica Federal\"}]},\"_links\": {\"self\": {\"href\": \"https://sandbox.boletobancario.com/api-integration/data/banks\"}}}";
    }
}