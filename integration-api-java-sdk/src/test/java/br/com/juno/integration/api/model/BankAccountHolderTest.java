package br.com.juno.integration.api.model;

import static br.com.juno.test.FixtureHelper.HOLDER_DOCUMENT;
import static br.com.juno.test.FixtureHelper.HOLDER_NAME;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import com.fasterxml.jackson.core.type.TypeReference;

import org.junit.jupiter.api.Test;
import org.springframework.hateoas.Resource;

import br.com.juno.integration.api.services.response.Response;
import br.com.juno.test.AbstractTest;

public class BankAccountHolderTest extends AbstractTest {

    @Test
    public void constructors() {
        BankAccountHolder bankAccountHolder = new BankAccountHolder();
        assertNull(bankAccountHolder.getName());
        assertNull(bankAccountHolder.getDocument());

        bankAccountHolder = new BankAccountHolder();
        bankAccountHolder.setName(HOLDER_NAME);
        bankAccountHolder.setDocument(HOLDER_DOCUMENT);

        assertEquals(HOLDER_NAME, bankAccountHolder.getName());
        assertEquals(HOLDER_DOCUMENT, bankAccountHolder.getDocument());

    }

    @Test
    public void toStringComplete() {
        BankAccountHolder bankAccountHolder = new BankAccountHolder();
        bankAccountHolder.setName(HOLDER_NAME);
        bankAccountHolder.setDocument(HOLDER_DOCUMENT);
        assertEquals("BankAccountHolder[John Doe,06085371950]", bankAccountHolder.toString());
    }

    @Test
    public void toStringEmpty() {
        BankAccountHolder bankAccountHolder = new BankAccountHolder();
        assertEquals("BankAccountHolder[<null>,<null>]", bankAccountHolder.toString());
    }

    //TODO: create equality test

    @Test
    public void jsonToObject() throws Exception {
        Response<BankAccountHolder> res = new Response<>(getObjectMapper().readValue(findOne(), new TypeReference<Resource<BankAccountHolder>>() {
            // NTD
        }));

        assertEquals(null, res.getHrefSelf());

        BankAccountHolder bankAccountHolder = res.getContent();

        assertEquals(HOLDER_NAME, bankAccountHolder.getName());
        assertEquals(HOLDER_DOCUMENT, bankAccountHolder.getDocument());

    }

    private String findOne() {
        return "{\"name\":\"John Doe\",\"document\":\"06085371950\"}";
    }
}
