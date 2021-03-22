package br.com.juno.integration.api.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import com.fasterxml.jackson.core.type.TypeReference;

import org.junit.jupiter.api.Test;
import org.springframework.hateoas.Resource;

import br.com.juno.integration.api.services.response.Response;
import br.com.juno.test.AbstractTest;

public class TokenizedCreditCardTest extends AbstractTest {

    @Test
    public void constructors() {
        TokenizedCreditCard tokenizedCreditCard = new TokenizedCreditCard();
        assertNull(tokenizedCreditCard.getCreditCardId());
        assertNull(tokenizedCreditCard.getLast4CardNumber());
        assertNull(tokenizedCreditCard.getExpirationMonth());
        assertNull(tokenizedCreditCard.getExpirationYear());

        tokenizedCreditCard = new TokenizedCreditCard();
        tokenizedCreditCard.setCreditCardId("string");
        tokenizedCreditCard.setLast4CardNumber("string");
        tokenizedCreditCard.setExpirationMonth("string");
        tokenizedCreditCard.setExpirationYear("string");

        assertEquals("string", tokenizedCreditCard.getCreditCardId());
        assertEquals("string", tokenizedCreditCard.getLast4CardNumber());
        assertEquals("string", tokenizedCreditCard.getExpirationMonth());
        assertEquals("string", tokenizedCreditCard.getExpirationYear());
    }

    @Test
    public void toStringComplete() {
        TokenizedCreditCard tokenizedCreditCard = new TokenizedCreditCard();
        tokenizedCreditCard.setCreditCardId("string");
        tokenizedCreditCard.setLast4CardNumber("string");
        tokenizedCreditCard.setExpirationMonth("string");
        tokenizedCreditCard.setExpirationYear("string");
        assertEquals("TokenizedCreditCard[string,string,string,string]", tokenizedCreditCard.toString());
    }

    @Test
    public void toStringEmpty() {
        TokenizedCreditCard tokenizedCreditCard = new TokenizedCreditCard();
        assertEquals("TokenizedCreditCard[<null>,<null>,<null>,<null>]", tokenizedCreditCard.toString());
    }

    //TODO: create equality test

    @Test
    public void jsonToObject() throws Exception {
        Response<TokenizedCreditCard> res = new Response<>(getObjectMapper().readValue(findOne(), new TypeReference<Resource<TokenizedCreditCard>>() {
            // NTD
        }));

        assertEquals(null, res.getHrefSelf());

        TokenizedCreditCard tokenizedCreditCard = res.getContent();

        assertEquals("string", tokenizedCreditCard.getCreditCardId());
        assertEquals("string", tokenizedCreditCard.getLast4CardNumber());
        assertEquals("string", tokenizedCreditCard.getExpirationMonth());
        assertEquals("string", tokenizedCreditCard.getExpirationYear());
    }

    private String findOne() {
        return "{\"creditCardId\":\"string\",\"last4CardNumber\":\"string\",\"expirationMonth\":\"string\",\"expirationYear\":\"string\"}";
    }
}
