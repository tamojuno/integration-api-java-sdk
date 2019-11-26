package br.com.juno.integration.api.services;

import org.junit.jupiter.api.Test;

import br.com.juno.test.AbstractTest;

public class AuthorizationServiceTest extends AbstractTest {

    @Test
    public void testGetToken() {
        ApiManager.initialize("8hKM1sGxo963Zego", "Yb#2(i;X<owxphN{M1Iy_BFTDc,4?1ok", "resourceToken");
        String token = ApiManager.getInstance().getAuthorizationService().getToken();
        System.out.println(token);
        token = ApiManager.getInstance().getAuthorizationService().getToken();
        System.out.println(token);
    }
}
