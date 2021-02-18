package br.com.juno.integration.api.services.request.subscriptions;

import br.com.juno.integration.api.services.JunoApiManager;
import br.com.juno.integration.api.services.request.BaseRequest;

public final class SubscriptionListRequest extends BaseRequest {
	
	private static final long serialVersionUID = 1157042804287419829L;

	public SubscriptionListRequest() {
		this(JunoApiManager.config().getResourceToken());
	}
	
	public SubscriptionListRequest(String resourceToken) {
		setResourceToken(resourceToken);
	}
}
