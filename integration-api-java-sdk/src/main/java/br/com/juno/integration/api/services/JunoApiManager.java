package br.com.juno.integration.api.services;

public final class JunoApiManager {

    public static final String CONTENT_TYPE_HEADER = "Content-type";
    public static final String CONTENT_ENCODING_HEADER = "Content-encoding";

    public static final String X_RESOURCE_TOKEN = "X-Resource-Token";
    public static final String X_API_VERSION = "X-API-Version";
    public static final String X_API_VERSION_VALUE = "2";
    public static final String X_IDEMPOTENCY_KEY = "X-Idempotency-Key";

    private static final JunoApiConfig config = new JunoApiConfig();
    private static final JunoApiResources resources = new JunoApiResources();

    private JunoApiManager() {
        // Private Constructor
    }

    public static JunoApiConfig config() {
        return config;
    }

    public static PixService getPixService() {
        return resources.getPixService();
    }

    public static DataService getDataService() {
        return resources.getDataService();
    }

    public static SubscriptionService getSubscriptionService() {
        return resources.getSubscriptionService();
    }

    public static PlanService getPlanService() {
        return resources.getPlanService();
    }

    public static ChargeService getChargeService() {
        return resources.getChargeService();
    }

    public static PicpayService getPicpayService() {
        return resources.getPicpayService();
    }

    public static BalanceService getBalanceService() {
        return resources.getBalanceService();
    }

    public static PaymentService getPaymentService() {
        return resources.getPaymentService();
    }

    public static DocumentService getDocumentService() {
        return resources.getDocumentService();
    }

    public static TransferService getTransferService() {
        return resources.getTransferService();
    }

    public static CreditCardService getCreditCardService() {
        return resources.getCreditCardService();
    }

    public static BillPaymentService getBillPaymentService() {
        return resources.getBillPaymentService();
    }

    public static CredentialsService getCredentialsService() {
        return resources.getCredentialsService();
    }

    public static NotificationService getNotificationService() {
        return resources.getNotificationService();
    }

    public static AuthorizationService getAuthorizationService() {
        return resources.getAuthorizationService();
    }

    public static DigitalAccountService getDigitalAccountService() {
        return resources.getDigitalAccountService();
    }
}
