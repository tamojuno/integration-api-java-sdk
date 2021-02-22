package br.com.juno.integration.api.services;

public final class JunoApiResources {
	
	public PixService getPixService() {
		return pixService;
	}

    public DataService getDataService() {
        return dataService;
    }
    
    public SubscriptionService getSubscriptionService() {
    	return subscriptionService;
    }
    
    public PlanService getPlanService() {
    	return planService;
    }

    public ChargeService getChargeService() {
        return chargeService;
    }
    
    public PicpayService getPicpayService() {
    	return picpayService;
    }

    public BalanceService getBalanceService() {
        return balanceService;
    }

    public PaymentService getPaymentService() {
        return paymentService;
    }

    public DocumentService getDocumentService() {
        return documentService;
    }

    public TransferService getTransferService() {
        return transferService;
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

    public NotificationService getNotificationService() {
        return notificationService;
    }

    public AuthorizationService getAuthorizationService() {
        return authorizationService;
    }

    public DigitalAccountService getDigitalAccountService() {
        return digitalAccountService;
    }

    private PixService pixService = new PixService();
    private DataService dataService = new DataService();
    private SubscriptionService subscriptionService = new SubscriptionService();
    private PlanService planService = new PlanService();
    private ChargeService chargeService = new ChargeService();
    private PicpayService picpayService = new PicpayService();
    private BalanceService balanceService = new BalanceService();
    private PaymentService paymentService = new PaymentService();
    private DocumentService documentService = new DocumentService();
    private TransferService transferService = new TransferService();
    private CreditCardService creditCardService = new CreditCardService();
    private BillPaymentService billPaymentService = new BillPaymentService();
    private CredentialsService credentialsService = new CredentialsService();
    private NotificationService notificationService = new NotificationService();
    private AuthorizationService authorizationService = new AuthorizationService();
    private DigitalAccountService digitalAccountService = new DigitalAccountService();
    
}