package br.com.juno.integration.api.services;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

import br.com.juno.integration.api.model.Address;
import br.com.juno.integration.api.model.BankAccount;
import br.com.juno.integration.api.model.BankAccountType;
import br.com.juno.integration.api.model.DigitalAccount;
import br.com.juno.integration.api.services.request.digitalaccounts.DigitalAccountCreateRequest;
import br.com.juno.integration.api.services.request.digitalaccounts.DigitalAccountRequest;
import br.com.juno.integration.api.services.request.digitalaccounts.DigitalAccountUpdateRequest;
import br.com.juno.test.AbstractServiceTest;
import br.com.juno.test.FixtureHelper;

public class DigitalAccountServiceTest extends AbstractServiceTest {

    @Test
    public void findDigitalAccount() {
        DigitalAccountRequest request = new DigitalAccountRequest();

        mockServer().expectFindDigitalAccount();
        DigitalAccount findDigitalAccount = JunoApiManager.getDigitalAccountService().findDigitalAccount(request);
        assertEquals(FixtureHelper.DAC_TYPE, findDigitalAccount.getType());
        assertEquals(FixtureHelper.DAC_STATUS, findDigitalAccount.getStatus());
        assertEquals(FixtureHelper.DAC_PERSON_TYPE, findDigitalAccount.getPersonType());
        assertEquals(FixtureHelper.HOLDER_DOCUMENT, findDigitalAccount.getDocument());
        assertEquals(FixtureHelper.CREATED_ON, findDigitalAccount.getCreatedOn());
        assertEquals(FixtureHelper.ACCOUNT_NUMBER, findDigitalAccount.getAccountNumber());
    }

    @Test
    public void createDigitalAccount() {

        Address address = new Address();
        address.setStreet("R. Mariano Torres");
        address.setNumber("729");
        address.setCity("Curitiba");
        address.setState("PR");
        address.setPostCode("80060120");

        BankAccount bankAccount = new BankAccount();
        bankAccount.setBankNumber(FixtureHelper.BANK_NUMBER);
        bankAccount.setAgencyNumber(FixtureHelper.AGENCY_NUMBER);
        bankAccount.setAccountNumber(FixtureHelper.ACCOUNT_NUMBER);
        bankAccount.setAccountType(BankAccountType.CHECKING);

        DigitalAccountCreateRequest request = new DigitalAccountCreateRequest("PAYMENT", "Alfredo Maroto", "84317951070", "9spiderman@liabravin.ml",
                "1994-06-09", "41999002102", 2029L, "QualquerCoisa", "Alfredina", BigDecimal.valueOf(1000.0D), "MEI", null, address, bankAccount);

        mockServer().expectCreateDigitalAccount(request);

        DigitalAccount createDigitalAccount = JunoApiManager.getDigitalAccountService().createDigitalAccount(request);
        assertEquals(FixtureHelper.DAC_TYPE, createDigitalAccount.getType());
        assertEquals(FixtureHelper.DAC_STATUS, createDigitalAccount.getStatus());
        assertEquals(FixtureHelper.DAC_PERSON_TYPE, createDigitalAccount.getPersonType());
        assertEquals(FixtureHelper.HOLDER_DOCUMENT, createDigitalAccount.getDocument());
        assertEquals(FixtureHelper.CREATED_ON, createDigitalAccount.getCreatedOn());
        assertEquals(FixtureHelper.X_RESOURCE_TOKEN, createDigitalAccount.getResourceToken());
        assertEquals(FixtureHelper.ACCOUNT_NUMBER, createDigitalAccount.getAccountNumber());

    }

    @Test
    public void updateDigitalAccount() {

        Address address = new Address();
        address.setStreet("R. Mariano Torres");
        address.setNumber("729");
        address.setCity("Curitiba");
        address.setState("PR");
        address.setPostCode("80060120");

        BankAccount bankAccount = new BankAccount();
        bankAccount.setBankNumber(FixtureHelper.BANK_NUMBER);
        bankAccount.setAgencyNumber(FixtureHelper.AGENCY_NUMBER);
        bankAccount.setAccountNumber(FixtureHelper.ACCOUNT_NUMBER);
        bankAccount.setAccountType(BankAccountType.CHECKING);
        DigitalAccountUpdateRequest request = new DigitalAccountUpdateRequest("Alfredao", "1995-09-06", "41999002102", 2029L, "QualquerCoisa", "MEI",
                "QualquerCoisa", null, address, bankAccount);

        mockServer().expectUpdateDigitalAccount(request);

        DigitalAccount updateDigitalAccount = JunoApiManager.getDigitalAccountService().updateDigitalAccount(request);
        assertEquals(FixtureHelper.DAC_TYPE, updateDigitalAccount.getType());
        assertEquals(FixtureHelper.DAC_STATUS, updateDigitalAccount.getStatus());
        assertEquals(FixtureHelper.DAC_PERSON_TYPE, updateDigitalAccount.getPersonType());
        assertEquals(FixtureHelper.HOLDER_DOCUMENT, updateDigitalAccount.getDocument());
        assertEquals(FixtureHelper.CREATED_ON, updateDigitalAccount.getCreatedOn());
        assertEquals(FixtureHelper.ACCOUNT_NUMBER, updateDigitalAccount.getAccountNumber());

    }

}
