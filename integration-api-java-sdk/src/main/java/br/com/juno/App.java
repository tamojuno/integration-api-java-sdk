package br.com.juno;

import java.util.List;

import br.com.juno.integration.api.model.Balance;
import br.com.juno.integration.api.model.Bank;
import br.com.juno.integration.api.model.BusinessArea;
import br.com.juno.integration.api.model.CompanyType;
import br.com.juno.integration.api.services.JunoApiManager;

public class App {

    public static void main(String[] args) {

        JunoApiManager.config() //
                .clientId("iH3Um6mPrlNNT98S") //
                .clientSecret("e!LCWcO<EAxq){:EZejRv4XATAt^hU9M") //
                .resourceToken("37013DDF21B83FFCA8AA6AF8912A9FBC91E5765DA991873CA407FA8CAFF22BB0"); //

        Balance balance1 = JunoApiManager.resources().balance().get();
        Balance balance2 = JunoApiManager.resources().balance().get("37013DDF21B83FFCA8AA6AF8912A9FBC91E5765DA991873CA407FA8CAFF22BB0");
        List<Bank> banks = JunoApiManager.resources().data().banks();
        List<CompanyType> companyTypes = JunoApiManager.resources().data().companyTypes();
        List<BusinessArea> businessArea = JunoApiManager.resources().data().businessAreas();

        System.out.println(balance1);
        System.out.println(balance2);
        System.out.println(banks);
        System.out.println(companyTypes);
        System.out.println(businessArea);
    }
}
