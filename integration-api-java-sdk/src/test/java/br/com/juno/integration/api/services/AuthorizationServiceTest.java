package br.com.juno.integration.api.services;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import br.com.juno.test.AbstractTest;
import br.com.juno.test.FixtureHelper;

public class AuthorizationServiceTest extends AbstractTest {

    @Test
    public void getToken() {
        String accessToken = JunoApiManager.getAuthorizationService().getToken();

        assertEquals(FixtureHelper.DUMMY_BEARER_AUTHORIZATION, accessToken);
    }
}
