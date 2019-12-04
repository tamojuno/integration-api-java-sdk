package br.com.juno.integration.api.services.request.notification.webhook;

import br.com.juno.integration.api.services.request.BaseTemplatedRequest;

public final class WebhookFindRequest extends BaseTemplatedRequest<String> {

    private static final long serialVersionUID = 2955775000707665606L;

    public WebhookFindRequest(String resourceToken, String id) {
        super(resourceToken, id);
    }

    public WebhookFindRequest(String id) {
        super(id);
    }

}
