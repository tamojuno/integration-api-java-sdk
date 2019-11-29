package br.com.juno.integration.api.services;

import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import br.com.juno.test.AbstractTest;

public class AuthorizationServiceTest extends AbstractTest {

    @Test
    public void testGetToken() {
        String token1 = JunoApiManager.getAuthorizationService().getToken();
        String token2 = JunoApiManager.getAuthorizationService().getToken();
        Assert.isTrue(token1 == token2, "The tokens are not the same.");
    }
}
