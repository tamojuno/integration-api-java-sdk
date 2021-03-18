package br.com.juno.integration.api.services.request.digitalaccounts;

import br.com.juno.integration.api.services.request.BaseResourceRequest;

public final class DigitalAccountRequest extends BaseResourceRequest {

    private static final long serialVersionUID = 1844479894836844315L;

    public DigitalAccountRequest() {
        super();
    }

    public DigitalAccountRequest(String resourceToken) {
        super(resourceToken);
    }
}
