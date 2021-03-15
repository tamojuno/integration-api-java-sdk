package br.com.juno.integration.api.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import br.com.juno.test.AbstractTest;

public class BankAccountHolderTest extends AbstractTest {

    @Test
    public void constructors() {
        BankAccountHolder accountHolder = findCompleteObject();
        assertEquals(findOne(), accountHolder.toString());
        accountHolder = findIncompleteObject();
        assertEquals(findOneNull(), accountHolder.toString());

        BankAccountHolder accountHolderSecondary = new BankAccountHolder(HOLDER_NAME, HOLDER_CPF);
        assertEquals(findOne(), accountHolderSecondary.toString());
        accountHolderSecondary = new BankAccountHolder(null, null);
        assertEquals(findOneNull(), accountHolderSecondary.toString());

    }

    public void toStringEmpty() {
        BankAccountHolder accountHolder = findIncompleteObject();
        assertEquals(findOneNull(), accountHolder.toString());
    }

    public void toStringFull() {
        BankAccountHolder accountHolder = findCompleteObject();
        assertEquals(findOne(), accountHolder.toString());
    }

    public void equality() {
        // NTD
    }

    public String findOne() {
        // NTD
        return "{\"name\":\"John Doe\",\"document\":\"06085371950\"}";
    }

    public String findOneNull() {
        // NTD
        return "{\"name\":null,\"document\":null}";
    }

    public BankAccountHolder findCompleteObject() {
        BankAccountHolder accountHolder = new BankAccountHolder();
        accountHolder.setName(HOLDER_NAME);
        accountHolder.setDocument(HOLDER_CPF);
        return accountHolder;
    }

    public BankAccountHolder findIncompleteObject() {
        BankAccountHolder accountHolder = new BankAccountHolder();
        accountHolder.getName();
        accountHolder.getDocument();
        return accountHolder;
    }
}
