package br.com.juno;

import br.com.juno.integration.api.model.Charge;
import br.com.juno.integration.api.services.ChargeService.ChargeListBuilder.OrderBy;
import br.com.juno.integration.api.services.JunoApiManager;
import br.com.juno.integration.api.utils.Responses;

public class App {

    public static void main(String[] args) {

        JunoApiManager.config() //
                .clientId("iH3Um6mPrlNNT98S") //
                .clientSecret("e!LCWcO<EAxq){:EZejRv4XATAt^hU9M") //
                .resourceToken("37013DDF21B83FFCA8AA6AF8912A9FBC91E5765DA991873CA407FA8CAFF22BB0"); //

        //        Balance balance1 = JunoApiManager.resources().balance().get();
        //        Balance balance2 = JunoApiManager.resources().balance().get("37013DDF21B83FFCA8AA6AF8912A9FBC91E5765DA991873CA407FA8CAFF22BB0");

        Responses<Charge> charges = JunoApiManager.resources().charges().list()//
                //                .createdOnStart(null) //
                //                .createdOnEnd(null) //
                //                .dueDateStart(null) //
                //                .dueDateEnd(null) //
                //                .paymentDateStart(null) //
                //                .paymentDateEnd(null) //
                //                .showUnarchived(false) //
                //                .showArchived(false) //
                //                .showDue(false) //
                //                .showNotDue(false) //
                .showPaid(true) //
                //                .showNotPaid(false) //
                //                .showCancelled(false) //
                //                .showNotCancelled(false) //
                //                .showManualReconciliation(false) //
                //                .showNotManualReconciliation(false) //
                //                .showNotFailed(false) //
                .orderBy(OrderBy.AMOUNT) //
                //                .orderAsc(false) //
                //                .pageSize(20)//
                .get(); //

        charges.getContent().forEach(r -> System.out.println(r.getContent()));

        while (charges.hasNext()) {
            charges = JunoApiManager.resources().charges().list().getNextPage(charges);
            charges.getContent().forEach(r -> System.out.println(r.getContent()));
        }

        //        List<Bank> banks = JunoApiManager.resources().data().getBanks();
        //        List<CompanyType> companyTypes = JunoApiManager.resources().data().getCompanyTypes();
        //        List<BusinessArea> businessArea = JunoApiManager.resources().data().getBusinessAreas();
        //
        //        System.out.println(balance1);
        //        System.out.println(balance2);
        //        System.out.println(banks);
        //        System.out.println(companyTypes);
        //        System.out.println(businessArea);
    }
}
