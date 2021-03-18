package br.com.juno.integration.api.services;

import org.junit.jupiter.api.Test;

import br.com.juno.integration.api.model.TokenizedCreditCard;
import br.com.juno.integration.api.services.request.creditcard.CreditCardTokenizationRequest;
import br.com.juno.test.AbstractTest;

public class CreditCardServiceTest extends AbstractTest {

    @Test
    public void testCreditCardTokenization() {
        CreditCardTokenizationRequest cardTokenizationRequest = new CreditCardTokenizationRequest("7fc59d5cca80b7f4a8a3442dfe18c8b764366e95");
        TokenizedCreditCard tokenizedCreditCard = JunoApiManager.getCreditCardService().tokenize(cardTokenizationRequest);
        System.out.println(tokenizedCreditCard);
    }

}
