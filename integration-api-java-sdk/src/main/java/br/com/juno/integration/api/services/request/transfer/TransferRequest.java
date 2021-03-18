package br.com.juno.integration.api.services.request.transfer;

import br.com.juno.integration.api.model.BankAccount;
import br.com.juno.integration.api.services.JunoApiManager;
import br.com.juno.integration.api.services.request.BaseResourceRequest;

public final class TransferRequest extends BaseResourceRequest {

    private static final long serialVersionUID = 4016895458768370638L;

    private final String type;
    private final String name;
    private final String document;
    private final String amount;
    private final BankAccount bankAccount;

    public TransferRequest(String type, String name, String document, String amount, BankAccount bankAccount) {
        this(JunoApiManager.config().getResourceToken(), type, name, document, amount, bankAccount);
    }

    public TransferRequest(String resourceToken, String type, String name, String document, String amount, BankAccount bankAccount) {
        super(resourceToken);
        this.type = type;
        this.name = name;
        this.document = document;
        this.amount = amount;
        this.bankAccount = bankAccount;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public String getDocument() {
        return document;
    }

    public String getAmount() {
        return amount;
    }

    public BankAccount getBankAccount() {
        return bankAccount;
    }

}
