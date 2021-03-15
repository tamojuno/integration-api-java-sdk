package br.com.juno.integration.api.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

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

        bankAccount = new BankAccount(null, null, ACCOUNT_NUMBER, null, null);
        assertEquals(null, bankAccount.getBankNumber());
        assertEquals(null, bankAccount.getAgencyNumber());
        assertEquals(ACCOUNT_NUMBER, bankAccount.getAccountNumber());
        assertEquals(null, bankAccount.getAccountComplementNumber());
        assertEquals(null, bankAccount.getAccountType());

    }

    @Test
    public void p2pConstructor() {
        BankAccount bankAccount = new BankAccount();
        assertNull(bankAccount.getAccountNumber());
        bankAccount = new BankAccount(null, null, ACCOUNT_NUMBER, null, null);
        assertEquals(ACCOUNT_NUMBER, bankAccount.getAccountNumber());
    }

    @Test
    public void hasNotBankHolderConstructor() {
        BankAccount bankAccount = new BankAccount(BANK_NUMBER, AGENCY_NUMBER, ACCOUNT_NUMBER, ACCOUNT_COMPLEMENT_NUMBER, ACCOUNT_TYPE);
        assertEquals(BANK_NUMBER, bankAccount.getBankNumber());
        assertEquals(AGENCY_NUMBER, bankAccount.getAgencyNumber());
        assertEquals(ACCOUNT_NUMBER, bankAccount.getAccountNumber());
        assertEquals(ACCOUNT_COMPLEMENT_NUMBER, bankAccount.getAccountComplementNumber());
        assertEquals(ACCOUNT_TYPE, bankAccount.getAccountType());
    }

    @Test
    public void isBankAccountCaixa() {
        BankAccount bankAccount = new BankAccount(BANK_NUMBER, AGENCY_NUMBER, ACCOUNT_NUMBER, ACCOUNT_COMPLEMENT_NUMBER, ACCOUNT_TYPE);
        assertTrue(bankAccount.isCaixa());
        assertFalse(!bankAccount.isCaixa());
    }

    @Test
    public void isBankAccountP2P() {
        BankAccount bankAccount = new BankAccount(null, null, ACCOUNT_NUMBER, null, ACCOUNT_TYPE);
        assertTrue(bankAccount.isP2P());
        assertFalse(!bankAccount.isP2P());
    }

    //TODO: Refactor this hole test
    @Test
    public void toStringEmpty() {
        BankAccount bankAccount = new BankAccount();
        assertEquals(getOneBankAccount(), bankAccount.toString());
    }

    private String getOneBankAccount() {
        return "{\"bankNumber\": \"104\",\"agencyNumber\": \"4562\",\"accountNumber\": \"0065696-8\",\"accountType\": \"CHECKING\",\"accountComplementNumber\":\"013\"}";
    }

}
