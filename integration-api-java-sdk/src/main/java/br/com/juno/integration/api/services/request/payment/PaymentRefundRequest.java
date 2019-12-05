package br.com.juno.integration.api.services.request.payment;

import br.com.juno.integration.api.services.request.BaseTemplatedRequest;

public class PaymentRefundRequest extends BaseTemplatedRequest<String> {

    private static final long serialVersionUID = -190621371447556540L;

    public PaymentRefundRequest(String resourceToken, String id) {
        super(resourceToken, id);
    }

    public PaymentRefundRequest(String id) {
        super(id);
    }

}
