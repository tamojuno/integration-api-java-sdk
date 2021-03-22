package br.com.juno.integration.api.model;

import static br.com.juno.test.FixtureHelper.ACCOUNT_COMPLEMENT_NUMBER;
import static br.com.juno.test.FixtureHelper.ACCOUNT_NUMBER;
import static br.com.juno.test.FixtureHelper.ACCOUNT_TYPE;
import static br.com.juno.test.FixtureHelper.AGENCY_NUMBER;
import static br.com.juno.test.FixtureHelper.BANK_NUMBER;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import com.fasterxml.jackson.core.type.TypeReference;

import org.junit.jupiter.api.Test;
import org.springframework.hateoas.Resource;

import br.com.juno.integration.api.services.response.Response;
import br.com.juno.test.AbstractTest;

public class BankAccountTest extends AbstractTest {

    @Test
    public void constructors() {
        BankAccount bankAccount = new BankAccount();
        assertNull(bankAccount.getBankNumber());
        assertNull(bankAccount.getAgencyNumber());
        assertNull(bankAccount.getAccountNumber());
        assertNull(bankAccount.getAccountComplementNumber());
        assertNull(bankAccount.getAccountType());

        bankAccount = new BankAccount();
        bankAccount.setBankNumber(BANK_NUMBER);
        bankAccount.setAgencyNumber(AGENCY_NUMBER);
        bankAccount.setAccountNumber(ACCOUNT_NUMBER);
        bankAccount.setAccountComplementNumber(ACCOUNT_COMPLEMENT_NUMBER);
        bankAccount.setAccountType(ACCOUNT_TYPE);

        assertEquals(BANK_NUMBER, bankAccount.getBankNumber());
        assertEquals(AGENCY_NUMBER, bankAccount.getAgencyNumber());
        assertEquals(ACCOUNT_NUMBER, bankAccount.getAccountNumber());
        assertEquals(ACCOUNT_COMPLEMENT_NUMBER, bankAccount.getAccountComplementNumber());
        assertEquals(ACCOUNT_TYPE, bankAccount.getAccountType());
    }

    @Test
    public void toStringComplete() {
        BankAccount bankAccount = new BankAccount();
        bankAccount.setBankNumber(BANK_NUMBER);
        bankAccount.setAgencyNumber(AGENCY_NUMBER);
        bankAccount.setAccountNumber(ACCOUNT_NUMBER);
        bankAccount.setAccountComplementNumber(ACCOUNT_COMPLEMENT_NUMBER);
        bankAccount.setAccountType(ACCOUNT_TYPE);
        assertEquals("BankAccount[104,4252,10000224836,013,CHECKING]", bankAccount.toString());
    }

    @Test
    public void toStringEmpty() {
        BankAccount bankAccount = new BankAccount();
        assertEquals("BankAccount[<null>,<null>,<null>,<null>,<null>]", bankAccount.toString());
    }

    //TODO: create equality test

    @Test
    public void jsonToObject() throws Exception {
        Response<BankAccount> res = new Response<>(getObjectMapper().readValue(findOne(), new TypeReference<Resource<BankAccount>>() {
            // NTD
        }));

        assertEquals(null, res.getHrefSelf());

        BankAccount bankAccount = res.getContent();

        assertEquals(BANK_NUMBER, bankAccount.getBankNumber());
        assertEquals(AGENCY_NUMBER, bankAccount.getAgencyNumber());
        assertEquals(ACCOUNT_NUMBER, bankAccount.getAccountNumber());
        assertEquals(ACCOUNT_COMPLEMENT_NUMBER, bankAccount.getAccountComplementNumber());
        assertEquals(ACCOUNT_TYPE, bankAccount.getAccountType());
    }

    private String findOne() {
        return "{\"bankNumber\":\"104\",\"agencyNumber\":\"4252\",\"accountNumber\":\"10000224836\",\"accountComplementNumber\":\"013\",\"accountType\":\"CHECKING\"}";
    }

}
