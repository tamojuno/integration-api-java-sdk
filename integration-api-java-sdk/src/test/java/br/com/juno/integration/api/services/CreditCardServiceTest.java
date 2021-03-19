package br.com.juno.integration.api.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import br.com.juno.integration.api.base.exception.JunoApiException;
import br.com.juno.integration.api.model.TokenizedCreditCard;
import br.com.juno.integration.api.services.request.creditcard.CreditCardTokenizationRequest;
import br.com.juno.test.AbstractServiceTest;

public class CreditCardServiceTest extends AbstractServiceTest {

    @Test
    public void tokenize() {
        CreditCardTokenizationRequest request = new CreditCardTokenizationRequest("7fc59d5cca80b7f4a8a3442dfe18c8b764366e95");

        mockServer().expectCreditCardTokenization(request);

        TokenizedCreditCard tokenizedCreditCard = JunoApiManager.getCreditCardService().tokenize(request);

        assertEquals("78a131ce-6869-41af-b341-aab3984a68b8", tokenizedCreditCard.getCreditCardId());
        assertEquals("4695", tokenizedCreditCard.getLast4CardNumber());
        assertEquals("09", tokenizedCreditCard.getExpirationMonth());
        assertEquals("2030", tokenizedCreditCard.getExpirationYear());
    }

    @Test
    public void tokenizeNotHavingPublicTokenConfigured() {
        configureCredentials("dummyClientId", "dummyClientSecret", "dummyResourceToken");

        assertThrows(JunoApiException.class, //
                () -> JunoApiManager.getCreditCardService().tokenize(null), //
                "To perform this operation your Public Token must be configured, check our integration manual to see how to generate the Public Token"); //
    }

}
