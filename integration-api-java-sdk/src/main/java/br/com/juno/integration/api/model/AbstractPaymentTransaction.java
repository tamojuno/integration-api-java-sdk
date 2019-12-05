package br.com.juno.integration.api.model;

public abstract class AbstractPaymentTransaction extends BaseModel {

    private static final long serialVersionUID = 2744803271932442751L;

    protected String transactionId;
    protected int installments;

    protected AbstractPaymentTransaction() {
        // NTD
    }

    public String getTransactionId() {
        return transactionId;
    }

    public int getInstallments() {
        return installments;
    }

}
