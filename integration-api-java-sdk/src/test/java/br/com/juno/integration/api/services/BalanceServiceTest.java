package br.com.juno.integration.api.services;

import org.junit.jupiter.api.Test;

import br.com.juno.integration.api.model.Balance;
import br.com.juno.integration.api.services.request.balance.GetBalanceRequest;
import br.com.juno.test.AbstractTest;

public class BalanceServiceTest extends AbstractTest {

    @Test
    public void testGetBalance() {

        //TODO: check possible initialize method change
        JunoApiManager.config().setClientId("JfzNWs79Mcdn6jfw").setClientSecret("mh7=jU*=!@OPiNFG^n6Ug|>f7uw6;%73").setResourceToken(
                "0153B6F504FC71A0EF1EB69116010986AA4C4B2C3755F79042366E9D00B915D3").sandbox();

        Balance balance = JunoApiManager.getBalanceService().getBalance(new GetBalanceRequest());
        System.out.println(balance);
    }
}
