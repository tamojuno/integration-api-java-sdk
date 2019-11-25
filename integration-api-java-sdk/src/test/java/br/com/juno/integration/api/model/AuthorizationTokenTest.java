package br.com.juno.integration.api.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

import br.com.juno.test.AbstractTest;

public class AuthorizationTokenTest extends AbstractTest {

    @Test
    public void jsonToObject() throws Exception {
        AuthorizationToken authToken = getObjectMapper().readValue(getOne(), AuthorizationToken.class);

        assertEquals(AUTH_TOKEN_ACCESS_TOKEN, authToken.getAccessToken());
        assertEquals(AUTH_TOKEN_TOKEN_TYPE, authToken.getTokenType());
        assertEquals(AUTH_TOKEN_EXPIRES_IN, authToken.getExpiresIn());
        assertEquals(AUTH_TOKEN_SCOPE, authToken.getScope());
        assertEquals(AUTH_TOKEN_USER_NAME, authToken.getUserName());
        assertEquals(AUTH_TOKEN_JTI, authToken.getJti());
        assertTrue(authToken.isExpired());
    }

    private String getOne() throws Exception {
        Map<String, Object> map = new HashMap<>();

        map.put("access_token", AUTH_TOKEN_ACCESS_TOKEN);
        map.put("token_type", AUTH_TOKEN_TOKEN_TYPE);
        map.put("expires_in", AUTH_TOKEN_EXPIRES_IN);
        map.put("scope", AUTH_TOKEN_SCOPE);
        map.put("user_name", AUTH_TOKEN_USER_NAME);
        map.put("jti", AUTH_TOKEN_JTI);

        return getObjectMapper().writeValueAsString(map);
    }
}