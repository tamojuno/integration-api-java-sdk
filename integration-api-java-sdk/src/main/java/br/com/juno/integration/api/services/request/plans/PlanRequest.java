package br.com.juno.integration.api.services.request.plans;

import br.com.juno.integration.api.services.request.BaseTemplatedRequest;

public final class PlanRequest extends BaseTemplatedRequest<String> {

    private static final long serialVersionUID = 6849985550047601608L;

    public PlanRequest(String resourceToken, String id) {
        super(resourceToken, id);
    }

    public PlanRequest(String id) {
        super(id);
    }

}
