package br.com.juno.integration.api.services;

public final class JunoApiResources {

    public DataService data() {
        return dataService;
    }

    public BalanceService balance() {
        return balanceService;
    }

    public AuthorizationService authorization() {
        return authorizationService;
    }

    private DataService dataService = new DataService();
    private BalanceService balanceService = new BalanceService();
    private AuthorizationService authorizationService = new AuthorizationService();
}
