package br.com.juno.integration.api.model;

import static br.com.juno.test.FixtureHelper.AUTH_TOKEN_ACCESS_TOKEN;
import static br.com.juno.test.FixtureHelper.AUTH_TOKEN_EXPIRES_IN;
import static br.com.juno.test.FixtureHelper.AUTH_TOKEN_JTI;
import static br.com.juno.test.FixtureHelper.AUTH_TOKEN_SCOPE;
import static br.com.juno.test.FixtureHelper.AUTH_TOKEN_TOKEN_TYPE;
import static br.com.juno.test.FixtureHelper.AUTH_TOKEN_USER_NAME;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

import br.com.juno.integration.api.base.Clock;
import br.com.juno.integration.api.base.exception.JunoApiException;
import br.com.juno.integration.api.services.JunoApiConfig;
import br.com.juno.test.AbstractTest;

public class AuthorizationTokenTest extends AbstractTest {

    @Test
    public void jsonToObject() throws Exception {
        AuthorizationToken authToken = getAuthorizationToken();

        assertEquals(AUTH_TOKEN_ACCESS_TOKEN, authToken.getAccessToken());
        assertEquals(AUTH_TOKEN_TOKEN_TYPE, authToken.getTokenType());
        assertEquals(AUTH_TOKEN_EXPIRES_IN, authToken.getExpiresIn());
        assertEquals(AUTH_TOKEN_SCOPE, authToken.getScope());
        assertEquals(AUTH_TOKEN_USER_NAME, authToken.getUserName());
        assertEquals(AUTH_TOKEN_JTI, authToken.getJti());
        assertFalse(authToken.isExpired());
    }

    @Test
    public void isExpiredWithExpiredInNotInitialized() throws Exception {
        AuthorizationToken authToken = getAuthorizationToken();
        authToken.setExpiresIn(null);

        assertThrows(JunoApiException.class, () -> authToken.isExpired());
    }

    @Test
    public void isExpiredNotExpired() throws Exception {
        AuthorizationToken authToken = getAuthorizationToken();

        Long notExpired = Clock.getTimeInMillis() + authToken.getExpiresInMillis();
        Clock.setFixedCalendar(notExpired);

        assertFalse(authToken.isExpired());
    }

    @Test
    public void isExpiredActuallyExpired() throws Exception {
        AuthorizationToken authToken = getAuthorizationToken();

        Long expired = Clock.getTimeInMillis() + authToken.getExpiresInMillis() + 1L;
        Clock.setFixedCalendar(expired);

        assertTrue(authToken.isExpired());
    }

    @Test
    public void isExpiredNotExpiredConsideringThreshold() throws Exception {
        AuthorizationToken authToken = getAuthorizationToken();

        Long notExpired = Clock.getTimeInMillis() + authToken.getExpiresInMillis() - JunoApiConfig.TOKEN_TIMEOUT;
        Clock.setFixedCalendar(notExpired);

        assertFalse(authToken.isExpired(JunoApiConfig.TOKEN_TIMEOUT));
    }

    @Test
    public void isExpiredActuallyExpiredConsideringThreshold() throws Exception {
        AuthorizationToken authToken = getAuthorizationToken();

        Long expired = Clock.getTimeInMillis() + authToken.getExpiresInMillis();
        Clock.setFixedCalendar(expired);

        assertTrue(authToken.isExpired(JunoApiConfig.TOKEN_TIMEOUT));
    }

    private AuthorizationToken getAuthorizationToken() throws Exception {
        return getObjectMapper().readValue(getOne(), AuthorizationToken.class);
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