package br.com.juno.integration.api.services.request.creditcard;

import org.apache.commons.lang3.StringUtils;

import br.com.juno.integration.api.model.CreditCard;
import br.com.juno.integration.api.services.request.BaseRequest;

public class CreditCardTokenizationRequest extends BaseRequest {

    private static final long serialVersionUID = -2600515235790901969L;

    private CreditCard creditCard;
    private String creditCardHash;

    public CreditCardTokenizationRequest(CreditCard creditCard) {
        this.creditCard = creditCard;
    }

    public CreditCardTokenizationRequest(String creditCardHash) {
        this.creditCardHash = creditCardHash;
    }

    public CreditCard getCreditCard() {
        return creditCard;
    }

    public String getCreditCardHash() {
        return creditCardHash;
    }

    public boolean hasCreditCardHash() {
        return StringUtils.isNotBlank(creditCardHash);
    }

    public boolean hasCreditCard() {
        return creditCard != null;
    }

}
