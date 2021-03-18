package br.com.juno.integration.api.services;

import org.junit.jupiter.api.Test;

import br.com.juno.integration.api.model.Balance;
import br.com.juno.integration.api.services.request.balance.GetBalanceRequest;
import br.com.juno.test.AbstractTest;

public class BalanceServiceTest extends AbstractTest {

    @Test
    public void getBalance() {
        Balance balance = JunoApiManager.getBalanceService().getBalance(new GetBalanceRequest());
        System.out.println(balance);
    }
}
