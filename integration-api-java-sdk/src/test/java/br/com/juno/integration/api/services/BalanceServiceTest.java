package br.com.juno.integration.api.services;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

import br.com.juno.integration.api.model.Balance;
import br.com.juno.integration.api.services.request.balance.GetBalanceRequest;
import br.com.juno.test.AbstractServiceTest;

public class BalanceServiceTest extends AbstractServiceTest {

    @Test
    public void getBalance() {
        GetBalanceRequest request = new GetBalanceRequest();

        mockServer().expectBalance();

        Balance getBalance = JunoApiManager.getBalanceService().getBalance(request);

        assertEquals(BigDecimal.valueOf(35840.87), getBalance.getBalance());
        assertEquals(BigDecimal.valueOf(1575.50).setScale(2), getBalance.getWithheldBalance());
        assertEquals(BigDecimal.valueOf(34265.37), getBalance.getTransferableBalance());

    }
}
