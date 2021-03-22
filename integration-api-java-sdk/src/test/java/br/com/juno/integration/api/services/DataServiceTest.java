package br.com.juno.integration.api.services;

import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import br.com.juno.integration.api.model.Bank;
import br.com.juno.integration.api.model.BusinessArea;
import br.com.juno.integration.api.model.CompanyType;
import br.com.juno.test.AbstractServiceTest;

@Disabled
public class DataServiceTest extends AbstractServiceTest {

    @Test
    public void getBanks() {
        List<Bank> banks = JunoApiManager.getDataService().getBanks();
        System.out.println(banks);
    }

    @Test
    public void companyTypes() {
        List<CompanyType> companyType = JunoApiManager.getDataService().getCompanyTypes();
        System.out.println(companyType);
    }

    @Test
    public void businessArea() {
        List<BusinessArea> businessArea = JunoApiManager.getDataService().getBusinessAreas();
        System.out.println(businessArea);
    }
}
