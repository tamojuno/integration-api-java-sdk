package br.com.juno.test;

import org.junit.jupiter.api.BeforeEach;
import org.springframework.hateoas.hal.Jackson2HalModule;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.juno.integration.api.utils.Clock;

public abstract class AbstractTest {

    @BeforeEach
    public void initialize() {
        setDate(CURRENT_DATE_TIME);
    }

    public void setDate(String date) {
        Clock.setFixedCalendar(date);
    }

    protected final ObjectMapper getObjectMapper() {
        if (objectMapper == null) {
            objectMapper = Jackson2ObjectMapperBuilder.json().modules(new Jackson2HalModule()).build();
        }

        return objectMapper;
    }

    protected static final String BASE_URI = "https://sandbox.boletobancario.com/api-integration";

    protected static final String AUTH_TOKEN_ACCESS_TOKEN = "eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXvCJ9.eyJ1c2VyX25hbWUiOiJ1c2VyQGRvbWFpbi5jb20iLCJzY29wZSI6WyJhbGwiXSwiZXhwIjoxNTczMDcsMDUyLCJqdGkiOiI5NzNhMGY1Yi01NzBmLTQ5OTMtYmViZi1iNTZmZGQyMjgwNGQiLCJjbGllbnRfaWQiOialeGVtcGxvLWNsaWVudC1pZCJ9.aI8b3TqmoXKN9JZG27t64z6GBM7u9BmcDoELvBmXOAnT_g-NZ3qo83ptpTtZXHGOzx7J0hFdzVZ60feCN7gBfM-UhOwKaRwKJwmA41ZPqNyInoRBieuLCrBua8DwNHJ-BroQBWvXgeuFmyukqz1nRGoJTMuov6gbRjThdsYM0pBS4bsLM9QhZEnPkG1C7PSSNBYpvsVdBSvSMWZk8ulrKennMn305O7WPL25W4HyU3RorJK2AyiQ2pYFIDf--QdpFjzALYpwj_WKi0W2noBUKM4lCnHgsgM6ezxO56n68eB5PQzDLtI3CqRgwMgBcys5aLUWO5Y71AjC1rerEOLOOQ";
    protected static final String AUTH_TOKEN_TOKEN_TYPE = "bearer";
    protected static final Long AUTH_TOKEN_EXPIRES_IN = 3600L;
    protected static final String AUTH_TOKEN_SCOPE = "all";
    protected static final String AUTH_TOKEN_USER_NAME = "email@domain.com";
    protected static final String AUTH_TOKEN_JTI = "973a0f5b-570f-4993-bebf-b56fdd22804d";

    protected static final String BANK_NUMBER = "104";
    protected static final String BANK_NAME = "Caixa Econômica Federal";

    protected static final String CURRENT_DATE_TIME = "25/11/2019 16:12:00.000";

    private ObjectMapper objectMapper;
}