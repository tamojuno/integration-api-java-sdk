package br.com.juno.test;

import static org.junit.jupiter.api.Assertions.fail;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import br.com.juno.integration.api.model.BankAccountType;

public class FixtureHelper {

    public static final String BASE_URI = "https://sandbox.boletobancario.com/api-integration";
    public static final String CLIENT_ID = "JfzNWs79Mcdn6jfw";
    public static final String CLIENT_SECRET = "mh7=jU*=!@OPiNFG^n6Ug|>f7uw6;%73";
    public static final String X_RESOURCE_TOKEN = "0153B6F504FC71A0EF1EB69116010986AA4C4B2C3755F79042366E9D00B915D3";

    public static final String AUTH_TOKEN_ACCESS_TOKEN = "eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCx9.eyJ1c2VyX25hbWUiOiJub3J0b250Z3Vlbm9AaG90bWFpbC5jb20iLCJzY29wZSI6WyJhbGwiXSwiZXhwIjoxNjE2MTYyMTE0LCJqdGkiOiJQTmtSalVrMnZUcUZDTnJEU2g5bDVwb2NEZDQiLCJjbGllbnRfaWQiOiIyaGZCdXd5UjIxQ1liNUU4In0.nGkj78Sh_KcYflrAzGHPHjuo6XDLY_pGiE6mZAarChWHJN2DjM0ejhL9ynV081b3sB8c5yn_03f3Leq6sqXVgLpP_39Pb_yWANJ3IKOO3B3L1tUunrl-Ex4Tpw8Ixsl_qIQc0z4-Rj3xcygkWYhGWeDwA4EM67HdTovy9IFgA8lzeRZvxd8lx-VEC_sPmOLIgzlB1GDNcY4CXX4vGQ2-g5xk7a97hCAv-zTslbbmi1HFTTM1v79zBa3PdQLPWEYdIBeJ6bukWabYveI33jIi2A8BryZWesJWQtwCVvQTtIBWGd_ttQI5dvEeQXIQ_t-2SZbgrWzIklIsUtub7fAndw";
    public static final String AUTH_TOKEN_TOKEN_TYPE = "bearer";
    public static final Long AUTH_TOKEN_EXPIRES_IN = 3600L;
    public static final String AUTH_TOKEN_SCOPE = "all";
    public static final String AUTH_TOKEN_USER_NAME = "email@domain.com";
    public static final String AUTH_TOKEN_JTI = "973a0f5b-570f-4993-bebf-b56fdd22804d";

    public static final String DAC_TYPE = "PAYMENT";
    public static final String DAC_STATUS = "AWAITING_DOCUMENTS";
    public static final char DAC_PERSON_TYPE = 'F';

    // BankAccount
    public static final String BANK_NUMBER = "104";
    public static final String BANK_NAME = "Caixa Econômica Federal";
    public static final String AGENCY_NUMBER = "4252";
    public static final String ACCOUNT_NUMBER = "10000224836";
    public static final String ACCOUNT_COMPLEMENT_NUMBER = "013";
    public static final BankAccountType ACCOUNT_TYPE = BankAccountType.CHECKING;

    public static final String HOLDER_NAME = "John Doe";
    public static final String HOLDER_DOCUMENT = "06085371950";
    public static final String PAYER_EMAIL = AUTH_TOKEN_USER_NAME;

    public static final String CURRENT_DATE_TIME = "25/11/2019 16:12:00.000";
    public static final String CREATED_ON = "2021-03-19T16:56:26.975-03:00";

    public static final String ACCESS_TOKEN = "eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCx9.eyJ1c2VyX25hbWUiOiJub3J0b250Z3Vlbm9AaG90bWFpbC5jb20iLCJzY29wZSI6WyJhbGwiXSwiZXhwIjoxNjE2MTYyMTE0LCJqdGkiOiJQTmtSalVrMnZUcUZDTnJEU2g5bDVwb2NEZDQiLCJjbGllbnRfaWQiOiIyaGZCdXd5UjIxQ1liNUU4In0.nGkj78Sh_KcYflrAzGHPHjuo6XDLY_pGiE6mZAarChWHJN2DjM0ejhL9ynV081b3sB8c5yn_03f3Leq6sqXVgLpP_39Pb_yWANJ3IKOO3B3L1tUunrl-Ex4Tpw8Ixsl_qIQc0z4-Rj3xcygkWYhGWeDwA4EM67HdTovy9IFgA8lzeRZvxd8lx-VEC_sPmOLIgzlB1GDNcY4CXX4vGQ2-g5xk7a97hCAv-zTslbbmi1HFTTM1v79zBa3PdQLPWEYdIBeJ6bukWabYveI33jIi2A8BryZWesJWQtwCVvQTtIBWGd_ttQI5dvEeQXIQ_t-2SZbgrWzIklIsUtub7fAndw";
    public static final String DUMMY_BEARER_AUTHORIZATION = "Bearer " + ACCESS_TOKEN;
    public static final String BASIC_AUTHENTICATION = "Basic ZHVtbXlDbGllbnRJZDpkdW1teUNsaWVudFNlY3JldA==";

    public static String getResource(String... resources) {
        Path resourcePath = getBaseResourcePath();

        for (String resource : resources) {
            resourcePath = resourcePath.resolve(resource);
        }

        return readFromResource(resourcePath);
    }

    private static Path getBaseResourcePath() {
        return Paths.get("src", "test", "resources");
    }

    private static String readFromResource(Path path) {
        try {
            return Files.readString(path);
        } catch (IOException e) {
            fail("Unable to load resource", e);
        }
        return null;
    }

}
