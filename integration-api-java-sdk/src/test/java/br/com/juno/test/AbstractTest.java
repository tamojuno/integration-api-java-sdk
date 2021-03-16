package br.com.juno.test;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.jupiter.api.BeforeEach;
import org.springframework.hateoas.hal.Jackson2HalModule;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import br.com.juno.integration.api.base.Clock;
import br.com.juno.integration.api.model.BankAccountType;
import br.com.juno.integration.api.services.JunoApiManager;

public abstract class AbstractTest {

    @BeforeEach
    public void initialize() {
        if (!JunoApiManager.config().isConfigured()) {
            JunoApiManager.config().setClientId("JfzNWs79Mcdn6jfw").setClientSecret("Yb#2(i;X<owxphN{M1Iy_BFTDc,4?1ok").setResourceToken(
                    "0153B6F504FC71A0EF1EB69116010986AA4C4B2C3755F79042366E9D00B915D3");
        }

        setDate(CURRENT_DATE_TIME);
    }

    public void setDate(String date) {
        Clock.setFixedCalendar(date);
    }

    protected final ObjectMapper getObjectMapper() {
        if (mapper == null) {
            mapper = Jackson2ObjectMapperBuilder.json().modules(new Jackson2HalModule()).build();
        }

        return mapper;
    }

    protected static final String BASE_URI = "https://sandbox.boletobancario.com/api-integration";
    protected static final String CLIENT_ID = "JfzNWs79Mcdn6jfw";
    protected static final String CLIENT_SECRET = "mh7=jU*=!@OPiNFG^n6Ug|>f7uw6;%73";
    protected static final String X_RESOURCE_TOKEN = "0153B6F504FC71A0EF1EB69116010986AA4C4B2C3755F79042366E9D00B915D3";

    protected static final String AUTH_TOKEN_ACCESS_TOKEN = "eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXvCJ9.eyJ1c2VyX25hbWUiOiJ1c2VyQGRvbWFpbi5jb20iLCJzY29wZSI6WyJhbGwiXSwiZXhwIjoxNTczMDcsMDUyLCJqdGkiOiI5NzNhMGY1Yi01NzBmLTQ5OTMtYmViZi1iNTZmZGQyMjgwNGQiLCJjbGllbnRfaWQiOialeGVtcGxvLWNsaWVudC1pZCJ9.aI8b3TqmoXKN9JZG27t64z6GBM7u9BmcDoELvBmXOAnT_g-NZ3qo83ptpTtZXHGOzx7J0hFdzVZ60feCN7gBfM-UhOwKaRwKJwmA41ZPqNyInoRBieuLCrBua8DwNHJ-BroQBWvXgeuFmyukqz1nRGoJTMuov6gbRjThdsYM0pBS4bsLM9QhZEnPkG1C7PSSNBYpvsVdBSvSMWZk8ulrKennMn305O7WPL25W4HyU3RorJK2AyiQ2pYFIDf--QdpFjzALYpwj_WKi0W2noBUKM4lCnHgsgM6ezxO56n68eB5PQzDLtI3CqRgwMgBcys5aLUWO5Y71AjC1rerEOLOOQ";
    protected static final String AUTH_TOKEN_TOKEN_TYPE = "bearer";
    protected static final Long AUTH_TOKEN_EXPIRES_IN = 3600L;
    protected static final String AUTH_TOKEN_SCOPE = "all";
    protected static final String AUTH_TOKEN_USER_NAME = "email@domain.com";
    protected static final String AUTH_TOKEN_JTI = "973a0f5b-570f-4993-bebf-b56fdd22804d";

    // BankAccount
    protected static final String BANK_NUMBER = "104";
    protected static final String BANK_NAME = "Caixa Econômica Federal";
    protected static final String AGENCY_NUMBER = "4252";
    protected static final String ACCOUNT_NUMBER = "0065696-8";
    protected static final String ACCOUNT_COMPLEMENT_NUMBER = "013";
    protected static final BankAccountType ACCOUNT_TYPE = BankAccountType.CHECKING;

    protected static final String HOLDER_NAME = "John Doe";
    protected static final String HOLDER_DOCUMENT = "06085371950";

    protected static final String CURRENT_DATE_TIME = "25/11/2019 16:12:00.000";

    private ObjectMapper mapper;
}