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

    public CredentialsService getCredentialsService() {
        return credentialsService;
    }

    public AuthorizationService getAuthorizationService() {
        return authorizationService;
    }

    public DocumentService getDocumentService() {
        return documentService;
    }

    private DataService dataService = new DataService();
    private ChargeService chargeService = new ChargeService();
    private BalanceService balanceService = new BalanceService();
    private DocumentService documentService = new DocumentService();
    private CredentialsService credentialsService = new CredentialsService();
    private AuthorizationService authorizationService = new AuthorizationService();
    private DocumentService documentService = new DocumentService();
}