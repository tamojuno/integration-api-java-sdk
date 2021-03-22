package br.com.juno.integration.api.model;

import static br.com.juno.test.FixtureHelper.ACCOUNT_COMPLEMENT_NUMBER;
import static br.com.juno.test.FixtureHelper.ACCOUNT_NUMBER;
import static br.com.juno.test.FixtureHelper.ACCOUNT_TYPE;
import static br.com.juno.test.FixtureHelper.AGENCY_NUMBER;
import static br.com.juno.test.FixtureHelper.BANK_NUMBER;
import static br.com.juno.test.FixtureHelper.HOLDER_DOCUMENT;
import static br.com.juno.test.FixtureHelper.HOLDER_NAME;
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
        Recipient recipient = new Recipient();
        assertNull(recipient.getName());
        assertNull(recipient.getDocument());
        assertNull(recipient.getBankAccount());

        recipient = new Recipient();
        recipient.setName(HOLDER_NAME);
        recipient.setDocument(HOLDER_DOCUMENT);

        BankAccount bankAccount = new BankAccount();
        bankAccount.setBankNumber(BANK_NUMBER);
        bankAccount.setAgencyNumber(AGENCY_NUMBER);
        bankAccount.setAccountNumber(ACCOUNT_NUMBER);
        bankAccount.setAccountComplementNumber(ACCOUNT_COMPLEMENT_NUMBER);
        bankAccount.setAccountType(ACCOUNT_TYPE);
        recipient.setBankAccount(bankAccount);

        assertEquals(HOLDER_NAME, recipient.getName());
        assertEquals(HOLDER_DOCUMENT, recipient.getDocument());
        assertEquals(BANK_NUMBER, recipient.getBankAccount().getBankNumber());
        assertEquals(AGENCY_NUMBER, recipient.getBankAccount().getAgencyNumber());
        assertEquals(ACCOUNT_NUMBER, recipient.getBankAccount().getAccountNumber());
        assertEquals(ACCOUNT_COMPLEMENT_NUMBER, recipient.getBankAccount().getAccountComplementNumber());
        assertEquals(ACCOUNT_TYPE, recipient.getBankAccount().getAccountType());

    }

    @Test
    public void toStringComplete() {
        Recipient recipient = new Recipient();
        recipient.setName(HOLDER_NAME);
        recipient.setDocument(HOLDER_DOCUMENT);
        BankAccount bankAccount = new BankAccount();
        bankAccount.setBankNumber(BANK_NUMBER);
        bankAccount.setAgencyNumber(AGENCY_NUMBER);
        bankAccount.setAccountNumber(ACCOUNT_NUMBER);
        bankAccount.setAccountComplementNumber(ACCOUNT_COMPLEMENT_NUMBER);
        bankAccount.setAccountType(ACCOUNT_TYPE);
        recipient.setBankAccount(bankAccount);
        assertEquals("Recipient[John Doe,06085371950,BankAccount[104,4252,10000224836,013,CHECKING]]", recipient.toString());
    }

    @Test
    public void toStringEmpty() {
        Recipient recipient = new Recipient();
        assertEquals("Recipient[<null>,<null>,<null>]", recipient.toString());
    }

    //TODO: create equality test

    @Test
    public void jsonToObject() throws Exception {
        Response<Recipient> res = new Response<>(getObjectMapper().readValue(findOne(), new TypeReference<Resource<Recipient>>() {
            // NTD
        }));

        assertEquals(null, res.getHrefSelf());

        Recipient recipient = res.getContent();

        assertEquals(HOLDER_NAME, recipient.getName());
        assertEquals(HOLDER_DOCUMENT, recipient.getDocument());
        assertEquals(BANK_NUMBER, recipient.getBankAccount().getBankNumber());
        assertEquals(AGENCY_NUMBER, recipient.getBankAccount().getAgencyNumber());
        assertEquals(ACCOUNT_NUMBER, recipient.getBankAccount().getAccountNumber());
        assertEquals(ACCOUNT_COMPLEMENT_NUMBER, recipient.getBankAccount().getAccountComplementNumber());
        assertEquals(ACCOUNT_TYPE, recipient.getBankAccount().getAccountType());

    }

    private String findOne() {
        return "{\"name\":\"John Doe\",\"document\":\"06085371950\",\"bankAccount\":{\"bankNumber\":\"104\",\"agencyNumber\":\"4252\",\"accountNumber\":\"10000224836\",\"accountComplementNumber\":\"013\",\"accountType\":\"CHECKING\"}}";
    }
}
