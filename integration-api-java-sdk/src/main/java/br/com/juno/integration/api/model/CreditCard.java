package br.com.juno.integration.api.model;

public class CreditCard extends BaseModel {

    private static final long serialVersionUID = -3308153331129389784L;

    private final String cardNumber;
    private final String holderName;
    private final String securityCode;
    private final String expirationMonth;
    private final String expirationYear;

    public CreditCard(String cardNumber, String holderName, String securityCode, String expirationMonth, String expirationYear) {
        this.cardNumber = cardNumber;
        this.holderName = holderName;
        this.securityCode = securityCode;
        this.expirationMonth = expirationMonth;
        this.expirationYear = expirationYear;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public String getHolderName() {
        return holderName;
    }

    public String getSecurityCode() {
        return securityCode;
    }

    public String getExpirationMonth() {
        return expirationMonth;
    }

    public String getExpirationYear() {
        return expirationYear;
    }

}
