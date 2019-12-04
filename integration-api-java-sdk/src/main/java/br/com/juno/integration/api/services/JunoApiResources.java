package br.com.juno.integration.api.services;

public final class JunoApiResources {

    public DataService getDataService() {
        return dataService;
    }

    public ChargeService getChargeService() {
        return chargeService;
    }

    public BalanceService getBalanceService() {
        return balanceService;
    }

    public DocumentService getDocumentService() {
        return documentService;
    }

    public CreditCardService getCreditCardService() {
        return creditCardService;
    }

    public BillPaymentService getBillPaymentService() {
        return billPaymentService;
    }

    public CredentialsService getCredentialsService() {
        return credentialsService;
    }

    public AuthorizationService getAuthorizationService() {
        return authorizationService;
    }

    private DataService dataService = new DataService();
    private ChargeService chargeService = new ChargeService();
    private BalanceService balanceService = new BalanceService();
    private DocumentService documentService = new DocumentService();
    private CreditCardService creditCardService = new CreditCardService();
    private BillPaymentService billPaymentService = new BillPaymentService();
    private CredentialsService credentialsService = new CredentialsService();
    private AuthorizationService authorizationService = new AuthorizationService();
}