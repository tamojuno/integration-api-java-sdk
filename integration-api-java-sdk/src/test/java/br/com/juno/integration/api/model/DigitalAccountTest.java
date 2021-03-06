package br.com.juno.integration.api.model;

import static br.com.juno.test.FixtureHelper.ACCOUNT_NUMBER;
import static br.com.juno.test.FixtureHelper.HOLDER_DOCUMENT;
import static br.com.juno.test.FixtureHelper.X_RESOURCE_TOKEN;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import com.fasterxml.jackson.core.type.TypeReference;

import org.junit.jupiter.api.Test;
import org.springframework.hateoas.Resource;

import br.com.juno.integration.api.services.response.Response;
import br.com.juno.test.AbstractTest;
import br.com.juno.test.FixtureHelper;

public class DigitalAccountTest extends AbstractTest {

    private static final String DIGITAL_ACCOUNT_TYPE = "PAYMENT";
    private static final String DIGITAL_ACCOUNT_STATUS = "AWAITING_DOCUMENTS";
    private static final char DIGITAL_ACCOUNT_PERSON_TYPE = 'F';
    private static final String DIGITAL_ACCOUNT_CREATED_ON = "2021-03-15T09:27:41.306-03:00";

    @Test
    public void constructors() {
        DigitalAccount digitalAccount = new DigitalAccount();
        assertNull(digitalAccount.getType());
        assertNull(digitalAccount.getStatus());
        assertEquals(0, digitalAccount.getPersonType());
        assertNull(digitalAccount.getDocument());
        assertNull(digitalAccount.getCreatedOn());
        assertNull(digitalAccount.getResourceToken());
        assertNull(digitalAccount.getAccountNumber());

        digitalAccount = new DigitalAccount();
        digitalAccount.setType(DIGITAL_ACCOUNT_TYPE);
        digitalAccount.setStatus(DIGITAL_ACCOUNT_STATUS);
        digitalAccount.setPersonType(DIGITAL_ACCOUNT_PERSON_TYPE);
        digitalAccount.setDocument(FixtureHelper.HOLDER_DOCUMENT);
        digitalAccount.setCreatedOn(DIGITAL_ACCOUNT_CREATED_ON);
        digitalAccount.setResourceToken(FixtureHelper.X_RESOURCE_TOKEN);
        digitalAccount.setAccountNumber(FixtureHelper.ACCOUNT_NUMBER);

        assertEquals(DIGITAL_ACCOUNT_TYPE, digitalAccount.getType());
        assertEquals(DIGITAL_ACCOUNT_STATUS, digitalAccount.getStatus());
        assertEquals(DIGITAL_ACCOUNT_PERSON_TYPE, digitalAccount.getPersonType());
        assertEquals(HOLDER_DOCUMENT, digitalAccount.getDocument());
        assertEquals(DIGITAL_ACCOUNT_CREATED_ON, digitalAccount.getCreatedOn());
        assertEquals(X_RESOURCE_TOKEN, digitalAccount.getResourceToken());
        assertEquals(ACCOUNT_NUMBER, digitalAccount.getAccountNumber());
    }

    @Test
    public void toStringComplete() {
        DigitalAccount digitalAccount = new DigitalAccount();
        digitalAccount.setType(DIGITAL_ACCOUNT_TYPE);
        digitalAccount.setStatus(DIGITAL_ACCOUNT_STATUS);
        digitalAccount.setPersonType(DIGITAL_ACCOUNT_PERSON_TYPE);
        digitalAccount.setDocument(HOLDER_DOCUMENT);
        digitalAccount.setCreatedOn(DIGITAL_ACCOUNT_CREATED_ON);
        digitalAccount.setResourceToken(X_RESOURCE_TOKEN);
        digitalAccount.setAccountNumber(ACCOUNT_NUMBER);
        assertEquals(
                "DigitalAccount[<null>,PAYMENT,AWAITING_DOCUMENTS,F,06085371950,2021-03-15T09:27:41.306-03:00,0153B6F504FC71A0EF1EB69116010986AA4C4B2C3755F79042366E9D00B915D3,10000224836]",
                digitalAccount.toString());
    }

    @Test
    public void toStringEmpty() {
        DigitalAccount digitalAccount = new DigitalAccount();
        assertEquals("DigitalAccount[<null>,<null>,<null>, ,<null>,<null>,<null>,<null>]", digitalAccount.toString());
    }

    //TODO: create equality test

    @Test
    public void jsonToObject() throws Exception {
        Response<DigitalAccount> res = new Response<>(getObjectMapper().readValue(findOne(), new TypeReference<Resource<DigitalAccount>>() {
            // NTD
        }));

        assertEquals(null, res.getHrefSelf());

        DigitalAccount digitalAccount = res.getContent();

        assertEquals(DIGITAL_ACCOUNT_TYPE, digitalAccount.getType());
        assertEquals(DIGITAL_ACCOUNT_STATUS, digitalAccount.getStatus());
        assertEquals(DIGITAL_ACCOUNT_PERSON_TYPE, digitalAccount.getPersonType());
        assertEquals(HOLDER_DOCUMENT, digitalAccount.getDocument());
        assertEquals(DIGITAL_ACCOUNT_CREATED_ON, digitalAccount.getCreatedOn());
        assertEquals(null, digitalAccount.getResourceToken());
        assertEquals(ACCOUNT_NUMBER, digitalAccount.getAccountNumber());

    }

    private String findOne() {
        return "{\"id\":\"dac_9EC04E9A110A2E3D\",\"type\":\"PAYMENT\",\"status\":\"AWAITING_DOCUMENTS\",\"personType\":\"F\",\"document\":\"06085371950\",\"createdOn\":\"2021-03-15T09:27:41.306-03:00\",\"accountNumber\":\"10000224836\"}";
    }
}
