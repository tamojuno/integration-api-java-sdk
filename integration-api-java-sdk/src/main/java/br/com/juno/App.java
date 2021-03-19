package br.com.juno;

import br.com.juno.integration.api.model.Charge;
import br.com.juno.integration.api.services.JunoApiManager;
import br.com.juno.integration.api.services.request.charge.ChargeListRequest;
import br.com.juno.integration.api.services.response.Responses;

public class App {

    public static void main(String[] args) {

        // @formatter:off
        JunoApiManager.config()
        .setClientId("JfzNWs79Mcdn6jfw")
        .setClientSecret("mh7=jU*=!@OPiNFG^n6Ug|>f7uw6;%73")
        .setResourceToken("0153B6F504FC71A0EF1EB69116010986AA4C4B2C3755F79042366E9D00B915D3")
        .sandbox();

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
        ChargeListRequest chargeListRequest = new ChargeListRequest();
        Responses<Charge> listCharges = JunoApiManager.getChargeService().list(chargeListRequest);

        listCharges.getContent().forEach(r -> System.out.println(r.getContent()));

        while (listCharges.hasNext()) {
            listCharges = JunoApiManager.getChargeService().listNextPage(listCharges);
            listCharges.getContent().forEach(r -> System.out.println(r.getContent()));
        }
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
        //
        //        List<EventType> listEventTypes = JunoApiManager.getNotificationService().listEventTypes();
        //        listEventTypes.forEach(System.out::println);
        //
        //        WebhookCreateRequest webhookCreateRequest = new WebhookCreateRequest("https://myendposssint.juno.com.br");
        //        webhookCreateRequest.getEventTypes().addAll(listEventTypes.stream().map(EventType::getName).collect(Collectors.toList()));
        //        Webhook createdWebhook = JunoApiManager.getNotificationService().createWebhook(webhookCreateRequest);
        //        System.out.println(createdWebhook);
        //
        //        WebhookUpdateRequest webhookUpdateRequest = new WebhookUpdateRequest(createdWebhook.getId());
        //        Webhook updatedWebhook = JunoApiManager.getNotificationService().updateWebhook(webhookUpdateRequest);
        //        System.out.println(updatedWebhook);
        //
        //        WebhookFindRequest webhookFindRequest = new WebhookFindRequest(createdWebhook.getId());
        //        Webhook foundWebhook = JunoApiManager.getNotificationService().findWebhook(webhookFindRequest);
        //        System.out.println(foundWebhook);
        //
        //        List<Webhook> listWebhooks = JunoApiManager.getNotificationService().listWebhooks(new WebhookListRequest());
        //        listWebhooks.forEach(System.out::println);
        //
        //        WebhookDeleteRequest webhookDeleteRequest = new WebhookDeleteRequest(createdWebhook.getId());
        //        JunoApiManager.getNotificationService().deleteWebhook(webhookDeleteRequest);
        //
        // ## Payments
        //        Address address = new PaymentCreateRequest.Billing.Address("R. Mariano Torres", "729", "Curitiba", "PR", "80060120");
        //        Billing billing = new PaymentCreateRequest.Billing("norton@juno.com.br", address);
        //        CreditCardDetails creditCardDetails = new PaymentCreateRequest.CreditCardDetails("623b7652-4fb4-4ee9-984b-e5a18f2806c0");
        //
        //        PaymentCreateRequest paymentCreateRequest = new PaymentCreateRequest("chr_D470D0CF33BB40B5", billing, creditCardDetails);
        //        PaymentTransaction paymentTransaction = JunoApiManager.getPaymentService().createPayment(paymentCreateRequest);
        //        System.out.println(paymentTransaction);

//        PaymentRefundRequest paymentRefundRequest = new PaymentRefundRequest("pay_199DAA2FC4017E3D");
//        PaymentRefundTransaction refundTransaction = JunoApiManager.getPaymentService().refundPayment(paymentRefundRequest);
//        System.out.println(refundTransaction);

    }
}
