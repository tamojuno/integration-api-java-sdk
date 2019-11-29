package br.com.juno.integration.api.model;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class TokenizedCreditCard extends BaseModel {

    private static final long serialVersionUID = 9066251764407445631L;

    private String creditCardId;
    private String last4CardNumber;
    private String expirationMonth;
    private String expirationYear;

    protected TokenizedCreditCard() {
        // NTD
    }

    public String getCreditCardId() {
        return creditCardId;
    }

    public String getLast4CardNumber() {
        return last4CardNumber;
    }

    public String getExpirationMonth() {
        return expirationMonth;
    }

    public String getExpirationYear() {
        return expirationYear;
    }

    @Override
    public String toString() {
        ToStringBuilder builder = new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE);
        builder.append(creditCardId);
        builder.append(last4CardNumber);
        builder.append(expirationMonth);
        builder.append(expirationYear);
        return builder.toString();
    }

}
