package br.com.juno.integration.api.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import br.com.juno.test.AbstractTest;

public class DigitalAccountTest extends AbstractTest {

    @Test
    public void constructors() {
        assertEquals(findOneNull(), findIncompleteObject().toString());
    }

    @Test
    public void toStringEmpty() {
        assertEquals(findOneNull(), findIncompleteObject().toString());
    }

    @Test
    public void toStringFull() {
        // NTD
        assertEquals(findOneComplete(), findCompleteObject().toString());
    }

    @Test
    public void equality() {
        // NTD
    }

    public String findOneComplete() {
        // NTD
        return "{\"id\":\"dac_9EC04E9A110A2E3D\",\"type\":\"PAYMENT\",\"status\":\"AWAITING_DOCUMENTS\",\"personType\":\"F\",\"document\":\"28600681049\",\"createdOn\":\"2021-03-15T09:27:41.306-03:00\",\"accountNumber\":10000221918}";
    }

    public String findOneNull() {
        // NTD
        return "{\"id\":null,\"type\":null,\"status\":null,\"personType\":\"\\u0000\",\"document\":null,\"createdOn\":null,\"accountNumber\":null}";
    }

    public DigitalAccount findCompleteObject() {
        // NTD
        DigitalAccount digitalAccount = new DigitalAccount();
        digitalAccount.setId("dac_9EC04E9A110A2E3D");
        digitalAccount.setType("PAYMENT");
        digitalAccount.setStatus("AWAITING_DOCUMENTS");
        digitalAccount.setPersonType('F');
        digitalAccount.setDocument("28600681049");
        digitalAccount.setCreatedOn("2021-03-15T09:27:41.306-03:00");
        //        digitalAccount.setResourceToken("BA8FA53ABE716BCC737FC0C879C2108F0871089F1DF2DCA71C5D74693867B6B4");
        digitalAccount.setAccountNumber(10000221918L);
        return digitalAccount;
    }

    public DigitalAccount findIncompleteObject() {
        // NTD
        DigitalAccount digitalAccount = new DigitalAccount();
        digitalAccount.getId();
        digitalAccount.getType();
        digitalAccount.getStatus();
        digitalAccount.getPersonType();
        digitalAccount.getDocument();
        digitalAccount.getCreatedOn();
        //        digitalAccount.getResourceToken();
        digitalAccount.getAccountNumber();
        return digitalAccount;
    }
}
