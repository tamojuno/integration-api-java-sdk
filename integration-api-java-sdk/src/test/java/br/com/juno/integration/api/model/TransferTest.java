package br.com.juno.integration.api.model;

import static br.com.juno.test.FixtureHelper.ACCOUNT_COMPLEMENT_NUMBER;
import static br.com.juno.test.FixtureHelper.ACCOUNT_NUMBER;
import static br.com.juno.test.FixtureHelper.ACCOUNT_TYPE;
import static br.com.juno.test.FixtureHelper.AGENCY_NUMBER;
import static br.com.juno.test.FixtureHelper.BANK_NUMBER;
import static br.com.juno.test.FixtureHelper.HOLDER_DOCUMENT;
import static br.com.juno.test.FixtureHelper.HOLDER_NAME;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.math.BigDecimal;

import com.fasterxml.jackson.core.type.TypeReference;

import org.junit.jupiter.api.Test;
import org.springframework.hateoas.Resource;

import br.com.juno.integration.api.services.response.Response;
import br.com.juno.test.AbstractTest;

public class TransferTest extends AbstractTest {

    private static final String DAC_ID = "dac_56101832681175AD";
    private static final String CREATION_DATE = "2021-03-16 14:45:00";
    private static final BigDecimal AMOUNT = BigDecimal.valueOf(10.00D);
    private static final String STATUS = "REQUESTED";

    //TODO: Try improve class with refactoring
    @Test
    public void constructors() {
        Transfer transfer = new Transfer();
        assertNull(transfer.getDigitalAccountId());
        assertNull(transfer.getCreationDate());
        assertNull(transfer.getTransferDate());
        assertNull(transfer.getAmount());
        assertNull(transfer.getStatus());
        assertNull(transfer.getRecipient());

        transfer = new Transfer();
        transfer.setDigitalAccountId(DAC_ID);
        transfer.setCreationDate(CREATION_DATE);
        transfer.setTransferDate(null);
        transfer.setAmount(AMOUNT);
        transfer.setStatus(STATUS);

        Recipient recipient = new Recipient();
        recipient.setName(HOLDER_NAME);
        recipient.setDocument(HOLDER_DOCUMENT);
        BankAccount bankAccount = new BankAccount();
        bankAccount.setBankNumber(BANK_NUMBER);
        bankAccount.setAgencyNumber(AGENCY_NUMBER);
        bankAccount.setAccountNumber(ACCOUNT_NUMBER);
        bankAccount.setAccountComplementNumber(ACCOUNT_COMPLEMENT_NUMBER);
        bankAccount.setAccountType(ACCOUNT_TYPE);
        recipient.setBankAccount(bankAccount);

        transfer.setRecipient(recipient);

        assertEquals(DAC_ID, transfer.getDigitalAccountId());
        assertEquals(CREATION_DATE, transfer.getCreationDate());
        assertEquals(null, transfer.getTransferDate());
        assertEquals(AMOUNT, transfer.getAmount());
        assertEquals(STATUS, transfer.getStatus());
        assertEquals(HOLDER_NAME, transfer.getRecipient().getName());
        assertEquals(HOLDER_DOCUMENT, transfer.getRecipient().getDocument());
        assertEquals(BANK_NUMBER, transfer.getRecipient().getBankAccount().getBankNumber());
        assertEquals(AGENCY_NUMBER, transfer.getRecipient().getBankAccount().getAgencyNumber());
        assertEquals(ACCOUNT_NUMBER, transfer.getRecipient().getBankAccount().getAccountNumber());
        assertEquals(ACCOUNT_COMPLEMENT_NUMBER, transfer.getRecipient().getBankAccount().getAccountComplementNumber());
        assertEquals(ACCOUNT_TYPE, transfer.getRecipient().getBankAccount().getAccountType());
    }

    @Test
    public void toStringComplete() {
        Transfer transfer = new Transfer();
        transfer.setDigitalAccountId(DAC_ID);
        transfer.setCreationDate(CREATION_DATE);
        transfer.setTransferDate(null);
        transfer.setAmount(AMOUNT);
        transfer.setStatus(STATUS);
        Recipient recipient = new Recipient();
        recipient.setName(HOLDER_NAME);
        recipient.setDocument(HOLDER_DOCUMENT);
        transfer.setRecipient(recipient);
        BankAccount bankAccount = new BankAccount();
        bankAccount.setBankNumber(BANK_NUMBER);
        bankAccount.setAgencyNumber(AGENCY_NUMBER);
        bankAccount.setAccountNumber(ACCOUNT_NUMBER);
        bankAccount.setAccountComplementNumber(ACCOUNT_COMPLEMENT_NUMBER);
        bankAccount.setAccountType(ACCOUNT_TYPE);
        recipient.setBankAccount(bankAccount);

        assertEquals(
                "Transfer[<null>,dac_56101832681175AD,2021-03-16 14:45:00,<null>,10.0,REQUESTED,Recipient[John Doe,06085371950,BankAccount[104,4252,10000224836,013,CHECKING]]]",
                transfer.toString());
    }

    @Test
    public void toStringEmpty() {
        Transfer transfer = new Transfer();
        assertEquals("Transfer[<null>,<null>,<null>,<null>,<null>,<null>,<null>]", transfer.toString());
    }

    //TODO: create equality test

    @Test
    public void jsonToObject() throws Exception {
        Response<Transfer> res = new Response<>(getObjectMapper().readValue(findOne(), new TypeReference<Resource<Transfer>>() {
            // NTD
        }));

        assertEquals(null, res.getHrefSelf());

        Transfer transfer = res.getContent();

        assertEquals(DAC_ID, transfer.getDigitalAccountId());
        assertEquals(CREATION_DATE, transfer.getCreationDate());
        assertEquals(null, transfer.getTransferDate());
        assertEquals(AMOUNT, transfer.getAmount());
        assertEquals(STATUS, transfer.getStatus());
        assertEquals(HOLDER_NAME, transfer.getRecipient().getName());
        assertEquals(HOLDER_DOCUMENT, transfer.getRecipient().getDocument());
        assertEquals(BANK_NUMBER, transfer.getRecipient().getBankAccount().getBankNumber());
        assertEquals(AGENCY_NUMBER, transfer.getRecipient().getBankAccount().getAgencyNumber());
        assertEquals(ACCOUNT_NUMBER, transfer.getRecipient().getBankAccount().getAccountNumber());
        assertEquals(ACCOUNT_COMPLEMENT_NUMBER, transfer.getRecipient().getBankAccount().getAccountComplementNumber());
        assertEquals(ACCOUNT_TYPE, transfer.getRecipient().getBankAccount().getAccountType());
    }

    private String findOne() {
        return "{\"id\":\"trf_063FB7C442D863AF\",\"digitalAccountId\":\"dac_56101832681175AD\",\"creationDate\":\"2021-03-16 14:45:00\",\"transferDate\":null,\"amount\":10.0,\"status\":\"REQUESTED\",\"recipient\":{\"name\":\"John Doe\",\"document\":\"06085371950\",\"bankAccount\":{\"bankNumber\":\"104\",\"agencyNumber\":\"4252\",\"accountNumber\":\"10000224836\",\"accountComplementNumber\":\"013\",\"accountType\":\"CHECKING\"}}}";
    }

}
