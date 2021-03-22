package br.com.juno.integration.api.services;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import br.com.juno.test.AbstractServiceTest;
import br.com.juno.test.FixtureHelper;

public class AuthorizationServiceTest extends AbstractServiceTest {

    @Test
    public void getToken() {
        String accessToken = JunoApiManager.getAuthorizationService().getToken();

        assertEquals(FixtureHelper.AUTH_TOKEN_ACCESS_TOKEN, accessToken);

    }
}
