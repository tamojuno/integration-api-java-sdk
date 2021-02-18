package br.com.juno.integration.api.services.request.plans;

import br.com.juno.integration.api.services.JunoApiManager;
import br.com.juno.integration.api.services.request.BaseRequest;

public final class PlanListRequest extends BaseRequest {

	private static final long serialVersionUID = 631262728656530571L;

	public PlanListRequest() {
		this(JunoApiManager.config().getResourceToken());
	}
	
	public PlanListRequest(String resourceToken) {
		setResourceToken(resourceToken);
	}
}
