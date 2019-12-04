package br.com.juno;

import java.util.Arrays;
import java.util.List;

import br.com.juno.integration.api.model.EventType;
import br.com.juno.integration.api.model.Webhook;
import br.com.juno.integration.api.services.JunoApiManager;
import br.com.juno.integration.api.services.request.notification.webhook.WebhookCreateRequest;
import br.com.juno.integration.api.services.request.notification.webhook.WebhookDeleteRequest;
import br.com.juno.integration.api.services.request.notification.webhook.WebhookFindRequest;
import br.com.juno.integration.api.services.request.notification.webhook.WebhookListRequest;
import br.com.juno.integration.api.services.request.notification.webhook.WebhookUpdateRequest;

public class App {

    public static void main(String[] args) {

        // @formatter:off
        JunoApiManager.config()
        // Sandbox
//            .clientId("iH3Um6mPrlNNT98S")
//            .clientSecret("e!LCWcO<EAxq){:EZejRv4XATAt^hU9M")
//            .resourceToken("37013DDF21B83FFCA8AA6AF8912A9FBC91E5765DA991873CA407FA8CAFF22BB0")
        // Local
            .clientId("X8I5PuJeD7AmgV1Q")
            .clientSecret("h|4KY73vf7ntn|:f4PAox@-^86QebA|s")
            .resourceToken("E3759A771310324A266F7B742FF0A44D48A29D7690614D8C")
            .publicToken("CB1DA65A0AFDE882DB9AFFB598CE5DA6CF872195C2332724B22ECC8D075350C0")
            .development();
        // @formatter:on

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
        //
        //        ChargeListRequest chargeListRequest = new ChargeListRequest();
        //        Responses<Charge> listCharges = JunoApiManager.getChargeService().list(chargeListRequest);
        //
        //        listCharges.getContent().forEach(r -> System.out.println(r.getContent()));
        //
        //        while (listCharges.hasNext()) {
        //            listCharges = JunoApiManager.getChargeService().listNextPage(listCharges);
        //            listCharges.getContent().forEach(r -> System.out.println(r.getContent()));
        //        }
        //
        //        // ## Balance
        //        Balance balance = JunoApiManager.getBalanceService().getBalance(new GetBalanceRequest());
        //        System.out.println(balance);
        //
        //        // ## Data
        //        List<Bank> banks = JunoApiManager.getDataService().getBanks();
        //        System.out.println(banks);
        //
        //        List<CompanyType> companyTypes = JunoApiManager.getDataService().getCompanyTypes();
        //        System.out.println(companyTypes);
        //
        //        List<BusinessArea> businessArea = JunoApiManager.getDataService().getBusinessAreas();
        //        System.out.println(businessArea);
        //
        //        // ## Credentials
        //        JunoPublicKey junoPublicKey = JunoApiManager.getCredentialsService().getPublicCredentials(new CredentialsRequest());
        //
        //        System.out.println(junoPublicKey.getKey());
        //        System.out.println(junoPublicKey.getPublicKey());
        //
        //        // ## Documents
        //        Document findDocumentResponse = JunoApiManager.getDocumentService().getDocument(new DocumentGetRequest("doc_8FBC3EA2276EB79F"));
        //        System.out.println(findDocumentResponse);
        //
        //        List<Document> listDocumentsResponse = JunoApiManager.getDocumentService().listDocument(new DocumentListRequest());
        //        listDocumentsResponse.forEach(System.out::println);
        //
        //        DocumentUploadRequest documentUploadUsingFileRequest = new DocumentUploadRequest("doc_8FBC3EA2276EB79F");
        //        documentUploadUsingFileRequest.getFiles().add(new JunoFile(new File("/Users/norton.gueno/Downloads/some_serious_document.pdf")));
        //
        //        Document documentUploadUsingFileResponse = JunoApiManager.getDocumentService().uploadDocument(documentUploadUsingFileRequest);
        //        System.out.println(documentUploadUsingFileResponse);
        //
        //        DocumentUploadRequest documentUploadUsingStreamsRequest = new DocumentUploadRequest("doc_3E281CC784AE799D");
        //        documentUploadUsingStreamsRequest.getFiles().add(new JunoFile(
        //                Files.newInputStream(Paths.get("/Users/norton.gueno/Downloads/some_serious_document.pdf")), "some_serious_document.pdf"));
        //
        //        Document documentUploadUsingStreamsResponse = JunoApiManager.getDocumentService().uploadDocument(documentUploadUsingStreamsRequest);
        //        System.out.println(documentUploadUsingStreamsResponse);
        //
        //        DocumentUploadEncryptedRequest documentUploadEncryptedRequest = new DocumentUploadEncryptedRequest("doc_3E281CC784AE799D", new JunoFile(
        //                Files.newInputStream(Paths.get("/Users/norton.gueno/Downloads/some_serious_document.pdf")), "some_serious_document.pdf"));
        //        Document documentUploadEncryptedResponse = JunoApiManager.getDocumentService().uploadDocumentAsEncripted(documentUploadEncryptedRequest);
        //        System.out.println(documentUploadEncryptedResponse);
        //
        //        // ## Credit Cards
        //        CreditCardTokenizationRequest cardTokenizationRequest = new CreditCardTokenizationRequest("7fc59d5cca80b7f4a8a3442dfe18c8b764366e95");
        //        TokenizedCreditCard tokenizedCreditCard = JunoApiManager.getCreditCardService().tokenize(cardTokenizationRequest);
        //        System.out.println(tokenizedCreditCard);
        //
        //        // ## Bill Payments
        //        RegisterBillPaymentRequest billPaymentRequest = new RegisterBillPaymentRequest("96645892098", //
        //                BigDecimal.valueOf(134.73D), //
        //                LocalDate.of(2019, 12, 25), //
        //                "23793381286001335752494000063308880630000005000", //
        //                BigDecimal.valueOf(134.73D), //
        //                LocalDate.now()); //
        //
        //        BillPayment billPayment = JunoApiManager.getBillPaymentService().registerBillPayment(billPaymentRequest);
        //        System.out.println(billPayment);
        //
        // ## Notifications

        List<EventType> listEventTypes = JunoApiManager.getNotificationService().listEventTypes();
        listEventTypes.forEach(System.out::println);

        WebhookCreateRequest webhookCreateRequest = new WebhookCreateRequest("https://myendpoint.juno.com.br");
        webhookCreateRequest.getEventTypes().addAll(Arrays.asList("PAYMENT_NOTIFICATION", "CHARGE_STATUS_CHANGED", "BILL_PAYMENT_STATUS_CHANGED"));
        Webhook createdWebhook = JunoApiManager.getNotificationService().createWebhook(webhookCreateRequest);
        System.out.println(createdWebhook);

        WebhookUpdateRequest webhookUpdateRequest = new WebhookUpdateRequest("wbh_C5F07F3F835CDAF6");
        Webhook updatedWebhook = JunoApiManager.getNotificationService().updateWebhook(webhookUpdateRequest);
        System.out.println(updatedWebhook);

        WebhookFindRequest webhookFindRequest = new WebhookFindRequest("wbh_C5F07F3F835CDAF6");
        Webhook foundWebhook = JunoApiManager.getNotificationService().findWebhook(webhookFindRequest);
        System.out.println(foundWebhook);

        List<Webhook> listWebhooks = JunoApiManager.getNotificationService().listWebhooks(new WebhookListRequest());
        listWebhooks.forEach(System.out::println);

        WebhookDeleteRequest webhookDeleteRequest = new WebhookDeleteRequest("wbh_C5F07F3F835CDAF6");
        JunoApiManager.getNotificationService().deleteWebhook(webhookDeleteRequest);

    }
}
