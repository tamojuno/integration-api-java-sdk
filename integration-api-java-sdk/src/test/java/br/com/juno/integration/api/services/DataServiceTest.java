package br.com.juno.integration.api.services;

import java.util.List;

import org.junit.jupiter.api.Test;

import br.com.juno.integration.api.model.Bank;
import br.com.juno.integration.api.model.BusinessArea;
import br.com.juno.integration.api.model.CompanyType;
import br.com.juno.test.AbstractTest;

public class DataServiceTest extends AbstractTest {

    @Test
    public void testGetBanks() {
        List<Bank> banks = JunoApiManager.getDataService().getBanks();
        System.out.println(banks);
    }

    @Test
    public void testCompanyTypes() {
        List<CompanyType> companyType = JunoApiManager.getDataService().getCompanyTypes();
        System.out.println(companyType);
    }

    @Test
    public void testBusinessArea() {
        List<BusinessArea> businessArea = JunoApiManager.getDataService().getBusinessAreas();
        System.out.println(businessArea);
    }
}
