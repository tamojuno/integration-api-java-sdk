package br.com.juno.test;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockserver.junit.jupiter.MockServerExtension;
import org.mockserver.junit.jupiter.MockServerSettings;

import br.com.juno.integration.api.base.Clock;
import br.com.juno.integration.api.services.JunoApiManager;
import br.com.juno.integration.api.utils.JacksonUtils;

@ExtendWith(MockitoExtension.class)
@ExtendWith(MockServerExtension.class)
@MockServerSettings(ports = 8888)
public abstract class AbstractTest {

    @BeforeEach
    public void initialize() {
        configureCredentials("dummyClientId", "dummyClientSecret", "dummyResourceToken", "dummyPublicToken");

        setDate(FixtureHelper.CURRENT_DATE_TIME);
    }

    public void configureCredentials(String clientId, String clientSecret, String resourceToken) {
        configureCredentials(clientId, clientSecret, resourceToken, null);
    }

    public void configureCredentials(String clientId, String clientSecret, String resourceToken, String publicToken) {
        JunoApiManager.config() //
                .setClientId(clientId) //
                .setClientSecret(clientSecret) //
                .setResourceToken(resourceToken) //
                .setPublicToken(publicToken) //
                .unitTests(); //
    }

    protected void setDate(String date) {
        Clock.setFixedCalendar(date);
    }

    protected final ObjectMapper getObjectMapper() {
        return JacksonUtils.getObjectMapper();
    }

}