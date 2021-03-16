package br.com.juno.integration.api.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import com.fasterxml.jackson.core.type.TypeReference;

import org.junit.jupiter.api.Test;
import org.springframework.hateoas.Resource;

import br.com.juno.integration.api.services.response.Response;
import br.com.juno.test.AbstractTest;

public class RecipientTest extends AbstractTest {

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
        Response<Recipient> res = new Response<>(getObjectMapper().readValue(findOne(), new TypeReference<Resource<Recipient>>() {
            // NTD
        }));

        assertEquals(null, res.getHrefSelf());

        Recipient recipient = res.getContent();
        System.out.println(res.getContent());

        assertEquals(HOLDER_NAME, recipient.getName());
        assertEquals(HOLDER_DOCUMENT, recipient.getDocument());
        //        assertEquals(BANK_ACCOUNT, recipient.getBankAccount());

    }

    private String findOne() {
        return "\"recipient\":{\"name\":\"John Doe\",\"document\":\"06085371950\",\"bankAccount\":{\"bankNumber\":\"104\",\"agencyNumber\":\"4252\",\"accountNumber\":\"0065696-8\",\"accountComplementNumber\":\"013\",\"accountType\":\"CHECKING\"}}";
    }
}
