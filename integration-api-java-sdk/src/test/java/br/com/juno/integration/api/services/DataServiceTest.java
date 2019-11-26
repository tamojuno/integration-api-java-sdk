package br.com.juno.integration.api.services;

import java.util.List;

import org.junit.jupiter.api.Test;

import br.com.juno.integration.api.model.Bank;

public class DataServiceTest {

    @Test
    public void testGetBanks() throws Exception {
        // just to call
        ApiManager.initialize("8hKM1sGxo963Zego", "Yb#2(i;X<owxphN{M1Iy_BFTDc,4?1ok", "resourceToken");
        List<Bank> banks = ApiManager.getInstance().getDataService().getBanks();
        System.out.println(banks);
    }
}
