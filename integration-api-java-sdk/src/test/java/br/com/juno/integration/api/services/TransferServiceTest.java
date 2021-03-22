package br.com.juno.integration.api.services;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import br.com.juno.integration.api.model.BankAccount;
import br.com.juno.integration.api.model.BankAccountType;
import br.com.juno.integration.api.model.Transfer;
import br.com.juno.integration.api.services.request.transfer.TransferRequest;
import br.com.juno.test.AbstractServiceTest;

@Disabled
public class TransferServiceTest extends AbstractServiceTest {

    @Test
    public void transfer() {
        BankAccount bankAccount = new BankAccount();
        bankAccount.setBankNumber("260");
        bankAccount.setAgencyNumber("0001");
        bankAccount.setAccountNumber("20704584");
        bankAccount.setAccountComplementNumber("013");
        bankAccount.setAccountType(BankAccountType.CHECKING);

        TransferRequest transferRequest = new TransferRequest("BANK_ACCOUNT", "Alfredo", "09801097957", "12.00", bankAccount);
        Transfer transfer = JunoApiManager.getTransferService().createTransfer(transferRequest);
        System.out.println(transfer);
    }

    @Test
    public void transferDefaultBankAccount() {
        TransferRequest transferRequest = new TransferRequest("DEFAULT_BANK_ACCOUNT", null, null, "13.00", null);
        Transfer transfer = JunoApiManager.getTransferService().createTransfer(transferRequest);
        System.out.println(transfer);
    }

    @Test
    public void transferP2P() {
        TransferRequest transferRequest = new TransferRequest("P2P", "Alfredo Avestruz", "84317951070", "13.00",
                new BankAccount("dac_CBC7495DBB162CFB"));
        Transfer transfer = JunoApiManager.getTransferService().createTransfer(transferRequest);
        System.out.println(transfer);
    }
}
