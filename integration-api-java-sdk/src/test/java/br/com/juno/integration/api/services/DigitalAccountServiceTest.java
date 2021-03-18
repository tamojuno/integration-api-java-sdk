package br.com.juno.integration.api.services;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

import br.com.juno.integration.api.model.Address;
import br.com.juno.integration.api.model.BankAccount;
import br.com.juno.integration.api.model.BankAccountType;
import br.com.juno.integration.api.model.DigitalAccount;
import br.com.juno.integration.api.services.request.digitalaccounts.DigitalAccountCreateRequest;
import br.com.juno.integration.api.services.request.digitalaccounts.DigitalAccountRequest;
import br.com.juno.integration.api.services.request.digitalaccounts.DigitalAccountUpdateRequest;
import br.com.juno.test.AbstractTest;

public class DigitalAccountServiceTest extends AbstractTest {

    @Test
    public void findDigitalAccount() {
        DigitalAccount findDigitalAccount = JunoApiManager.getDigitalAccountService().findDigitalAccount(new DigitalAccountRequest());
        System.out.println(findDigitalAccount);
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
        bankAccount.setBankNumber("260");
        bankAccount.setAgencyNumber("0001");
        bankAccount.setAccountNumber("20704584");
        bankAccount.setAccountType(BankAccountType.CHECKING);

        //        LegalRepresentative legalRepresentative = new LegalRepresentative();
        //        legalRepresentative.setName(HOLDER_NAME);
        //        legalRepresentative.setDocument(HOLDER_DOCUMENT);
        //        legalRepresentative.setBirthDate(LocalDate.of(1994, 12, 12));
        //        legalRepresentative.setMotherName("Alfredina");
        //        legalRepresentative.setType("INDIVIDUAL");

        DigitalAccountCreateRequest request = new DigitalAccountCreateRequest("PAYMENT", "Alfredo Maroto", "84317951070", "9spiderman@liabravin.ml",
                "1994-06-09", "41999002102", 2029L, "QualquerCoisa", "Alfredina", BigDecimal.valueOf(1000.0D), "MEI", null, address, bankAccount);
        DigitalAccount createDigitalAccount = JunoApiManager.getDigitalAccountService().createDigitalAccount(request);
        System.out.println(createDigitalAccount);

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
        bankAccount.setBankNumber("260");
        bankAccount.setAgencyNumber("0001");
        bankAccount.setAccountNumber("20704584");
        bankAccount.setAccountType(BankAccountType.CHECKING);
        DigitalAccountUpdateRequest request = new DigitalAccountUpdateRequest("Alfredao", "1995-09-06", "41999002102", 2029L, "QualquerCoisa", "MEI",
                "QualquerCoisa", null, address, bankAccount);
        DigitalAccount updateDigitalAccount = JunoApiManager.getDigitalAccountService().updateDigitalAccount(request);
        System.out.println(updateDigitalAccount);

    }

}
