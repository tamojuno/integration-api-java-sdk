package br.com.juno;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import br.com.juno.integration.api.model.Document;
import br.com.juno.integration.api.services.JunoApiManager;
import br.com.juno.integration.api.services.request.document.DocumentUploadRequest;

public class App {

    public static void main(String[] args) throws IOException {

        // @formatter:off
        JunoApiManager.config()
            .clientId("iH3Um6mPrlNNT98S")
            .clientSecret("e!LCWcO<EAxq){:EZejRv4XATAt^hU9M")
            .resourceToken("37013DDF21B83FFCA8AA6AF8912A9FBC91E5765DA991873CA407FA8CAFF22BB0");
        // @formatter:on

        // @formatter:off
        //
        // ## Charges
        //        ChargeCreateRequest.Billing billing = new ChargeCreateRequest.Billing();
        //        ChargeCreateRequest.Charge charge = new ChargeCreateRequest.Charge("First Charge using SDK :)");
        //
        //        charge.setAmount(BigDecimal.valueOf(50D));
        //        charge.setDueDate(LocalDate.now().plusDays(5));
        //        charge.setInstallments(3);
        //        charge.getReferences().addAll(Arrays.asList("ref1", "ref2", "ref3"));
        //        charge.getPaymentTypes().addAll(new HashSet<>(Arrays.asList(PaymentType.BOLETO, PaymentType.CREDIT_CARD)));
        //
        //        billing.setName("Norton");
        //        billing.setDocument("25238016042");
        //        billing.setEmail("norton@juno.com.br");
        //        billing.setPhone("41999999999");
        //
        //        ChargeCreateRequest createChargeRequest = new ChargeCreateRequest(charge, billing);
        //
        //        List<Charge> createdCharges = JunoApiManager.getChargeService().create(createChargeRequest);
        //
        //        createdCharges.forEach(System.out::println);
        //        // @formatter:on
        //
        //        // @formatter:off
        //        ChargeListRequest chargeListRequest = new ChargeListRequest();
        //        Responses<Charge> listCharges = JunoApiManager.getChargeService().list(chargeListRequest);
        //
        //        listCharges.getContent().forEach(r -> System.out.println(r.getContent()));
        //
        //        while (listCharges.hasNext()) {
        //            listCharges = JunoApiManager.getChargeService().listNextPage(listCharges);
        //            listCharges.getContent().forEach(r -> System.out.println(r.getContent()));
        //        }
        //        // @formatter:on
        //

        // ## Balance
        //        Balance balance = JunoApiManager.getBalanceService().getBalance(new GetBalanceRequest());
        //        System.out.println(balance);

        // ## Data
        //        List<Bank> banks = JunoApiManager.getDataService().getBanks();
        //        System.out.println(banks);
        //
        //        List<CompanyType> companyTypes = JunoApiManager.getDataService().getCompanyTypes();
        //        System.out.println(companyTypes);
        //
        //        List<BusinessArea> businessArea = JunoApiManager.getDataService().getBusinessAreas();
        //        System.out.println(businessArea);

        // ## Credentials
        //        JunoPublicKey junoPublicKey = JunoApiManager.getCredentialsService().getPublicCredentials(new CredentialsRequest());
        //
        //        System.out.println(junoPublicKey.getKey());
        //        System.out.println(junoPublicKey.getPublicKey());

        // ## Documents
        //        Document document = JunoApiManager.getDocumentService().getDocument(new DocumentGetRequest("doc_8FBC3EA2276EB79F"));
        //        System.out.println(document);

        //        List<Document> documents = JunoApiManager.getDocumentService().listDocument(new DocumentListRequest());
        //        documents.forEach(System.out::println);

        DocumentUploadRequest documentRequest = new DocumentUploadRequest("doc_8FBC3EA2276EB79F");
        documentRequest.getFiles().add(Files.newInputStream(Paths.get("/Users/norton.gueno/Downloads/some_serious_document.pdf")));

        Document document = JunoApiManager.getDocumentService().uploadDocument(documentRequest);
        System.out.println(document);
    }
}
