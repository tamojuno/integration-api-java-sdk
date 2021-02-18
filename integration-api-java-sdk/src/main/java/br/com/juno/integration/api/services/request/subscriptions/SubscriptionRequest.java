package br.com.juno.integration.api.services.request.subscriptions;

import br.com.juno.integration.api.services.request.BaseTemplatedRequest;

public final class SubscriptionRequest extends BaseTemplatedRequest<String> {

	private static final long serialVersionUID = -1292397181059830743L;

	public SubscriptionRequest(String resourceToken, String id) {
		super(resourceToken, id);
	}
	
	public SubscriptionRequest(String id) {
		super(id);
	}
}
