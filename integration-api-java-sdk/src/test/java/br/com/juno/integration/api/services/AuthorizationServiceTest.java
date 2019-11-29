package br.com.juno.integration.api.services;

import org.junit.jupiter.api.Test;

import br.com.juno.test.AbstractTest;

public class AuthorizationServiceTest extends AbstractTest {

    @Test
    public void testGetToken() {
        // just to call
        String token = JunoApiManager.resources().authorization().getToken();
        System.out.println(token);
        token = JunoApiManager.resources().authorization().getToken();
        System.out.println(token);
    }
}
