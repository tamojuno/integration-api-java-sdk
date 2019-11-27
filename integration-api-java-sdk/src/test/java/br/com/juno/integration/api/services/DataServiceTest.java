package br.com.juno.integration.api.services;

import java.util.List;

import org.junit.jupiter.api.Test;

import br.com.juno.integration.api.model.Bank;
import br.com.juno.test.AbstractTest;

public class DataServiceTest extends AbstractTest {

    @Test
    public void testGetBanks() {
        // just to call
        List<Bank> banks = JunoApiManager.resources().data().getBanks();
        System.out.println(banks);
    }
}
