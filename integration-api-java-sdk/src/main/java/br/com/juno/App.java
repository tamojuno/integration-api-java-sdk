package br.com.juno;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import br.com.juno.integration.api.model.Balance;
import br.com.juno.integration.api.model.Bank;
import br.com.juno.integration.api.model.BusinessArea;
import br.com.juno.integration.api.model.Charge;
import br.com.juno.integration.api.model.CompanyType;
import br.com.juno.integration.api.services.JunoApiManager;
import br.com.juno.integration.api.services.request.balance.GetBalanceRequest;
import br.com.juno.integration.api.services.request.charge.ChargeCreateRequest;
import br.com.juno.integration.api.services.request.charge.ChargeCreateRequest.Charge.PaymentType;
import br.com.juno.integration.api.services.request.charge.ChargeListRequest;
import br.com.juno.integration.api.services.response.Responses;

public class App {

    public static void main(String[] args) {

        // @formatter:off
        JunoApiManager.config()
                .clientId("iH3Um6mPrlNNT98S")
                .clientSecret("e!LCWcO<EAxq){:EZejRv4XATAt^hU9M")
                .resourceToken("37013DDF21B83FFCA8AA6AF8912A9FBC91E5765DA991873CA407FA8CAFF22BB0");
        // @formatter:on

        // @formatter:off
        ChargeCreateRequest.Billing billing = new ChargeCreateRequest.Billing();
        ChargeCreateRequest.Charge charge = new ChargeCreateRequest.Charge("First Charge using SDK :)");

        charge.setAmount(BigDecimal.valueOf(50D));
        charge.setDueDate(LocalDate.now().plusDays(5));
        charge.setInstallments(3);
        charge.getReferences().addAll(Arrays.asList("ref1", "ref2", "ref3"));
        charge.getPaymentTypes().addAll(new HashSet<>(Arrays.asList(PaymentType.BOLETO, PaymentType.CREDIT_CARD)));

        billing.setName("Norton");
        billing.setDocument("25238016042");
        billing.setEmail("norton@juno.com.br");
        billing.setPhone("41999999999");

        ChargeCreateRequest createChargeRequest = new ChargeCreateRequest(charge, billing);

        List<Charge> createdCharges = JunoApiManager.getChargeService().create(createChargeRequest);

        createdCharges.forEach(System.out::println);
        // @formatter:on

        // @formatter:off
        ChargeListRequest chargeListRequest = new ChargeListRequest();
        Responses<Charge> listCharges = JunoApiManager.getChargeService().list(chargeListRequest);

        listCharges.getContent().forEach(r -> System.out.println(r.getContent()));

        while (listCharges.hasNext()) {
            listCharges = JunoApiManager.getChargeService().listNextPage(listCharges);
            listCharges.getContent().forEach(r -> System.out.println(r.getContent()));
        }
        // @formatter:on

        Balance balance = JunoApiManager.getBalanceService().getBalance(new GetBalanceRequest());
        System.out.println(balance);

        List<Bank> banks = JunoApiManager.getDataService().getBanks();
        System.out.println(banks);

        List<CompanyType> companyTypes = JunoApiManager.getDataService().getCompanyTypes();
        System.out.println(companyTypes);

        List<BusinessArea> businessArea = JunoApiManager.getDataService().getBusinessAreas();
        System.out.println(businessArea);
    }
}
