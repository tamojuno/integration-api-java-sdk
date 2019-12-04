package br.com.juno.integration.api.services.request.creditcard;

import org.apache.commons.lang3.StringUtils;

import br.com.juno.integration.api.services.request.BaseRequest;

public final class CreditCardTokenizationRequest extends BaseRequest {

    private static final long serialVersionUID = -2600515235790901969L;

    private String creditCardHash;

    public CreditCardTokenizationRequest(String creditCardHash) {
        this.creditCardHash = creditCardHash;
    }

    public String getCreditCardHash() {
        return creditCardHash;
    }

    public boolean hasCreditCardHash() {
        return StringUtils.isNotBlank(creditCardHash);
    }

}
