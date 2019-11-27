package br.com.juno.integration.api.services;

public final class JunoApiResources {

    public DataService data() {
        return dataService;
    }

    public ChargeService charges() {
        return chargeService;
    }

    public BalanceService balance() {
        return balanceService;
    }

    public AuthorizationService authorization() {
        return authorizationService;
    }

    private DataService dataService = new DataService();
    private ChargeService chargeService = new ChargeService();
    private BalanceService balanceService = new BalanceService();
    private AuthorizationService authorizationService = new AuthorizationService();
}
