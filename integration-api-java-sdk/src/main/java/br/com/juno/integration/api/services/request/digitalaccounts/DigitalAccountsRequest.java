package br.com.juno.integration.api.services.request.digitalaccounts;

import br.com.juno.integration.api.services.request.BaseResourceRequest;

public final class DigitalAccountsRequest extends BaseResourceRequest {

	private static final long serialVersionUID = 1844479894836844315L;

	public DigitalAccountsRequest() {
		super();
	}
	
	public DigitalAccountsRequest(String resourceToken) {
		super(resourceToken);
	}
}
